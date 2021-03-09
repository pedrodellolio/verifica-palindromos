package projeto_palindromos;
import java.text.Normalizer;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerificaPalindromo {
	
	public static String read(Scanner scanner) {
		System.out.println("Digite uma palavra ou uma frase: ");
		String frase = scanner.nextLine();
		System.out.println("A frase digitada foi: " + frase);
		return frase;
	}
	
	public static Boolean verificaCaracteresEspeciais (String str) {
		Pattern pattern = Pattern.compile("^\\w+$"); //Verificando se a string possui APENAS caracteres (A-Z) e/ou números (0-9)
		Matcher matcher = pattern.matcher(str);
		
		if (matcher.find()) {
			return false;
		} else {
			return true;
		}
		
	}
	
	public static String transformaFrase (String str) {
		String strSemEspaco = str.replace(" ", "").toLowerCase();
		String especiais = "!@#$%¨&*()_±={}[]?:/;><.-,";
		
		if (verificaCaracteresEspeciais(strSemEspaco)) {
			for (int i=0; i<especiais.length(); i++) {
				strSemEspaco = strSemEspaco.replace(especiais.charAt(i)+"", "");

			}
		}
		return strSemEspaco;
	}
	
	public static String inverteFrase (String str) {
		StringBuilder stringBuilder = new StringBuilder(str);
		String strInvertida = stringBuilder.reverse().toString();
		return strInvertida;
	}
	
	public static String removeAcentos (String str) {
		str = Normalizer.normalize(str, Normalizer.Form.NFD);
	    str = str.replaceAll("[^\\p{ASCII}]", "");
	    return str;
	}
			
	
	public static void verifica (String str, String strInvertida) {
		if (str.equalsIgnoreCase(strInvertida)) {
			System.out.println("A frase é um palindromo!");;
		} else {
			System.out.println("A frase não é um palindromo!");;

		}
	}
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String frase = read(scanner);
		
		frase = transformaFrase(frase);
		frase = removeAcentos(frase);
		verifica(frase, inverteFrase(frase));
		
		
	}
	
	
	
	
}
