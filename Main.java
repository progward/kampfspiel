import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import java.io.FileWriter;
import java.io.BufferedWriter;

public class Main {
	public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
		
		Scanner userInput = new Scanner(System.in);
		System.out.println("Möchtest du einen bestehenden Charakter laden (l), oder einen Neuen erstellen (n)?");
		String antwort = userInput.nextLine();
		boolean programmAusfuehren=true;
		double random;
		UserPlayer user = new UserPlayer(antwort);
		Sound soundy = new Sound();
		
		while(programmAusfuehren) {	
			soundy.stopBackgroundMusic();
			soundy.playBackgroundMusic();

			System.out.println("Einen Kampf starten (f), dein Inventar betrachten (i), deine Charakterwerte ansehen (c), deinen Fortschritt speichern (s), oder das Spiel beenden (x)?");
			antwort = userInput.nextLine();
			if(antwort.equals("f")) {
				soundy.stopBackgroundMusic();
				random = Math.random();
				if(random<0.33) {
					soundy.playSkelettMusic();
					Skelett skeleton1 = new Skelett(user.getLevel());
					Kampf.kampfBeginn(skeleton1, user);
					soundy.stopSkelettMusic();
				}
				else if(random>=0.33 && random<0.66) {
					soundy.playScavengerMusic();
					Scavenger scav1 = new Scavenger(user.getLevel());
					Kampf.kampfBeginn(scav1, user);
					soundy.stopScavengerMusic();
				}
				else if(random>=0.66 && random <=1) {
					soundy.playGeistMusic();
					Geist ghost1 = new Geist(user.getLevel());
					Kampf.kampfBeginn(ghost1, user);
					soundy.stopGeistMusic();
				}
			}
			else if(antwort.equals("i")) {
				user.getInventarInhaltAusgabe();
				System.out.println();
				System.out.println("Willst du ein Item löschen? (Zahl eingeben, oder 'x' um ins Menü zurückzugelangen)");
				antwort = userInput.nextLine();
				if(antwort.equals("x")) {
					
				}
				else if(antwort.equals("1")|| antwort.equals("2") || antwort.equals("3") || antwort.equals("4") || antwort.equals("5") || antwort.equals("6") || antwort.equals("7") || antwort.equals("8") || antwort.equals("9") || antwort.equals("10")) {
					int antwort2 = Integer.parseInt(antwort);
					Instanzen.dot(500);
					System.out.print(user.getInventarInhalt(antwort2)+" wurde gelöscht.");
					user.inventarLoescheItem(antwort2);
					userInput.nextLine();
				}
				else {
					
				}
			}
			else if(antwort.equals("c")) {
				user.info();
				userInput.nextLine();
			}
			else if(antwort.equals("s")) {
				System.out.println("Bitte GIB den Pfad zu dem Ordner an, in welchem du die Save-Datei speichern möchtest.");
				System.out.println("(Zum Beispiel so: C:/DeinUserName/BeispielOrdner/");
				antwort = userInput.nextLine();
				try {
					FileWriter writer = new FileWriter(antwort+"/speicherdatei.txt");
					BufferedWriter writeToFile = new BufferedWriter(writer);
					System.out.print("Speichere");
					Instanzen.dot(500);
					System.out.println();
					writeToFile.write(user.getName());
					writeToFile.newLine();
					writeToFile.write(user.getAttacke1());
					writeToFile.newLine();
					writeToFile.write(user.getAttacke2());
					writeToFile.newLine();
					writeToFile.write(user.getAttacke3());
					writeToFile.newLine();
					writeToFile.write(user.getAttacke4());
					writeToFile.newLine();
					writeToFile.write(user.getAttacke5Spezial());
					writeToFile.newLine();
					writeToFile.write(user.getZustand());
					writeToFile.newLine();
					writeToFile.write(String.valueOf(user.getGrundVerteidigung()));
					writeToFile.newLine();
					writeToFile.write(String.valueOf(user.getGrundAngriffsKraft()));
					writeToFile.newLine();
					writeToFile.write(String.valueOf(user.getGrundGesundheit()));
					writeToFile.newLine();
					writeToFile.write(String.valueOf(user.getGrundEnergie()));
					writeToFile.newLine();
					writeToFile.write(String.valueOf(user.getLevel()));
					writeToFile.newLine();
					writeToFile.write(String.valueOf(user.getErfahrungspunkte()));
					writeToFile.newLine();
					writeToFile.write(user.getInventarInhalt(1));
					writeToFile.newLine();
					writeToFile.write(user.getInventarInhalt(2));
					writeToFile.newLine();
					writeToFile.write(user.getInventarInhalt(3));
					writeToFile.newLine();
					writeToFile.write(user.getInventarInhalt(4));
					writeToFile.newLine();
					writeToFile.write(user.getInventarInhalt(5));
					writeToFile.newLine();
					writeToFile.write(user.getInventarInhalt(6));
					writeToFile.newLine();
					writeToFile.write(user.getInventarInhalt(7));
					writeToFile.newLine();
					writeToFile.write(user.getInventarInhalt(8));
					writeToFile.newLine();
					writeToFile.write(user.getInventarInhalt(9));
					writeToFile.newLine();
					writeToFile.write(user.getInventarInhalt(10));
					System.out.println("Fertig!");
					userInput.nextLine();
					writeToFile.close();
					writer.close();
				}
				catch(Exception e) {
					System.out.println("Dieser Pfad konnnte nicht gefunden werden. Stelle sicher, dass der Pfad korrekt eingegeben wurde, und existiert. :>");
				}
			}
			else if(antwort.equals("x")) {
				System.out.print("Spiel wird beendet");
				Instanzen.dot(500);
				System.out.println();
				System.out.println("Bis dann!");
				programmAusfuehren=false;
			}
		}
	}
}
