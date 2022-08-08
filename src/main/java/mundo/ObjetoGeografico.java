/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;

/**
 *
 * @author Juan Sebastian
 */
public abstract class ObjetoGeografico {
    
    // Clase abastracta que solo contendrá el nombre de un municipio (no debería ser necesario esta clase, pero fue solicitado)
    
    // Atributo
    protected String municipio;
    
    // Constructor
    public ObjetoGeografico(String municipio){
        this.municipio = municipio;
    }
    
    // Get y set

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
    
}
