package tps.tp4;

import java.io.File;
import java.io.FileNotFoundException;

public class TabuleiroDim5 extends Tabuleiro{
	private static final long serialVersionUID = 6784824663872156802L;

	public TabuleiroDim5(File file) throws FileNotFoundException{
		super(5,5,file);
	}

}
