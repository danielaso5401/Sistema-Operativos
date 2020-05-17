package so4;

public class Simulacion01 {

	public static void main(String[] args)throws InterruptedException {
		
		Filosofo[] fil=new Filosofo[5];
		int i=0;
		while(true) {
			fil[i]=new Filosofo(i);
			
			fil[i].start();
			fil[i].join();
			i++;
			if(i==5){
				i=0;
			}
		}
		

	}

}
