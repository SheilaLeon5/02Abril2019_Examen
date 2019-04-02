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
    // �IMPORTANTE!: NO DEJAR AQUI C�DIGO IRRELEVANTE, LEER ENUNCIADO.
	
	
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
	
							Jugador jugador = new Jugador();
							jugador.setId(Integer.parseInt(camposJug[0]));
							jugador.setNif(camposJug[1]);
							jugador.setNombre(camposJug[2]);
							jugador.setLongitudPaso(Integer.parseInt(camposJug[3]));
							jugador.setFecha_nac(camposJug[4]);
							jugador.setSexo(camposJug[5].charAt(0));
							jugador.setDorsal(Integer.parseInt(camposJug[6]));
							jugador.setIdEquipo(Integer.parseInt(camposJug[7]));

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
		 ArrayList<Jugador> resultadoEjercicio1 = ejercicios.ejercicio1("ficheros/jugadores.txt", "BARCELONA");
		 System.out.println("h");
	}
}
