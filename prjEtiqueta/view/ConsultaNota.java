package view;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import java.awt.Rectangle;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import javax.swing.JButton;

import controle.CtrlNota;

import modelo.Nota;
import javax.swing.JScrollPane;

public class ConsultaNota extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private String filial;
	private String nota;
	DefaultTableModel dtmc = new DefaultTableModel()
	{  
        @Override  
        public boolean isCellEditable(final int row, final int column) {  
          return false;  }};
	
	private JButton jBtOk = null;
	private JButton jBtCancelar = null;
	private JScrollPane jScrollPane = null;
	private JTable jTbNota = null;
	/**
	 * This is the default constructor
	 */
	public ConsultaNota(String filial, String nota) {
		super();
		this.filial = filial;
		this.nota = nota;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(546, 262);
		this.setContentPane(getJContentPane());
		this.setTitle("Consulta Nota Fiscal");
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
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJBtOk(), null);
			jContentPane.add(getJBtCancelar(), null);
			jContentPane.add(getJScrollPane(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jTbNotas	
	 * 	
	 * @return javax.swing.JTable	
	 */
	

	/**
	 * This method initializes jBtOk	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJBtOk() {
		if (jBtOk == null) {
			jBtOk = new JButton();
			jBtOk.setBounds(new Rectangle(133, 181, 106, 33));
			jBtOk.setText("OK");
			jBtOk.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
					int linha = jTbNota.getSelectedRow();
					int coluna = 2;
					String data = String.valueOf(jTbNota.getModel().getValueAt(linha, coluna));
					NotaFiscal nova = new NotaFiscal(filial, nota, data);
					dispose();
				}
			});
		}
		return jBtOk;
	}

	/**
	 * This method initializes jBtCancelar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJBtCancelar() {
		if (jBtCancelar == null) {
			jBtCancelar = new JButton();
			jBtCancelar.setBounds(new Rectangle(282, 181, 106, 33));
			jBtCancelar.setText("Cancelar");
		}
		return jBtCancelar;
	}
	
	
	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(13, 27, 500, 139));
			jScrollPane.setViewportView(getJTbNota());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTbNota	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTbNota() {
		if (jTbNota == null) {
			jTbNota = new JTable();
			TableCellRenderer renderer = new MeuRenderer();  
			jTbNota.setDefaultRenderer(Object.class, renderer); 
			//Aqui eu defino as colunas que a tabela vai conter     
		       dtmc.addColumn("FILIAL");  
		       dtmc.addColumn("N. FISCAL");  
		       dtmc.addColumn("DATA");  
		       dtmc.addColumn("FORNECEDOR"); 
			  jTbNota.setModel(dtmc);
			  
			 preencheTabela();
		   }
		return jTbNota;
	}
	private void preencheTabela()
	{
		CtrlNota ctrl = new CtrlNota();
		for(Iterator<Nota> it=ctrl.pegaNotas(filial, nota).iterator();it.hasNext();)
		{
			String[] linha = new String[5];//crio uma nova linha para a tabela com 5 elementos // TODO Auto-generated Event stub actionPerformed()
			Nota not = (Nota)it.next();
			linha[0]= not.getCodfil();
			linha[1]=not.getNumnota();  
			SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
			linha[2]=formatador.format(not.getDtnota());
			linha[3]=not.getRazsoc(); 
			
	        dtmc.addRow( linha );//Adiciono a linha que eu criei na tabela
		}
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
