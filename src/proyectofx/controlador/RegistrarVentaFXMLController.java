/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofx.controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author afs30
 */
public class RegistrarVentaFXMLController implements Initializable {

    @FXML
    private TextField txt_subTotal;
    @FXML
    private TextField txt_ivaVenta;
    @FXML
    private TextField txt_totalVenta;
    @FXML
    private TextField txt_idContrato;
    @FXML
    private TextField txt_estatusVenta1;
    @FXML
    private TextField txt_idCliente;
    @FXML
    private TextField txt_idCreador;
    @FXML
    private DatePicker cmb_creacion;
    @FXML
    private TextField txt_total;
    @FXML
    private DatePicker cmb_cancelacion;
    @FXML
    private TextField txt_usuario;
    @FXML
    private ComboBox<?> cmb_tipo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
