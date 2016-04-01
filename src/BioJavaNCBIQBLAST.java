import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.biojava.nbio.core.sequence.io.util.IOUtils;
import org.biojava.nbio.ws.alignment.qblast.BlastProgramEnum;
import org.biojava.nbio.ws.alignment.qblast.NCBIQBlastAlignmentProperties;
import org.biojava.nbio.ws.alignment.qblast.NCBIQBlastOutputProperties;
import org.biojava.nbio.ws.alignment.qblast.NCBIQBlastService;

/**
 * this calss demonstrates how to perform a blast quiery remotely using
 * the NCBI Qblast web service
 * to access web services we need to include yet another jar file
 * it's here: bj4.0.0/biojava-ws/target/biojava-ws-4.0.0.jar
 * @author gares
 *
 */
public class BioJavaNCBIQBLAST {

	public static void main(String[] args) {
		//this is an example sequence that we will pass to the blast service
		String sequence = "PYRTWNYHGSYDVKPTGSASSLVNGVVRLLSKPWDTITNVTTMAMTDTTPFGQQRVF"; //mystery sequence
		String outputFile = "blast.xml"; //store output in this file for further processing (via XML parser hint hint)

		//the NCBIQBlastService class encapsulates the complexity related to connecting to the web service
		//declare a reference to the blast service
		NCBIQBlastService blastService = new NCBIQBlastService();
		//we need to do a few things before using
		//1) set the alignment properties - the ones we will touch represent only some properties
		//there are more!
		NCBIQBlastAlignmentProperties alignmentProperties = new NCBIQBlastAlignmentProperties();
		//set the program
		alignmentProperties.setBlastProgram(BlastProgramEnum.blastp);
		//set the database
		alignmentProperties.setBlastDatabase("swissprot");
		//set the output options using the appropriate class - leave the defaults for now..
		NCBIQBlastOutputProperties outputProperties = new NCBIQBlastOutputProperties();
		//each request to NCBI Blast service has a unique ID, store it in a string
		String requestID = null; ///this will be provided by the API
		//we're going to need a FileWriter in order to output the results to a file
		FileWriter writer = null;
		//also need a reader to read results from the service
		BufferedReader reader = null;
		//send the alignment request and remember the request id for later
		try {
			requestID = blastService.sendAlignmentRequest(sequence, alignmentProperties);
			//patiently wait for a result from the service!
			//the method blastService.isReady() quieries the remote web service
			//using the provided ID to determine whether the results are ready
			while(!blastService.isReady(requestID)){
				System.out.println("Waiting for results, updating in 10 seconds");
				Thread.sleep(10000);//sleep for 10 seconds
			}
			System.out.println("Finally got some results!\n");
			//now we're ready to actually get those results
			InputStream in = blastService.getAlignmentResults(requestID, outputProperties);
			//associate the input stream with our buffered reader
			reader = new BufferedReader(new InputStreamReader(in));
			//write the results to the output file
			File file = new File(outputFile);
			System.out.println("outputting results to " + outputFile);
			writer = new FileWriter(file);
			String temp;
			while((temp = reader.readLine()) != null){
				writer.write(temp + System.getProperty("line.separator"));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//clean up our objects
			IOUtils.close(writer);
			IOUtils.close(reader);
			//it's good practice to tell the NCBI server that your results don't need to be cached anymore;
			//they can be safely deleted from the server
			blastService.sendDeleteRequest(requestID);
		}
		
		System.out.println("Program completed successfully");
		
		
		
	}

}
