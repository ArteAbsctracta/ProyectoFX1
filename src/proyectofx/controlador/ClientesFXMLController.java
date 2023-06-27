/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofx.controlador;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import proyectofx.modelo.pojos.Usuarios;
/**
 * FXML Controller class
 *
 * @author afs30
 */
public class ClientesFXMLController implements Initializable {
    /**
     * Initializes the controller class.
     */
    
     Usuarios usuario = null;
     Boolean isnew=false;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    public void setData(Usuarios usuario, Boolean isnew){ 
        this.usuario=usuario;
        this.isnew=isnew;
       // this.cargarUsuario();
    }
}
