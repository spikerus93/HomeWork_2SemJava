import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class task1 {
    public static void main(String[] args) throws IOException {
        int[] arr = {};

        if (args.length == 0) {
            arr = new int[]{9, 4, 8, 3, 1};

        } else {
            arr = Arrays.stream(args[0].split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        BubbleSort ans = new BubbleSort();
        ans.sort(arr);

        try (BufferedReader br = new BufferedReader(new FileReader("log.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
        //              e.printStackTrace();          arr = new int[]{9, 4, 8, 3, 1};
//sort(arr)
//Реализуйте алгоритм сортировки пузырьком числового массива,
// результат после каждой итерации запишите в лог-файл.
//
//Напишите свой код в методе sort класса BubbleSort.
// Метод sort принимает на вход один параметр:
//
//int[] arr - числовой массив
//
//После каждой итерации, ваш код должен делать запись
// в лог-файл 'log.txt' в формате:
// год-месяц-день час:минуты {массив на данной итерации}.
//// При чтении лог-файла получим:
//2023-05-19 07:53 [4, 8, 3, 1, 9]
//2023-05-19 07:53 [4, 3, 1, 8, 9]
//2023-05-19 07:53 [3, 1, 4, 8, 9]
//2023-05-19 07:53 [1, 3, 4, 8, 9]
//2023-05-19 07:53 [1, 3, 4, 8, 9]
        class BubbleSort {
            private static File log;
            private static FileWriter fileWriter;

            public static void sort(int[] mas) {
                String logPath = "log.txt";
                StringBuilder sb = new StringBuilder();

                int count = mas.length;
                while (count != 0) {
                    count = 0;
                    for (int i = 0; i < mas.length-1; i++) {
                        if (mas[i] > mas[i + 1]) {
                            int temp = mas[i];
                            mas[i] = mas[i + 1];
                            mas[i + 1] = temp;
                            count++;
                        }

                    }
                    Date date = new Date();
                    SimpleDateFormat form = new SimpleDateFormat("yyyyy-MM-dd HH:mm");
                    sb.append(form.format(date)).append(" ").append(Arrays.toString(mas));
                    sb.append("\n");
                    String logLine = sb.toString();
                    writeToFile(logLine, logPath);
                }

            }


        static void writeToFile (String logLine, String filePath){
            try (FileWriter writer = new FileWriter(filePath)) {
                writer.write(logLine + System.lineSeparator());
                writer.flush();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Ошибка");
            }


        }
    }



