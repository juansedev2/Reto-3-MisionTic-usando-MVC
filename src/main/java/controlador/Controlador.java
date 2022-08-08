/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import mundo.OperadorCuerpoDeAgua;

/**
 *
 * @author Juan Sebastian
 */
public class Controlador {
    
    // Esta clase controlado está destinada al tratamiento de la información, quiero separar en lo posible, la lógica del procesamiento de datos al momento de calcularlos
    // Atributos de la clase
    private String cadena_datos;  // Cadena enviada desde la interfaz con los datos del cuerpo de agua
    private OperadorCuerpoDeAgua operadorAgua;  // Realizo asociación del operador del cuerpo de agua para que este realice el tratamiento de la información
    
    // Constructor
    public Controlador(){
        this.operadorAgua = new OperadorCuerpoDeAgua();
    }

    // Get y set
    
    public String getCadena_datos() {
        return cadena_datos;
    }

    public void setCadena_datos(String cadena_datos) {
        this.cadena_datos = cadena_datos;
    }

    public OperadorCuerpoDeAgua getOperadorAgua() {
        return operadorAgua;
    }

    public void setOperadorAgua(OperadorCuerpoDeAgua operadorAgua) {
        this.operadorAgua = operadorAgua;
    }
    
    // Método para enviar Cadena con los datos obtenidos de la interfaz y agregar cuerpo de agua
    public void agregarCuerpo(){
        this.operadorAgua.setCadena_datos(this.cadena_datos);
        this.operadorAgua.agregarCuerpoDeAgua();
    }
    
    // Método para devolver la cantidad de cuerpos de agua medios o inferiores
    public String devolverInferiores(){
        return String.valueOf(this.operadorAgua.getTotal_inferiores());
    }
    
    // Método para devolver los cuerpos de agua que tienen un nivel de riesgo Medio
    public String devolverMedios(){
        return this.operadorAgua.indicarMedios();
    }
    
    // Método para devolver el cuerpo de agua con clasificación IRCA más baja
    public String devolverMasBajo(){
        return this.operadorAgua.indicarCuerpoBajo();
    }
    
    // Método para reiniciar el operador (cuando se reinice el programa, este debe perdir todos sus datos para volver a comenzar)
    public void reininiarOperador(){
        this.operadorAgua = null;
    }
    
    // Método para devolver los niveles de cada cuerpo de agua
    public String devolverNivelesCompletos(){
        return this.operadorAgua.devolverNivelesCuerpos();
    }
    
    // Método para realizar el cálculo de los cuerpos de gia
    public void realizarCalculoMedios(){
        this.operadorAgua.calcularMediosAgua();
    }
    
    
    // TODO: 
    /*
    Pensar bien que atributos y métodos tendrá el controlador, ya que una idea que puedo implementar es que al 
    momento de crear una instanciade InterfazApp, puedo crear una de controlador, la cual su vida será igual
    a la que dure el programa (ventana activa).
    Controlador deberá tener una relación de agregación de Cuerpo de agua a través de un arreglo, con eso arreglo
    yo voy a realizar todos los cálculos, porque en ese arreglo debo de almacenar cada cuerpo de agua y cuando sea
    momento de hacer el cálculo, cuando el evento de procesar sea activado, debo venir acá y con el arreglo
    de los cuerpos empezar a realizar el cálculo (aunque podría también destinar una clase en el mundo para que
    realize ese proceso y únicamente dejar al controlador como medio de compartir y devolver información a la vista)
    (si hago esta última opción, entonces haría que una nueva clase cargue con esa relación de agregación y en 
    este controlador, hago una asosiación de un objeto de esa clase calculadora, donde esta me hará todas las 
    operaciones que necesitaré y solo controlador las recibirá y las retornará a la vista)
    
    Hacer también un botón que limpie en memoria la entrada y salida producida, es decir, como una especie de reinicio 
    del programa sin terminar el programa, las cajas de texto se limpiarán, los datos se borrarán y nuevamente se podrá
    volver a ingresar datos
    
    LAS CAJAS DE TEXTO TAMPOCO DEBEN PERMITIRSE EDITAR, SOLO DEBEN MOSTRAR
    
    TODO: COMUNICAR LA INTERFAZ CON EL CONTROLADOR, (ENVIAR Y RECIBIR TODA LA INFORMACIÓN) y hacer debugging si se presenta el caso -- Hecho
    */
    
    
}
