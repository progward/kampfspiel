
public class Skelett extends Instanzen {
		
	Skelett(int level){
		newGegner();
		this.levelUpUm((level-1));
		
		if(Skelett.this.getLevel()>=5) {
			Skelett.this.setAttacke1("Knochenprügel");
		  //Skelett.this.erhoeheAttackenkraft1Um(erhoehterAttackenwert);
		  // in der Instanzenklasse -> public void erhoeheAttackenkraft1Um(int erhoehterAttackenwert) {attackenkraft1 = attackenkraft+erhoehterAttackenwert}
		}
		if(Skelett.this.getLevel()>=10) {
			Skelett.this.setAttacke2("Splitterhagel");
		  //Skelett.this.erhoeheAttackenkraft2Um(erhoehterAttackenwert);
		  // in der Instanzenklasse -> public void erhoeheAttackenkraft2Um(int erhoehterAttackenwert) {attackenkraft2 = attackenkraft+erhoehterAttackenwert}	
		}
	}
	
	public void newGegner() {
		Skelett.this.setName("Skelett");
		Skelett.this.setAttacke1("Knochenfaust");
		Skelett.this.setAttacke2("Splitterschnitzer");
		Skelett.this.setAttacke3("Schädelnuss");
		Skelett.this.setAttacke4("Knochentanz");
		Skelett.this.setAttacke5Spezial("Spezialattacke (P): Todesinjektion");
		Skelett.this.setZustand("normal");
		Skelett.this.setGrundVerteidigung(10);
		Skelett.this.setGrundAngriffskraft(17);
		Skelett.this.setGrundGesundheit(95);
		Skelett.this.setGrundEnergie(10);
		Skelett.this.setLevel(1);
		Skelett.this.setErfahrungspunkte(100);
	}
}
