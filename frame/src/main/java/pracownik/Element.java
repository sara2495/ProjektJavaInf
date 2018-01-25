package pracownik;

public interface Element {
	public void wypisz(String nazwaZmiennej, Object zmienna);
	public Object zwroc (String nazwaZmiennej);
	public String wyswietl();
	
	public void dodaj	(Element element);
	public void usun	(Element element);
	public Element zwroc(int i);

}
