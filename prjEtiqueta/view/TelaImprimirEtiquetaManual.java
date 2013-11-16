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
import modelo.EtiquetaManual;
import modelo.Itens;
import modelo.Lista;
import controle.CtrlItens;
import controle.CtrlMalaDireta;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaImprimirEtiquetaManual extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLbLista;
	private JLabel jLbNome;
	private JTextField jTfFilial = null;
	private JTextField jTfItem = null;
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
	private JTextField tfCodigo;
	private JTextField tfNome;
	private JTextField JTfData;
	private EtiquetaManual etiqueta;
	private JComboBox comboBox;

	/**
	 * This is the default constructor
	 * 
	 * @param etiqueta
	 */
	public TelaImprimirEtiquetaManual(EtiquetaManual etiqueta) {
		super();
		this.etiqueta = etiqueta;
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
		this.setTitle("Emissão de Etiquetas - Imprimindo Etiqueta Manual");
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
			jLbEtiqImpressao.setBounds(new Rectangle(314, 122, 187, 16));
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
			jContentPane.add(getJBtSair(), null);
			jContentPane.add(jLbEtiqImpressao, null);
			jContentPane.add(getJScrollPane(), null);

			tfCodigo = new JTextField();
			tfCodigo.setBounds(143, 23, 86, 20);
			jContentPane.add(tfCodigo);
			tfCodigo.setColumns(10);
			tfCodigo.setText(etiqueta.getCodigo());

			tfNome = new JTextField();
			tfNome.setBounds(143, 67, 542, 20);
			jContentPane.add(tfNome);
			tfNome.setColumns(10);
			tfNome.setText(etiqueta.getNome());

			JLabel lblData = new JLabel("Data: <F3>");
			lblData.setFont(new Font("Arial", Font.BOLD, 11));
			lblData.setBounds(85, 49, 86, 15);
			jContentPane.add(lblData);

			JTfData = new JTextField();
			JTfData.setBounds(143, 46, 124, 19);
			jContentPane.add(JTfData);
			JTfData.setColumns(10);
			JTfData.setText(etiqueta.getData());

			JLabel label = new JLabel();
			label.setText("Impressora:");
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setFont(new Font("Arial", Font.BOLD, 11));
			label.setBounds(new Rectangle(29, 503, 107, 16));
			label.setBounds(27, 434, 107, 16);
			jContentPane.add(label);

			JButton btImprimir = new JButton();
			btImprimir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CtrlMalaDireta.imprimirEtiqueta(comboBox.getSelectedIndex(), etiqueta);
					dispose();
				}
			});
			btImprimir.setText("Imprimir <F11>");
			btImprimir.setSize(new Dimension(123, 41));
			btImprimir.setLocation(new Point(393, 481));
			btImprimir.setFont(new Font("Arial", Font.BOLD, 11));
			btImprimir.setBounds(391, 430, 123, 41);
			jContentPane.add(btImprimir);
				String[] linha = new String[2];
				linha[0] = etiqueta.getTexto();
				linha[1]=String.valueOf(etiqueta.getQnt());
				
				dtmc.addRow(linha);
			
			
			jTbEtiquetas.setModel(dtmc);
			jContentPane.add(getComboBox());

		}
		return jContentPane;
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
			jBtSair.setBounds(new Rectangle(695, 59, 69, 36));
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
			jScrollPane.setBounds(new Rectangle(27, 149, 732, 274));
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
			dtmc.addColumn("Texto");
			dtmc.addColumn("Quant.");
			jTbEtiquetas.setModel(dtmc);
			jTbEtiquetas.getColumn("Texto").setPreferredWidth(670);
			jTbEtiquetas.getColumn("Quant.").setPreferredWidth(80);
			jTbEtiquetas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		}
		return jTbEtiquetas;
	}

	private JComboBox getComboBox() {
		if (comboBox == null) {
			String impressora[] = { "Zebra S600", "Zebra stripe S4M", "DoPDF" };
			comboBox = new JComboBox(impressora);
			comboBox.setBounds(143, 432, 238, 20);
		}
		return comboBox;
	}
} // @jve:decl-index=0:visual-constraint="10,10"
