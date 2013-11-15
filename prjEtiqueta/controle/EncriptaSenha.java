package controle;

import java.security.MessageDigest;      
import java.security.NoSuchAlgorithmException;      
 
import sun.misc.BASE64Encoder;            
    
public class EncriptaSenha {     
 
/*     public static String encripta (String senha) {     
          try {     
               MessageDigest digest = MessageDigest.getInstance("MD5");      
               digest.update(senha.getBytes());      
               BASE64Encoder encoder = new BASE64Encoder();      
               return encoder.encode (digest.digest());      
          } catch (NoSuchAlgorithmException ns) {     
               ns.printStackTrace();      
               return senha;      
          }      
     }*/
     
     public static String encripta(String senha) {  
    	   //Quando se aplica o md5sum (do linux) colocando a senha em um arquivo,  
    	        //deve-se lembrar que o flag de fim de arquivo '0x0A' é também usado no  
    	        //cálculo. Para obter o mesmo resultado com este algoritmo, descomente  
    	        //as próximas duas linhas para incluir o 0x0A na senha.  
    	        //String flagFimDeArquivo = Character.toString((char) 0x0A);  
    	        //senha = senha + flagFimDeArquivo;  
    	        //  
    	        MessageDigest md = null;  
    	        try {  
    	            md = MessageDigest.getInstance("MD5");  
    	        } catch (NoSuchAlgorithmException e) {  
    	       //prefiro isso na fase de teste pois evita tratar acima...  
    	            System.out.println("Ocorreu NoSuchAlgorithmException");  
    	        }  
    	        md.update(senha.getBytes());  
    	        byte[] xx = md.digest();  
    	        //---------------------------------------  
    	        //Converte byte[] para um String de hexa:  
    	        //---------------------------------------  
    	        String n2 = null;  
    	        StringBuffer resposta = new StringBuffer();  
    	        for (int i = 0; i < xx.length; i++) {//para todos os bytes...  
    	            //Obtém apenas o último byte do Integer.  
    	            //O AND com 0xFF elimina a propagação do sinal  
    	            //negativo que preenche todos os outros bytes  
    	            //do int com ffffff.  
    	            n2 = Integer.toHexString(0XFF & ((int) (xx[i])));  
    	            //Evita um único caracter no hexa colocando zero antes.  
    	            if (n2.length() < 2) {  
    	                n2 = "0" + n2;  
    	            }  
    	            resposta.append(n2);  
    	        }  
    	        //System.out.println("<" + resposta.toString() + ">");  
    	        //---------------------------------------  
    	        return resposta.toString();  
    	    }  
}   