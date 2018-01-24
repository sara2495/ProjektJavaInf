package dane;

public class Pracownik extends Osoba{
	
	private int idPracownik;
	private double zarobki;
	
	public Pracownik () {}
	
	public void wypisz(int id, String imie, String nazwisko, int idPrcownik, double zarobki)
	{
		super.wypisz(idPrcownik, imie, nazwisko);
		this.idPracownik=idPracownik;
		this.zarobki=zarobki;
	}
	public void idPracownik(int idPracownik) {this.idPracownik=idPracownik;}
	public void zarobki (double zarobki) {this.zarobki = zarobki;}
	
	public int idPracownik () {return this.idPracownik;}
	public double zarobki () {return this.zarobki;}

}
