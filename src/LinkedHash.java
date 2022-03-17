import java.util.LinkedHashMap;


public class LinkedHash extends RawMap implements InterfazMapa{


	//Esta clase implementa las misma funcionalidades impuestas por la InterfazMapa pero ahora con LinkedHashMap del JVC
	
	
	
	protected LinkedHashMap<String, String> linkedhashmap = new LinkedHashMap<>();
	
	protected LinkedHashMap<String, Integer> cantidades = new LinkedHashMap<>(); // hashmap adicional para contar ocurrencias de cada tipo de carta
	
	
	
	@Override
	public void add(String nombre, String tipo) { // Agregar un personaje particular a la coleccion general
		
		linkedhashmap.put(nombre, tipo);
		
	}
	
	@Override
	public String tipo(String nombre) { // Retorna el tipo de carta
		
		return linkedhashmap.get(nombre);
	}
	
	
	@Override
	public void ShowType(String nombre) { //Retorna el tipo de carta a la que corresponde el nombre
		
		System.out.println("La carta " + nombre + " es de tipo: " + linkedhashmap.get(nombre));
		System.out.println(" ");
	}

	@Override
	public void View() { // metodo para ver nombre, tipo y cantidades resectivas de Monstruo, Hechizo y Trampa
		
		
		
		cantidades.put("Monstruo", 0); // inciializando mapa de conteo
		cantidades.put("Trampa", 0);
		cantidades.put("Hechizo", 0);
		
		linkedhashmap.forEach((key, value) -> {

			cantidades.put(value, cantidades.get(value) + 1);
		    
		    });
		
		System.out.println("Cantidades de cada tipo de carta: " + cantidades);
		System.out.println(" ");
		
		
		linkedhashmap.forEach((key, value) -> { 
			
			System.out.println("Nombre: " + key + " ---> Tipo: " + value);
		      
		    });
		
	}

	
	@Override
	public void ViewByType() { // metodo para ver todo el mapa incluyendo nombre, tipo y cantidad pero ordenado por tipo 
		
		cantidades.put("Monstruo", 0);
		cantidades.put("Trampa", 0);
		cantidades.put("Hechizo", 0);
		
		linkedhashmap.forEach((key, value) -> {

			cantidades.put(value, cantidades.get(value) + 1);
		    
		    });
		
		System.out.println("Cantidades de cada tipo de carta: " + cantidades);
		System.out.println(" ");
		
		System.out.println("------------------- HECHIZO ------------------- ");
		
		linkedhashmap.forEach((key, value) -> { // imprimiendo solo los Hechizo
			
			
			if (value.equals("Hechizo")) {

		      System.out.println("Nombre: " + key + " ---> Tipo: " + value);
		      
			} else {}
		      
		    });
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("------------------- MONSTRUO ------------------- ");
		
		linkedhashmap.forEach((key, value) -> { // imprimiendo solo los Monstruo
			
			
			if (value.equals("Monstruo")) {

		      System.out.println("Nombre: " + key + " ---> Tipo: " + value);
		      
			} else {}
		      
		    });
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("-------------------- TRAMPA -------------------- ");
		
		linkedhashmap.forEach((key, value) -> { // imprimiendo solo los Trampa
			
			
			if (value.equals("Trampa")) {

		      System.out.println("Nombre: " + key + " ---> Tipo: " + value);
		      
			} else {}
		      
		    });

	}
	
	@Override
	public boolean checkIn(String nombre) {
		
		return linkedhashmap.containsKey(nombre); 
		
	}
	
}
