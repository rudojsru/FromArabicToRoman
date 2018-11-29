package program;

public class ConvertArabicToRoman {
    static String[] rome = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    static int[] arabic = {1000, 900,  500,  400, 100,  90,  50,   40,  10,    9,   5,   4,    1};

    public String arabicToRomo(String ara) {
        int arab =  Integer.parseInt(ara);
        String arabConvert = "";
        if (arab > 0) {
            for (int i = 0; arab !=0; i++) {
               if (arab>=arabic[i]){
                   while (arab >=arabic[i]){
                       arabConvert +=rome[i];
                       arab -=arabic[i];
                   }

               }
            }

        }

        return arabConvert;

    }


//    public static void main(String[] args) {
//        System.out.println(arabicToRomo("2562"));
//    }
}
