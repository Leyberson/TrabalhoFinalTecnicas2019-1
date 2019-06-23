package model;

import java.util.Date;

public class Consulta implements java.io.Serializable{
	Paciente paciente;
	Medico medico;
	Date data;

	public Consulta (Paciente paciente, Medico medico, Date data){
		this.paciente = paciente;
		this.medico = medico;
		this.data = data;
	}
}