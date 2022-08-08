/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;

import java.util.ArrayList;

/**
 *
 * @author Juan Sebastian
 */
public class OperadorCuerpoDeAgua {

    // Atributos de la clase
    private ArrayList<CuerpoDeAgua> lista_cuerpos_agua; // Se compondrá de uno o más cuerpos de agua para que esta clase tenga sentido de funcionaldiad
    private String cadena_datos;   // Esta cadena contendrá la cadena de datos de cada cuerpo de agua enviado por el controlador y este de la interfaz
    private int total_inferiores;
    private int total_medios;

    // Constructor
    public OperadorCuerpoDeAgua() {
        // Instanciar la lista porque es un objeto y de no instanciarlo, apuntaría a nulo, entonces no existe y no se puede usar.
        this.lista_cuerpos_agua = new ArrayList();
    }

    // Set y get
    public ArrayList<CuerpoDeAgua> getLista_cuerpos_agua() {
        return lista_cuerpos_agua;
    }

    public void setLista_cuerpos_agua(ArrayList<CuerpoDeAgua> lista_cuerpos_agua) {
        this.lista_cuerpos_agua = lista_cuerpos_agua;
    }

    public String getCadena_datos() {
        return cadena_datos;
    }

    public void setCadena_datos(String cadena_datos) {
        this.cadena_datos = cadena_datos;
    }

    public int getTotal_inferiores() {
        return total_inferiores;
    }

    public void setTotal_inferiores(int total_inferiores) {
        this.total_inferiores = total_inferiores;
    }

    public int getTotal_medios() {
        return total_medios;
    }

    public void setTotal_medios(int total_medios) {
        this.total_medios = total_medios;
    }

    // Método para dividir la cadena recibida y obtener los datos del cuerpo de agua
    private String[] dividirCadena() {
        String[] datos = this.cadena_datos.split(" ");
        return datos;
    }

    // Método para crear un cuerpo de agua y llenar sus datos
    public void agregarCuerpoDeAgua() {

        String[] datos = dividirCadena();
        //System.out.println("Tamaño de la cadena: " + datos.length);
        // Obtenemos cada dato recibido en el arreglo
        String nombre = datos[0];
        String identificacion = datos[1];
        String municipio = datos[2];
        String tipo_cuerpo_agua = datos[3];
        String tipo_agua = datos[4];
        //System.out.println("VALOR: ");
        //System.out.println(datos[5]);
        float clasificacion = Float.parseFloat(datos[5]);
        CuerpoDeAgua cuerpo = new CuerpoDeAgua(nombre, identificacion, tipo_cuerpo_agua, tipo_agua, clasificacion, municipio);
        cuerpo.setClasificacion();
        lista_cuerpos_agua.add(cuerpo);
    }

    public void calcularMediosAgua() {

        for (CuerpoDeAgua cuerpo : lista_cuerpos_agua) {

            // Evaluar de una vez cuantos hay de nivele medio o inferior
            if (cuerpo.getClasificacion().equals("MEDIO") || cuerpo.getClasificacion().equals("BAJO") || cuerpo.getClasificacion().equals("SIN RIESGO")) {
                this.total_inferiores++;

                if (cuerpo.getClasificacion().equals("MEDIO")) {  // Es necesario contar particularmente los de medio para un caso más adelanta acá abajo
                    total_medios++;
                }

            }
        }
    }

    // Método para devolver el nombre de los cuerpos de agua con nivel IRCA MEDIO
    public String indicarMedios() {

        String lista_medios = "";

        if (this.total_medios == 0) {
            lista_medios = "NA";
        } else {

            for (CuerpoDeAgua cuerpo : lista_cuerpos_agua) {

                if (cuerpo.getClasificacion().equals("MEDIO")) {
                    // Este es un formato especial para mostrar las cadenas con saltos de línea, en cada una estará el nombre del cuerpo de agua
                    if (lista_medios.length() == 0) {  // La cadena al final no puede tener una salto de línea agregado, solo el nombre del último cuerpo
                        lista_medios += cuerpo.getNombre();
                    } else {
                        lista_medios += "\n" + cuerpo.getNombre();
                    }
                    
                }
            }
        }

        return lista_medios;
    }

    // Función para devolver datos del cuerpo de agua con nivel IRCA má bajo
    public String indicarCuerpoBajo() {

        float menor = 999;
        String cadena_menor = "";
        String identificacion = "";

        for (CuerpoDeAgua cuerpo : lista_cuerpos_agua) {

            if (cuerpo.getNumero_clasificacion() < menor) {
                menor = cuerpo.getNumero_clasificacion();
                cadena_menor = cuerpo.getNombre();
                identificacion = cuerpo.getIdentificacion();
            }
        }

        cadena_menor += " " + identificacion;

        return cadena_menor;

    }

    // Función para devolver los niveles de cada cuerpo de agua
    public String devolverNivelesCuerpos() {
        
        String cadena_niveles = "";

        for (CuerpoDeAgua cuerpo : lista_cuerpos_agua) {
            
            if(cadena_niveles.length() == 0){
                cadena_niveles += cuerpo.getClasificacion();
            }else{
                cadena_niveles += "\n" + cuerpo.getClasificacion();
            }
        }
        return cadena_niveles;
    }
}
