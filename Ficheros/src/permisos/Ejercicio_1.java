package permisos;

import java.io.File;
import java.io.IOException;

public class Ejercicio_1 {
	public static void main(String[] args) {
		File archivo = new File("informe_confidencial.txt");

		try {
			// 1. Crear el archivo si no existe
			if (!archivo.exists()) {
				if (archivo.createNewFile()) {
					System.out.println("Archivo 'informe_confidencial.txt' creado con exito!!");
				}
			}

			// 2. Modificar permisos:
			boolean okLectura = archivo.setReadable(true); // lo hacemos leible
			boolean escrituraCambiada = archivo.setWritable(false);
//			boolean noEscritura = archivo.setWritable(false); // no se puede escribir
			boolean noEjecucion = archivo.setExecutable(false); // no se ejecuta

			// validar especificamente la escritura
			if (escrituraCambiada && !archivo.canWrite()) {
				System.out.println("Exito, el archivo txt es de solo lectura");
			} else {
				System.out.println("No se pudo modificar el permiso de escritura");
			}
			System.out.println("Comprobacion: ");
			System.out.println("Se puede leer: " + archivo.canRead());
			System.out.println("Se puede escribir: " + archivo.canWrite());
			// 3. Confirmación
//			if(okLectura && noEscritura && noEjecucion) {
//				System.out.println("Los permisos se han actualizado correctamente: ");
//				System.out.println(" - ¿Es legible?: " + archivo.canRead());
//				System.out.println(" - ¿Es escribible?: " + archivo.canWrite());
//				System.out.println(" - ¿Es ejecutable?: " + archivo.canExecute());
//				System.out.println("Estado actual: SOLO LECTURA");
//			}else {
//				System.out.println("No se pueden cambiar los permisos.");
//			}

		} catch (IOException e) {
			System.err.println("Error al manejar el archivo: " + e.getMessage());
		}

	}
}
