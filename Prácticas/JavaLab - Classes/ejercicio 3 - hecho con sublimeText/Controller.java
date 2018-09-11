import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder;
import java.nio.file.Files;
import java.io.File;
import java.io.IOException;

public class Controller{

	private Model m = new Model();


	public int importDataFromFile(String ruta){
		File f = new File(ruta);
		List<String>importedData = null;

		try{
			importedData = Files.readAllLines(f.toPath());
		}catch(IOException e){
			return -1;
		}

		m.setEquipos(importedData);
		return 0;
	}

	public void saveDataFromKeyBoard(int[][]goles){
		m.generateDataFromKeyBoard(goles);
	}

	public void generateRandomData(){
		m.generateRandomData();
	}



	public String getDatatable(){
		return m.generateStringDataTable();
	}


	public int exportToHtmlFile(String ruta){
		File f = new File(ruta);

		List<String>toExport = m.generateHtmlDataList();

		try{
			Files.deleteIfExists(f.toPath());
			Files.write(f.toPath(),toExport);
		}catch(IOException e){
			return -1;
		}

		return 0;
	}


	public int exportToCsvFile(String ruta){
		File f = new File(ruta);

		List<String>toExport = m.generateCsvDataList();

		try{
			Files.deleteIfExists(f.toPath());
			Files.write(f.toPath(),toExport);
		}catch(IOException e){
			return -1;
		}

		return 0;
	}

	public String[] getListaEquipos(){
		List <String> equipos = m.getEquipos();
		
		if( null == equipos){
			return null;
		}else{
			int i = 0;
			String[]eq = new String[equipos.size()];
			for(String s : equipos)
				eq[i++]=s;
			return eq;
		}

	}

}