package Boletin3.ej8.refranes.model;

public class Refran {
    private String frase;
    
    public Refran(String frase) {
        this.frase = frase;
    }
    
    public String getFrase() {
        return frase;
    }
    
    public boolean contienePalabra(String palabra) {
        return frase.contains(palabra);
    }
    
    @Override
    public String toString() {
        return frase;
    }
}
