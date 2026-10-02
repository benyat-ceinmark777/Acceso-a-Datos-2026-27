package ficheros;

import java.io.File;
import java.io.IOException;

public class Ficheros_2 {
	/**
	 * Creación de Archivo dentro de un Directorio Padre 
	 * Crea un directorio de trabajo representado por un objeto File 
	 * apuntando a una carpeta (por ejemplo, "./mi_carpeta"). 
	 * Utilizando el constructor secundario File(File carpetaDeTrabajo, String nombre), define un objeto File para un nuevo fichero llamado "documento.txt" dentro de esa carpeta. Comprueba si la carpeta existe y, si no es así, créala (mkdir()). Posteriormente
	 * crea el archivo "documento.txt" mediante el método createNewFile().
	 */
	
	public static void main(String[] args) {
		// Creamos el directorio padre
		File carpetaPadre = new File("./mi_carpeta");
		// Comprobamos si la carpeta existe
		if (!carpetaPadre.exists()) {
			// si no existe
			carpetaPadre.mkdir();
		} else {
			System.out.println("La carpeta ya existe!!");
		}
		
		// Creamos el archivo dentro de la carpeta
		File archivo = new File(carpetaPadre, "documento.txt");
		
		try {
			
			// Creamos fisicamente el archivo
			if(archivo.createNewFile()) {
				System.out.println("Archvio creado con exito!!");
			} else {
				System.out.println("El archivo ya existía");
			}
			
		} catch (IOException e) {
			System.out.println("Error al crear el archivo");
		}
		
	}
}
