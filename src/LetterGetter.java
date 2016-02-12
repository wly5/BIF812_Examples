/**
 * our first interface
 * recall that interfaces only delcare method signatures without implementations
 * (everything is already implied as abstract)
 * @author marek
 *
 */
public interface LetterGetter {
	/**
	 * this class is assumed to have a gene sequence (someplace)
	 * it will return the letter at the specified position
	 * @param position indicates the desired position of a letter
	 * @return the letter at the indicated position
	 */
	public char getLetter(int position);//NO IMPLEMENTATION!
}
