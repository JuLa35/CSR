import java.util.Random;

/* Importation de la classe Lecture. */


class SystemeEmprunt extends Thread {


/* Constantes (final indique que la valeur ne peut pas changer) */

static final int nbSites = 5;
static final int maxClients = 100;

/* Ces attributs sont statiques */

private static Site[] sites = new Site[nbSites];
private Client[] clients = new Client[maxClients];
private int nbClients = 0;

private Camion c;


/* Cette fonction cr�e un seul client � la fois (� la limite aucun).
 * Elle renvoie vrai si et seulement si un client a �t� cr��.
 * Elle renvoie faux d�s que la cr�ation des clients est termin�e. */

private boolean nouveauClient() {

	Site depart;
	Site arrivee;

	if(nbClients == maxClients) {
		System.out.println("Le nombre maximum de clients est"
			+ " atteint.");
		return false;
	}

	depart = sites[0];
	arrivee = sites[1];

	clients[nbClients] = new Client(nbClients, depart, arrivee);
	nbClients++;

	return true;

}

private boolean nouveauClient(Site siteD, Site siteF) {
	
	if(nbClients == maxClients) {
		System.out.println("Le nombre maximum de clients est"
			+ " atteint.");
		return false;
	}
	clients[nbClients] = new Client(nbClients, siteD, siteF);
	nbClients++;

	return true;
}

private int[] randomSite() {
	int[] res = new int[2];
	Random r = new Random();
    res[0] = r.nextInt((4 - 0) + 1);
    r = new Random();
    int add = r.nextInt((4 - 0) + 1);
    while(add == res[0]) {
    	r = new Random();
    	add = r.nextInt((4 - 0) + 1);	
    }
	res[1] = add;
	return res;
}


/* Constructeur. Il est appel� lors de l'instanciation du syst�me d'emprunt. */

public SystemeEmprunt() {

	int i;

	/* Instanciation des sites */
	for(i = 0; i < nbSites; i++)
		sites[i] = new Site(i);

	/* Instanciation du camion et des clients */
	/*for( i = 0; i < maxClients; i++) {
		nouveauClient();
	}*/

	int[] numSites = randomSite();
	nouveauClient(sites[numSites[0]], sites[numSites[1]]);
	numSites = randomSite();
	nouveauClient(sites[numSites[0]], sites[numSites[1]]);
	numSites = randomSite();
	nouveauClient(sites[numSites[0]], sites[numSites[1]]);
	numSites = randomSite();
	nouveauClient(sites[numSites[0]], sites[numSites[1]]);
	numSites = randomSite();
	nouveauClient(sites[numSites[0]], sites[numSites[1]]);
	
	this.c = new Camion(10, sites[0]);
	
    /* ... */
}

public static void afficherEtatSites() {
	System.out.println("Site 0 : Velos = " + sites[0].getnbV());
	System.out.println("Site 1 : Velos = " + sites[1].getnbV());
	System.out.println("Site 2 : Velos = " + sites[2].getnbV());
	System.out.println("Site 3 : Velos = " + sites[3].getnbV());
	System.out.println("Site 4 : Velos = " + sites[4].getnbV());
}

public void run() {
	clients[0].start();
	clients[1].start();
	clients[2].start();
	clients[3].start();
	clients[4].start();
	c.start();
}

/* Point d'entr�e du programme */

public static void main(String[] args) {

	SystemeEmprunt se = new SystemeEmprunt();
	se.run();
	se.afficherEtatSites();

}


} // class SystemeEmprunt
