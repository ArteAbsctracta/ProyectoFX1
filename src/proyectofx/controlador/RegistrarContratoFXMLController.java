/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofx.controlador;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.json.JSONException;
import org.json.JSONObject;
import proyectofx.api.request.Requests;
import proyectofx.modelo.pojos.Empeño;
import proyectofx.modelo.pojos.Usuarios;
import proyectofx.utils.Window;

/**
 * FXML Controller class
 *
 * @author otreb
 */
public class RegistrarContratoFXMLController implements Initializable {

    private ObservableList<Usuarios> comboBoxListUsuarios;
    private ObservableList<Empeño> comboBoxListEmpeños;
    @FXML
    private Button btn_cancelarRegistro;
    @FXML
    private Button btn_registrarContrato;
    @FXML
    private ComboBox<String> cmbUsuario;
    @FXML
    private DatePicker dtCreacion;
    @FXML
    private DatePicker dtActualizacion;
    @FXML
    private TextField txt_importePrestamo;
    @FXML
    private TextField txt_ContratoSiguiente;
    @FXML
    private TextField txt_ContratoAnterior;
    @FXML
    private DatePicker dtLimite;
    @FXML
    private DatePicker dtComercializar;
    @FXML
    private DatePicker dtCancelacion;
    @FXML
    private DatePicker dtComercializacion;
    @FXML
    private TextField txt_Observaciones;
    @FXML
    private TextField txt_Refrendo;
    @FXML
    private TextField txt_Finiquito;
    @FXML
    private TextField txt_Espera;
    @FXML
    private ComboBox<String> cmbEmpeno;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        comboBoxListUsuarios = getAllUsuarios();
        comboBoxListEmpeños = getAllEmpeños();

        List<String> nombreRoles = new LinkedList<String>();
        int i = 0;
        for (Usuarios rol : comboBoxListUsuarios) {
            nombreRoles.add(rol.getNombre());
            i++;
        }
        ObservableList<String> ObsnombreRoles = FXCollections.observableArrayList(nombreRoles);
        cmbUsuario.setItems(ObsnombreRoles);

        List<String> nombreRoles2 = new LinkedList<String>();
        Integer idRoles2[] = new Integer[comboBoxListEmpeños.size()];
        i = 0;
        for (Empeño rol : comboBoxListEmpeños) {
            nombreRoles2.add(rol.getIdEmpeño().toString());
            i++;
        }
        ObservableList<String> ObsnombreRoles2 = FXCollections.observableArrayList(nombreRoles2);
        cmbEmpeno.setItems(ObsnombreRoles2);
        dtActualizacion.setValue(LocalDate.now());
        dtCancelacion.setValue(LocalDate.now());
        dtComercializacion.setValue(LocalDate.now());
        dtComercializar.setValue(LocalDate.now());
        dtCreacion.setValue(LocalDate.now());
        dtLimite.setValue(LocalDate.now());
    }

    @FXML
    private void cancelarRegistro(ActionEvent event) {
        Window.close(event);
    }

    private ObservableList getAllUsuarios() {

        String respuesta = Requests.get("/Usuarios/getAllUsers/");
        Gson gson = new Gson();

        TypeToken<List<Usuarios>> token = new TypeToken<List<Usuarios>>() {
        };

        List<Usuarios> listaRoles = gson.fromJson(respuesta, token.getType());

        comboBoxListUsuarios = FXCollections.observableArrayList(listaRoles);
        System.out.print(comboBoxListUsuarios);
        return comboBoxListUsuarios;
    }

    private ObservableList getAllEmpeños() {

        String respuesta = Requests.get("/Empenos/getAllEmpenos/");
        Gson gson = new Gson();

        TypeToken<List<Empeño>> token = new TypeToken<List<Empeño>>() {
        };

        List<Empeño> listaRoles = gson.fromJson(respuesta, token.getType());

        comboBoxListEmpeños = FXCollections.observableArrayList(listaRoles);
        System.out.print(comboBoxListEmpeños);
        return comboBoxListEmpeños;
    }

    @FXML
    private void registrarContrato(ActionEvent event) {
        int position = this.cmbUsuario.getSelectionModel().getSelectedIndex();
        int position2 = this.cmbEmpeno.getSelectionModel().getSelectedIndex();

        if (this.dtCreacion.getValue() == null
                || this.dtActualizacion.getValue() == null
                || this.txt_importePrestamo.getText().isEmpty()
                || this.txt_ContratoSiguiente.getText().isEmpty()
                || this.txt_ContratoAnterior.getText().isEmpty()
                || this.dtLimite.getValue() == null
                || this.dtComercializar.getValue() == null
                || this.dtCancelacion.getValue() == null
                || this.dtComercializacion.getValue() == null
                || this.txt_Observaciones.getText().isEmpty()
                || this.txt_Refrendo.getText().isEmpty()
                || this.txt_Finiquito.getText().isEmpty()
                || this.txt_Espera.getText().isEmpty()
                || position <= -1
                || position2 <= -1) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error al registrar el empeño");
            alert.setHeaderText(null);
            alert.setContentText("Alguno de los campos se encuentra Vacio");
            alert.showAndWait();
        } else {

            try {
                String idusuario = Requests.get("/Usuarios/buscarUsuario/" + cmbUsuario.getValue());
                Gson gson = new Gson();
                TypeToken<Usuarios> token = new TypeToken<Usuarios>() {
                };
                Usuarios user = gson.fromJson(idusuario, token.getType());

                HashMap<String, Object> params = new LinkedHashMap<>();
                params.put("idEmpeño", cmbEmpeno.getValue());
                params.put("fechaCreacion", this.dtCreacion.getValue());
                params.put("fechaActualizacion", this.dtActualizacion.getValue());
                params.put("fechaLimite", this.dtLimite.getValue());
                params.put("fechaComercializar", this.dtComercializar.getValue());
                params.put("importePrestamo", this.txt_importePrestamo.getText());
                params.put("estatusContrato", "Activo");
                params.put("contratoSiguiente", this.txt_ContratoSiguiente.getText());
                params.put("contratoAnterior", this.txt_ContratoAnterior.getText());
                params.put("fechaCancelacion", this.dtCancelacion.getValue());
                params.put("fechaComercializacion", this.dtComercializacion.getValue());
                params.put("idUsuario", user.getIdUsuario());
                params.put("observaciones", this.txt_Observaciones.getText());
                params.put("idRefrendo", this.txt_Refrendo.getText());
                params.put("idFiniquito", this.txt_Finiquito.getText());
                params.put("idEspera", this.txt_Espera.getText());

                String respuesta = Requests.post("/Contratos/registrarContrato/", params);
                JSONObject dataJson = new JSONObject(respuesta);

                if ((Boolean) dataJson.get("error") == false) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Informativo");
                    alert.setHeaderText(null);
                    alert.setContentText(dataJson.getString("mensaje"));
                    alert.showAndWait();
                    Window.close(event);

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText(dataJson.getString("mensaje"));
                    alert.showAndWait();
                }

            } catch (JSONException ex) {
                Logger.getLogger(RegistrarUsuarioFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
