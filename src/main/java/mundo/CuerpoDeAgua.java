/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;

/**
 *
 * @author Juan Sebastian
 */
public class CuerpoDeAgua extends ObjetoGeografico {
    // Atributos de la clase
    private String nombre;  // Nombre del cuerpo de agua
    private String identificacion;  // Número de identificación
    // private String municipio;   Este ya es heredado de Objeto Gegrogafico
    private String tipo_cuerpo_agua; // Tipos de cuerpo de agua
    private String tipo_agua;  // Tipo de agua
    private float numero_clasificacion;  // Número de clasificación IRCA
    private String clasificacion;  // Clasificación IRCA en palabra, basado en el número de arriba

    // Constructor

    public CuerpoDeAgua(String nombre, String identificacion, String tipo_cuerpo_agua, String tipo_agua,float numero_clasificacion, String municipio) {
        super(municipio);
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.tipo_cuerpo_agua = tipo_cuerpo_agua;
        this.tipo_agua = tipo_agua;
        this.numero_clasificacion = numero_clasificacion;
    }
    
    
    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTipo_cuerpo_agua() {
        return tipo_cuerpo_agua;
    }

    public void setTipo_cuerpo_agua(String tipo_cuerpo_agua) {
        this.tipo_cuerpo_agua = tipo_cuerpo_agua;
    }
    

    public String getClasificacion() {
        return clasificacion;
    }

    public float getNumero_clasificacion() {
        return numero_clasificacion;
    }

    public void setNumero_clasificacion(float numero_clasificacion) {
        this.numero_clasificacion = numero_clasificacion;
    }

    public String getTipo_agua() {
        return tipo_agua;
    }

    public void setTipo_agua(String tipo_agua) {
        this.tipo_agua = tipo_agua;
    }
    
    

    // Este es realmente el método llamado nivel que calculará el nivel de riesgo de un cuerpo de agua con el atributo de clasificación
    public void setClasificacion() {  // ESTE SERÁ UN CASO EXCEPCIONAL DE SET, porque el parámetro lo obtendré del número de clasificaciónd de la clase al instanciar el objeto

        // Según el número en clasificación IRCA (número de identificación), será asignado la clasificación    
        if (numero_clasificacion >= 0 && numero_clasificacion < 5) {

            clasificacion = "SIN RIESGO";

        } else if (numero_clasificacion >= 5 && numero_clasificacion < 14) {
            
            clasificacion = "BAJO";

        } else if (numero_clasificacion >= 14 && numero_clasificacion < 35) {
            
            clasificacion = "MEDIO";

        } else if (numero_clasificacion >= 35 && numero_clasificacion <= 80) {  // NOTA: (DEBE SER < 80 ORIGINALMENTE) porque la lógica establecida en el documento no es la misma que plasmraron en codegrade (esa está mal según el documento)
            
            clasificacion = "ALTO";

        } else if (numero_clasificacion > 80 && numero_clasificacion <= 100) {
            
            clasificacion = "INVIABLE SANITARIAMENTE";

        } else {
            clasificacion = "FUERA DE RANGO";
            
        }  
    }
    
}
