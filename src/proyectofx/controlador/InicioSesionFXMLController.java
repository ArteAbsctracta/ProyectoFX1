/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofx.controlador;

import com.google.gson.Gson;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import proyectofx.utils.Window;
import proyectofx.api.request.Requests;
import proyectofx.modelo.pojos.Usuarios;
import proyectofx.utils.JavaUtils;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * FXML Controller class
 *
 * @author afs30
 */
public class InicioSesionFXMLController implements Initializable {

    @FXML
    private TextField txt_usuario;
    @FXML
    private PasswordField txt_password;
    @FXML
    private Label lbl_mensaje;
    @FXML
    private Button btn_iniciarSesion;
    @FXML
    private Button btn_cancelar;

    @FXML
    private void cancelar(ActionEvent event) {
        Window.close(event);
    }
    
    @FXML
    private void iniciarSesion(ActionEvent event) throws UnknownHostException {
        if(this.validar()){ 
            try {
                this.lbl_mensaje.setText(""); 
                
                String data ="";
                
                HashMap<String,Object> params = new LinkedHashMap<>();
                params.put("usuario", this.txt_usuario.getText());
                params.put("password", this.txt_password.getText());
                
                data = Requests.post("/sesion/login/", params);
                
                if(!data.isEmpty()){
                    System.out.println("Data;"+data);
                
                    JSONObject dataJson = new JSONObject(data);

                     

                        Stage stage = Window.getStageByEvent(event);
                        
                        Gson gson = new Gson();
                        Usuarios user = gson.fromJson(data, Usuarios.class); 
                        HashMap<String,Object> context = new HashMap<String,Object> ();             
                        context.put("mac",JavaUtils.getMAC());
                        context.put("usuario", user);                                                  
                        context.put("ip",InetAddress.getLocalHost());
                        
                        if(user.getIdRol() == 1){
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/proyectofx/gui/vista/Principal1FXML.fxml"));
                            
                            Parent principal = loader.load();
                            
                            PrincipalFXMLController ctrl = loader.getController();
                            ctrl.setData(context);
                            ctrl.setDataUsuario(user);

                            Scene scene = new Scene(principal);

                            stage.setScene(scene);
                            stage.setTitle("Sistema de Administración");
                            stage.setResizable(false);
                            stage.getIcons();
                            stage.show();
                        }else{
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setTitle("Advertencia");
                            alert.setHeaderText(null);
                            alert.setContentText("Usuario no AUTORIZADO...");
                            alert.showAndWait();
                        }
                  
               
                    
                }else{
                    this.lbl_mensaje.setText("Error en la conexion");
                }
            } catch (JSONException ex) {
                Logger.getLogger(InicioSesionFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(InicioSesionFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }else{
            this.lbl_mensaje.setText("Ingrese los datos por favor...");  
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    private boolean validar(){
        boolean valido = false;
        if(!this.txt_usuario.getText().isEmpty() && !this.txt_password.getText().isEmpty()){
            valido= true;
        }
        return valido;
    }
    
}
