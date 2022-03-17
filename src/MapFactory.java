
public class MapFactory {

	// Esta clase es la factory para producir los objetos correspondientes a las 3 implementaciones deseadas
	
	public static RawMap generarMapa(int I) {
		
		switch (I) {
		case 1:
            return new Hash();
        case 2:
            return new Tree();
        case 3:
            return new LinkedHash();
        default:
        	
            return null;
		
	}
	
	}
}
