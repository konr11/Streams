import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

//Прочитайте файл, содержащий код на языке Java.
// Определите, какие ключевые слова языка Java этот код содержит.
// Выведите эти слова и их количество в другой файл.
// Используйте только символьные потоки ввода-вывода.

public class WorkWithSymbols {
    private final String[] keywords = {"class", "public", "private", "void", "return", "this"};


    public void readFile(String inpFile, String outFile) {
        HashSet<Integer> index = new HashSet<Integer>();
        ArrayList<String> occurrences = new ArrayList<>();
        StringBuilder res = new StringBuilder();
        try (BufferedReader fin = new BufferedReader(new FileReader(inpFile))) {
            int i;
            StringBuilder text = new StringBuilder();
            while ((i = fin.read()) != -1) {
                text.append((char) i);
                if ('\n' == (char) i) {
                    for (String row : keywords) {
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
            for (String item : keywords) {
                int count = 0;
                for (String row : occurrences) {
                    if (item.equals(row))
                        count++;
                }
                res.append(item).append(": ").append(count).append("\n");
                count = 0;
            }
            System.out.println(res);
            System.out.println(writeToFile(outFile, res.toString()));

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private String writeToFile(String file, String text) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(file).getAbsoluteFile()))) {

            bw.write(text);
        } catch (FileNotFoundException e) {
            return e.getMessage();
        } catch (IOException e) {
            return e.getMessage();
        }

        return "The file has been written";
    }
}
