package com.casetas.ficheros;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.casetas.model.Calle;
import com.casetas.model.Caseta;
import com.casetas.model.CasetaComparator;

public class XMLReader {
	
	public static Map<Calle, List<Caseta>> cargarCasetas(String path){
		Map<Calle, List<Caseta>> callesYCasetas = new HashMap<>();
		
		File fichero = new File(path);
		
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document documento = builder.parse(fichero);
			documento.getDocumentElement().normalize();
			
			
			NodeList listaNodosDatos = documento.getElementsByTagName("DatosLeidos");
			
			for(int i=0; i<listaNodosDatos.getLength();i++) {
				Element nodo = (Element)listaNodosDatos.item(i);
				
				
				int idCaseta = Integer.parseInt(nodo.getElementsByTagName("ID").item(0).getTextContent());
				String nombreCaseta = nodo.getElementsByTagName("TITULO").item(0).getTextContent();
				int numeroCaseta = Integer.parseInt(nodo.getElementsByTagName("NUMERO").item(0).getTextContent());
				int modulos = Integer.parseInt(nodo.getElementsByTagName("MODULOS").item(0).getTextContent());
				String clase = nodo.getElementsByTagName("CLASE").item(0).getTextContent();
				int idCalle = Integer.parseInt(nodo.getElementsByTagName("ID_CALLE").item(0).getTextContent());
				String nombreCalle = nodo.getElementsByTagName("CALLE").item(0).getTextContent();
				
				Calle cll = new Calle(nombreCalle, idCalle);
				Caseta c = new Caseta(idCaseta, nombreCaseta, numeroCaseta, modulos, clase);
				
				if(!callesYCasetas.containsKey(cll)) {
					callesYCasetas.put(cll, new ArrayList());					
				}
				callesYCasetas.get(cll).add(c);
				callesYCasetas.get(cll).sort(new CasetaComparator());
			}
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		
		return callesYCasetas;
	}
	
}
