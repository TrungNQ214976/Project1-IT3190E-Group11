package convertRawToJson.ErrorLogCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class Convert {

	public void Start() {
		// TODO Auto-generated method stub
		String inputfile = "./resources/com/it/loganalyze/log/error.log";
		
		JsonObject jsonObject = new JsonObject();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(inputfile))){
			String line;
			int lineNumber = 1;
			
			while((line = reader.readLine()) != null) {
				
				LogEntry logEntry = createLogEntry.extractLogEntry(line);
				jsonObject.add("line_" + lineNumber, createLogEntry.create(logEntry));
				
				lineNumber ++;
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonString = gson.toJson(jsonObject);
		
		String outputfile = "./resources/com/it/loganalyze/log/error.json";
		try(FileWriter fileWriter = new FileWriter(outputfile)){
			fileWriter.write(jsonString);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}