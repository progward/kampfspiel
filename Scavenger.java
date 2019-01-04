
public class Scavenger extends Instanzen {

	Scavenger(int level){
		newGegner();
		this.levelUpUm((level-1));
	}
	
	public void newGegner() {
		Scavenger.this.setName("Scavenger");
		Scavenger.this.setAttacke1("Schnabelangriff");
		Scavenger.this.setAttacke2("Bauchpicker");
		Scavenger.this.setAttacke3("Laufattacke");
		Scavenger.this.setAttacke4("Superhuhn");
		Scavenger.this.setAttacke5Spezial("Spezialattacke (P): Flugsturz");
		Scavenger.this.setZustand("normal");
		Scavenger.this.setGrundVerteidigung(6);
		Scavenger.this.setGrundAngriffskraft(19);
		Scavenger.this.setGrundGesundheit(100);
		Scavenger.this.setGrundEnergie(10);
		Scavenger.this.setLevel(1);
		Scavenger.this.setErfahrungspunkte(200);
	}
}
