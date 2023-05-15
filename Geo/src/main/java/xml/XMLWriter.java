package main.java.xml;
	
import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
	
	public class XMLWriter {
		
		public static void escribirXML(List<String[]> lista_country, List<String[]> lista_city, List<String[]> lista_address,String path) {
			
			try {
				Document documento = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
				Element nodoRaiz = documento.createElement("Countrys");
				documento.appendChild(nodoRaiz);
					
				for (String[] c : lista_country) {
					
					
					
					Element primerNodoHijo = documento.createElement("Country");
					nodoRaiz.appendChild(primerNodoHijo);
					
					
					Element country_id = documento.createElement("country_id");
					country_id.appendChild(documento.createTextNode("c[0]"));
					primerNodoHijo.appendChild(country_id);
					
					Element name = documento.createElement("name");
					name.appendChild(documento.createTextNode("c[1]"));
					primerNodoHijo.appendChild(name);
					
					Element time = documento.createElement("time");
					time.appendChild(documento.createTextNode("c[2]"));
					primerNodoHijo.appendChild(time);
					
					for (String[] city : lista_city) {
						if (city[2].equals(c[1])) {
							
							Element segundoNodoHijo = documento.createElement("Citys");
							primerNodoHijo.appendChild(segundoNodoHijo);
							
							Element city_id = documento.createElement("city_id");
							city_id.appendChild(documento.createTextNode(city[0]));
							segundoNodoHijo.appendChild(city_id);
							
							Element cityDoc = documento.createElement("city");
							cityDoc.appendChild(documento.createTextNode(city[1]));
							segundoNodoHijo.appendChild(cityDoc);
							
							Element country = documento.createElement("country");
							country.appendChild(documento.createTextNode(city[2]));
							segundoNodoHijo.appendChild(country);
							
							Element timeCity = documento.createElement("time");
							timeCity.appendChild(documento.createTextNode(city[2]));
							segundoNodoHijo.appendChild(timeCity);
							
							for (String[] address : lista_address) {
								
								Element tercerNodoHijo = documento.createElement("Address");
								segundoNodoHijo.appendChild(tercerNodoHijo);
								
								Element address_id = documento.createElement("address_id");
								address_id.appendChild(documento.createTextNode(address[0]));
								segundoNodoHijo.appendChild(address_id);
								
								Element descripcion = documento.createElement("descripcion");
								descripcion.appendChild(documento.createTextNode(address[1]));
								segundoNodoHijo.appendChild(descripcion);
								
								Element state = documento.createElement("state");
								state.appendChild(documento.createTextNode(address[2]));
								segundoNodoHijo.appendChild(state);
								
								Element cityAddress = documento.createElement("city");
								cityAddress.appendChild(documento.createTextNode(address[3]));
								segundoNodoHijo.appendChild(cityAddress);
								/*
								Element times = documento.createElement("times");
								times.appendChild(documento.createTextNode(times[4]));
								segundoNodoHijo.appendChild(times);
								*/
							}
							
						}
					}
					
				}
				
				Transformer optimus = TransformerFactory.newInstance().newTransformer();
				DOMSource source = new DOMSource(documento);
				StreamResult result = new StreamResult(new File(path));
				
				optimus.setOutputProperty(OutputKeys.INDENT, "yes");
				optimus.transform(source, result);
				
					
				
			} catch (ParserConfigurationException | TransformerException | TransformerFactoryConfigurationError e) {
				e.printStackTrace();
		}
			
	}
		
}