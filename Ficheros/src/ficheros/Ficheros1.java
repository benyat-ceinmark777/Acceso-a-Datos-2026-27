package ficheros;

import java.io.File;
import java.util.Scanner;

public class Ficheros1 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce la ruta del archivo o carpeta: ");
		String ruta = teclado.nextLine();

		File archivo = new File(ruta);

		if (archivo.exists()) {
			System.out.println("El elemento SI EXISTE");
			if (archivo.isFile()) {
				System.out.println("Tipo: FICHERO");
			} else if (archivo.isDirectory()) {
				System.out.println("Tipo: CARPETA");
			}
			System.out.println("Nombre: " + archivo.getName());
			System.out.println("Ruta absoluta: " + archivo.getAbsolutePath());
		} else {
			System.out.println("El elemento no existe aquí!!");
		}
		teclado.close();

	}

}
