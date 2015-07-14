package tps.tp4;

import java.awt.Color;

import javax.swing.JLabel;

public abstract class Elemento extends JLabel {
	private static final long serialVersionUID = -3509712629827253893L;
	static final Color BACKGROUNDCOLOR = new Color(50, 50, 50);
	
	protected Color cor;

	public Elemento(Color cor) {
		this.cor = cor;
		setOpaque(true);
		
		setBackground(BACKGROUNDCOLOR);
		//setText("enter text here");
		//setForeground (Color.red);

	}
	
	protected abstract String getNome();
	
	/*@Override
	protected abstract void paintComponent(Graphics g);*/
	enum Colors {
		Color1(203, 37, 41),
		Color2(198, 86, 49),
		Color3(200, 123, 31),
		Color4(201, 174, 41),
		Color5(180, 193, 43),
		Color6(132, 199, 34),
		Color7(85, 204, 50),
		Color8(69, 185, 52),
		Color9(37, 198, 84),
		Color10(40, 198, 124),
		Color11(44, 194, 169),
		Color12(55, 179, 213),
		Color13(35, 131, 207),
		Color14(42, 94, 214),
		Color15(38, 35, 202),
		Color16(81, 42, 197),
		Color17(122, 42, 191),
		Color18(169, 34, 198),
		Color19(168, 32, 132),
		Color20(201, 39, 142);
		
		
		private int red;
	    private int blue;
	    private int green;

	    private Colors(int r, int g, int b) {
	        this.red = r;
	        this.green = g;
	        this.blue = b;
	    }
	    
	    public int getRedValue() {
	        return red;
	    }

	    public int getBlueValue() {
	        return blue;
	    }

	    public int getGreenValue() {
	        return green;
	    }
		// PRIMAVERA(), VERAO(), OUTONO(), INVERNO()
	}

}


