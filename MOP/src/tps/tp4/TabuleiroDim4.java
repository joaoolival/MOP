package tps.tp4;

import java.io.File;
import java.io.FileNotFoundException;

public class TabuleiroDim4 extends Tabuleiro {
	private static final long serialVersionUID = 6784824663872156802L;

	public TabuleiroDim4(File file) throws FileNotFoundException {
		super(4, 4, file);
	}

}
