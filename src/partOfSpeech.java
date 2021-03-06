import java.io.*;
import java.util.Scanner;

public class partOfSpeech {	
	public static void main(String[] args) throws IOException {
		File inFile = new File ("partOfSpeech.dat");
		Scanner scan = new Scanner(inFile); //the partOfSpeech text
		String[] nounWords = scan.nextLine().split(" ");
		String verbWordsInit = scan.nextLine() + " " + scan.nextLine();
		String[] verbWords = verbWordsInit.split(" ");
		int dataSets = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < dataSets; i++) { //work for a set
			String[] toSearch = scan.nextLine().toLowerCase().split(" ");
			int indivSets = Integer.parseInt(toSearch[1]);
			int indexOfSearch = 0;
			for (int j = 0; j < indivSets; j++) {
				String currString[] = scan.nextLine().split(" ");
				currString[currString.length-1] = currString[currString.length-1].replace(".", "");
				currString[currString.length-1] = currString[currString.length-1].replace("!", "");
				currString[currString.length-1] = currString[currString.length-1].replace("?", "");
				for (int a = 0; a < currString.length; a++) { //finds where string to search for is
					if (currString[a].equals(toSearch[0])) {
						indexOfSearch = a;
					}
				}
				for (int e = 0; e < nounWords.length-1; e++) {
					if (currString[indexOfSearch-1].equalsIgnoreCase(nounWords[e])) {
						System.out.println("NOUN");
					}
				}
				for (int e = 0; e < verbWords.length-1; e++) {
					if (currString[indexOfSearch-1].equalsIgnoreCase(verbWords[e])) {
						System.out.println("VERB");
					}
				}
			}
			System.out.println();
		}
		scan.close();
	}
}