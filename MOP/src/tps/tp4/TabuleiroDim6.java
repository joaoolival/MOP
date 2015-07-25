package tps.tp4;

import java.io.File;
import java.io.FileNotFoundException;

public class TabuleiroDim6 extends Tabuleiro{
	private static final long serialVersionUID = 6784824663872156802L;

	public TabuleiroDim6(File file) throws FileNotFoundException{
		super(6,6,file);
	}

}