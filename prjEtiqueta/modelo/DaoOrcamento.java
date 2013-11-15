package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import controle.LerXml;

import modelo.Orcamento;

public class DaoOrcamento {
	
	public static ArrayList<Orcamento> conexao(String filial, String numorc)
	{
		 try 
	      {
			 LerXml.LendoXml();
			 Class.forName("net.sourceforge.jtds.jdbc.Driver");  //com.microsoft.sqlserver.jdbc.SQLServerDriver
	         Connection con = DriverManager.getConnection("jdbc:jtds:sqlserver://"+LerXml.SERVIDOR+":1433/"+LerXml.BANCO+";user="+LerXml.USUARIO+";password="+LerXml.SENHA+"");//jdbc:sqlserver://localhost:1433;databaseName=travel;selectMethod=cursor
	         Statement stm = con.createStatement();
	         ResultSet rs = stm.executeQuery("SELECT     TOP 100 PERCENT dbo.CAD_FILIAL.CODFIL, dbo.CAD_FILIAL.FANTASIA, dbo.MOV_ITORC.NUMORC, dbo.MOV_ITORC.CODITPROD, "+
             "dbo.CAD_ITPROD.DIGITPROD, dbo.MOV_ITORC.ITEM, dbo.CAD_CODBARRA.CODBARRA, CONVERT(Varchar(40), dbo.CAD_PROD.DESCRICAO) "+
             "+ ' ' + CONVERT(varchar(15), dbo.CAD_COR.DESCRES) + ' ' + CONVERT(varchar(10), dbo.CAD_ESPEC.DESCRES) AS DESCRICAO, "+
             "dbo.MOV_ITORC.QTCOMP, dbo.CAD_PRECO.PRECO, dbo.CAD_ITPROD.CODPROD, dbo.CAD_PROD.DIGPROD, CONVERT(Varchar(10), "+
             "dbo.CAD_ITPROD.CODITPROD) + CONVERT(Varchar(1), dbo.CAD_ITPROD.DIGITPROD) AS CODITEM "+
"FROM         dbo.MOV_ITORC INNER JOIN "+
             "dbo.CAD_FILIAL ON dbo.MOV_ITORC.CODFIL = dbo.CAD_FILIAL.CODFIL INNER JOIN "+
             "dbo.CAD_ITPROD ON dbo.MOV_ITORC.CODITPROD = dbo.CAD_ITPROD.CODITPROD INNER JOIN "+
             "dbo.CAD_COR ON dbo.CAD_ITPROD.CODCOR = dbo.CAD_COR.CODCOR INNER JOIN "+
             "dbo.CAD_ESPEC ON dbo.CAD_ITPROD.CODFAM = dbo.CAD_ESPEC.CODFAM AND "+
             "dbo.CAD_ITPROD.ESPECIFIC = dbo.CAD_ESPEC.ESPECIFIC INNER JOIN "+
             "dbo.CAD_PROD ON dbo.CAD_ITPROD.CODPROD = dbo.CAD_PROD.CODPROD INNER JOIN "+
             "dbo.CAD_PRECO ON dbo.CAD_ITPROD.CODITPROD = dbo.CAD_PRECO.CODITPROD AND dbo.CAD_FILIAL.CODFIL = dbo.CAD_PRECO.CODFIL AND "+
             "dbo.MOV_ITORC.CODEMBAL = dbo.CAD_PRECO.CODEMBAL RIGHT OUTER JOIN "+
             "dbo.CAD_CODBARRA ON dbo.CAD_ITPROD.CODITPROD = dbo.CAD_CODBARRA.CODITPROD "+
"WHERE     (dbo.MOV_ITORC.NUMORC = '"+numorc+"') "+
"ORDER BY dbo.MOV_ITORC.ITEM");//"select * from orcamento where NUMORC = '"+numorc+"' and CODFIL = "+filial+" order by 6"

	         
	         
	         ArrayList<Orcamento> listaOrc = new ArrayList<Orcamento>();
	         while(rs.next())
	         {
	        	 Orcamento orc = new Orcamento(null,null,null,null,null,null,null,null);
	        	 orc.setQTCOMP(rs.getString("QTCOMP"));  
	        	 orc.setDESCRICAO(rs.getString("DESCRICAO"));
	        	 orc.setCODBARRA(rs.getString("CODBARRA"));
	        	 orc.setCODFIL(rs.getString("CODFIL"));
	        	 orc.setPRECOUNIT(rs.getString("PRECO"));
	        	 orc.setCODITPROD(rs.getString("CODITPROD"));
	        	 listaOrc.add(orc);
	         }  
	         con.close();
	         return
	       		listaOrc;
	       }
	       catch(Exception e)
	       {
	          System.out.println("Houve um erro:" + e.getMessage());
	          return null;
	       }
	       
	}

}
