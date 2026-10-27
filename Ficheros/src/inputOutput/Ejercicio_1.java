package inputOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Ejercicio_1 {
	public static void main(String[] args) {
		// definimos el archivo de origen y destino
		File archivoOrigen = new File("./mi_carpeta/origen.txt");
		File archivoDestino = new File("./mi_carpeta/destino.txt");
		
		// Llamada al método crearOrigenSiNoExiste para garantizar que existe un 'origen.txt'
		// antes de leer el archivo
		crearOrigenSiNoExiste(archivoOrigen);
		
		// Uso de try-catch
		// Abrir los streams y los cierra AUTOMÁTICAMENTE al terminar
		try (
			InputStream entrada = new FileInputStream(archivoOrigen);
			OutputStream salida = new FileOutputStream(archivoDestino);
		){
			
			int bytesLeido;
			
			// read() lee solo un SOLO BYTE (de 0 a 255).
			// Cuando llega al final del archivo (EOF), el método devuelve -1.
			while((bytesLeido = entrada.read()) != -1) {
				
				// Escribimos en el archivo de salida el byte que estamos leyendo.
				salida.write(bytesLeido);
			}
			System.out.println("Copia byte a byte realizada con ÉXITO!!!!!!!!!!!!!!!!!!!!!!");
			System.out.println("Ubicación del destino: " + archivoDestino.getAbsolutePath());
			
		} catch (IOException e) {
			System.out.println("Error durante el proceso de copia: " + e.getMessage());
		}
		
		
	}

	// Crea el archivo 'origen.txt' con un texto inicial si todavía no existe
	private static void crearOrigenSiNoExiste(File origen) {
		if (!origen.exists()) {
			try (OutputStream os = new FileOutputStream(origen)) {
				Scanner teclado = new Scanner(System.in);
				System.out.println("QUE QUIERES QUE ESCRIBA EN EL FICHERO ORIGEN TIO??????????????????????????????????????????????????????????????????????????????????????????????????");
				os.write(teclado.nextLine().getBytes());
			} catch (IOException e) {
				System.out.println("Error al preparar origen.txt: " + e.getMessage());
			}
		}
	}
}
