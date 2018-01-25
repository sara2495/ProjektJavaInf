package dane;

import pracownik.PracownikEtatowy;

public abstract class ElementBuilder {

	protected PracownikEtatowy pracownik;
	
	protected abstract void composePracownik();
	
	public PracownikEtatowy build() {
		return pracownik;
	}
}