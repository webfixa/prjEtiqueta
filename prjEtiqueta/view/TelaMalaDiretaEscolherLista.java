package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import modelo.Lista;
import controle.CtrlMalaDireta;

public class TelaMalaDiretaEscolherLista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTextField jTfFilial = null;
	private JTextField jTfItem = null;
	private JButton jBtIncluir = null;
	private JButton jBtExcluir = null;
	private JButton jBtLimpar = null;
	private JButton jBtLimparLista = null;
	private JButton jBtExibirListas = null;
	private JButton jBtSair = null;
	private JLabel jLbEtiqImpressao = null;
	private JScrollPane jScrollPane = null;
	private JTable jTbEtiquetas = null;
	private int seq = 1;
	private ArrayList<Lista> listas = new ArrayList<Lista>();
	DefaultTableModel dtmc = new DefaultTableModel(); // criar o modelo da
														// tabela
	private JTextField JTfData;

	/**
	 * This is the default constructor
	 * @throws ParseException 
	 */
	public TelaMalaDiretaEscolherLista() throws ParseException {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 * @throws ParseException 
	 */
	private void initialize() throws ParseException {
		this.setSize(800, 493);
		this.setResizable(true);
		this.setContentPane(getJContentPane());
		this.setTitle("Emiss„o de Etiquetas - Mala Direta Escolher Lista");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 * @throws ParseException 
	 */
	private JPanel getJContentPane() throws ParseException {
		if (jContentPane == null) {
			jLbEtiqImpressao = new JLabel();
			jLbEtiqImpressao.setBounds(new Rectangle(313, 89, 187, 16));
			jLbEtiqImpressao.setFont(new Font("Dialog", Font.BOLD, 12));
			jLbEtiqImpressao.setForeground(SystemColor.activeCaption);
			jLbEtiqImpressao.setText("Etiquetas para Impress\u00E3o");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);

			jContentPane.add(getJBtIncluir(), null);
			jContentPane.add(getJBtExcluir(), null);
			jContentPane.add(getJBtLimpar(), null);
			jContentPane.add(getJBtLimparLista(), null);
			jContentPane.add(getJBtExibirListas(), null);
			jContentPane.add(getJBtSair(), null);
			jContentPane.add(jLbEtiqImpressao, null);
			jContentPane.add(getJScrollPane(), null);

			JLabel lblData = new JLabel("Data: <F3>");
			lblData.setFont(new Font("Arial", Font.BOLD, 11));
			lblData.setBounds(32, 20, 86, 15);
			jContentPane.add(lblData);
			javax.swing.text.MaskFormatter data;
			data = new javax.swing.text.MaskFormatter("##/##/####");
			
			JTfData = new JFormattedTextField(data);
			JTfData.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						CtrlMalaDireta malaDireta = new CtrlMalaDireta();

						for (Iterator<Lista> it = malaDireta.pegaListaData(
								JTfData.getText()).iterator(); it.hasNext();) {
							Lista lista = it.next();
							listas.add(lista);
						}
						JTfData.setText("");
						while (dtmc.getRowCount() > 0) {
							dtmc.removeRow(0);
						}
						for (Lista lista : listas) {
							String[] linha = new String[2];// crio uma nova
															// linha para a
															// tabela com 5
															// elementos // TODO
															// Auto-generated
															// Event stub
															// actionPerformed()
							linha[0] = lista.getData();
							linha[1] = lista.getNome();

							dtmc.addRow(linha);// Adiciono a linha que eu criei
												// na tabela
							jTbEtiquetas.setModel(dtmc);
						}

					}
				}
			});
			JTfData.setBounds(90, 17, 124, 19);
			jContentPane.add(JTfData);
			JTfData.setColumns(10);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jTfFilial
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTfCodigo() {
		if (jTfFilial == null) {
			jTfFilial = new JTextField();
			jTfFilial.setBounds(new Rectangle(143, 24, 76, 20));
			jTfFilial.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_F2) {
						jTfFilial.requestFocus();
					}
					if (e.getKeyCode() == KeyEvent.VK_F3) {
						jTfItem.requestFocus();
					}

					if (e.getKeyCode() == KeyEvent.VK_F7) {
						jBtIncluir.doClick();
					}
					if (e.getKeyCode() == KeyEvent.VK_F8) {
						jBtExcluir.doClick();
					}
					if (e.getKeyCode() == KeyEvent.VK_F9) {
						jBtLimpar.doClick();
					}
					if (e.getKeyCode() == KeyEvent.VK_F10) {
						jBtLimparLista.doClick();
					}
				}

			});
		}
		return jTfFilial;
	}

	/**
	 * This method initializes jBtIncluir
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJBtIncluir() {
		if (jBtIncluir == null) {
			jBtIncluir = new JButton();
			jBtIncluir.setText("Consultar <F7>");
			jBtIncluir.setSize(new Dimension(124, 36));
			jBtIncluir.setLocation(new Point(26, 42));
			jBtIncluir.setFont(new Font("arial", Font.BOLD, 11));
			jBtIncluir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					CtrlMalaDireta malaDireta = new CtrlMalaDireta();

					for (Iterator<Lista> it = malaDireta.pegaListaData(
							JTfData.getText()).iterator(); it.hasNext();) {
						Lista lista = it.next();
						listas.add(lista);
					}
					try {
						while (dtmc.getRowCount() > 0) {
							dtmc.removeRow(0);
						}
						for (Lista lista : listas) {
							String[] linha = new String[2];// crio uma nova
															// linha para a
															// tabela com 5
															// elementos // TODO
															// Auto-generated
															// Event stub
															// actionPerformed()
							linha[0] = lista.getCodigo();
							linha[1] = lista.getNome();

							dtmc.addRow(linha);// Adiciono a linha que eu criei
												// na tabela
							jTbEtiquetas.setModel(dtmc);
						}

					} catch (NullPointerException e1) {
						JOptionPane.showMessageDialog(null,
								"Preencher todos os campos!");
					}
				}
			});
		}
		return jBtIncluir;
	}

	/**
	 * This method initializes jBtExcluir
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJBtExcluir() {
		if (jBtExcluir == null) {
			jBtExcluir = new JButton();
			jBtExcluir.setText("Excluir <F8>");
			jBtExcluir.setSize(new Dimension(113, 36));
			jBtExcluir.setLocation(new Point(149, 42));
			jBtExcluir.setFont(new Font("arial", Font.BOLD, 11));
			jBtExcluir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					listas.remove(jTbEtiquetas.getSelectedRow());
					dtmc.removeRow(jTbEtiquetas.getSelectedRow());
					jTbEtiquetas.setModel(dtmc);
					
				}
			});
		}
		return jBtExcluir;
	}

	/**
	 * This method initializes jBtLimpar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJBtLimpar() {
		if (jBtLimpar == null) {
			jBtLimpar = new JButton();
			jBtLimpar
					.setText("<html><center>Limpar<br>Campos - F9</center></html>");
			jBtLimpar.setSize(new Dimension(112, 36));
			jBtLimpar.setFont(new Font("Arial", Font.BOLD, 11));
			jBtLimpar.setLocation(new Point(263, 42));
			jBtLimpar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {

					JTfData.setText("");

				}
			});
		}
		return jBtLimpar;
	}

	/**
	 * This method initializes jBtLimparLista
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJBtLimparLista() {
		if (jBtLimparLista == null) {
			jBtLimparLista = new JButton();
			jBtLimparLista
					.setText("<html><center>Limpar<br>Lista - F10</center></html>");
			jBtLimparLista.setBounds(new Rectangle(376, 42, 112, 36));
			jBtLimparLista.setFont(new Font("arial", Font.BOLD, 11));
			jBtLimparLista
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							while (dtmc.getRowCount() > 0) {
								dtmc.removeRow(0);
							}
							listas.removeAll(listas);
							jTbEtiquetas.setModel(dtmc);
							seq = 1;
						}
					});
		}
		return jBtLimparLista;
	}

	/**
	 * This method initializes jBtOr√ßamento
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJBtExibirListas() {
		if (jBtExibirListas == null) {
			jBtExibirListas = new JButton();
			jBtExibirListas.setText("Exibir Listas");
			jBtExibirListas.setBounds(new Rectangle(579, 42, 105, 36));
			jBtExibirListas.setFont(new Font("arial", Font.BOLD, 11));
			jBtExibirListas
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							TelaMalaDiretaImprimirLista imprimirLista = new TelaMalaDiretaImprimirLista(
									listas.get(jTbEtiquetas.getSelectedRow()));

						}
					});
		}
		return jBtExibirListas;
	}

	/**
	 * This method initializes jBtSair
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJBtSair() {
		if (jBtSair == null) {
			jBtSair = new JButton();
			jBtSair.setText("Sair");
			jBtSair.setBounds(new Rectangle(685, 42, 69, 36));
			jBtSair.setFont(new Font("arial", Font.BOLD, 11));
			jBtSair.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose(); // TODO Auto-generated Event stub
								// actionPerformed()
				}
			});
		}
		return jBtSair;
	}

	/**
	 * This method initializes jScrollPane
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(26, 116, 732, 310));
			jScrollPane.setViewportView(getJTbEtiquetas());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTbEtiquetas
	 * 
	 * @return javax.swing.JTable
	 */
	private JTable getJTbEtiquetas() {
		if (jTbEtiquetas == null) {
			jTbEtiquetas = new JTable();
			TableCellRenderer renderer = new MeuRenderer();
			jTbEtiquetas.setDefaultRenderer(Object.class, renderer);
			// Aqui eu defino as colunas que a tabela vai conter
			dtmc.addColumn("CÛdigo");
			dtmc.addColumn("Lista");
			jTbEtiquetas.setModel(dtmc);
			jTbEtiquetas.getColumn("CÛdigo").setPreferredWidth(90);
			jTbEtiquetas.getColumn("Lista").setPreferredWidth(640);
			jTbEtiquetas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		}
		return jTbEtiquetas;
	}
} // @jve:decl-index=0:visual-constraint="10,10"
