class Site {

/* Constantes associ�es au site */

static final int stockInit = 6;
static final int stockMax = 10;
static final int borneSup = 8;
static final int borneInf = 2;

int nbV = 6;
int numSite;
boolean camion;

	public Site(int i) {
		this.numSite = i;
	}
	
	public synchronized int getNumSite() {
		return this.numSite;
	}
	
	public synchronized void setNumSite(int num) {
		this.numSite = num;
	}
	
	public synchronized int getnbV() {
		return this.nbV;
	}
	
	public synchronized void prendreV() {
		/* changer attente active*/
		while(this.nbV < 0) {}
		this.nbV --;
	}
	
	public synchronized void deposerV() {
		/* changer attente active*/
		while(this.nbV > 9) {}
		this.nbV ++;
	}
	
	public synchronized boolean camionIsHere(boolean isHere){
		return camion = isHere;
	}
	
	public synchronized boolean camionIsHere(){
		return camion;
	}

}

