package ged.gont.testbst.testhuffmancode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.BitSet;

import org.junit.jupiter.api.*;
import ged.gont.bst.huffmancode.*;

public class TestHuffmanCode {

    static HuffmanCode huffmanCode;
    static String inputString;
    static String expectedEncodedString;

    @BeforeAll
    public static void init() {
        huffmanCode = new HuffmanCode();
        inputString = "A_DEAD_DAD_CEDED_A_BAD_BABE_A_BEADED_ABACA_BED";
        expectedEncodedString = "1000011101001000110010011101100111001001000111110010011111011111100010001111110100111001001011111011101000111111001";
    }

    @Test
    public void testEncode() {
        assertEquals(expectedEncodedString, convertString(huffmanCode.encode(inputString)));
    }

    @Test
    public void testDecode() {
        assertEquals(inputString, huffmanCode.decode(huffmanCode.encode(inputString)));
    }

    private String convertString(BitSet encodedBitSet){
        String convertedString = "";

        for (int i = 0; i < encodedBitSet.length(); i++) {
            if(!encodedBitSet.get(i)){
                convertedString += '0';
            }else{
                convertedString += '1';
            }
        }
        return convertedString;
    }
}