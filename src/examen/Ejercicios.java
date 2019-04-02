package examen;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

import modelo.Jugador;
import modelo.Persona;

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
	
	
	//EJERCICIO 2
/*	
	public HashMap<String, ArrayList<Jugador>> ejercicio2(String rutaJugadores) throws FileNotFoundException{

		int contador= 1;
		BufferedReader fichero = new BufferedReader(new FileReader(rutaJugadores));
		String registro;
		HashMap<String, ArrayList<Jugador>> mapaJugadores = new HashMap<String,ArrayList<Jugador>>();
		while ((registro = fichero.readLine()) != null) {
			String[] campos = registro.split("#");
			if (campos[3].equals("")) // ultimo partido jugado..
				break;
			String eL = campos[2];
			String gL = campos[3];
			String eV = campos[4];
			String gV = campos[5];



			if (!equipos.containsKey(eL))
				equipos.put(eL, new ArrayList<Integer>(Arrays.asList(0, 0, 0)));

			if (!equipos.containsKey(eV))
				equipos.put(eV, new ArrayList<Integer>(Arrays.asList(0, 0, 0)));

			// cual fue el resultado ..?

			if (gL.compareTo(gV) > 0) {// gana Local
				equipos.get(eL).set(0, equipos.get(eL).get(0) + 1);
				equipos.get(eV).set(2, equipos.get(eV).get(2) + 1);

			} else if (gL.compareTo(gV) < 0) // gana Visitante
			{// gana Local
				equipos.get(eL).set(2, equipos.get(eL).get(2) + 1);
				equipos.get(eV).set(0, equipos.get(eV).get(0) + 1);
			} else { // empate

				equipos.get(eL).set(1, equipos.get(eL).get(1) + 1);
				equipos.get(eV).set(1, equipos.get(eV).get(1) + 1);
			}

		}
		fichero.close();
		System.out.println("Fin de la lectura del fichero");
}
*/
	
	
	//EJERCICIO 3
		
	public ArrayList<Jugador> ejercicio3_1 (String rutaEquipos){
		
		try {
			BufferedReader fichero;
			fichero = new BufferedReader(new FileReader(rutaEquipos));
			ArrayList<Jugador> ListaJugadores = new ArrayList<Jugador>();
			String registro ;

			while ((registro=fichero.readLine() ) != null) {
				String [] campos = registro.split("#");  
				Jugador jugador = new Jugador();
				jugador.setId(Integer.parseInt(campos[0]));
				jugador.setNif(campos[1]);
				jugador.setNombre(campos[2]);
				jugador.setLongitudPaso(Integer.parseInt(campos[3]));
				jugador.setFecha_nac(campos[4]);
				jugador.setSexo(campos[5].charAt(0));
				jugador.setDorsal(Integer.parseInt(campos[6]));
				jugador.setIdEquipo(Integer.parseInt(campos[7]));

				ListaJugadores.add(jugador);
			}
			 Collections.sort(ListaJugadores, Jugador.compareNamesPlayers);
			 System.out.println(ListaJugadores);
			
			fichero.close();
			System.out.println("Creada y ordenada la lista de jugadores");
			return ListaJugadores;
			
		} catch (FileNotFoundException excepcion) {
			System.out.println("fichero no encontrado");

		} catch (IOException e) {
			System.out.println("IO Excepcion");
		}
		return null;	
	}

		

	
	
	
	
	
	
	public static void main(String[]args){
		// 
		 Ejercicios ejercicios= new Ejercicios();
		 ArrayList<Jugador> resultadoEjercicio1 = ejercicios.ejercicio1("ficheros/jugadores.txt", "BARCELONA");
		  ArrayList<Jugador> resultadoEjercicio2 = ejercicios.ejercicio3_1("ficheros/jugadores.txt");
		 System.out.println("h");
	}
}
