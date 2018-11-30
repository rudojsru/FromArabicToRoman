package program;

import program.ConvertArabicToRoman;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadConvertWrite {

    String track = trackToFiles();
    final String TEXT = track + "/Report.txt";
 //Search all numbers (Arabic) in the Report
    public List<String> listSearchNumbers() throws IOException {

        BufferedReader br;
        List<String> numbersFromText = new ArrayList<>();    // here we collect all the numbers from the text

        try {
            br = new BufferedReader(new FileReader(TEXT));
            String searchNumber = "";

            while ((searchNumber = br.readLine()) != null) {
                Pattern pattern = Pattern.compile("\\b[\\d]+\\b");  //
                Matcher matcher = pattern.matcher(searchNumber);
                while (matcher.find()) {
                    searchNumber = matcher.group();
                    numbersFromText.add(searchNumber);    //  add the found number to the List
                }
            }
            br.close();
            System.out.println(numbersFromText);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numbersFromText;
    }
      public void replacementTextFromArabToRom(List numbersFromText) throws IOException {

  // We find the Arabic number in the text and replace it with the Roman one.
        Path path = Paths.get(TEXT);
        Path path2 = Paths.get(track+"/ReportCopi.txt");
        Charset charset = StandardCharsets.UTF_8;
        ConvertArabicToRoman c =new ConvertArabicToRoman();      // class where numbers are converted

        String content = new String(Files.readAllBytes(path), charset);
        for (int i = 0; i <numbersFromText.size() ; i++) {
            String t1= (String) numbersFromText.get(i);
            String t2= c.arabicToRomo(t1);          // converting arabic numbers to roman
            content = content.replaceFirst(t1, t2);
            Files.write(path2, content.getBytes(charset));
        }

    }

    public  String trackToFiles() {          //  Track to the place where the file is located
        String track=new File(".").getAbsolutePath();

        String [] splitTrack =track.split("");
        track="";


        for (int i=0; i<splitTrack.length-1; i++){
            track+=splitTrack[i];

        }


        System.out.println(track);
        return track;

    }
}
