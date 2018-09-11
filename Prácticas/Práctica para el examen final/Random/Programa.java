import java.util.Map;
import java.util.HashMap;
import java.util.stream.IntStream;
import java.util.Scanner;
import java.util.Arrays;

public class Programa{
	
	public static void main(String[]args){
		intStream();
		System.out.println(" ");
		mapProductos();

	}

	public static void intStream(){
		int[]vect = IntStream.rangeClosed(1,10000).filter(i->primo(i)).toArray();
		System.out.println(Arrays.toString(vect));
		System.out.println(IntStream.rangeClosed(1,10000).filter((i) -> primo(i)).sum());
	}

	public static boolean primo(int i){
		double iRoot = Math.sqrt(i);
		for(int j=2; j<=iRoot; j++){
			if(i%j == 0) return false;
		}
		return true;
	}


	public static void mapProductos(){
		Map<String,Integer>map = new HashMap<>();
		
		Scanner sc = new Scanner(System.in);
		boolean correcto=true;
		String temp;

		String producto;
		int cantidad=0;

		do{
			System.out.println("Producto: ");
			producto = sc.nextLine();
			System.out.println("Cantidad: ");

			do{
				try{
					cantidad = sc.nextInt(); sc.nextLine(); //Vaciar buffer
				}catch(Exception e){
					correcto = false;
					System.err.println("ERROR: subnormal introduce un puto numero");
				}
			}while(!correcto);
			correcto = true;

			if(map.containsKey(producto)){
				map.replace(producto,map.get(producto)+cantidad);
			}else{
				map.put(producto,cantidad);
			}

			System.out.println("¿Desea continuar? (S/N)");
			do{ temp = sc.nextLine(); }while(temp.isEmpty() || !"sSnN".contains(temp));

		}while(temp.equalsIgnoreCase("s"));

		System.out.println(generarTabla(map));
	}	

	public static String generarTabla(Map<String,Integer>map){
		StringBuilder sb = new StringBuilder();
		String separador = String.format("+%20s+%10s+"," "," ").replace(" ","-");

		sb.append("\n").append(separador).append("\n").append(String.format("|%10s%-10s%11s|"," ","TITULO"," "));

		for(String s : map.keySet())
			sb.append("\n").append(separador).append("\n").append(String.format("|%20s|%10d|",s,map.get(s)));

		sb.append("\n").append(separador).append("\n");

		return sb.toString();
	}
}