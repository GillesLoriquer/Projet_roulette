import java.util.Hashtable;

public class Joueur {
  // Variables relatives à chaque joueur (de 1 à 3 joueurs)
  private static String joueur1Nom = "";                                     // Nom du joueur 1
  private static int joueur1Cagnotte = 0;                                    // Cagnotte du joueur 1
  private static Hashtable<String, Integer> joueur1gain = new Hashtable<>(); // Contient gains ("Nom pari" > gain)
  private static Hashtable<String, Integer> joueur1perte = new Hashtable<>();// Contient pertes ("Nom pari" > pertes)

  private static String joueur2Nom = "";                                     // Idem pour le joueur 2
  private static int joueur2Cagnotte = 0;                                    // Idem pour le joueur 2
  private static Hashtable<String, Integer> joueur2gain = new Hashtable<>(); // Idem pour le joueur 2
  private static Hashtable<String, Integer> joueur2perte = new Hashtable<>();// Idem pour le joueur 2

  private static String joueur3Nom = "";                                     // Idem pour le joueur 3
  private static int joueur3Cagnotte = 0;                                    // Idem pour le joueur 3
  private static Hashtable<String, Integer> joueur3gain = new Hashtable<>(); // Idem pour le joueur 3
  private static Hashtable<String, Integer> joueur3perte = new Hashtable<>();// Idem pour le joueur 3

  /****************************** JOUEUR 1 */
  public static String getJoueur1Nom() {
    return joueur1Nom;
  }

  public static void setJoueur1Nom(String joueur1Nom) { Joueur.joueur1Nom = joueur1Nom; }

  public static int getJoueur1Cagnotte() {
    return joueur1Cagnotte;
  }

  public static void setJoueur1Cagnotte(int joueur1Cagnotte) {
    Joueur.joueur1Cagnotte = joueur1Cagnotte;
  }

  public static Hashtable<String, Integer> getJoueur1gain() {
    return joueur1gain;
  }

  public static void setJoueur1gain(String clef, int valeur) {
    if (!(Joueur.getJoueur1gain().containsKey(clef))) Joueur.joueur1gain.put(clef, valeur);
    else Joueur.joueur1gain.put(clef, Joueur.getJoueur1gain().get(clef) + valeur);
  }

  public static Hashtable<String, Integer> getJoueur1perte() {
    return joueur1perte;
  }

  public static int getJoueur1perte(String clef) { return joueur1perte.get(clef); }

  public static void setJoueur1perte(String clef, int valeur) {
    if (!(Joueur.getJoueur1perte().containsKey(clef))) Joueur.joueur1perte.put(clef, valeur);
    else Joueur.joueur1perte.put(clef, Joueur.getJoueur1perte(clef) + valeur);
  }

  /****************************** JOUEUR 2 */
  public static String getJoueur2Nom() {
    return joueur2Nom;
  }

  public static void setJoueur2Nom(String joueur2Nom) {
    Joueur.joueur2Nom = joueur2Nom;
  }

  public static int getJoueur2Cagnotte() {
    return joueur2Cagnotte;
  }

  public static void setJoueur2Cagnotte(int joueur2Cagnotte) {
    Joueur.joueur2Cagnotte = joueur2Cagnotte;
  }

  public static Hashtable<String, Integer> getJoueur2gain() {
    return joueur2gain;
  }

  public static void setJoueur2gain(String clef, int valeur) {
    if (!(Joueur.getJoueur2gain().containsKey(clef))) Joueur.joueur2gain.put(clef, valeur);
    else Joueur.joueur2gain.put(clef, Joueur.getJoueur2gain().get(clef) + valeur);
  }

  public static Hashtable<String, Integer> getJoueur2perte() {
    return joueur2perte;
  }

  public static int getJoueur2perte(String clef) { return joueur2perte.get(clef); }

  public static void setJoueur2perte(String clef, int valeur) {
    if (!(Joueur.getJoueur2perte().containsKey(clef))) Joueur.joueur2perte.put(clef, valeur);
    else Joueur.joueur2perte.put(clef, Joueur.getJoueur2perte(clef) + valeur);
  }

  /****************************** JOUEUR 3 */
  public static String getJoueur3Nom() {
    return joueur3Nom;
  }

  public static void setJoueur3Nom(String joueur3Nom) {
    Joueur.joueur3Nom = joueur3Nom;
  }

  public static int getJoueur3Cagnotte() {
    return joueur3Cagnotte;
  }

  public static void setJoueur3Cagnotte(int joueur3Cagnotte) {
    Joueur.joueur3Cagnotte = joueur3Cagnotte;
  }

  public static Hashtable<String, Integer> getJoueur3gain() {
    return joueur3gain;
  }

  public static void setJoueur3gain(String clef, int valeur) {
    if (!(Joueur.getJoueur3gain().containsKey(clef))) Joueur.joueur3gain.put(clef, valeur);
    else Joueur.joueur3gain.put(clef, Joueur.getJoueur3gain().get(clef) + valeur);
  }

  public static Hashtable<String, Integer> getJoueur3perte() {
    return joueur3perte;
  }

  public static int getJoueur3perte(String clef) { return joueur3perte.get(clef); }

  public static void setJoueur3perte(String clef, int valeur) {
    if (!(Joueur.getJoueur3perte().containsKey(clef))) Joueur.joueur3perte.put(clef, valeur);
    else Joueur.joueur3perte.put(clef, Joueur.getJoueur3perte(clef) + valeur);
  }
}