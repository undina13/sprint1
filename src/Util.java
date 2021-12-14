import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Util {
    public static final String PATHOFFILES = "C:/sprint1/resources/";

    public static String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

    public static File[] getFiles(String s) {

        return new File(PATHOFFILES).listFiles(new FilenameFilter() {
            public boolean accept(File directory, String fileName) {
                return fileName.startsWith(s);
            }
        });
    }


    public static Map<String, List<Item>> getItemsOfMonth() {
        File[] myFiles = getFiles("m.");
        Map<String, List<Item>> map = new HashMap<>();
        for (int i = 0; i < myFiles.length; i++) {
            String s = myFiles[i].getName().substring(6, 8);
            ArrayList<Item> items = new ArrayList<>();
            String res = Util.readFileContentsOrNull(myFiles[i].toString());
            String[] s1 = res.split("\\n");
            for (int j = 1; j < s1.length; j++) {
                String[] sItem = s1[j].split(",");
                String name = sItem[0];
                boolean is_expense = Boolean.parseBoolean(sItem[1]);
                int quantity = Integer.parseInt(sItem[2]);
                int sum_of_one = Integer.parseInt(sItem[3].substring(0, sItem[3].length() - 1));
                items.add(new Item(name, is_expense, quantity, sum_of_one));
            }
            map.put(s, items);
        }
        return map;
    }

    public static void checkReport() {
        Map<String, List<Item>> mapMonth = getItemsOfMonth();
        Map<String, MonNew> mapYear = Util.checkYear();
        for (Map.Entry<String, List<Item>> entry : mapMonth.entrySet()) {
            int amount = 0;
            int expense = 0;
            for (Item item : entry.getValue()) {
                if (item.is_expense) {
                    expense = expense + item.sum_of_one * item.quantity;
                } else {
                    amount = amount + item.sum_of_one * item.quantity;
                }
            }
            if (mapYear.get(entry.getKey()).expense != expense || mapYear.get(entry.getKey()).amount != amount) {
                int num = Integer.parseInt(entry.getKey());
                System.out.println(NameOfMonth.values()[num - 1]);
            }
        }
        System.out.println("Проверка  прошла успешно");
    }


    public static void infoAboutMonth(List<Item> items) {

        int max_amount = 0;
        String max = "";
        int max_expense = 0;
        String min = "";
        for (Item item : items) {
            if (item.is_expense) {
                if (item.quantity * item.sum_of_one > max_expense) {
                    max_expense = item.quantity * item.sum_of_one;
                    min = item.name;
                }
            } else {
                if (item.quantity * item.sum_of_one > max_amount) {
                    max_amount = item.quantity * item.sum_of_one;
                    max = item.name;
                }
            }
        }
        System.out.println("Самый прибыльный товар");
        System.out.println(max + " " + max_amount);
        System.out.println("Самая большая трата");
        System.out.println(min + " " + max_expense);
    }

    public static Map<String, MonNew> checkYear() {
        File[] myFiles = Util.getFiles("y.");
        String year = Util.readFileContentsOrNull(myFiles[0].toString());
        Map<String, MonNew> map = new HashMap<>();

        String[] s1 = year.split("\\n");
        for (int i = 1; i < s1.length; i++) {
            String[] sItem = s1[i].split(",");
            String mon = sItem[0];
            int amount = Integer.parseInt(sItem[1]);
            boolean is_expense = Boolean.parseBoolean(sItem[2].substring(0, sItem[2].length() - 1));
            if (map.containsKey(mon)) {
                MonNew monNew = map.get(mon);
                if (is_expense) {
                    monNew.setExpense(amount);
                } else {
                    monNew.setAmount(amount);
                }
                map.put(mon, monNew);
            } else {
                MonNew monNew = new MonNew();
                monNew.setMon(mon);
                if (is_expense) {
                    monNew.setExpense(amount);
                } else {
                    monNew.setAmount(amount);
                }
                map.put(mon, monNew);
            }
        }
        return map;
    }
}
