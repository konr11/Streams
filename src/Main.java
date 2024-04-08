
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        System.out.println("Hello and welcome!");
        WorkWithByte workWithByte = new WorkWithByte();
        workWithByte.readFile("Data\\note.java");
        WorkWithSymbols workWithSymbols = new WorkWithSymbols();
        workWithSymbols.readFile("Data\\note.java");

        FilmCollection fc = new FilmCollection();
        fc.addFilm(new Film("Интерстеллар", new Actor[]{new Actor("Мэттью", "Макконахи"), new Actor("Энн", "Хэтэуэй")}));
        fc.addFilm(new Film("Джентльмены", new Actor[]{new Actor("Мэттью", "Макконахи"), new Actor("Чарли", "Ханнэм")}));
        System.out.println(fc.getFilms());

        Operation oper = new Operation();
        oper.save(fc);

        fc.addFilm(new Film("Gor", new Actor[]{new Actor("Мэттью", "Макконахи"), new Actor("Чарли", "Ханнэм")}));

        System.out.println(fc.getFilms());

        fc = oper.load("Data\\Save\\save.ser");
        System.out.println(fc.getFilms());


    }
}