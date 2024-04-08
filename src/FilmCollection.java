import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;

//Дана коллекция фильмов, содержащая информацию об актерах, снимавшихся в главных ролях (один актер мог сниматься и в нескольких фильмах).
// Необходимо написать консольное приложение, позволяющее при запуске восстанавливать коллекцию фильмов, позволять ее модифицировать,
// а по завершении работы приложения – сохранять в файл. Для восстановления/сохранения коллекции использовать сериализацию/десериализацию.
public class FilmCollection implements Serializable {

    private static final long serialVersionUID = 1L;
    HashSet<Film> films = new HashSet<>();

    public void addFilm(Film film) {
        if (!films.contains(film)) {
            films.add(film);
        } else {
            System.out.println("Фильм уже есть в коллекции");
        }
    }

    public HashSet<Film> getFilms() {
        return films;
    }

    @Override
    public String toString() {
        return "FilmCollection{" +
                "films=" + films +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FilmCollection)) return false;
        FilmCollection that = (FilmCollection) o;
        return Objects.equals(getFilms(), that.getFilms());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFilms());
    }
}
