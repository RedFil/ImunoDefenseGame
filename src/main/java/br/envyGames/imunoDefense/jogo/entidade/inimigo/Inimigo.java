/*
 * This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.envyGames.imunoDefense.jogo.entidade.inimigo;

import java.awt.Point;

import br.envyGames.imunoDefense.jogo.Tabuleiro;
import br.envyGames.imunoDefense.jogo.entidade.FormaDeVida;
import br.envyGames.imunoDefense.motor.Cenario;

enum Direcao {
	BAIXO, CIMA, DIREITA, ESQUERDA;
}

/*
 * Classe abstrata base dos inimigos
 */
public abstract class Inimigo extends FormaDeVida {
	protected TipoLocomocao tipoLocomocao;
	protected int bonusDinheiroToKill;
	protected int bonusScoreToKill;
	protected int forca = 1;
	private float velocidadeNatural = 32;
	private float lentidao = 1;
	private Direcao direcao = Direcao.DIREITA;
	
	
	/*
	 * Construtor<br/>
	 * Por padr�o os inimigos iniciam com for�a 1, velocidade 1 e com 2 de vida.
	 * @param <code>name</code> - Nome do inimigo do qual ser� usado para encontra-lo na EntityCollection.
	 * @param <code>xy</code>   - Coordenadas "(x, y)" iniciais. 
	 */
	public Inimigo(String name, Point xy, Cenario cenario) {
		super(name, new Point(Tabuleiro.getTabuleiroAtual().converteCoordToTab(xy.x), Tabuleiro.getTabuleiroAtual().converteCoordToTab(xy.y)), cenario);
	}
	
	// Getters & Setters
	public int getForca() { return forca; }
	public float getVelocidade() { return velocidadeNatural * lentidao; }
	public Direcao getDirecao() { return direcao; }
	public TipoLocomocao getTipoLocomocao() { return tipoLocomocao; }
	public int getBonusDinheiroToKill()  { return bonusDinheiroToKill; }
	public int getBonusScoreToKill() { return bonusScoreToKill; }
	
	public void setForca(int dano) { forca = dano; }
	public void setVelocidadeNormal(int vel) { velocidadeNatural = vel; }
	public void setDirecao(Direcao novaDirecao) { direcao = novaDirecao; }
	
	/*
	 * Aplica efeito de lentid�o nesta unidade
	 * @param <code>porcentagem</code> - Quantos porcentos ser�o removidos da velocidade (0~1)
	 */
	public void addSlow(float porcentagem) {
		if(lentidao < (1 - porcentagem))
			lentidao = 1 - porcentagem;
	}
	public void removeSlow() {
		lentidao = 1;
	}
}
