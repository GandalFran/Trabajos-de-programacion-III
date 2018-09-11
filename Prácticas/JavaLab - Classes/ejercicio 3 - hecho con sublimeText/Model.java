import java.lang.StringBuilder;
import java.util.List;
import java.util.ArrayList;

public class Model{

	private List<Partido>partidos;
	private List<String>equipos;

	public Model(){
		this.partidos = null;
		this.equipos = null;
	}


	public void generateDataFromKeyBoard(int[][]goles){
		if( null== this.partidos ){
			this.partidos = new ArrayList<>();
		}else if( !this.partidos.isEmpty() ){
			this.partidos.clear();
		}

		String [] fragmentos = null;
		Partido p = null;
		int i = 0;
		for(String equipo : this.equipos ){
			fragmentos = equipo.split("-");
			p = new Partido(fragmentos[0],fragmentos[1],goles[i][0],goles[i][1]);
			this.partidos.add(p);
			i++;
		}
	}
	
	public void generateRandomData(){
		if( null== this.partidos ){
			this.partidos = new ArrayList<>();
		}else if( !this.partidos.isEmpty() ){
			this.partidos.clear();
		}

		String [] fragmentos = null;
		Partido p = null;
		for(String equipo : this.equipos ){
			fragmentos = equipo.split("-");
			p = new Partido(fragmentos[0],fragmentos[1]);
			this.partidos.add(p);
		}
	}

	public String generateStringDataTable(){
		StringBuilder sb = new StringBuilder();
		String separador = String.format("\n+%20s+%20s+%15s+%15s+%10s+"," "," "," "," "," ").replace(" ","-");


		sb.append(separador).append(String.format("\n|%38s%s%38s|"," ","QUINIELA"," ")).append(separador);
		sb.append(String.format("\n|%20s|%20s|%15s|%15s|%10s|","Equipo local","Equipo visitante","Goles local","Goles visitante","Resultado")).append(separador);
		if( null == this.partidos || this.partidos.isEmpty()){
			sb.append(String.format("\n|%86s|","No se tienen informacon todavia")).append(separador);
		}else{
			for(Partido a : this.partidos)
				sb.append(a.toString()).append(separador);
		}

		return sb.toString();	
	}


	public List<String> generateHtmlDataList(){
		List<String>toExport = new ArrayList<>();

		//Cabecera
		toExport.add("<!DOCTYPE = html><HTML>");
		toExport.add("<HEAD><metacharset = \"UTF-8\"><H1>QUINIELA</H1></HEAD>\n");
		toExport.add("<BODY>");
		toExport.add("<TABLE BORDER = 1>");
		//Añadir datos
		toExport.add(String.format("<TR>  <TD><STRONG>%s</STRONG></TD> <TD><STRONG>%s</STRONG></TD> <TD><STRONG>%s</STRONG></TD> <TD><STRONG>%s</STRONG></TD> <TD><STRONG>%s</STRONG></TD>  </TR>","Equipo local","Equipo visitante","Goles local","Goles visitante","Resultado"));
		if( null == this.partidos || this.partidos.isEmpty()){
			toExport.add("<TD><TR>No data aviable</TD></TR>");
		}else{
			for(Partido a : this.partidos)
				toExport.add(a.toHtmlString());
		}
		//Cerrar tabla
		toExport.add("</TABLE>");
		toExport.add("\n</HTML></BODY>");

		return toExport;
	}


	public List<String> generateCsvDataList(){
		List<String>toExport = new ArrayList<>();

		toExport.add(String.format("\t%20s\t%20s\t%15s\t%15s\t%10s","Equipo local","Equipo visitante","Goles local","Goles visitante","Resultado"));
		if( null == this.partidos || this.partidos.isEmpty()){
			toExport.add("No data aviable");
		}else{
			for(Partido a : this.partidos)
				toExport.add(a.toTabbedString());
		}

		return toExport;
	}


	public List<String>getEquipos(){ return this.equipos; }
	public void setEquipos(List<String>equipos){ this.equipos=equipos; }
}