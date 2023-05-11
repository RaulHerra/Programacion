package com.casetas.ficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.casetas.model.Calle;
import com.casetas.model.Caseta;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class JSONManager {

	public static Map<Calle, Caseta[]> cargarDatos(String path){
		JsonReader getLocalJsonFile = null;
		try {
			getLocalJsonFile = new JsonReader(new FileReader(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

        Type mapTokenType = new TypeToken<Map<Calle, Caseta[]>>(){}.getType();

        Map<Calle, Caseta[]> jsonMap = new Gson().fromJson(getLocalJsonFile, mapTokenType);

        return jsonMap;
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
