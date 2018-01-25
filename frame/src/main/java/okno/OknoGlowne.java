package okno;

import zbiory.Zbiory;
import java.awt.event.KeyListener;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import okno.OknoDrzewo;
import okno.OknoPracownik;
import pracownik.Element;

public class OknoGlowne extends JFrame implements ActionListener
{
private JTextArea ta;
private JTextField tfZwiekszZarobki;
private JTextField tfZmniejszZarobki;
private JButton bUtworzDrzewo;
private JButton bZarzadzajPracownikiem;
private JButton bZwiekszZarobki;
private JButton bZmniejszZarobki;
private JButton bSort;
private JComboBox sortCombo;

//tablica z itemami do combobox
String[] items = { "OD najmniejszej kwoty", "OD najwiekszej kwoty" };

private Container cp = getContentPane();
private Element pracownicy;
private Zbiory zbiory;




public OknoGlowne(Element pracownicy, Zbiory zbiory)
    {
    this.pracownicy = pracownicy;
    this.zbiory = zbiory;

    //ustawienie okna rozmiar,zmkniecie,tytul
setSize(800,480);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setTitle("lista pracownikow"); 
    
    wypelnijOkno();
    setVisible(true); 
    }
//==========================================================================
private void wypelnijOkno() 
    {  
	
	// utworzenie obiektów, buttony oraz labele 
	
	final JComboBox sortCombo = new JComboBox(items);
    JLabel jlZwiekszZarobki = new JLabel(" Zwieksz zarobki wszystkim o ");
    JLabel jlZmniejszZarobki = new JLabel("Zmniejsz zarobki wszystkim o ");
    tfZwiekszZarobki = new JTextField(4);
    tfZmniejszZarobki = new JTextField(4);
    bZarzadzajPracownikiem = new JButton("Zarzadzaj pracownikiem");
    bUtworzDrzewo = new JButton("Utworz nowe Drzewo");
    bZwiekszZarobki = new JButton("Zwieksz");
    bZmniejszZarobki = new JButton("Zmniejsz");
    bSort= new JButton ("Sortowanie");
    ta = new JTextArea(pracownicy.wyswietl());  
 
    
    // przycisk wyboru sortowania
    
    bSort.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
        	String typeofSort = (String)sortCombo.getSelectedItem();
        	
        	if(typeofSort== "OD najmniejszej kwoty")
        	{
        		zbiory.sortujPracownikowWedlogZarobkow();
            	odswiez();
        	}
        	else if (typeofSort=="OD najwiekszej kwoty")
        	{
        		zbiory.sortujPracownikowWedlugnajwiekszych();
            	odswiez();
        	}
        }
    });

    
    
    
    
    JScrollPane scroll = new JScrollPane(ta);
    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    
    bZarzadzajPracownikiem.addActionListener(this);
    bUtworzDrzewo.addActionListener(this);
    bZwiekszZarobki.addActionListener(this);
    bZmniejszZarobki.addActionListener(this);
    bSort.addActionListener(this);
    sortCombo.addActionListener(this);
    
    
    
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    
       //dodanie przyciskow do okna glownego
    
    p1.add(bUtworzDrzewo);
    p1.add(bZarzadzajPracownikiem);
    p1.add(bSort);
    p1.add(sortCombo);
    p2.add(jlZwiekszZarobki);
    p2.add(tfZwiekszZarobki);
    p2.add(bZwiekszZarobki);
    p2.add(jlZmniejszZarobki);
    p2.add(tfZmniejszZarobki);
    p2.add(bZmniejszZarobki);


    // ustawienie przyciskow na oknie 
    
    cp.add(p1, BorderLayout.NORTH); 
    cp.add(scroll, BorderLayout.CENTER);
    cp.add(p2, BorderLayout.SOUTH); 
    

    
} 
//==========================================================================
public void odswiez() 
    {
    ta.setText(""); 
    ta.setText(pracownicy.wyswietl());
    }
//--------------------------------------------------------------------------
private int sprawdzLiczbe(String s)
    {
    int liczba;
    try {liczba = Integer.parseInt(s);} 
    catch (NumberFormatException n) {liczba=0;}
    return liczba;
    }
//==========================================================================
public void actionPerformed(ActionEvent e) 
{
    if (e.getSource() == bUtworzDrzewo) {OknoDrzewo oknoDrzewo = new OknoDrzewo(zbiory, this);}
    if (e.getSource() == bZarzadzajPracownikiem) {OknoPracownik oknoPracownik = new OknoPracownik(pracownicy,zbiory, this);}
    //---------------------------------------------------------------------
    
    //zwiekszanie zarobkow
    
    if (e.getSource() == bZwiekszZarobki)
        {
        double wartosc = sprawdzLiczbe(tfZwiekszZarobki.getText());
        tfZwiekszZarobki.setText("");
        pracownicy.wypisz("wartosc", wartosc);
        odswiez();
        }
    //----------------------------------------------------------------------
    
    //zmniejszanie zarobkow
    
    if (e.getSource() == bZmniejszZarobki)
        {
        double wartosc = (-1) * sprawdzLiczbe(tfZmniejszZarobki.getText());
        tfZmniejszZarobki.setText("");
        pracownicy.wypisz("wartosc", wartosc);
        odswiez();
        }
    //----------------------------------------------------------------------
    }
//==========================================================================
}
