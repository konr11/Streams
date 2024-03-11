import java.io.*;
import java.util.ArrayList;

//Прочитайте файл, содержащий код на языке Java.
// Определите, какие ключевые слова языка Java этот код содержит.
// Выведите эти слова и их количество в другой файл.
// Используйте только символьные потоки ввода-вывода.

public class WorkWithSymbols {
    private final String[] Keywords = {"class", "public", "private", "void", "return", "this"};
    private ArrayList<Integer> index = new ArrayList<Integer>();
    private ArrayList<String> occurrences = new ArrayList<>();
    private String res = "";

    public void readFile(String inpFile) {
        try (BufferedReader fin = new BufferedReader(new FileReader(inpFile))) {
            int i;
            StringBuilder text = new StringBuilder();
            while ((i = fin.read()) != -1) {
                text.append((char) i);
                if ('\n' == (char) i) {
                    for (String row : Keywords) {
                        int i1 = text.lastIndexOf(row);
                        if (i1 != -1) {
                            if (!index.contains(i1)) {
                                occurrences.add(row);
                                index.add(i1);
                            }
                        }
                    }
                }
            }
            for (String item : Keywords) {
                int count = 0;
                for (String row : occurrences) {
                    if (item.equals(row))
                        count++;
                }
                res = res + item + ": " + count + "\n";
                count = 0;
            }
            System.out.println(res);
            System.out.println(writeToFile(res));

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private String writeToFile(String text) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Data\\ResultSymbol.txt").getAbsoluteFile()))) {

            bw.write(text);
        } catch (FileNotFoundException e) {
            return e.getMessage();
        } catch (IOException e) {
            return e.getMessage();
        }

        return "The file has been written";
    }
}
