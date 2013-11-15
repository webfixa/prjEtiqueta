package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import controle.LerXml;

public class DaoNota {
	
	public static ArrayList<Nota> conexao(String filial, String numnota, String dtnota)
	{
		 try 
	      {
			 SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
			 Date data = formatador.parse(dtnota);
			 SimpleDateFormat novoFormatador = new SimpleDateFormat("yyyy-MM-dd");
			 LerXml.LendoXml();
			 Class.forName("net.sourceforge.jtds.jdbc.Driver");  //com.microsoft.sqlserver.jdbc.SQLServerDriver
	         Connection con = DriverManager.getConnection("jdbc:jtds:sqlserver://"+LerXml.SERVIDOR+":1433/"+LerXml.BANCO+";user="+LerXml.USUARIO+";password="+LerXml.SENHA+"");//jdbc:sqlserver://localhost:1433;databaseName=travel;selectMethod=cursor
	         Statement stm = con.createStatement();
	         ResultSet rs = stm.executeQuery("SELECT     dbo.CAD_FILIAL.CODFIL, dbo.CAD_FILIAL.FANTASIA, dbo.ENT_ITENT.ITEM, dbo.ENT_NOTA.TPNOTA, dbo.ENT_NOTA.NUMNOTA, dbo.ENT_NOTA.SERIE, "+
            "dbo.CAD_ITPROD.CODITPROD, dbo.CAD_ITPROD.DIGITPROD, dbo.ENT_NOTA.DTNOTA, dbo.CAD_FORNE.RAZSOC, dbo.CAD_CODBARRA.CODBARRA, "+
            "CONVERT(Varchar(40), dbo.CAD_PROD.DESCRICAO) + ' ' + CONVERT(varchar(15), dbo.CAD_COR.DESCRES) + ' ' + CONVERT(varchar(10), "+
            "dbo.CAD_ESPEC.DESCRES) AS DESCRICAO, dbo.ENT_ITENT.QTRECEB, dbo.CAD_PRECO.PRECO, dbo.CAD_ITPROD.CODPROD, "+
            "dbo.CAD_ITPROD.CODFORNE, dbo.CAD_PROD.DIGPROD, dbo.CAD_ITPROD.CODLINHA, dbo.CAD_ITPROD.CODFAM, dbo.CAD_ITPROD.CODGRUPO, "+ 
            "dbo.CAD_ITPROD.CODSUBGP, CONVERT(Varchar(10), dbo.CAD_ITPROD.CODITPROD) + CONVERT(Varchar(1), dbo.CAD_ITPROD.DIGITPROD) "+
            "AS CODITEM, dbo.CAD_CODBARRA.CODEMBAL "+
"FROM         dbo.ENT_NOTA INNER JOIN "+
            "dbo.ENT_ITENT ON dbo.ENT_NOTA.CODFIL = dbo.ENT_ITENT.CODFIL AND dbo.ENT_NOTA.TPNOTA = dbo.ENT_ITENT.TPNOTA AND "+ 
            "dbo.ENT_NOTA.CODREMET = dbo.ENT_ITENT.CODREMET AND dbo.ENT_NOTA.SERIE = dbo.ENT_ITENT.SERIE AND "+
            "dbo.ENT_NOTA.NUMNOTA = dbo.ENT_ITENT.NUMNOTA INNER JOIN "+
            "dbo.CAD_FILIAL ON dbo.ENT_NOTA.CODFIL = dbo.CAD_FILIAL.CODFIL INNER JOIN "+
            "dbo.CAD_ITPROD ON dbo.ENT_ITENT.CODITPROD = dbo.CAD_ITPROD.CODITPROD INNER JOIN "+
            "dbo.CAD_COR ON dbo.CAD_ITPROD.CODCOR = dbo.CAD_COR.CODCOR INNER JOIN "+
            "dbo.CAD_ESPEC ON dbo.CAD_ITPROD.CODFAM = dbo.CAD_ESPEC.CODFAM AND "+
            "dbo.CAD_ITPROD.ESPECIFIC = dbo.CAD_ESPEC.ESPECIFIC INNER JOIN "+
            "dbo.CAD_PROD ON dbo.CAD_ITPROD.CODPROD = dbo.CAD_PROD.CODPROD INNER JOIN "+
            "dbo.CAD_CODBARRA ON dbo.CAD_ITPROD.CODITPROD = dbo.CAD_CODBARRA.CODITPROD INNER JOIN "+
            "dbo.CAD_PRODLOC ON dbo.CAD_ITPROD.CODITPROD = dbo.CAD_PRODLOC.CODITPROD INNER JOIN "+
            "dbo.CAD_FORNE ON dbo.CAD_ITPROD.CODFORNE = dbo.CAD_FORNE.CODFORNE INNER JOIN "+
            "dbo.CAD_PRECO ON dbo.CAD_FILIAL.CODFIL = dbo.CAD_PRECO.CODFIL AND dbo.ENT_ITENT.CODITPROD = dbo.CAD_PRECO.CODITPROD AND "+ 
            "dbo.CAD_CODBARRA.CODEMBAL = dbo.CAD_PRECO.CODEMBAL "+
"GROUP BY dbo.CAD_FILIAL.CODFIL, dbo.CAD_FILIAL.FANTASIA, dbo.ENT_ITENT.ITEM, dbo.ENT_NOTA.TPNOTA, dbo.ENT_NOTA.NUMNOTA, "+
           "dbo.ENT_NOTA.SERIE, dbo.CAD_ITPROD.CODITPROD, dbo.CAD_ITPROD.DIGITPROD, dbo.ENT_NOTA.DTNOTA, CONVERT(Varchar(40), "+
           "dbo.CAD_PROD.DESCRICAO) + ' ' + CONVERT(varchar(15), dbo.CAD_COR.DESCRES) + ' ' + CONVERT(varchar(10), dbo.CAD_ESPEC.DESCRES), "+
           "dbo.CAD_ITPROD.CODPROD, dbo.CAD_PROD.DIGPROD, dbo.CAD_CODBARRA.CODBARRA, dbo.CAD_FORNE.RAZSOC, CONVERT(Varchar(10), "+
           "dbo.CAD_ITPROD.CODITPROD) + CONVERT(Varchar(1), dbo.CAD_ITPROD.DIGITPROD), dbo.CAD_ITPROD.CODFORNE, dbo.CAD_ITPROD.CODLINHA, "+ 
           "dbo.CAD_ITPROD.CODFAM, dbo.CAD_ITPROD.CODGRUPO, dbo.CAD_ITPROD.CODSUBGP, dbo.ENT_ITENT.QTRECEB, dbo.CAD_PRECO.PRECO, "+
           "dbo.CAD_CODBARRA.CODEMBAL "+
"HAVING      (dbo.CAD_CODBARRA.CODEMBAL = 0) AND (dbo.CAD_FILIAL.CODFIL = "+filial+") AND (dbo.ENT_NOTA.DTNOTA = CONVERT(DATETIME, '"+novoFormatador.format(data)+"', "+
           "102)) AND (dbo.ENT_NOTA.NUMNOTA = "+numnota+")ORDER BY dbo.CAD_ITPROD.CODITPROD, dbo.ENT_ITENT.ITEM ");
            
	         
	         //select * from nota where CODFIL = "+filial+" and NUMNOTA = "+numnota+" and DTNOTA = '"+novoFormatador.format(data)+"'"
	         ArrayList<Nota> listaNota = new ArrayList<Nota>();
	         while(rs.next())
	         {
	        	 Nota notas = new Nota(null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);
	        	 notas.setCoditprod(rs.getString("CODITPROD"));  
	        	 notas.setDescricao(rs.getString("DESCRICAO"));
	        	 notas.setCodbarra(rs.getString("CODBARRA"));
	        	 notas.setCodfil(rs.getString("CODFIL"));
	        	 notas.setPreco(rs.getString("PRECO"));
	        	 notas.setQuantidade(rs.getString("QTRECEB"));
	        	 listaNota.add(notas);
	         }  
	         con.close();
	         return
	       		listaNota;
	       }
	       catch(Exception e)
	       {
	          System.out.println("Houve um erro:" + e.getMessage());
	          return null;
	       }
	       
	}
	
	public static ArrayList<Nota> pegaNotas(String filial, String numnota)
	{
		 try 
	      {
			 LerXml.LendoXml();
			 Class.forName("net.sourceforge.jtds.jdbc.Driver");  //com.microsoft.sqlserver.jdbc.SQLServerDriver
	         Connection con = DriverManager.getConnection("jdbc:jtds:sqlserver://"+LerXml.SERVIDOR+":1433/"+LerXml.BANCO+";user="+LerXml.USUARIO+";password="+LerXml.SENHA+"");//jdbc:sqlserver://localhost:1433;databaseName=travel;selectMethod=cursor
	         Statement stm = con.createStatement();
	         ResultSet rs = stm.executeQuery("SELECT DISTINCT TOP 100 PERCENT dbo.ENT_NOTA.CODFIL, dbo.ENT_NOTA.NUMNOTA, dbo.ENT_NOTA.DTNOTA, dbo.CAD_FORNE.RAZSOC "+
"FROM         dbo.ENT_NOTA INNER JOIN "+
                      "dbo.CAD_TPNOTA ON dbo.ENT_NOTA.TPNOTA = dbo.CAD_TPNOTA.TPNOTA INNER JOIN "+
                      "dbo.CAD_FORNE ON dbo.ENT_NOTA.CODREMET = dbo.CAD_FORNE.CODFORNE "+
"WHERE     (dbo.ENT_NOTA.CODFIL = "+filial+") AND (dbo.ENT_NOTA.NUMNOTA = "+numnota+") "+
"ORDER BY dbo.ENT_NOTA.DTNOTA, dbo.ENT_NOTA.NUMNOTA DESC");//"select * from notas where CODFIL = "+filial+" and NUMNOTA = "+numnota);
	         ArrayList<Nota> listaNota = new ArrayList<Nota>();
	         while(rs.next())
	         {
	        	 Nota notas = new Nota(null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);
	        	 notas.setNumnota(rs.getString("NUMNOTA")); 
	        	 notas.setCodfil(rs.getString("CODFIL"));
	        	 notas.setDtnota(rs.getDate("DTNOTA"));
	        	 notas.setRazsoc(rs.getString("RAZSOC"));
	        	 listaNota.add(notas);
	         }  
	         con.close();
	         return
	       		listaNota;
	       }
	       catch(Exception e)
	       {
	          System.out.println("Houve um erro:" + e.getMessage());
	          return null;
	       }
	       
	}

}
