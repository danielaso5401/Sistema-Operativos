package barber_shop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.TextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import java.awt.Color;
import java.awt.Label;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class interface2 {

	private JFrame frame;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interface2 window = new interface2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public interface2() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 708, 407);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		TextArea textArea = new TextArea();
		textArea.setBackground(Color.DARK_GRAY);
		textArea.setBounds(277, 21, 393, 220);
		frame.getContentPane().add(textArea);
		
		JLabel lblNewLabel = new JLabel("Barbero 1");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(20, 21, 63, 24);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblBarbero = new JLabel("Barbero 2");
		lblBarbero.setForeground(Color.WHITE);
		lblBarbero.setBounds(20, 125, 63, 24);
		frame.getContentPane().add(lblBarbero);
		
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setForeground(Color.WHITE);
		lblClientes.setBounds(20, 230, 63, 24);
		frame.getContentPane().add(lblClientes);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(Color.GREEN);
		progressBar.setBounds(104, 55, 146, 14);
		frame.getContentPane().add(progressBar);
		
		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setForeground(Color.GREEN);
		progressBar_1.setBounds(104, 160, 146, 14);
		frame.getContentPane().add(progressBar_1);
		
		JLabel lblNewLabel_1 = new JLabel("descanso: 0");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(140, 75, 131, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("descanso: 0");
		label.setForeground(Color.WHITE);
		label.setBounds(140, 185, 140, 14);
		frame.getContentPane().add(label);
		
		JLabel lblClientes_2 = new JLabel("clientes: ");
		lblClientes_2.setForeground(Color.WHITE);
		lblClientes_2.setBounds(140, 206, 83, 14);
		frame.getContentPane().add(lblClientes_2);
		
		JLabel lblClientes_1 = new JLabel("clientes: ");
		lblClientes_1.setForeground(Color.WHITE);
		lblClientes_1.setBounds(140, 100, 83, 14);
		frame.getContentPane().add(lblClientes_1);
		
		Bshop shop = new Bshop();
		
		Barber barber = new Barber(shop,1,textArea,progressBar,lblNewLabel_1,lblClientes_1);
	    Barber barber2 = new Barber(shop,2,textArea,progressBar_1,label,lblClientes_2);
	    
	    CustomerGenerator cg = new CustomerGenerator(shop,textArea);
	    Thread thbarber = new Thread(barber);
	    Thread thbarber2 = new Thread(barber2);
	    Thread thcg = new Thread(cg);
	    
		JButton btnNewButton = new JButton("start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thbarber.start();
			}
		});
		btnNewButton.setBounds(83, 21, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("stop");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thbarber.stop();
			}
		});
		btnNewButton_1.setBounds(182, 21, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnStart = new JButton("start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thbarber2.start();
			}
		});
		btnStart.setBounds(83, 126, 89, 23);
		frame.getContentPane().add(btnStart);
		
		JButton btnStart_1 = new JButton("start");
		btnStart_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thcg.start();
			}
		});
		btnStart_1.setBounds(83, 231, 89, 23);
		frame.getContentPane().add(btnStart_1);
		
		JButton btnStop = new JButton("stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thbarber2.stop();
			}
		});
		btnStop.setBounds(182, 127, 89, 23);
		frame.getContentPane().add(btnStop);
		
		JButton btnStop_1 = new JButton("stop");
		btnStop_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thcg.stop();	
			}
		});
		
		btnStop_1.setBounds(182, 231, 89, 23);
		frame.getContentPane().add(btnStop_1);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("energia");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(48, 56, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel label_1 = new JLabel("energia");
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(48, 160, 46, 14);
		frame.getContentPane().add(label_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("F:\\barber_shop\\src\\barber_shop\\Linux-icon.png"));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setBounds(619, 261, 63, 79);
		frame.getContentPane().add(lblNewLabel_3);
		
	
		

	}
}
