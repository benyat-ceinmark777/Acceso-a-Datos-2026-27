package permisos;

import java.io.File;

public class Ejercicio3Directorio {
	public static void main(String[] args) {
		// defino el objeto File apuntando a la carpeta/directorio 'backup_diario'
		File directorio = new File("backup_diario");
		
		// 1. Asegurarnos de que el directorio se crea con mkdir()
		if(!directorio.exists()) {
			directorio.mkdir();
			System.out.println("Directorio creado con éxito!!");
		}else {
			System.out.println("Ya existe el directorio!!");
		}
		
		// 2. y 3. modificar permisos
		boolean permLectura= directorio.setReadable(true, true);
		boolean permEscritura = directorio.setWritable(true, true);
		boolean permEjecucion = directorio.setExecutable(true, true);
		
		// Verificamos los resultados de cada modificación
		System.out.println("RESULTADO DE LA MODIFICACIÓN DE PERMISOS");
		System.out.println("Permiso de lectura otorgado: " + permLectura);
		System.out.println("Permiso de escritura otorgado: " + permEscritura);
		System.out.println("Permiso de ejecución otorgado: " + permEjecucion);
		
		// Comprobar lo que dice el sistema
		System.out.println("\nCOMPROBACIÓN DEL SISTEMA");
		System.out.println("- PUEDE LEER? : " + directorio.canRead());
		System.out.println("- PUEDE ESCRIBIR? : " + directorio.canWrite());
		System.out.println("- PUEDE EJECUTARSE? : " + directorio.canExecute());
		if(directorio.canWrite()) {
			System.out.println("El directorio permite escribir");
		}
	}
	
}
