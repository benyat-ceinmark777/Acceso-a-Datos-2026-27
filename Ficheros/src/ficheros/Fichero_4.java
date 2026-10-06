package ficheros;

import java.io.File;
import java.util.Scanner;

public class Fichero_4 {
	
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		// Pedimos ruta
		System.out.println("Introduce la ruta de una carpeta: ");
		String ruta = teclado.nextLine();
		
		// Creamos el objeto file
		File carpeta = new File(ruta);
		
		// Comprobamos que existe
		if(!carpeta.exists()) {
			System.out.println("La ruta no existe");
		} else if(!carpeta.isDirectory()){
			System.out.println("La ruta no es un directorio.");
		
		} else {
			// Obtenemos el contenido
			File[] contenido = carpeta.listFiles();
			System.out.println("\nContenido de la carpeta: ");
			
			// Recorremos los elementos
			for (File elemento : contenido) {
				System.out.println(
						"Nombre: " + elemento.getName() + 
						" | Tamaño: " + elemento.length() + "bytes"
				);
			}
		}
		teclado.close();
	}
	
}
