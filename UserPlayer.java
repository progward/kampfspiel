import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Scanner;

public class UserPlayer extends Instanzen {
	
	
	
	UserPlayer(String antwort) throws IOException{
		
		if(antwort.equals("n")) {
			Scanner userInput = new Scanner(System.in);
			System.out.println("Bitte gib ein, wie dein Charakter heiﬂen soll.");
			UserPlayer.this.setName(userInput.nextLine());
			UserPlayer.this.setAttacke1("Faustschlag");
			UserPlayer.this.setAttacke2("Tritt");
			UserPlayer.this.setAttacke3("Ellbogen-Punch");
			UserPlayer.this.setAttacke4("Sprunghieb");
			UserPlayer.this.setAttacke5Spezial("Spezialattacke (S): Gute-Nacht-Lied");
			UserPlayer.this.setZustand("normal");
			UserPlayer.this.setGrundVerteidigung(8);
			UserPlayer.this.setGrundAngriffskraft(18);
			UserPlayer.this.setGrundGesundheit(100);
			UserPlayer.this.setGrundEnergie(10);
			UserPlayer.this.setLevel(1);
			UserPlayer.this.setErfahrungspunkte(0);
			System.out.println("Bitte warte nun einen Moment.");
		}
		else if(antwort.equals("l")) {
			Scanner userInput = new Scanner(System.in);
			boolean tryIt = true;
			while(tryIt) {
				System.out.println("Bitte GIB den Pfad zu der Speicherdatei, inklusive dem Namen der Speicherdatei ein.\n"
						+ "Zum Beispiel so: C:/User/Speicherort/speicherdatei.txt");
				try {
					FileReader readFile = new FileReader(userInput.nextLine());
					BufferedReader readToCode = new BufferedReader(readFile);
					
					UserPlayer.this.setName(readToCode.readLine());
					UserPlayer.this.setAttacke1(readToCode.readLine());
					UserPlayer.this.setAttacke2(readToCode.readLine());
					UserPlayer.this.setAttacke3(readToCode.readLine());
					UserPlayer.this.setAttacke4(readToCode.readLine());
					UserPlayer.this.setAttacke5Spezial(readToCode.readLine());
					UserPlayer.this.setZustand(readToCode.readLine());
					UserPlayer.this.setGrundVerteidigung(Integer.parseInt(readToCode.readLine()));
					UserPlayer.this.setGrundAngriffskraft(Integer.parseInt(readToCode.readLine()));
					UserPlayer.this.setGrundGesundheit(Integer.parseInt(readToCode.readLine()));
					UserPlayer.this.setGrundEnergie(Integer.parseInt(readToCode.readLine()));
					UserPlayer.this.setLevel(Integer.parseInt(readToCode.readLine()));
					UserPlayer.this.setErfahrungspunkte(Integer.parseInt(readToCode.readLine()));
					UserPlayer.this.inventarFuegeHinzu(1, readToCode.readLine());
					UserPlayer.this.inventarFuegeHinzu(2, readToCode.readLine());
					UserPlayer.this.inventarFuegeHinzu(3, readToCode.readLine());
					UserPlayer.this.inventarFuegeHinzu(4, readToCode.readLine());
					UserPlayer.this.inventarFuegeHinzu(5, readToCode.readLine());
					UserPlayer.this.inventarFuegeHinzu(6, readToCode.readLine());
					UserPlayer.this.inventarFuegeHinzu(7, readToCode.readLine());
					UserPlayer.this.inventarFuegeHinzu(8, readToCode.readLine());
					UserPlayer.this.inventarFuegeHinzu(9, readToCode.readLine());
					UserPlayer.this.inventarFuegeHinzu(10, readToCode.readLine());
					tryIt=false;
				}
				catch(Exception e) {
					System.out.println("Etwas lief schief. Vermutlich wurde der Pfad nicht erkannt.");
				}
			}
			System.out.println("Bitte warte nun einen Moment.");
		}
	}
	

}
