package de.steri.springbatch.parallelstep.processing;

import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

/**
 * {@link ItemReader} with hard-coded input data.
 */

@Component("reader1")
public class Reader1 implements ItemReader<String> {
	
	private String[] input = {"Hello 1", "Hello 2","Hello 3","Hello 4","Hello 5","Hello 6",};
	
	private int index = 0;
	
	/**
	 * Reads next record from input
	 */
	public String read() throws Exception {
		System.out.println("READER 1 AUFFERUFEN");
		if (index < input.length) {
			System.out.println("Lese Thread: " + Thread.currentThread().getId() + " lese: " + input[index]);
			return input[index++];
		}
		else {
			return null;
		}
		
	}
}
