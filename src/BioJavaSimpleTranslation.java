import org.biojava.nbio.core.exceptions.CompoundNotFoundException;
import org.biojava.nbio.core.sequence.DNASequence;
import org.biojava.nbio.core.sequence.ProteinSequence;
import org.biojava.nbio.core.sequence.RNASequence;
import org.biojava.nbio.core.sequence.transcription.Frame;

/**
 * this program illustrates using BioJava classes to do a simple frame translation
 * its correct operation depends on the inclusion of several external JAR files
 * (See slides for details)
 * @author gares
 *
 */
public class BioJavaSimpleTranslation {

	public static void main(String[] args) throws CompoundNotFoundException {
		//let's use the DNASequence class to store a DNA Sequence
		//note that the BioJava DNASequence class will throw an exception
		//if letters besides ACGT are used!
		DNASequence dna = new DNASequence("CTATTGCAAGGGGCTCTACAAACCCCGTTTTTCACAAGGGGTATCCCCGAACTGGCCGATGTGCGACTTG");
		System.out.println("Using dna sequence: " + dna);
		//translate the DNA to RNA using the specified frame
		RNASequence rna = dna.getRNASequence(Frame.TWO);
		System.out.println("translated to RNA: " + rna.toString());
		//translate it to a protein sequence
		ProteinSequence protein = rna.getProteinSequence();
		System.out.println("The translated protein sequence is: " + protein.toString());
	}

}
