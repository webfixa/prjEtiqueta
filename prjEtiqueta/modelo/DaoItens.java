package modelo;

import java.sql.*;
import java.util.ArrayList;
import controle.LerXml;

public class DaoItens {

	public DaoItens() {
		super();
	}

	public static ArrayList<Itens> pegaItem(String filial, String item) {
		try {
			LerXml.LendoXml();
			Class.forName("net.sourceforge.jtds.jdbc.Driver"); // com.microsoft.sqlserver.jdbc.SQLServerDriver
			Connection con = DriverManager
					.getConnection("jdbc:jtds:sqlserver://" + LerXml.SERVIDOR
							+ ":1433/" + LerXml.BANCO + ";user="
							+ LerXml.USUARIO + ";password=" + LerXml.SENHA + "");// jdbc:sqlserver://localhost:1433;databaseName=travel;selectMethod=cursor
			Statement stm = con.createStatement();
			ResultSet rs = stm
					.executeQuery("SELECT     TOP 100 PERCENT CAD_PRODLOC.CODFIL, CAD_FILIAL.FANTASIA, CAD_ITPROD.CODITPROD, CAD_ITPROD.DIGITPROD, CONVERT(Varchar(40),  "
							+ "CAD_PROD.DESCRICAO) + ' ' + CONVERT(varchar(15), CAD_COR.DESCRES) + ' ' + CONVERT(varchar(10), CAD_ESPEC.DESCRES) AS DESCRICAO,  "
							+ "CAD_PRECO.PRECO, CAD_CODBARRA.CODBARRA, CAD_PRODLOC.FISICO - CAD_PRODLOC.RESFIS AS [EST.DISP], CAD_PROD.CODPROD, "
							+ "CAD_PROD.DIGPROD,  "
							+ "CAD_PROD.CODGRUPO, CAD_LINHA_1.CODLINHA, CAD_PROD.CODFAM, CONVERT(Varchar(10), CAD_ITPROD.CODITPROD) + CONVERT(Varchar(1), "
							+ "CAD_ITPROD.DIGITPROD) AS CODITEM, CAD_EMBAL.UNIDMAIOR "
							+ "FROM         CAD_PROD INNER JOIN "
							+ "CAD_ITPROD ON CAD_PROD.CODPROD = CAD_ITPROD.CODPROD INNER JOIN "
							+ "CAD_COR ON CAD_ITPROD.CODCOR = CAD_COR.CODCOR INNER JOIN "
							+ "CAD_ESPEC ON CAD_ITPROD.ESPECIFIC = CAD_ESPEC.ESPECIFIC AND CAD_ITPROD.CODFAM = CAD_ESPEC.CODFAM INNER JOIN "
							+ "CAD_LINHA ON CAD_PROD.CODLINHA = CAD_LINHA.CODLINHA INNER JOIN "
							+ "CAD_GRUPO ON CAD_PROD.CODFAM = CAD_GRUPO.CODFAM AND CAD_PROD.CODGRUPO = CAD_GRUPO.CODGRUPO AND "
							+ "CAD_ITPROD.CODFAM = CAD_GRUPO.CODFAM AND CAD_ITPROD.CODGRUPO = CAD_GRUPO.CODGRUPO INNER JOIN "
							+ "CAD_PRODLOC ON CAD_ITPROD.CODITPROD = CAD_PRODLOC.CODITPROD INNER JOIN "
							+ "CAD_CODBARRA ON CAD_ITPROD.CODITPROD = CAD_CODBARRA.CODITPROD INNER JOIN "
							+ "CAD_FILIAL ON CAD_PRODLOC.CODFIL = CAD_FILIAL.CODFIL INNER JOIN "
							+ "CAD_LINHA CAD_LINHA_1 ON CAD_PROD.CODLINHA = CAD_LINHA_1.CODLINHA INNER JOIN "
							+ "CAD_EMBAL ON CAD_CODBARRA.CODPROD = CAD_EMBAL.CODPROD AND CAD_CODBARRA.CODEMBAL = CAD_EMBAL.CODEMBAL LEFT OUTER JOIN "
							+ "CAD_PRECO ON CAD_PRODLOC.CODFIL = CAD_PRECO.CODFIL AND CAD_ITPROD.CODITPROD = CAD_PRECO.CODITPROD "
							+ "WHERE     (CAD_PRODLOC.TPDEPOS = 'D') AND (CAD_PRECO.CODEMBAL = 0) AND (CAD_EMBAL.CODEMBAL = 0) "
							+ "GROUP BY CONVERT(Varchar(40), CAD_PROD.DESCRICAO) + ' ' + CONVERT(varchar(15), CAD_COR.DESCRES) + ' ' + CONVERT(varchar(10), CAD_ESPEC.DESCRES), "
							+ "CAD_ITPROD.CODITPROD, CAD_PRODLOC.CODFIL, CAD_PRECO.PRECO, CAD_CODBARRA.CODBARRA, CAD_PRODLOC.FISICO - CAD_PRODLOC.RESFIS, "
							+ "CAD_ITPROD.DIGITPROD, CAD_PROD.CODPROD, CAD_PROD.DIGPROD, CAD_PROD.CODGRUPO, CAD_PROD.CODFAM, CONVERT(Varchar(10),  "
							+ "CAD_ITPROD.CODITPROD) + CONVERT(Varchar(1), CAD_ITPROD.DIGITPROD), CAD_FILIAL.FANTASIA, CAD_LINHA_1.CODLINHA, CAD_EMBAL.UNIDMAIOR "
							+ "HAVING      (CAD_PRODLOC.CODFIL = "
							+ filial
							+ ") AND (CAD_ITPROD.CODITPROD =  '" + item + "')");// "select * from produtos where CODFIL = "+filial+" AND CODITPROD = '"+item+"'"

			ArrayList<Itens> listaItens = new ArrayList<Itens>();
			while (rs.next()) {
				Itens itens = new Itens(0, null, null, 0, 0, null, null, null,
						null, null,null);
				itens.setItem(Integer.parseInt(rs.getString("CODITPROD")));
				itens.setDescricao(rs.getString("DESCRICAO"));
				itens.setCod_barras(rs.getString("CODBARRA"));
				itens.setFilial(Integer.parseInt(rs.getString("CODFIL")));
				itens.setPreco(rs.getString("PRECO"));
				itens.setVerificador(rs.getString("DIGITPROD"));
				itens.setProduto(rs.getString("CODPROD"));
				itens.setProdVerificador(rs.getString("DIGPROD"));
				itens.setEstoque(rs.getString("EST.DISP"));
				itens.setUndMaior(rs.getString("UNIDMAIOR"));
				listaItens.add(itens);
			}
			con.close();
			return listaItens;
		} catch (Exception e) {
			System.out.println("Houve um erro:" + e.getMessage());
			return null;
		}

	}

	public static ArrayList<Itens> pegaDescricao(String filial, String descricao) {
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver"); // com.microsoft.sqlserver.jdbc.SQLServerDriver
			Connection con = DriverManager
					.getConnection("jdbc:jtds:sqlserver://pjfs02:1433/dbGemco;user=SA;password=4710858250");// jdbc:sqlserver://localhost:1433;databaseName=travel;selectMethod=cursor
			Statement stm = con.createStatement();
			ResultSet rs = stm
					.executeQuery("select * from produtos where CODFIL = "
							+ filial + " AND DESCRICAO = '" + descricao + "'");
			ArrayList<Itens> listaItens = new ArrayList<Itens>();
			while (rs.next()) {
				Itens itens = new Itens(0, null, null, 0, 0, null, null, null,
						null, null, null);
				itens.setItem(Integer.parseInt(rs.getString("CODITPROD")));
				itens.setDescricao(rs.getString("DESCRICAO"));
				itens.setCod_barras(rs.getString("CODBARRA"));
				// itens.setQnt(Integer.parseInt(rs.getString("EST_DISP")));
				itens.setFilial(Integer.parseInt(rs.getString("CODFIL")));
				itens.setPreco(rs.getString("PRECO"));
				itens.setVerificador(rs.getString("DIGITPROD"));
				itens.setProduto(rs.getString("CODPROD"));
				itens.setProdVerificador(rs.getString("DIGPROD"));
				itens.setEstoque(rs.getString("EST.DISP"));
				itens.setUndMaior(rs.getString("UNIDMAIOR"));
				listaItens.add(itens);
			}
			con.close();
			return listaItens;
		} catch (Exception e) {
			System.out.println("Houve um erro:" + e.getMessage());
			return null;
		}

	}

	public static ArrayList<Itens> pegaCodBarras(String filial, String codbarras) {
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver"); // com.microsoft.sqlserver.jdbc.SQLServerDriver
			Connection con = DriverManager
					.getConnection("jdbc:jtds:sqlserver://pjfs02:1433/dbGemco;user=SA;password=4710858250");// jdbc:sqlserver://localhost:1433;databaseName=travel;selectMethod=cursor
			Statement stm = con.createStatement();
			ResultSet rs = stm
					.executeQuery("SELECT     TOP 100 PERCENT dbo.CAD_PRODLOC.CODFIL, dbo.CAD_FILIAL.FANTASIA, dbo.CAD_ITPROD.CODITPROD, dbo.CAD_ITPROD.DIGITPROD, "
							+ "CONVERT(Varchar(40), dbo.CAD_PROD.DESCRICAO) + ' ' + CONVERT(varchar(15), dbo.CAD_COR.DESCRES) + ' ' + CONVERT(varchar(10), "
							+ "dbo.CAD_ESPEC.DESCRES) AS DESCRICAO, dbo.CAD_PRECO.PRECO, dbo.CAD_CODBARRA.CODBARRA, "
							+ "dbo.CAD_PRODLOC.FISICO - dbo.CAD_PRODLOC.RESFIS AS [EST.DISP], dbo.CAD_PROD.CODPROD, dbo.CAD_PROD.DIGPROD, "
							+ "dbo.CAD_PROD.CODGRUPO, CAD_LINHA_1.CODLINHA, dbo.CAD_PROD.CODFAM, CONVERT(Varchar(10), dbo.CAD_ITPROD.CODITPROD) "
							+ "+ CONVERT(Varchar(1), dbo.CAD_ITPROD.DIGITPROD) AS CODITEM "
							+ "FROM       dbo.CAD_PROD INNER JOIN "
							+ "dbo.CAD_ITPROD ON dbo.CAD_PROD.CODPROD = dbo.CAD_ITPROD.CODPROD INNER JOIN "
							+ "dbo.CAD_COR ON dbo.CAD_ITPROD.CODCOR = dbo.CAD_COR.CODCOR INNER JOIN "
							+ "dbo.CAD_ESPEC ON dbo.CAD_ITPROD.ESPECIFIC = dbo.CAD_ESPEC.ESPECIFIC AND "
							+ "dbo.CAD_ITPROD.CODFAM = dbo.CAD_ESPEC.CODFAM INNER JOIN "
							+ "dbo.CAD_LINHA ON dbo.CAD_PROD.CODLINHA = dbo.CAD_LINHA.CODLINHA INNER JOIN "
							+ "dbo.CAD_GRUPO ON dbo.CAD_PROD.CODFAM = dbo.CAD_GRUPO.CODFAM AND dbo.CAD_PROD.CODGRUPO = dbo.CAD_GRUPO.CODGRUPO AND "
							+ "dbo.CAD_ITPROD.CODFAM = dbo.CAD_GRUPO.CODFAM AND dbo.CAD_ITPROD.CODGRUPO = dbo.CAD_GRUPO.CODGRUPO INNER JOIN "
							+ "dbo.CAD_PRODLOC ON dbo.CAD_ITPROD.CODITPROD = dbo.CAD_PRODLOC.CODITPROD INNER JOIN "
							+ "dbo.CAD_CODBARRA ON dbo.CAD_ITPROD.CODITPROD = dbo.CAD_CODBARRA.CODITPROD INNER JOIN "
							+ "dbo.CAD_FILIAL ON dbo.CAD_PRODLOC.CODFIL = dbo.CAD_FILIAL.CODFIL INNER JOIN "
							+ "dbo.CAD_LINHA CAD_LINHA_1 ON dbo.CAD_PROD.CODLINHA = CAD_LINHA_1.CODLINHA LEFT OUTER JOIN "
							+ "dbo.CAD_PRECO ON dbo.CAD_PRODLOC.CODFIL = dbo.CAD_PRECO.CODFIL AND "
							+ "dbo.CAD_ITPROD.CODITPROD = dbo.CAD_PRECO.CODITPROD "
							+ "WHERE     (dbo.CAD_PRODLOC.TPDEPOS = 'D') AND (dbo.CAD_PRECO.CODEMBAL = 0) "
							+ "GROUP BY CONVERT(Varchar(40), dbo.CAD_PROD.DESCRICAO) + ' ' + CONVERT(varchar(15), dbo.CAD_COR.DESCRES) + ' ' + CONVERT(varchar(10), "
							+ "dbo.CAD_ESPEC.DESCRES), dbo.CAD_ITPROD.CODITPROD, dbo.CAD_PRODLOC.CODFIL, dbo.CAD_PRECO.PRECO, dbo.CAD_CODBARRA.CODBARRA, "
							+ "dbo.CAD_PRODLOC.FISICO - dbo.CAD_PRODLOC.RESFIS, dbo.CAD_ITPROD.DIGITPROD, dbo.CAD_PROD.CODPROD, dbo.CAD_PROD.DIGPROD, "
							+ "dbo.CAD_PROD.CODGRUPO, dbo.CAD_PROD.CODFAM, CONVERT(Varchar(10), dbo.CAD_ITPROD.CODITPROD) + CONVERT(Varchar(1), "
							+ "dbo.CAD_ITPROD.DIGITPROD), dbo.CAD_FILIAL.FANTASIA, CAD_LINHA_1.CODLINHA "
							+ "HAVING      (dbo.CAD_PRODLOC.CODFIL = "
							+ filial
							+ ") AND (dbo.CAD_CODBARRA.CODBARRA = '"
							+ codbarras + "')");// "select * from produtos where CODFIL = "+filial+" AND CODBARRA = '"+codbarras+"'"

			ArrayList<Itens> listaItens = new ArrayList<Itens>();
			while (rs.next()) {
				Itens itens = new Itens(0, null, null, 0, 0, null, null, null,
						null, null, null);
				itens.setItem(Integer.parseInt(rs.getString("CODITPROD")));
				itens.setDescricao(rs.getString("DESCRICAO"));
				itens.setCod_barras(rs.getString("CODBARRA"));
				// itens.setQnt(Integer.parseInt(rs.getString("EST_DISP")));
				itens.setFilial(Integer.parseInt(rs.getString("CODFIL")));
				itens.setPreco(rs.getString("PRECO"));
				itens.setVerificador(rs.getString("DIGITPROD"));
				itens.setProduto(rs.getString("CODPROD"));
				itens.setProdVerificador(rs.getString("DIGPROD"));
				itens.setEstoque(rs.getString("EST.DISP"));
				listaItens.add(itens);
			}
			con.close();
			return listaItens;
		} catch (Exception e) {
			System.out.println("Houve um erro:" + e.getMessage());
			return null;
		}

	}
}
