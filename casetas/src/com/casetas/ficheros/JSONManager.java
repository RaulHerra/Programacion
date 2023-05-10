package com.casetas.ficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.casetas.model.Calle;
import com.casetas.model.CallesYCasetas;
import com.casetas.model.Caseta;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class JSONManager {

	public static Map<Calle, List<Caseta>> cargarDatos(String path){
		Map<Calle, List<Caseta>> callesYCasetas = null; 
		
		Gson gson = new GsonBuilder().create();
		CallesYCasetas[] array;
		
		try {
			array = gson.fromJson(new FileReader(path), CallesYCasetas[].class);
			callesYCasetas = (Map<Calle, List<Caseta>>) new ArrayList(Arrays.asList(array));
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return callesYCasetas;
	}
	
	public static void toJSON(Map<Calle, List<Caseta>> mapaCasetas, String path) {
		Gson gson = new GsonBuilder().setPrettyPrinting().enableComplexMapKeySerialization().create();
		
		File archivo = new File(path);
		try {
			archivo.createNewFile();
			FileWriter writer = new FileWriter(new File(path));
			gson.toJson(mapaCasetas, writer);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
