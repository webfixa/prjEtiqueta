package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaEtiquetaManual extends JFrame {

	private JPanel contentPane;
	private JTextField tfTexto;
	private JLabel lblQuantidadeDeEtiquetas;
	private JTextField tfQnt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEtiquetaManual frame = new TelaEtiquetaManual();
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
	public TelaEtiquetaManual() {
		setTitle("Etiqueta Manual");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(800, 265);
		this.setResizable(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDigiteOTexto = new JLabel("Digite o texto a ser impresso na etiqueta:");
		lblDigiteOTexto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDigiteOTexto.setBounds(76, 32, 243, 14);
		contentPane.add(lblDigiteOTexto);
		
		tfTexto = new JTextField();
		tfTexto.setBounds(76, 57, 666, 20);
		contentPane.add(tfTexto);
		tfTexto.setColumns(60);
		
		lblQuantidadeDeEtiquetas = new JLabel("Quantidade de Etiquetas:");
		lblQuantidadeDeEtiquetas.setBounds(76, 106, 169, 14);
		contentPane.add(lblQuantidadeDeEtiquetas);
		
		tfQnt = new JTextField();
		tfQnt.setBounds(240, 103, 54, 20);
		contentPane.add(tfQnt);
		tfQnt.setColumns(10);
		
		JButton btnLimparCampos = new JButton("<html><center>Limpar<br /> Campos</center></html>");
		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfTexto.setText("");
				tfQnt.setText("");
			}
		});
		btnLimparCampos.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLimparCampos.setBounds(76, 170, 119, 46);
		contentPane.add(btnLimparCampos);
		
		JButton btnSalvarEtiqueta = new JButton("<html><center>Salvar<br /> Etiqueta</center></html>");
		btnSalvarEtiqueta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaSalvarEtiquetaManual tela = new TelaSalvarEtiquetaManual();
				tela.run(tfTexto.getText(), tfQnt.getText());
			}
		});
		btnSalvarEtiqueta.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalvarEtiqueta.setBounds(200, 170, 119, 46);
		contentPane.add(btnSalvarEtiqueta);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSair.setBounds(325, 170, 80, 46);
		contentPane.add(btnSair);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
}
