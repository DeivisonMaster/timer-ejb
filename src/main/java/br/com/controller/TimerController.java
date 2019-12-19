package br.com.controller;

import java.util.Collection;

import javax.ejb.Timer;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.model.Calendario;
import br.com.model.TimerTest;

@Named("timerController")
@RequestScoped
public class TimerController {
	private TimerTest timerTeste;
	private Calendario calendario;
	
	
	public TimerController() {
		this.timerTeste = new TimerTest();
		this.calendario = new Calendario();
	}
	
	
	public String agendar() {
		this.timerTeste.configuraAgendamento(calendario.getNome(), calendario.getHora(), 
				calendario.getMinuto(), calendario.getSegundo());
		
		return "Timers.xhtml";
	}
	
	public void cancelar(Timer timer) {
		timer.cancel();
	}
	
	public Collection<Timer> buscarTodos(){
		return timerTeste.buscarTodos();
	}

	public TimerTest getTimerTeste() {
		return timerTeste;
	}

	public void setTimerTeste(TimerTest timerTeste) {
		this.timerTeste = timerTeste;
	}

	public Calendario getCalendario() {
		return calendario;
	}

	public void setCalendario(Calendario calendario) {
		this.calendario = calendario;
	}
	
}
