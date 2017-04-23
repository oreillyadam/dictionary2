package view;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

public class ReadMe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReadMe frame = new ReadMe();
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
	public ReadMe() {
		setTitle("ReadMe");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.append(ReadFile());
		textArea.setEditable(false);
		textArea.setBounds(10, 11, 414, 239);
		contentPane.add(textArea);
	}

	public static String ReadFile() {
		String sb = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(
					"./Files/ReadMe.txt"));

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
