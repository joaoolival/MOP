package tps.tp4;

import java.io.File;
import java.io.FileNotFoundException;

public class TabuleiroDim7 extends Tabuleiro{
	private static final long serialVersionUID = 6784824663872156802L;

	public TabuleiroDim7(File file) throws FileNotFoundException{
		super(7,7,file);
	}

}