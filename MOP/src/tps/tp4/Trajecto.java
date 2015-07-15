package tps.tp4;

import java.util.ArrayList;

public class Trajecto {
	private ArrayList<Elemento> colocados = new ArrayList<Elemento>();
	private Tabuleiro tabuleiro;
	
	public Trajecto(Tabuleiro tabuleiro){
		this.tabuleiro = tabuleiro;
	}
	
	public void setElemento(Elemento elemento){
		colocados.add(elemento);
	}
	public void apagaElemento(Elemento elemento){
		colocados.remove(elemento);
	}
	public Elemento getElemento(int x, int y){
		for(Elemento elementoColocado: colocados){
			if(elementoColocado.equals(tabuleiro.getQuadricula(x, y).getElemento())){
				return elementoColocado;
			}
		}
		return null;
	}
	
	

}
