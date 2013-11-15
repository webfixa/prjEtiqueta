package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import modelo.DaoLogin;

import controle.CtrlLogin;

public class AlterarUser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLogin = null;
	private JLabel jSenha = null;
	private JPasswordField jTfLogin = null;
	private JPasswordField jPfSenha = null;
	private JButton jBtIniciar = null;
	private JButton jBtSair = null;

	/**
	 * This is the default constructor
	 * @throws IOException 
	 */
	public AlterarUser() throws IOException {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() throws IOException {
		this.setSize(400, 300);
		this.setContentPane(getJContentPane());
		this.setTitle("Alterar Usuário");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JImagePanel getJContentPane() throws IOException {
		if (jContentPane == null) {
			jSenha = new JLabel();
			jSenha.setBounds(new Rectangle(181, 76, 173, 22));
			jSenha.setFont(new Font("Dialog", Font.BOLD, 18));
			jSenha.setForeground(Color.white);
			jSenha.setText("Digite Novamente:");
			jLogin = new JLabel();
			jLogin.setBounds(new Rectangle(55, 76, 114, 22));
			jLogin.setFont(new Font("Dialog", Font.BOLD, 18));
			jLogin.setForeground(Color.white);
			jLogin.setText("Nova Senha:");
			jContentPane = new JImagePanel(System.getProperty("user.dir") + "/arquivos/LOGIN.jpg");
			jContentPane.setLayout(null);
			jContentPane.add(jLogin, null);
			jContentPane.add(jSenha, null);
			jContentPane.add(getJTfLogin(), null);
			jContentPane.add(getJPfSenha(), null);
			jContentPane.add(getJBtIniciar(), null);
			jContentPane.add(getJBtSair(), null);
		}
		return (JImagePanel) jContentPane;
	}

	private JPasswordField getJTfLogin() {
		if (jTfLogin == null) {
			jTfLogin = new JPasswordField();
			jTfLogin.setBounds(new Rectangle(53, 102, 115, 20));
		}
		return jTfLogin;
	}

	/**
	 * This method initializes jPfSenha	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getJPfSenha() {
		if (jPfSenha == null) {
			jPfSenha = new JPasswordField();
			jPfSenha.setBounds(new Rectangle(204, 102, 115, 20));
			jPfSenha.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER)
					{
						jBtIniciar.doClick();
					}
				}
			});
		}
		return jPfSenha;
	}

	/**
	 * This method initializes jBtIniciar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJBtIniciar() {
		if (jBtIniciar == null) {
			jBtIniciar = new JButton();
			jBtIniciar.setBounds(new Rectangle(106, 159, 77, 22));
			jBtIniciar.setText("Alterar");
			jBtIniciar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						if(jTfLogin.getText().equals(jPfSenha.getText())){
						if(CtrlLogin.alterarLogin(DaoLogin.USER.getLogin(), jPfSenha.getText()))
						{
							JOptionPane.showMessageDialog(null, "Usuário Alterado com Sucesso!");
						}else JOptionPane.showMessageDialog(null, "Problemas na Alteração do Usuário!");}
						else{JOptionPane.showMessageDialog(null, "Senhas não conferem, digite novamente!");}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			jBtIniciar.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER)
					{
						jBtIniciar.doClick();
					}
				}
			});
		}
		return jBtIniciar;
	}

	/**
	 * This method initializes jBtSair	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJBtSair() {
		if (jBtSair == null) {
			jBtSair = new JButton();
			jBtSair.setBounds(new Rectangle(195, 159, 77, 22));
			jBtSair.setText("Sair");
			jBtSair.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
				}
			});
		}
		return jBtSair;
	}
}
