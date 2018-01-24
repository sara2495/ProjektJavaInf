package pracownik;

import dane.Pracownik;
import pracownik.Element;

public class PracownikEtatowy extends Pracownik implements Element{
	
	public PracownikEtatowy(int id, String imie, String nazwisko, int idPracownik, double zarobki) {wypisz(id, imie, nazwisko, idPracownik, zarobki);}
	
	public void wypisz(String nazwaZmiennej, Object zmienna)
    {
        if("id".equals(nazwaZmiennej)) id((Integer)zmienna);
        if("imie".equals(nazwaZmiennej)) imie(zmienna.toString());   
        if("nazwisko".equals(nazwaZmiennej)) nazwisko(zmienna.toString());
        if("idPracownika".equals(nazwaZmiennej)) idPracownik((Integer)zmienna);
        if("zarobki".equals(nazwaZmiennej)) zarobki((Double)zmienna);
      }
	
	public Object zwroc(String nazwaZmiennej)
	{
		Object wy = null;
		   if("id".equals(nazwaZmiennej)) wy = (Object)id();
	        if("imie".equals(nazwaZmiennej)) wy = (Object)imie();    
	        if("nazwisko".equals(nazwaZmiennej)) wy = (Object)nazwisko();
	        if("idPracownika".equals(nazwaZmiennej)) wy = (Object)idPracownik();
	        if("zarobki".equals(nazwaZmiennej)) wy = (Object)zarobki();
	        return wy;
	}
	public String wyswietl () {return id()+". "+imie()+". "+nazwisko()+ ", idPracownik=" + idPracownik() + ", zarobki=" + zarobki() + "zl";}
	public void dodaj(Element element) {}
    public void usun(Element element) {}
    public Element zwroc(int i) {throw new UnsupportedOperationException();}
}
