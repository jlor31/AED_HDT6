import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
 * Juan Lorthiois 18771
 * Jorge Andrino
 * Hoja de Trabajo 6
 */



public class Main {

	
	
	static RawMap mapBig = null;
	static RawMap mapUser = null;
	
	private static void seleccionMapa() {  // metodo para solicitar la implementacion de map deseada
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Selecciona la implementacion de Map que te interesa utilizar: ");
		System.out.println(" ");
		System.out.println("1. HashMap");
		System.out.println("2. TreeMap");
		System.out.println("3. LinkedHashMap");
		System.out.println(" ");
		System.out.print("Tu seleccion -> ");
		
		try {
			
			int seleccion = input.nextInt();
			
			mapBig = MapFactory.generarMapa(seleccion);
			mapUser = MapFactory.generarMapa(seleccion);
			
		} catch (Exception e){
			
			System.out.println("Ha ocurrido un error con la seleccion del Mapa");
			
		}
		
	}
	
	
	public static void lector(String url) {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(url));
			
			
			String linea;
			
			while((linea = reader.readLine()) != null) {
				
				String[] datos = linea.split("[|]");
				
				
				
				String nombre = datos[0];
				String tipo = datos[1].replaceAll(" ","");
				
				
				mapBig.add(nombre, tipo);
				
			    
			}
			
			reader.close();
			
		} catch(Exception e) {
			
			System.out.println(" ");
			System.out.println(" Esta direccion es invalida o inaccesible! ");
			prompt();
	}
		
		
	}
	
	public static void opciones() {
		Scanner in2 = new Scanner(System.in);
		
		System.out.println(" ");
		System.out.println("----------------- SELECCIONAR UNA OPCION ----------------- ");
		System.out.println("1. Agregar una carta a la coleccion del usuario.");
		System.out.println("2. Mostrar el tipo de una carta especifica.");
		System.out.println("3. Mostrar nombre, tipo y cantidad de cada carta que el usuario tiene en su colección");
		System.out.println("4. Mostrar el nombre, tipo y cantidad de cada carta que el usuario tiene en su colección, ordenadas por tipo");
		System.out.println("5. Mostrar el nombre y tipo de todas las cartas existentes");
		System.out.println("6. Mostrar el nombre y tipo de todas las cartas existentes, ordenadas por tipo");
		System.out.println("7. Salir del programa");
		System.out.print("Seleccion -> ");
		
		int I = in2.nextInt();
		
		try {
		switch (I) {
		case 1:
            Scanner in3 = new Scanner(System.in);
            System.out.print("Nombre de la carta que desea agregar a la coleccion del usuario-> ");
            String nombre = in3.nextLine();
            
            if (mapBig.checkIn(nombre)) {
            	
            	mapUser.add(nombre, mapBig.tipo(nombre));
            	System.out.println(" ");
            	System.out.println("La carta " + nombre + " fue agregada a la coleccion del usuario");
            	opciones();
            	
            } else {
            	
            	System.out.println(" ");
            	System.out.println("Esta carta no existe!");
            	opciones(); 
            	
            }
            
            
        case 2:
            Scanner in4 = new Scanner(System.in);
            System.out.print("Nombre de la carta cuyo tipo desea averiguar -> ");
            String nombre_carta = in4.nextLine();
            
            if (mapBig.checkIn(nombre_carta)) {
            	
            	
            	System.out.println(" ");
            	mapBig.ShowType(nombre_carta);
            	opciones();
            	
            } else {
            	
            	System.out.println(" ");
            	System.out.println("Esta carta no existe!");
            	opciones(); 
            	
            }
            
            
        case 3:
            
        	System.out.println("---------- Cartas en coleccion del usuario ----------");
        	System.out.println(" ");
        	
        	mapUser.View();
        	opciones();
        	
        
        case 4: 
        	
        	System.out.println("---------- Cartas en coleccion del usuario ordenadas por tipo ----------");
        	System.out.println(" ");
        	
        	mapUser.ViewByType();
        	opciones();
        	
        case 5: 
        	
        	System.out.println("---------- Cartas existentes ----------");
        	System.out.println(" ");
        	
        	mapBig.View();
        	opciones();
        	
        case 6: 
        	
        	System.out.println("---------- Cartas existentes ordenadas por tipo----------");
        	System.out.println(" ");
        	
        	mapBig.ViewByType();
        	opciones();
        	
        case 7:
        	
        	System.out.println(" ");
        	System.out.println(" Sesion terminada");
        	System.exit(0);
		
	}
		}catch (Exception E) {
		
			System.out.println(" ");
        	System.out.println(" Ingresar una opcion valida !");
        	opciones();
		
	}
		
		
	}
	
	
	public static void prompt() {
		
		
		
		System.out.println("---------------------- MONSTERS INC --------------------------");
		System.out.println(" ");
		
		seleccionMapa();  // pidiendo al usuario que seleccione la implementacion de map
		
		
		
		System.out.print("Ingresa la direccion del archivo de texto  (Ej: C:\\Users\\fulanito\\cards_desc.txt) -> ");

		Scanner in = new Scanner(System.in);
		
		
		try {
			
			String url = in.nextLine();
			
			lector(url);
			System.out.println(" ");
			System.out.println(" Cartas cargadas exitosamente del archivo de texto! ");
				
			
		} catch (Exception e){
			
			System.out.println("Ha ocurrido un error al leer el archivo de texto");
			System.out.println(" ");
			prompt();
			
		}
		
		System.out.println(" ");
		System.out.println("Tipo de mapa empleado: " + mapBig.getClass());
		System.out.println(" ");
		
		opciones();
		
		
		
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		
		prompt();
		

	}

}
