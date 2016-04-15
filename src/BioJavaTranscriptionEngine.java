import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JFileChooser;

import org.biojava.nbio.core.sequence.DNASequence;
import org.biojava.nbio.core.sequence.compound.AmbiguityDNACompoundSet;
import org.biojava.nbio.core.sequence.compound.AmbiguityRNACompoundSet;
import org.biojava.nbio.core.sequence.compound.AminoAcidCompound;
import org.biojava.nbio.core.sequence.compound.NucleotideCompound;
import org.biojava.nbio.core.sequence.io.FastaReaderHelper;
import org.biojava.nbio.core.sequence.template.CompoundSet;
import org.biojava.nbio.core.sequence.template.Sequence;
import org.biojava.nbio.core.sequence.transcription.Frame;
import org.biojava.nbio.core.sequence.transcription.TranscriptionEngine;

/**
 * this program demonstrates using the BioJava transcription engine
 * to work with a FASTA file
 * @author gares
 *
 */
public class BioJavaTranscriptionEngine {

	public static void main(String[] args) {
		//first let's declare some data structures to hold our data
		//LinkedHashMap will be used to hold the dnaSequence read from the FASTA file
		LinkedHashMap<String, DNASequence> dnaSequences = null;
		//FastaReaderHelper is a convenience class provided by BioJava to read FASTA files
		//but first lets let the user choose an input file
		final JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(null);
		//pass the selected file to the loadSequenceFromFile method
		String filename = fc.getSelectedFile().getAbsolutePath();
		try {
			dnaSequences = FastaReaderHelper.readFastaDNASequence(new File(filename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//define the ambiguity compound sets by calling the static method (see notes)
		AmbiguityDNACompoundSet dnaCompoundSet = AmbiguityDNACompoundSet.getDNACompoundSet();
		/*
		 * get the nucleotide compound set from the RNA compound set and store the result
		 * in a CompoundSet object
		 */
		CompoundSet<NucleotideCompound> rnaCompoundSet = AmbiguityRNACompoundSet.getDNACompoundSet();
		//initalize the Transcription engine using the compound sets (using a factory)
		TranscriptionEngine engine = new TranscriptionEngine.Builder().dnaCompounds(dnaCompoundSet).rnaCompounds(rnaCompoundSet).build();
		//declare an array of frames to store each frame
		Frame[] sixFrames = Frame.getAllFrames();
		//for each dna dequence in dnaSequences - use a for-each statement
		for(DNASequence dna: dnaSequences.values()){
			//translate each
			//create a Map to store the results of the transcription
			Map<Frame, Sequence<AminoAcidCompound>> results = engine.multipleFrameTranslation(dna, sixFrames);
			//display the rsults
			//for each frame in the array of frames...
			for(Frame frame : sixFrames){
				System.out.println("Translated frame: " + frame + " : " + results.get(frame));
			}
		}
		
		System.out.println("Program completed successfully");

	}

}
