package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
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

import modelo.Cliente;
import controle.CtrlMalaDireta;

public class TelaMalaDiretaNomeCodigo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLbCodigo;
	private JLabel jLbNome;
	private JTextField jTfItem = null;
	private JButton jBtIncluir = null;
	private JButton jBtExcluir = null;
	private JButton jBtLimpar = null;
	private JButton jBtLimparLista = null;
	private JButton jBtSair = null;
	private JLabel jLbEtiqImpressao = null;
	private JScrollPane jScrollPane = null;
	private JTable jTbCliente = null;
	private Cliente cliente;
	private JTextField tfCodigo;
	private JTextField tfNome;
	private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

	// @jve:decl-index=0:

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

	/**
	 * This is the default constructor
	 */
	public TelaMalaDiretaNomeCodigo() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(800, 493);
		this.setResizable(true);
		this.setContentPane(getJContentPane());
		this.setTitle("Emiss\u00E3o de Etiquetas - Mala Direta Gerando Lista");
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
			jLbEtiqImpressao.setBounds(new Rectangle(314, 128, 187, 16));
			jLbEtiqImpressao.setFont(new Font("Dialog", Font.BOLD, 12));
			jLbEtiqImpressao.setForeground(SystemColor.activeCaption);
			jLbEtiqImpressao.setText("Etiquetas para Impress\u00E3o");
			jLbNome = new JLabel();
			jLbNome.setBounds(new Rectangle(69, 48, 67, 16));
			jLbNome.setFont(new Font("arial", Font.BOLD, 11));
			jLbNome.setHorizontalAlignment(SwingConstants.RIGHT);
			jLbNome.setText("Nome: <F3>");
			jLbCodigo = new JLabel();
			jLbCodigo.setBounds(new Rectangle(62, 29, 76, 16));
			jLbCodigo.setFont(new Font("arial", Font.BOLD, 11));
			jLbCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
			jLbCodigo.setText("C\u00F3digo: <F2>");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLbCodigo, null);
			jContentPane.add(jLbNome, null);

			jContentPane.add(getJBtIncluir(), null);
			jContentPane.add(getJBtExcluir(), null);
			jContentPane.add(getJBtLimpar(), null);
			jContentPane.add(getJBtLimparLista(), null);
			jContentPane.add(getJBtSair(), null);
			jContentPane.add(jLbEtiqImpressao, null);
			jContentPane.add(getJScrollPane(), null);

			tfCodigo = new JTextField();
			tfCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						CtrlMalaDireta malaDireta = new CtrlMalaDireta();

						for (Iterator<Cliente> it = malaDireta.pegaCodigo(
								tfCodigo.getText()).iterator(); it.hasNext();) {
							cliente = it.next();
						}
						if (cliente != null) {
							tfNome.setText(cliente.getNome());
						}
					}
				}
			});
			tfCodigo.setBounds(144, 23, 86, 20);
			jContentPane.add(tfCodigo);
			tfCodigo.setColumns(10);

			tfNome = new JTextField();
			tfNome.setBounds(143, 46, 542, 20);
			jContentPane.add(tfNome);
			tfNome.setColumns(10);
		}
		return jContentPane;
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
			jBtIncluir.setLocation(new Point(27, 81));
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
						linha[0] = String.valueOf(cliente.getCodigo());
						linha[1] = cliente.getNome();
						linha[2] = cliente.getEndereco();
						linha[3] = cliente.getBairro();
						linha[4] = cliente.getCidade();

						dtmc.addRow(linha);// Adiciono a linha que eu criei na
											// tabela
						jTbCliente.setModel(dtmc);
						
						listaClientes.add(cliente);
						tfCodigo.setText("");
						tfNome.setText("");

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
			jBtExcluir.setLocation(new Point(133, 81));
			jBtExcluir.setFont(new Font("arial", Font.BOLD, 11));
			jBtExcluir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					listaClientes.remove(jTbCliente.getSelectedRow());
					dtmc.removeRow(jTbCliente.getSelectedRow());
					jTbCliente.setModel(dtmc);
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
			jBtLimpar.setLocation(new Point(247, 81));
			jBtLimpar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {

					tfCodigo.setText("");
					tfNome.setText("");

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
			jBtLimparLista.setBounds(new Rectangle(360, 81, 112, 36));
			jBtLimparLista.setFont(new Font("arial", Font.BOLD, 11));
			jBtLimparLista
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							while (dtmc.getRowCount() > 0) {
								dtmc.removeRow(0);
							}
							listaClientes.removeAll(listaClientes);
							jTbCliente.setModel(dtmc);
						}
					});
		}
		return jBtLimparLista;
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
			jBtSair.setBounds(new Rectangle(686, 81, 69, 36));
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
			jScrollPane.setBounds(new Rectangle(27, 155, 732, 274));
			jScrollPane.setViewportView(getJTbCliente());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTbEtiquetas
	 * 
	 * @return javax.swing.JTable
	 */
	private JTable getJTbCliente() {
		if (jTbCliente == null) {
			jTbCliente = new JTable();
			TableCellRenderer renderer = new MeuRenderer();
			jTbCliente.setDefaultRenderer(Object.class, renderer);
			// Aqui eu defino as colunas que a tabela vai conter
			dtmc.addColumn("Código");
			dtmc.addColumn("Nome");
			dtmc.addColumn("Endereço");
			dtmc.addColumn("Bairro");
			dtmc.addColumn("Cidade");
			jTbCliente.setModel(dtmc);
			jTbCliente.getColumn("Código").setPreferredWidth(90);
			jTbCliente.getColumn("Nome").setPreferredWidth(200);
			jTbCliente.getColumn("Endereço").setPreferredWidth(200);
			jTbCliente.getColumn("Bairro").setPreferredWidth(116);
			jTbCliente.getColumn("Cidade").setPreferredWidth(115);
			jTbCliente.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		}
		return jTbCliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

} // @jve:decl-index=0:visual-constraint="10,10"
