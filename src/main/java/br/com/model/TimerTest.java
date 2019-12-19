package br.com.model;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;


@Singleton
public class TimerTest {
	
	@Resource
	private TimerService timerService;
	
	
	public void configuraAgendamento(String nome, String hora, String minuto, String segundo) {
		TimerConfig config = new TimerConfig();  // configura nome ao Timer
		config.setInfo(nome);
		
		ScheduleExpression expression = new ScheduleExpression();
		expression.hour(hora);
		expression.minute(minuto);
		expression.second(segundo);
		
		this.timerService.createCalendarTimer(expression, config);
		
		Logger.getLogger(TimerTest.class.getName()).log(Level.INFO, "EXECUTANDO TAREFA AGENDADA");
	}
	
	
	//@Schedule(hour = "*", minute="*", second="*/1")
	@Timeout
	public void executaTarefa() {
		Logger.getLogger(TimerTest.class.getName()).log(Level.INFO, "EXECUTANDO TAREFA");
	}
	
	
	public Collection<Timer> buscarTodos(){
		Collection<Timer> timers = timerService.getAllTimers();
		
		return timers;
	}
}





























