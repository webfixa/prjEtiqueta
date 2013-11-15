package controle;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class LerXml {

public static String SERVIDOR;
public static String BANCO;
public static String USUARIO;
public static String SENHA;
	
public static void LendoXml()	{
	Document doc = null;
    SAXBuilder builder = new SAXBuilder();
    
    try {
        doc = builder.build("arquivos/config.xml");
       } catch (Exception x) {
       
        x.printStackTrace(); }           
   
    Element teste = doc.getRootElement();
    List<Element> lista = teste.getChildren();
    for (Element e: lista ){
          SERVIDOR = e.getChildText("servidor");
          BANCO = e.getChildText("banco");
          USUARIO = e.getChildText("usuario");
          SENHA = e.getChildText("senha");
    }  
    System.out.println(SERVIDOR+" "+BANCO+" "+USUARIO+" "+SENHA);
  }
}