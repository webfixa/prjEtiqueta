package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.joda.time.DateTime;

public class DaoMalaDireta {

	public static ArrayList<Cliente> pegaCliente(String codigo) {
		try {
			// LerXml.LendoXml();
			// Class.forName("net.sourceforge.jtds.jdbc.Driver");
			// //com.microsoft.sqlserver.jdbc.SQLServerDriver
			// Connection con =
			// DriverManager.getConnection("jdbc:jtds:sqlserver://"+LerXml.SERVIDOR+":1433/"+LerXml.BANCO+";user="+LerXml.USUARIO+";password="+LerXml.SENHA+"");//jdbc:sqlserver://localhost:1433;databaseName=travel;selectMethod=cursor
			Class.forName("com.mysql.jdbc.Driver"); // com.microsoft.sqlserver.jdbc.SQLServerDriver
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost/pjetiqueta", "root", "senhaadmin");// jdbc:sqlserver://localhost:1433;databaseName=travel;selectMethod=cursor
			Statement stm = con.createStatement();
			ResultSet rs = stm
					.executeQuery("select * from CAD_CLIENTE where CODIGO = "
							+ codigo);

			ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setCodigo(Integer.parseInt(rs.getString("CODIGO")));
				cliente.setNome(rs.getString("NOMCLI"));
				cliente.setEndereco(rs.getString("ENDERECO"));
				cliente.setLogradouro(rs.getString("CODLOGRAD"));
				cliente.setNumero(rs.getString("NUMERO"));
				cliente.setBairro(rs.getString("BAIRRO"));
				cliente.setCidade(rs.getString("CIDADE"));
				cliente.setEstado(rs.getString("ESTADO"));
				cliente.setCep(rs.getString("CEP"));
				cliente.setReferencia(rs.getString("REFER"));
				cliente.setComplemento(rs.getString("COMPLEMENTO"));
				cliente.setTipoEndereco(rs.getString("TPENDER"));
				listaClientes.add(cliente);
			}
			con.close();
			return listaClientes;
		} catch (Exception e) {
			System.out.println("Houve um erro:" + e.getMessage());
			return null;
		}

	}

	public static int salvarLista(String nomeLista, ArrayList<Cliente> clientes) {

		try {
			Class.forName("com.mysql.jdbc.Driver"); // com.microsoft.sqlserver.jdbc.SQLServerDriver
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost/pjetiqueta", "root", "senhaadmin");// jdbc:sqlserver://localhost:1433;databaseName=travel;selectMethod=cursor
			PreparedStatement stm = con.prepareStatement("INSERT INTO lista_etiqueta (cod_lista,data,nome_lista) VALUES (null,?,?)");
			DateTime data = new DateTime();
			stm.setString(1, data.toString("dd/MM/yyyy"));
			stm.setString(2, nomeLista);
			int rs = stm
					.executeUpdate();
			if (rs > 0) {
				stm = con.prepareStatement("select cod_lista from lista_etiqueta where data = ? and nome_lista = ?");
				stm.setString(1, data.toString("dd/MM/yyyy"));
				stm.setString(2, nomeLista);
				ResultSet rs2 = stm.executeQuery();
				 if(rs2 != null) {  
		                while(rs2.next()) {
		                	for (Cliente cliente : clientes) {
		    					stm = con.prepareStatement("INSERT INTO item_lista (cod_lista,cod_cliente) VALUES (?,?)");
		    					stm.setInt(1, Integer.parseInt(rs2.getString("cod_lista")));
		    					stm.setInt(2, cliente.getCodigo());
		    					rs = stm.executeUpdate();
		    				}
		                }  
		            }  
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static ArrayList<Lista> pegaLista(String codigo) {
		ArrayList<Lista> listas = new ArrayList<Lista>();
		try{
		Class.forName("com.mysql.jdbc.Driver"); // com.microsoft.sqlserver.jdbc.SQLServerDriver
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/pjetiqueta", "root", "senhaadmin");// jdbc:sqlserver://localhost:1433;databaseName=travel;selectMethod=cursor
		Statement stm = con.createStatement();
		ResultSet rs = stm
				.executeQuery("select * from lista_etiqueta where cod_lista = "
						+ codigo);
		
		while (rs.next()) {
			Lista lista = new Lista();
			lista.setCodigo(rs.getString("cod_lista"));
			lista.setData(rs.getString("data"));
			lista.setNome(rs.getString("nome_lista"));
			ResultSet rs2 = stm.executeQuery("select * from item_lista where cod_lista = "+ lista.getCodigo());
			ArrayList<Cliente> clientes = new ArrayList<Cliente>();
			while (rs2.next()) {
				Cliente cliente = pegaCliente(rs2.getString("cod_cliente")).get(0);
				clientes.add(cliente);
			}
			lista.setClientes(clientes);
			listas.add(lista);
		}
		con.close();
		}catch(Exception e){
			e.printStackTrace();

		}
		return listas;
	}
	
	public static ArrayList<Lista> pegaListaData(String data) {
		ArrayList<Lista> listas = new ArrayList<Lista>();
		try{
		Class.forName("com.mysql.jdbc.Driver"); // com.microsoft.sqlserver.jdbc.SQLServerDriver
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/pjetiqueta", "root", "senhaadmin");// jdbc:sqlserver://localhost:1433;databaseName=travel;selectMethod=cursor
		PreparedStatement stm = con.prepareStatement("select * from lista_etiqueta where data = ?");
		stm.setString(1, data);
		ResultSet rs = stm.executeQuery();
		try{
		while (rs.next()) {
			Lista lista = new Lista();
			lista.setCodigo(rs.getString("cod_lista"));
			lista.setData(rs.getString("data"));
			lista.setNome(rs.getString("nome_lista"));
			listas.add(lista);
		}
		}catch(SQLException e){
			
		}
		con.close();
		}catch(Exception e){
			e.printStackTrace();

		}
		return listas;
	}
	
	public static ArrayList<Cliente> pegaClientes(String codigo){
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		try{
		Class.forName("com.mysql.jdbc.Driver"); // com.microsoft.sqlserver.jdbc.SQLServerDriver
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/pjetiqueta", "root", "senhaadmin");// jdbc:sqlserver://localhost:1433;databaseName=travel;selectMethod=cursor
		Statement stm = con.createStatement();
		ResultSet rs = stm
				.executeQuery("select * from item_lista where cod_lista = "+ codigo);
		
		while (rs.next()) {
		Cliente cliente = pegaCliente(rs.getString("cod_cliente")).get(0);
		clientes.add(cliente);
		}
		con.close();
		}catch(Exception e){
			e.printStackTrace();

		}
		return clientes;
		

	}

}
