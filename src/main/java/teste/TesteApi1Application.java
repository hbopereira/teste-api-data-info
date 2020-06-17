package teste;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;



@SpringBootApplication
public class TesteApi1Application {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(TesteApi1Application.class, args);

		File arquivo = new File("c:/Users/hbope/Desktop/TABELA_DE_CLASSES_ATIVAS.csv");
		 try {
	         CsvSchema csv = CsvSchema.emptySchema().withHeader();
	         CsvMapper csvMapper = new CsvMapper();
	         MappingIterator<Map<?, ?>> mappingIterator =  csvMapper.reader().forType(Map.class).with(csv).readValues(arquivo);
	         List<Map<?, ?>> listaClassesAtivas = mappingIterator.readAll(); 
	         
	         System.out.println(listaClassesAtivas);
	       
	         
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
		
		
		//System.out.println(jsonClasses.toString());

	}

}
