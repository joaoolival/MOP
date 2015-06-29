package tps.tp4;

import java.awt.Color;





public class Quadricula {
	static final Color BACKGROUNDCOLOR = new Color(100, 100, 100);
	
	private int x;
	private int y;
	private Elemento elemento;

	public Quadricula(int x, int y) {
		this.x = x;
		this.y = y;
		this.elemento = new ElementoVazio();
	}

	int getTabX() {
		return x;
	}

	int getTabY() {
		return y;
	}
	
	public Elemento getElemento(){
		return elemento;
	}
	
	public void setElemento(Elemento elemento){
		this.elemento = elemento;
		
	}


}


