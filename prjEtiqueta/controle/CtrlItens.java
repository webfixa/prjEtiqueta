package controle;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import modelo.Itens;
import modelo.DaoItens;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import net.sf.jasperreports.view.JasperViewer;


import java.io.File;  
import java.io.FileWriter;  
import java.io.IOException;  

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;


public class CtrlItens 
{

	public CtrlItens() {
		super();
	}
	
	public ArrayList<Itens> getItens(String filial, String item)
	{
		return DaoItens.pegaItem(filial,item);
	}
	
	public ArrayList<Itens> getDescricao(String filial, String descricao)
	{
		return DaoItens.pegaDescricao(filial,descricao);
	}
	
	public ArrayList<Itens> getCodBarras(String filial,String codbarras)
	{
		return DaoItens.pegaCodBarras(filial,codbarras);
	}
	
		
	public void impressao(ArrayList<String[]> tabela, String report, int impressora, boolean impreco, boolean unidade) throws JRException, ClassNotFoundException
	{
		Element impressao = new Element("impressao");
		int i=1;		
		for(Iterator it=tabela.iterator();it.hasNext();)
		{
			String[] linha = (String[])it.next();
			//for(int i=0; i<linha.length;i++)
				//System.out.println(linha[i]);//0-seq/1-descricao/2-codbarras/3-preco/4-qnt
			Element item = new Element("item");   
			Element descricao = new Element("descricao");  
			Element codbarras = new Element("codbarras");  
			Element preco = new Element("preco");
			Element unidmaior = new Element("unidmaior");
			
			item.setAttribute("id", Integer.toString(i));
			
			descricao.setText(linha[1]);
			codbarras.setText(linha[2]);
			if(impreco)
				preco.setText(linha[3]);
			else
				preco.setText(" ");
			unidmaior.setText(linha[5]);
			item.addContent(descricao);  
			item.addContent(codbarras);  
			item.addContent(preco); 
			item.addContent(unidmaior);
			
			impressao.addContent(item);
			i++;
		}
		 //Criando o documento XML (montado)  
		 Document doc = new Document();  
		 doc.setRootElement(impressao);
		 Format format = Format.getPrettyFormat();  
	     format.setEncoding("ISO-8859-1");
		
		//Imprimindo o XML  
		   XMLOutputter xout = new XMLOutputter(format);  
	        try   
	        {  
	            //Criando o arquivo de saida  
	            FileWriter arquivo = new FileWriter  
	            (  
	                    new File("impressao.xml")  
	            );  
	            //Imprimindo o XML no arquivo  
	            xout.output(doc, arquivo);
	        
	            //exibindo o Relatório
	            relatorio(report,impressora,impreco, unidade);
	            
	        } catch (IOException e)   
	        {  
	            e.printStackTrace();  
	        }        
	}
	
	public void relatorio(String report,int impressora, boolean impreco, boolean unidade)throws JRException , ClassNotFoundException
	{
		try 
		{
			String relatorio;
			String printer = "";
			if(impressora == 1){
				printer = "_1";
			}
			String und = "";
			if(unidade){
				und = "_um";
			}
			
			//Caminho do arquivo Boletim.jasper (bytecode gerado/compilado do nosso relatorio Boletim.jrxml)
			if(impreco)
				relatorio = System.getProperty("user.dir") + "/arquivos/"+report+printer+und+".jasper";
			else
				relatorio = System.getProperty("user.dir") + "/arquivos/"+report+printer+und+"_sp.jasper";
			
			//Configurando a classe JRXmlDataSource que apontara o caminho do  nosso XML de dados e sua pesquisa XPath geral
			JRXmlDataSource xml = new JRXmlDataSource("impressao.xml","/impressao/item");

			/*Gerando o relatorio (Filling) informando o caminho do relatorio, os parametros
			(neste caso nenhum paramentro esta sendo passado ao relatorio, por isso o HashMap esta vazio)
			e o objeto JRXmlDataSource configurado)*/
			JasperPrint jp = JasperFillManager.fillReport(relatorio, new HashMap<String,Integer>(),xml);

			//Utilizando o JasperView, uma classe desktop do jasper para visualização dos relatorios		
			JasperViewer.viewReport(jp,false);			
		
		} catch (JRException e) 
			{
				e.printStackTrace();
			}
	}
}
/**

import java.io.File;  
import java.io.FileWriter;  
import java.io.IOException;  
import org.jdom.Document;  
import org.jdom.Element;  
import org.jdom.output.XMLOutputter;  

  //Declara��o dos elementos que ir�o compor a estrutura do documento.  
   Element mural = new Element("mural");  
   Element mensagem = new Element("mensagem");  
   Element para = new Element("para");  
   Element de = new Element("de");  
   Element corpo = new Element("corpo");  
  
   //"Setando" os atributos  
   mensagem.setAttribute("id", "01");  
     
   //"Setando" outro atributo agora utilizando da classe Attribute  
   Attribute prioridade = new Attribute("prioridade","-1");  
   mensagem.setAttribute(prioridade);     
  
   mensagem.addContent(para);  
   mensagem.addContent(de);  
   mensagem.addContent(corpo);  
     
   mural.addContent(mensagem);  
        
   //Criando o documento XML (montado)  
   Document doc = new Document();  
   doc.setRootElement(mural);  
  
   //Imptrimindo o XML  
   XMLOutputter xout = new XMLOutputter("  ", true);  
   xout.output(doc, System.out);
   
   try   
        {  
            //Criando o arquivo de saida  
            FileWriter arquivo = new FileWriter  
            (  
                    new File("c:/arquivo.xml")  
            );  
            //Imprimindo o XML no arquivo  
            xout.output(documento, arquivo);  
        } catch (IOException e)   
        {  
            e.printStackTrace();  
        }     

_____________________________________________________________________________________________ 
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public void gerar( String layout ) throws JRException , SQLException, ClassNotFoundException {
//gerando o jasper design
JasperDesign desenho = JRXmlLoader.load( layout );

//compila o relat�rio
JasperReport relatorio = JasperCompileManager.compileReport( desenho );

//estabelece conex�o
Class.forName( driver );
Connection con = DriverManager.getConnection( url , login , pwd );
Statement stm = con.createStatement();
String query = "select * from turma";
ResultSet rs = stm.executeQuery( query );

//implementa��o da interface JRDataSource para DataSource ResultSet
JRResultSetDataSource jrRS = new JRResultSetDataSource( rs );

//executa o relat�rio
Map parametros = new HashMap();
parametros.put("nota", new Double(10));
JasperPrint impressao = JasperFillManager.fillReport( relatorio , parametros,    jrRS );

//exibe o resultado
JasperViewer viewer = new JasperViewer( impressao , true );
viewer.show();
*/