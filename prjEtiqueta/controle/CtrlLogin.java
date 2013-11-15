package controle;
import java.io.IOException;

import view.TelaPrograma;
import modelo.DaoLogin;
public class CtrlLogin 
{
	
	public static boolean validarLogin(String login, String senha) throws IOException
	{
		if(DaoLogin.conexaoLogin(login, EncriptaSenha.encripta(senha)))
		{
			TelaPrograma tela = new TelaPrograma();
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public static boolean incluirLogin(String login, String senha) throws IOException
	{
		if(DaoLogin.incluirLogin(login, EncriptaSenha.encripta(senha)))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean alterarLogin(String login, String senha) throws IOException
	{
		if(DaoLogin.alterarLogin(login, EncriptaSenha.encripta(senha)))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
