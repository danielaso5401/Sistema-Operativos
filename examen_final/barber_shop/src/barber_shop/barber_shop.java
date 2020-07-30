package barber_shop;
import java.awt.TextArea;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.JProgressBar;
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class barber_shop {

}


class Barber implements Runnable
{
    Bshop shop;
    int nume;
    TextArea texto;
    JProgressBar barra;
    JLabel etiqueta;
    JLabel clientes;
    public Barber(Bshop shop,int num,TextArea textArea,JProgressBar progressBar,JLabel etiqueta_1,JLabel lblClientes_1)
    {
        this.shop = shop;
        nume=num;
        
        texto=textArea;
        barra=progressBar;
        
        barra.setMinimum(0);
        barra.setMaximum(15);
        barra.setValue(15);
        etiqueta=etiqueta_1;
        clientes=lblClientes_1;
    }
    public void run()
    {
        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }
        texto.append("Barebero "+nume+" comenzara.."+"\n");
        while(true)
        {
            shop.cutHair(nume, texto, barra, etiqueta, clientes);
        }
    }
}

class Customer implements Runnable
{
    String name;
 
    Bshop shop;
    TextArea texto;
    public Customer(Bshop shop,TextArea area)
    {
        this.shop = shop;
        texto=area;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 

    public void run()
    {
        goForHairCut();
    }
    public synchronized void goForHairCut()
    {
        shop.add(this,texto);
    }
}

class CustomerGenerator implements Runnable
{
    Bshop shop;
    TextArea texto;
    public CustomerGenerator(Bshop shop,TextArea area)
    {
        this.shop = shop;
        texto=area;

    }
 
    public void run()
    {

    	while(true)
        {

    		Customer customer = new Customer(shop,texto);
            Thread thcustomer = new Thread(customer);
            customer.setName("Cliente Thread "+thcustomer.getId());
            thcustomer.start();
 
            try
            {
                TimeUnit.SECONDS.sleep((long)(Math.random()*4));
            }
            catch(InterruptedException iex)
            {
                iex.printStackTrace();
            }
        }
    }
 
}
 
class Bshop
{
    int sillas;
    List<Customer> listCustomer;
    int n = 0;
    int cont=0;
    public Bshop()
    {
        sillas = 3;
        listCustomer = new LinkedList<Customer>();
    }
 
    public void cutHair(int val,TextArea texto, JProgressBar barra,JLabel etiqueta,JLabel clientes)
    {
        Customer customer;
        
        texto.append("Barebero "+val+ " esperando para cortar."+"\n");
        synchronized (listCustomer)
        {
 
            while(listCustomer.size()==0)
            {
            	
            	long inicio = System.currentTimeMillis();
            	barra.setValue(barra.getValue()+1);
            	texto.append("Barbero "+val+ " esta esperando al cliente."+"\n");
                try
                {
                    listCustomer.wait();
                }
                catch(InterruptedException iex)
                {
                    iex.printStackTrace();
                }
				long fin = System.currentTimeMillis();
				int tiempo = (int) ((fin - inicio)/1000);
				n=n+tiempo;
				etiqueta.setText("Descanso: "+n+" segundos");
				
				
            }
            texto.append("Barbero "+val+" encontro un cliente en la cola."+"\n");
            customer = (Customer)((LinkedList<?>)listCustomer).poll();
        }
        long duration=0;
        try
        {    
        	 texto.append("Corte de pelo a la cliente : "+customer.getName()+"\n");
        	 barra.setValue(barra.getValue()-1);
        	 duration = (long)(Math.random()*4);
            TimeUnit.SECONDS.sleep(duration);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }
        cont=cont+1;
        clientes.setText("Clientes: "+cont);
        texto.append("Corte de pelo completado a la cliente : "+customer.getName() + " en "+duration+ " segundos."+"\n");
    }
 
    public void add(Customer customer, TextArea texto2)
    {
        texto2.append("cliente : "+customer.getName()+ " entro a la tienda"+"\n");
 
        synchronized (listCustomer)
        {
            if(listCustomer.size() == sillas)
            {
            	texto2.append("no hay silla disponible para el cliene  "+customer.getName()+"\n");
            	texto2.append("cliente "+customer.getName()+"Salio..."+"\n");
                return ;
            }
 
            ((LinkedList<Customer>)listCustomer).offer(customer);
            texto2.append("Cliente : "+customer.getName()+ " tiene la silla."+"\n");
             
            if(listCustomer.size()==1)
                listCustomer.notify();
        }
    }
}

