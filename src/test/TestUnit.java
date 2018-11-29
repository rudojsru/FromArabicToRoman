package test;

import org.junit.jupiter.api.Test;
import program.ConvertArabicToRoman;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class TestUnit {

    ConvertArabicToRoman c= new ConvertArabicToRoman();

     @Test
    public void testConwert() {

    assertEquals("V",c.arabicToRomo("5"));
    }
}
