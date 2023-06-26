/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofx;


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

/**
 *
 * @author afs30
 */
public class ProyectoFX extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        //Mandamos a llamar a la ventana de login
        Parent login = FXMLLoader.load(getClass().getResource("/proyectofx/gui/vista/InicioSesionFXML.fxml"));
        
        Scene scene = new Scene(login);
        //Nombramos la ventana
        stage.setTitle("Sistema de Administración");
        //agregamos un icono a la ventana
        stage.getIcons();
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
