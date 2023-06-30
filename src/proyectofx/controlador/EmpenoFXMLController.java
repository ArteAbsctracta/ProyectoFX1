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
import java.util.Date;
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
import proyectofx.modelo.pojos.Empeño;

/**
 * FXML Controller class
 *
 * @author otreb
 */
public class EmpenoFXMLController implements Initializable {

    @FXML
    private TableView<Empeño> tbl_Empeno;
    @FXML
    private TableColumn<Empeño, Integer> tcl_ID;
    @FXML
    private TableColumn<Empeño, Date> tcl_FCreacion;
    @FXML
    private TableColumn<Empeño, Date> tcl_FActualizacion;
    @FXML
    private TableColumn<Empeño, Integer> tcl_Usuario;
    @FXML
    private TableColumn<Empeño, Integer> tcl_Periodos;
    @FXML
    private TableColumn<Empeño, Double> tcl_Comercializacion;
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
        
        respuesta = Requests.get("/Empenos/getAllEmpenos/");
        Gson gson = new Gson();
        
        TypeToken<List<Empeño>> token = new TypeToken<List<Empeño>>(){   
        };

        List<Empeño> listaContratos = gson.fromJson(respuesta, token.getType());
        
        
        tcl_ID.setCellValueFactory(new PropertyValueFactory<>("idEmpeño"));
        tcl_Usuario.setCellValueFactory(new PropertyValueFactory<>("nombreUsuario"));
        tcl_FCreacion.setCellValueFactory(new PropertyValueFactory<>("fechaCreacion"));
        tcl_FActualizacion.setCellValueFactory(new PropertyValueFactory<>("fechaActualizacion"));
        tcl_Periodos.setCellValueFactory(new PropertyValueFactory<>("numPeriodos"));
        tcl_Comercializacion.setCellValueFactory(new PropertyValueFactory<>("tasaComercializacion"));
        
        listaContratos.forEach(e ->{
            tbl_Empeno.getItems().add(e);
        });
    }

    @FXML
    private void nuevoEmpeno(ActionEvent event) {
        try {
            Stage stage = new Stage();   
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/proyectofx/gui/vista/RegistrarEmpeñoFXML.fxml")); 
            
            Parent formUsuarioRegistrar = loader.load(); 
            
            RegistrarEmpeñoFXMLController ctrl = loader.getController();   
               
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

    @FXML
    private void editarEmpeño(ActionEvent event) {
        Empeño prendaSeleccionada = tbl_Empeno.getSelectionModel().getSelectedItem();        
        try {
            Stage stage = new Stage();   
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/proyectofx/gui/vista/RegistrarEmpeñoFXML.fxml")); 
            
            Parent formUsuarioRegistrar = loader.load(); 
            
            RegistrarEmpeñoFXMLController ctrl = loader.getController();   
            ctrl.setData(prendaSeleccionada);
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

    @FXML
    private void activarEmpeño(ActionEvent event) {
    }

    @FXML
    private void desactivarEmpeño(ActionEvent event) {
    }
    
    
}
