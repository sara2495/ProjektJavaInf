package dane;

public class Osoba {
	
	private int id;
	private String imie,nazwisko;
	
	public Osoba() {};
	
	
	public void wypisz(int id,String imie, String nazwisko)
	{
		this.id=id;
		this.imie=imie;
		this.nazwisko=nazwisko;
	}
	
	public void id(int id) {this.id=id;}
	public void imie(String imie){this.imie=imie;}
	public void nazwisko(String nazwisko) {this.nazwisko=nazwisko;}
	
	public int id() {return this.id;}
	public String imie() { return this.imie;}
	public String nazwisko() {return this.nazwisko;}

}
