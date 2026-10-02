package ficheros;

import java.io.File;
import java.io.FilenameFilter;

public class EjercicioFiltro {
	
	public static void main(String[] args) {
		// Carpeta en la que queremos consultar 
		File carpeta = new File("C:\\Users\\Web\\Desktop"); 
		
		// Creamos filtro
		FilenameFilter filtro = new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				
				// Solo aceptamos archivos que terminen en .txt
				return name.endsWith(".txt") || name.endsWith(".log");
			}
		};
		
		// Obtenemos los archivos aplicando el filtro
		String[] archivos = carpeta.list(filtro);
		
		// Mostrar archivos
		for (String archivo : archivos) {
			System.out.println(archivo);
		}		
	
	}
}
