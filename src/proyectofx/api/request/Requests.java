/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofx.api.request;

/**
 *
 * @author afs30
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import proyectofx.modelo.pojos.Respuesta;


public class Requests {

    private static String urlBase = "http://localhost:8084/EmpenaWS/ws/";
	private static Gson parser = new Gson();

    public Requests() {
    }

    public static String get(String url) {
        String resultado = "";
        try {
            URL urlAcceso = new URL(urlBase + url);
            HttpURLConnection conexionHTTP = (HttpURLConnection) urlAcceso.openConnection();
            conexionHTTP.setRequestMethod("GET");
            // Realizamos la invocación del servicio
            int codigoRespuesta = conexionHTTP.getResponseCode();
            //System.out.println("Codigo de respuesta obtenido en peticion: " + codigoRespuesta);
            if (codigoRespuesta == HttpURLConnection.HTTP_OK) {
                resultado = convierteStreamCadena(conexionHTTP.getInputStream());
            } else {
                resultado = "Error en la petición GET con código: " + codigoRespuesta;
            }

        } catch (MalformedURLException ex) {
            Logger.getLogger(Requests.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Requests.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Requests.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

	public static <T> Respuesta<T> getResultado(String url) {
		Respuesta<T> respuesta = null;
        try {
            URL urlAcceso = new URL(urlBase + url);
            HttpURLConnection conexionHTTP = (HttpURLConnection) urlAcceso.openConnection();
            conexionHTTP.setRequestMethod("GET");
            // Realizamos la invocación del servicio
            int codigoRespuesta = conexionHTTP.getResponseCode();
            //System.out.println("Codigo de respuesta obtenido en peticion: " + codigoRespuesta);
            if (codigoRespuesta == HttpURLConnection.HTTP_OK) {
                String jsonString = convierteStreamCadena(conexionHTTP.getInputStream());
				TypeToken<T> token = new TypeToken<T>(){};
				T resultado = parser.fromJson(jsonString, token.getType());
				respuesta = new Respuesta<T>(resultado);

            } else {
				String jsonString = convierteStreamCadena(conexionHTTP.getInputStream());
				TypeToken<Respuesta<T>> token = new TypeToken<Respuesta<T>>(){};
				respuesta = parser.fromJson(jsonString, token.getType());
				respuesta.setIsError(true);
                // resultado = "Error en la petición GET con código: " + codigoRespuesta;
            }

        } catch (MalformedURLException ex) {
            Logger.getLogger(Requests.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Requests.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Requests.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
	}

	public static Respuesta<Object> postItem(String url, Map<String, Object> params) {
		Respuesta<Object> respuesta = null;
        try {

            URL urlAcceso = new URL(urlBase + url);
            HttpURLConnection conexionHTTP = (HttpURLConnection) urlAcceso.openConnection();
            conexionHTTP.setRequestMethod("POST");
            conexionHTTP.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conexionHTTP.setDoOutput(true);
            OutputStream outputSalida = conexionHTTP.getOutputStream();
            outputSalida.write(getDataBytes(params));
            outputSalida.flush();
            outputSalida.close();
            //System.out.println(outputSalida);
            int codigoRespuesta = conexionHTTP.getResponseCode();
            System.out.println("Codigo de respuesta: " + codigoRespuesta);
            if (codigoRespuesta == HttpURLConnection.HTTP_OK) {
				String jsonString = convierteStreamCadena(conexionHTTP.getInputStream());
				TypeToken<Respuesta<Object>> token = new TypeToken<Respuesta<Object>>(){};
				respuesta = parser.fromJson(jsonString, token.getType());
            } else {
                String jsonString = convierteStreamCadena(conexionHTTP.getInputStream());
				TypeToken<Respuesta<Object>> token = new TypeToken<Respuesta<Object>>(){};
				respuesta = parser.fromJson(jsonString, token.getType());
				respuesta.setIsError(true);
            }

        } catch (Exception ex) {
            Logger.getLogger(Requests.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
	}

    public static String post(String url, Map<String, Object> params) {
        String resultado = "";
        try {

            URL urlAcceso = new URL(urlBase + url);
            HttpURLConnection conexionHTTP = (HttpURLConnection) urlAcceso.openConnection();
            conexionHTTP.setRequestMethod("POST");
            conexionHTTP.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conexionHTTP.setDoOutput(true);
            OutputStream outputSalida = conexionHTTP.getOutputStream();
            outputSalida.write(getDataBytes(params));
            outputSalida.flush();
            outputSalida.close();
            //System.out.println(outputSalida);
            int codigoRespuesta = conexionHTTP.getResponseCode();
            System.out.println("Codigo de respuesta: " + codigoRespuesta);
            if (codigoRespuesta == HttpURLConnection.HTTP_OK) {
                resultado = convierteStreamCadena(conexionHTTP.getInputStream());
            } else {
                resultado = "ERROR en la petición POST con código: " + codigoRespuesta;
            }

        } catch (Exception ex) {
            Logger.getLogger(Requests.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    public static String put(String url, Map<String, Object> params) {
        String resultado = "";
        try {

            URL urlAcceso = new URL(urlBase + url);
            HttpURLConnection conexionHTTP = (HttpURLConnection) urlAcceso.openConnection();
            conexionHTTP.setRequestMethod("PUT");
            conexionHTTP.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conexionHTTP.setDoOutput(true);
            OutputStream outputSalida = conexionHTTP.getOutputStream();
            outputSalida.write(getDataBytes(params));
            outputSalida.flush();
            outputSalida.close();
            int codigoRespuesta = conexionHTTP.getResponseCode();
            System.out.println("Codigo de respuesta: " + codigoRespuesta);
            if (codigoRespuesta == HttpURLConnection.HTTP_OK) {
                resultado = convierteStreamCadena(conexionHTTP.getInputStream());
            } else {
                resultado = "ERROR en la petición PUT con código: " + codigoRespuesta;
            }

        } catch (Exception ex) {
            Logger.getLogger(Requests.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    public static String delete(String url, Map<String, Object> params) {
        String resultado = "";
        try {

            URL urlAcceso = new URL(urlBase + url);
            HttpURLConnection conexionHTTP = (HttpURLConnection) urlAcceso.openConnection();
            conexionHTTP.setRequestMethod("DELETE");
            conexionHTTP.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conexionHTTP.setDoOutput(true);
            OutputStream outputSalida = conexionHTTP.getOutputStream();
            outputSalida.write(getDataBytes(params));
            outputSalida.flush();
            outputSalida.close();
            int codigoRespuesta = conexionHTTP.getResponseCode();
            System.out.println("Codigo de respuesta: " + codigoRespuesta);
            if (codigoRespuesta == HttpURLConnection.HTTP_OK) {
                resultado = convierteStreamCadena(conexionHTTP.getInputStream());
            } else {
                resultado = "ERROR en la petición DELETE con código: " + codigoRespuesta;
            }

        } catch (Exception ex) {
            Logger.getLogger(Requests.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    private static String convierteStreamCadena(InputStream streamServicio) throws Exception {
        InputStreamReader isr = new InputStreamReader(streamServicio);
        BufferedReader in = new BufferedReader(isr);
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println(response);
        return response.toString();
    }

    private static byte[] getDataBytes(Map<String, Object> params) throws Exception {
        StringBuilder postData = new StringBuilder();
        for (Map.Entry<String, Object> param : params.entrySet()) {
            if (postData.length() != 0) {
                postData.append('&');
            }
            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        }
        byte[] postDataBytes = postData.toString().getBytes("UTF-8");
        System.out.println(postDataBytes);
        return postDataBytes;
    }
}