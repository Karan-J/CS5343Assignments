
import java.rmi.UnexpectedException;
import java.util.HashMap;
import java.util.Map;

public class MyHashTable {

	Integer tableSize = 0;
	Integer currentSize = 0;
	String[] keys;

	Double loadFactor;
	Integer totalNumberOfCollisions;
	static Map<Integer, Integer> keysCollisionsMap = new HashMap<>();

	public MyHashTable(Integer capacity) {
		super();
		this.tableSize = capacity;
		this.keys = new String[tableSize];
		this.totalNumberOfCollisions = 0;
	}

	// quadratic probing
	// initial table size = 31
	// increase table size and rehash at load factor of 0.5 automatically
	// this should happen when 15 or 16 records are inserted

	public void insert(String word) throws UnexpectedException {
		int hashValue = getHashValueFromKey(word);
		int i = hashValue;
		int temp2 = 1;
		int numberOfCollisions;
		int temp = this.currentSize + 1;
		loadFactor = updateLoadFactor(temp, tableSize);
		int position = hashValue;

		if (loadFactor - 0.5 < 0) {

			// checking if the location is already occupied
			if (keys[hashValue] != null) {

				// storing the total number of collisions
				totalNumberOfCollisions++;

				// storing the number of collisions for each hashValue
				if (!keysCollisionsMap.containsKey(hashValue)) {
					keysCollisionsMap.put(hashValue, 1);
				}

				numberOfCollisions = keysCollisionsMap.get(hashValue);
				if (numberOfCollisions == 1) {
					temp2 = numberOfCollisions * numberOfCollisions;
					position = hashValue + temp2;
				}

				// System.out.println("------- colli->"+keysCollisionsMap + " h->" + hashValue +
				// " t->" + temp2);
				while (keys[position] != null) {
					numberOfCollisions++;
					keysCollisionsMap.put(hashValue, numberOfCollisions);
					temp2 = numberOfCollisions * numberOfCollisions;
					if ((position + temp2) > tableSize) {
						position = (hashValue + temp2) % tableSize;
					} else {
						position = hashValue + temp2;
					}
					// System.out.println(word + " " + hashValue + /*temp2 +*/ " " +keys[position]);
				}
			}

			// finally storing the key at the position
			keys[position] = word;
			currentSize++;
			// System.out.println(i + " w:" + keys[position] + " h=" + hashValue + " pos=" +
			// position + " totalColl=" + totalNumberOfCollisions + " " +keysCollisionsMap);
		} else {
			// printHashTable();
			// need to increase the tableSize
			System.out
					.println("!!!!!!!!!!!! Load-factor greater than 0.5. Need to increase the table size !!!!!!!!!!!!");
			throw new UnexpectedException("Need to increase the table size");
		}
	}

	public Double updateLoadFactor(int currentSize, int tableSize) {
		return (currentSize * 1.0) / tableSize;
	}

	public int getHashValueFromKey(String word) {
		return Math.abs(word.hashCode() % tableSize);
	}

	public void printHashTable() {
		System.out.println("%%%%%%%%%%% Printing the hashtable %%%%%%%%%%%%%%");
		System.out.println("Index\tWord");
		for (int i = 0; i < tableSize; i++) {
			if (keys[i] != null) {
				System.out.println(i + "\t" + keys[i]);
			}
		}
	}

	public Integer getTableSize() {
		return tableSize;
	}

	public Integer getCurrentSize() {
		return currentSize;
	}

}
