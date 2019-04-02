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
		ArrayList<Jugador> listaJugadores = new ArrayList<Jugador>();

		try {
			BufferedReader fichero = new BufferedReader(new FileReader("ficheros/equipos.txt"));
			BufferedReader ficheroJug = new BufferedReader(new FileReader(rutaJugadores));

			while((registro=fichero.readLine()) !=null) {
				String[] campos = registro.split("#");
				idEquipo = campos[0];
				nombreLargo = campos[2];

				if (equipo.compareToIgnoreCase(nombreLargo)==0) {
					//Leer jugadores
					while((registroJugadores= ficheroJug.readLine())!= null) {
						String[]camposJug = registroJugadores.split("#");
						if (idEquipo.equals(camposJug[7])) {
							//Jugador jugador = new Jugador(camposJug[1], camposJug[2], Integer.parseInt(camposJug[2]), camposJug[3], camposJug[4].charAt(0), Integer.parseInt(camposJug[5]), Integer.parseInt(camposJug[6]), Integer.parseInt(camposJug[7]));							
							
							Jugador jugador = new Jugador();
							jugador.setId(Integer.parseInt(campos[0]));
							jugador.setNif(campos[1]);
							jugador.setNombre(campos[2]);
							jugador.set
							listaJugadores.add(jugador);
						}
					}	
				}
			}
			fichero.close();
			return listaJugadores;
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}	catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return null;	
		
	}
	
	
	
	public static void main(String[]args){
		// 
		 Ejercicios ejercicios= new Ejercicios();
		 ArrayList<Jugador> resultadoEjercicio1 = ejercicios.ejercicio1("ficheros/jugadores.txt", "REAL MADRID");
		 System.out.println("h");
	}
}
