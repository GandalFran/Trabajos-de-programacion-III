import java.util.Scanner;

public class View{

	private final Scanner sc = new Scanner(System.in);
	private Controller c = new Controller(); 

	public void runMenu(String menuText){
		boolean exit = false;
		String respuesta = null;

		while(!exit){
			System.out.print(menuText);
			respuesta = sc.nextLine();

			switch(respuesta){
				case("1"):
					importFileData();
				break;
				case("2"):
					importKeyBoardData();
				break;
				case("3"):
					generateRandomData();
				break;
				case("4"):
					showData();
				break;
				case("5"):
					exportToHtmlFile();
				break;
				case("6"):
					exportToCsvFile();
				break;
				case("7"):
					exit = true;
				break;
				default:
					System.out.println("ERROR: introduzca un caracter valido");
			}

		}
	}


	private void importFileData(){
		String ruta = "equipos.txt";
		int resultado = c.importDataFromFile(ruta);

		if(-1 == resultado){
			System.out.println("ERROR: no se pudo leer " + ruta + ".");
		}else{
			System.out.println("Los datos fueron importados con exito");
		}
	}

	private void importKeyBoardData(){
		String [] listaEquipos = c.getListaEquipos();

		if( null == listaEquipos){
			System.out.println("ERROR: debe importar un archivo con los nombres de los equipos antes de introducir datos");
		}else{
			int [][] goles = new int[ listaEquipos.length ][2];

			int i = 0;
			for(String equipos : listaEquipos){
				System.out.println("Partido \"" + equipos + "\" : ");
				System.out.print("\tEquipo local: ");
				goles[i][0] = sc.nextInt();
				System.out.print("\n\tEquipo local: ");
				goles[i][1] = sc.nextInt();
				i++;
			}

			c.saveDataFromKeyBoard(goles);
		}
	}

	private void generateRandomData(){
		String [] listaEquipos = c.getListaEquipos();

		if( null == listaEquipos ){
			System.out.println("ERROR: debe importar un archivo con los nombres de los equipos antes de introducir datos");
		}else{
			c.generateRandomData();
		}
	}
	
	private void showData(){
		String toPrint = c.getDatatable();
		System.out.println(toPrint);
	}
	
	private void exportToHtmlFile(){
		String ruta = System.getProperty("user.home") + "/Desktop/quiniela.html";
		int resultado = c.exportToHtmlFile(ruta);

		if(-1 == resultado){
			System.out.println("ERROR: no se pudo acceder a " + ruta + ".");
		}else{
			System.out.println("Los datos fueron exportados con exito");
		}
	}
	
	private void exportToCsvFile(){
		String ruta = System.getProperty("user.home") + "/Desktop/quiniela.csv";
		int resultado = c.exportToCsvFile(ruta);

		if(-1 == resultado){
			System.out.println("ERROR: no se pudo acceder a " + ruta + ".");
		}else{
			System.out.println("Los datos fueron exportados con exito");
		}
	}
	

}