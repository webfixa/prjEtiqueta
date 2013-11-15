package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class Sobre extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;

	/**
	 * This is the default constructor
	 * @throws IOException 
	 */
	public Sobre() throws IOException {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize()throws IOException {
		this.setSize(400, 300);
		this.setContentPane(getJContentPane());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Sobre");
		this.setVisible(true);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JImagePanel getJContentPane() throws IOException {
		if (jContentPane == null) {
			jContentPane = new JImagePanel(System.getProperty("user.dir") + "/arquivos/SOBRE.jpg");
			jContentPane.setLayout(null);
			
		}
		return (JImagePanel) jContentPane;
	}

}
