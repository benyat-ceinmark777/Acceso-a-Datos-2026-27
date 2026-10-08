package ficheros;

import java.io.File;
import java.util.Arrays;

public class Ejercicio_3 {
	public static void main(String[] args) {
		// Obtenemos las raices disponibles del sistema
		File[] raices = File.listRoots();
		System.out.println(Arrays.toString(raices));
		
		// Recorrer el array
		for (File raiz : raices) {
			System.out.println("Raíz detectada: " + raiz);
		}
	}
}
