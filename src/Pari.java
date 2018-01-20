public class Pari {
  private static String typePari;                   // Nom du pari
  private static String joueur;                     // Nom du joueur courant
  private static int rapport;                       // Rapport du gain (35 contre 1 etc.)
  private static int mise;                          // Mise réalisé par le joueur
  private static int gain;                          // Gain réalisé par le joueur
  private static int cagnotte;                      // Cagnotte du joueur courant
  private static boolean nouveauPari;               // True si le joueur souhaite faire un nouveau pari

  public static String getTypePari() {
    return typePari;
  }

  public static void setTypePari(String typePari) {
    Pari.typePari = typePari;
  }

  public static String getJoueur() { return joueur; }

  public static void setJoueur(String joueur) { Pari.joueur = joueur; }

  public static int getRapport() {
    return rapport;
  }

  public static void setRapport(int rapport) {
    Pari.rapport = rapport;
  }

  public static int getMise() {
    return mise;
  }

  public static void setMise(int mise) { Pari.mise = mise; }

  public static int getGain() {
    return gain;
  }

  public static void setGain(int gain) { Pari.gain = gain; }

  public static int getCagnotte() {
    return cagnotte;
  }

  public static void setCagnotte(int cagnote) {
    Pari.cagnotte = cagnote;
  }

  public static boolean isNouveauPari() {
    return nouveauPari;
  }

  public static void setNouveauPari(boolean nouveauPari) {
    Pari.nouveauPari = nouveauPari;
  }
}