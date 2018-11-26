class Site {

/* Constantes associ�es au site */

static final int stockInit = 6;
static final int stockMax = 10;
static final int borneSup = 8;
static final int borneInf = 2;

int nbV = 6;
int numSite;

	public Site(int i) {
		this.numSite = i;
	}
	
	public int getNumSite() {
		return this.numSite;
	}
	
	public void setNumSite(int num) {
		this.numSite = num;
	}
	
	public int getnbV() {
		return this.nbV;
	}
	
	public void prendreV() {
		/* changer attente active*/
		while(this.nbV < 0) {}
		this.nbV --;
	}
	
	public void deposerV() {
		/* changer attente active*/
		while(this.nbV > 9) {}
		this.nbV ++;
	}

}

