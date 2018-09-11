
import java.util.Random;

public class Partido{

	String equipoLocal;
	String equipoVisitante;
	int golesLocal;
	int golesVisitante;


	public Partido(String equipoLocal, String equipoVisitante, int golesLocal, int golesVisitante){
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.golesLocal = golesLocal;
		this.golesVisitante = golesVisitante;
	}
	public Partido(String equipoLocal, String equipoVisitante){
		Random r = new Random();

		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.golesLocal = r.nextInt(10);
		this.golesVisitante = r.nextInt(10);
	}
	public Partido(){
		this.equipoLocal = null;
		this.equipoVisitante = null;
		this.golesLocal = 0;
		this.golesVisitante = 0;
	}


	public static void factoryMethod(){
		/*TODO --> para convertir lo del archivo en normal*/
	}

	public String calcularResultado(){
		return (this.golesLocal > this.golesVisitante)? ("1") : ( (this.golesLocal < this.golesVisitante)? ("2") : ("X") );
	}

	@Override
	public String toString(){
		return String.format("\n|%20s|%20s|%15s|%15s|%10s|",this.equipoLocal,this.equipoVisitante,this.golesLocal,this.golesVisitante,this.calcularResultado());
	}
	public String toHtmlString(){
		return String.format("<TR>  <TD>%s</TD> <TD>%s</TD> <TD>%d</TD> <TD>%d</TD> <TD>%s</TD>  </TR>",this.equipoLocal,this.equipoVisitante,this.golesLocal,this.golesVisitante,this.calcularResultado());
	}
	public String toTabbedString(){
		return String.format("\n\t%s\t%s\t%d\t%d\t%s",this.equipoLocal,this.equipoVisitante,this.golesLocal,this.golesVisitante,this.calcularResultado());
	}


	public String getEquipoLocal(){ return this.equipoLocal; }
	public void setEquipoLocal(String equipoLocal){ this.equipoLocal = equipoLocal; }
	public String getEquipoVisitante(){ return this.equipoVisitante; }
	public void setEquipoVisitante(String equipoVisitante){ this.equipoVisitante = equipoVisitante; }
	public int getGolesLocal(){ return this.golesLocal; }
	public void setGolesLocal(int golesLocal){ this.golesLocal = golesLocal; }
	public int getGolesVisitante(){ return this.golesVisitante; }
	public void setGolesVisitante(int golesVisitante){ this.golesVisitante = golesVisitante; }

}