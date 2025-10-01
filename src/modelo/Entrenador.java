package modelo;

import java.util.Objects;

public class Entrenador {
	private int idEntrenador;
    private String estrategiaFavorita;

    public Entrenador(int idEntrenador, String estrategiaFavorita) {
    	this.idEntrenador = idEntrenador;
        this.estrategiaFavorita = estrategiaFavorita;
    }
    
    public int getIdEntrenador() {
		return idEntrenador;
	}

	private void setIdEntrenador(int idEntrenador) {
		this.idEntrenador = idEntrenador;
	}

	public String getEstrategiaFavorita() {
        return estrategiaFavorita;
    }

    public void setEstrategiaFavorita(String estrategiaFavorita) {
        this.estrategiaFavorita = estrategiaFavorita;
    }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrenador other = (Entrenador) obj;
		return Objects.equals(estrategiaFavorita, other.estrategiaFavorita);
	}
    
}
