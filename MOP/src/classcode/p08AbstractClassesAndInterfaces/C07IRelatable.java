package classcode.p08AbstractClassesAndInterfaces;

/**
 * Interface que permite comparar dois objectos de classes que a implementem. Os
 * n�meros suportados s�o compostos s� por d�gitos.
 */
public interface C07IRelatable {

	String getValue();

	boolean isEquals(C07IRelatable other);

	boolean isBiggerThan(C07IRelatable other);

	boolean isSmallerThan(C07IRelatable other);
}
