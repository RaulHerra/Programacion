package boletin1.maquinaCafe.model;

public class MaquinaCafe {
	
    private int cafe;
    private int leche;
    private int vasos;
    private double monedero;
    private final double pRECIOCAFE = 1;
    private final double pRECIOLECHE = 1;
    private final double pRECIOCAFELECHE = 1;

    public MaquinaCafe(double monederoInicial) {
        this.cafe = 50;
        this.leche = 50;
        this.vasos = 80;
        this.monedero = monederoInicial;
    }

    public String servirCafe(double dinero) {
    	if (monedero-dinero<0 || dinero<pRECIOCAFE) {
    		return "Lo siento, la máquina no dispone de cambio suficiente o el dinero introducido no es suficiente";
    	}
        if (this.cafe >= 1 && this.vasos >= 1) {
            this.cafe -= 1;
            this.vasos -= 1;
            this.monedero += 1.0;
            return "Aquí tiene su café. ¡Disfrútelo!";
        } else {
            return "Lo siento, no hay café o vasos disponibles.";
        }
    }

    public String servirLeche(double dinero) {
    	if (monedero-dinero<0 || dinero<pRECIOLECHE) {
    		return "Lo siento, la máquina no dispone de cambio suficiente o el dinero introducido no es suficiente";
    	}
        if (this.leche >= 1 && this.vasos >= 1) {
            this.leche -= 1;
            this.vasos -= 1;
            this.monedero += 0.8;
            return "Aquí tiene su vaso de leche. ¡Disfrútela!";
        } else {
            return "Lo siento, no hay leche o vasos disponibles.";
        }
    }

    public String servirCafeConLeche(double dinero) {
    	if (monedero-dinero<0 || dinero<pRECIOCAFELECHE) {
    		return "Lo siento, la máquina no dispone de cambio suficiente o el dinero introducido no es suficiente";
    	}
        if (this.cafe >= 1 && this.leche >= 1 && this.vasos >= 1) {
            this.cafe -= 1;
            this.leche -= 1;
            this.vasos -= 1;
            this.monedero += 1.5;
            return "Aquí tiene su café con leche. ¡Disfrútelo!";
        } else {
            return "Lo siento, no hay café, leche o vasos disponibles.";
        }
    }

    public String mostrarDepositos() {
        return "Depósito de café: " + this.cafe + " dosis"+
        "Depósito de leche: " + this.leche + " dosis"+
        "Depósito de vasos: " + this.vasos + " vasos";
    }

    public String mostrarMonedero() {
        return "El monedero tiene " + this.monedero + " euros";
    }
}
