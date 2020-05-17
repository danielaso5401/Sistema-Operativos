package filosofos_cilicos;

public class Filosofo extends Thread {
	int estomago;
	int name;
	public Filosofo(int fil) {
		this.estomago=0;
		this.name=fil;
	}
	public void run() {
		
		
			comer();
			try {
				this.sleep(1000);
			}
			catch( InterruptedException e) {
				e.printStackTrace();
				System.out.println("se produjo un error");
			}
			long inicio = System.nanoTime();
			pensar();
			long despues = System.nanoTime();
			long tiempo = despues - inicio;
			if(tiempo<=2000) {
				System.out.println(this.name + " acabo de morir de hambre.");
			};
			
		
	}
	public void comer() {
		long inicio=System.nanoTime();
		this.estomago++;
		long fin =System.nanoTime();
		long com =inicio-fin;
		System.out.println(this.name+" esta comiendo..."+this.estomago+" me demore"+com);
		
	}
	public void pensar() {
		long inicio=System.nanoTime();
		this.estomago--;
		long fin =System.nanoTime();
		long com =inicio-fin;
		System.out.println(this.name+" esta pensando..."+this.estomago+" me demore"+com);
		
	}

}
