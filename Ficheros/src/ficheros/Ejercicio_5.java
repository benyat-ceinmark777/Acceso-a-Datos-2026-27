package ficheros;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ejercicio_5 {
	
	public static void main(String[] args) {

		// Creamos el directorio
		File carpeta = new File("./Desktop/carpeta_PRUEBA");
		
		// Si no existe, lo creamos
		if (!carpeta.exists()) {
			carpeta.mkdirs();
			System.out.println("Carpeta creada con exito.");
			System.out.println(carpeta.getAbsolutePath());
		}
		
		// Creamos los objetos File de los 3 archivos
		File archivo_1 = new File(carpeta, "nota1.tmp");
		File archivo_2 = new File(carpeta, "nota2.tmp");
		File archivo_3 = new File(carpeta, "nota3.tmp");
		
		try {
			// Creamos los tres archivos
			boolean creado1 = archivo_1.createNewFile();
			boolean creado2 = archivo_2.createNewFile();
			boolean creado3 = archivo_3.createNewFile();
			
			// Comprobamos si se han creado bien
			System.out.println("nota1.tmp creado: " + creado1);
			System.out.println("nota2.tmp creado: " + creado2);
			System.out.println("nota3.tmp creado: " + creado3);
			
		} catch (IOException e) {
			System.out.println("Se ha producido un error.");
		}
		
		// Eliminamos nota2.tmp
		if (archivo_2.delete()) {
			System.out.println("nota2.tmp eliminado correctamente.");
		} else {
			System.out.println("Archivo no borrado.");
		}
		
		// añadir los ficheros a un array
		List<File> listaF = new ArrayList<File>();
		listaF.add(archivo_1);
		listaF.add(archivo_2);
		listaF.add(archivo_3);
		System.out.println(listaF);
	}
}
