import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;


//Прочитайте файл, содержащий код на языке Java.
// Определите, какие ключевые слова языка Java этот код содержит.
// Выведите эти слова и их количество в другой файл.
// Используйте только байтовые потоки ввода-вывода.Прочитайте файл, содержащий код на языке Java.
// Определите, какие ключевые слова языка Java этот код содержит.
// Выведите эти слова и их количество в другой файл.
// Используйте только байтовые потоки ввода-вывода.
public class WorkWithByte {

    private final String[] keywords = {"class", "public", "private", "void", "return", "this"};

    public void readFile(String inpFile, String outFile) {
        HashSet<Integer> index = new HashSet<Integer>();
        ArrayList<String> occurrences = new ArrayList<>();
        StringBuilder res = new StringBuilder();
        try (FileInputStream fin = new FileInputStream(inpFile)) {
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
        try (FileOutputStream fos = new FileOutputStream(file)) {
            byte[] buffer = text.getBytes();

            fos.write(buffer, 0, buffer.length);
        } catch (FileNotFoundException e) {
            return e.getMessage();
        } catch (IOException e) {
            return e.getMessage();
        }

        return "The file has been written";
    }
}
