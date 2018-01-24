package okno;

import zbiory.Zbiory;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import okno.OknoGlowne;
import pracownik.Element;
import pracownik.PracownikEtatowy;


public class OknoPracownik extends JFrame implements ActionListener
{

    private JLabel jlId;
    private JLabel jlImie;
    private JLabel jlNazwisko;
    private JLabel jlIdPracownika;
    private JLabel jlZarobki;
    private JTextField tfNrPracownika;
    private JTextField tfImie;
    private JTextField tfNazwisko;
    private JTextField tfZarobki;
    private JButton bWyswietl;
    private JButton bDodaj;
    private JButton bEdytuj;
    private JButton bUsun;
    
    private Element pracownicy;
    private Zbiory zbiory;
    private OknoGlowne oknoGlowne;
    private Element pracownik;
	
	
public OknoPracownik(Element pracownicy, Zbiory zbiory, OknoGlowne oknoGlowne)
{
	this.pracownicy = pracownicy;
	this.zbiory=zbiory;
	this.oknoGlowne =oknoGlowne;
	
	setSize(310,310);
	setLayout(new GridLayout(8,1));
	
	wypelnijOkno();
	setVisible(true);
}

private void wypelnijOkno()
{
	JLabel jlId0 = new JLabel("id: ");
    JLabel jlImie0 = new JLabel("imie: ");
    JLabel jlNazwisko0 = new JLabel("nazwisko: ");
    JLabel jlIdPracownika0 = new JLabel("idPracownika: ");
    JLabel jlZarobki0 = new JLabel("zarobki: ");	

	
    JLabel jlWpiszId = new JLabel("wpisz nr osoby");
    jlId = new JLabel("");
    jlImie = new JLabel("");
    jlNazwisko = new JLabel("");
    jlIdPracownika = new JLabel("");
    jlZarobki = new JLabel("");
    tfNrPracownika = new JTextField(2);
    tfImie = new JTextField(10);
    tfNazwisko = new JTextField(10);
    tfZarobki = new JTextField(5);
    bWyswietl = new JButton("wyswietl");
    bDodaj = new JButton("dodaj");
    bEdytuj = new JButton("edytuj");
    bUsun = new JButton("usun");
    
    bWyswietl.addActionListener(this);
    bDodaj.addActionListener(this);
    //bEdytuj.addActionListener(this);
    bUsun.addActionListener(this);
    
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JPanel p4 = new JPanel();
    JPanel p5 = new JPanel();
    JPanel p6 = new JPanel();
    JPanel p7 = new JPanel();
    JPanel p8 = new JPanel();
    
    p1.add(jlWpiszId);
    p1.add(tfNrPracownika);
    p1.add(bWyswietl);
    p2.add(bUsun);
    p2.add(bEdytuj);
    p3.add(jlId0);
    p3.add(jlId);
    p4.add(jlImie0);
    p4.add(jlImie);
    p4.add(tfImie);
    p5.add(jlNazwisko0);
    p5.add(jlNazwisko);
    p5.add(tfNazwisko);
    p6.add(jlIdPracownika0);
    p6.add(jlIdPracownika);
    p7.add(jlZarobki0);
    p7.add(jlZarobki);
    p7.add(tfZarobki);
    p8.add(bDodaj);
    

    add(p1);
    add(p2);
    add(p3);
    add(p4);
    add(p5);
    add(p6);
    add(p7);
    add(p8);
} 
	
private int sprawdzLiczbe(String s)
{
int liczba;
try {liczba = Integer.parseInt(s);} 
catch (NumberFormatException n) {liczba=-1;}
return liczba;
}
private void zerujTextField()
{   
tfImie.setText("");
tfNazwisko.setText("");
tfZarobki.setText("");    
}
private void zerujJLabel()
{
jlId.setText("");   
jlImie.setText(""); 
jlNazwisko.setText(""); 
jlIdPracownika.setText("");
jlZarobki.setText("");
}
private void ustawJLabel(Element pracownik)
{
jlId.setText(Integer.toString((Integer)pracownik.zwroc("id")));   
jlImie.setText((String)pracownik.zwroc("imie")); 
jlNazwisko.setText((String)pracownik.zwroc("nazwisko")); 
jlIdPracownika.setText(Integer.toString((Integer)pracownik.zwroc("idPracownika")));
jlZarobki.setText(Double.toString((Double)pracownik.zwroc("zarobki"))+"zl");
}

public void actionPerformed(ActionEvent e) 
{
if (e.getSource() == bWyswietl) 
    {
    pracownik = null;
    zerujTextField();
    int id = sprawdzLiczbe(tfNrPracownika.getText());
    tfNrPracownika.setText("");
    if(id>=0 && id<(Integer)pracownicy.zwroc("ilosc"))
        {
        Element p = pracownicy.zwroc(id);
        ustawJLabel(p); 
        }
    else zerujJLabel();
    } 
//----------------------------------------------------------------------
if (e.getSource() == bUsun) 
    {
    pracownik = null;
    zerujTextField();
    zerujJLabel();
    int id = sprawdzLiczbe(tfNrPracownika.getText());
    tfNrPracownika.setText("");
    if(id>=0 && id<(Integer)pracownicy.zwroc("ilosc"))
        {
        Element p = pracownicy.zwroc(id);
        pracownicy.usun(p);
        //zbiory.sortujPracownikowWedlogZarobkow();
        oknoGlowne.odswiez();
        }
    } 
//----------------------------------------------------------------------
if (e.getSource() == bEdytuj) 
    {
    zerujTextField();
    zerujJLabel();
    int id = -1;
    id = sprawdzLiczbe(tfNrPracownika.getText());
    tfNrPracownika.setText("");
    if(id>=0 && id<(Integer)pracownicy.zwroc("ilosc"))
        {
        Element p = pracownicy.zwroc(id);
        pracownik = p;
        ustawJLabel(p); 
        }
    } 
//----------------------------------------------------------------------
if (e.getSource() == bDodaj) 
    {
    String imie = tfImie.getText();
    String nazwisko = tfNazwisko.getText();
    double zarobki = sprawdzLiczbe(tfZarobki.getText());
    if(imie!=null && nazwisko!=null && zarobki>0 && pracownik==null)
        {
        int id = 0;
        for(int i=0; i<(Integer)pracownicy.zwroc("ilosc"); i++)
            {
            if((Integer)pracownicy.zwroc(i).zwroc("id") > id) id = (Integer)pracownicy.zwroc(i).zwroc("id") + 1;
            }
        Element p = new PracownikEtatowy(id, imie, nazwisko, id, zarobki);
        pracownicy.dodaj(p);
       // zbiory.sortujPracownikowWedlogZarobkow();
        oknoGlowne.odswiez();
        zerujTextField();
        zerujJLabel();
        pracownik=null;
        }
    if(imie!=null && nazwisko!=null && zarobki>0 && pracownik!=null)
        {
        pracownicy.usun(pracownik);
        pracownik.wypisz("imie ", imie);
        pracownik.wypisz("nazwisko", nazwisko);
        pracownik.wypisz("zarobki", zarobki);
        pracownicy.dodaj(pracownik);
       // zbiory.sortujPracownikowWedlogZarobkow();
        oknoGlowne.odswiez();
        zerujTextField();
        zerujJLabel();
        pracownik=null;
        }
    }
}
}
