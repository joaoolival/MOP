package tps.tp4;

import java.io.File;
import java.io.FileNotFoundException;

public class TabuleiroDim8 extends Tabuleiro {
	private static final long serialVersionUID = 6784824663872156802L;

	public TabuleiroDim8(File file) throws FileNotFoundException {
		super(8, 8, file);
	}

}