public class Util {
  /****************************** VERIFIER SI LA VALEUR FOURNIE EST BIEN UN INT */
  public static boolean foncIsInt(String chaine, int base) {
    if (chaine.isEmpty()) return false;

    for (int i = 0; i < chaine.length(); i++) {
      if (i == 0 && chaine.charAt(i) == '-') {
        if (chaine.length() == 1) return false;
        else continue;
      }
      if (Character.digit(chaine.charAt(i), base) < 0) return false;
    }
    return true;
  }

  /****************************** VERIFIER SI TOUTES LES VALEURS DU TABLEAU FOURNI SONT DES INT */
  public static boolean foncAreInts(String stringTab[], int base) {
    boolean isInt = false;

    for (String chaine : stringTab) {
      if (foncIsInt(chaine, base)) isInt = true;
      else isInt = false;
    }
    return isInt;
  }

  /****************************** VERIFIER QUE LE NUMERO FOURNI SE TROUVE ENTRE X ET Y */
  public static boolean foncIsInRange(int num, int x, int y) {
    if (num  >= x && num <= y) return true;
    else return false;
  }

  /****************************** VERIFIER QUE LES VALEURS DU TABLEAU FOURNI SONT ENTRE X ET Y */
  public static boolean foncAreInRange(int intTab[], int x, int y) {
    boolean isInRange = false;

    for (int val : intTab) {
      if (foncIsInRange(val, x, y)) isInRange = true;
      else isInRange = false;
    }
    return isInRange;
  }

  /****************************** TRANSFORMER UN TABLEAU DE STRING EN TABLEAU DE INT */
  public static int[] foncStringTabToIntTab(String stringTab[]) {
    int intTab[] = new int[stringTab.length];

    for (int i = 0; i < intTab.length; i++) intTab[i] = Integer.parseInt(stringTab[i]);
    return intTab;
  }

  /****************************** ATTENDRE LE TEMPS FOURNI EN PARAMETRE (EN SECONDE) */
  public static void procWait(int i_temps) {
    for (int i = 0; i < i_temps; i++) {
      System.out.print(".");
      try { Thread.sleep(1000); }
      catch (InterruptedException ie) { }
    }
  }
}