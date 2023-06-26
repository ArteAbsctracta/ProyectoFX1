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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.json.JSONException;
import org.json.JSONObject;
import proyectofx.api.request.Requests;
import proyectofx.modelo.pojos.Usuarios;

/**
 * FXML Controller class
 *
 * @author afs30
 */
public class UsuariosFXMLController implements Initializable {

   @FXML
    private TextField txt_buscarUsuario;
    @FXML
    private Button btn_buscarUsuario;
    @FXML
    private Button btn_limpiarUsuario;
    @FXML
    private Button btn_nuevaUsuario;
    @FXML
    private Button btn_editarUsuario;
    @FXML
    private Button btn_activarUsuario;
    @FXML
    private Button btn_desactivarUsuario;
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
    private TableView<Usuarios> tbl_usuario;
    @FXML
    private TableColumn<Usuarios, String> tcl_nombreUsuario;
    @FXML
    private TableColumn<Usuarios, String> tcl_apellidoPaterno;
    @FXML
    private TableColumn<Usuarios, String> tcl_apellidoMaterno;
    @FXML
    private TableColumn<Usuarios, String> tcl_usuarioUsuario;
    @FXML
    private TableColumn<Usuarios, String> tcl_password;
    @FXML
    private TableColumn<Usuarios, String> tcl_estatusUsuario;
    @FXML
    private TableColumn<Usuarios, Integer> tcl_rolUsuario;
    @FXML
    private TableColumn<Usuarios, String> tcl_curp;

    Usuarios usuario = null;
    Usuarios nombreUsuario=null;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
       this.cargarTabla();
    }    

    public void setData(Usuarios usuario){       
        this.usuario = usuario;
    }
    @FXML
    private void buscarUsuario(ActionEvent event) {                         
        String buscar = this.txt_buscarUsuario.getText();
        tbl_usuario.getItems().clear();
		List<Usuarios> listaUsuario = null;
        String respuesta = "";

        respuesta = Requests.get("/Usuarios/buscarUsuario/"+buscar);
        Gson gson = new Gson();

        TypeToken<List<Usuarios>> token = new TypeToken<List<Usuarios>>() {
        };
        listaUsuario = gson.fromJson(respuesta, token.getType());
        
        tcl_nombreUsuario.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tcl_apellidoPaterno.setCellValueFactory(new PropertyValueFactory<>("apellidoPaterno"));
        tcl_apellidoMaterno.setCellValueFactory(new PropertyValueFactory<>("apellidoMaterno"));
        tcl_usuarioUsuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
        tcl_password.setCellValueFactory(new PropertyValueFactory<>("password"));
        tcl_estatusUsuario.setCellValueFactory(new PropertyValueFactory<>("estatus"));
        tcl_rolUsuario.setCellValueFactory(new PropertyValueFactory<>("idRol"));
        tcl_curp.setCellValueFactory(new PropertyValueFactory<>("curp"));
        
        listaUsuario.forEach(e ->{
            tbl_usuario.getItems().add(e);
        });
                 
    }

    @FXML
    private void limpiarUsuario(ActionEvent event) {
        txt_buscarUsuario.setText("");
        this.cargarTabla();
    }

    @FXML
    private void nuevaUsuario(ActionEvent event) {
        try {
            Stage stage = new Stage();   
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/proyectofx/gui/vista/RegistrarUsuarioFXML.fxml")); 
            
            Parent formUsuarioRegistrar = loader.load(); 
            
            RegistrarUsuarioFXMLController ctrl = loader.getController();   
            ctrl.setData(null);
               
            Scene scene = new Scene(formUsuarioRegistrar);  
            stage.setScene(scene);
            stage.setTitle("Registrar");
            stage.setResizable(false);
            stage.showAndWait();
            this.cargarTabla();
            this.usuario = null;
        } catch (IOException ex) {
            Logger.getLogger(UsuariosFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void editarUsuario(ActionEvent event) {
        if(this.usuario != null){
            try {
                Stage stage = new Stage();
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/proyectofx/gui/vista/EditarUsuarioFXML.fxml"));
                
                Parent formUsuarioEditar = loader.load();  
                
                EditarUsuarioFXMLController ctrl = loader.getController();
                ctrl.setData(this.usuario,false);
                
                Scene scene = new Scene(formUsuarioEditar);
                stage.setScene(scene);
                stage.setTitle("Editar");
                stage.setResizable(false);
                stage.showAndWait();
                this.cargarTabla();
                this.usuario = null;
            } catch (IOException ex) {
                Logger.getLogger(UsuariosFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText(null);
            alert.setContentText("Debe seleccionar un Usuario...");
            alert.showAndWait();
        }
         
    }

    @FXML
    private void activarUsuario(ActionEvent event) { 
        
            if(tbl_usuario.getSelectionModel().getSelectedItem() != null){
            usuario = tbl_usuario.getSelectionModel().getSelectedItem();
        }
        
        if (this.usuario != null) {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmación");
            alert.setHeaderText(null);
            alert.setContentText("Seguro que desea activar el usuario?...");
           

            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {

                    try {
                        HashMap<String, Object> params = new LinkedHashMap<>();
                        params.put("idUsuario", this.usuario.getIdUsuario());
                        String respuesta = Requests.post("/Usuarios/actualizarEstatus/"+usuario.getIdUsuario(), params);

                        String estado = this.usuario.getEstatus();
                        
                        if ("Inactivo".equals(estado)) {
                            
                            JSONObject dataJson = new JSONObject(respuesta);
                            
                            if ((Boolean) dataJson.get("error") == false) {

                                Alert alertC = new Alert(Alert.AlertType.INFORMATION);
                                alertC.setTitle("Informativo");
                                alertC.setHeaderText(null);
                                alertC.setContentText(dataJson.getString("mensaje"));
                                alertC.showAndWait();
                                this.usuario = null;
                                this.cargarTabla();

                            } else {
                                Alert alertN = new Alert(Alert.AlertType.INFORMATION);
                                alertN.setTitle("Informativo");
                                alertN.setHeaderText(null);
                                alertN.setContentText(dataJson.getString("mensaje"));
                                alertN.showAndWait();
                                this.usuario = null;
                                this.cargarTabla();
                            }
                        } else {
                            Alert alertInactivo = new Alert(Alert.AlertType.INFORMATION);
                            alertInactivo.setTitle("Informativo");
                            alertInactivo.setHeaderText(null);
                            alertInactivo.setContentText("El usuario ya esta Activo...");
                            alertInactivo.showAndWait();
                            this.usuario = null;
                            this.cargarTabla();
                        }
                    } catch (JSONException ex) {
                        Logger.getLogger(UsuariosFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (response == ButtonType.CANCEL) {
                    this.usuario = null;
                    this.cargarTabla();
                }
            });
        } else {
            Alert alertI = new Alert(Alert.AlertType.WARNING);
            alertI.setTitle("Advertencia");
            alertI.setHeaderText(null);
            alertI.setContentText("Debe seleccionar un Usuario...");
            alertI.showAndWait();
        }
    }

    @FXML
    private void desactivarUsuario(ActionEvent event) {    
        
        
        if(tbl_usuario.getSelectionModel().getSelectedItem() != null){
            usuario = tbl_usuario.getSelectionModel().getSelectedItem();
        }
        
        if(this.usuario != null){
            
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmación");
            alert.setHeaderText(null);
            alert.setContentText("Seguro que desea desactivar el usuario?...");
            //alert.showAndWait();
            
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    
                    try {
                        HashMap<String, Object> params = new LinkedHashMap<>();
                        params.put("idUsuario",this.usuario.getIdUsuario());
                        String respuesta = Requests.post("/Usuarios/eliminarUsuario/"+usuario.getIdUsuario(), params);
                        
                        String estado = this.usuario.getEstatus();
                        if("Activo".equals(estado)){
                            
                            JSONObject dataJson = new JSONObject(respuesta);
                            
                            if ((Boolean) dataJson.get("error") == false) {

                                Alert alertC = new Alert(Alert.AlertType.INFORMATION);
                                alertC.setTitle("Informativo");
                                alertC.setHeaderText(null);
                                alertC.setContentText(dataJson.getString("mensaje"));
                                alertC.showAndWait();
                                this.usuario = null;
                                this.cargarTabla();

                            } else {
                                Alert alertN = new Alert(Alert.AlertType.INFORMATION);
                                alertN.setTitle("Informativo");
                                alertN.setHeaderText(null);
                                alertN.setContentText(dataJson.getString("mensaje"));
                                alertN.showAndWait();
                                this.usuario = null;
                                this.cargarTabla();
                            }
                        } else{
                            Alert alertInactivo = new Alert(Alert.AlertType.INFORMATION);
                            alertInactivo.setTitle("Informativo");
                            alertInactivo.setHeaderText(null);
                            alertInactivo.setContentText("El usuario ya esta Inactivo...");
                            alertInactivo.showAndWait();
                            this.usuario = null;
                            this.cargarTabla();
                        }                      
                    } catch (JSONException ex) {
                        Logger.getLogger(UsuariosFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (response == ButtonType.CANCEL) {
                    this.usuario = null;
                    this.cargarTabla();
                }
            });
        }else{
            Alert alertI = new Alert(Alert.AlertType.WARNING);
            alertI.setTitle("Advertencia");
            alertI.setHeaderText(null);
            alertI.setContentText("Debe seleccionar un Usuario...");
            alertI.showAndWait();
        }
        //this.cargarTabla();s
    }
    
    public void cargarTabla(){
        String respuesta = "";
        tbl_usuario.getItems().clear();
        
        respuesta = Requests.get("/Usuarios/getAllUsers/");
        Gson gson = new Gson();
        
        TypeToken<List<Usuarios>> token = new TypeToken<List<Usuarios>>(){   
        };

        List<Usuarios> listaUsuario = gson.fromJson(respuesta, token.getType());
        
        
        tcl_nombreUsuario.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tcl_apellidoPaterno.setCellValueFactory(new PropertyValueFactory<>("apellidoPaterno"));
        tcl_apellidoMaterno.setCellValueFactory(new PropertyValueFactory<>("apellidoMaterno"));
        tcl_usuarioUsuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
        tcl_password.setCellValueFactory(new PropertyValueFactory<>("password"));
        tcl_estatusUsuario.setCellValueFactory(new PropertyValueFactory<>("estatus"));
        tcl_rolUsuario.setCellValueFactory(new PropertyValueFactory<>("idRol"));
        tcl_curp.setCellValueFactory(new PropertyValueFactory<>("curp"));
        
        listaUsuario.forEach(e ->{
            tbl_usuario.getItems().add(e);
        });
    }

    @FXML
    private void clickTable(MouseEvent event) {
        String respuesta ="";
        if(tbl_usuario.getSelectionModel().getSelectedItem() != null){
            usuario = tbl_usuario.getSelectionModel().getSelectedItem();
        }
    }
    
    
}
