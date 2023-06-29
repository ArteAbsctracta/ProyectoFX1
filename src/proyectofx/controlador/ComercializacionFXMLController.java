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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import proyectofx.api.request.Requests;
import proyectofx.modelo.pojos.Comercializacion;

/**
 * FXML Controller class
 *
 * @author otreb
 */
public class ComercializacionFXMLController implements Initializable {

    @FXML
    private TableView<Comercializacion> tbl_Empeno;
    @FXML
    private TableColumn<Comercializacion, Integer> tcl_ID;
    @FXML
    private TableColumn<Comercializacion, String> tcl_Usuario;
    @FXML
    private TableColumn<Comercializacion, String> tcl_FCreacion;
    @FXML
    private TableColumn<Comercializacion, String> tcl_FFinalBusqueda;
    @FXML
    private TableColumn<Comercializacion, String> tcl_FInicioBusqueda;
    @FXML
    private TableColumn<Comercializacion, String> tcl_Tipo;
    @FXML
    private TableColumn<Comercializacion, String> tcl_Observaciones;
    @FXML
    private Button btn_registrar;
    @FXML
    private Button btn_Editar;
    @FXML
    private Button btn_activar;
    @FXML
    private Button btn_desactivar;
    @FXML
    private TextField txt_busquedaEmpeno;
    @FXML
    private Button btn_buscar;
    @FXML
    private Button btn_limpiar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.cargarTabla();
    }    
    
    public void cargarTabla(){
        String respuesta = "";
        tbl_Empeno.getItems().clear();
        
        respuesta = Requests.get("/Comercializacion/getAllComercializacion/");
        Gson gson = new Gson();
        
        TypeToken<List<Comercializacion>> token = new TypeToken<List<Comercializacion>>(){   
        };

        List<Comercializacion> listaContratos = gson.fromJson(respuesta, token.getType());
        
        
        tcl_ID.setCellValueFactory(new PropertyValueFactory<>("idComercializacion"));
        tcl_Usuario.setCellValueFactory(new PropertyValueFactory<>("idUsuario"));
        tcl_FCreacion.setCellValueFactory(new PropertyValueFactory<>("fechaCreacion"));
        tcl_FFinalBusqueda.setCellValueFactory(new PropertyValueFactory<>("fechaFinalBusqueda"));
        tcl_FInicioBusqueda.setCellValueFactory(new PropertyValueFactory<>("fechaInicioBusqueda"));
        tcl_Tipo.setCellValueFactory(new PropertyValueFactory<>("tipoComercializacion"));
        tcl_Observaciones.setCellValueFactory(new PropertyValueFactory<>("observaciones"));
        
        listaContratos.forEach(e ->{
            tbl_Empeno.getItems().add(e);
        });
    }
}
