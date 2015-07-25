package tps.tp4;

import java.io.File;
import java.io.FileNotFoundException;

public class TabuleiroDim9 extends Tabuleiro{
	private static final long serialVersionUID = 6784824663872156802L;

	public TabuleiroDim9(File file) throws FileNotFoundException{
		super(9,9,file);
	}

}