package controle;

import java.util.ArrayList;
import java.util.HashMap;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import net.sf.jasperreports.view.JasperViewer;

import modelo.Cliente;
import modelo.DaoMalaDireta;
import modelo.Lista;

public class CtrlMalaDireta {

	public ArrayList<Cliente> pegaCodigo(String codigo) {
		return DaoMalaDireta.pegaCliente(codigo);
	}

	public int salvarLista(String nomeLista, ArrayList<Cliente> clientes) {
		return DaoMalaDireta.salvarLista(nomeLista, clientes);
	}

	public ArrayList<Lista> pegaLista(String codigo) {
		return DaoMalaDireta.pegaLista(codigo);
	}

	public ArrayList<Lista> pegaListaData(String data) {
		return DaoMalaDireta.pegaListaData(data);
	}

	public static ArrayList<Cliente> pegaCliente(String codigo) {
		return DaoMalaDireta.pegaClientes(codigo);
	}

	public static void relatorio(int impressora,ArrayList<Cliente> clientes) throws JRException,
			ClassNotFoundException {
		try {
			String relatorio;
			String printer = "";
			if (impressora == 1) {
				printer = "_1";
			}

			// Caminho do arquivo Boletim.jasper (bytecode gerado/compilado do
			// nosso relatorio Boletim.jrxml)

			relatorio = System.getProperty("user.dir") + "/arquivos/cliente_codigo"+ printer + ".jasper";

			JRBeanCollectionDataSource dados = new JRBeanCollectionDataSource(clientes);

			/*
			 * Gerando o relatorio (Filling) informando o caminho do relatorio,
			 * os parametros (neste caso nenhum paramentro esta sendo passado ao
			 * relatorio, por isso o HashMap esta vazio) e o objeto
			 * JRXmlDataSource configurado)
			 */
			JasperPrint jp = JasperFillManager.fillReport(relatorio,
					new HashMap<String, Integer>(), dados);

			// Utilizando o JasperView, uma classe desktop do jasper para
			// visualização dos relatorios
			JasperViewer.viewReport(jp, false);

		} catch (JRException e) {
			e.printStackTrace();
		}
	}

}
