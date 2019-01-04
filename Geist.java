
public class Geist extends Instanzen {

	Geist(int level){
		newGegner();
		this.levelUpUm((level-1));
	}
	
	public void newGegner() {
		Geist.this.setName("Geist");
		Geist.this.setAttacke1("Jenseitsgruss");
		Geist.this.setAttacke2("Seelenflash");
		Geist.this.setAttacke3("Gruselgeschichte");
		Geist.this.setAttacke4("Geistergeflüster");
		Geist.this.setAttacke5Spezial("Spezialattacke (P): Spukpeitsche");
		Geist.this.setZustand("normal");
		Geist.this.setGrundVerteidigung(9);
		Geist.this.setGrundAngriffskraft(20);
		Geist.this.setGrundGesundheit(100);
		Geist.this.setGrundEnergie(10);
		Geist.this.setLevel(1);
		Geist.this.setErfahrungspunkte(300);
	}
}

