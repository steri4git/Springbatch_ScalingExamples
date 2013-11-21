package de.steri.springbatch.threadedstep.processing;

import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

/**
 * {@link ItemReader} with hard-coded input data.
 */

@Component("itemReader1")
public class Reader1 implements ItemReader<String> {
	
	int anzahl = 1000;
	//int zaehler =1;
		
	//private String[] input = {"Hello 1", "Hello 2","Hello 3","Hello 4","Hello 5","Hello 6",};
	private String[] input= new String[anzahl];
	
	private int index = 0;
	
	/**
	 * Reads next record from input
	 */
	public String read() throws Exception {
		
		for (int i = 0; i < anzahl; i++) {
			input[i]= new String("Hello "+ i);
		}
		
		
		System.out.println("READER 1 AUFFERUFEN");
		if (index < input.length) {
			Thread.sleep(500);
			return input[index++];
		}
		else {
			return null;
		}
		
	}
}
