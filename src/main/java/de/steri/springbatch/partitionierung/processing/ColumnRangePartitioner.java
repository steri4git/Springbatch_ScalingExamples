package de.steri.springbatch.partitionierung.processing;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class ColumnRangePartitioner implements Partitioner {
	
		public Map<String, ExecutionContext> partition(int gridSize) {
			int min = 0;
			int max = 1000;
			int targetSize = (max - min) / gridSize + 1;

			Map<String, ExecutionContext> result = new HashMap<String, ExecutionContext>();
			int number = 0;
			int start = min;
			int end = start + targetSize - 1;

			while (start <= max) {
				ExecutionContext value = new ExecutionContext();
				result.put("partition" + number, value);

				if (end >= max) {
					end = max;
				}
				value.putInt("minValue", start);
				value.putInt("maxValue", end);
				start += targetSize;
				end += targetSize;
				number++;
			}
			System.out.println("Partitioner " + result.size());
			for (int i = 0; i < result.size(); i++) {
				System.out.println("partition" + i+ " min=" +result.get("partition"+i).get("minValue"));
				System.out.println("partition" + i+ " max=" +result.get("partition"+i).get("maxValue"));
			}
			return result;
		}
	}
