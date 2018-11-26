public class Client extends Thread{

	Site siteD;
	Site siteF;
	int nbClients = 0;

	
	public Client(int nbClients, Site siteD, Site siteF) {
		this.siteD = siteD;
		this.siteF = siteF;
		this.nbClients = nbClients;
	}
	
	public synchronized void emprunt() throws InterruptedException {
		while (siteD.getnbV() == 0 || siteD.camionIsHere()) {
			wait();
		}
		siteD.prendreV();
	}
	
	public synchronized void depot() throws InterruptedException{
		while (siteF.getnbV() == 10 || siteF.camionIsHere()) {
			wait();
		}
		siteF.deposerV();
	}
	
	public synchronized void run() {
		try {
			notifyAll();
			emprunt();
			int duree = Math.abs(siteF.getNumSite()-siteD.getNumSite());
			sleep(100* duree);
			depot();
			notifyAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
