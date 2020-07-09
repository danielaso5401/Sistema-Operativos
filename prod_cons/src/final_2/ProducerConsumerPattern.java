/*creditos: Javin paul at February 16, 2017 https://javarevisited.blogspot.com/2012/02/producer-consumer-design-pattern-with.html */
package final_2;
import java.awt.Label;
import java.awt.TextArea;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea; 

public class ProducerConsumerPattern {

    public static void main(String args[]){
  
     //Creating shared object
     BlockingQueue sharedQueue = new LinkedBlockingQueue();
 
     //Creating Producer and Consumer Thread
     //Thread prodThread = new Thread(new Producer(sharedQueue,10));
     //Thread consThread = new Thread(new Consumer(sharedQueue,1));
     //Thread consThread2 = new Thread(new Consumer(sharedQueue,2));
     
     //Starting producer and Consumer thread
     //prodThread.start();
     //consThread.start();
     //consThread2.start();
     
    }
 
}


//Producer Class in java
class Producer extends Thread {
  JProgressBar prod_line;
  TextArea mensajes;
  public BlockingQueue sharedQueue;
  int buffer;
  Label t1;
  public Producer(BlockingQueue sharedQueue, int y, JProgressBar jpb, TextArea jta, Label tiempo) {
      this.sharedQueue = sharedQueue;
      this.buffer=y;
      this.prod_line=jpb;
      this.prod_line.setMinimum(0);
      this.prod_line.setMaximum(y-1);
      this.mensajes=jta;
      this.t1=tiempo;
    
  }

  @Override
  public void run() {
	  
      
      
       
      
	  //char val='a';
	  if(buffer!=0) {
			  for(int i=0; i<buffer; i++){
		          String val="";
				  try {
					  this.prod_line.setValue(i);
					  //System.out.println("Produced: " + val);
				      int codigoAscii = (int)Math.floor(Math.random()*(122 -97)+97); 
				      val = val + (char)codigoAscii; 

					  mensajes.append("Produced: " + val+"\n");
					  sharedQueue.put(val);
		              //val++;
		              //Thread.sleep((Math.random() * 2000));
		              
		              this.sleep((int) (Math.random() * 2000));
		          } catch (InterruptedException ex) {
		              Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
		          }
		      }  
	  }
	  else {
		  while(true) {
			  	String val="";
		          try {
		              //System.out.println("Produced: " + val);
		        	  int codigoAscii = (int)Math.floor(Math.random()*(122 -97)+97); 
				      val = val + (char)codigoAscii; 
				      
		        	  mensajes.append("Produced: " + val+"\n");
		              sharedQueue.put(val);
		              //val++;
		              //Thread.sleep(1000);
		              this.sleep((int) (Math.random() * 2000));
		          } catch (InterruptedException ex) {
		              Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
		          }
		      
		  }
	  }
	   
      
      
      
  }



}

//Consumer Class in Java
class Consumer extends Thread{

  public BlockingQueue sharedQueue;
  int id;
  TextArea mensaje;
  Label t2;
  public Consumer (BlockingQueue sharedQueue, int x, TextArea jta, Label tiempo) {
      this.sharedQueue = sharedQueue;
      id=x;
      mensaje=jta;
      this.t2=tiempo;
  }

  @Override
  public void run() {
      while(true){
          try {
        	  this.sleep((int) (Math.random() * 2000));
        	  mensaje.append("Consumed"+id+": "+ sharedQueue.take()+"\n");
          } catch (InterruptedException ex) {
              Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
          }
          
      }
  }


}


