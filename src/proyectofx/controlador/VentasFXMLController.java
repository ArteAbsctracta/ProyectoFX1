/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofx.controlador;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import proyectofx.api.request.Requests;
import proyectofx.modelo.pojos.Usuarios;
import proyectofx.modelo.pojos.VentasRemates;

/**
 * FXML Controller class
 *
 * @author afs30
 */
public class VentasFXMLController implements Initializable {

    @FXML
    private Button btn_buscarVentas;
    @FXML
    private Button btn_limpiarVenta;
    @FXML
    private TextArea txt_buscarVenta;
    @FXML
    private Button btn_editarVenta;
    @FXML
    private Button btn_activarVenta;
    @FXML
    private Button btn_desactivarVenta;
    @FXML
    private Button btn_registrarVenta;
    @FXML
    private Button btn_detallesVentas;
    @FXML
    private MenuBar mb_principal;
    @FXML
    private Menu mi_empeño;
    @FXML
    private MenuItem mi_contratos;
    @FXML
    private MenuItem mi_prendas;
    @FXML
    private MenuItem mi_comercializacion;
    @FXML
    private Menu mi_clientes;
    @FXML
    private Menu mi_ventas;
    @FXML
    private Menu mi_usuarios;
    @FXML
    private Menu mi_catalogo;
    @FXML
    private Menu mi_categorias;
    @FXML
    private Menu mi_movimientos;
    @FXML
    private MenuItem mi_ingresos;
    @FXML
    private MenuItem mi_egresos;
    @FXML
    private Menu mi_sesion;
    @FXML
    private MenuItem mi_cerrar;
    @FXML
    private MenuItem mi_sistemaCatalogos;
    @FXML
    private MenuItem mi_prendaCatalogos;
    @FXML
    private MenuItem mi_prendaCategorias;
    @FXML
    private MenuItem mi_sistemaCategorias;
    @FXML
    private MenuItem mi_empeno;
    @FXML
    private MenuItem mi_cliente;
    @FXML
    private MenuItem mi_venta;
    @FXML
    private MenuItem mi_usuario;
    @FXML
    private TableView<VentasRemates> tbl_ventas;
    @FXML
    private TableColumn<VentasRemates, String> tcl_Subtotal;
    @FXML
    private TableColumn<VentasRemates, String> tcl_Ivaventa;
    @FXML
    private TableColumn<VentasRemates, String> tcl_totalVenta;
    @FXML
    private TableColumn<VentasRemates, Integer> tcl_idContrato;
    @FXML
    private TableColumn<VentasRemates, String> tcl_estatusVenta;
    @FXML
    private TableColumn<VentasRemates, Integer> tcl_idCliente;
    @FXML
    private TableColumn<VentasRemates, Integer> tcl_idCreador;
    @FXML
    private TableColumn<VentasRemates, String> tcl_fechaCreacion;
    @FXML
    private TableColumn<VentasRemates, String> tcl_totalArticulos;
    @FXML
    private TableColumn<VentasRemates, String> tcl_fechaCancelacion;
    @FXML
    private TableColumn<VentasRemates, Integer> tcl_idUsuario;
    @FXML
    private TableColumn<VentasRemates, String> tcl_tipoVenta;

    /**
     * Initializes the controller class.
     */
    
    Usuarios usuario = null;
    VentasRemates ventas= null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // this.cargarTabla();
    }    
    
        public void setData(Usuarios usuario){       
        this.usuario = usuario;
    }
    
        
        private void buscarVenta(ActionEvent event) {                         
        String buscar = this.txt_buscarVenta.getText();
        tbl_ventas.getItems().clear();
		List<VentasRemates> listaventas = null;
        String respuesta = "";

        respuesta = Requests.get("/Ventas/buscarVentas/"+buscar);
        Gson gson = new Gson();

        TypeToken<List<VentasRemates>> token = new TypeToken<List<VentasRemates>>() {
        };
        listaventas = gson.fromJson(respuesta, token.getType());
        
        tcl_Subtotal.setCellValueFactory(new PropertyValueFactory<>("subtotal"));
        tcl_Ivaventa.setCellValueFactory(new PropertyValueFactory<>("ivaVenta"));
        tcl_totalVenta.setCellValueFactory(new PropertyValueFactory<>("totalVenta"));
        tcl_idContrato.setCellValueFactory(new PropertyValueFactory<>("idContrato"));
        tcl_estatusVenta.setCellValueFactory(new PropertyValueFactory<>("estatusVenta"));
        tcl_idCliente.setCellValueFactory(new PropertyValueFactory<>("idCliente"));
        tcl_idCreador.setCellValueFactory(new PropertyValueFactory<>("idCreador"));
        tcl_fechaCreacion.setCellValueFactory(new PropertyValueFactory<>("fechaCreacion"));
        tcl_totalArticulos.setCellValueFactory(new PropertyValueFactory<>("totalArticulos"));
        tcl_fechaCancelacion.setCellValueFactory(new PropertyValueFactory<>("fechaCancelacion"));
        tcl_idUsuario.setCellValueFactory(new PropertyValueFactory<>("idUsuario"));
        tcl_tipoVenta.setCellValueFactory(new PropertyValueFactory<>("tipoVenta"));
        
        listaventas.forEach(e ->{
            tbl_ventas.getItems().add(e);
        });
                 
    }
    
        @FXML
    private void limpiarUsuario(ActionEvent event) {
        txt_buscarVenta.setText("");
        this.cargarTabla();
    }
        
    public void cargarTabla(){
        String respuesta = "";
        tbl_ventas.getItems().clear();
        
        respuesta = Requests.get("/Ventas/getAllVentas/");
        Gson gson = new Gson();
        
        TypeToken<List<VentasRemates>> token = new TypeToken<List<VentasRemates>>(){   
        };

        List<VentasRemates> listaventas = gson.fromJson(respuesta, token.getType());
        
        
        tcl_Subtotal.setCellValueFactory(new PropertyValueFactory<>("subtotal"));
        tcl_Ivaventa.setCellValueFactory(new PropertyValueFactory<>("ivaVenta"));
        tcl_totalVenta.setCellValueFactory(new PropertyValueFactory<>("totalVenta"));
        tcl_idContrato.setCellValueFactory(new PropertyValueFactory<>("idContrato"));
        tcl_estatusVenta.setCellValueFactory(new PropertyValueFactory<>("estatusVenta"));
        tcl_idCliente.setCellValueFactory(new PropertyValueFactory<>("idCliente"));
        tcl_idCreador.setCellValueFactory(new PropertyValueFactory<>("idCreador"));
        tcl_fechaCreacion.setCellValueFactory(new PropertyValueFactory<>("fechaCreacion"));
        tcl_totalArticulos.setCellValueFactory(new PropertyValueFactory<>("totalArticulos"));
        tcl_fechaCancelacion.setCellValueFactory(new PropertyValueFactory<>("fechaCancelacion"));
        tcl_idUsuario.setCellValueFactory(new PropertyValueFactory<>("idUsuario"));
        tcl_tipoVenta.setCellValueFactory(new PropertyValueFactory<>("tipoVenta"));
        listaventas.forEach(e ->{
            tbl_ventas.getItems().add(e);
        });
    }

    @FXML
    private void clickTable(MouseEvent event) {
        String respuesta ="";
        if(tbl_ventas.getSelectionModel().getSelectedItem() != null){
            ventas = tbl_ventas.getSelectionModel().getSelectedItem();
        }
    }
}
