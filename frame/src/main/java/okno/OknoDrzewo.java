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

public class OknoDrzewo extends JFrame implements ActionListener {
	
	private JTextField iloscPracownikow;
	private JButton utworzDrzewo;
	
	private Zbiory zbiory;
	private OknoGlowne oknoGlowne;
	
	
	public OknoDrzewo(Zbiory zbiory, OknoGlowne oknoGlowne)
	{
		this.zbiory=zbiory;
		this.oknoGlowne=oknoGlowne;
	
	
	setSize(300,200);
	setTitle("Drzewo");
	setLayout(new GridLayout(2,1));
	wypelnijOkno();
    setVisible(true);
	}

	private void wypelnijOkno()
	{
	JLabel napis1 = new JLabel("Wpisz liczbe pracownikow");
	iloscPracownikow = new JTextField(2);
	utworzDrzewo = new JButton("Utworz nowa liste");
	
	utworzDrzewo.addActionListener(this);
	
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel ();
	
	p1.add(napis1);
	p2.add(iloscPracownikow);
	p2.add(utworzDrzewo);
	
	add(p1);
	add(p2);
	
	}
	
	private int sprawdzLiczbe(String s)
	{
		int liczba;
			try 
			{
				liczba = Integer.parseInt(s);
			}
			catch (NumberFormatException n){liczba=-1;}
			return liczba;
	}
    public void actionPerformed(ActionEvent e) 
        {
        if (e.getSource() == utworzDrzewo) 
            {
            int liczbaPracownikow = sprawdzLiczbe(iloscPracownikow.getText()); 
            zbiory.stworzDrzewo(liczbaPracownikow);
            oknoGlowne.odswiez();
            this.dispose();
            }

}
}
