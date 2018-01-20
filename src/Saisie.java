import java.util.Scanner;

public class Saisie {
  // STRING
  public static String foncLireString() {
    String chaine = null;
    try {
      Scanner input = new Scanner(System.in);
      chaine = input.nextLine();
    }
    catch (NumberFormatException e) {System.err.println(e);}
    return chaine;
  }

  // CHAR
  public static char foncLireChar() {
    String chaine = foncLireString();
    return chaine.charAt(0);
  }

  // BYTE
  public static byte lire_byte() {
    return Byte.parseByte(foncLireString());
  }

  // SHORT
  public static short lire_short() { return Short.parseShort(foncLireString()); }

  // INT
  public static int foncLireInt(int base) {
    Scanner input = new Scanner(System.in);
    String chaine = input.nextLine();
    boolean isInt = Util.foncIsInt(chaine, base);

    while (!(isInt)) {
      System.out.print("Saisie incorrect, caractères non conformes : ");
      chaine = input.nextLine();
      isInt = Util.foncIsInt(chaine, base);
    }
    return Integer.parseInt(chaine);
  }

  // SHORT
  public static long foncLireLong() { return Long.parseLong(foncLireString()); }

  // FLOAT
  public static float foncLireFloat() {
    return Float.parseFloat(foncLireString());
  }

  // DOUBLE
  public static double foncLireDouble() {
    return Double.parseDouble(foncLireString());
  }
}