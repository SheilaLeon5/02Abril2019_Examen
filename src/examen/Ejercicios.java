package examen;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.Jugador;

// 2 de abril de 2019
public class Ejercicios {
	
	// implementar y llamar desde AQUI los ejercicios
    // ¡IMPORTANTE!: NO DEJAR AQUI CÓDIGO IRRELEVANTE, LEER ENUNCIADO.
	
	
	//EJERCICIO 1
	public ArrayList<Jugador> ejercicio1 (String rutaJugadores , String equipo){
		String registro = null;
		String registroJugadores = null;
		String idEquipo;
		String nombreLargo;
		String palabraFinalizar = ".";

		try {
			BufferedReader fichero = new BufferedReader(new FileReader("ficheros/equipos.txt")); //Leer fichero (comparar lo escrito por teclado)
			BufferedReader ficheroJug = new BufferedReader(new FileReader(rutaJugadores));

				while((registro=fichero.readLine()) !=null) {
					String[] campos = registro.split("#");
					idEquipo = campos[0];
					nombreLargo = campos[2];
					if(tecleado.equals(nombreLargo)) {
						System.out.println(nombreLargo + " ha sido escrito");

						//Leer jugadores
						while((registroJugadores= ficheroJug.readLine())!= null) {
							String[]camposJug = registroJugadores.split("#");
							if (idEquipo.equals(camposJug[4])) {
								System.out.println(camposJug[2]);
							}
						}
					}
				}

			teclado.close(); fichero.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}	catch (IOException e) {
			System.out.println(e.getMessage());
		}	
		
		
		
		
		
		
		
		
		
		
		
		return null;
		
	}
}
