import java.time.Year;

public class j1e6{
	
	public static void main(String[]args){
		int currentYear=Year.now().getValue();
		int birthDay=Integer.parseInt(args[0]);

		if( birthDay > currentYear ){
			System.out.println("ERROR: este año no ha llegado todavia");
		}else{
			System.out.println("La edad es " + (currentYear-birthDay) );
		}

	}

}