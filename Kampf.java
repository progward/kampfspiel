import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class Kampf {
	
	public static void kampfBeginn(Instanzen gegner, Instanzen userPlayer) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		Scanner userInput = new Scanner(System.in);
		double random = Math.random();
		boolean gegnerDran = true;
		boolean userDran = true;
		boolean kampfFortfuehren = true;
		boolean userVerteidigt = false;
		boolean userKritischerTreffer = false;
		boolean gegnerKritischerTreffer = false;
		//int angriffskraftZaehler = 0;
		int gegnerSchlaeftZaehler = 0;
		int userSchlaeftZaehler = 0;
		int gegnerVergiftetZaehler = 0;
		int userVergiftetZaehler = 0;
		
		System.out.print("Du triffst auf \""+gegner.getName()+"\" (Level: "+gegner.getLevel()+")");
		Instanzen.dot(600);
		System.out.println("Der Kampf beginnt!");
		
		
		if (random>=0.5){
			System.out.println(gegner.getName()+" ist schneller...");
			userInput.nextLine();
			gegnerDran = true;
			userDran = false;
		}
		else if(random<0.5) {
			System.out.println("Du bist schneller...");
			userInput.nextLine();
			userDran = true;
			gegnerDran = false;
		}	
		
		while(kampfFortfuehren) {
			while(gegnerDran) {
				
				gegner.changeEnergieUm(1);
				
				if(userPlayer.getGesundheit()<=0 ||gegner.getGesundheit()<=0) {
					kampfFortfuehren = false;
					userDran = false;
					gegnerDran = false;
					break;
				}
				
				if(gegner.getZustand().equals("schlaeft")) {
					gegnerSchlaeftZaehler++;
					if(gegnerSchlaeftZaehler<4) {
						gegnerDran=false;
						userDran=true;
						System.out.print(gegner.getName()+" schlaeft tief und fest...");
						userInput.nextLine();
						break;
					}
					if(gegnerSchlaeftZaehler==4) {
						gegnerSchlaeftZaehler=0;
						gegner.setZustand("normal");
						System.out.print(gegner.getName()+" ist wieder aufgewacht.");
						userInput.nextLine();
					}
				}
				
				if(gegner.getZustand().equals("vergiftet")) {
					gegnerVergiftetZaehler++;
					if(gegnerVergiftetZaehler<4) {
						System.out.print(gegner.getName()+" verliert durch die Vergiftung "+(gegner.getGrundGesundheit()/6)+"HP.");
						gegner.changeHpUm(-(gegner.getGrundGesundheit()/6));
						userInput.nextLine();	
					}
					if(gegnerVergiftetZaehler==4) {
						gegnerVergiftetZaehler=0;
						gegner.setZustand("normal");
						System.out.print(gegner.getName()+" ist nicht mehr vergiftet.");
						userInput.nextLine();
					}
				}
				
				random = Math.random();
				if(gegner.getEnergie() == 1) {
					gegner.greiftAn(1);
					userPlayer.wirdAngegriffen(gegner.getAttackenKraft(1), gegner.getAttacke1());					
					userDran = true;
					break;
				}
					
				if(gegner.getEnergie() <= 2) {
					if(random >= 0.5) {
						gegner.greiftAn(2);					
						userPlayer.wirdAngegriffen(gegner.getAttackenKraft(2),gegner.getAttacke2());					
						userDran = true;
						break;
					}
					else if(random < 0.5) {
						gegner.greiftAn(1);						
						userPlayer.wirdAngegriffen(gegner.getAttackenKraft(1),gegner.getAttacke1());
						userDran = true;
						break;
					}
				}
				if(gegner.getEnergie() <= 3) {
					if(random <= 0.3) {
						gegner.greiftAn(2);						
						userPlayer.wirdAngegriffen(gegner.getAttackenKraft(2),gegner.getAttacke2());						
						userDran = true;
						break;
					}
					else if(random > 0.3 && random < 0.65) {
						gegner.greiftAn(1);						
						userPlayer.wirdAngegriffen(gegner.getAttackenKraft(1),gegner.getAttacke1());
						userDran = true;
						break;
					}
					else if(random >=0.65 && random <= 1) {
						gegner.greiftAn(3);
						userPlayer.wirdAngegriffen(gegner.getAttackenKraft(3),gegner.getAttacke3());
						userDran = true;
						break;
					}
				}
				if(gegner.getEnergie() >= 4) {
					random = Math.random();
					if(random<=0.5) {
						random = Math.random();
						if(random < 0.33) {
							gegner.greiftAn(2);
							userPlayer.wirdAngegriffen(gegner.getAttackenKraft(2),gegner.getAttacke2());
							userDran = true;
							break;
						}
						else if(random >= 0.33 && random < 0.66) {
							gegner.greiftAn(1);
							userPlayer.wirdAngegriffen(gegner.getAttackenKraft(1),gegner.getAttacke1());
							userDran = true;
							break;
						}
						else if(random >= 0.66 && random <= 1) {
							gegner.greiftAn(3);
							userPlayer.wirdAngegriffen(gegner.getAttackenKraft(3),gegner.getAttacke3());
							userDran = true;
							break;
						}
					}
					else if(random>0.5) {
						if(gegner.getSpezialZaehler()>=5) {
							gegner.greiftAn(5);
							userPlayer.wirdAngegriffen(gegner.getAttackenKraft(5), gegner.getAttacke5Spezial());
							userDran = true;
							break;
						}
						else {
							gegner.greiftAn(4);
							userPlayer.wirdAngegriffen(gegner.getAttackenKraft(4),gegner.getAttacke4());
							userDran = true;
							break;
						}
					}
				}
			}
			while(userDran) {
				
				random = Math.random();
							
				userPlayer.changeEnergieUm(1);
				
				if(userVerteidigt) {
					userPlayer.changeVerteidigungUm(-(userPlayer.getVerteidigung()/2));
					userVerteidigt = false;
				}
				
				if(userPlayer.getZustand().equals("schlaeft")) {
					userSchlaeftZaehler++;
					if(userSchlaeftZaehler<4) {
						userDran=false;
						gegnerDran=true;
						System.out.print(userPlayer.getName()+" schlaeft tief und fest...");
						userInput.nextLine();
						break;
					}
					if(userSchlaeftZaehler==4) {
						userSchlaeftZaehler=0;
						userPlayer.setZustand("normal");
						System.out.print(userPlayer.getName()+" ist wieder aufgewacht.");
						userInput.nextLine();
					}
				}
				
				if(userPlayer.getZustand().equals("vergiftet")) {
					userVergiftetZaehler++;
					if(userVergiftetZaehler<4) {
						System.out.print(userPlayer.getName()+" verliert durch die Vergiftung "+(userPlayer.getGrundGesundheit()/6)+"HP.");
						userPlayer.changeHpUm(-(userPlayer.getGrundGesundheit()/6));
						userInput.nextLine();	
					}
					if(userVergiftetZaehler==4) {
						userVergiftetZaehler=0;
						userPlayer.setZustand("normal");
						System.out.print(gegner.getName()+" ist nicht mehr vergiftet.");
						userInput.nextLine();
					}
				}
				
				if(userPlayer.getGesundheit()<=0 ||gegner.getGesundheit()<=0) {
					kampfFortfuehren = false;
					userDran = false;
					gegnerDran = false;
					break;
				}
				
				System.out.println("Was willst du tun? (Spezialaufladungen: "+userPlayer.getSpezialZaehler()+" | Energie: "+userPlayer.getEnergie()+" | HP: "+userPlayer.getGesundheit()+")");
				System.out.println("a: Angreifen \nb: Item einsetzen\nc: Fluchtversuch\nd: Nichts\ne: Verteidigen (3 Energie)");
				String antwort = userInput.nextLine();
				
				if(antwort.equals("a")) {
					antwort = "";
					System.out.println("a: "+userPlayer.getAttacke1()+" (1 Energie)\nb: "+userPlayer.getAttacke2()+" (2 Energie)\nc: "+userPlayer.getAttacke3()+" (3 Energie)\nd: "+userPlayer.getAttacke4()+" (4 Energie)\ne: "+userPlayer.getAttacke5Spezial()+" (5 Energie)");
					antwort = userInput.nextLine();
					if(antwort.equals("a")) {
						userPlayer.greiftAn(1);
						gegner.wirdAngegriffen(userPlayer.getAttackenKraft(1),userPlayer.getAttacke1());
						userDran = false;
						gegnerDran = true;
						break;
					}
					else if(antwort.equals("b")) {
						if(userPlayer.getEnergie() >=2) {
							userPlayer.greiftAn(2);
							gegner.wirdAngegriffen(userPlayer.getAttackenKraft(2),userPlayer.getAttacke2());
							userDran = false;
							gegnerDran = true;
							break;
						}
						else {
							System.out.print("Energie zu gering!");
							userInput.nextLine();
						}
					}
					else if(antwort.equals("c")) {
						if(userPlayer.getEnergie() >=3) {
							userPlayer.greiftAn(3);
							gegner.wirdAngegriffen(userPlayer.getAttackenKraft(3),userPlayer.getAttacke3());
							userDran = false;
							gegnerDran = true;
							break;	
						}
						else {
							System.out.print("Energie zu gering!");
							userInput.nextLine();
						}
					}
					else if(antwort.equals("d")) {
						if(userPlayer.getEnergie() >=4) {
							userPlayer.greiftAn(4);
							gegner.wirdAngegriffen(userPlayer.getAttackenKraft(4),userPlayer.getAttacke4());
							userDran = false;
							gegnerDran = true;
							break;	
						}
						else {
							System.out.print("Energie zu gering!");
							userInput.nextLine();
						}
					}
					else if(antwort.equals("e")){
						if(userPlayer.getEnergie() >=4 && userPlayer.getSpezialZaehler() >=5) {
							userPlayer.greiftAn(5);
							gegner.wirdAngegriffen(userPlayer.getAttackenKraft(5), userPlayer.getAttacke5Spezial());
							userDran = false;
							gegnerDran = true;
							break;
						}
						else {
							System.out.print("Energie zu gering, oder zu wenig Spezialaufladungen!");
						}
					}				
				}
				else if(antwort.equals("b")) {
					userPlayer.getInventarInhaltAusgabe();
					if(!userPlayer.getInventarInhalt(1).equals("leer")) {
						System.out.println("Welches Item möchtest du nutzen? (Alternativ 'x' um zurück zu gelangen)");
						antwort = userInput.nextLine();
						if(antwort.equals("x")) {
							userPlayer.changeEnergieUm(-1);
						}
						else if(antwort.equals("1") || antwort.equals("2") || antwort.equals("3") || antwort.equals("4") || antwort.equals("5") || antwort.equals("6") || antwort.equals("7") || antwort.equals("8") || antwort.equals("9") || antwort.equals("10")) {
							int antwort2 = Integer.parseInt(antwort);
							userPlayer.benutzeItem(antwort2);
							userDran = false;
							gegnerDran = true;
							break;
						}
						else {
							userPlayer.changeEnergieUm(-1);
						}
					}
					else {
						System.out.println("Dein Inventar ist leer!");
						userInput.nextLine();
					}
				}
				else if(antwort.equals("c")) {
					System.out.print("Du versuchst zu fliehen");
					Instanzen.dot(500);
					random = Math.random();
					if(random > 0.7) {
						System.out.println("Die Flucht ist gelungen!");
						userInput.nextLine();
						kampfFortfuehren = false;
						break;
					}
					else {
						System.out.print("Die Flucht ist gescheitert!");
						userInput.nextLine();
						userDran = false;
						gegnerDran = true;
						break;
					}
				}
				else if(antwort.equals("d")) {
					System.out.print("Du setzt eine Runde aus");
					Instanzen.dot(500);
					userDran = false;
					gegnerDran = true;
					break;
				}
				else if(antwort.equals("e")) {
					userVerteidigt = true;
					userPlayer.changeVerteidigungUm(userPlayer.getVerteidigung());
					userPlayer.changeEnergieUm(-3);
					userPlayer.changeSpezialZaehlerUm(1);
					System.out.println("Verteidigung wird für eine Runde auf "+userPlayer.getVerteidigung()+" erhöht.");
					userInput.nextLine();
					userDran = false;
					gegnerDran = true;
					break;
				}
			}
		}
		if(gegner.getGesundheit() <= 0) {
			System.out.print("Glückwunsch, du hast deinen Gegner besiegt");
			Instanzen.dot(400);
			System.out.println("Du erhältst "+gegner.getErfahrungspunkte()+" EXP.");
			userPlayer.setErfahrungspunkte(userPlayer.getErfahrungspunkte()+gegner.getErfahrungspunkte());
			userPlayer.stufenAufstieg();
			userPlayer.itemDrop();
		}
		else if(userPlayer.getGesundheit()<=0) {
			System.out.println("Du hast verloren");
			Instanzen.dot(400);
			System.out.println("Du erhältst 0 EXP.");
			userInput.nextLine();
			System.out.println("Du erhältst kein Item.");
			

		}
		else{
			System.out.println("Niemand hat gewonnen.");
			userInput.nextLine();
			
		}
		userPlayer.werteResetNachKampf();
		gegner.werteResetNachKampf();
	}
}

