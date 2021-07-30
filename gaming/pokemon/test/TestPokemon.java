package pokemon.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

public class TestPokemon {

    @BeforeEach
    public void setUp() {}

    @AfterEach
    public void tearDown() {}

    @Test
    @DisplayName("List creation should result in 2 entries.")
    public void testListCreation() {
        assertEquals("", PokemonList.get("Caterpie"));
        assertEquals("", PokemonList.get("Blastoise"));
        assertEquals(2, PokemonList.amount());
    }

}
