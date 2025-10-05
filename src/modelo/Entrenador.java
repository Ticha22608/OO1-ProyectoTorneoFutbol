package modelo;

import java.time.LocalDate;
import java.util.Objects;

public class Entrenador extends Persona{
    private String estrategiaFavorita;

    public Entrenador(int idPersona, String nombre, String apellido, long dni, LocalDate fechaNacimiento, String estrategiaFavorita) {
    	super(idPersona, nombre, apellido, dni, fechaNacimiento);
        this.estrategiaFavorita = estrategiaFavorita;
    }

	public String getEstrategiaFavorita() {
        return estrategiaFavorita;
    }

    public void setEstrategiaFavorita(String estrategiaFavorita) {
        this.estrategiaFavorita = estrategiaFavorita;
    }



	@Override
	public String toString() {
		return "Entrenador [estrategiaFavorita=" + estrategiaFavorita + ", " + super.toString() + "]\n";
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
