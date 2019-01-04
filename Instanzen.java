import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Instanzen {
	
	
	private Scanner userEingabe = new Scanner(System.in);
	private String name;
	private String attacke1;
	private String attacke2;
	private String attacke3;
	private String attacke4;
	private String attacke5Spezial;
	private String zustand; 
	private int spezialZaehler;
	private int verteidigung;
	private int grundVerteidigung;
	private int angriffskraft;
	private int grundAngriffskraft;
	private int gesundheit;
	private int grundGesundheit;
	private int energie;
	private int grundEnergie;
	private int level;
	private int erfahrungspunkte;
	private String[] inventar = {"leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer"};
	
	private int kritZaehler = 0;


	
	public void greiftAn(int attackenNummer) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		Sound soundy = new Sound(true);
		
		double random = Math.random();
		boolean krit = false;
		
		if (kritZaehler>0) {
			int kritty = (int) -(getGrundAngriffsKraft()*0.5);
			changeAngriffskraftUm(kritty);
			kritZaehler = 0;
		}
		
		if(random > 0.9) {
			krit = true;
			changeAngriffskraftUm((int) (getGrundAngriffsKraft()*0.5));
			kritZaehler = 1;
		}
		
		
		if(attackenNummer == 1) {
			energie--;
			System.out.print(name+" greift an");
			Instanzen.dot(500);
			soundy.playAngriffsMusic();
			System.out.print(name+" setzt "+attacke1+" ein!");
			userEingabe.nextLine();
			soundy.stopAngriffsMusic();
		}
		else if(attackenNummer ==2) {
			energie = energie-2;
			System.out.print(name+" greift an");
			Instanzen.dot(500);
			soundy.playAngriffsMusic();
			System.out.print(name+" setzt "+attacke2+" ein!");
			userEingabe.nextLine();
			soundy.stopAngriffsMusic();
		}
		else if(attackenNummer ==3) {
			energie = energie-3;
			System.out.print(name+" greift an");
			Instanzen.dot(500);
			soundy.playAngriffsMusic();
			System.out.print(name+" setzt "+attacke3+" ein!");
			userEingabe.nextLine();
			soundy.stopAngriffsMusic();
		}
		else if(attackenNummer ==4) {
			energie = energie-4;
			System.out.print(name+" greift an");
			Instanzen.dot(500);
			soundy.playAngriffsMusic();
			System.out.print(name+" setzt "+attacke4+" ein!");
			userEingabe.nextLine();
			soundy.stopAngriffsMusic();
		}
		else if(attackenNummer ==5) {
			if(spezialZaehler>=5) {
				energie = energie-5;
				System.out.print(name+" greift an");
				Instanzen.dot(500);
				soundy.playAngriffsMusic();
				System.out.print(name+" setzt "+attacke5Spezial+" ein");
				Instanzen.dot(500);
				System.out.println();
				spezialZaehler = spezialZaehler-5;
				soundy.stopAngriffsMusic();
			}
		}
		else {
			System.out.print(name+" greift an");
			Instanzen.dot(500);
			soundy.playAngriffsMusic();
			System.out.print(name+" setzt "+attacke1+" ein!");
			userEingabe.nextLine();
			soundy.stopAngriffsMusic();
		}
		if(krit) {
			System.out.print("Es war ein kritischer Treffer!");
			userEingabe.nextLine();
		}
		spezialZaehler++;
	}
	
	public void wirdAngegriffen(int angriffskraft, String welcheAttacke) {
		if(welcheAttacke.contains("(P)")) {
			this.zustand = "vergiftet";
			System.out.print(name+" wurde vergiftet. Dadurch verliert "+name+" 3 Runden lang etwas Leben.");
			userEingabe.nextLine();
		}
		if(welcheAttacke.contains("(S)")) {
			this.zustand = "schlaeft";
			System.out.print(name+" wurde eingeschlaefert. Dadurch setzt "+name+" drei Runden lang aus.");
			userEingabe.nextLine();
		}
		if(welcheAttacke.contains("(C)")) {
			this.zustand = "verwirrt";
		}
		if(welcheAttacke.contains("(W)")) {
			this.zustand = "schwach";
		}
		if(welcheAttacke.contains("(T)")) {
			this.zustand = "angeschlagen";
		}
		gesundheit = (int) (gesundheit+verteidigung)-angriffskraft;
		System.out.println(name+" verliert "+(angriffskraft-verteidigung)+" HP.");
		userEingabe.nextLine();
		if(gesundheit<=0) {
			gesundheit = 0;
			energie = -1;
		}
		System.out.println(name+"s HP: "+gesundheit+"\n"+name+"s Energie: "+(energie+1));
		userEingabe.nextLine();
	}

	
	public void changeHpUm(int healAnzahl) {
		gesundheit = gesundheit+healAnzahl;

	}
	
	public void changeEnergieUm(int wieVielEnergie) {
		energie = energie+wieVielEnergie;
	}
	
	public void changeAngriffskraftUm(int wieVielAngriff) {
		angriffskraft = angriffskraft+wieVielAngriff;
	}
	
	public void changeVerteidigungUm(int wieVielVerteidigung) {
		verteidigung = verteidigung+wieVielVerteidigung;
	}
	
	public void changeSpezialZaehlerUm(int wieVielSpezialZaehler) {
		spezialZaehler = spezialZaehler+wieVielSpezialZaehler;
	}
	
	public void levelUpUm(int wieVieleLevel) {
		for(int i = 0; i<wieVieleLevel; i++) {
			setGrundVerteidigung(getGrundVerteidigung()+2);
			setGrundAngriffskraft(getGrundAngriffsKraft()+4);
			setGrundGesundheit(getGrundGesundheit()+40);
			level++;
			if(level==5||level==10||level==15||level==20||level==25||level==30||level==35||level==40||level==45||level==50) {
				grundEnergie++;	
			}
		}
	}
	
	//-------------------STUFENAUFSTIEG ANFANG----------------------
	
	public void stufenAufstieg() {
		
		if(erfahrungspunkte >= (getGrundGesundheit()*10)) {
			setErfahrungspunkte(getErfahrungspunkte()-(getGrundGesundheit()*10));
			levelUpUm(1);
			System.out.println("Du bist eine Stufe aufgestiegen!");
			userEingabe.nextLine();
			info();
			userEingabe.nextLine();
		} 
		else {
			System.out.println("Dir fehlen noch "+((getGrundGesundheit()*10)-getErfahrungspunkte())+" EXP bis zur nächsten Stufe.");
			userEingabe.nextLine();
		}
		
	}
	
	//----------STUFENAUFSTIEG ENDE------------
	
	public void angriffskraftReset() {
		angriffskraft = grundAngriffskraft;
	}
	
	public void verteidigungReset() {
		verteidigung = grundVerteidigung;
	}
	
	public void gesundheitReset() {
		gesundheit = grundGesundheit;
	}
	
	public void energieReset() {
		energie = grundEnergie;
	}
	
	public void werteResetNachKampf() {
		angriffskraftReset();
		verteidigungReset();
		gesundheitReset();
		energieReset();
		zustand="normal";
		spezialZaehler = 0;
	}
	
	public void info() {
		System.out.println("Name: "+name+"\nAttacke 1: "+attacke1+"\nAttacke 2: "+attacke2+"\nAttacke 3: "+attacke3+"\nAttacke 4: "+attacke4+"\nSpezialattacke: "+attacke5Spezial+""
				+ "\nVerteidigung: "+grundVerteidigung+"\nAngriffskraft: "+grundAngriffskraft+"\nGesundheit: "+grundGesundheit+"\nEnergie: "+grundEnergie+"\nLevel: "+level+"\nErfahrungspunkte: "+erfahrungspunkte);
	}
	
	//--------------INVENTAR ANFANG---------------------
	
	public void getInventarInhaltAusgabe() {
		for(int i=0;i<10;i++) {
			System.out.println((i+1)+". Inventarplatz: "+inventar[i]);
		}
	}
	
	public String getInventarInhalt(int inventarStelle) {
		inventarStelle--;
		return inventar[inventarStelle];
	}
	
	public String getInventarLast() {
		int i=0;
		while(!inventar[i].equals("leer")) {
			i++;
		}
		i--;
		return inventar[i];
	}
	
	public void inventarFuegeHinzu(int inventarStelle, String item) {
		inventarStelle--;
		inventar[inventarStelle] = item;
	}
	
	public void inventarLoescheItem(int inventarStelle) {
		inventarStelle--;
		inventar[inventarStelle] = "leer";
	}
	
	public void inventarFuegeHinzu(String itemName) {
		int i=0;

		while(!inventar[i].equals("leer")) {
			if(i==9) {
				break;
			}
			i++;
			if(inventar[i].equals("leer")) {
				inventar[i] = itemName;
				break;
			}
		}
		
		if(inventar[i].equals("leer")) {
			inventar[i] = itemName;
		}
	}
	
	public void benutzeItem(int inventarStelle) {
		inventarStelle--;
		
		if(inventar[inventarStelle].equals("Kleiner Heiltrank")) {
			changeHpUm((int) (getGrundGesundheit()*0.25));
			inventar[inventarStelle] = "leer";
			System.out.println(getName()+" setzt einen kl. Heiltrank ein. "+"Dadurch erhöht sich die HP um "+(getGrundGesundheit()*0.25));
			userEingabe.nextLine();
		}
		else if(inventar[inventarStelle].equals("Mittlerer Heiltrank")) {
			changeHpUm((int) (getGrundGesundheit()*0.5));	
			inventar[inventarStelle] = "leer";
			System.out.println(getName()+" setzt einen mttl. Heiltrank ein. "+"Dadurch erhöht sich die HP um "+(getGrundGesundheit()*0.5));
			userEingabe.nextLine();
		}
		else if(inventar[inventarStelle].equals("Grosser Heiltrank")) {
			changeHpUm((int) (getGrundGesundheit()*0.75));	
			inventar[inventarStelle] = "leer";
			System.out.println(getName()+" setzt einen gr. Heiltrank ein. "+"Dadurch erhöht sich die HP um "+(getGrundGesundheit()*0.75));
			userEingabe.nextLine();
		}
		else if(inventar[inventarStelle].equals("Verteidigungstrank")) {
			changeVerteidigungUm(getVerteidigung()/2);
			inventar[inventarStelle] = "leer";
			System.out.println(getName()+" setzt einen Verteidigungstrank ein. "+"Die Verteidigung von "+getName()+" wurde um "+(getVerteidigung()/2)+" erhöht!");
			userEingabe.nextLine();
		}
		else if(inventar[inventarStelle].equals("ATK-Steigerer")) {
			changeAngriffskraftUm(getGrundAngriffsKraft()/2);
			inventar[inventarStelle] = "leer";
			System.out.println(getName()+" setzt einen ATK-Steigerer ein. "+"Die Angriffskraft von "+getName()+" wurde um "+(getGrundAngriffsKraft()/2)+" erhöht!");
			userEingabe.nextLine();
		}
		else if(inventar[inventarStelle].equals("Zustands-Neutralisierer")) {
			setZustand("normal");
			inventar[inventarStelle] = "leer";
			System.out.println(getName()+" setzt einen Zustands-Neutralisierer ein. "+"Alle negativen Zustaende von "+getName()+" wurden entfernt.");
			userEingabe.nextLine();
		}
		else if(inventar[inventarStelle].equals("Kleiner Energietrank")) {
			changeEnergieUm((int) (getGrundEnergie()*0.25));
			inventar[inventarStelle] = "leer";
			System.out.println(getName()+" setzt einen kl. Energietrank ein. "+"Die Energie von "+getName()+" wurde um"+(getGrundEnergie()*0.25)+" erhöht!");
			userEingabe.nextLine();
		}
		else if(inventar[inventarStelle].equals("Mittlerer Energietrank")) {
			changeEnergieUm((int) (getGrundEnergie()*0.5));
			inventar[inventarStelle] = "leer";
			System.out.println(getName()+" setzt einen mttl. Energietrank ein. "+"Die Energie von "+getName()+" wurde um"+(getGrundEnergie()*0.5)+" erhöht!");
			userEingabe.nextLine();
		}
		else if(inventar[inventarStelle].equals("Grosser Energietrank")) {
			changeEnergieUm((int) (getGrundEnergie()*0.75));
			inventar[inventarStelle] = "leer";
			System.out.println(getName()+" setzt einen gr. Energietrank ein. "+"Die Energie von "+getName()+" wurde um"+(getGrundEnergie()*0.75)+" erhöht!");
			userEingabe.nextLine();
		}
		else if(inventar[inventarStelle].equals("leer")) {
			System.out.println("Dieser Inventarplatz ist leer!");
			userEingabe.nextLine();
			benutzeItem(inventarStelle);
		}
		energie--;
	}
	
	
	public void itemDrop() {
		double random = Math.random();
		boolean itemDrop = true;
		while(itemDrop) {
			if(random<0.4) {
				System.out.println("Du erhältst kein Item.");
				userEingabe.nextLine();
				itemDrop = false;
				break;
			}
			else if(random>=0.4) {
				random = Math.random();
				if(random<=0.25) {
					random = Math.random();
					if(random<=0.5)
						inventarFuegeHinzu("Kleiner Heiltrank");
					else if(random>0.5)
						inventarFuegeHinzu("Kleiner Energietrank");
					System.out.println("Du erhältst das Item \""+getInventarLast()+"\".");
					userEingabe.nextLine();
					itemDrop = false;
					break;
				}
				else if(random>0.25 && random<=0.42) {
					random = Math.random();
					if(random>0.5)
						inventarFuegeHinzu("Mittlerer Heiltrank");
					else if(random<=0.5)
						inventarFuegeHinzu("Mittlerer Energietrank");
					System.out.println("Du erhältst das Item \""+getInventarLast()+"\".");
					userEingabe.nextLine();
					itemDrop = false;
					break;
				}
				else if(random>0.42 && random<0.52) {
					random = Math.random();
					if(random>0.5)
						inventarFuegeHinzu("Grosser Heiltrank");
					else if(random<=0.5)
						inventarFuegeHinzu("Grosser Energietrank");
					System.out.println("Du erhältst das Item \""+getInventarLast()+"\".");
					userEingabe.nextLine();
					itemDrop = false;
					break;
				}
				else if(random>=0.52 && random<0.97) {
					random = Math.random();
					if(random<=0.33)
						inventarFuegeHinzu("Verteidigungstrank");
					else if(random>0.33 && random<=0.66)
						inventarFuegeHinzu("ATK-Steigerer");
					else if(random>0.66 && random <= 1)
						inventarFuegeHinzu("Zustands-Neutralisierer");
					System.out.println("Du erhältst das Item \""+getInventarLast()+"\".");
					userEingabe.nextLine();
					itemDrop = false;
					break;
				}
				else if(random>=0.97 && random <=1) {
					inventarFuegeHinzu("Level-Up-Trank");
					System.out.println("Du erhältst das Item \""+getInventarLast()+"\".");
					userEingabe.nextLine();
					itemDrop = false;
					break;
				}
				
			}
		}
	}
	
	//--------------INVENTAR ENDE-----------------------
	
	//--------------GETTER & SETTER ANFANG--------------
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getName() {	 
		return name;
	}

	 
	public String getAttacke1() {
		return attacke1;
	}
	
	public void setAttacke1(String attacke1) {
		this.attacke1 = attacke1;
	}
	 
	public String getAttacke2() {	 
		return attacke2;
	}
	
	public void setAttacke2(String attacke2) {
		this.attacke2 = attacke2;
	}
	 
	public String getAttacke3() {	 
		return attacke3;
	}
	
	public void setAttacke3(String attacke3) {
		this.attacke3 = attacke3;
	}

	 
	public String getAttacke4() { 
		return attacke4;
	}
	
	public void setAttacke4(String attacke4) {
		this.attacke4 = attacke4;
	}
	
	public String getAttacke5Spezial() {
		return attacke5Spezial;
	}
	
	public void setAttacke5Spezial(String attacke5Spezial) {
		this.attacke5Spezial = attacke5Spezial;
	}

	 
	public int getAttackenKraft(int attackeNummer) {
		if(attackeNummer==1)
			return angriffskraft;
		else if(attackeNummer==2)
			return (int) (angriffskraft+(angriffskraft*0.2));
		else if(attackeNummer==3)
			return (int) (angriffskraft+(angriffskraft*0.4));
		else if(attackeNummer==4)
			return (int) (angriffskraft+(angriffskraft*0.6));
		else if(attackeNummer==5)
			return (int) (angriffskraft+(angriffskraft*0.8));
		else
			return 0;
	}

	 
	public int getVerteidigung() {
		return verteidigung;
	}
	
	public void setGrundVerteidigung(int grundVerteidigung) {
		this.grundVerteidigung = grundVerteidigung;
		verteidigung = this.grundVerteidigung;
	}
	
	public int getGrundVerteidigung() {
		return this.grundVerteidigung;
	}
	
	public void setGrundAngriffskraft(int grundAngriffskraft) {
		this.grundAngriffskraft = grundAngriffskraft;
		angriffskraft = this.grundAngriffskraft;
	}
	
	public int getGrundAngriffsKraft() {
		return grundAngriffskraft;
	}
	
	public void setGrundGesundheit(int grundGesundheit) {
		this.grundGesundheit = grundGesundheit;
		gesundheit = this.grundGesundheit;
	}
	
	public int getGrundGesundheit() {
		return grundGesundheit;
	}
	
	public void setGrundEnergie(int grundEnergie) {
		this.grundEnergie = grundEnergie;
		energie = this.grundEnergie;
	}
	 
	public int getEnergie() {
		return energie;
	}
	
	public int getGrundEnergie() {
		return grundEnergie;
	}
 
	public int getLevel() { 
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getGesundheit() {
		return gesundheit;
	}
	
	public int getErfahrungspunkte() {
		return erfahrungspunkte;
	}
	
	public void setErfahrungspunkte(int erfahrungspunkte) {
		this.erfahrungspunkte = erfahrungspunkte;
	}
	
	public void setZustand(String zustand) {
		this.zustand = zustand;
	}
	
	public String getZustand() {
		return zustand;
	}
	
	public int getSpezialZaehler(){
		return spezialZaehler;
	}
	
	
	//--------------GETTER & SETTER ENDE--------------
	
	public static void dot(long millis) {
		try {
			Thread.sleep(millis);
			System.out.print(".");
			Thread.sleep(millis);
			System.out.print(".");
			Thread.sleep(millis);
			System.out.println(".");
		}
		catch(Exception e) {
			System.out.println("Blub");
		}
	}

}
