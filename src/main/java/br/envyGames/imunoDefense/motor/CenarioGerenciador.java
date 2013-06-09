package br.envyGames.imunoDefense.motor;

import s3t.gameControl.system.GameSystem;

public class CenarioGerenciador {
	
	public void adicionarCenario(Cenario cenario) {
		GameSystem.getScenarioCollection().addScenario(cenario);
	}
	
	public void removerCenario(String id) {
		GameSystem.getScenarioCollection().removeScenario(id);
	}
	
	public void loadCenario(String cenarioID) {
		GameSystem.getScenarioCollection().setScenarioAtual(cenarioID);
	}

}