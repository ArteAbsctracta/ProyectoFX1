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
import java.util.HashMap;
import java.util.LinkedHashMap;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.json.JSONException;
import org.json.JSONObject;
import proyectofx.api.request.Requests;
import proyectofx.modelo.pojos.Prendas;
/**
 * FXML Controller class
 *
 * @author otreb
 */
public class PrendasFXMLController implements Initializable {

    @FXML
    private TableView<Prendas> tbl_Prendas;
    @FXML
    private TableColumn<Prendas, Integer> tcl_Id;
    @FXML
    private TableColumn<Prendas, Integer> tcl_Usuario;
    @FXML
    private TableColumn<Prendas, String> tcl_Categoria;
    @FXML
    private TableColumn<Prendas, Integer> tcl_NPiezas;
    @FXML
    private TableColumn<Prendas, String> tcl_Serie;
    @FXML
    private TableColumn<Prendas, String> tcl_Modelo;
    @FXML
    private TableColumn<Prendas, String> tcl_SubCategoria;
    @FXML
    private TableColumn<Prendas, Boolean> tcl_Metal;
    @FXML
    private TableColumn<Prendas, String> tcl_Peso;
    @FXML
    private TableColumn<Prendas, String> tcl_Kilataje;
    @FXML
    private Button btn_registrar;
    @FXML
    private Button btn_Editar;
    @FXML
    private Button btn_activar;
    @FXML
    private Button btn_desactivar;
    @FXML
    private TextField txt_busquedaCliente;
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
        tbl_Prendas.getItems().clear();
        
        respuesta = Requests.get("/Prendas/getAllPrendas/");
        Gson gson = new Gson();
        
        TypeToken<List<Prendas>> token = new TypeToken<List<Prendas>>(){   
        };

        List<Prendas> listaContratos = gson.fromJson(respuesta, token.getType());
        
        
        tcl_Id.setCellValueFactory(new PropertyValueFactory<>("idPrenda"));
        tcl_Usuario.setCellValueFactory(new PropertyValueFactory<>("nombreUsuario"));
        tcl_Categoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        tcl_NPiezas.setCellValueFactory(new PropertyValueFactory<>("numPiezas"));
        tcl_Serie.setCellValueFactory(new PropertyValueFactory<>("serie"));
        tcl_Modelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        tcl_SubCategoria.setCellValueFactory(new PropertyValueFactory<>("subcategoria"));
        tcl_Metal.setCellValueFactory(new PropertyValueFactory<>("esMetal"));
        tcl_Peso.setCellValueFactory(new PropertyValueFactory<>("peso"));
        tcl_Kilataje.setCellValueFactory(new PropertyValueFactory<>("kilataje"));
        
        listaContratos.forEach(e ->{
            tbl_Prendas.getItems().add(e);
        });
    }

    @FXML
    private void nuevaPrenda(ActionEvent event) {
        try {
            Stage stage = new Stage();   
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/proyectofx/gui/vista/RegistrarPrendaFXML.fxml")); 
            
            Parent formUsuarioRegistrar = loader.load(); 
            
            RegistrarPrendaFXMLController ctrl = loader.getController();   
               
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
    private void editarPrenda(ActionEvent event) {
        Prendas prendaSeleccionada = tbl_Prendas.getSelectionModel().getSelectedItem();
        System.out.println(prendaSeleccionada.getKilataje());
        
        try {
            Stage stage = new Stage();   
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/proyectofx/gui/vista/RegistrarPrendaFXML.fxml")); 
            
            Parent formUsuarioRegistrar = loader.load(); 
            
            RegistrarPrendaFXMLController ctrl = loader.getController();   
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
    private void buscar(ActionEvent event) {
    }

    @FXML
    private void limpiar(ActionEvent event) {
    }
    Prendas prenda;
    @FXML
    private void activarPrenda(ActionEvent event) {
        if(tbl_Prendas.getSelectionModel().getSelectedItem() != null){
            prenda = tbl_Prendas.getSelectionModel().getSelectedItem();
        }
        
        if(prenda != null){
            
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmación");
            alert.setHeaderText(null);
            alert.setContentText("Seguro que desea activar la prenda?...");
            //alert.showAndWait();
            
            alert.showAndWait().ifPresent((ButtonType response) -> {
                if (response == ButtonType.OK) {
                    
                    try {
                        HashMap<String, Object> params = new LinkedHashMap<>();
                        
                        String respuesta = Requests.get("/Prendas/actualizarEstatus/"+prenda.getIdPrenda());
                        
                        String estado = prenda.getEstatusPrenda();
                        if("ACTIVO".equals(estado)){
                            
                            JSONObject dataJson = new JSONObject(respuesta);
                            
                            if ((Boolean) dataJson.get("error") == false) {

                                Alert alertC = new Alert(Alert.AlertType.INFORMATION);
                                alertC.setTitle("Informativo");
                                alertC.setHeaderText(null);
                                alertC.setContentText(dataJson.getString("mensaje"));
                                alertC.showAndWait();
                                
                                this.cargarTabla();

                            } else {
                                Alert alertN = new Alert(Alert.AlertType.INFORMATION);
                                alertN.setTitle("Informativo");
                                alertN.setHeaderText(null);
                                alertN.setContentText(dataJson.getString("mensaje"));
                                alertN.showAndWait();
                                
                                this.cargarTabla();
                            }
                        } else{
                            Alert alertInactivo = new Alert(Alert.AlertType.INFORMATION);
                            alertInactivo.setTitle("Informativo");
                            alertInactivo.setHeaderText(null);
                            alertInactivo.setContentText("La Prenda ya esta Activa...");
                            alertInactivo.showAndWait();
                        
                            this.cargarTabla();
                        }                      
                    } catch (JSONException ex) {
                        Logger.getLogger(UsuariosFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (response == ButtonType.CANCEL) {
                    
                    this.cargarTabla();
                }
            });
        }else{
            Alert alertI = new Alert(Alert.AlertType.WARNING);
            alertI.setTitle("Advertencia");
            alertI.setHeaderText(null);
            alertI.setContentText("Debe seleccionar una Prenda...");
            alertI.showAndWait();
        }
    }
    
    
    @FXML
    private void desactivarPrenda(ActionEvent event) {
        if(tbl_Prendas.getSelectionModel().getSelectedItem() != null){
            prenda = tbl_Prendas.getSelectionModel().getSelectedItem();
        }
        
        if(prenda != null){
            
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmación");
            alert.setHeaderText(null);
            alert.setContentText("Seguro que desea desactivar la prenda?...");
            //alert.showAndWait();
            
            alert.showAndWait().ifPresent((ButtonType response) -> {
                if (response == ButtonType.OK) {
                    
                    try {
                        HashMap<String, Object> params = new LinkedHashMap<>();
                        
                        String respuesta = Requests.get("/Prendas/eliminarPrenda/"+prenda.getIdPrenda());
                        
                        String estado = prenda.getEstatusPrenda();
                        if("INACTIVO".equals(estado)){
                            
                            JSONObject dataJson = new JSONObject(respuesta);
                            
                            if ((Boolean) dataJson.get("error") == false) {

                                Alert alertC = new Alert(Alert.AlertType.INFORMATION);
                                alertC.setTitle("Informativo");
                                alertC.setHeaderText(null);
                                alertC.setContentText(dataJson.getString("mensaje"));
                                alertC.showAndWait();
                                
                                this.cargarTabla();

                            } else {
                                Alert alertN = new Alert(Alert.AlertType.INFORMATION);
                                alertN.setTitle("Informativo");
                                alertN.setHeaderText(null);
                                alertN.setContentText(dataJson.getString("mensaje"));
                                alertN.showAndWait();
                                
                                this.cargarTabla();
                            }
                        } else{
                            Alert alertInactivo = new Alert(Alert.AlertType.INFORMATION);
                            alertInactivo.setTitle("Informativo");
                            alertInactivo.setHeaderText(null);
                            alertInactivo.setContentText("La Prenda ya esta Inactivo...");
                            alertInactivo.showAndWait();
                        
                            this.cargarTabla();
                        }                      
                    } catch (JSONException ex) {
                        Logger.getLogger(UsuariosFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (response == ButtonType.CANCEL) {
                    
                    this.cargarTabla();
                }
            });
        }else{
            Alert alertI = new Alert(Alert.AlertType.WARNING);
            alertI.setTitle("Advertencia");
            alertI.setHeaderText(null);
            alertI.setContentText("Debe seleccionar una Prenda...");
            alertI.showAndWait();
        }
    }
}
