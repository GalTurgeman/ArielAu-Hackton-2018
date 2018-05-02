package TimeTableManager;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import java.awt.TextField;
import java.awt.Label;

public class GUI {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
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
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 717, 456);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnImportFile = new JButton("Import File");
		btnImportFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc;
				jfc = new JFileChooser();     
				File f = new File(System.getProperty("user.dir"));
				jfc.setCurrentDirectory(f);
				jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				jfc.setFileFilter(new FileNameExtensionFilter("xlsx Files only", "xlsx","XLSX"));
				jfc.showOpenDialog(btnImportFile);
			}
		});
		btnImportFile.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnImportFile.setBounds(6, 6, 117, 29);
		frame.getContentPane().add(btnImportFile);
		
		JButton btnAddRestrication = new JButton("Add restrication");
		btnAddRestrication.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddRestrication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddRestrication.setBounds(6, 108, 117, 35);
		frame.getContentPane().add(btnAddRestrication);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(6, 155, 117, 29);
		frame.getContentPane().add(btnRefresh);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnClear.setBounds(6, 196, 117, 29);
		frame.getContentPane().add(btnClear);
		//
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(6, 401, 117, 29);
		frame.getContentPane().add(btnExit);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(124, 0, 2, 430);
		frame.getContentPane().add(panel);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TableExample();
			}
		});
		btnPrint.setBounds(6, 77, 117, 29);
		frame.getContentPane().add(btnPrint);
		
		

	}
}
