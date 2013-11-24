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
import javax.swing.JCheckBox;
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

import modelo.Itens;
import net.sf.jasperreports.engine.JRException;
import controle.CtrlItens;

public class Etiqueta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLbFilial = null;
	private JLabel jLbItem = null;
	private JLabel jLbDescricao = null;
	private JLabel jLbCodBarras = null;
	private JLabel jLbQnt = null;
	private JTextField jTfFilial = null;
	private JTextField jTfItem = null;
	private JTextField jCbDescricao = null;
	private JTextField jTfCodBarras = null;
	private JTextField jTfQnt = null;
	private JButton jBtIncluir = null;
	private JButton jBtExcluir = null;
	private JButton jBtLimpar = null;
	private JButton jBtLimparLista = null;
	private JButton jBtNota = null;
	private JButton jBtOrcamento = null;
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
	private JLabel jLbPreco1 = null;
	private JTextField jTfPreco = null;
	private JTextField jTfFilial1 = null;
	private ArrayList<Itens> listaItem = new ArrayList<Itens>();  //  //  @jve:decl-index=0:
	private int seq = 1;
	private JCheckBox jChBUnidade = null;
	private String und;
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
	private JTextField jTfVerificador = null;
	private JLabel jLbProduto = null;
	private JTextField jTfProduto = null;
	private JTextField jTfProdVerificador = null;
	private JLabel jbEstoque = null;
	private JTextField jTfEstoque = null;
	/**
	 * This is the default constructor
	 */
	public Etiqueta() {
		super();
		initialize();
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
		this.setTitle("Emiss\u00E3o de Etiquetas");
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
			jbEstoque = new JLabel();
			jbEstoque.setBounds(new Rectangle(586, 69, 92, 16));
			jbEstoque.setFont(new Font("arial", Font.BOLD, 11));
			jbEstoque.setHorizontalAlignment(SwingConstants.RIGHT);
			jbEstoque.setText("Estoque D:");
			jLbProduto = new JLabel();
			jLbProduto.setBounds(new Rectangle(586, 50, 90, 16));
			jLbProduto.setFont(new Font("arial", Font.BOLD, 11));
			jLbProduto.setHorizontalAlignment(SwingConstants.RIGHT);
			jLbProduto.setText("Produto:");
			jLbPreco1 = new JLabel();
			jLbPreco1.setBounds(new Rectangle(585, 27, 91, 16));
			jLbPreco1.setFont(new Font("arial", Font.BOLD, 11));
			jLbPreco1.setHorizontalAlignment(SwingConstants.RIGHT);
			jLbPreco1.setText("Pre\u00E7o:");
			jLbPreco = new JLabel();
			jLbPreco.setBounds(new Rectangle(521, 484, 45, 16));
			jLbPreco.setFont(new Font("arial", Font.BOLD, 11));
			jLbPreco.setHorizontalAlignment(SwingConstants.RIGHT);
			jLbPreco.setText("Pre\u00E7o:");
			jLbImpressora = new JLabel();
			jLbImpressora.setBounds(new Rectangle(29, 503, 107, 16));
			jLbImpressora.setFont(new Font("arial", Font.BOLD, 11));
			jLbImpressora.setHorizontalAlignment(SwingConstants.RIGHT);
			jLbImpressora.setText("Impressora:");
			jLbTipoEtiqueta = new JLabel();
			jLbTipoEtiqueta.setBounds(new Rectangle(29, 484, 107, 16));
			jLbTipoEtiqueta.setFont(new Font("arial", Font.BOLD, 11));
			jLbTipoEtiqueta.setHorizontalAlignment(SwingConstants.RIGHT);
			jLbTipoEtiqueta.setText("Tipo da Etiqueta:");
			jLbEtiqImpressao = new JLabel();
			jLbEtiqImpressao.setBounds(new Rectangle(313, 178, 187, 16));
			jLbEtiqImpressao.setFont(new Font("Dialog", Font.BOLD, 12));
			jLbEtiqImpressao.setForeground(SystemColor.activeCaption);
			jLbEtiqImpressao.setText("Etiquetas para Impress\u00E3o");
			jLbQnt = new JLabel();
			jLbQnt.setBounds(new Rectangle(72, 102, 63, 16));
			jLbQnt.setFont(new Font("arial", Font.BOLD, 11));
			jLbQnt.setHorizontalAlignment(SwingConstants.RIGHT);
			jLbQnt.setText("Qnt: <F6>");
			jLbCodBarras = new JLabel();
			jLbCodBarras.setBounds(new Rectangle(28, 85, 107, 16));
			jLbCodBarras.setFont(new Font("arial", Font.BOLD, 11));
			jLbCodBarras.setHorizontalAlignment(SwingConstants.RIGHT);
			jLbCodBarras.setText("C\u00F3d.Barras: <F5>");
			jLbDescricao = new JLabel();
			jLbDescricao.setBounds(new Rectangle(27, 66, 109, 16));
			jLbDescricao.setFont(new Font("arial", Font.BOLD, 11));
			jLbDescricao.setHorizontalAlignment(SwingConstants.RIGHT);
			jLbDescricao.setText("Descri\u00E7\u00E3o: <F4>");
			jLbItem = new JLabel();
			jLbItem.setBounds(new Rectangle(69, 48, 67, 16));
			jLbItem.setFont(new Font("arial", Font.BOLD, 11));
			jLbItem.setHorizontalAlignment(SwingConstants.RIGHT);
			jLbItem.setText("Item: <F3>");
			jLbFilial = new JLabel();
			jLbFilial.setBounds(new Rectangle(71, 29, 67, 16));
			jLbFilial.setFont(new Font("arial", Font.BOLD, 11));
			jLbFilial.setHorizontalAlignment(SwingConstants.RIGHT);
			jLbFilial.setText("Filial: <F2>");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLbFilial, null);
			jContentPane.add(jLbItem, null);
			jContentPane.add(jLbDescricao, null);
			jContentPane.add(jLbCodBarras, null);
			jContentPane.add(jLbQnt, null);
			jContentPane.add(getJTfFilial(), null);
			jContentPane.add(getJTfItem(), null);
			jContentPane.add(getJCbDescricao(), null);
			jContentPane.add(getJTfCodBarras(), null);
			jContentPane.add(getJTfQnt(), null);
			jContentPane.add(getJBtIncluir(), null);
			jContentPane.add(getJBtExcluir(), null);
			jContentPane.add(getJBtLimpar(), null);
			jContentPane.add(getJBtLimparLista(), null);
			jContentPane.add(getJBtNota(), null);
			jContentPane.add(getJBtOrcamento(), null);
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
			jContentPane.add(jLbPreco1, null);
			jContentPane.add(getJTfPreco(), null);
			jContentPane.add(getJTfFilial1(), null);
			jContentPane.add(getJTfVerificador(), null);
			jContentPane.add(jLbProduto, null);
			jContentPane.add(getJTfProduto(), null);
			jContentPane.add(getJTfProdVerificador(), null);
			jContentPane.add(jbEstoque, null);
			jContentPane.add(getJTfEstoque(), null);	
			
			JLabel lblUnidade = new JLabel("Unidade:");
			lblUnidade.setFont(new Font("Arial", Font.BOLD, 11));
			lblUnidade.setBounds(521, 504, 57, 14);
			jContentPane.add(lblUnidade);
			
			jChBUnidade = new JCheckBox("");
			jChBUnidade.setBounds(567, 500, 21, 23);
			jContentPane.add(jChBUnidade);
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
			jTfFilial.setBounds(new Rectangle(143, 24, 76, 20));
			jTfFilial.addKeyListener(new java.awt.event.KeyAdapter() {   
				public void keyPressed(java.awt.event.KeyEvent e) {    
						if (e.getKeyCode() == KeyEvent.VK_F2)
						{
							jTfFilial.requestFocus();
						}
						if (e.getKeyCode() == KeyEvent.VK_F3)
						{
							jTfItem.requestFocus();
						}
						if (e.getKeyCode() == KeyEvent.VK_F4)
						{
							jCbDescricao.requestFocus();
						}
						if (e.getKeyCode() == KeyEvent.VK_F5)
						{
							jTfCodBarras.requestFocus();
						}
						if (e.getKeyCode() == KeyEvent.VK_F6)
						{
							jTfQnt.requestFocus();
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
				}
				public void keyTyped(java.awt.event.KeyEvent e) {
					if (jTfFilial.getText().equals("1")){
						jTfFilial1.setText("PJ Center");
						jTfItem.requestFocus();}
					else
						if (jTfFilial.getText().equals("2")){
							jTfFilial1.setText("RJ CONTRUÇÃO");
							jTfItem.requestFocus();}
						else
							if (jTfFilial.getText().equals("3")){
								jTfFilial1.setText("PJ CALÇADOS");
								jTfItem.requestFocus();}
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
	private JTextField getJTfItem() {
		if (jTfItem == null) {
			jTfItem = new JTextField();
			jTfItem.setLocation(new Point(143, 44));
			jTfItem.setSize(new Dimension(76, 20));
			jTfItem.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent e) {	
					if (e.getKeyCode() == KeyEvent.VK_ENTER)
					{
						try{
							CtrlItens descricao = new CtrlItens();
							for(Iterator it=descricao.getItens(jTfFilial.getText(),jTfItem.getText()).iterator();it.hasNext();)
							{
								Itens item = (Itens)it.next();
								listaItem.add(item);
							}
						for(Iterator<Itens> it=listaItem.iterator();it.hasNext();)
						{
							Itens itens = (Itens)it.next();
							if(itens.getItem()==Integer.parseInt(jTfItem.getText()))
							{
								NumberFormat nf = NumberFormat.getCurrencyInstance();
								jCbDescricao.setText(itens.getDescricao());
								jTfCodBarras.setText(itens.getCod_barras());
								String aux="";
								try{
							       aux = nf.format(Double.parseDouble(itens.getPreco())); }
							        catch(NumberFormatException x){
							        	String valor="";
							        	char[] prec = new char[itens.getPreco().length()];
							        	for(int i=0;i<itens.getPreco().length();i++)
							        	{
							        		prec[i]= itens.getPreco().charAt(i);
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
							            aux = nf.format(Double.parseDouble(valor));
							        	}
								jTfPreco.setText(aux);
								jTfVerificador.setText(itens.getVerificador());
								jTfProduto.setText(itens.getProduto());
								jTfProdVerificador.setText(itens.getProdVerificador());
								jTfEstoque.setText(itens.getEstoque());
								und = itens.getUndMaior();
								jTfQnt.requestFocus();
							}
						}
						}catch(Exception x){javax.swing.JOptionPane.showMessageDialog(null,"Item inválido!");}
					}
				}
			});
			jTfItem.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_F2)
					{
						jTfFilial.requestFocus();
					}
					if (e.getKeyCode() == KeyEvent.VK_F3)
					{
						jTfItem.requestFocus();
					}
					if (e.getKeyCode() == KeyEvent.VK_F4)
					{
						jCbDescricao.requestFocus();
					}
					if (e.getKeyCode() == KeyEvent.VK_F5)
					{
						jTfCodBarras.requestFocus();
					}
					if (e.getKeyCode() == KeyEvent.VK_F6)
					{
						jTfQnt.requestFocus();
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
				}
			});
		}
		return jTfItem;
	}
	/**
	 * This method initializes jCbDescricao	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JTextField getJCbDescricao() {
		if (jCbDescricao == null) {
			jCbDescricao = new JTextField();
			jCbDescricao.setBounds(new Rectangle(143, 64, 400, 20));
			jCbDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_F2)
					{
						jTfFilial.requestFocus();
					}
					if (e.getKeyCode() == KeyEvent.VK_F3)
					{
						jTfItem.requestFocus();
					}
					if (e.getKeyCode() == KeyEvent.VK_F4)
					{
						jCbDescricao.requestFocus();
					}
					if (e.getKeyCode() == KeyEvent.VK_F5)
					{
						jTfCodBarras.requestFocus();
					}
					if (e.getKeyCode() == KeyEvent.VK_F6)
					{
						jTfQnt.requestFocus();
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
				}
			});
			/*jCbDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER)
					{
						try{
							CtrlItens descricao = new CtrlItens();
							for(Iterator it=descricao.getDescricao(jTfFilial.getText(),jCbDescricao.getText()).iterator();it.hasNext();)
							{
								Itens item = (Itens)it.next();
								listaItem.add(item);
							}
						for(Iterator<Itens> it=listaItem.iterator();it.hasNext();)
						{
							Itens itens = (Itens)it.next();
							if(itens.getDescricao().equals(jCbDescricao.getText()))
							{
								NumberFormat nf = NumberFormat.getCurrencyInstance();
								jTfItem.setText(String.valueOf(itens.getItem()));
								jCbDescricao.setText(itens.getDescricao());
								jTfCodBarras.setText(itens.getCod_barras());
								String aux="";
								try{
							       aux = nf.format(Double.parseDouble(itens.getPreco())); }
							        catch(NumberFormatException x){
							        	String valor="";
							        	char[] prec = new char[itens.getPreco().length()];
							        	for(int i=0;i<itens.getPreco().length();i++)
							        	{
							        		prec[i]= itens.getPreco().charAt(i);
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
							            aux = nf.format(Double.parseDouble(valor));
							        	}
								jTfPreco.setText(aux);
								jTfVerificador.setText(itens.getVerificador());
								jTfProduto.setText(itens.getProduto());
								jTfProdVerificador.setText(itens.getProdVerificador());
								jTfEstoque.setText(itens.getEstoque());
								jTfQnt.requestFocus();
							}
						}
						}catch(Exception x){javax.swing.JOptionPane.showMessageDialog(null,"ï¿½tem invï¿½lido!");}
					}
				}
			});*/
				
		}
		return jCbDescricao;
	}

	/**
	 * This method initializes jTfCodBarras	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTfCodBarras() {
		if (jTfCodBarras == null) {
			jTfCodBarras = new JTextField();
			jTfCodBarras.setBounds(new Rectangle(143, 85, 226, 20));
			jTfCodBarras.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_F2)
					{
						jTfFilial.requestFocus();
					}
					if (e.getKeyCode() == KeyEvent.VK_F3)
					{
						jTfItem.requestFocus();
					}
					if (e.getKeyCode() == KeyEvent.VK_F4)
					{
						jCbDescricao.requestFocus();
					}
					if (e.getKeyCode() == KeyEvent.VK_F5)
					{
						jTfCodBarras.requestFocus();
					}
					if (e.getKeyCode() == KeyEvent.VK_F6)
					{
						jTfQnt.requestFocus();
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
				}
			});
			jTfCodBarras.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER)
					{
						try{
								CtrlItens descricao = new CtrlItens();
								for(Iterator it=descricao.getCodBarras(jTfFilial.getText(),jTfCodBarras.getText()).iterator();it.hasNext();)
								{
									Itens item = (Itens)it.next();
									listaItem.add(item);
								}
						for(Iterator<Itens> it=listaItem.iterator();it.hasNext();)
						{
							Itens itens = (Itens)it.next();
							if(itens.getCod_barras().equals(jTfCodBarras.getText()))
							{
								NumberFormat nf = NumberFormat.getCurrencyInstance();
								jTfItem.setText(String.valueOf(itens.getItem()));
								jCbDescricao.setText(itens.getDescricao());
								jTfCodBarras.setText(itens.getCod_barras());
								String aux="";
								try{
							       aux = nf.format(Double.parseDouble(itens.getPreco())); }
							        catch(NumberFormatException x){
							        	String valor="";
							        	char[] prec = new char[itens.getPreco().length()];
							        	for(int i=0;i<itens.getPreco().length();i++)
							        	{
							        		prec[i]= itens.getPreco().charAt(i);
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
							            aux = nf.format(Double.parseDouble(valor));
							        	}
								jTfPreco.setText(aux);
								jTfVerificador.setText(itens.getVerificador());
								jTfProduto.setText(itens.getProduto());
								jTfProdVerificador.setText(itens.getProdVerificador());
								jTfEstoque.setText(itens.getEstoque());
								jTfQnt.requestFocus();
							}
						}
						}catch(Exception x){javax.swing.JOptionPane.showMessageDialog(null,"Item inválido!");}
					}
				}
			});
				
		}
		return jTfCodBarras;
	}

	/**
	 * This method initializes jTfQnt	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTfQnt() {
		if (jTfQnt == null) {
			jTfQnt = new JTextField();
			jTfQnt.setLocation(new Point(143, 105));
			jTfQnt.setSize(new Dimension(76, 20));
			jTfQnt.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_F2)
					{
						jTfFilial.requestFocus();
					}
					if (e.getKeyCode() == KeyEvent.VK_F3)
					{
						jTfItem.requestFocus();
					}
					if (e.getKeyCode() == KeyEvent.VK_F4)
					{
						jCbDescricao.requestFocus();
					}
					if (e.getKeyCode() == KeyEvent.VK_F5)
					{
						jTfCodBarras.requestFocus();
					}
					if (e.getKeyCode() == KeyEvent.VK_F6)
					{
						jTfQnt.requestFocus();
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
		return jTfQnt;
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
			jBtIncluir.setLocation(new Point(26, 134));
			jBtIncluir.setFont(new Font("arial", Font.BOLD, 11));
			jBtIncluir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
				try {
					if(jCbDescricao.getText().equals("")|| jTfCodBarras.getText().equals("") || jTfPreco.getText().equals("")|| jTfQnt.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Preencher a Quantidade!");
					}else{
						String[] linha = new String[6];//crio uma nova linha para a tabela com 5 elementos // TODO Auto-generated Event stub actionPerformed()
						linha[0]=Integer.toString(seq);
					    linha[1]=jCbDescricao.getText();  
					    linha[2]=jTfCodBarras.getText();  
					    linha[3]=jTfPreco.getText(); 
					    linha[4]=jTfQnt.getText(); 
					    linha[5]=und;
					    
					    dtmc.addRow( linha );//Adiciono a linha que eu criei na tabela
					    jTbEtiquetas.setModel(dtmc);
					    seq++;
					    
					    jCbDescricao.setText("");
					    jTfItem.setText("");
						jTfPreco.setText("");
						jTfQnt.setText("");
						jTfCodBarras.setText("");
						jTfVerificador.setText("");
						jTfProduto.setText("");
						jTfProdVerificador.setText("");
						jTfEstoque.setText("");
						jTfItem.requestFocus();
					}
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "Preencher todos os campos!");
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
			jBtExcluir.setLocation(new Point(132, 134));
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
			jBtLimpar.setSize(new Dimension(112, 36));
			jBtLimpar.setFont(new Font("Arial", Font.BOLD, 11));
			jBtLimpar.setLocation(new Point(246, 134));
			jBtLimpar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jCbDescricao.setText("");
		            jTfItem.setText("");
					jTfPreco.setText("");
					jTfQnt.setText("");
					jTfCodBarras.setText("");
					jTfVerificador.setText("");
					jTfProduto.setText("");
					jTfProdVerificador.setText("");
					jTfEstoque.setText("");
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
			jBtLimparLista.setBounds(new Rectangle(359, 134, 112, 36));
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
	 * This method initializes jBtNota	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJBtNota() {
		if (jBtNota == null) {
			jBtNota = new JButton();
			jBtNota.setText("<html><center>Buscar pela<br>Nota</center></html>");
			jBtNota.setBounds(new Rectangle(472, 134, 106, 36));
			jBtNota.setFont(new Font("arial", Font.BOLD, 11));
			jBtNota.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					NotaFiscal nota = new NotaFiscal();
				}
			});
		}
		return jBtNota;
	}

	/**
	 * This method initializes jBtOrÃ§amento	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJBtOrcamento() {
		if (jBtOrcamento == null) {
			jBtOrcamento = new JButton();
			jBtOrcamento.setText("<html><center>Buscar pelo<br>Or\u00E7amento</center></html>");
			jBtOrcamento.setBounds(new Rectangle(579, 134, 105, 36));
			jBtOrcamento.setFont(new Font("arial", Font.BOLD, 11));
			jBtOrcamento.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					TelaOrcamento orc = new TelaOrcamento();
				}
			});
		}
		return jBtOrcamento;
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
			jBtSair.setBounds(new Rectangle(685, 134, 69, 36));
			jBtSair.setFont(new Font("arial", Font.BOLD, 11));
			jBtSair.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose(); // TODO Auto-generated Event stub actionPerformed()
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
			jScrollPane.setBounds(new Rectangle(27, 199, 732, 274));
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
		       dtmc.addColumn("Seq");  
		       dtmc.addColumn("Descrição");  
		       dtmc.addColumn("CodBarra");  
		       dtmc.addColumn("Preço");  
		       dtmc.addColumn("Qnt");
		       dtmc.addColumn("Und");
		       jTbEtiquetas.setModel(dtmc);
		       jTbEtiquetas.getColumn("Seq").setPreferredWidth(90);
		       jTbEtiquetas.getColumn("Descrição").setPreferredWidth(335);
		       jTbEtiquetas.getColumn("CodBarra").setPreferredWidth(134);
		       jTbEtiquetas.getColumn("Preço").setPreferredWidth(85);
		       jTbEtiquetas.getColumn("Qnt").setPreferredWidth(85);
		       jTbEtiquetas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		       
		       
		}
		return jTbEtiquetas;
	}
	
	private JComboBox getJCbTipoEtiqueta() {
		String tipo[] = {"eletro", "geral","gondola", "jóias","roupas","suporte"};
		if (jCbTipoEtiqueta == null) {
			jCbTipoEtiqueta = new JComboBox(tipo);
			jCbTipoEtiqueta.setPreferredSize(new Dimension(200, 20));
			jCbTipoEtiqueta.setSize(new Dimension(250, 20));
			jCbTipoEtiqueta.setLocation(new Point(140, 481));
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
			jCbImpressora.setLocation(new Point(140,502));
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
			jBtImprimir.setLocation(new Point(393, 481));
			jBtImprimir.setFont(new Font("arial", Font.BOLD, 11));
			jBtImprimir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int numLinhas = jTbEtiquetas.getModel().getRowCount();
					int i = 0;
					ArrayList<String[]> tabela = new ArrayList<String[]>();
					while(i<numLinhas)
					{
						String[] linha = new String[6];
						for(int j=0;j<6;j++)
						{
							linha[j]=String.valueOf(jTbEtiquetas.getModel().getValueAt(i, j));
						}
						for(int k=0; k<Integer.parseInt(linha[4]);k++)
							tabela.add(linha);
						i++;
					}
					CtrlItens ctrl=new CtrlItens();
					try {
						ctrl.impressao(tabela,String.valueOf(jCbTipoEtiqueta.getSelectedItem()),jCbImpressora.getSelectedIndex() ,jChBPreco.isSelected(), jChBUnidade.isSelected() );
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
			jChBPreco.setBounds(new Rectangle(567, 482, 21, 21));
		}
		return jChBPreco;
	}

	/**
	 * This method initializes jTfPreco	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTfPreco() {
		if (jTfPreco == null) {
			jTfPreco = new JTextField();
			jTfPreco.setLocation(new Point(678, 26));
			jTfPreco.setSize(new Dimension(88, 20));
		}
		return jTfPreco;
	}

	/**
	 * This method initializes jTfFilial1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTfFilial1() {
		if (jTfFilial1 == null) {
			jTfFilial1 = new JTextField();
			jTfFilial1.setBounds(new Rectangle(219, 24, 322, 20));
			jTfFilial1.setEnabled(false);
		}
		return jTfFilial1;
	}

	/**
	 * This method initializes jTfVerificador	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTfVerificador() {
		if (jTfVerificador == null) {
			jTfVerificador = new JTextField();
			jTfVerificador.setBounds(new Rectangle(219, 44, 21, 20));
		}
		return jTfVerificador;
	}

	/**
	 * This method initializes jTfProduto	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTfProduto() {
		if (jTfProduto == null) {
			jTfProduto = new JTextField();
			jTfProduto.setBounds(new Rectangle(678, 47, 67, 20));
		}
		return jTfProduto;
	}

	/**
	 * This method initializes jTfProdVerificador	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTfProdVerificador() {
		if (jTfProdVerificador == null) {
			jTfProdVerificador = new JTextField();
			jTfProdVerificador.setBounds(new Rectangle(745, 47, 21, 20));
		}
		return jTfProdVerificador;
	}

	/**
	 * This method initializes jTfEstoque	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTfEstoque() {
		if (jTfEstoque == null) {
			jTfEstoque = new JTextField();
			jTfEstoque.setBounds(new Rectangle(678, 67, 88, 20));
		}
		return jTfEstoque;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
