
public class Camion extends Thread {

	int nbVelo = 0;
	Site siteActuel = new Site(0);
	
	
	public Camion(int nbv, Site siteAct) {
		this.nbVelo = nbv;
		this.siteActuel = siteAct;
		
	}
	
	public void deplacement() {
		int numActu = siteActuel.getNumSite();
		numActu = (numActu + 1)%5;
		try {
			sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.siteActuel.setNumSite(numActu);
	}
	
	public void equilibrage() {
		this.siteActuel.camionIsHere(true);
		int nbv = siteActuel.getnbV();
		if(nbv > siteActuel.borneSup) {
			while(nbv > siteActuel.stockInit) {
				siteActuel.prendreV();
				this.nbVelo ++;
			}
		}
		else if(nbv < siteActuel.borneInf) {
			while(nbv < siteActuel.stockInit) {
				if(nbVelo == 0) break;
				siteActuel.deposerV();
				this.nbVelo --;
			}
		}
		this.siteActuel.camionIsHere(false);
	}
	
	public Site siteActuelCamion(){
		return this.siteActuel;
	}
	
	public void run() {
		while(true) {
		deplacement();		
		equilibrage();
		}
		
	}
}
