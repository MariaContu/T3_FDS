package com.example.T3_FDS;

import org.junit.jupiter.api.Test;
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
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++){
                barca.ocupaLugarSemVerificacao(i, j);
            }
        }
        assertEquals(0, barca.ocupaLugar("F61A01")); // Fileira fora do intervalo permitido (on-point)
        assertEquals(3, barca.ocupaLugar("F60A01")); // Fileira no intervalo permitido (off-point)
        assertEquals(1, barca.ocupaLugar("F02A10")); // testOcupado()
    }

    @Test
    public void testUltimoAssento(){
        assertEquals(0, barca.ocupaLugar("F02A60")); // on-point
        assertEquals(0, barca.ocupaLugar("F02A61")); // off-point
        assertEquals(0, barca.ocupaLugar("F02A10")); // testOcupado()
    }

    @Test
    public void testFormato(){
        assertEquals(0, barca.ocupaLugar("F2A01"));  // Formato incorreto (faltando um dígito) on-point
        assertEquals(0, barca.ocupaLugar("F02A01")); // off-point
        assertEquals(0, barca.ocupaLugar("F02A10")); // testOcupado()

    }

    @Test
    public void testOcupado(){
        barca.ocupaLugarSemVerificacao(2, 10); // Assento sendo ocupado (off-point)
        assertEquals(1, barca.ocupaLugar("F02A10")); // Assento já ocupado (on-point)
        assertEquals(3, barca.ocupaLugar("F02A11")); // 
    }

    @Test
    public void testDistribuicaoDePeso(){
        // Não permitido pela distribuição de peso
        //assertEquals(2, barca.ocupaLugar("F21A01"));
        assertEquals(3, barca.ocupaLugar("F20A10")); // on-point
        assertEquals(2, barca.ocupaLugar("F21A01")); // off-point
        assertEquals(3, barca.ocupaLugar("F02A10")); // testOcupado()
        assertEquals(2, barca.ocupaLugar("F60A20")); // sentaCerto()
        //assertEquals(2, barca.ocupaLugar("F60A10"));
    }

    @Test
    public void sentaCerto(){
        // Passageiro senta-se na fileira permitida
        assertEquals(3, barca.ocupaLugar("F61A20")); // off-point
        assertEquals(3, barca.ocupaLugar("F60A20")); // on-point    
        assertEquals(3, barca.ocupaLugar("F39A10")); // testDistribuicaoDePeso()
    }



}
