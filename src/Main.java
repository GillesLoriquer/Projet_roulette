public class Main {
  public static void main(String args[]) {
    /****************************** 1. PARAMETRER LE NOMBRE DE JOUEURS DANS LA PARTIE */
    Jeu.procSetNbJoueur();

    /****************************** 2. RECUPERER LE NOM DE CHAQUE JOUEUR ET SET DES CAGNOTTES A 1000 */
    Jeu.procSetJoueurs();

    /****************************** 3. BOUCLER SUR VALIDITE DU BOOLEAN continuerPartie (CLASSE PARTIE) */
    do {
      /**************************** 4. TIRER LE NUMERO DE SORTIE ET CALCULER SES CARACTERISTIQUES */
      Jeu.procDefCaractNumSorti();

      /**************************** 5. AFFICHER LE TAPIS DE ROULETTE */
      Jeu.procAffTapis();

      /**************************** 6. AFFICHER LES TYPES DE PARI */
      Jeu.procTypePari();

      /**************************** 7. BOUCLER SUR LE NOMBRE D'UTILISATEURS DANS LA PARTIE */
      loopJoueur : for (int joueur = 0; joueur < Partie.getNbJoueur(); joueur++) {

        /************************** 8. VERIFIER SI CAGNOTTE > 0. SET DE JOUEUR ET CAGNOTTE AVEC JOUEUR COURANT */
        switch (joueur) {
          case 0: {
            if (Joueur.getJoueur1Cagnotte() == 0) {
              System.out.println("\nVous êtes ruiné "+Joueur.getJoueur1Nom()+" ! Joueur suivant...\n");
              continue loopJoueur;
            } else {
              Pari.setJoueur(Joueur.getJoueur1Nom());
              Pari.setCagnotte(Joueur.getJoueur1Cagnotte());
            }
            break;
          }
          case 1: {
            if (Joueur.getJoueur2Cagnotte() == 0) {
              System.out.println("\nVous êtes ruiné "+Joueur.getJoueur2Nom()+" ! Joueur suivant...\n");
              continue loopJoueur;
            } else {
              Pari.setJoueur(Joueur.getJoueur2Nom());
              Pari.setCagnotte(Joueur.getJoueur2Cagnotte());
            }
            break;
          }
          case 2: {
            if (Joueur.getJoueur3Cagnotte() == 0) {
              System.out.println("\nVous êtes ruiné "+Joueur.getJoueur3Nom()+" ! Joueur suivant...\n");
              continue loopJoueur;
            } else {
              Pari.setJoueur(Joueur.getJoueur3Nom());
              Pari.setCagnotte(Joueur.getJoueur3Cagnotte());
            }
            break;
          }
        }

        // On affiche "A ton tour -nom du joueur courant- ! cagnotte (-cagnotte du joueur courant-)"
        System.out.println("\nA ton tour "+Pari.getJoueur()+" ! (cagnotte : "+Pari.getCagnotte()+")\n");

        /************************** 9. TANT QUE LE JOUEUR SOUHAITE FAIRE UN NOUVEAU PARI, ON BOUCLE */
        do {
          Pari.setTypePari(null);                           // Reinit du nom de pari
          Pari.setRapport(0);                               // Reinit du rapport de pari
          Pari.setMise(0);                                  // Reinit de la mise de pari
          Pari.setGain(0);                                  // Reinit des gains du pari

          /************************ 10. RECUPERER LE NOM DU PARI */
          Jeu.foncGetPari();

          /************************ 11. JOUER LES PARIS */
          // Jouer les paris
          switch (Pari.getTypePari()) {
            case "En plein": Jeu.procJouerEnPlein(); break;
            case "A cheval": Jeu.procJouerAcheval(); break;
            case "Transversale pleine": Jeu.procJouerTransversale(); break;
            case "Triple": Jeu.procJouerTriple(); break;
            case "Carré": Jeu.procJouerCarre(); break;
            case "Ligne haute": Jeu.procJouerLigne(); break;
            case "Sixain": Jeu.procJouerSixain(); break;
            case "Colonne": Jeu.procJouerColonne(); break;
            case "Douzaine": Jeu.procJouerDouzaine(); break;
            case "Couleur": Jeu.procJouerCouleur(); break;
            case "Parité": Jeu.procJouerParite(); break;
            case "Manque - passe": Jeu.procJouerManquePasse(); break;
          }

          /************************ 12. CALCUL DES PERTES ET DES GAINS */
          Jeu.procSetPertesGains(joueur);

          /************************ 13. DEMANDER SI LE JOUEUR SOUHAITE UN NOUVEAU PARI */
          Jeu.procNouvauPari();
        } // Fin récupération des paris du joueur en cours
        while (Pari.isNouveauPari());
      } // Fin loopJoueur

      /**************************** 14. AFFICHER LE LANCEMENT DE LA BILLE */
      Jeu.procAffLancCroupier();

      /**************************** 15. AFFICHER LES CARACTERISTIQUES DU NUMERO SORTI */
      Jeu.procAffCaractNumSorti();

      /**************************** 16. AFFICHER LES RESULTATS DE LA PARTIE */
      System.out.println("\n*********************** RESULTATS ***********************\n");

      for (int joueur = 0; joueur < Partie.getNbJoueur(); joueur++) {
        switch (joueur) {
          case 0: {
            System.out.println("--------- " + Joueur.getJoueur1Nom());

            Jeu.procAffResult(joueur);

            Joueur.getJoueur1gain().clear();
            Joueur.getJoueur1perte().clear();
            break;
          }
          case 1: {
            System.out.println("--------- " + Joueur.getJoueur2Nom());

            Jeu.procAffResult(joueur);

            Joueur.getJoueur2gain().clear();
            Joueur.getJoueur2perte().clear();
            break;
          }
          case 2: {
            System.out.println("--------- " + Joueur.getJoueur3Nom());

            Jeu.procAffResult(joueur);

            Joueur.getJoueur3gain().clear();
            Joueur.getJoueur3perte().clear();
            break;
          }
        }
      }

      /**************************** 17. DEMANDER AU JOUEUR S'IL SOUHAITE CONTINUER LA PARTIE */
      Jeu.procContinuerPartie();
    } // Fin de la partie
    while (Partie.isContinuerParti());
  }
}