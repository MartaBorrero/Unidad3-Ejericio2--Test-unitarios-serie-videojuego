package es.iessoterohernandez.daw.endes.Entregable;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VideojuegoTest {
	 private Videojuego videojuego;

	    @BeforeEach
	    public void setUp() {
	        videojuego = new Videojuego();
	    }
	    
	    @Test
	    public void testEntregar() {
	        assertFalse(videojuego.isEntregado());
	        videojuego.entregar();
	        assertTrue(videojuego.isEntregado());
	    }

	    @Test
	    public void testDevolver() {
	        videojuego.entregar();
	        assertTrue(videojuego.isEntregado());
	        videojuego.devolver();
	        assertFalse(videojuego.isEntregado());
	    }

	    @Test
	    public void testCompareTo() {
	        Videojuego juego1 = new Videojuego("Juego1", 50, "Aventura", "Compañia1");
	        Videojuego juego2 = new Videojuego("Juego2", 200, "Estrategia", "Compañia2");
	        Videojuego juego3 = new Videojuego("Juego3", 50, "Aventura", "Compañia3");

	        assertTrue(juego1.compareTo(juego2) < 0); // juego1 tiene menos horas estimadas que juego2
	        assertTrue(juego1.compareTo(juego3) == 0); // juego1 tiene el mismo número de horas estimadas que juego3
	        assertTrue(juego2.compareTo(juego3) > 0); // juego2 tiene más horas estimadas que juego3
	    }

	    @Test
	    public void testEquals() {
	        Videojuego juego1 = new Videojuego("Juego1", 100, "Aventura", "Compañia1");
	        Videojuego juego2 = new Videojuego("Juego1", 200, "Estrategia", "Compañia2");
	        Videojuego juego3 = new Videojuego("Juego2", 100, "Aventura", "Compañia1");
	        Videojuego juego4 = new Videojuego("Juego1", 100, "Aventura", "Compañia1");

	        assertFalse(juego1.equals(juego2)); // Juego1 y Juego2 tienen el mismo título pero compañías diferentes
	        assertFalse(juego1.equals(juego3)); // Juego1 y Juego3 tienen la misma compañía pero títulos diferentes
	        assertTrue(juego1.equals(juego4)); // Juego1 y Juego4 son iguales en título y compañía
	    }
}
