package view;

import view.JImagePanel;
import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import modelo.DaoLogin;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrograma extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JMenuBar jBarraMenu = null;
	private JMenu jMenuArquivo = null;
	private JMenuItem jMenuItemEtiqueta = null;
	private JMenu jMenuUsuarios = null;
	private JMenuItem jMenuItemIncluir = null;
	private JMenuItem jMenuItemAlterar = null;
	private JMenu jMenuAjuda = null;
	private JMenuItem jMenuItemSobre = null;
	private JMenuItem jMenuItemNota = null;  //  @jve:decl-index=0:
	private JMenuItem jMenuItemOrcamento;
	private JMenu JMenuMalaDireta;
	private JMenuItem JMenuItemNomeCodigo;
	private JMenuItem JMenuItemConsultaLista;
	private JMenuItem JMenuItemImprimiLista;
	/**
	 * This is the default constructor
	 * @throws IOException 
	 */
	public TelaPrograma() throws IOException {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		this.setSize(800, 570);
		this.setJMenuBar(getJBarraMenu());
		this.setContentPane(getJContentPane());
		this.setTitle("Programa Principal");
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 * @throws IOException 
	 */
	private JImagePanel getJContentPane() throws IOException {
		if (jContentPane == null) {
			jContentPane = new JImagePanel(System.getProperty("user.dir") + "/arquivos/FUNDO.jpg");
			jContentPane.setLayout(null);
			
		}
		return (JImagePanel) jContentPane;
	}

	/**
	 * This method initializes jBarraMenu	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getJBarraMenu() {
		if (jBarraMenu == null) {
			jBarraMenu = new JMenuBar();
			jBarraMenu.add(getJMenuArquivo());
			jBarraMenu.add(getJMenuUsuarios());
			jBarraMenu.add(getJMenuMalaDireta());
			jBarraMenu.add(getJMenuAjuda());
		}
		return jBarraMenu;
	}

	/**
	 * This method initializes jMenuArquivo	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenuArquivo() {
		if (jMenuArquivo == null) {
			jMenuArquivo = new JMenu();
			jMenuArquivo.setText("Etiqueta");
			jMenuArquivo.add(getJMenuItemEtiqueta());
			jMenuArquivo.add(getJMenuItemNota());
			jMenuArquivo.add(getJMenuItemOrcamento());
		}
		return jMenuArquivo;
	}

	/**
	 * This method initializes jMenuItemEtiqueta	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemEtiqueta() {
		if (jMenuItemEtiqueta == null) {
			jMenuItemEtiqueta = new JMenuItem("Por Item");
			jMenuItemEtiqueta.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Etiqueta etiqueta = new Etiqueta();
				}
			});
		}
		return jMenuItemEtiqueta;
	}
	
	private JMenuItem getJMenuItemNota() {
		if (jMenuItemNota == null) {
			jMenuItemNota = new JMenuItem("Nota Fiscal");
			jMenuItemNota.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					NotaFiscal nota = new NotaFiscal();
				}
			});
		}
		return jMenuItemNota;
	}
	
	private JMenuItem getJMenuItemOrcamento() {
		if (jMenuItemOrcamento == null) {
			jMenuItemOrcamento = new JMenuItem("Orçamento");
			jMenuItemOrcamento.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					TelaOrcamento nota = new TelaOrcamento();
				}
			});
		}
		return jMenuItemOrcamento;
	}
	
	

	/**
	 * This method initializes jMenuUsuÃ¡rios	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenuUsuarios() {
		if (jMenuUsuarios == null) {
			jMenuUsuarios = new JMenu();
			jMenuUsuarios.setText("Usuários");
//			if(DaoLogin.USER.login.equals("admin")){
//				jMenuUsuarios.add(getJMenuItemIncluir());}
			jMenuUsuarios.add(getJMenuItemAlterar());
		}
		return jMenuUsuarios;
	}

	/**
	 * This method initializes jMenuItemIncluir	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemIncluir() {
		if (jMenuItemIncluir == null) {
			jMenuItemIncluir = new JMenuItem("Incluir");
			jMenuItemIncluir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						IncluirUser etiqueta = new IncluirUser();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		return jMenuItemIncluir;
	}

	/**
	 * This method initializes jMenuItemAlterar	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemAlterar() {
		if (jMenuItemAlterar == null) {
			jMenuItemAlterar = new JMenuItem("Alterar");
			jMenuItemAlterar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						AlterarUser etiqueta = new AlterarUser();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		return jMenuItemAlterar;
	}

	/**
	 * This method initializes jMenuAjuda	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenuAjuda() {
		if (jMenuAjuda == null) {
			jMenuAjuda = new JMenu("Ajuda");
			jMenuAjuda.add(getJMenuItemSobre());
		}
		return jMenuAjuda;
	}

	/**
	 * This method initializes jMenuItemSobre	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemSobre() {
		if (jMenuItemSobre == null) {
			jMenuItemSobre = new JMenuItem("Sobre");
			jMenuItemSobre.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						Sobre sobre = new Sobre();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		return jMenuItemSobre;
	}


	private JMenu getJMenuMalaDireta() {
		if (JMenuMalaDireta == null) {
			JMenuMalaDireta = new JMenu("Mala Direta");
			JMenuMalaDireta.add(getJMenuItemNomeCodigo());
			JMenuMalaDireta.add(getJMenuItemConsultaLista());
		}
		return JMenuMalaDireta;
	}
	private JMenuItem getJMenuItemNomeCodigo() {
		if (JMenuItemNomeCodigo == null) {
			JMenuItemNomeCodigo = new JMenuItem("Consulta por Nome ou Código");
			JMenuItemNomeCodigo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TelaMalaDiretaNomeCodigo mdNomeCodigo = new TelaMalaDiretaNomeCodigo();
				}
			});
		}
		return JMenuItemNomeCodigo;
	}
	private JMenuItem getJMenuItemConsultaLista() {
		if (JMenuItemConsultaLista == null) {
			JMenuItemConsultaLista = new JMenuItem("Consulta Lista");
			JMenuItemConsultaLista.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TelaMalaDiretaEscolherLista escolherLista = new TelaMalaDiretaEscolherLista();
				}
			});
		}
		return JMenuItemConsultaLista;
	}
	
}
