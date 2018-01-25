package glowny;

import okno.OknoGlowne;
import zbiory.Zbiory;
import pracownik.Element;
import pracownik.Pracownicy;

public class Main {

	public static void main(String[] args) 
    {
	Pracownicy p = new Pracownicy();
    Zbiory zbiory = new Zbiory(p);
   
    zbiory.stworzDrzewo(10);
    Element pracownicy = p;
    OknoGlowne okno = new OknoGlowne(pracownicy, zbiory);
    }
}