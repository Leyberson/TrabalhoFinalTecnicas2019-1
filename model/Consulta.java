package model;

import controller.*;
import view.*;

import java.time.LocalDateTime;


public class Consulta implements java.io.Serializable{
	Paciente paciente;
	Medico medico;
	LocalDateTime horario;

	public Consulta (Paciente paciente, Medico medico, int dia, int mes, int ano, int hora){
		this.paciente = paciente;
		this.medico = medico;
		horario = LocalDateTime.of(ano, mes, dia, hora, 0);
        }
        
        public LocalDateTime getHorario(){
            return this.horario;
        }
        
        public boolean equals(Consulta outra){
            return (this.paciente.equals(outra.paciente) && this.medico.equals(outra.medico) &&
                    this.horario.equals(outra.horario));
        }
        
}