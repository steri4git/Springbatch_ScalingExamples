package de.steri.springbatch.partitionierung.processing;

import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

/**
 * {@link ItemReader} with hard-coded input data.
 */

public class Reader1 implements ItemReader<String> {

	private int min;
	private int max;

	private int anzahl;
	private int index = 0;

	private String[] input;

	/**
	 * Reads next record from input
	 */
	public String read() throws Exception {
		anzahl = max - min;
		int zaehler = min;
		if (input == null) {
			input = new String[anzahl];
			System.out.println("READER 1 AUFFERUFEN: " + min + " " + max);

			for (int i = 0; i < anzahl; i++) {
				input[i] = new String("Hello " + zaehler);
				zaehler++;
			}
			System.out.println("Array erzeugt: " + input.length);
		}

		if (index < input.length) {
			System.out.println("Lese Thread: " + Thread.currentThread().getId() + " lese: " + input[index]);
			Thread.sleep(200);
			return input[index++];
		} else {
			return null;
		}
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}
}
