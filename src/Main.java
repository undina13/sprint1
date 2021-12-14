import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        while (true) {
            System.out.println("Введите цифру команды");
            System.out.println("1 - Считать все месячные отчёты");
            System.out.println("2 - Считать годовой отчёт");
            System.out.println("3 - Сверить отчёты");
            System.out.println("4 - Вывести информацию о всех месячных отчётах");
            System.out.println("5 - Вывести информацию о годовом отчёте");


            Scanner scanner = new Scanner(System.in);
            int command = scanner.nextInt();

            if (command == 1) {
                Map<String, List<Item>> map = Util.getItemsOfMonth();

            } else if (command == 2) {
                Map<String, MonNew> map = Util.checkYear();

            } else if (command == 3) {
                Util.checkReport();

            } else if (command == 4) {
                Map<String, List<Item>> map = Util.getItemsOfMonth();
                for (Map.Entry<String, List<Item>> entry : map.entrySet()) {
                    int num = Integer.parseInt(entry.getKey());
                    System.out.println(NameOfMonth.values()[num - 1]);
                    Util.infoAboutMonth(entry.getValue());
                    System.out.println("");
                    System.out.println("");
                }

            } else if (command == 5) {
                System.out.println("Год 2021");
                Map<String, MonNew> map = Util.checkYear();
                int allAamount = 0;
                int allExpence = 0;

                for (Map.Entry<String, MonNew> entry : map.entrySet()) {
                    System.out.println("Месяц: " + entry.getKey() + " Прибыль: " + (entry.getValue().amount - entry.getValue().expense));
                    allAamount += entry.getValue().amount;
                    allExpence += entry.getValue().expense;
                }

                System.out.println("Средний расход за все месяцы в году - " + allAamount / map.size());
                System.out.println("Средний доход за все месяцы в году - " + allExpence / map.size());

            }
            else if(command==1000){
                System.out.println("Выход из программы");
                break;
            }
            else {
                System.out.println("Нет такой команды. Попробуйте еще раз");
            }
        }
    }

}




