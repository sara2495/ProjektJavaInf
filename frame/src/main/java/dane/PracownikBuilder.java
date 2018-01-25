package dane;

import pracownik.PracownikEtatowy;

public abstract class PracownikBuilder extends ElementBuilder {
	
	public PracownikBuilder(){
	}

	public void composePracownik() {
		pracownik = new PracownikEtatowy();
		pracownik.id(100);
		pracownik.imie("Test");
		pracownik.nazwisko("Builder");
		pracownik.zarobki(9999.00);
	}
	
	public PracownikEtatowy build() {
		composePracownik();
		return pracownik;
	}
}