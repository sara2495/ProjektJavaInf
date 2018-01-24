package zbiory;

import pracownik.Pracownicy;
import java.util.Random;
import pracownik.Element;
import pracownik.PracownikEtatowy;

public class Zbiory
    {
    private Pracownicy pracownicy;
    
    public Zbiory(Pracownicy pracownicy) {this.pracownicy = pracownicy;}
    //==========================================================================
    public void stworzDrzewo(int liczbaOsob)
        {
        Random rn = new Random();
        if((Integer)pracownicy.zwroc("ilosc") > 0) pracownicy.zwroc("wyczysc");
        for (int id=0; id<liczbaOsob;id++) 
            {
            String imie = "imie"+id;
            String nazwisko = "nazwisko"+id;
            double zarobki = rn.nextInt(1000)+1000; 
            Element pracownik = new PracownikEtatowy(id, imie, nazwisko, id, zarobki);
            pracownicy.dodaj(pracownik);    
            }
        }
    public void sortujPracownikowWedlogZarobkow()
    {
    Element pracownikTmp1, pracownikTmp2;
    int n = (Integer)pracownicy.zwroc("ilosc");
    
    do
        { 
        for(int i =0; i<n-1; i++)
            {
            if ((Double)pracownicy.zwroc(i).zwroc("zarobki") > (Double)pracownicy.zwroc(i+1).zwroc("zarobki"))
                { 
                pracownikTmp1 = pracownicy.zwroc(i);
                pracownikTmp2 = pracownicy.zwroc(i+1);
                pracownicy.usun(pracownicy.zwroc(i));
                pracownicy.usun(pracownicy.zwroc(i));
                pracownicy.wstawElement(i, pracownikTmp2);
                pracownicy.wstawElement(i+1, pracownikTmp1);
                } 
            }  
        n = n-1; 
        }
    while (n>1);
    }
    public void sortujPracownikowWedlugnajwiekszych()
    {
        Element pracownikTmp1, pracownikTmp2;
        int n = (Integer)pracownicy.zwroc("ilosc");
        
        do
            { 
            for(int i =0; i<n-1; i++)
                {
                if ((Double)pracownicy.zwroc(i+1).zwroc("zarobki")>(Double)pracownicy.zwroc(i).zwroc("zarobki"))
                    { 
                    pracownikTmp1 = pracownicy.zwroc(i);
                    pracownikTmp2 = pracownicy.zwroc(i+1);
                    pracownicy.usun(pracownicy.zwroc(i));
                    pracownicy.usun(pracownicy.zwroc(i));
                    pracownicy.wstawElement(i, pracownikTmp2);
                    pracownicy.wstawElement(i+1, pracownikTmp1);
                    } 
                }  
            n = n-1; 
            }
        while (n>1);
    	
    }
    }
   