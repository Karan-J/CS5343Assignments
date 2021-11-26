
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.UnexpectedException;
import java.util.ArrayList;
import java.util.List;

public class Assignment6 {

	public static void main(String[] args) {

		// get list of words from a file
		List<String> words = getListOfWords();
		System.out.println(words);

		Integer tableSize = 31;
		MyHashTable hashTable = new MyHashTable(tableSize);
		Integer collisionsInTableSize31 = 0;
		Integer collisionsInTableSize67 = 0;

		try {
			// insert words into a hash table
			insertWordsIntoTable(words, hashTable);

			// catch an exception from insert.
		} catch (UnexpectedException e) {
			collisionsInTableSize31 = hashTable.totalNumberOfCollisions;
			hashTable.printHashTable();
			System.out.println("Number of Collisions In Table-Size 31 = " + collisionsInTableSize31);
			System.out.println("############################## Rehashing the table ##############################");

			// re-initialise the hashTable with new size
			// insert each word again in the table
			int nextPrimeNumber = 67; // next prime number greater than double the initial table size
			hashTable = new MyHashTable(nextPrimeNumber);
			try {
				insertWordsIntoTable(words, hashTable);
			} catch (UnexpectedException e1) {
				e1.printStackTrace();
			}
		}

		collisionsInTableSize67 = hashTable.totalNumberOfCollisions;
		hashTable.printHashTable();
		System.out.println("Number of Collisions In Table-Size 67 = " + collisionsInTableSize67);

		// print number of collisions at the end. attach screenshots
		int totalNumberOfCollisions = collisionsInTableSize31 + collisionsInTableSize67;
		System.out.println("Total Number of Collisions So Far = " + totalNumberOfCollisions);

	}

	public static void insertWordsIntoTable(List<String> words, MyHashTable hashTable) throws UnexpectedException {
		for (String word : words) {
			hashTable.insert(word);
		}
	}

	public static List<String> getListOfWords() {
		List<String> words = new ArrayList<>();
		try {
			String fileName = "words.txt";
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String word;
			while ((word = br.readLine()) != null) {
				words.add(word);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return words;
	}

}
