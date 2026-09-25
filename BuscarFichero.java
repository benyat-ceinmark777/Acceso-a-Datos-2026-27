package ficheros;

import java.io.File;
import java.util.Scanner;

public class BuscarFichero {

	private static boolean encontrado = false;
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el nombre del archivo a buscar: ");
		String nombreBuscado = teclado.nextLine();
		
		File raiz = new File("C:\\");
		System.out.println("Buscando " + nombreBuscado + " en todo el disco, Espera");
		
		// empezamos la búsqueda
		buscarArchivo(raiz, nombreBuscado);
		
		if(!encontrado) {
			System.out.println("No se ha encontrado nada");
		}
		teclado.close();
	}

	private static void buscarArchivo(File directorioPadre, String nombreBuscado) {
		// Obtener elementos del directorio
		File[] lista = directorioPadre.listFiles();
		
		// Evitamos carpetas protegidas o null
		if (lista != null) {
			for (File elemento : lista) {
				// si coindice el nombre
				if(elemento.getName().equalsIgnoreCase(nombreBuscado)) {
					System.out.println("Archivo encontrado");
					System.out.println("Nombre "+ elemento.getName());
					System.out.println("Ruta absoluta "+ elemento.getAbsolutePath());
					System.out.println("Es fichero: " + elemento.isFile());
					System.out.println("Es directorio: " + elemento.isDirectory());
					encontrado = true;
				}
				if (elemento.isDirectory()) {
					buscarArchivo(elemento, nombreBuscado);
				}
			}
		}
				
	}
	
}
