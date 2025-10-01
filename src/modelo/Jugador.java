package modelo;

public class Jugador {
	private int idJugador;
    private double estatura;
    private double peso;
    private String posicion;
    private int numCamiseta;

    public Jugador(int idJugador, double estatura, double peso, String posicion, int numCamiseta) {
        this.idJugador=idJugador;
    	this.estatura = estatura;
        this.peso = peso;
        this.posicion = posicion;
        this.numCamiseta = numCamiseta;
    }
    
    public int getIdJugador() {
		return idJugador;
	}

	private void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}

	public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getNumCamiseta() {
        return numCamiseta;
    }

    public void setNumCamiseta(int numCamiseta) {
        this.numCamiseta = numCamiseta;
    }
    
    
}
