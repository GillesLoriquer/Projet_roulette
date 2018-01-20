public class Partie {
  private static int nbJoueur;                            // Nombre de joueur de la partie
  private static int nbPartie = 1;                        // Compteur du nombre de partie
  private static int caractNumSorti[] = new int[6];       // Tableau contenant le numéro sorti et ses caractéristiques
  private static boolean continuerPartie;                 // True si on continue la partie, false si non

  public static int getNbJoueur() {
    return nbJoueur;
  }

  public static void setNbJoueur(int nbJoueur) {
    Partie.nbJoueur = nbJoueur;
  }

  public static int getNbPartie() {
    return nbPartie;
  }

  public static void setNbPartie(int nbPartie) {
    Partie.nbPartie = nbPartie;
  }

  public static int[] getCaractNumSorti() {
    return caractNumSorti;
  }

  public static int getCaractNumSorti(int index) { return caractNumSorti[index]; }

  public static void setCaractNumSorti(int index, int num) {
    Partie.caractNumSorti[index] = num;
  }

  public static boolean isContinuerParti() {
    return continuerPartie;
  }

  public static void setContinuerParti(boolean continuerParti) {
    Partie.continuerPartie = continuerParti;
  }
}