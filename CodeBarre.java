
public class CodeBarre {
	private String identifiant;
	
	public CodeBarre(){
		
	}
	
	// === GETTER & SETTER =====================
	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	
	// === FONCTION ============================
	public int calculCleEAN(){
		int somme=0, i;		
		String chiffreCB = this.identifiant.substring(4, Math.min(this.identifiant.length(), this.identifiant.length()));
		String[] listeChiffreCB = chiffreCB.split("");
		
		for(i=0;i<11;i++){
			if (i%2==0){
				somme = somme + Integer.parseInt(listeChiffreCB[i]);
			}else{
				somme = somme + Integer.parseInt(listeChiffreCB[i])*3;
			}
		}
		
		if(somme%10==0){
			return 0;
		}
		return 10-somme%10;
	}
	
	// == Programme principal =================
	public static void main(String[] args){
		CodeBarre codeBarre1 = new CodeBarre();
		codeBarre1.setIdentifiant("EAN 303792016200");
		
		int cleCodeBarre = codeBarre1.calculCleEAN();
		System.out.println("CleEAN = " + cleCodeBarre);
	}
}
