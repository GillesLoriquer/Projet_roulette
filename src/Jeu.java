import java.util.Hashtable;
import java.util.stream.IntStream;
import java.util.Set;
import java.util.Arrays;

public class Jeu {
  /**************************************************************************************************************
   *                                                VARIABLES
   **************************************************************************************************************/

  /****************************** TABLEAU 2 DIMENSIONS REPRESENTANT LA TABLE DE JEU */
  private static int tableJeu[][] = {
          {3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36},
          {2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35},
          {1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34}
  };
  // GETTER TABLE DE JEU
  public static int[][] getTableJeu() {
    return tableJeu;
  }

  /****************************** TABLEAU CONTENANT LA LISTE DES VALEURS POSSEDANT LA COULEUR ROUGE */
  private static int nbRouges[] = {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};
  // GETTER NOMBRES ROUGES
  public static int[] getNbRouges() {
    return nbRouges;
  }

  /**************************************************************************************************************
   *                                                AFFICHAGES
   **************************************************************************************************************/

  /****************************** AFFICHER LE TAPIS DE JEU */
  public static void procAffTapis() {
    System.out.println("\n\t\t\t\t\t\t\tTAPIS\n");
    System.out.println("\t3  6  9  12  |  15  18  21  24  |  27  30  33  36  |  3eC");
    System.out.println("0   2  5  8  11  |  14  17  20  23  |  26  29  32  35  |  2eC");
    System.out.println("\t1  4  7  10  |  13  16  19  22  |  25  28  31  34  |  1eC");
    System.out.println("\t 1 douzaine      2 douzaines        3 douzaines\n");
  }

  /****************************** AFFICHER LES TYPES DE PARI */
  public static void procTypePari() {
    String[] tab = {
            "PARIS INTERIEURS :",
            "\t[1]  En plein (1 num)",
            "\t[2]  A cheval (2 num)",
            "\t[3]  Transversale pleine (3 num)",
            "\t[4]  Triple (3 num)",
            "\t[5]  Carré (4 num)",
            "\t[6]  Ligne haute (4 num)",
            "\t[7]  Sixain (6 num)",
            "PARIS EXTERIEURS",
            "\t[8]  Colonne (12 num)",
            "\t[9]  Douzaine (12 num)",
            "\t[10] Couleur (18 num)",
            "\t[11] Parité (18 num)",
            "\t[12] Manque - passe (18 num)",
    };

    for (String el : tab) {
      System.out.println(el);
    }
  }

  /****************************** AFFICHER LES CARACTERISTIQUES DU NUMERO SORTI */
  public static void procAffCaractNumSorti() {
    String a_trame[] = {"Numéro : ", "Colonne : ", "Douzaine : ", "Couleur : ", "Parité : ", "Manque - passe : "};

    System.out.println("Caractéristiques du numéro sorti : ");

    System.out.println("\t" + a_trame[0] + "" + Partie.getCaractNumSorti(0));

    if (Partie.getCaractNumSorti(0) == 0) {
      for (int i = 1; i < Partie.getCaractNumSorti().length; i++) {
        System.out.println("\t" + a_trame[i] + "N/A");
      }
      return;
    }
    else {
      System.out.println("\t" + a_trame[1] + "" + Partie.getCaractNumSorti(1));

      System.out.println("\t" + a_trame[2] + "" + Partie.getCaractNumSorti(2));

      if (Partie.getCaractNumSorti(3) == 1) System.out.println("\t" + a_trame[3] + "" + "rouge");
      else System.out.println("\t" + a_trame[3] + "" + "noir");

      if (Partie.getCaractNumSorti(4) == 0) System.out.println("\t" + a_trame[4] + "" + "pair");
      else System.out.println("\t" + a_trame[4] + "" + "impair");

      if (Partie.getCaractNumSorti(5) == 0) System.out.println("\t" + a_trame[5] + "" + "manque");
      else System.out.println("\t" + a_trame[5] + "" + "passe");
    }
  }

  /****************************** AFFICHER LES RESULTATS DE LA PARTIE */
  public static void procAffResult(int joueur) {
    Hashtable<String, Integer> gain = new Hashtable<>();
    Hashtable<String, Integer> perte = new Hashtable<>();
    int gainTotal = 0;
    int perteTotal = 0;

    switch (joueur) {
      case 0: {
        gain = Joueur.getJoueur1gain();
        perte = Joueur.getJoueur1perte();
        break;
      }
      case 1: {
        gain = Joueur.getJoueur2gain();
        perte = Joueur.getJoueur2perte();
        break;
      }
      case 2: {
        gain = Joueur.getJoueur3gain();
        perte = Joueur.getJoueur3perte();
        break;
      }
    }

    // Afficher les gains
    System.out.println("GAINS : ");

    Set<String> gainClefs = gain.keySet();
    for (String s_key : gainClefs) {
      gainTotal += gain.get(s_key);
      System.out.println("\t" + s_key + " : " + gain.get(s_key));
    }
    System.out.println("\tTotal : " + gainTotal);

    // Afficher les pertes
    System.out.println("PERTES : ");

    Set<String> perteClefs = perte.keySet();
    for (String s_key : perteClefs) {
      perteTotal += perte.get(s_key);
      System.out.println("\t" + s_key + " : " + perte.get(s_key));
    }
    System.out.println("\tTotal : " + perteTotal);

    // Afficher la balance
    System.out.println("BALANCE : ");

    if (gainTotal > perteTotal) System.out.println("\tPositive (+" + (gainTotal - perteTotal) + ")");
    else if (gainTotal < perteTotal) System.out.println("\tNegative (" + (gainTotal - perteTotal) + ")");
    else System.out.println("\tNull (à l'équilibre)");

    System.out.println("\n");
  }

  /****************************** AFFICHER LE LANCEMENT DE LA BILLE */
  public static void procAffLancCroupier() {
    System.out.print("\nRien ne va plus");
    Util.procWait(5);
    System.out.println("Les jeux sont faits !\n");
  }

  /**************************************************************************************************************
   *                                        GESTION DU NUMERO DE SORTI
   **************************************************************************************************************/

  /****************************** TIRER UN NUMERO ENTRE 0 ET 36 ET DEFINIR SES CARACTERISTIQUES */
  public static void procDefCaractNumSorti() {
    System.out.println("\n------------------------------------------------------ Tour " + Partie.getNbPartie() + "\n");
    System.out.println("Faites vos jeux !");

    // Tirer le numéro de sorti
    int num = (int)Math.round((Math.random() * 36) * 100) / 100;
    //int num = 3;

    // Définir les caractéristiques du numéro
    switch (num) {
      case 0: {
        for (int i = 0; i < Partie.getCaractNumSorti().length; i++) Partie.setCaractNumSorti(i, 0);
        break;
      }
      default: {
        // Insérer le numéro sorti comme premier élément du tableau
        Partie.setCaractNumSorti(0, num);

        // Définir le numéro de colonne
        Partie.setCaractNumSorti(1, foncQuelleColonne(num));

        // Définir le numéro de douzaine
        Partie.setCaractNumSorti(2, foncQuelleDouzaine(num));

        // Définir la couleur (0 - noir / 1 - rouge)
        if (foncIsRouge(num)) Partie.setCaractNumSorti(3, 1);
        else Partie.setCaractNumSorti(3, 0);

        // Définir la parité (0 - pair / 1 - impair)
        if (foncIsPair(num)) Partie.setCaractNumSorti(4, 0);
        else Partie.setCaractNumSorti(4, 1);

        // Définir manque ou passe (0 - manque - 1 passe)
        if (foncIsManque(num)) Partie.setCaractNumSorti(5, 0);
        else Partie.setCaractNumSorti(5, 1);
        break;
      }
    }
  }

  /****************************** RETOURNER LE NUMERO DE COLONNE DU NUMERO SORTI */
  public static int foncQuelleColonne(int num) {
    if (IntStream.of(tableJeu[0]).anyMatch(x -> x == num)) return 3;
    else if (IntStream.of(tableJeu[1]).anyMatch(x -> x == num)) return 2;
    else return 1;
  }

  /****************************** RETOURNER LE NUMERO DE DOUZAINE DU NUMERO SORTI */
  public static int foncQuelleDouzaine(int num) {
    if (num <= 12) return 1;
    else if (num <= 24) return 2;
    else return 3;
  }

  /****************************** RETOURNER TRUE SI LE NUMERO DE SORTI EST ROUGE */
  public static boolean foncIsRouge(int num) {
    if (IntStream.of(nbRouges).anyMatch(x -> x == num)) return true;
    else return false;
  }

  /****************************** RETOURNER TRUE SI LE NUMERO SORTI EST PAIR */
  public static boolean foncIsPair(int num) {
    if (num % 2 == 0) return true;
    else return false;
  }

  /****************************** RETOURNER TRUE SI LE NUMERO SORTI MANQUE */
  public static boolean foncIsManque(int num) {
    if (num <= 18) return true;
    else return false;
  }

  /**************************************************************************************************************
   *                                          GESTION DE LA PARTIE
   **************************************************************************************************************/

  /****************************** PARAMETRER LE NOMBRE DE JOUEURS DANS LA PARTIE */
  public static void procSetNbJoueur() {
    boolean nbJoueurInRange;
    do {
      System.out.print("Indiquer le nombre de joueurs (1,2 ou 3) : ");
      Partie.setNbJoueur(Saisie.foncLireInt(10));
      nbJoueurInRange = Util.foncIsInRange(Partie.getNbJoueur(), 1, 3);

      if (!(nbJoueurInRange)) System.out.println("ERR : le nombre de joueurs doit être compris entre 1 et 3 !");
    }
    while (!(nbJoueurInRange));
  }

  /****************************** RECUPERER LE NOM DE CHAQUE JOUEUR ET SET DE LA CAGNOTTE A 1000 */
  public static void procSetJoueurs() {
    for (int joueur = 0; joueur < Partie.getNbJoueur(); joueur++) {
      System.out.print("Nom du joueur " + (joueur + 1) + " : ");

      switch (joueur) {
        case 0: {
          Joueur.setJoueur1Nom(Saisie.foncLireString().toUpperCase());
          Joueur.setJoueur1Cagnotte(1000);
          break;
        }
        case 1: {
          Joueur.setJoueur2Nom(Saisie.foncLireString().toUpperCase());
          Joueur.setJoueur2Cagnotte(1000);
          break;
        }
        case 2: {
          Joueur.setJoueur3Nom(Saisie.foncLireString().toUpperCase());
          Joueur.setJoueur3Cagnotte(1000);
          break;
        }
      }
    }
  }

  /****************************** RENVOYER TRUE SI LE JOUEUR CONTINU LA PARTIE */
  public static void procContinuerPartie() {
    System.out.print("Continuer la partie (O/N) ? ");

    if (Saisie.foncLireString().toUpperCase().equals("O")) {
      Partie.setContinuerParti(true);
      Partie.setNbPartie(Partie.getNbPartie()+1);
    } else {
      Partie.setContinuerParti(false);
    }
  }

  /**************************************************************************************************************
   *                                          GESTION DES PARIS
   **************************************************************************************************************/

  /****************************** RENVOYER TRUE SI LE JOUEUR SOUHAITE UN NOUVEAU PARI */
  public static void procNouvauPari() {
    if (Pari.getCagnotte() == 0) {
      System.out.println("Cagnotte vide, fin des paris !");
      Pari.setNouveauPari(false);
    } else {
      System.out.print("Nouveau pari (O/N) ? (cagnotte restante : " + Pari.getCagnotte() + ") ");
      Pari.setNouveauPari(Saisie.foncLireString().toUpperCase().equals("O"));
    }
  }

  /****************************** RECUPERER LES PARIS */
  public static void foncGetPari() {
    int numPari;
    boolean pariInRange;
    String nomPari = "";

    System.out.print("Quel pari joues-tu (1 à 12) : ");

    do {
      numPari = Saisie.foncLireInt(10);
      pariInRange = Util.foncIsInRange(numPari, 1, 12);

      if (!(pariInRange)) System.out.println("ERR : le nombre de paris doit être compris entre 1 et 12 : ");
    }
    while (!(pariInRange));

    switch (numPari) {
      case 1: nomPari = "En plein"; break;
      case 2: nomPari = "A cheval"; break;
      case 3: nomPari = "Transversale pleine"; break;
      case 4: nomPari = "Triple"; break;
      case 5: nomPari = "Carré"; break;
      case 6: nomPari = "Ligne haute"; break;
      case 7: nomPari = "Sixain"; break;
      case 8: nomPari = "Colonne"; break;
      case 9: nomPari = "Douzaine"; break;
      case 10: nomPari = "Couleur"; break;
      case 11: nomPari = "Parité"; break;
      case 12: nomPari = "Manque - passe"; break;
    }

    Pari.setTypePari(nomPari);
  }

  /****************************** RECUPERER LA MISE */
  public static void procSetfMise() {
    // Vérifier que le joueur mise moins que ce qu'il lui reste dans sa cagnotte
    System.out.print("Combien mises-tu : ");
    Pari.setMise(Saisie.foncLireInt(10));

    while (!(Pari.getCagnotte() - Pari.getMise() >= 0)) {
      System.out.print("Mise trop haute ! Entrez un nouveau montant (cagnotte restante : " + Pari.getCagnotte() + ") : ");
      Pari.setMise(Saisie.foncLireInt(10));
    }
    Pari.setCagnotte(Pari.getCagnotte() - Pari.getMise());
  }

  /****************************** AFFECTER LES PERTES ET GAINS A CHAQUE JOUEUR */
  public static void procSetPertesGains(int joueur) {
    switch (joueur) {
      case 0: {
        if (Pari.getGain() > 0) {
          Joueur.setJoueur1Cagnotte(Joueur.getJoueur1Cagnotte() + Pari.getGain());
          Joueur.setJoueur1gain(Pari.getTypePari(), Pari.getGain());
        } else {
          Joueur.setJoueur1Cagnotte(Joueur.getJoueur1Cagnotte() - Pari.getMise());
          Joueur.setJoueur1perte(Pari.getTypePari(), Pari.getMise());
        }
        break;
      }
      case 1: {
        if (Pari.getGain() > 0) {
          Joueur.setJoueur2Cagnotte(Joueur.getJoueur2Cagnotte() + Pari.getGain());
          Joueur.setJoueur2gain(Pari.getTypePari(), Pari.getGain());
        } else {
          Joueur.setJoueur2Cagnotte(Joueur.getJoueur2Cagnotte() - Pari.getMise());
          Joueur.setJoueur2perte(Pari.getTypePari(), Pari.getMise());
        }
        break;
      }
      case 2: {
        if (Pari.getGain() > 0) {
          Joueur.setJoueur3Cagnotte(Joueur.getJoueur3Cagnotte() + Pari.getGain());
          Joueur.setJoueur3gain(Pari.getTypePari(), Pari.getGain());
        } else {
          Joueur.setJoueur3Cagnotte(Joueur.getJoueur3Cagnotte() - Pari.getMise());
          Joueur.setJoueur3perte(Pari.getTypePari(), Pari.getMise());
        }
        break;
      }
    }
  }

  /****************************** PARI EN PLEIN */
  public static void procJouerEnPlein() {
    Pari.setRapport(35);                              // Rapport du gain (35 contre 1 etc.)
    int valI;                                         // Valeur jouée par le joueur
    boolean isInRange;                                // True si la valeur testée est entre x et y

    // Récupérer la mise du joueur et valider que sa mise en inférieur à sa cagnotte
    procSetfMise();

    System.out.print("Quel numéro joues-tu : ");
    do {
      valI = Saisie.foncLireInt(10);
      isInRange = Util.foncIsInRange(valI, 0, 36);

      if (!(isInRange)) System.out.print("ERR : le nombre de joueurs doit être compris entre 0 et 36 : ");
      else if (valI == Partie.getCaractNumSorti(0)) Pari.setGain(Pari.getRapport() * Pari.getMise());
    }
    while (!(isInRange));
  }

  /****************************** PARI A CHEVAL */
  public static void procJouerAcheval() {
    Pari.setRapport(17);                            // Rapport du gain (35 contre 1 etc.)
    String valIstrings[];                           // Valeurs jouées par le joueur (ex : 1,2 pour un pari à cheval)
    int valIints[];                                 // Valeurs jouées par le joueur (ex : 1,2 pour un pari à cheval)
    int nbNumbers = 2;                              // Nombre de numéros à jouer (ex : carré => 4)
    boolean areNumOk = false;                       // True les valeurs entrées sont valables

    // Récupérer la mise du joueur et valider que sa mise en inférieur à sa cagnotte
    procSetfMise();

    System.out.print("Quels numéros à cheval joues-tu (ex : 3,6) : ");

    do {
      valIstrings = Saisie.foncLireString().trim().split(",");
      if (valIstrings.length == nbNumbers) {
        if (Util.foncAreInts(valIstrings, 10)) {
          valIints = Util.foncStringTabToIntTab(valIstrings);
          if (Util.foncAreInRange(valIints, 0, 36)) {
            areNumOk = foncIsAcheval(valIints);
            if (areNumOk) {
              if (IntStream.of(valIints).anyMatch(x -> x == Partie.getCaractNumSorti(0))) {
                Pari.setGain(Pari.getRapport() * Pari.getMise());
              }
            } else System.out.print("ERR : les valeurs selectionnées ne sont pas valables : ");
          } else System.out.print("ERR : les nombres doivent être compris entre 0 et 36 : ");
        } else System.out.print("ERR : vous devez entrer des numéros séparés par une virgule : ");
      } else System.out.print("ERR : vous devez entrez " + nbNumbers + " numéros : ");
    }
    while (!(areNumOk));
  }

  public static boolean foncIsAcheval(int valeurs[]) {
    Arrays.sort(valeurs);
    boolean valeursOk = false;

    if (valeurs[0] != 0) {
      loopLigne : for (int ligne = 0; ligne < getTableJeu().length; ligne++) {
        for (int colonne = 0; colonne < getTableJeu()[0].length; colonne++) {
          if (Jeu.getTableJeu()[ligne][colonne] == valeurs[0]
                  && (ligne-1 >= 0
                      && Jeu.getTableJeu()[ligne-1][colonne] == valeurs[1])
                    || (ligne+1 < getTableJeu().length
                      && Jeu.getTableJeu()[ligne+1][colonne] == valeurs[1])
                    || (colonne-1 >= 0
                      && Jeu.getTableJeu()[ligne][colonne-1] == valeurs[1])
                    || (colonne+1 < getTableJeu()[0].length
                      && Jeu.getTableJeu()[ligne][colonne+1] == valeurs[1])) {
            valeursOk = true;
            break loopLigne;
          }
        }
      }
    }
    return valeursOk;
  }

  /****************************** PARI TRANSVERSALE PLEINE */
  public static void procJouerTransversale() {
    Pari.setRapport(11);                            // Rapport du gain (35 contre 1 etc.)
    String valIstrings[];                           // Valeurs jouées par le joueur (ex : 1,2 pour un pari à cheval)
    int valIints[];                                 // Valeurs jouées par le joueur (ex : 1,2 pour un pari à cheval)
    int nbNumbers = 3;                              // Nombre de numéros à jouer (ex : carré => 4)
    boolean areNumOk = false;                       // True les valeurs entrées sont valables

    // Récupérer la mise du joueur et valider que sa mise en inférieur à sa cagnotte
    procSetfMise();

    System.out.print("Quels numéros transvesales joues-tu (ex : 1,2,3) : ");

    do {
      valIstrings = Saisie.foncLireString().trim().split(",");
      if (valIstrings.length == nbNumbers) {
        if (Util.foncAreInts(valIstrings, 10)) {
          valIints = Util.foncStringTabToIntTab(valIstrings);
          if (Util.foncAreInRange(valIints, 0, 36)) {
            areNumOk = foncIsTransversal(valIints);
            if (areNumOk) {
              if (IntStream.of(valIints).anyMatch(x -> x == Partie.getCaractNumSorti(0))) {
                Pari.setGain(Pari.getRapport() * Pari.getMise());
              }
            } else System.out.print("ERR : les valeurs selectionnées ne sont pas valables : ");
          } else System.out.print("ERR : les nombres doivent être compris entre 0 et 36 : ");
        } else System.out.print("ERR : vous devez entrer des numéros séparés par une virgule : ");
      } else System.out.print("ERR : vous devez entrez " + nbNumbers + " numéros : ");
    }
    while (!(areNumOk));
  }

  public static boolean foncIsTransversal(int valeurs[]) {
    Arrays.sort(valeurs);
    boolean valeursOk = false;

    if (valeurs[0] != 0) {
      loopLigne : for (int ligne = 0; ligne < Jeu.getTableJeu().length; ligne++) {
        for (int colonne = 0; colonne < Jeu.getTableJeu()[0].length; colonne++) {
          if (Jeu.getTableJeu()[ligne][colonne] == valeurs[0]
                  && ligne == 2
                  && Jeu.getTableJeu()[ligne-1][colonne] == valeurs[1]
                  && Jeu.getTableJeu()[ligne-2][colonne] == valeurs[2]) {
            valeursOk = true;
            break loopLigne;
          }
        }
      }
    }
    return valeursOk;
  }

  /****************************** PARI TRIPLE */
  public static void procJouerTriple() {
    Pari.setRapport(11);                            // Rapport du gain (35 contre 1 etc.)
    int valI;                                       // Valeur jouée par le joueur
    boolean isInRange;                              // True si la valeur testée est entre x et y

    // Récupérer la mise du joueur et valider que sa mise en inférieur à sa cagnotte
    procSetfMise();

    System.out.print("Quels numéros triple joues-tu ([0] 0,1,2 | [1] 0,2,3) : ");

    do {
      valI = Saisie.foncLireInt(10);
      isInRange = Util.foncIsInRange(valI, 0, 1);

      if (isInRange) {
        switch (valI) {
          case 0: {
            if (Partie.getCaractNumSorti(0) == 0
                    || Partie.getCaractNumSorti(0) == 1
                    || Partie.getCaractNumSorti(0) == 2) {
              Pari.setGain(Pari.getRapport() * Pari.getMise());
            }
          }
          case 1: {
            if (Partie.getCaractNumSorti(0) == 0
                    || Partie.getCaractNumSorti(0) == 2
                    || Partie.getCaractNumSorti(0) == 3) {
              Pari.setGain(Pari.getRapport() * Pari.getMise());
            }
          }
        }
      }
      else System.out.print("ERR : vous devez entrer 0 ou 1 : ");
    }
    while (!(isInRange));
  }

  /****************************** PARI CARRE */
  public static void procJouerCarre() {
    Pari.setRapport(8);                             // Rapport du gain (35 contre 1 etc.)
    String valIstrings[];                           // Valeurs jouées par le joueur (ex : 1,2 pour un pari à cheval)
    int valIints[];                                 // Valeurs jouées par le joueur (ex : 1,2 pour un pari à cheval)
    int nbNumbers = 4;                              // Nombre de numéros à jouer (ex : carré => 4)
    boolean areNumOk = false;                       // True les valeurs entrées sont valables

    // Récupérer la mise du joueur et valider que sa mise en inférieur à sa cagnotte
    procSetfMise();

    System.out.print("Quels numéros carre joues-tu (ex : 2,3,5,6) : ");

    do {
      valIstrings = Saisie.foncLireString().trim().split(",");
      if (valIstrings.length == nbNumbers) {
        if (Util.foncAreInts(valIstrings, 10)) {
          valIints = Util.foncStringTabToIntTab(valIstrings);
          if (Util.foncAreInRange(valIints, 0, 36)) {
            areNumOk = foncIsCarre(valIints);
            if (areNumOk) {
              if (IntStream.of(valIints).anyMatch(x -> x == Partie.getCaractNumSorti(0))) {
                Pari.setGain(Pari.getRapport() * Pari.getMise());
              }
            } else System.out.print("ERR : les valeurs selectionnées ne sont pas valables : ");
          } else System.out.print("ERR : les nombres doivent être compris entre 0 et 36 : ");
        } else System.out.print("ERR : vous devez entrer des numéros séparés par une virgule : ");
      } else System.out.print("ERR : vous devez entrez " + nbNumbers + " numéros : ");
    }
    while (!(areNumOk));
  }

  public static boolean foncIsCarre(int valeurs[]) {
    Arrays.sort(valeurs);
    boolean valeursOk = false;

    if (valeurs[0] != 0) {
      loopLigne : for (int ligne = 0; ligne < Jeu.getTableJeu().length; ligne++) {
        for (int colonne = 0; colonne < Jeu.getTableJeu()[0].length; colonne++) {
          if (Jeu.getTableJeu()[ligne][colonne] == valeurs[0]
                  && ligne-1 >= 0
                  && colonne+1 < Jeu.getTableJeu()[0].length
                  && Jeu.getTableJeu()[ligne-1][colonne] == valeurs[1]
                  && Jeu.getTableJeu()[ligne][colonne+1] == valeurs[2]
                  && Jeu.getTableJeu()[ligne-1][colonne+1] == valeurs[3]) {
            valeursOk = true;
            break loopLigne;
          }
        }
      }
    }
    return valeursOk;
  }

  /****************************** PARI LIGNE HAUTE */
  public static void procJouerLigne() {
    Pari.setRapport(8);                             // Rapport du gain (35 contre 1 etc.)

    System.out.println("Les numéros de la ligne du haut sont les suivants : 0,1,2,3");

    // Récupérer la mise du joueur et valider que sa mise en inférieur à sa cagnotte
    procSetfMise();

    if (Util.foncIsInRange(Partie.getCaractNumSorti(0), 0, 3)) {
      Pari.setGain(Pari.getRapport() * Pari.getMise());
    }
  }

  /****************************** PARI SIXAIN */
  public static void procJouerSixain() {
    Pari.setRapport(5);                             // Rapport du gain (35 contre 1 etc.)
    String valIstrings[];                           // Valeurs jouées par le joueur (ex : 1,2 pour un pari à cheval)
    int valIints[];                                 // Valeurs jouées par le joueur (ex : 1,2 pour un pari à cheval)
    int nbNumbers = 6;                              // Nombre de numéros à jouer (ex : carré => 4)
    boolean areNumOk = false;                       // True les valeurs entrées sont valables

    // Récupérer la mise du joueur et valider que sa mise en inférieur à sa cagnotte
    procSetfMise();

    System.out.print("Quels numéros de sixain joues-tu (ex : 1,2,3,4,5,6) : ");

    do {
      valIstrings = Saisie.foncLireString().trim().split(",");
      if (valIstrings.length == nbNumbers) {
        if (Util.foncAreInts(valIstrings, 10)) {
          valIints = Util.foncStringTabToIntTab(valIstrings);
          if (Util.foncAreInRange(valIints, 0, 36)) {
            areNumOk = foncIsSixain(valIints);
            if (areNumOk) {
              if (IntStream.of(valIints).anyMatch(x -> x == Partie.getCaractNumSorti(0))) {
                Pari.setGain(Pari.getRapport() * Pari.getMise());
              }
            } else System.out.print("ERR : les valeurs selectionnées ne sont pas valables : ");
          } else System.out.print("ERR : les nombres doivent être compris entre 0 et 36 : ");
        } else System.out.print("ERR : vous devez entrer des numéros séparés par une virgule : ");
      } else System.out.print("ERR : vous devez entrez " + nbNumbers + " numéros : ");
    }
    while (!(areNumOk));
  }

  public static boolean foncIsSixain(int valeurs[]) {
    Arrays.sort(valeurs);
    boolean valeursOk = false;

    if (valeurs[0] != 0) {
      loopLigne : for (int ligne = 0; ligne < Jeu.getTableJeu().length; ligne++) {
        for (int colonne = 0; colonne < Jeu.getTableJeu()[0].length; colonne++) {
          if (Jeu.getTableJeu()[ligne][colonne] == valeurs[0]
                  && ligne-2 == 0
                  && colonne+1 < Jeu.getTableJeu()[0].length
                  && Jeu.getTableJeu()[ligne-1][colonne] == valeurs[1]
                  && Jeu.getTableJeu()[ligne-2][colonne] == valeurs[2]
                  && Jeu.getTableJeu()[ligne][colonne+1] == valeurs[3]
                  && Jeu.getTableJeu()[ligne-1][colonne+1] == valeurs[4]
                  && Jeu.getTableJeu()[ligne-2][colonne+1] == valeurs[5]) {
            valeursOk = true;
            break loopLigne;
          }
        }
      }
    }
    return valeursOk;
  }

  /****************************** PARI COLONNE */
  public static void procJouerColonne() {
    Pari.setRapport(2);                       // Rapport du gain (35 contre 1 etc.)
    int indice = 1;                           // Indice du tableau caractNumSorti à vérifier
    int valI;                                 // Valeur jouée par le joueur (ex : numéro 10)
    boolean isInRange;                        // True si la valeur testée est entre x et y

    // Récupérer la mise du joueur et valider que sa mise en inférieur à sa cagnotte
    procSetfMise();

    System.out.print("Quel numéro de colonne joues-tu : ");

    do {
      valI = Saisie.foncLireInt(10);
      isInRange = Util.foncIsInRange(valI, 1, 3);

      if (isInRange) {
        if (valI == Partie.getCaractNumSorti(indice)) Pari.setGain(Pari.getRapport() * Pari.getMise());
      }
      else System.out.print("ERR : le numéro doit être compris entre 1 et 3 : ");
    }
    while (!(isInRange));
  }

  /****************************** PARI DOUZAINE */
  public static void procJouerDouzaine() {
    Pari.setRapport(2);                       // Rapport du gain (35 contre 1 etc.)
    int indice = 2;                           // Indice du tableau caractNumSorti à vérifier
    int valI;                                 // Valeur jouée par le joueur (ex : numéro 10)
    boolean isInRange;                        // True si la valeur testée est entre x et y

    // Récupérer la mise du joueur et valider que sa mise en inférieur à sa cagnotte
    procSetfMise();

    System.out.print("Quelle numéro de colonne joues-tu : ");

    do {
      valI = Saisie.foncLireInt(10);
      isInRange = Util.foncIsInRange(valI, 1, 3);

      if (isInRange) {
        if (valI == Partie.getCaractNumSorti(indice)) Pari.setGain(Pari.getRapport() * Pari.getMise());
      }
      else System.out.print("ERR : le numéro doit être compris entre 1 et 3 : ");
    }
    while (!(isInRange));
  }

  /****************************** PARI COULEUR */
  public static void procJouerCouleur() {
    Pari.setRapport(1);                       // Rapport du gain (35 contre 1 etc.)
    int indice = 3;                           // Indice du tableau caractNumSorti à vérifier
    int valI;                                 // Valeur jouée par le joueur (ex : numéro 10)
    boolean isInRange;                        // True si la valeur testée est entre x et y

    // Récupérer la mise du joueur et valider que sa mise en inférieur à sa cagnotte
    procSetfMise();

    System.out.print("Quelle couleur joues-tu ([0] Noir | [1] Rouge) : ");

    do {
      valI = Saisie.foncLireInt(10);
      isInRange = Util.foncIsInRange(valI, 0, 1);

      if (isInRange) {
        if (Partie.getCaractNumSorti(0) != 0
                && valI == Partie.getCaractNumSorti(indice)) {
          Pari.setGain(Pari.getRapport() * Pari.getMise());
        }
      } else System.out.print("ERR : vous devez entrer 0 ou 1 : ");
    }
    while (!(isInRange));
  }

  /****************************** PARI PARITE */
  public static void procJouerParite() {
    Pari.setRapport(1);                       // Rapport du gain (35 contre 1 etc.)
    int indice = 4;                           // Indice du tableau caractNumSorti à vérifier
    int valI;                                 // Valeur jouée par le joueur (ex : numéro 10)
    boolean isInRange;                        // True si la valeur testée est entre x et y

    // Récupérer la mise du joueur et valider que sa mise en inférieur à sa cagnotte
    procSetfMise();

    System.out.print("Quelle parité joues-tu ([0] Pair | [1] Impair) : ");

    do {
      valI = Saisie.foncLireInt(10);
      isInRange = Util.foncIsInRange(valI, 0, 1);

      if (isInRange) {
        if (Partie.getCaractNumSorti(0) != 0
                && valI == Partie.getCaractNumSorti(indice)) {
          Pari.setGain(Pari.getRapport() * Pari.getMise());
        }
      }
      else System.out.print("ERR : vous devez entrer 0 ou 1 : ");
    }
    while (!(isInRange));
  }

  /****************************** PARI MANQUE PASSE */
  public static void procJouerManquePasse() {
    Pari.setRapport(1);                       // Rapport du gain (35 contre 1 etc.)
    int indice = 5;                           // Indice du tableau caractNumSorti à vérifier
    int valI;                                 // Valeur jouée par le joueur (ex : numéro 10)
    boolean isInRange;                        // True si la valeur testée est entre x et y

    // Récupérer la mise du joueur et valider que sa mise en inférieur à sa cagnotte
    procSetfMise();

    System.out.print("Joues-tu manque ou passe ([0] Manque | [1] Passe) : ");

    do {
      valI = Saisie.foncLireInt(10);
      isInRange = Util.foncIsInRange(valI, 0, 1);

      if (isInRange) {
        if (Partie.getCaractNumSorti(0) != 0
                && valI == Partie.getCaractNumSorti(indice)) {
          Pari.setGain(Pari.getRapport() * Pari.getMise());
        }
      }
      else System.out.print("ERR : vous devez entrer 0 ou 1 : ");
    }
    while (!(isInRange));
  }
}
