import java.util.ArrayList;

public class Plateau
{
	private Pion[][] _plat;
	private int _taille;
	public  ArrayList<Pion> composante;

	public Plateau(int n)
	{
		_plat = new Pion[n][n];
		_taille = n;

		for (int i=0; i<n; i++)
		{
			for (int j=0; j<n; j++)
			{
				_plat[i][j] = new Pion(i,j,((n*n)+1));
			}
		}
		composante = new ArrayList<Pion>();
	}

	public Pion[][] getPlateau()
	{
		return _plat;
	}

	public int getTaille()
	{
		return _taille;
	}

	public Pion getPion(int x, int y)
	{
		return _plat[x][y];
	}

	public int getCouleurPion(int x, int y)
	{
		return _plat[x][y].getCouleur();
	} 

	public ArrayList<Pion> getComposante()
	{
		return composante;
	}

	public Pion testVoisins(int x, int y)
	{

		if ((x==0) && (y==0)) // Coin Haut-Gauche
		{
			if (_plat[x][y].testClasse(_plat[x][y+1])) // teste Droit
			{
				return _plat[x][y+1];
			}
			if (_plat[x][y].testClasse(_plat[x+1][y])) // teste Bas-Droit
			{
				return _plat[x+1][y];
			}
		}
		else if ((x==0) && (y==_taille-1)) // Coin Haut-Droite
		{
			if (_plat[x][y].testClasse(_plat[x][y-1])) // teste Gauche
			{
				return _plat[x][y-1];
			}
			if (_plat[x][y].testClasse(_plat[x+1][y-1])) // teste Bas-Gauche
			{
				return _plat[x+1][y-1];
			}
			if (_plat[x][y].testClasse(_plat[x+1][y])) // teste Bas-Droit
			{
				return _plat[x+1][y];
			}
		}
		else if ((x==_taille-1) && (y==_taille-1)) // Coin Bas-Droite
		{
			if (_plat[x][y].testClasse(_plat[x-1][y])) // teste Haut-Gauche
			{
				return _plat[x-1][y];
			}
			if (_plat[x][y].testClasse(_plat[x][y-1]))
			{
				return _plat[x][y-1];
			}
		}
		else if ((x==_taille-1) && (y==0)) // Coin Bas-Gauche
		{
			if (_plat[x][y].testClasse(_plat[x-1][y]))
			{
				return _plat[x-1][y];
			}
			if (_plat[x][y].testClasse(_plat[x-1][y+1])) // teste Haut-Droite
			{
				return _plat[x-1][y+1];
			}
			if (_plat[x][y].testClasse(_plat[x][y+1]))
			{
				return _plat[x][y+1];
			}
		}
		else if ((x==0) && (y>0) && (y<_taille-1)) // Bord Haut
		{
			if (_plat[x][y].testClasse(_plat[x][y-1]))
			{
				return _plat[x][y-1];
			}
			if (_plat[x][y].testClasse(_plat[x][y+1]))
			{
				return _plat[x][y+1];
			}
			if (_plat[x][y].testClasse(_plat[x+1][y-1]))
			{
				return _plat[x+1][y-1];
			}
			if (_plat[x][y].testClasse(_plat[x+1][y]))
			{
				return _plat[x+1][y];
			}
		}
		else if ((x==_taille-1) && (y>0) && (y<_taille-1)) // Bord Bas
		{
			if (_plat[x][y].testClasse(_plat[x-1][y]))
			{
				return _plat[x-1][y];
			}
			if (_plat[x][y].testClasse(_plat[x-1][y+1]))
			{
				return _plat[x-1][y+1];
			}
			if (_plat[x][y].testClasse(_plat[x][y-1]))
			{
				return _plat[x][y-1];
			}
			if (_plat[x][y].testClasse(_plat[x][y+1]))
			{
				return _plat[x][y+1];
			}
		}
		else if ((y==0) && (x>0) && (x<_taille-1)) // Bord Gauche
		{
			if (_plat[x][y].testClasse(_plat[x-1][y]))
			{
				return _plat[x-1][y];
			}
			if (_plat[x][y].testClasse(_plat[x-1][y+1]))
			{
				return _plat[x-1][y+1];
			}
			if (_plat[x][y].testClasse(_plat[x][y+1]))
			{
				return _plat[x][y+1];
			}
			if (_plat[x][y].testClasse(_plat[x+1][y]))
			{
				return _plat[x+1][y];
			}
		}
		else if ((y==_taille-1) && (x>0) && (x<_taille-1)) // Bord Droite
		{
			if (_plat[x][y].testClasse(_plat[x-1][y]))
			{
				return _plat[x-1][y];
			}
			if (_plat[x][y].testClasse(_plat[x][y-1]))
			{
				return _plat[x][y-1];
			}
			if (_plat[x][y].testClasse(_plat[x+1][y-1]))
			{
				return _plat[x+1][y-1];
			}
			if (_plat[x][y].testClasse(_plat[x+1][y]))
			{
				return _plat[x+1][y];
			}
		}
		else // cas général
		{
			if (_plat[x][y].testClasse(_plat[x-1][y]))
			{
				return _plat[x-1][y];
			}
			if (_plat[x][y].testClasse(_plat[x-1][y+1]))
			{
				return _plat[x-1][y+1];
			}
			if (_plat[x][y].testClasse(_plat[x][y-1]))
			{
				return _plat[x][y-1];
			}
			if (_plat[x][y].testClasse(_plat[x][y+1]))
			{
				return _plat[x][y+1];
			}
			if (_plat[x][y].testClasse(_plat[x+1][y-1]))
			{
				return _plat[x+1][y-1];
			}
			if (_plat[x][y].testClasse(_plat[x+1][y]))
			{
				return _plat[x+1][y];
			}
		}

		return _plat[x][y]; // Si on n'as pas trouvé de pions adjacents de la même couleur
	}

	public boolean relieComposantes(int c, int x, int y)
	{

		Pion v = testVoisins(x,y);

		if (v == _plat[x][y])
		{
			return false;
		}
		else
		{
			int ca = _plat[x][y].getCouleur();
			int xrepa = _plat[x][y].getXRep();
			int yrepa = _plat[x][y].getYRep();

			_plat[x][y].setCouleur(c);
			_plat[x][y].setRep(v);
			if (testVoisins(x,y) == _plat[x][y])
			{
				return false;
			}
			else
			{
				_plat[x][y].setCouleur(ca);
				_plat[x][y].setXRep(xrepa);
				_plat[x][y].setYRep(yrepa);
				return true;
			}
		}
	}

	public Pion classe(Pion p)
	{
		int x = p.getX();
		int y = p.getY();

		if (_plat[x][y].getRep(this) != _plat[x][y])
		{
			_plat[x][y].setRep(classe(_plat[x][y].getRep(this)));
		}

		return _plat[x][y].getRep(this);

	}

	public boolean testComposante(Pion p1, Pion p2)
	{
		if ((p1.getCouleur() == p2.getCouleur()) && (classe(p1) == classe(p2)))
		{
			return true;
		} 
		else 
		{ 
			return false; 
		}
	}

	public void union(Pion p1, Pion p2)
	{
		Pion rep1 = classe(p1);
		Pion rep2 = classe(p2);

		if (rep1 != rep2)
		{
			if (rep1.getRang() < rep2.getRang())
			{
				rep1.setRep(rep2);
			}
			else if (rep1.getRang() > rep2.getRang())
			{
				rep2.setRep(rep1);
			}
			else
			{
				rep1.setRep(rep2);
				rep2.setRang(rep2.getRang()+1);
			}
		}
	}

	public boolean ajoutePion(int c, int x, int y)
	{
		
		
		if ((x < _taille) && (y <_taille) && (x >= 0) && (y >= 0) && (_plat[x][y].getCouleur() == 0))
		{
			_plat[x][y].setCouleur(c);
			Pion v = testVoisins(x,y);
			
			if (relieComposantes(c,x,y))
			{
				union(_plat[x][y],v);
				Pion w = testVoisins(x,y);
				union(w,v);
			}
			else
			{
				union(_plat[x][y],v);
			}

			return true;
		}
		else
		{
			return false;
		}
	}

	public void testCompoVoisin (int x, int y)
	{
		
		if (!(composante.contains(_plat[x][y])))
		{
			composante.add(_plat[x][y]);
			if ((x==0) && (y==0)) // Coin Haut-Gauche
			{
				if (testComposante(_plat[x][y],_plat[x][y+1])) // teste Droit
				{
					testCompoVoisin(x,y+1);
				}
				if (testComposante(_plat[x][y],_plat[x+1][y])) // teste Bas-Droit
				{
				
					testCompoVoisin(x+1,y);
				}
			}
			else if ((x==0) && (y==_taille-1)) // Coin Haut-Droite
			{
				if (testComposante(_plat[x][y],_plat[x][y-1])) // teste Gauche
				{

					testCompoVoisin(x,y-1);
				}
				if (testComposante(_plat[x][y],_plat[x+1][y-1])) // teste Bas-Gauche
				{

					testCompoVoisin(x+1,y-1);
				}
				if (testComposante(_plat[x][y],_plat[x+1][y])) // teste Bas-Droit
				{

					testCompoVoisin(x+1,y);
				}
			}
			else if ((x==_taille-1) && (y==_taille-1)) // Coin Bas-Droite
			{
				if (testComposante(_plat[x][y],_plat[x-1][y])) // teste Haut-Gauche
				{

					testCompoVoisin(x-1,y);
				}
				if (testComposante(_plat[x][y],_plat[x][y-1]))
				{

					testCompoVoisin(x,y-1);
				}
			}
			else if ((x==_taille-1) && (y==0)) // Coin Bas-Gauche
			{
				if (testComposante(_plat[x][y],_plat[x-1][y]))
				{

					testCompoVoisin(x-1,y);
				}
				if (testComposante(_plat[x][y],_plat[x-1][y+1])) // teste Haut-Droite
				{

					testCompoVoisin(x-1,y+1);
				}
				if (testComposante(_plat[x][y],_plat[x][y+1]))
				{

					testCompoVoisin(x,y+1);
				}
			}
			else if ((x==0) && (y>0) && (y<_taille-1)) // Bord Haut
			{
				if (testComposante(_plat[x][y],_plat[x][y-1]))
				{
					testCompoVoisin(x,y-1);
				}
				if (testComposante(_plat[x][y],_plat[x][y+1]))
				{
					testCompoVoisin(x,y+1);
				}
				if (testComposante(_plat[x][y],_plat[x+1][y-1]))
				{
					testCompoVoisin(x+1,y-1);
				}
				if (testComposante(_plat[x][y],_plat[x+1][y]))
				{
					testCompoVoisin(x+1,y);
				}
			}
			else if ((x==_taille-1) && (y>0) && (y<_taille-1)) // Bord Bas
			{
				if (testComposante(_plat[x][y],_plat[x-1][y]))
				{
					testCompoVoisin(x-1,y);
				}
				if (testComposante(_plat[x][y],_plat[x-1][y+1]))
				{
					testCompoVoisin(x-1,y+1);
				}
				if (testComposante(_plat[x][y],_plat[x][y-1]))
				{

					testCompoVoisin(x,y-1);
				}
				if (testComposante(_plat[x][y],_plat[x][y+1]))
				{
					testCompoVoisin(x,y+1);
				}
			}
			else if ((y==0) && (x>0) && (x<_taille-1)) // Bord Gauche
			{
				if (testComposante(_plat[x][y],_plat[x-1][y]))
				{

					testCompoVoisin(x-1,y);
				}
				if (testComposante(_plat[x][y],_plat[x-1][y+1]))
				{

					testCompoVoisin(x-1,y+1);
				}
				if (testComposante(_plat[x][y],_plat[x][y+1]))
				{

					testCompoVoisin(x,y+1);
				}
				if (testComposante(_plat[x][y],_plat[x+1][y]))
				{

					testCompoVoisin(x+1,y);
				}
			}
			else if ((y==_taille-1) && (x>0) && (x<_taille-1)) // Bord Droite
			{
				if (testComposante(_plat[x][y],_plat[x-1][y]))
				{

					testCompoVoisin(x-1,y);
				}
				if (testComposante(_plat[x][y],_plat[x][y-1]))
				{

					testCompoVoisin(x,y-1);
				}
				if (testComposante(_plat[x][y],_plat[x+1][y-1]))
				{

					testCompoVoisin(x+1,y-1);
				}
				if (testComposante(_plat[x][y],_plat[x+1][y]))
				{

					testCompoVoisin(x+1,y);
				}
			}
			else // cas général
			{
				if (testComposante(_plat[x][y],_plat[x-1][y]))
				{

					testCompoVoisin(x-1,y);
				}
				if (testComposante(_plat[x][y],_plat[x-1][y+1]))
				{

					testCompoVoisin(x-1,y+1);
				}
				if (testComposante(_plat[x][y],_plat[x][y-1]))
				{

					testCompoVoisin(x,y-1);
				}
				if (testComposante(_plat[x][y],_plat[x][y+1]))
				{

					testCompoVoisin(x,y+1);
				}
				if (testComposante(_plat[x][y],_plat[x+1][y-1]))
				{

					testCompoVoisin(x+1,y-1);
				}
				if (testComposante(_plat[x][y],_plat[x+1][y]))
				{

					testCompoVoisin(x+1,y);
				}
			}

		}
	}


	public void afficheComposante(int x, int y)
	{
		testCompoVoisin(x,y);
		for (Pion p : composante)
		{
			p.afficher();
		}
		composante.clear();
	}
	
	public boolean existeCheminCases(Pion p1, Pion p2) 
	{
		if (p1.getCouleur() == p2.getCouleur())
		{
			if (classe(p1) == classe(p2))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}

	public boolean existeCheminCotes(int c)
	{
		ArrayList<Pion> bord1 = new ArrayList<Pion>();
		ArrayList<Pion> bord2 = new ArrayList<Pion>();

		if (c==2)
		{
			for (int i=0; i<_taille; ++i)
			{
				if (_plat[0][i].getCouleur() == c)
				{
					bord1.add(classe(_plat[0][i]));
				}
				if (_plat[_taille-1][i].getCouleur() == c)
				{
					bord2.add(classe(_plat[_taille-1][i]));
				}
			}
			for (Pion p : bord1)
			{
				if (bord2.contains(p))
				{
					return true;
				}
			}
			return false;
		}
		else
		{
			for (int i=0; i<_taille; ++i)
			{
				if (_plat[i][0].getCouleur() == c)
				{
					bord1.add(classe(_plat[i][0]));
				}
				if (_plat[i][_taille-1].getCouleur() == c)
				{
					bord2.add(classe(_plat[i][_taille-1]));
				}
			}

			for (Pion p : bord1)
			{
				if (bord2.contains(p))
				{
					return true;
				}
			}
			return false;
		}
	}
	

	public void initDistance(int x, int y)
	{
		testCompoVoisin(x,y);
		for (Pion p : composante)
		{
			p.setDist(0);
		}
		composante.clear();
	}

	public Pion miniCompoDistance(int x, int y)
	{
		int min = (_taille*_taille)+1;
		Pion res = new Pion();
		composante.clear();
		testCompoVoisin(x,y);
		for (Pion p : composante)
		{
			p.afficher();
			if (p.getDist() < min)
			{
				min = p.getDist();
				res = p;
			}
		}
		composante.clear();
		return res;
	}


	public void parcoursPlateau(int x, int y, Pion p)
	{
		int dist = _plat[x][y].getDist() + 1;
		int c = 0;


		if (p.getCouleur() == 1)
		{
			c = 2;
		}
		else
		{
			c = 1;
		}
		if (!(composante.contains(_plat[x][y])) && _plat[x][y].getCouleur() != c)
		{
			composante.add(_plat[x][y]);
			
			if ((x==0) && (y==0)) // Coin Haut-Gauche
			{
				if (_plat[x][y+1].getCouleur() == 0)
				{
					_plat[x][y+1].setDist(Math.min(dist,_plat[x][y+1].getDist()));
				}
				else if (_plat[x][y+1].getCouleur() != c)
				{
					_plat[x][y+1].setDist(Math.min(dist-1,_plat[x][y+1].getDist()));
				}
				if (_plat[x+1][y].getCouleur() == 0)
				{
					_plat[x+1][y].setDist(Math.min(dist,_plat[x+1][y].getDist()));
				}
				else if (_plat[x+1][y].getCouleur() != c)
				{
					_plat[x+1][y].setDist(Math.min(dist-1,_plat[x+1][y].getDist()));
				}
				parcoursPlateau(x,y+1,p);
				parcoursPlateau(x+1,y,p);
			}
			else if ((x==0) && (y==_taille-1)) // Coin Haut-Droite
			{
				if (_plat[x][y-1].getCouleur() == 0)
				{
					_plat[x][y-1].setDist(Math.min(dist,_plat[x][y-1].getDist()));
				}
				else if (_plat[x][y-1].getCouleur() != c)
				{
					_plat[x][y-1].setDist(Math.min(dist-1,_plat[x][y-1].getDist()));
				}
				if (_plat[x+1][y].getCouleur() == 0)
				{
					_plat[x+1][y].setDist(Math.min(dist,_plat[x+1][y].getDist()));
				}
				else if (_plat[x+1][y].getCouleur() != c)
				{
					_plat[x+1][y].setDist(Math.min(dist-1,_plat[x+1][y].getDist()));
				}
				if (_plat[x+1][y-1].getCouleur() == 0)
				{
					_plat[x+1][y-1].setDist(Math.min(dist,_plat[x+1][y-1].getDist()));
				}
				else if (_plat[x+1][y-1].getCouleur() != c)
				{
					_plat[x+1][y-1].setDist(Math.min(dist-1,_plat[x+1][y-1].getDist()));
				}
				parcoursPlateau(x,y-1,p);
				parcoursPlateau(x+1,y-1,p);
				parcoursPlateau(x+1,y,p);
			}
			else if ((x==_taille-1) && (y==_taille-1)) // Coin Bas-Droite
			{
				if (_plat[x-1][y].getCouleur() == 0)
				{
					_plat[x-1][y].setDist(Math.min(dist,_plat[x-1][y].getDist()));
				}
				else if (_plat[x-1][y].getCouleur() != c)
				{
					_plat[x-1][y].setDist(Math.min(dist-1,_plat[x-1][y].getDist()));
				}
				if (_plat[x][y-1].getCouleur() == 0)
				{
					_plat[x][y-1].setDist(Math.min(dist,_plat[x][y-1].getDist()));
				}
				else if (_plat[x][y-1].getCouleur() != c)
				{
					_plat[x][y-1].setDist(Math.min(dist-1,_plat[x][y-1].getDist()));
				}
				parcoursPlateau(x-1,y,p);
				parcoursPlateau(x,y-1,p);
			}
			else if ((x==_taille-1) && (y==0)) // Coin Bas-Gauche
			{
				if (_plat[x][y+1].getCouleur() == 0)
				{
					_plat[x][y+1].setDist(Math.min(dist,_plat[x][y+1].getDist()));
				}
				else if (_plat[x][y+1].getCouleur() != c)
				{
					_plat[x][y+1].setDist(Math.min(dist-1,_plat[x][y+1].getDist()));
				}
				
				if (_plat[x-1][y].getCouleur() == 0)
				{
					_plat[x-1][y].setDist(Math.min(dist,_plat[x-1][y].getDist()));
				}
				else if (_plat[x-1][y].getCouleur() != c)
				{
					_plat[x-1][y].setDist(Math.min(dist-1,_plat[x-1][y].getDist()));
				}
				
				if (_plat[x-1][y+1].getCouleur() == 0)
				{
					_plat[x-1][y+1].setDist(Math.min(dist,_plat[x-1][y+1].getDist()));
				}
				else if (_plat[x-1][y+1].getCouleur() != c)
				{
					_plat[x-1][y+1].setDist(Math.min(dist-1,_plat[x-1][y+1].getDist()));
				}
				parcoursPlateau(x-1,y,p);
				parcoursPlateau(x-1,y+1,p);
				parcoursPlateau(x,y+1,p);
			}
			else if ((x==0) && (y>0) && (y<_taille-1)) // Bord Haut
			{
				if (_plat[x][y+1].getCouleur() == 0)
				{
					_plat[x][y+1].setDist(Math.min(dist,_plat[x][y+1].getDist()));
				}
				else if (_plat[x][y+1].getCouleur() != c)
				{
					_plat[x][y+1].setDist(Math.min(dist-1,_plat[x][y+1].getDist()));
				}
				
				if (_plat[x+1][y].getCouleur() == 0)
				{
					_plat[x+1][y].setDist(Math.min(dist,_plat[x+1][y].getDist()));
				}
				else if (_plat[x+1][y].getCouleur() != c)
				{
					_plat[x+1][y].setDist(Math.min(dist-1,_plat[x+1][y].getDist()));
				}
				
				if (_plat[x][y-1].getCouleur() == 0)
				{
					_plat[x][y-1].setDist(Math.min(dist,_plat[x][y-1].getDist()));
				}
				else if (_plat[x][y-1].getCouleur() != c)
				{
					_plat[x][y-1].setDist(Math.min(dist-1,_plat[x][y-1].getDist()));
				}
				
				if (_plat[x+1][y-1].getCouleur() == 0)
				{
					_plat[x+1][y-1].setDist(Math.min(dist,_plat[x+1][y-1].getDist()));
				}
				else if (_plat[x+1][y-1].getCouleur() != c)
				{
					_plat[x+1][y-1].setDist(Math.min(dist-1,_plat[x+1][y-1].getDist()));
				}
				parcoursPlateau(x,y-1,p);
				parcoursPlateau(x,y+1,p);
				parcoursPlateau(x+1,y-1,p);
				parcoursPlateau(x+1,y,p);
			}
			else if ((x==_taille-1) && (y>0) && (y<_taille-1)) // Bord Bas
			{
				if (_plat[x][y+1].getCouleur() == 0)
				{
					_plat[x][y+1].setDist(Math.min(dist,_plat[x][y+1].getDist()));
				}
				else if (_plat[x][y+1].getCouleur() != c)
				{
					_plat[x][y+1].setDist(Math.min(dist-1,_plat[x][y+1].getDist()));
				}
				
				if (_plat[x][y-1].getCouleur() == 0)
				{
					_plat[x][y-1].setDist(Math.min(dist,_plat[x][y-1].getDist()));
				}
				else if (_plat[x][y-1].getCouleur() != c)
				{
					_plat[x][y-1].setDist(Math.min(dist-1,_plat[x][y-1].getDist()));
				}
				
				if (_plat[x-1][y].getCouleur() == 0)
				{
					_plat[x-1][y].setDist(Math.min(dist,_plat[x-1][y].getDist()));
				}
				else if (_plat[x-1][y].getCouleur() != c)
				{
					_plat[x-1][y].setDist(Math.min(dist-1,_plat[x-1][y].getDist()));
				}
				
				if (_plat[x-1][y+1].getCouleur() == 0)
				{
					_plat[x-1][y+1].setDist(Math.min(dist,_plat[x-1][y+1].getDist()));
				}
				else if (_plat[x-1][y+1].getCouleur() != c)
				{
					_plat[x-1][y+1].setDist(Math.min(dist-1,_plat[x-1][y+1].getDist()));
				}
				
				parcoursPlateau(x-1,y,p);
				parcoursPlateau(x-1,y+1,p);
				parcoursPlateau(x,y-1,p);
				parcoursPlateau(x,y+1,p);
			}
			else if ((y==0) && (x>0) && (x<_taille-1)) // Bord Gauche
			{
				if (_plat[x][y+1].getCouleur() == 0)
				{
					_plat[x][y+1].setDist(Math.min(dist,_plat[x][y+1].getDist()));
				}
				else if (_plat[x][y+1].getCouleur() != c)
				{
					_plat[x][y+1].setDist(Math.min(dist-1,_plat[x][y+1].getDist()));
				}
				
				if (_plat[x+1][y].getCouleur() == 0)
				{
					_plat[x+1][y].setDist(Math.min(dist,_plat[x+1][y].getDist()));
				}
				else if (_plat[x+1][y].getCouleur() != c)
				{
					_plat[x+1][y].setDist(Math.min(dist-1,_plat[x+1][y].getDist()));
				}
				
				if (_plat[x-1][y].getCouleur() == 0)
				{
					_plat[x-1][y].setDist(Math.min(dist,_plat[x-1][y].getDist()));
				}
				else if (_plat[x-1][y].getCouleur() != c)
				{
					_plat[x-1][y].setDist(Math.min(dist-1,_plat[x-1][y].getDist()));
				}
				
				if (_plat[x-1][y+1].getCouleur() == 0)
				{
					_plat[x-1][y+1].setDist(Math.min(dist,_plat[x-1][y+1].getDist()));
				}
				else if (_plat[x-1][y+1].getCouleur() != c)
				{
					_plat[x-1][y+1].setDist(Math.min(dist-1,_plat[x-1][y+1].getDist()));
				}
				
				parcoursPlateau(x-1,y,p);
				parcoursPlateau(x-1,y+1,p);
				parcoursPlateau(x,y+1,p);
				parcoursPlateau(x+1,y,p);
			}
			else if ((y==_taille-1) && (x>0) && (x<_taille-1)) // Bord Droite
			{
				if (_plat[x+1][y].getCouleur() == 0)
				{
					_plat[x+1][y].setDist(Math.min(dist,_plat[x+1][y].getDist()));
				}
				else if (_plat[x+1][y].getCouleur() != c)
				{
					_plat[x+1][y].setDist(Math.min(dist-1,_plat[x+1][y].getDist()));
				}
				
				if (_plat[x][y-1].getCouleur() == 0)
				{
					_plat[x][y-1].setDist(Math.min(dist,_plat[x][y-1].getDist()));
				}
				else if (_plat[x][y-1].getCouleur() != c)
				{
					_plat[x][y-1].setDist(Math.min(dist-1,_plat[x][y-1].getDist()));
				}
				
				if (_plat[x-1][y].getCouleur() == 0)
				{
					_plat[x-1][y].setDist(Math.min(dist,_plat[x-1][y].getDist()));
				}
				else if (_plat[x-1][y].getCouleur() != c)
				{
					_plat[x-1][y].setDist(Math.min(dist-1,_plat[x-1][y].getDist()));
				}
				
				if (_plat[x+1][y-1].getCouleur() == 0)
				{
					_plat[x+1][y-1].setDist(Math.min(dist,_plat[x+1][y-1].getDist()));
				}
				else if (_plat[x+1][y-1].getCouleur() != c)
				{
					_plat[x+1][y-1].setDist(Math.min(dist-1,_plat[x+1][y-1].getDist()));
				}
				
				parcoursPlateau(x-1,y,p);
				parcoursPlateau(x,y-1,p);
				parcoursPlateau(x+1,y-1,p);
				parcoursPlateau(x+1,y,p);
				
			}
			else // cas général
			{
				if (_plat[x][y+1].getCouleur() == 0)
				{
					_plat[x][y+1].setDist(Math.min(dist,_plat[x][y+1].getDist()));
				}
				else if (_plat[x][y+1].getCouleur() != c)
				{
					_plat[x][y+1].setDist(Math.min(dist-1,_plat[x][y+1].getDist()));
				}
				
				if (_plat[x+1][y].getCouleur() == 0)
				{
					_plat[x+1][y].setDist(Math.min(dist,_plat[x+1][y].getDist()));
				}
				else if (_plat[x+1][y].getCouleur() != c)
				{
					_plat[x+1][y].setDist(Math.min(dist-1,_plat[x+1][y].getDist()));
				}
				
				if (_plat[x][y-1].getCouleur() == 0)
				{
					_plat[x][y-1].setDist(Math.min(dist,_plat[x][y-1].getDist()));
				}
				else if (_plat[x][y-1].getCouleur() != c)
				{
					_plat[x][y-1].setDist(Math.min(dist-1,_plat[x][y-1].getDist()));
				}
				
				if (_plat[x-1][y].getCouleur() == 0)
				{
					_plat[x-1][y].setDist(Math.min(dist,_plat[x-1][y].getDist()));
				}
				else if (_plat[x-1][y].getCouleur() != c)
				{
					_plat[x-1][y].setDist(Math.min(dist-1,_plat[x-1][y].getDist()));
				}
				
				if (_plat[x+1][y-1].getCouleur() == 0)
				{
					_plat[x+1][y-1].setDist(Math.min(dist,_plat[x+1][y-1].getDist()));
				}
				else if (_plat[x+1][y-1].getCouleur() != c)
				{
					_plat[x+1][y-1].setDist(Math.min(dist-1,_plat[x+1][y-1].getDist()));
				}
				
				if (_plat[x-1][y+1].getCouleur() == 0)
				{
					_plat[x-1][y+1].setDist(Math.min(dist,_plat[x-1][y+1].getDist()));
				}
				else if (_plat[x-1][y+1].getCouleur() != c)
				{
					_plat[x-1][y+1].setDist(Math.min(dist-1,_plat[x-1][y+1].getDist()));
				}
				parcoursPlateau(x-1,y,p);
				parcoursPlateau(x-1,y+1,p);
				parcoursPlateau(x,y-1,p);
				parcoursPlateau(x,y+1,p);
				parcoursPlateau(x+1,y-1,p);
				parcoursPlateau(x+1,y,p);
			}
		}
	}

	public Pion calculePionML(Pion p1, Pion p2)
	{
		initDistance(p1.getX(), p1.getY());
		parcoursPlateau(p1.getX(), p1.getY(), p1);
		composante.clear();
		Pion res = miniCompoDistance(p2.getX(), p2.getY());
		return res;
	}

	public int calculeDistance(Pion p1, Pion p2)
	{
		return calculePionML(p1, p2).getDist();
	}


}
