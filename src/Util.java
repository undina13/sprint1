import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Util {
    public static String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

    public static List<Item> getItemsOfMonth(String s) {
        ArrayList<Item> items = new ArrayList<>();
        String[] s1 = s.split("\\n");
        for (int i = 1; i < s1.length; i++) {
            String[] sItem = s1[i].split(",");
            String name = sItem[0];
            System.out.println(name);
            boolean is_expense = Boolean.parseBoolean(sItem[1]);
            System.out.println(is_expense);
            int quantity = Integer.parseInt(sItem[2]);
            System.out.println(quantity);
            int sum_of_one = Integer.parseInt(sItem[3].substring(0, sItem[3].length() - 1));
            System.out.println(sum_of_one);
            items.add(new Item(name, is_expense, quantity, sum_of_one));
        }
        return items;
    }

    public static List<Month> getMonthList(String s){
        ArrayList<Month> items = new ArrayList<>();
        String[] s1 = s.split("\\n");
        for (int i = 1; i < s1.length; i++) {
            String[] sItem = s1[i].split(",");
            String mon = sItem[0];
            System.out.println(mon);
            int amount = Integer.parseInt(sItem[1]);
            System.out.println(amount);
            boolean is_expense = Boolean.parseBoolean(sItem[2].substring(0, sItem[2].length() - 1));
            System.out.println(is_expense);
            items.add(new Month(mon, amount, is_expense));
        }
        return items;
    }

    public static void checkReport(){

    }


}
