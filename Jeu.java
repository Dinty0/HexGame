import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

class Jeu
{
	private Plateau _plateau;
	private Joueur _joueur1;
	private Joueur _joueur2;
	private Scanner saisie;
	private boolean _premierTour;

	public Jeu(int taille)
	{
		_plateau = new Plateau(taille);
		_joueur1 = new Joueur(1,true);
		_joueur2 = new Joueur(2,true);
		_premierTour = true;
	}


	public Plateau getPlateau()
	{
		return _plateau;
	}

	public void afficher(Plateau plateau)
	{
		System.out.print("\n");
		for (int i=0; i<plateau.getTaille(); i++)
		{
			for (int k=0; k<i; k++)
			{
				System.out.print(" ");
			}
			for (int j=0; j<plateau.getTaille(); j++)
			{
				System.out.print(" "+plateau.getPion(i,j).getCouleur());
			}
			System.out.println("");
		}
		System.out.print("\n");
	}

	public void afficherDist(Plateau plateau)
	{
		System.out.print("\n");
		for (int i=0; i<plateau.getTaille(); i++)
		{
			for (int k=0; k<i; k++)
			{
				System.out.print(" ");
			}
			for (int j=0; j<plateau.getTaille(); j++)
			{
				System.out.print(" "+plateau.getPion(i,j).getDist());
			}
			System.out.println("");
		}
		System.out.print("\n");
	}

	public void afficherPere()
	{
		System.out.print("\n");
		for (int i=0; i<_plateau.getTaille(); i++)
		{
			for (int k=0; k<i; k++)
			{
				System.out.print(" ");
			}
			for (int j=0; j<_plateau.getTaille(); j++)
			{
				System.out.print(" "+_plateau.getPion(i,j).getXRep()+","+_plateau.getPion(i,j).getYRep());
			}
			System.out.println("");
		}
		System.out.print("\n");
	}

	public Joueur prochainJoueur(Joueur j)
	{
		if (j.getCouleur()==_joueur1.getCouleur())
		{
			return _joueur2;
		}
		else
		{
			return _joueur1;
		}
	}

	public boolean ajoutePion(int c, int x, int y)
	{
		return _plateau.ajoutePion(c,x,y);
	}

	public Plateau recopiePlateau(Plateau plat)
	{
		int t = plat.getTaille();
		Plateau copie = new Plateau(t);

		for (int i=0; i<t; i++)
		{
			for (int j=0; j<t; j++)
			{
				int col=plat.getPion(i,j).getCouleur();
				copie.ajoutePion(col,i,j);
			}
		}
		return copie;
	}

	public void ajoutePionOrdi()
	{
		Plateau copie = recopiePlateau(_plateau);

		Random r = new Random();

		if (_premierTour)
		{
			int pos2 = r.nextInt(copie.getTaille());
			while (copie.getPion(0,pos2).getCouleur() != 0)
			{
				pos2 = r.nextInt(copie.getTaille());
			}
			//Pion trouvé ajouté sur le vrai plateau.
			_plateau.ajoutePion(2,0,pos2);
			_premierTour = false;
		}
		else
		{

			ArrayList<Pion> ar1 = new ArrayList<Pion>();
			ArrayList<Pion> ar2 = new ArrayList<Pion>();

			for (int j =0; j<copie.getTaille(); j++)
			{
				if (copie.getPion(0, j).getCouleur() == 2)
				{
					ar1.add(copie.getPion(0,j));
				}
			}
		
			for (Pion p : ar1)
			{
				copie.initDistance(p.getX(),p.getY());
			}

			System.out.println("Taille ar1 : " + ar1.size());
			copie.parcoursPlateau(ar1.get(0).getX(), ar1.get(0).getY(), ar1.get(0));

			int min = copie.getTaille()*copie.getTaille()+1;
			Pion res=new Pion();
			for (int k=0; k<copie.getTaille(); k++)
			{
				if (copie.getPion(copie.getTaille()-1,k).getCouleur() == 2)
				{
					copie.getComposante().clear();
					copie.testCompoVoisin(copie.getTaille()-1,k);

					for (Pion p : copie.getComposante())
					{
						if (p.getDist() <= min)
						{
							res=p;
							min = p.getDist();
						}
					}
				}
				else 
				{
					if (copie.getPion(copie.getTaille()-1,k).getDist() <= min)
					{
						res = copie.getPion(copie.getTaille()-1,k);
						min = copie.getPion(copie.getTaille()-1,k).getDist();
					}
				}
			}

			System.out.println("Min : " + min);
			System.out.println("\nDistance de copie");
			afficherDist(copie);

			int x = res.getX();
			int y = res.getY();

			System.out.println("\nres : ");
			res.afficher();
			Pion p = new Pion();

			if (res.getCouleur() == 0)
			{
				p = res;
			}
			else
			{
				for (int i=0; i<copie.getTaille()-1; i++)
				{
					for (int j=0; j<copie.getTaille()-1; j++)
					{
						if (i == x-1 && j == y)
						{		
							if (copie.getPion(i,j).getCouleur() == 0 && copie.getPion(i,j).getDist() <= res.getDist())
							{
								p = copie.getPion(i,j);
							}
						}
						else if (i == x-1 && j == y+1)
						{		
							if (copie.getPion(i,j).getCouleur() == 0 && copie.getPion(i,j).getDist() <= res.getDist())
							{
								p = copie.getPion(i,j);
							}
						}
						else if (i == x && j == y-1)
						{		
							if (copie.getPion(i,j).getCouleur() == 0 && copie.getPion(i,j).getDist() <= res.getDist())
							{
								p = copie.getPion(i,j);
							}
						}
						else if (i == x && j == y+1)
						{		
							if (copie.getPion(i,j).getCouleur() == 0 && copie.getPion(i,j).getDist() <= res.getDist())
							{
								p = copie.getPion(i,j);
							}
						}
						else if (i == x+1 && j == y-1)
						{		
							if (copie.getPion(i,j).getCouleur() == 0 && copie.getPion(i,j).getDist() <= res.getDist())
							{
								p = copie.getPion(i,j);
							}
						}
						else if (i == x+1 && j == y)
						{		
							if (copie.getPion(i,j).getCouleur() == 0 && copie.getPion(i,j).getDist() <= res.getDist())
							{
								p = copie.getPion(i,j);
							}
						}
						else
						{ 

						}
					}
				}
			}

			p.afficher();
			System.out.println("Tableau copié");
			afficher(copie);
			System.out.println("\nDistance de copie");
			afficherDist(copie);

			//Pion trouvé ajouté sur le vrai plateau.
			_plateau.ajoutePion(2,p.getX(),p.getY());
		}
		
	}

	public void joueDeuxHumains()
	{
		boolean gagne = false;
		saisie = new Scanner(System.in);
		Joueur joueurCourant = new Joueur(0,true);
		boolean ajout = false;
		int coordX;
		int coordY;

		while(!gagne)
		{
			afficher(_plateau);

			joueurCourant = prochainJoueur(joueurCourant);

			System.out.println("Joueur " + joueurCourant.getCouleur() +" : Choisissez les coordonnées du Pion à ajouter : ");
			coordX = saisie.nextInt();
			coordY = saisie.nextInt();

			ajout = ajoutePion(joueurCourant.getCouleur(),coordX,coordY);

			while (!ajout)
			{
				afficher(_plateau);
				System.out.println("Joueur " + joueurCourant.getCouleur() +" : Coordonnées non valides, recommencez : ");
				coordX = saisie.nextInt();
				coordY = saisie.nextInt();
				ajout = ajoutePion(joueurCourant.getCouleur(),coordX,coordY);
			} 
			if (_plateau.existeCheminCotes(joueurCourant.getCouleur()))
			{
				gagne = true;
				afficher(_plateau);
				afficherPere();
				_plateau = new Plateau(_plateau.getTaille());
				System.out.println("Joueur " + joueurCourant.getCouleur() + " a gagné !");
			}

		}
	}

	public void joueOrdiHumain()
	{
		boolean gagne = false;
		 saisie = new Scanner(System.in);
		Joueur joueurCourant = new Joueur(0,true);
		boolean ajout = false;
		int coordX;
		int coordY;

		_joueur2.setHumain(false);

		while(!gagne)
		{
			afficher(_plateau);

			joueurCourant = prochainJoueur(joueurCourant);

			if (joueurCourant.estHumain())
			{
				System.out.println("Joueur " + joueurCourant.getCouleur() +" : Choisissez les coordonnées du Pion à ajouter : ");
				coordX = saisie.nextInt();
				coordY = saisie.nextInt();

				ajout = ajoutePion(joueurCourant.getCouleur(),coordX,coordY);

				while (!ajout)
				{
					afficher(_plateau);
					System.out.println("Joueur " + joueurCourant.getCouleur() +" : Coordonnées non valides, recommencez : ");
					coordX = saisie.nextInt();
					coordY = saisie.nextInt();
					ajout = ajoutePion(joueurCourant.getCouleur(),coordX,coordY);
				} 
			}
			else
			{
				ajoutePionOrdi();
			}

			if (_plateau.existeCheminCotes(joueurCourant.getCouleur()))
			{
				gagne = true;
				afficher(_plateau);
				afficherPere();
				_plateau = new Plateau(_plateau.getTaille());
				System.out.println("Joueur " + joueurCourant.getCouleur() + " a gagné !");
			}

		}
	}

	public void test()
	{
		int choix;
		saisie = new Scanner(System.in);
		System.out.println("Quelle fonction appeler ?\n 1. ajouterPion \n 2. afficheComposante \n 3. existeCheminCases \n 4. existeCheminCotes");
		System.out.println(" 5. relieComposantes \n 6. calculeDistance \n 7. evaluerPionZ \n 8. Quitter");
		choix = saisie.nextInt();

		afficher(_plateau);
		switch (choix)
		{
			case 1 :
				System.out.println("Combien de pions voulez vous ajouter ?");
				int nbPion = saisie.nextInt();
				while (nbPion > 0)
				{
					System.out.println("Saisissez les coordonnées du pion a ajouter ('x' 'y')");
					int coordX = saisie.nextInt();
					int coordY = saisie.nextInt();
					System.out.println("Saisissez la COULEUR du pion a ajouter ('1' ou '2')");
					int couleur = saisie.nextInt();
					_plateau.ajoutePion(couleur, coordX, coordY);
					nbPion--;
				}
				afficher(_plateau);
				break;
			case 2 :
				System.out.println("Saisissez les coordonnées du pion dont vous voulez afficher la composante ('x' 'y')");
				int coordX = saisie.nextInt();
				int coordY = saisie.nextInt();
				_plateau.afficheComposante(coordX,coordY);
				break;
			case 3 :
				System.out.println("Saisissez les coordonnées du 1er pion ('x' 'y')");
				coordX = saisie.nextInt();
				coordY = saisie.nextInt();
				System.out.println("Saisissez les coordonnées du 2eme pion ('x' 'y')");
				int coordX2 = saisie.nextInt();
				int coordY2 = saisie.nextInt();
				afficher(_plateau);
				System.out.println("existeCheminCase(("+coordX+","+coordY+"),("+coordX2+","+coordY2+")) : "+_plateau.existeCheminCases(_plateau.getPion(coordX,coordY),_plateau.getPion(coordX2,coordY2)));
				break;
			case 4 :
				System.out.println("Saisissez la couleur a tester ('1' ou '2')");
				int couleur = saisie.nextInt();
				afficher(_plateau);
				System.out.println("existeCheminCotes ("+couleur+") : "+_plateau.existeCheminCotes(couleur));
				break;
			case 5 :
				System.out.println("Saisissez les coordonnées du pion a tester ('x' 'y')");
				coordX = saisie.nextInt();
				coordY = saisie.nextInt();
				System.out.println("Saisissez la couleur du pion a tester ('1' ou '2')");
				couleur = saisie.nextInt();
				afficher(_plateau);
				System.out.println("relieComposantes("+couleur+","+coordX+","+coordY+") : " + _plateau.relieComposantes(couleur,coordX,coordY));
				break;
			case 6 :
				System.out.println("Saisissez les coordonnées du 1er pion ('x' 'y')");
				coordX = saisie.nextInt();
				coordY = saisie.nextInt();
				System.out.println("Saisissez les coordonnées du 2eme pion ('x' 'y')");
				coordX2 = saisie.nextInt();
				coordY2 = saisie.nextInt();
				afficher(_plateau);
				System.out.println("calculeDistance(("+coordX+","+coordY+"),("+coordX2+","+coordY2+")) : "+_plateau.calculeDistance(_plateau.getPion(coordX,coordY),_plateau.getPion(coordX2,coordY2)));
				System.out.println("Affichage des distances");
				afficherDist(_plateau);
				break;
			case 7 :
				int cpion = 0;
				coordX = 100;
				coordY = 100;
				while (cpion == 0)
				{
					System.out.println("Saisissez les coordonnées du pion (sa couleur ne doit pas être 0) ('x' 'y')");
					coordX = saisie.nextInt();
					coordY = saisie.nextInt();
					cpion = _plateau.getPion(coordX,coordY).getCouleur();
				}
				_plateau.parcoursPlateau(coordX,coordY,_plateau.getPion(coordX,coordY));
				System.out.println("Affichage des distances");
				afficherDist(_plateau);
				afficher(_plateau);
				break;
			case 8 :
				System.out.println("Au revoir.");
				break;
		}
	}

	public void menuChoix()
	{
		int choix;
		saisie = new Scanner(System.in);
		System.out.println("Que voulez vous faire ?\n 1. Jouer a 2 \n 2. Jouer contre l'ordi \n 3. Tester les fonctions \n 4. Quitter");
		choix = saisie.nextInt();

		switch (choix)
		{
			case 1 : _plateau = new Plateau(_plateau.getTaille());
					 joueDeuxHumains();
					 menuChoix();
					 break;
			case 2 : _plateau = new Plateau(_plateau.getTaille());
					 joueOrdiHumain();
					 menuChoix();
					 break;
			case 3 : 
					 test();
					 menuChoix();
					 break;
			case 4 : System.out.println("Au revoir.");
					 break;
		}
	}


	public static void main(String[] args)
	{
		int taille;
		Scanner saisie = new Scanner(System.in);
		System.out.println("Entrez la taille du plateau sur lequel vous voulez jouer");
		taille = saisie.nextInt();
		Jeu j = new Jeu(taille);

		j.menuChoix();
		
		j.getPlateau().ajoutePion(1,0,0);
		j.getPlateau().ajoutePion(1,0,1);
		j.getPlateau().ajoutePion(1,1,2);
		j.getPlateau().ajoutePion(1,1,1);
		j.getPlateau().ajoutePion(1,1,1);
		j.getPlateau().ajoutePion(1,1,3);
		j.getPlateau().ajoutePion(1,4,4);
		j.getPlateau().ajoutePion(1,4,3);
		j.getPlateau().ajoutePion(2,4,0);
		j.getPlateau().ajoutePion(2,3,0);
		j.afficher(j.getPlateau());
		
		System.out.println("Affiche composante (0,1)");
		j.getPlateau().afficheComposante(0,1);

		System.out.println("");

		boolean b1 = j.getPlateau().existeCheminCases(j.getPlateau().getPion(0,0),j.getPlateau().getPion(1,3));
		System.out.println("Existe chemin cases (0,0) (1,3) : "+b1);
	 	b1 = j.getPlateau().existeCheminCases(j.getPlateau().getPion(1,0),j.getPlateau().getPion(0,3));
		System.out.println("Existe chemin cases (1,0) (0,3) : "+b1);

		System.out.println("Existe chemin coté (gauche-droite) :"+j.getPlateau().existeCheminCotes(1));

		System.out.println("Calcule distance entre (0,0) (4,4) : "+j.getPlateau().calculeDistance(j.getPlateau().getPion(0,0),j.getPlateau().getPion(4,4)));
		System.out.println();
		j.afficherDist(j.getPlateau());
		
	} 
}