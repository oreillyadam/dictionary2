package view;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.filechooser.FileNameExtensionFilter;

import models.Entry;
import controllers.MaxHeap;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;

public class Dictionary {

	private JFrame frmAdamsDictionary;
	private JTextField engTxt;
	private JTextField spanTxt;
	private JTextField searchTxt;

	private JButton btnSearch;
	private JTextArea resultsArea;

	private MaxHeap<?> maxHeap = new MaxHeap<Object>();

	private final String userDirLocation = System.getProperty("user.dir");
	private final File userDir = new File(userDirLocation);
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmImporDictionary;
	private JMenu mnHelp;
	private JMenuItem mntmFaq;
	private JMenuItem mntmReadMe;
	private JMenuItem mntmExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dictionary window = new Dictionary();
					window.frmAdamsDictionary.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Dictionary() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdamsDictionary = new JFrame();
		frmAdamsDictionary.setTitle("Adam's Dictionary");
		frmAdamsDictionary.setBounds(100, 100, 821, 375);
		frmAdamsDictionary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdamsDictionary.getContentPane().setLayout(null);

		resultsArea = new JTextArea();
		resultsArea.setEditable(false);
		resultsArea.setToolTipText("This is the results area ");
		resultsArea.setBounds(211, 68, 584, 220);
		frmAdamsDictionary.getContentPane().add(resultsArea);

		engTxt = new JTextField();
		engTxt.setBackground(Color.WHITE);
		engTxt.setBounds(10, 173, 191, 46);
		engTxt.setToolTipText("English text here");
		frmAdamsDictionary.getContentPane().add(engTxt);
		engTxt.setColumns(10);

		spanTxt = new JTextField();
		spanTxt.setBackground(Color.WHITE);
		spanTxt.setColumns(10);
		spanTxt.setToolTipText("Spanish text here");
		spanTxt.setBounds(10, 116, 191, 46);
		frmAdamsDictionary.getContentPane().add(spanTxt);

		searchTxt = new JTextField();
		searchTxt.setColumns(10);
		searchTxt.setToolTipText("Spanish text here");
		searchTxt.setBounds(409, 11, 386, 46);
		frmAdamsDictionary.getContentPane().add(searchTxt);

		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String spanishWord = searchTxt.getText();
				String englishWord = maxHeap.getEntry(spanishWord);
				if (englishWord != null) {
					resultsArea.setText("Spanish word: " + spanishWord
							+ "\nEnglish translation: " + englishWord
							+ "\nnumber of steps for the search: "
							+ maxHeap.getNumberOfStepsInSearch());
					maxHeap.setNumberOfStepsInSearch(0);
				} else {

					resultsArea.setText(spanishWord
							+ "\" is not in the dictionary");

				}
				clearTextFields();
			}
		});
		btnSearch.setBounds(211, 11, 191, 46);
		frmAdamsDictionary.getContentPane().add(btnSearch);

		JButton btnAdd = new JButton("Add Translation");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (spanTxt.getText() != null && engTxt.getText() != null)
					maxHeap.add(new Entry<Object>(spanTxt.getText(), engTxt
							.getText()));
				resultsArea.setText("spanish word \"" + spanTxt.getText()
						+ "\" has been added to the dictionary");
				clearTextFields();
				maxHeap.printEntries();
			}
		});
		btnAdd.setBounds(10, 230, 191, 46);
		frmAdamsDictionary.getContentPane().add(btnAdd);

		menuBar = new JMenuBar();
		frmAdamsDictionary.setJMenuBar(menuBar);

		mnFile = new JMenu("File");
		menuBar.add(mnFile);

		mntmImporDictionary = new JMenuItem("Import Dictionary");
		mntmImporDictionary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser(userDir);
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"dat files", "dat");
				chooser.setFileFilter(filter);
				int returnVal = chooser.showOpenDialog(frmAdamsDictionary);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					String path = chooser.getSelectedFile().getAbsolutePath();
					maxHeap.loadDictionary(path);
					maxHeap.printEntries();
				}
				clearTextFields();
			}
		});

		mnFile.add(mntmImporDictionary);

		mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdamsDictionary
						.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		mnFile.add(mntmExit);

		mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		mntmFaq = new JMenuItem("FAQ");
		mntmFaq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FAQ faq = new FAQ();
				faq.setVisible(true);
			}
		});
		mnHelp.add(mntmFaq);

		mntmReadMe = new JMenuItem("Read Me");
		mntmReadMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReadMe readMe = new ReadMe();
				readMe.setVisible(true);

			}
		});
		mnHelp.add(mntmReadMe);

		// frmAdamsDictionary.getRootPane().setDefaultButton(btnSearch);
		// frmAdamsDictionary.getRootPane().setDefaultButton(btnAdd);

	}

	private void clearTextFields() {
		spanTxt.setText("");
		engTxt.setText("");
		searchTxt.setText("");
		searchTxt.setText("");
	}
}
