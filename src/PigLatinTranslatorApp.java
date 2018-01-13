import java.util.ArrayList;
import java.util.Scanner;

public class PigLatinTranslatorApp {

	private static String line = "";
	private static String[] lineParts;
	private static ArrayList<String> lineParts2 = new ArrayList<>();
	private static ArrayList<String> linePartsTranslated = new ArrayList<>();
	
	public static void main(String[] args) {
		System.out.println("Pig Latin Translator\n");
		
		Scanner sc = new Scanner(System.in);		
		String choice = "y";
		
		while(choice.equalsIgnoreCase("y")) {
			line = ConsolePigLatTr.getString("Enter a line: ");	
			lineParts = line.toLowerCase().split(" ");		
			linePartsTranslated = translateToPigLatin(lineParts);	
			System.out.println("\nPig Latin translation: ");
			for (String pigWord: linePartsTranslated)
				System.out.print(pigWord + " ");
			
			choice = ConsolePigLatTr.getString("\n\nAnother line? (y/n): ", "y", "n");
			System.out.println();
		}
		
		System.out.println("Bye!");
		sc.close();
	}
	
	public static ArrayList<String> translateToPigLatin(String[] words) {
		lineParts2.clear();
		linePartsTranslated.clear();
		
		for (String word: words) {
			if (word.endsWith(".") || word.endsWith(",") || word.endsWith("!") ||
				word.endsWith(";") || word.endsWith(":") || word.endsWith("?") ||
				word.endsWith("?") || word.endsWith(")") )						{			
				word = word.substring(0, (word.length()-1));
				lineParts2.add(word);				
			}
			else if (word.startsWith("(")) {
				word = word.substring(1, word.length()-1);
				lineParts2.add(word);		
			}
			else {
				lineParts2.add(word);
			}
		}
		for (String word: lineParts2) {
			char c = word.charAt(0);
			if (word.contains("@")|| word.contains("#") || word.contains("$") ||
				word.contains("0")|| word.contains("1")	|| word.contains("2") ||
				word.contains("3")|| word.contains("4")	|| word.contains("5") ||	
				word.contains("6")|| word.contains("7")	|| word.contains("8") ||	
				word.contains("9")) {
				linePartsTranslated.add(word);			
			}
			else if (c == 'a'||c == 'e'|| c == 'i' || c == 'o' || c == 'u') {
				word += "way";	
				linePartsTranslated.add(word);
			}
			else {
				while (c != 'a'&& c != 'e'&& c != 'i' && c != 'o' && c != 'u' && c != 'y') {
				word = word.substring(1);
//				System.out.println(word);    //	For testing
				word += c;
//				System.out.println(word);	//	For testing
				c = word.charAt(0);
				}
				word += "ay";
				linePartsTranslated.add(word);
			}
		}
		return linePartsTranslated;
	}
}
