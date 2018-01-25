package pracownik;

import java.util.ArrayList;
import java.util.Iterator;


public class Pracownicy implements Element
    {
    private ArrayList<Element> pracownicy = new ArrayList<Element>(); 
    
    public Pracownicy() {}
    //**************************************************************************
    public void dodaj(Element element) {pracownicy.add(element);}
    public void usun(Element element) {pracownicy.remove(element);}
    public Element zwroc(int i) {return (Element)pracownicy.get(i);}
    //--------------------------------------------------------------------------
    public void wypisz(String nazwaZmiennej, Object zmienna) 
        {
        if("wartosc".equals(nazwaZmiennej)) 
            {
            double wartosc = (Double)zmienna;
            for(int i=0; i<pracownicy.size(); i++) 
                {
                if(i < pracownicy.size())
                    {
                    Element pracownik = zwroc(i);
                    double zarobki = (Double)pracownik.zwroc("zarobki") + wartosc;
                    pracownik.wypisz("zarobki", (Object)zarobki);
                    }
                }
            }
        }
    //--------------------------------------------------------------------------
    public Object zwroc(String nazwaZmiennej) 
        {
        Object wy = null;
        if("ilosc".equals(nazwaZmiennej)) wy = (Object)pracownicy.size();
        if("wyczysc".equals(nazwaZmiennej)) pracownicy.clear();
        return wy;
        }
    //--------------------------------------------------------------------------
    public String wyswietl() 
        {
        String s = "";
        Iterator<Element> iterator = pracownicy.iterator();
        for (int i=0; i<pracownicy.size();i++)
            {
            Element pracownik = iterator.next(); 
            s = s + i + " : " + pracownik.wyswietl() + "\n";
            }
        return s;
        }

    public void wstawElement(int i, Element element) {pracownicy.add(i, element);}
    } 