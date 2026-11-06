package entrega_1;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class Ejercicio1 {
	public static void main(String[] args) {
		// 1. Crear directorio logs_sistema SI NO EXISTE
		File directorio = new File("./logs_sistema");
		if(!directorio.exists()) {
			directorio.mkdir();
			System.out.println("Directorio creado: " + directorio.getName());
		}
		
		// 2. Crear archivos dentro de la carpeta creada
		File logFile = new File(directorio, "app.log");
		File tmpFile = new File(directorio, "backup.tmp");
		
		try {
			logFile.createNewFile();
			tmpFile.createNewFile();
			System.out.println("Archivos creados con éxito!!!");
		} catch (IOException e) {
			System.err.println("Error al crear los archivos: " + e.getMessage());
		}
		
		// 3. Configurar permisos en app.log
		logFile.setReadable(false, false); // Quita lectura pública
        logFile.setReadable(true, true);   // Lectura solo propietario
        logFile.setWritable(false, false); // Quita escritura pública
        logFile.setWritable(true, true);   // Escritura solo propietario
		
		// 4. FilenameFilter para listar solo archivos.log
        FilenameFilter filtroLog = new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".log");
			}
		};
		
		// 5. Listar e imprimir información de los ficheros filtrados (los ".log")
		File[] archivosLog = directorio.listFiles(filtroLog);
		System.out.println("ARCHIVOS .log encontrados");
		if(archivosLog != null) {
			for (File f : archivosLog) {
				try {
					System.out.println("Nombre: " + f.getName());
					System.out.println("Ruta canónica: " + f.getCanonicalPath());
					System.out.println("Tamaño: " + f.length() + " bytes");
				} catch (IOException e) {
					System.err.println("Error obteniendo ruta: " + e.getMessage());
				}
			}
		}
	}
}
