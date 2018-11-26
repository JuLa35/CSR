public class Client extends Thread{

	Site siteD;
	Site siteF;
	int nbClients = 0;

	
	public Client(int nbClients, Site siteD, Site siteF) {
		this.siteD = siteD;
		this.siteF = siteF;
		this.nbClients = nbClients;
	}
	
	public void emprunt() {
		while (siteD.getnbV() == 0) {
		}
		siteD.prendreV();
	}
	
	public void depot() {
		while (siteF.getnbV() == 10) {
			
		}
		siteF.deposerV();
	}
	
	public void run() {
		emprunt();
		try {
			int duree = Math.abs(siteF.getNumSite()-siteD.getNumSite());
			sleep(100* duree);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		depot();
	}
}
