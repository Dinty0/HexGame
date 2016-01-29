public class Pion
{
	private int _couleur;
	private int _x;
	private int _y;
	private int _xRep;
	private int _yRep;
	private int _rang;
	private int _dist;

	public Pion(){}
	
	public Pion(int xRep,int yRep,int dist)
	{
		_xRep = xRep;
		_yRep = yRep;
		_x = xRep;
		_y = yRep;
		_couleur=0;
		_rang = 0;
		_dist = dist;
	}

	public int getCouleur()
	{
		return _couleur;
	}

	public void setCouleur(int c)
	{
		_couleur = c;
	}
	
	public int getX()
	{
		return _x;
	}

	public int getY()
	{
		return _y;
	}

	public int getXRep()
	{
		return _xRep;
	}
	
	public int getYRep()
	{
		return _yRep;
	}

	public void setXRep(int x)
	{
		_xRep = x;
	}

	public void setYRep(int y)
	{
		_yRep = y;
	}

	public void setRep(Pion p)
	{
		_xRep = p.getXRep();
		_yRep = p.getYRep();
	}

	public Pion getRep(Plateau p)
	{
		return p.getPlateau()[_xRep][_yRep];
	}

	public int getRang()
	{
		return _rang;
	}

	public void setRang(int r)
	{
		_rang = r;
	}

	public int getDist()
	{
		return _dist;
	}

	public void setDist(int dist)
	{
		_dist = dist;
	}

	public boolean testClasse(Pion p)
	{
		if ((_couleur == p.getCouleur()) && ((_xRep != p.getXRep()) || (_yRep != p.getYRep())))
		{
			return true;
		} 
		else 
		{ 
			return false; 
		}
	}

	public boolean equals(Pion p)
	{
		return (_x == p.getX() && _y == p.getY());
	}

	public void afficher()
	{
		System.out.println(_x+","+_y);
	}
}
