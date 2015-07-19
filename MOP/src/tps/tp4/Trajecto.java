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
	
	public ArrayList<Elemento> getColocados(){
		return colocados;
	}
	
	public Elemento getUltimoElemento(){
		if (colocados != null && !colocados.isEmpty()) {
			return colocados.get(colocados.size()-1);
			}
		return null;
	}
	
	public Elemento getPenultimoElemento(){
		if (colocados != null && colocados.size() >= 2) {
			return colocados.get(colocados.size()-2);
			}
		return null;
	}
	
	
	
	public void setUltimoElemento(Elemento elemento){
		colocados.set(colocados.size()-1,elemento);
	}
	
	public boolean estaVazio(){
		if(colocados.isEmpty()){
			return true;
		}
		return false;
	}
	
	
	

}
