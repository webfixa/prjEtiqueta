package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import modelo.Cliente;
import controle.CtrlMalaDireta;

public class TelaSalvarLista {

	private JFrame frame;
	private JTextField textField;
	private ArrayList<Cliente> listaClientes;
	
	/**
	 * Launch the application.
	 */
	
			public void run(ArrayList<Cliente> listaClientes) {
				try {
					TelaSalvarLista window = new TelaSalvarLista(listaClientes);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
	

	/**
	 * Create the application.
	 */
	public TelaSalvarLista() {
		initialize();
	}
	
	public TelaSalvarLista(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 165);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblInformeONome = new JLabel("Informe o nome da lista:");
		lblInformeONome.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformeONome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInformeONome.setBounds(10, 21, 414, 14);
		frame.getContentPane().add(lblInformeONome);
		frame.setLocationRelativeTo(null);
		textField = new JTextField();
		textField.setBounds(10, 46, 414, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				CtrlMalaDireta malaDireta = new CtrlMalaDireta();
				malaDireta.salvarLista(textField.getText(), listaClientes);
				frame.dispose();
			}
		});
		btnOk.setBounds(109, 93, 89, 23);
		frame.getContentPane().add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					frame.dispose();
			}
		});
		btnCancelar.setBounds(231, 93, 89, 23);
		frame.getContentPane().add(btnCancelar);
	}
}
