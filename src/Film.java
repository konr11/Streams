import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Film implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name = "";

    private Actor[] actors;

    public Film(String name) {
        this.name = name;
    }

    public Film(String name, Actor[] actors) {
        this.name = name;
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Film{" +
                "name='" + name + '\'' +
                ", actors=" + Arrays.toString(actors) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Film)) return false;
        Film film = (Film) o;
        return Objects.equals(getName(), film.getName()) && Arrays.equals(getActors(), film.getActors());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getName());
        result = 31 * result + Arrays.hashCode(getActors());
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Actor[] getActors() {
        return actors;
    }

    public void setActors(Actor[] actors) {
        this.actors = actors;
    }
}
