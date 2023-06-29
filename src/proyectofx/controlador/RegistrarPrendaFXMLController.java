/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofx.controlador;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.net.URL;
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
public class RegistrarPrendaFXMLController implements Initializable {

    private ObservableList<Usuarios> comboBoxListUsuarios;
    private ObservableList<Empeño> comboBoxListEmpeños;
    @FXML
    private Button btn_cancelarRegistro;
    @FXML
    private ComboBox<String> cmbEmpeno;
    @FXML
    private ComboBox<String> cmbUsuario;
    @FXML
    private DatePicker dtCreacion;
    @FXML
    private DatePicker dtComercializacion;
    @FXML
    private TextField txt_Categoria;
    private TextField txt_Precio;
    @FXML
    private TextField txt_Serie;
    @FXML
    private DatePicker dtVenta;
    @FXML
    private TextField txt_Descripcion;
    @FXML
    private TextField txt_SubCategoria;
    @FXML
    private TextField txt_Venta;
    @FXML
    private TextField txt_PrecioComercializacion;
    @FXML
    private TextField txt_Modelo;
    @FXML
    private TextField txt_NumPiezas;
    @FXML
    private TextField txt_Metal;
    @FXML
    private TextField txt_Peso;
    @FXML
    private TextField txt_kilataje;
    @FXML
    private TextField txt_Prestamo;
    @FXML
    private TextField txt_Prenda;
    @FXML
    private TextField txt_Comercializacion;
    @FXML
    private Button btn_registrarPrenda;

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
    private void cancelarRegistro(ActionEvent event) {
        Window.close(event);
    }

    @FXML
    private void registrarPrenda(ActionEvent event) {

        int position = this.cmbUsuario.getSelectionModel().getSelectedIndex();
        int position2 = this.cmbEmpeno.getSelectionModel().getSelectedIndex();

        if (this.dtCreacion.getValue() == null
                || this.dtComercializacion.getValue() == null
                || this.txt_Categoria.getText().isEmpty()
                || this.txt_Serie.getText().isEmpty()
                || this.dtVenta.getValue() == null
                || this.txt_Descripcion.getText().isEmpty()
                || this.txt_SubCategoria.getText().isEmpty()
                || this.txt_Venta.getText().isEmpty()
                || this.txt_PrecioComercializacion.getText().isEmpty()
                || this.txt_Modelo.getText().isEmpty()
                || this.txt_NumPiezas.getText().isEmpty()
                || this.txt_Metal.getText().isEmpty()
                || this.txt_Peso.getText().isEmpty()
                || this.txt_kilataje.getText().isEmpty()
                || this.txt_Prestamo.getText().isEmpty()
                || this.txt_Prenda.getText().isEmpty()
                || this.txt_Comercializacion.getText().isEmpty()
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
                params.put("idEmpeño", this.cmbEmpeno.getValue());
                params.put("categoria", this.txt_Categoria.getText());
                params.put("numPiezas", this.txt_NumPiezas.getText());
                params.put("serie", this.txt_Serie.getText());
                params.put("modelo", this.txt_Modelo.getText());
                params.put("subCategoria", this.txt_SubCategoria.getText());
                params.put("descripcionPrenda", this.txt_Descripcion.getText());
                params.put("metal", this.txt_Metal.getText());
                params.put("peso", this.txt_Peso.getText());
                params.put("kilataje", this.txt_kilataje.getText());
                params.put("prestamo", this.txt_Prestamo.getText());
                params.put("modeloPrenda", this.txt_Prenda.getText());
                params.put("precioComercializacion", this.txt_PrecioComercializacion.getText());
                params.put("precioVenta", this.txt_Venta.getText());
                params.put("estatusPrenda", "Activo");
                params.put("comercializacionAsociada", this.txt_Comercializacion.getText());
                params.put("fechaCreacion", this.dtCreacion.getValue());
                params.put("fechaComercializacion", this.dtComercializacion.getValue());
                params.put("fechaVenta", this.dtVenta.getValue());
                params.put("idUsuario", user.getIdUsuario());

                String respuesta = Requests.post("/Prendas/registrarPrenda/", params);
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
