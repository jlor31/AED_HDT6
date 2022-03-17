
public interface InterfazMapa {
	
	
	
	
	
	
	public void add(String nombre, String tipo); // Agregar un personaje particular a la coleccion general
	
	
	public String tipo(String nombre); // Retorna el tipo de carta a la que corresponde el nombre
	
	public void ShowType(String nombre);  //Imprime el tipo de carta a la que corresponde el nombre
	
	public void View();  // permite ver todo el mapa incluyendo nombre, tipo y cantidad
	
	public void ViewByType(); // permite ver todo el mapa incluyendo nombre, tipo y cantidad pero ordenado por tipo 
	
	public boolean checkIn(String nombre); // permite verificar si una carta particular esta en el mapa
	

}
