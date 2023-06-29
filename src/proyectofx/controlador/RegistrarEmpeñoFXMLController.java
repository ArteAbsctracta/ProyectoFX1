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
import proyectofx.modelo.pojos.Usuarios;
import proyectofx.utils.Window;

/**
 * FXML Controller class
 *
 * @author otreb
 */
public class RegistrarEmpeñoFXMLController implements Initializable {

    private ObservableList<Usuarios> comboBoxListUsuarios;
    //private ObservableList<Clientes> comboBoxList;

    @FXML
    private Button btn_cancelarRegistro;
    @FXML
    private TextField txt_almacenajePorcentaje;
    @FXML
    private TextField txt_interesPorcentaje;
    @FXML
    private TextField txt_observaciones;
    @FXML
    private TextField txt_IVAEmpeño;
    @FXML
    private Button btn_registrarContrato;
    @FXML
    private TextField txt_numPeriodos;
    @FXML
    private TextField txt_diasPeriodo;
    @FXML
    private TextField txt_TasaComercializacion;
    @FXML
    private ComboBox<?> cmbCliente;
    @FXML
    private ComboBox<String> cmbUsuario;
    @FXML
    private DatePicker dtCreacion;
    @FXML
    private DatePicker dtActualizacion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        comboBoxListUsuarios = getAllUsuarios();

        List<String> nombreRoles = new LinkedList<String>();
        Integer idRoles[] = new Integer[comboBoxListUsuarios.size()];
        int i = 0;
        for (Usuarios rol : comboBoxListUsuarios) {
            nombreRoles.add(rol.getNombre());
            idRoles[i] = rol.getIdRol();
            i++;
        }
        ObservableList<String> ObsnombreRoles = FXCollections.observableArrayList(nombreRoles);
        cmbUsuario.setItems(ObsnombreRoles);
        dtCreacion.setValue(LocalDate.now());
        dtCreacion.setDisable(true);
        dtActualizacion.setValue(LocalDate.now());
        dtActualizacion.setDisable(true);
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

    @FXML
    private void registrarEmpeño(ActionEvent event) {
        int position = this.cmbUsuario.getSelectionModel().getSelectedIndex();

        if (this.txt_almacenajePorcentaje.getText().isEmpty()
                || this.txt_interesPorcentaje.getText().isEmpty()
                || this.txt_observaciones.getText().isEmpty()
                || this.txt_IVAEmpeño.getText().isEmpty()
                || this.txt_diasPeriodo.getText().isEmpty()
                || this.txt_numPeriodos.getText().isEmpty()
                || this.txt_TasaComercializacion.getText().isEmpty()
                || this.dtActualizacion.getValue().equals("")
                || this.dtCreacion.getValue().equals("")
                || position <= -1) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error al registrar el empeño");
            alert.setHeaderText(null);
            alert.setContentText("Alguno de los campos se encuentra Vacio");
            alert.showAndWait();
        } else {

            try {
                String verificacion = null;
                String v = "0";
                String id = Requests.get("/Usuarios/buscarUsuario/"+cmbUsuario.getValue());
                Gson gson = new Gson();
                TypeToken<Usuarios> token = new TypeToken<Usuarios>(){};
                Usuarios user = gson.fromJson(id, token.getType());
                System.out.println(user.getIdUsuario());
                
                HashMap<String, Object> params = new LinkedHashMap<>();
                params.put("idUsuario", user.getIdUsuario());
                params.put("idCliente", 1);
                params.put("fechaCreacion", this.dtCreacion.getValue());
                params.put("observaciones", this.txt_observaciones.getText());
                params.put("contratoActual", 1);
                params.put("fechaActualizacion", this.dtActualizacion.getValue());
                params.put("interesPorcentaje", this.txt_interesPorcentaje.getText());
                params.put("almacenajePorcentaje", this.txt_almacenajePorcentaje.getText());
                params.put("numPeriodos", this.txt_numPeriodos.getText());
                params.put("diasPeriodos", this.txt_diasPeriodo.getText());
                params.put("ivaEmpeño", this.txt_IVAEmpeño.getText());
                params.put("tasaCormecializacion", this.txt_TasaComercializacion.getText());

                String respuesta = Requests.post("/Empenos/registrarEmpenos/", params);
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
