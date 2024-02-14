package es.iessoterohernandez.daw.endes.Entregable;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SerieTest {
	
	private Serie serie;

	@BeforeEach
	public void setUp() {
		serie = new Serie();
	}

	@Test
	public void testEntregar() {
		assertFalse(serie.isEntregado());
		serie.entregar();
		assertTrue(serie.isEntregado());
	}

	@Test
	public void testDevolver() {
		serie.entregar();
		assertTrue(serie.isEntregado());
		serie.devolver();
		assertFalse(serie.isEntregado());
	}

	@Test
	public void testCompareTo() {
		Serie serie1 = new Serie("Serie1", 5, "Drama", "Creador1");
		Serie serie2 = new Serie("Serie2", 3, "Comedia", "Creador2");
		Serie serie3 = new Serie("Serie3", 5, "Thriller", "Creador3");

		assertTrue(serie1.compareTo(serie2) > 0); // serie1 tiene más temporadas que serie2
		assertTrue(serie1.compareTo(serie3) == 0); // serie1 tiene el mismo número de temporadas que serie3
		assertTrue(serie2.compareTo(serie3) < 0); // serie2 tiene menos temporadas que serie3
	}

	@Test
	public void testEquals() {
		Serie serie1 = new Serie("Serie1", 5, "Drama", "Creador1");
		Serie serie2 = new Serie("Serie1", 3, "Comedia", "Creador2");
		Serie serie3 = new Serie("Serie2", 5, "Drama", "Creador1");
		Serie serie4 = new Serie("Serie1", 5, "Drama", "Creador1");

		assertFalse(serie1.equals(serie2)); // Serie1 y Serie2 tienen el mismo título pero creadores diferentes
		assertFalse(serie1.equals(serie3)); // Serie1 y Serie3 tienen el mismo creador pero títulos diferentes
		assertTrue(serie1.equals(serie4)); // Serie1 y Serie4 son iguales en título y creador
	}

}
