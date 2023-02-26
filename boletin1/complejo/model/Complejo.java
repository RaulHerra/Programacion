package boletin1.complejo.model;

public class Complejo {
    private double parteReal;
    private double parteImaginaria;

    public Complejo(double parteReal, double parteImaginaria) {
        this.parteReal = parteReal;
        this.parteImaginaria = parteImaginaria;
    }

    public Complejo suma(Complejo otroComplejo) {
        double sumaParteReal = this.parteReal + otroComplejo.parteReal;
        double sumaParteImaginaria = this.parteImaginaria + otroComplejo.parteImaginaria;
        return new Complejo(sumaParteReal, sumaParteImaginaria);
    }

    public Complejo resta(Complejo otroComplejo) {
        double restaParteReal = this.parteReal - otroComplejo.parteReal;
        double restaParteImaginaria = this.parteImaginaria - otroComplejo.parteImaginaria;
        return new Complejo(restaParteReal, restaParteImaginaria);
    }

    public String mostrar() {
        return ("(" + this.parteReal + "," + this.parteImaginaria + ")");
    }

    public boolean equals(Complejo otroComplejo) {
        return (this.parteReal == otroComplejo.parteReal && this.parteImaginaria == otroComplejo.parteImaginaria);
    }
}