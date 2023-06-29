/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofx.controlador;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import proyectofx.modelo.pojos.Usuarios;

/**
 * FXML Controller class
 *
 * @author afs30
 */
public class PrincipalFXMLController implements Initializable {

    @FXML
    private BorderPane pnl_principal;
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

    Usuarios usuario = null;
    @FXML
    private MenuItem mi_empeno;
    @FXML
    private MenuItem mi_cliente;
    @FXML
    private MenuItem mi_venta;
    @FXML
    private MenuItem mi_usuario;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setData(HashMap<String,Object> context){                  
        System.out.print(context);
        
    }
    public void setDataUsuario(Usuarios usuario){                  
        this.usuario=usuario;
    }
    
    @FXML
    private void clickUsuario(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/proyectofx/gui/vista/UsuariosFXML.fxml"));
            
            Parent principal = loader.load();
            
            UsuariosFXMLController usuario = loader.getController();
            usuario.setData(this.usuario);
            pnl_principal.setCenter(principal);
        }catch(IOException ex){
            Logger.getLogger(PrincipalFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void clickCliente(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/proyectofx/gui/vista/UsuariosFXML.fxml"));
            
            Parent principal = loader.load();
            
            UsuariosFXMLController usuario = loader.getController();

            pnl_principal.setCenter(principal);
        }catch(IOException ex){
            Logger.getLogger(PrincipalFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void clickVenta(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/proyectofx/gui/vista/VentasFXML.fxml"));
            
            Parent principal = loader.load();
            usuario.setData(this.usuario);
            VentasFXMLController usuario = loader.getController();
            pnl_principal.setCenter(principal);
        }catch(IOException ex){
            Logger.getLogger(PrincipalFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    @FXML
    
    private void clickContratos(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/proyectofx/gui/vista/ContratoFXML.fxml"));
            
            Parent principal = loader.load();
            
            ContratoFXMLController usuario = loader.getController();

            pnl_principal.setCenter(principal);
        }catch(IOException ex){
            Logger.getLogger(PrincipalFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
    @FXML
    private void clickPrendas(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/proyectofx/gui/vista/PrendasFXML.fxml"));
            
            Parent principal = loader.load();
            
            PrendasFXMLController usuario = loader.getController();

            pnl_principal.setCenter(principal);
        }catch(IOException ex){
            Logger.getLogger(PrincipalFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
    
    @FXML
    private void clickComercializacion(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/proyectofx/gui/vista/ComercializacionFXML.fxml"));
            
            Parent principal = loader.load();
            
            ComercializacionFXMLController usuario = loader.getController();

            pnl_principal.setCenter(principal);
        }catch(IOException ex){
            Logger.getLogger(PrincipalFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    
    
    
    @FXML
    private void clickEmpeño(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/proyectofx/gui/vista/EmpenoFXML.fxml"));
            
            Parent principal = loader.load();
            
            EmpenoFXMLController usuario = loader.getController();

            pnl_principal.setCenter(principal);
        }catch(IOException ex){
            Logger.getLogger(PrincipalFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }      
    
    
    @FXML
    private void clickSistemaCatalogo(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/proyectofx/gui/vista/UsuariosFXML.fxml"));
            
            Parent principal = loader.load();
            
            UsuariosFXMLController usuario = loader.getController();

            pnl_principal.setCenter(principal);
        }catch(IOException ex){
            Logger.getLogger(PrincipalFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    @FXML
    private void clickPrendaCatalogo(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/proyectofx/gui/vista/UsuariosFXML.fxml"));
            
            Parent principal = loader.load();
            
            UsuariosFXMLController usuario = loader.getController();

            pnl_principal.setCenter(principal);
        }catch(IOException ex){
            Logger.getLogger(PrincipalFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 





    @FXML
    private void clickprendasCategorias(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/proyectofx/gui/vista/UsuariosFXML.fxml"));
            
            Parent principal = loader.load();
            
            UsuariosFXMLController usuario = loader.getController();

            pnl_principal.setCenter(principal);
        }catch(IOException ex){
            Logger.getLogger(PrincipalFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 






    @FXML
    private void clickSistemaCategoria(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/proyectofx/gui/vista/UsuariosFXML.fxml"));
            
            Parent principal = loader.load();
            
            UsuariosFXMLController usuario = loader.getController();

            pnl_principal.setCenter(principal);
        }catch(IOException ex){
            Logger.getLogger(PrincipalFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    private void clickIngreso(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/proyectofx/gui/vista/UsuariosFXML.fxml"));
            
            Parent principal = loader.load();
            
            UsuariosFXMLController usuario = loader.getController();

            pnl_principal.setCenter(principal);
        }catch(IOException ex){
            Logger.getLogger(PrincipalFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    @FXML
    private void clickEgreso(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/proyectofx/gui/vista/UsuariosFXML.fxml"));
            
            Parent principal = loader.load();
            
            UsuariosFXMLController usuario = loader.getController();

            pnl_principal.setCenter(principal);
        }catch(IOException ex){
            Logger.getLogger(PrincipalFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
  
    
    @FXML
    private void clickSesion(ActionEvent event) {
        try {
            Parent vistaPrincipal =FXMLLoader.load(getClass().getResource("/proyectofx/gui/vista/InicioSesionFXML.fxml"));
            Scene escenaPrincipal = new Scene(vistaPrincipal);
            Stage escenarioBase = (Stage)pnl_principal.getScene().getWindow();
            escenarioBase.setScene(escenaPrincipal);
            escenarioBase.show();
        } catch (IOException ex) {
            Logger.getLogger(PrincipalFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
