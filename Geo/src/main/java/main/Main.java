package main.java.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import main.java.xml.XMLWriter;

public class Main {

	public static void main(String[] args) {

		File ficheroCountry = new File(".\\Files\\country.txt");
		File ficheroCity = new File(".\\Files\\city.txt");
		File ficheroAddress = new File(".\\Files\\address.txt");
		List<String[]> lista_country = new ArrayList<>();
		List<String[]> lista_city = new ArrayList<>();
		List<String[]> lista_address = new ArrayList<>();
		
		try {
			BufferedReader bufferCountry = new BufferedReader(new FileReader(ficheroCountry));
			BufferedReader bufferAuxCountry = new BufferedReader(new FileReader(ficheroCountry));
			BufferedReader bufferCity = new BufferedReader(new FileReader(ficheroCity));
			BufferedReader bufferAuxCity = new BufferedReader(new FileReader(ficheroCity));
			BufferedReader bufferAddress = new BufferedReader(new FileReader(ficheroAddress));
			BufferedReader bufferAuxAddress = new BufferedReader(new FileReader(ficheroAddress));
			String lineaAuxCountry = bufferAuxCountry.readLine();
			String lineaAuxCity = bufferAuxCity.readLine();
			String lineaAuxAddress = bufferAuxAddress.readLine();
			String[] lineaCountry = bufferCountry.readLine().split(",");
			String[] lineaCity = bufferCity.readLine().split(",");
			String[] lineaAddress = bufferAddress.readLine().split(",");
			lineaAuxCountry = bufferAuxCountry.readLine();
			lineaAuxCity = bufferAuxCity.readLine();
			lineaAuxAddress = bufferAuxAddress.readLine();
			while (lineaCountry != null && lineaAuxCountry != null) {
				
				lineaCountry = bufferCountry.readLine().split(",");
				lista_country.add(lineaCountry);
				lineaAuxCountry = bufferAuxCountry.readLine();
			}
			while (lineaCity != null && lineaAuxCity != null) {
				lineaCity = bufferCity.readLine().split(",");
				lista_city.add(lineaCity);
				lineaAuxCity = bufferAuxCity.readLine();
			}
			while (lineaAddress != null && lineaAuxAddress != null ) {
				lineaAddress = bufferAddress.readLine().split(",");
				lista_address.add(lineaAddress);
				lineaAuxAddress = bufferAuxAddress.readLine();
			}
			
			bufferCountry.close();
			bufferCity.close();
			bufferAddress.close();
			bufferAuxCountry.close();
			
			XMLWriter.escribirXML(lista_country, lista_city, lista_address, ".\\Files\\");
			
			
			
		} catch (IOException e) {
			System.out.println("El fichero no se ha encontrado.");
		}

	}

}
