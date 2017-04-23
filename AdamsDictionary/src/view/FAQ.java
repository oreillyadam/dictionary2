package view;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

public class FAQ extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FAQ frame = new FAQ();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FAQ() {
		setTitle("FAQ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextArea FAQTxt = new JTextArea();
		FAQTxt.setEditable(false);
		FAQTxt.append(ReadFile());
		FAQTxt.setBounds(10, 11, 414, 239);
		contentPane.add(FAQTxt);
		

		
		/**
		LineNumberReader lnr = null;
		  FileReader fr = null;
		  
		  try{
		  fr = new FileReader("./Files/FAQ.txt");
		  lnr =new LineNumberReader(fr);
		  
		  String line;
		  
		  while((line = lnr.readLine()) != null)
		  {
		  int lr = lnr.getLineNumber();
		  System.out.println();
		  lnr.close();
		  }
		  }
		/* finally
		  {
		  if{lnr != null)
		  {
		  
		  }*/
		   
		  
		        }
	
	public static String ReadFile() {
		String sb = "";
		try {

			BufferedReader br = new BufferedReader(new FileReader(

			"./Files/FAQ.txt"));

			try {
				String line = br.readLine();

				while (line != null) {
					sb += line;
					line = br.readLine();
				}
			} finally {
				br.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return sb;
	}

}
