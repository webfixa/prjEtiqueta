package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import controle.LerXml;

public class DaoLogin {

	public static Login USER = new Login(null,null);
	public static boolean conexaoLogin(String login, String senha)
	{
		try {
			LerXml.LendoXml();
			 Class.forName("net.sourceforge.jtds.jdbc.Driver");  //com.microsoft.sqlserver.jdbc.SQLServerDriver
	         Connection con = DriverManager.getConnection("jdbc:jtds:sqlserver://"+LerXml.SERVIDOR+":1433/"+LerXml.BANCO+";user="+LerXml.USUARIO+";password="+LerXml.SENHA+"");//jdbc:sqlserver://localhost:1433;databaseName=travel;selectMethod=cursor
	        Statement stm = con.createStatement();
	        ResultSet rs = stm.executeQuery("select login,senha from INFO_USER_ETIQUETAS where login = '"+login+"' and senha = '"+senha+"'");
	        if(rs.next())
	        {
	        	USER = new Login(rs.getString("login"),rs.getString("senha"));
	        	con.close();
	        	return true;
	        }else{
	        	con.close();
	        	return false;
	        }
	         
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}  
        
	}
	
	public static boolean incluirLogin(String login, String senha)
	{
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");  //com.microsoft.sqlserver.jdbc.SQLServerDriver
	        Connection con = DriverManager.getConnection("jdbc:jtds:sqlserver://pjfs02:1433/dbGemco;user=SA;password=4710858250");//jdbc:sqlserver://localhost:1433;databaseName=travel;selectMethod=cursor
	        Statement stm = con.createStatement();
	        if(stm.executeUpdate("insert into INFO_USER_ETIQUETAS(login, senha) values ('"+login+"','"+senha+"')")==1)
	        {
	        	con.close();
	        	return true;
	        }else{
	        	con.close();
	        	return false;
	        }
	      
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}  
        
	}
	
	public static boolean alterarLogin(String login, String senha)
	{
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");  //com.microsoft.sqlserver.jdbc.SQLServerDriver
	        Connection con = DriverManager.getConnection("jdbc:jtds:sqlserver://pjfs02:1433/dbGemco;user=SA;password=4710858250");//jdbc:sqlserver://localhost:1433;databaseName=travel;selectMethod=cursor
	        Statement stm = con.createStatement();
	        if(stm.executeUpdate("DELETE FROM INFO_USER_ETIQUETAS WHERE login = '"+USER.login+"' and senha = '"+USER.senha+"'" )==1)
	        {
	        	stm.executeUpdate("insert into INFO_USER_ETIQUETAS(login, senha) values ('"+login+"','"+senha+"')");
	        	con.close();
	        	return true;
	        }else{
	        	con.close();
	        	return false;
	        }
	         
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}  
	}
}
