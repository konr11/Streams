import java.io.Serializable;
import java.util.Objects;

public class Actor implements Serializable {

    private static final long serialVersionUID = 1L;

    private String first_name = "";

    private String last_name = "";

    public Actor(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Actor)) return false;
        Actor actor = (Actor) o;
        return Objects.equals(getFirst_name(), actor.getFirst_name()) && Objects.equals(getLast_name(), actor.getLast_name());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirst_name(), getLast_name());
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

}
