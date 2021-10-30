import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Scanner;
import java.util.Date;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class bullAndCow_2 {
    public static void main(String[] args) {
        String nameCows = "";
        String nameBulls = "";
        String aCompNum = "";
        String myNum = "";
        String data = "";
        String data_game = "";

        int bulls = 0;
        int cows = 0;
        int replay = 0;
        int game = 1;
        SimpleDateFormat format_date = new SimpleDateFormat("dd.MM.yyyy hh:mm");


        do {
            //число компьютера
            Random rand = new Random();
            int cr = rand.nextInt(2001);
            String compRand = Integer.toString(cr);
            if (compRand.length() == 3) {
                aCompNum = ("0" + compRand);
            } else if (compRand.length() == 2) {
                aCompNum = ("00" + compRand);
            } else if (compRand.length() == 1) {
                aCompNum = ("000" + compRand);
            } else {
                aCompNum = (compRand);
            }
            Date date = new Date();
            replay = 0;

            System.out.println(aCompNum);

            do {
                // ввод с клавиатуры
                Scanner sc = new Scanner(System.in);
                System.out.print("Ввести число до 2000: ");
                myNum = sc.nextLine();
                if (myNum.length() == 3) {
                    myNum = ("0" + myNum);
                } else if (myNum.length() == 2) {
                    myNum = ("00" + myNum);
                } else if (myNum.length() == 1) {
                    myNum = ("000" + myNum);
                } else {
                    myNum = (myNum);
                }
                bulls = 0;
                cows = 0;
                replay += 1;
                // находим быков и коров
                for (int i = 0; i < 4; i++)
                    for (int j = 0; j < 4; j++) {
                        if (myNum.charAt(i) == aCompNum.charAt(j) && i == j)
                            bulls += 1;
                        if (myNum.charAt(i) == aCompNum.charAt(j) && i != j) {
                            cows += 1;
                        }
                    }
                if (cows == 1)
                    nameCows = "корова";
                else if (cows > 1 && cows < 5)
                    nameCows = "коровы";
                else if (cows >= 5 || cows == 0)
                    nameCows = "коров";

                if (bulls == 1)
                    nameBulls = "бык";
                else if (bulls > 1 && bulls < 5)
                    nameBulls = "быка";
                else if (bulls >= 5 || bulls == 0)
                    nameBulls = "быков";
                data_game = "Game №: "+game+" ";
                data = (" Загаданная строка: " + aCompNum + "\n" + "Запрос: " + aCompNum + " Ответ: " + cows + " " + nameCows + " " + bulls + " " + nameBulls + "\n"+"Строка была угадана за: " + replay + " попыток"+"\n");
            } while (bulls != 4);

            System.out.println("Строка была угадана за: " + replay + " попыток");
            System.out.println("Загаданная строка: " + aCompNum);
            if (bulls == 4) {
                game += 1;
            }

            try {
                if (bulls == 4) {
                    Files.write(Paths.get("C:/Users/anton/Desktop/Bulls_and_Cows.txt"), data_game.getBytes(), StandardOpenOption.APPEND);
                    Files.write(Paths.get("C:/Users/anton/Desktop/Bulls_and_Cows.txt"), format_date.format(date).getBytes(), StandardOpenOption.APPEND);
                }
                Files.write(Paths.get("C:/Users/anton/Desktop/Bulls_and_Cows.txt"), data.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (game != 100);
    }
}

