
public class Items {
	
	String itemName;
	
	Items(String itemName){
		if(itemName.equals("")) {
			this.itemName = "leer";
		}
		if(itemName.equals("kleinerHeiltrank")) {
			this.itemName = "Kleiner Heiltrank";
		}
		if(itemName.equals("mittlererHeiltrank")) {
			this.itemName = "Mittlerer Heiltrank";
		}
		if(itemName.equals("grosserHeiltrank")) {
			this.itemName = "Grosser Heiltrank";
		}
		if(itemName.equals("verteidigungsTrank")) {
			this.itemName = "Verteidigungstrank";
		}
		if(itemName.equals("atkSteigerer")) {
			this.itemName = "ATK-Steigerer";
		}
		if(itemName.equals("zustandsNeutralisierer")) {
			this.itemName = "Zustands-Neutralisierer";
		}
		if(itemName.equals("kleinerEnergieTrank")) {
			this.itemName = "Kleiner Energietrank";
		}
		if(itemName.equals("mittlererEnergieTrank")) {
			this.itemName = "Mittlerer Energietrank";
		}
		if(itemName.equals("grosserEnergieTrank")) {
			this.itemName = "Grosser Energietrank";
		}
	}
	
	public String getItemName() {
		return this.itemName;
	}

}
