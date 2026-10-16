package permisos;

import java.io.File;
import java.io.IOException;

public class Ejercicio_2 {
	public static void main(String[] args) {
		// creamos fichero
		File archivo = new File("script.sh");
		
		try {
			
			// Crear el archivo físicamente
			if(archivo.createNewFile()) {
				System.out.println("Archivo 'script.sh' creado.");
			}
			
			// 1 y 2. Asignar permisos de escritura y ejecución
			boolean permEscritura = archivo.setWritable(true);
			boolean permEjecucion = archivo.setExecutable(true);
			
			// 3. Comprobar valores devueltos e imprimir resultado
			System.out.println("RESULTADO DE LA MODIFICACIÓN DE PERMISOS");
			System.out.println("Permiso de escritura otorgado: " + permEscritura);
			System.out.println("Permiso de ejecución otorgado: " + permEjecucion);
			
			System.out.println("\nCOMPROBACIÓN DEL SISTEMA");
			System.out.println("- PUEDE ESCRIBIR? : " + archivo.canWrite());
			System.out.println("- PUEDE EJECUTARSE? : " + archivo.canExecute());
			
		} catch (IOException e) {
			System.err.println("Error al crear el script: " + e.getMessage());
		}
	}
}
