package test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import program.ConvertArabicToRoman;
import program.ReadConvertWrite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestUnit {

    ConvertArabicToRoman c= new ConvertArabicToRoman();
    ReadConvertWrite r= new ReadConvertWrite();

     @Test
      void testConwertV() {

    assertEquals("V",c.arabicToRomo("5"));
    }

    @Test
      void testConwertMCCLVI() {

        assertEquals("MCCLVI",c.arabicToRomo("1256"));
    }

    @Test
      void feindNumberFromText() throws IOException {
        List<String> l= new ArrayList<>();
        Collections.addAll(l, "1", "4", "1", "969", "1082", "2", "10", "1256",
                "1321", "90", "2", "3", "900", "5", "999", "1003", "12", "4");


         assertEquals(l,  r.listSearchNumbers());
    }

    @Test
    void feindTrackToFiles(){
         assertTrue(true, r.trackToFiles());
     }
      


    @Test
    @Disabled
    void testConvertFalse(){
        String min="I";
        String max="V";

    }

}
