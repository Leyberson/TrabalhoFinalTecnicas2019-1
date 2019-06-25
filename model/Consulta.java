package model;

import java.util.Date;

public class Consulta implements java.io.Serializable{
	Paciente paciente;
	Medico medico;
	Calendar calendar = Calendar.getInstance();

	public Consulta (Paciente paciente, Medico medico, int dia, int mes, int ano, int hora){
		this.paciente = paciente;
		this.medico = medico;
		calendar.set(Calendar.DAY_OF_MONTH, dia);
		calendar.set(Calendar.MONTH, mes);
		calendar.set(Calendar.YEAR, ano);
		calendar.set(Calendar.HOUR_OF_DAY, hora);
	}

	public String toString(){
		return calendar.get(Calendar.DAY_OF_MONTH) +"/"
		+calendar.get(Calendar.MONTH) +"/"
		+calendar.get(Calendar.YEAR) +" as "
		+calendar.get(Calendar.HOUR_OF_DAY);
	}
}