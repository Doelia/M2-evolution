package propre;

import java.util.ArrayList;
import java.util.List;

public class Methode {
	
	public static ArrayList<Methode> instances = new ArrayList<>(); // Méthodes la composant
	
	
	
	public String name; // Contruit à li'init
	
	// Provisoire pour contruction plus tard
	public String typeRetour; // Contsruit à l'init
	public ArrayList<String> paramsString = new ArrayList<>();
	
	public String nameClasse = "undefined";
	
	
	// Contruit après coup
	public Type retour; // Type de retour
	public ArrayList<Type> params = new ArrayList<>(); // Liste des parametres
	public ArrayList<Methode> appels = new ArrayList<>(); // Appelle des méthodes
	public Type classe = null; // Classe dont elle fait partie
	
	@Override
	public String toString() {
		return "Méthode "+name+" (classe "+nameClasse+"), retour de type "+typeRetour;
	}
	
	public static Methode getMothodeFromName(String nameClasse, String nomMethode) {
		for (Methode m : instances) {
			if (m.nameClasse.equals(nameClasse) && m.name.equals(nomMethode)) {
				return m;
			}
		}
		return null;
	}
	
	public static void addInvocation(String classeAppellante, String methodeappelante, String appelee) {
		Methode appelante = getMothodeFromName(classeAppellante, methodeappelante);
		Methode appellee = getMothodeFromName(classeAppellante, appelee); // Attention, c'est la même classe ?
		if (appelante != null) {
			appelante.appels.add(appellee);
			System.out.println("La méthode "+methodeappelante+ "appelle la méthode "+appelee);
			return;
		}
	}
}