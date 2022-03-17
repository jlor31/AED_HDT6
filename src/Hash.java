import java.util.HashMap;

public class Hash extends RawMap implements InterfazMapa {

	protected HashMap<String, String> hashmap = new HashMap<>();
	
	protected HashMap<String, Integer> cantidades = new HashMap<>(); // hashmap adicional para contar ocurrencias de cada tipo de carta
	
	
	
	@Override
	public void add(String nombre, String tipo) { // Agregar un personaje particular a la coleccion general
		
		hashmap.put(nombre, tipo);
		
	}
	
	@Override
	public String tipo(String nombre) {
		
		return hashmap.get(nombre);
	}
	
	@Override
	public void ShowType(String nombre) { //Retorna el tipo de carta a la que corresponde el nombre
		
		System.out.println("La carta " + nombre + " es de tipo: " + hashmap.get(nombre));
		System.out.println(" ");
	}

	@Override
	public void View() { // metodo para ver nombre, tipo y cantidades resectivas de Monstruo, Hechizo y Trampa
		
		cantidades.put("Monstruo", 0); // inciializando mapa de conteo
		cantidades.put("Trampa", 0);
		cantidades.put("Hechizo", 0);
		
		hashmap.forEach((key, value) -> {

			cantidades.put(value, cantidades.get(value) + 1);
		    
		    });
		
		System.out.println("Cantidades de cada tipo de carta: " + cantidades);
		System.out.println(" ");
		
		
		hashmap.forEach((key, value) -> { 
			
			System.out.println("Nombre: " + key + " ---> Tipo: " + value);
		      
		    });
		
	}

	
	@Override
	public void ViewByType() { // metodo para ver todo el mapa incluyendo nombre, tipo y cantidad pero ordenado por tipo 
		
		cantidades.put("Monstruo", 0);
		cantidades.put("Trampa", 0);
		cantidades.put("Hechizo", 0);
		
		hashmap.forEach((key, value) -> {

			cantidades.put(value, cantidades.get(value) + 1);
		    
		    });
		
		System.out.println("Cantidades de cada tipo de carta: " + cantidades);
		System.out.println(" ");
		
		System.out.println("------------------- HECHIZO ------------------- ");
		
		hashmap.forEach((key, value) -> { // imprimiendo solo los Hechizo
			
			
			if (value.equals("Hechizo")) {

		      System.out.println("Nombre: " + key + " ---> Tipo: " + value);
		      
			} else {}
		      
		    });
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("------------------- MONSTRUO ------------------- ");
		
		hashmap.forEach((key, value) -> { // imprimiendo solo los Monstruo
			
			
			if (value.equals("Monstruo")) {

		      System.out.println("Nombre: " + key + " ---> Tipo: " + value);
		      
			} else {}
		      
		    });
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("-------------------- TRAMPA -------------------- ");
		
		hashmap.forEach((key, value) -> { // imprimiendo solo los Trampa
			
			
			if (value.equals("Trampa")) {

		      System.out.println("Nombre: " + key + " ---> Tipo: " + value);
		      
			} else {}
		      
		    });
		
	}


	@Override
	public boolean checkIn(String nombre) {
		
		return hashmap.containsKey(nombre); 
		
	}


	
	
	
}
