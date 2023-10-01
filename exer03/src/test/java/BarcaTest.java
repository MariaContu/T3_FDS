import org.junit.jupiter.api.Test;

import com.bcopstein.Barca;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;

public class BarcaTest {
    private Barca barca;
    @BeforeEach
    void setUp(){
        // Crie uma instância da classe Barca
        barca = new Barca();// Crie uma instância da classe Barca
    }
    // Casos de teste definidos na letra "a"
    @Test
    public void testUltimaFileira() {
        assertEquals(0, barca.ocupaLugar("F61A01")); // Fileira no intervalo permitido (off-point)
        assertEquals(0, barca.ocupaLugar("F60A01")); // Fileira fora do intervalo permitido (on-point)
        assertEquals(0, barca.ocupaLugar("F02A10")); // testOcupado()
    }

    @Test
    public void testUltimoAssento(){
        assertEquals(0, barca.ocupaLugar("F02A61")); // off-point
        assertEquals(0, barca.ocupaLugar("F02A60")); // on-point
        assertEquals(0, barca.ocupaLugar("F60A01")); // testUltimaFileira()
        assertEquals(0, barca.ocupaLugar("F39A10")); // testDistribuicaoDePeso()
    }

    @Test
    public void testFormato(){
        assertEquals(0, barca.ocupaLugar("F2A01"));  // Formato incorreto (faltando um dígito) on-point
        assertEquals(0, barca.ocupaLugar("F02A01")); // off-point
    }

    @Test
    public void testOcupado(){
        assertEquals(1, barca.ocupaLugar("F02A10")); // Assento sendo ocupado
        assertEquals(1, barca.ocupaLugar("F02A10")); // Assento já ocupado
        assertEquals(1, barca.ocupaLugar("F02A11")); //off-point
    }

    @Test
    public void testDistribuicaoDePeso(){
        // Não permitido pela distribuição de peso
        //assertEquals(2, barca.ocupaLugar("F21A01"));
        assertEquals(2, barca.ocupaLugar("F39A10")); //on-point
        assertEquals(2, barca.ocupaLugar("F40A01")); //off-point
        assertEquals(2, barca.ocupaLugar("F60A20"));   
        //assertEquals(2, barca.ocupaLugar("F60A10"));
    }

    @Test
    public void sentaCerto(){
        // Passageiro senta-se na fileira permitida
        assertEquals(3, barca.ocupaLugar("F02A10")); // Assento já ocupado
        assertEquals(3, barca.ocupaLugar("F60A10"));
        assertEquals(3, barca.ocupaLugar("F61A21")); //off-point
        assertEquals(3, barca.ocupaLugar("F60A20")); //on-point    
    }



}
