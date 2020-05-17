package filosofos ciclicos;

public class Simulacion01 {

	public static void main(String[] args)throws InterruptedException {
		
		Filosofo[] fil=new Filosofo[5];//creamos el tamaño deseado de filsoofos
		int i=0;
		while(true) {
			fil[i]=new Filosofo(i);
			fil[i].start();
			fil[i].join();
			/*usamos el metodo joing de manera que una vez que un filosofo piense pase al siguiente y de esa manera
			tenerlo controlado*/
			i++;
			if(i==5){
				i=0;
			}
		}
		

	}

}
