package final_2;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.ScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;
import java.awt.TextArea;
import java.awt.Label;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;


public class interfac {
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	
	
	int num=0;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfac window = new interfac();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public interfac() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 574, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(28, 10, 209, 222);
		frame.getContentPane().add(textArea);
		textArea.setEditable(false);
			
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(28, 247, 146, 14);
		frame.getContentPane().add(progressBar);
		
		Label label1 = new Label("time desp");
		label1.setBounds(0, 360, 122, 44);
		frame.getContentPane().add(label1);
		
		Label label2 = new Label("time desp");
		label2.setBounds(147, 360, 107, 44);
		frame.getContentPane().add(label2);
		
		Label label3 = new Label("time desp");
		label3.setBounds(262, 371, 84, 32);
		frame.getContentPane().add(label3);
		
		BlockingQueue sharedQueue = new LinkedBlockingQueue();
		
		JButton productor = new JButton("Stop");
		productor.setBounds(28, 329, 89, 23);
		frame.getContentPane().add(productor);

		
		
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Thread prodThread = new Thread(new Producer(sharedQueue,20,progressBar,textArea,label1));
				prodThread.start();
				productor.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						prodThread.stop();
						int n=(int) (Math.random() * 10);
						label1.setText("despedicio: "+"\n"+n);
					}
				});
				
			}
		});
		btnNewButton.setBounds(28, 295, 89, 23);
		frame.getContentPane().add(btnNewButton);
		

		JLabel lblNewLabel = new JLabel("Productor");
		lblNewLabel.setBounds(49, 273, 59, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("consumidor1");
		lblNewLabel_1.setBounds(147, 273, 90, 14);
		frame.getContentPane().add(lblNewLabel_1);
	
		
		JButton btnNewButton_2 = new JButton("Stop");
		btnNewButton_2.setBounds(147, 329, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		JButton btnNewButton_1 = new JButton("Start");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread consThread = new Thread(new Consumer(sharedQueue,1,textArea,label2));
				consThread.start();
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						consThread.stop();
						int n=(int) (Math.random() * 10);
						label2.setText("despedicio: "+"\n"+n);
					}
				});
			}	
		});
		btnNewButton_1.setBounds(147, 295, 89, 23);
		frame.getContentPane().add(btnNewButton_1);

		
		JLabel lblNewLabel_2 = new JLabel("consumidor 2");
		lblNewLabel_2.setBounds(262, 273, 84, 14);
		frame.getContentPane().add(lblNewLabel_2);
		

		JButton btnNewButton_4 = new JButton("Stop");
		btnNewButton_4.setBounds(257, 329, 89, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_3 = new JButton("Start");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread consThread2 = new Thread(new Consumer(sharedQueue,2,textArea,label3));
				consThread2.start();
				btnNewButton_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						consThread2.stop();
						int n=(int) (Math.random() * 10);
						label3.setText("despedicio: "+"\n"+n);
					}
				});
			}
		});
		btnNewButton_3.setBounds(257, 295, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		
		
		
		
		
		
		

		
		
		
		
		
 
		
	}
}
