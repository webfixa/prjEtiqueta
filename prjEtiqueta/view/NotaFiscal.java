package view;

import java.awt.BorderLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JTextField;
import java.awt.Point;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.SystemColor;
import java.awt.event.KeyEvent;

import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import net.sf.jasperreports.engine.JRException;

import modelo.Itens;
import modelo.Nota;
import controle.CtrlItens;
import controle.CtrlNota;
import view.MeuRenderer;
import javax.swing.SwingConstants;

public class NotaFiscal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLbFilial = null;
	private JTextField jTfFilial = null;
	private JButton jBtIncluir = null;
	private JButton jBtExcluir = null;
	private JButton jBtLimpar = null;
	private JButton jBtLimparLista = null;
	private JButton jBtSair = null;
	private JLabel jLbEtiqImpressao = null;
	private JScrollPane jScrollPane = null;
	private JTable jTbEtiquetas = null;
	private JLabel jLbTipoEtiqueta = null;
	private JComboBox jCbTipoEtiqueta = null;
	private JLabel jLbImpressora = null;
	private JComboBox jCbImpressora = null;
	private JButton jBtImprimir = null;
	private JCheckBox jChBPreco = null;
	private JLabel jLbPreco = null;
	private JTextField jTfFilial1 = null;
	private ArrayList<Itens> listaItem = new ArrayList<Itens>();  //  //  @jve:decl-index=0:
	private int seq = 1;
	DefaultTableModel dtmc = new DefaultTableModel()
	{  
        @Override  
        public boolean isCellEditable(final int row, final int column) {  
        	if (column < 4) {  
                return false;  
            } else {  
                return true;  
            }    
        }};  //criar o modelo da tabela
	private JLabel jLbNotaFiscal = null;
	private JTextField jTextField = null;
	private JLabel jLbData = null;
	private JTextField jTfData = null;
	/**
	 * This is the default constructor
	 */
	public NotaFiscal() {
		super();
		initialize();
	}
	public NotaFiscal(String filial,String nota,String data) {
		super();
		initialize();
		jTfFilial.setText(filial);
		jTextField.setText(nota);
		jTfData.setText(data);
		jBtIncluir.doClick();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(800, 570);
		this.setResizable(true);
		this.setContentPane(getJContentPane());
		this.setTitle("Emiss�o de Etiquetas por Nota Fiscal");
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
			jLbData = new JLabel();
			jLbData.setBounds(new Rectangle(10, 73, 128, 16));
			jLbData.setFont(new Font("arial", Font.BOLD, 11));
			jLbData.setHorizontalAlignment(SwingConstants.RIGHT);
			jLbData.setText("Data: <F4>");
			jLbNotaFiscal = new JLabel();
			jLbNotaFiscal.setBounds(new Rectangle(9, 49, 129, 16));
			jLbNotaFiscal.setFont(new Font("arial", Font.BOLD, 11));
			jLbNotaFiscal.setHorizontalAlignment(SwingConstants.RIGHT);
			jLbNotaFiscal.setText("N� Nota Fiscal: <F3>");
			jLbPreco = new JLabel();
			jLbPreco.setBounds(new Rectangle(521, 481, 45, 16));
			jLbPreco.setFont(new Font("arial", Font.BOLD, 11));
			jLbPreco.setHorizontalAlignment(SwingConstants.RIGHT);
			jLbPreco.setText("Pre�o:");
			jLbImpressora = new JLabel();
			jLbImpressora.setBounds(new Rectangle(29, 500, 107, 16));
			jLbImpressora.setFont(new Font("arial", Font.BOLD, 11));
			jLbImpressora.setHorizontalAlignment(SwingConstants.RIGHT);
			jLbImpressora.setText("Impressora:");
			jLbTipoEtiqueta = new JLabel();
			jLbTipoEtiqueta.setBounds(new Rectangle(29, 479, 107, 16));
			jLbTipoEtiqueta.setFont(new Font("arial", Font.BOLD, 11));
			jLbTipoEtiqueta.setHorizontalAlignment(SwingConstants.RIGHT);
			jLbTipoEtiqueta.setText("Tipo da Etiqueta:");
			jLbEtiqImpressao = new JLabel();
			jLbEtiqImpressao.setBounds(new Rectangle(313, 175, 187, 16));
			jLbEtiqImpressao.setFont(new Font("Dialog", Font.BOLD, 12));
			jLbEtiqImpressao.setForeground(SystemColor.activeCaption);
			jLbEtiqImpressao.setText("Etiquetas para Impress�o");
			jLbFilial = new JLabel();
			jLbFilial.setBounds(new Rectangle(10, 23, 127, 16));
			jLbFilial.setFont(new Font("arial", Font.BOLD, 11));
			jLbFilial.setHorizontalAlignment(SwingConstants.RIGHT);
			jLbFilial.setText("Filial: <F2>");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLbFilial, null);
			jContentPane.add(getJTfFilial(), null);
			jContentPane.add(getJBtIncluir(), null);
			jContentPane.add(getJBtExcluir(), null);
			jContentPane.add(getJBtLimpar(), null);
			jContentPane.add(getJBtLimparLista(), null);
			jContentPane.add(getJBtSair(), null);
			jContentPane.add(jLbEtiqImpressao, null);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(jLbTipoEtiqueta, null);
			jContentPane.add(getJCbTipoEtiqueta(), null);
			jContentPane.add(jLbImpressora, null);
			jContentPane.add(getJCbImpressora(), null);
			jContentPane.add(getJBtImprimir(), null);
			jContentPane.add(getJChBPreco(), null);
			jContentPane.add(jLbPreco, null);
			jContentPane.add(getJTfFilial1(), null);
			jContentPane.add(jLbNotaFiscal, null);
			jContentPane.add(getJTextField(), null);
			jContentPane.add(jLbData, null);
			jContentPane.add(getJTfData(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jTfFilial	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTfFilial() {
		if (jTfFilial == null) {
			jTfFilial = new JTextField();
			jTfFilial.setBounds(new Rectangle(143, 21, 76, 20));
			jTfFilial.addKeyListener(new java.awt.event.KeyAdapter() {   
				public void keyPressed(java.awt.event.KeyEvent e) {    
					if (e.getKeyCode() == KeyEvent.VK_F2)
					{
						jTfFilial.requestFocus();
					}
					if (e.getKeyCode() == KeyEvent.VK_F3)
					{
						jTextField.requestFocus();
					}
					if (e.getKeyCode() == KeyEvent.VK_F4)
					{
						jTfData.requestFocus();
					}
					
					if (e.getKeyCode() == KeyEvent.VK_F7)
					{
						jBtIncluir.doClick();
					}
					if (e.getKeyCode() == KeyEvent.VK_F8)
					{
						jBtExcluir.doClick();
					}
					if (e.getKeyCode() == KeyEvent.VK_F9)
					{
						jBtLimpar.doClick();
					}
					if (e.getKeyCode() == KeyEvent.VK_F10)
					{
						jBtLimparLista.doClick();
					}
					if (e.getKeyCode() == KeyEvent.VK_ENTER)
					{
						jTextField.requestFocus();
					}

				}   
				public void keyTyped(java.awt.event.KeyEvent e) {
					if (jTfFilial.getText().equals("1"))
						jTfFilial1.setText("PJ Center");
					else
						if (jTfFilial.getText().equals("2"))
							jTfFilial1.setText("RFJ Materiais de Constru��o");
						else
							if (jTfFilial.getText().equals("3"))
								jTfFilial1.setText("JJ Cal�ados");
					
					}
			});
		}
		return jTfFilial;
	}

	
	
	private JButton getJBtIncluir() {
		if (jBtIncluir == null) {
			jBtIncluir = new JButton();
			jBtIncluir.setText("Incluir <F7>");
			jBtIncluir.setBounds(new Rectangle(26, 131, 105, 36));
			jBtIncluir.setFont(new Font("arial", Font.BOLD, 11));
			jBtIncluir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
				try {
					if(jTextField.getText().equals("") || jTfData.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Preencher todos os campos!");
					}else{
					CtrlNota ctrl = new CtrlNota();
					for(Iterator<Nota> it=ctrl.getNota(jTfFilial.getText(), jTextField.getText(), jTfData.getText()).iterator();it.hasNext();)
						{
						    NumberFormat nf = NumberFormat.getCurrencyInstance();
							String[] linha = new String[5];//crio uma nova linha para a tabela com 5 elementos // TODO Auto-generated Event stub actionPerformed()
							Nota nota = (Nota)it.next();
							linha[0]= nota.getCoditprod();
							linha[1]=nota.getDescricao();  
					        linha[2]=nota.getCodbarra();  
					        try{
						        linha[3]= nf.format(Double.parseDouble(nota.getPreco())); }
						        catch(NumberFormatException x){
						        	String valor="";
						        	char[] prec = new char[nota.getPreco().length()];
						        	for(int i=0;i<nota.getPreco().length();i++)
						        	{
						        		prec[i]= nota.getPreco().charAt(i);
						        	}
						        	boolean ponto = false;		
						        	for(int i=0;i<prec.length;i++)
						        	{
						        		if(prec[i]!='.' || ponto==true)
						        		{
						        			valor+=prec[i];
						        		}
						        		else{
						        			valor+="";
						        			ponto= true;
						        			}
						        	}
						            linha[3]= nf.format(Double.parseDouble(valor));
						        	} 
						        try{
						        	linha[4]= String.valueOf(Integer.parseInt(nota.getQuantidade()));}
							        catch(NumberFormatException x){
							        	String valor="";
							        	char[] prec = new char[nota.getQuantidade().length()];
							        	for(int i=0;i<nota.getQuantidade().length();i++)
							        	{
							        		prec[i]= nota.getQuantidade().charAt(i);
							        	}
							        	boolean ponto = false;		
							        	for(int i=0;i<prec.length;i++)
							        	{
							        		if(prec[i]!='.')
							        		{
							        			valor+=prec[i];
							        		}
							        		else{
							        			break;
							        			}
							        	}
							            linha[4]= valor;
							        	}
						        
					        dtmc.addRow( linha );//Adiciono a linha que eu criei na tabela
					        jTbEtiquetas.setModel(dtmc);	
						}
					}
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "Preencher todos os campos!");
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
			jBtExcluir.setBounds(new Rectangle(132, 131, 113, 36));
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
			jBtLimpar.setText("<html><center>Limpar<br>Campos - F9</center></html>");
			jBtLimpar.setBounds(new Rectangle(246, 131, 125, 36));
			jBtLimpar.setFont(new Font("Arial", Font.BOLD, 11));
			jBtLimpar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jTextField.setText("");
					jTfData.setText("");
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
			jBtLimparLista.setText("<html><center>Limpar<br>Lista - F10</center></html>");
			jBtLimparLista.setBounds(new Rectangle(372, 131, 105, 36));
			jBtLimparLista.setFont(new Font("arial", Font.BOLD, 11));
			jBtLimparLista.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					while(dtmc.getRowCount()> 0)
					{
						dtmc.removeRow(0);
					}
					jTbEtiquetas.setModel(dtmc);
					seq=1;
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
			jBtSair.setBounds(new Rectangle(684, 130, 70, 36));
			jBtSair.setFont(new Font("arial", Font.BOLD, 11));
			jBtSair.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose(); // TODO Auto-generated Event stub actionPerformed()
				}
			});
			jBtSair.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
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
			jScrollPane.setBounds(new Rectangle(27, 196, 732, 274));
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
		      //Aqui eu defino as colunas que a tabela vai conter     
		       dtmc.addColumn("Item");  
		       dtmc.addColumn("Descrição");  
		       dtmc.addColumn("CodBarra");  
		       dtmc.addColumn("Preço");  
		       dtmc.addColumn("Qnt"); 
		       jTbEtiquetas.setModel(dtmc);
		       jTbEtiquetas.getColumn("Item").setPreferredWidth(90);
		       jTbEtiquetas.getColumn("Descrição").setPreferredWidth(335);
		       jTbEtiquetas.getColumn("CodBarra").setPreferredWidth(134);
		       jTbEtiquetas.getColumn("Preço").setPreferredWidth(85);
		       jTbEtiquetas.getColumn("Qnt").setPreferredWidth(85);
		       jTbEtiquetas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		       
		}
		return jTbEtiquetas;
	}
	/**
	 * This method initializes jTbEtiquetas	
	 * 	
	 * @return javax.swing.JTable	
	 *
	//m�todo para atualizar (preencher) a tebela  
	 public void atualizaTabelaCliente()  
	    {  
	        clientes = new ArrayList<Cliente>(); //ArrayList de clientes  
	        clientes = banco.buscarCliente(""); //preenchendo o Array com todos os clientes da base  
	        insereTabelaCliente(clientes);//pasando por par�metro o ArrayList de clientes  
	    }  
	  
	//metodo para criar a tabela  
	private void insereTabelaCliente(ArrayList<Cliente> clientes)  
	    {  
	          DefaultTableModel dtmc = new DefaultTableModel();//criar o modelo da tabela  
	         
	      Cliente cliente;  
	  
	      //Aqui eu defino as colunas que a tabela vai conter     
	       dtmc.addColumn("C�digo");  
	       dtmc.addColumn("Nome");  
	       dtmc.addColumn("CPF");  
	       dtmc.addColumn("Data de Nascimento");  
	       dtmc.addColumn("Endere�o");  
	       dtmc.addColumn("Bairro");  
	       dtmc.addColumn("CEP");  
	       dtmc.addColumn("Cidade");  
	       dtmc.addColumn("UF");  
	       dtmc.addColumn("Telefone");  
	       dtmc.addColumn("Celular");  
	       dtmc.addColumn("E-mail");  
	       dtmc.addColumn("Pend�ncias");  
	       dtmc.addColumn("Cr�ditos");  
	       dtmc.addColumn("Dependentes");  
	       dtmc.addColumn("N�mero de loca��es");  
	       dtmc.addColumn("Valor arrecadado");
	  
	       //Aqui eu preencho a tabela com os dados de todos os clientes do Array Clientes  
	        for(Object c2 : clientes){  
	            cliente = (Cliente) c2;  
	        
	            String[] linha = new String[17];//crio uma nova linha para a tabela com 17 elementos  
	           // 17 � o n�mero de colunas da tabela, se voc� colocar um numero menor vai dar erro  
	              
	            linha[0]=cliente.getCodigoS();//c�digo do cliente na coluna 0  
	            linha[1]=cliente.getNome();//nome do cliente na coluna 1  
	            linha[2]=cliente.getCpf();// cpf na coluna 3  
	            linha[3]=cliente.getDataNascimento();//...  
	            linha[4]=cliente.getEndereco();  
	            linha[5]=cliente.getBairro();  
	            linha[6]=cliente.getCep();  
	            linha[7]=cliente.getCidade();  
	            linha[8]=cliente.getUf();  
	            linha[9]=cliente.getTelefone();  
	            linha[10]=cliente.getCelular();  
	            linha[11]=cliente.getEmail();  
	            linha[12]=cliente.getPendencias();  
	            linha[13]=cliente.getCreditos();  
	            linha[14]=cliente.getNumDependentes();  
	            linha[15]=cliente.getNumLocacoes();  
	            linha[16]=cliente.getValorArrecadado();  
	              
	              
	            dtmc.addRow( linha );//Adiciono a linha que eu criei na tabela  
	         }  
	  
	         tabelaCliente.setModel(dtmc);//adiciono o modelo que eu criei na tabela  
	        //aqui eu defino a largura minima de cada coluna, nao precisa fazer para todas as colunas  
	        //somente para aquelas que ser�o um pouco mais largas como o campo "NOME" e "ENDERE�O"  
	         tabelaCliente.getColumnModel().getColumn(1).setMinWidth(300);  
	         tabelaCliente.getColumnModel().getColumn(2).setMinWidth(110);  
	         tabelaCliente.getColumnModel().getColumn(4).setMinWidth(300);  
	         tabelaCliente.getColumnModel().getColumn(5).setMinWidth(110);  
	         tabelaCliente.getColumnModel().getColumn(9).setMinWidth(110);  
	         tabelaCliente.getColumnModel().getColumn(10).setMinWidth(110);  
	         tabelaCliente.getColumnModel().getColumn(11).setMinWidth(200);  
	         tabelaCliente.getColumnModel().getColumn(15).setMinWidth(130);  
	         tabelaCliente.getColumnModel().getColumn(16).setMinWidth(110);  
	  }  


	Para pega um dado na linha selecionada pelo usu�rio:
	private void botaoClicado() { //coloque o codigo a baixo dentro da anction de um botao   
	//Pegar dados da tabela  
	 if(tabelaClientes.getSelectedRowCount() == 1){ //verifico se somente uma linha est� selecionada  
	       String assa = (String) tabelaClientes.getValueAt(tabelaUser.getSelectedRow(), 0);  
	       //Pego o valoe da coluna 0 na linha que foi selecionada pelo usu�rio;  
	    
	       }*/

	/**
	 * This method initializes jCbTipoEtiqueta	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJCbTipoEtiqueta() {
		String tipo[] = {"eletro", "geral","gondola", "jóias","roupas","suporte"};
		if (jCbTipoEtiqueta == null) {
			jCbTipoEtiqueta = new JComboBox(tipo);
			jCbTipoEtiqueta.setPreferredSize(new Dimension(200, 20));
			jCbTipoEtiqueta.setSize(new Dimension(250, 20));
			jCbTipoEtiqueta.setLocation(new Point(140, 479));
		}
		return jCbTipoEtiqueta;
	}

	/**
	 * This method initializes jCbImpressora	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJCbImpressora() {
		String impressora[] = {"Zebra S600", "Zebra stripe S4M","DoPDF"};
		if (jCbImpressora == null) {
			jCbImpressora = new JComboBox(impressora);
			jCbImpressora.setLocation(new Point(140,500));
			jCbImpressora.setSize(new Dimension(250, 20));
		}
		return jCbImpressora;
	}

	/**
	 * This method initializes jBtImprimir	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJBtImprimir() {
		if (jBtImprimir == null) {
			jBtImprimir = new JButton();
			jBtImprimir.setText("Imprimir <F11>");
			jBtImprimir.setSize(new Dimension(123, 41));
			jBtImprimir.setLocation(new Point(393, 478));
			jBtImprimir.setFont(new Font("arial", Font.BOLD, 11));
			jBtImprimir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int numLinhas = jTbEtiquetas.getModel().getRowCount();
					int i = 0;
					ArrayList<String[]> tabela = new ArrayList<String[]>();
					while(i<numLinhas)
					{
						String[] linha = new String[5];
						for(int j=0;j<5;j++)
						{
							linha[j]=String.valueOf(jTbEtiquetas.getModel().getValueAt(i, j));
						}
						for(int k=0; k<Integer.parseInt(linha[4]);k++)
							tabela.add(linha);
						i++;
					}
					CtrlNota ctrl=new CtrlNota();
					try {
						ctrl.impressao(tabela,String.valueOf(jCbTipoEtiqueta.getSelectedItem()), jCbImpressora.getSelectedIndex(),jChBPreco.isSelected());
					} catch (JRException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		return jBtImprimir;
	}

	/**
	 * This method initializes jChBPreco	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJChBPreco() {
		if (jChBPreco == null) {
			jChBPreco = new JCheckBox("Preco",true);
			jChBPreco.setBounds(new Rectangle(567, 479, 21, 21));
		}
		return jChBPreco;
	}

	/**
	 * This method initializes jTfFilial1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTfFilial1() {
		if (jTfFilial1 == null) {
			jTfFilial1 = new JTextField();
			jTfFilial1.setBounds(new Rectangle(219, 21, 322, 20));
			jTfFilial1.setEnabled(false);
		}
		return jTfFilial1;
	}

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new Rectangle(144, 47, 104, 20));
			jTextField.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_F2)
					{
						jTfFilial.requestFocus();
					}
					if (e.getKeyCode() == KeyEvent.VK_F3)
					{
						jTextField.requestFocus();
					}
					if (e.getKeyCode() == KeyEvent.VK_F4)
					{
						jTfData.requestFocus();
					}
					
					if (e.getKeyCode() == KeyEvent.VK_F7)
					{
						jBtIncluir.doClick();
					}
					if (e.getKeyCode() == KeyEvent.VK_F8)
					{
						jBtExcluir.doClick();
					}
					if (e.getKeyCode() == KeyEvent.VK_F9)
					{
						jBtLimpar.doClick();
					}
					if (e.getKeyCode() == KeyEvent.VK_F10)
					{
						jBtLimparLista.doClick();
					}
					if (e.getKeyCode() == KeyEvent.VK_ENTER)
					{
						ConsultaNota consulta = new ConsultaNota(jTfFilial.getText(),jTextField.getText());
						dispose();
					}

				}
			});
		}
		return jTextField;
	}

	/**
	 * This method initializes jTfData	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTfData() {
		if (jTfData == null) {
			javax.swing.text.MaskFormatter data;
			try {
				data = new javax.swing.text.MaskFormatter("##/##/####");
				jTfData = new JFormattedTextField(data);
			} catch (ParseException e1) {
				JOptionPane.showMessageDialog(null, "Data inv�lida!");
			} 
			jTfData.setBounds(new Rectangle(144, 71, 104, 20));
			jTfData.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_F2)
					{
						jTfFilial.requestFocus();
					}
					if (e.getKeyCode() == KeyEvent.VK_F3)
					{
						jTextField.requestFocus();
					}
					if (e.getKeyCode() == KeyEvent.VK_F4)
					{
						jTfData.requestFocus();
					}
					
					if (e.getKeyCode() == KeyEvent.VK_F7)
					{
						jBtIncluir.doClick();
					}
					if (e.getKeyCode() == KeyEvent.VK_F8)
					{
						jBtExcluir.doClick();
					}
					if (e.getKeyCode() == KeyEvent.VK_F9)
					{
						jBtLimpar.doClick();
					}
					if (e.getKeyCode() == KeyEvent.VK_F10)
					{
						jBtLimparLista.doClick();
					}
					if (e.getKeyCode() == KeyEvent.VK_ENTER)
					{
						jBtIncluir.doClick();
					}

				}
			});
		}
		return jTfData;
	}
	
}  //  @jve:decl-index=0:visual-constraint="10,10"
