import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите цифру команды");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
      //  System.out.println("Для выхода напишите exit");


       Scanner scanner = new Scanner(System.in);
        int command= scanner.nextInt();

        if(command == 1){
            String january =  Util.readFileContentsOrNull("C:/sprint1/resources/m.202101.csv");
            String february =  Util.readFileContentsOrNull("C:/sprint1/resources/m.202102.csv");
            String march =  Util.readFileContentsOrNull("C:/sprint1/resources/m.202103.csv");
        }
        else if(command == 2){
            String year =  Util.readFileContentsOrNull("C:/sprint1/resources/y.2021.csv");
        }
        else if(command == 3){
            String january =  Util.readFileContentsOrNull("C:/sprint1/resources/m.202101.csv");
            List<Item> jan = Util.getItemsOfMonth(january);
            Util.checkReport(jan, "01");

            String february =  Util.readFileContentsOrNull("C:/sprint1/resources/m.202102.csv");
            List<Item> feb = Util.getItemsOfMonth(february);
            Util.checkReport(feb, "02");

            String march =  Util.readFileContentsOrNull("C:/sprint1/resources/m.202103.csv");
            List<Item> mar = Util.getItemsOfMonth(march);
            Util.checkReport(mar, "03");

            System.out.println("Проверка  прошла успешно");

        }



    }



}

