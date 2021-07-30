package gaming.pokemon.test;

import gaming.pokemon.PokemonList;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;

public class TestPokemon {

    @BeforeEach
    public void setUp() {
        /* NOP. */
    }

    @AfterEach
    public void tearDown() {
        /* NOP. */
    }

    @Test
    @DisplayName("List creation should result in 2 entries.")
    public void testListCreation() {
        assertEquals("", PokemonList.get("Caterpie"));
        assertEquals("", PokemonList.get("Blastoise"));
        assertEquals(2, PokemonList.amount());
    }

}