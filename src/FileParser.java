import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class FileParser {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Потрібно передати ім'я файлу в якості параметра");
            return;
        }

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(args[0]));
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println("Введений рядок: " + line);

                StringTokenizer tokenizer = new StringTokenizer(line);
                System.out.print("Рядок складається з: ");

                while (tokenizer.hasMoreTokens()) {
                    String token = tokenizer.nextToken();
                    try {
                        double number = Double.parseDouble(token);
                        System.out.printf("%s - це число = %.1f\n", token, number);
                    } catch (NumberFormatException e) {
                        System.out.printf("%s - це не число\n", token);
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдений");
        } catch (IOException e) {
            System.out.println("Помилка введення/виведення");
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Помилка закриття потоку");
                    e.printStackTrace();
                }
            }
        }
    }
}