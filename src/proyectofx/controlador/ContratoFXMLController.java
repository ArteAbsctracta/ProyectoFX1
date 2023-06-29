/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofx.controlador;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import proyectofx.api.request.Requests;
import proyectofx.modelo.pojos.Contratos;

/**
 * FXML Controller class
 *
 * @author otreb
 */
public class ContratoFXMLController implements Initializable {

    @FXML
    private TableView<Contratos> tbl_Contrato;
    @FXML
    private TableColumn<Contratos, Integer> tcl_ID;
    @FXML
    private TableColumn<Contratos, Integer> tcl_Usuario;
    @FXML
    private TableColumn<Contratos, Integer> tcl_Estatus;
    @FXML
    private TableColumn<Contratos, String> tcl_FCreacion;
    @FXML
    private TableColumn<Contratos, String> tcl_FActualizacion;
    @FXML
    private TableColumn<Contratos, String> tcl_FLimite;
    @FXML
    private Button btn_registrar;
    @FXML
    private Button btn_Editar;
    @FXML
    private Button btn_activar;
    @FXML
    private Button btn_desactivar;
    @FXML
    private TextField txt_busquedaContrato;
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
        tbl_Contrato.getItems().clear();
        
        respuesta = Requests.get("/Contratos/getAllContratos/");
        Gson gson = new Gson();
        
        TypeToken<List<Contratos>> token = new TypeToken<List<Contratos>>(){   
        };

        List<Contratos> listaContratos = gson.fromJson(respuesta, token.getType());
        
        
        tcl_ID.setCellValueFactory(new PropertyValueFactory<>("idContrato"));
        tcl_Usuario.setCellValueFactory(new PropertyValueFactory<>("nombreUsuario"));
        tcl_Estatus.setCellValueFactory(new PropertyValueFactory<>("estatusContrato"));
        tcl_FCreacion.setCellValueFactory(new PropertyValueFactory<>("fechaCreacion"));
        tcl_FActualizacion.setCellValueFactory(new PropertyValueFactory<>("fechaActualizacion"));
        tcl_FLimite.setCellValueFactory(new PropertyValueFactory<>("fechaLimite"));
        
        listaContratos.forEach(e ->{
            tbl_Contrato.getItems().add(e);
        });
    }

    @FXML
    private void nuevoContrato(ActionEvent event) {
        try {
            Stage stage = new Stage();   
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/proyectofx/gui/vista/RegistrarContratoFXML.fxml")); 
            
            Parent formUsuarioRegistrar = loader.load(); 
            
            RegistrarContratoFXMLController ctrl = loader.getController();   
               
            Scene scene = new Scene(formUsuarioRegistrar);  
            stage.setScene(scene);
            stage.setTitle("Registrar");
            stage.setResizable(false);
            stage.showAndWait();
            this.cargarTabla();
        } catch (IOException ex) {
            Logger.getLogger(UsuariosFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
