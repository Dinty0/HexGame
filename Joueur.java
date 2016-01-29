class Joueur
{
	private int _couleur;
	private boolean _humain;

	public Joueur(int c, boolean humain)
	{
		_couleur = c;
		_humain = humain;
	}

	public int getCouleur()
	{
		return _couleur;
	}

	public boolean estHumain()
	{
		return _humain;
	}

	public void setHumain(boolean humain)
	{
		_humain = humain;
	}

}