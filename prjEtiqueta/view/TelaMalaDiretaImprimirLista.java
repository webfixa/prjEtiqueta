package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import net.sf.jasperreports.engine.JRException;

import modelo.Cliente;
import modelo.Itens;
import modelo.Lista;
import controle.CtrlItens;
import controle.CtrlMalaDireta;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaMalaDiretaImprimirLista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLbLista;
	private JLabel jLbNome;
	private JTextField jTfFilial = null;
	private JTextField jTfItem = null;
	private JButton jBtIncluir = null;
	private JButton jBtExcluir = null;
	private JButton jBtLimpar = null;
	private JButton jBtLimparLista = null;
	private JButton jBtSalvaLista = null;
	private JButton jBtSair = null;
	private JLabel jLbEtiqImpressao = null;
	private JScrollPane jScrollPane = null;
	private JTable jTbEtiquetas = null;
	
	private ArrayList<Itens> listaItem = new ArrayList<Itens>(); // //
																	// @jve:decl-index=0:
	private int seq = 1;
	DefaultTableModel dtmc = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(final int row, final int column) {
			if (column < 4) {
				return false;
			} else {
				return true;
			}
		}
	}; // criar o modelo da tabela
	private JLabel jLbProduto = null;
	private JLabel jbEstoque = null;
	private JTextField tfCodigo;
	private JTextField tfNome;
	private JTextField JTfData;
	private Lista lista;
	private JComboBox comboBox;

	/**
	 * This is the default constructor
	 * 
	 * @param lista
	 */
	public TelaMalaDiretaImprimirLista(Lista lista) {
		super();
		this.lista = lista;
		ArrayList<Cliente> clientes = CtrlMalaDireta.pegaCliente(lista.getCodigo());
		this.lista.setClientes(clientes);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(800, 560);
		this.setResizable(true);
		this.setContentPane(getJContentPane());
		this.setTitle("Emissão de Etiquetas - Mala Direta Imprimindo Lista de Clientes");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLbEtiqImpressao = new JLabel();
			jLbEtiqImpressao.setBounds(new Rectangle(314, 149, 187, 16));
			jLbEtiqImpressao.setFont(new Font("Dialog", Font.BOLD, 12));
			jLbEtiqImpressao.setForeground(SystemColor.activeCaption);
			jLbEtiqImpressao.setText("Etiquetas para Impress\u00E3o");
			jLbNome = new JLabel();
			jLbNome.setBounds(new Rectangle(69, 69, 67, 16));
			jLbNome.setFont(new Font("arial", Font.BOLD, 11));
			jLbNome.setHorizontalAlignment(SwingConstants.RIGHT);
			jLbNome.setText("Nome: <F4>");
			jLbLista = new JLabel();
			jLbLista.setBounds(new Rectangle(62, 29, 76, 16));
			jLbLista.setFont(new Font("arial", Font.BOLD, 11));
			jLbLista.setHorizontalAlignment(SwingConstants.RIGHT);
			jLbLista.setText("Lista: <F2>");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLbLista, null);
			jContentPane.add(jLbNome, null);

			jContentPane.add(getJBtIncluir(), null);
			jContentPane.add(getJBtExcluir(), null);
			jContentPane.add(getJBtLimpar(), null);
			jContentPane.add(getJBtLimparLista(), null);
			jContentPane.add(getJBtSalvaLista(), null);
			jContentPane.add(getJBtSair(), null);
			jContentPane.add(jLbEtiqImpressao, null);
			jContentPane.add(getJScrollPane(), null);

			tfCodigo = new JTextField();
			tfCodigo.setBounds(143, 23, 86, 20);
			jContentPane.add(tfCodigo);
			tfCodigo.setColumns(10);
			tfCodigo.setText(lista.getCodigo());

			tfNome = new JTextField();
			tfNome.setBounds(143, 67, 542, 20);
			jContentPane.add(tfNome);
			tfNome.setColumns(10);
			tfNome.setText(lista.getNome());

			JLabel lblData = new JLabel("Data: <F3>");
			lblData.setFont(new Font("Arial", Font.BOLD, 11));
			lblData.setBounds(85, 49, 86, 15);
			jContentPane.add(lblData);

			JTfData = new JTextField();
			JTfData.setBounds(143, 46, 124, 19);
			jContentPane.add(JTfData);
			JTfData.setColumns(10);
			JTfData.setText(lista.getData());

			JLabel label = new JLabel();
			label.setText("Impressora:");
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setFont(new Font("Arial", Font.BOLD, 11));
			label.setBounds(new Rectangle(29, 503, 107, 16));
			label.setBounds(27, 461, 107, 16);
			jContentPane.add(label);

			JButton button = new JButton();
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						CtrlMalaDireta.relatorio(comboBox.getSelectedIndex(), lista.getClientes());
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (JRException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			button.setText("Imprimir <F11>");
			button.setSize(new Dimension(123, 41));
			button.setLocation(new Point(393, 481));
			button.setFont(new Font("Arial", Font.BOLD, 11));
			button.setBounds(391, 457, 123, 41);
			jContentPane.add(button);
			for(Cliente cliente : lista.getClientes()){
				String[] linha = new String[5];
				linha[0] = String.valueOf(cliente.getCodigo());
				linha[1]=cliente.getNome();
				linha[2]=cliente.getEndereco();
				linha[3]=cliente.getBairro();
				linha[4]=cliente.getCidade();	
				dtmc.addRow(linha);
			}
			
			jTbEtiquetas.setModel(dtmc);
			jContentPane.add(getComboBox());

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
	 * This method initializes jTfItem
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTfNome() {
		if (jTfItem == null) {
			jTfItem = new JTextField();
			jTfItem.setLocation(new Point(143, 44));
			jTfItem.setSize(new Dimension(400, 20));
			jTfItem.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						try {
							CtrlItens descricao = new CtrlItens();
							for (Iterator it = descricao.getItens(
									jTfFilial.getText(), jTfItem.getText())
									.iterator(); it.hasNext();) {
								Itens item = (Itens) it.next();
								listaItem.add(item);
							}
							for (Iterator<Itens> it = listaItem.iterator(); it
									.hasNext();) {
								Itens itens = (Itens) it.next();
								if (itens.getItem() == Integer.parseInt(jTfItem
										.getText())) {
									NumberFormat nf = NumberFormat
											.getCurrencyInstance();
									String aux = "";
									try {
										aux = nf.format(Double
												.parseDouble(itens.getPreco()));
									} catch (NumberFormatException x) {
										String valor = "";
										char[] prec = new char[itens.getPreco()
												.length()];
										for (int i = 0; i < itens.getPreco()
												.length(); i++) {
											prec[i] = itens.getPreco()
													.charAt(i);
										}
										boolean ponto = false;
										for (int i = 0; i < prec.length; i++) {
											if (prec[i] != '.' || ponto == true) {
												valor += prec[i];
											} else {
												valor += "";
												ponto = true;
											}
										}
										aux = nf.format(Double
												.parseDouble(valor));
									}

								}
							}
						} catch (Exception x) {
							javax.swing.JOptionPane.showMessageDialog(null,
									"ï¿½tem invï¿½lido!");
						}
					}
				}
			});
			jTfItem.addKeyListener(new java.awt.event.KeyAdapter() {
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
		return jTfItem;
	}

	/**
	 * This method initializes jBtIncluir
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJBtIncluir() {
		if (jBtIncluir == null) {
			jBtIncluir = new JButton();
			jBtIncluir.setText("Incluir <F7>");
			jBtIncluir.setSize(new Dimension(105, 36));
			jBtIncluir.setLocation(new Point(27, 102));
			jBtIncluir.setFont(new Font("arial", Font.BOLD, 11));
			jBtIncluir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {

						String[] linha = new String[5];// crio uma nova linha
														// para a tabela com 5
														// elementos // TODO
														// Auto-generated Event
														// stub
														// actionPerformed()
						linha[0] = Integer.toString(seq);
						// linha[1]=jCbDescricao.getText();
						// linha[2]=jTfCodBarras.getText();
						// linha[3]=jTfPreco.getText();
						// linha[4]=jTfQnt.getText();

						dtmc.addRow(linha);// Adiciono a linha que eu criei na
											// tabela
						jTbEtiquetas.setModel(dtmc);
						seq++;

						jTfItem.setText("");
						jTfItem.requestFocus();

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
			jBtExcluir.setLocation(new Point(133, 102));
			jBtExcluir.setFont(new Font("arial", Font.BOLD, 11));
			jBtExcluir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
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
			jBtLimpar.setLocation(new Point(247, 102));
			jBtLimpar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {

					jTfItem.setText("");

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
			jBtLimparLista.setBounds(new Rectangle(360, 102, 112, 36));
			jBtLimparLista.setFont(new Font("arial", Font.BOLD, 11));
			jBtLimparLista
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							while (dtmc.getRowCount() > 0) {
								dtmc.removeRow(0);
							}
							jTbEtiquetas.setModel(dtmc);
							seq = 1;
						}
					});
		}
		return jBtLimparLista;
	}

	/**
	 * This method initializes jBtOrÃ§amento
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJBtSalvaLista() {
		if (jBtSalvaLista == null) {
			jBtSalvaLista = new JButton();
			jBtSalvaLista.setText("Salvar Lista");
			jBtSalvaLista.setBounds(new Rectangle(580, 102, 105, 36));
			jBtSalvaLista.setFont(new Font("arial", Font.BOLD, 11));
			jBtSalvaLista
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							TelaOrcamento orc = new TelaOrcamento();
						}
					});
		}
		return jBtSalvaLista;
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
			jBtSair.setBounds(new Rectangle(686, 102, 69, 36));
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
			jScrollPane.setBounds(new Rectangle(27, 176, 732, 274));
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
			dtmc.addColumn("Código");
			dtmc.addColumn("Nome");
			dtmc.addColumn("Endereço");
			dtmc.addColumn("Bairro");
			dtmc.addColumn("Cidade");
			jTbEtiquetas.setModel(dtmc);
			jTbEtiquetas.getColumn("Código").setPreferredWidth(90);
			jTbEtiquetas.getColumn("Nome").setPreferredWidth(200);
			jTbEtiquetas.getColumn("Endereço").setPreferredWidth(200);
			jTbEtiquetas.getColumn("Bairro").setPreferredWidth(116);
			jTbEtiquetas.getColumn("Cidade").setPreferredWidth(115);
			jTbEtiquetas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		}
		return jTbEtiquetas;
	}

	private JComboBox getComboBox() {
		if (comboBox == null) {
			String impressora[] = { "Zebra S600", "Zebra stripe S4M", "DoPDF" };
			comboBox = new JComboBox(impressora);
			comboBox.setBounds(143, 459, 238, 20);
		}
		return comboBox;
	}
} // @jve:decl-index=0:visual-constraint="10,10"
