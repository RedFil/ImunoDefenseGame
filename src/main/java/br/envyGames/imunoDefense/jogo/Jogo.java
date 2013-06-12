package br.envyGames.imunoDefense.jogo;

import br.envyGames.imunoDefense.motor.Cenario;
import br.envyGames.imunoDefense.motor.JogoMotor;

public class Jogo implements Runnable
{	
	private static final int WIDTH = 800;
	private static final int HEIGHT = 540;

	private JogoMotor motor;

	public void setup() {
		inicializarSistema();
		motor.criarJanela(WIDTH, HEIGHT);		
	}
	
	@Override
	public void run() {  		
		 //cria o cen�rio INTRO LOGO
		 Cenario logo = new LogoCenario(WIDTH, HEIGHT);
		 motor.adicionarCenario(logo);
		
		 //cria o cen�rio MENU
		 Cenario menu = new MenuCenario(WIDTH, HEIGHT);
		 motor.adicionarCenario(menu);
		 
		 //cria o cen�rio JOGO
		 Cenario jogo = new JogoCenario(WIDTH, HEIGHT);
		 motor.adicionarCenario(jogo);
		 
		 //cria o cen�rio INSTRU��ES
		 Cenario instrucoes = new InstrucoesCenario(WIDTH, HEIGHT);
		 motor.adicionarCenario(instrucoes);
		 
		 //cria o cen�rio CR�DITOS
		 Cenario creditos = new CreditosCenario(WIDTH, HEIGHT);
		 motor.adicionarCenario(creditos);
		 
		 motor.exibirJanela();
		 motor.inicializar();
		 
		 motor.loadCenario(logo.getScenarioId());
		 
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 motor.loadCenario(menu.getScenarioId());
		 

		 
		/*
		 Cenario jogo = new JogoCenario(WIDTH, HEIGHT);
		 motor.adicionarCenario(jogo);
		 motor.loadCenario(jogo.getScenarioId());
		 */
	}
	
	private void inicializarSistema() {
		motor = new JogoMotor();
				 
	}
}
