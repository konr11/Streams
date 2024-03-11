package koevasilev.notebook;

import java.util.Objects;

/**
 * Класс Заметки
 *
 * @author Константин Васильев
 * @version 1.0
 */
public class Note {
    /**
     * Конструктор - создание нового объекта Заметка
     *
     * @param id   Id заметки
     * @param text текст заметки
     */
    public Note(String text, int id) {
        this.note = text;
        this.Id = id;
    }

    /**
     * Поле заметка
     */
    private String note;
    /**
     * Поле Id заметки
     */
    private int Id = 0;

    /**
     * Функция преобразования объекта Note в String
     *
     * @return возвращает String: текст и Id заметки
     */
    @Override
    public String toString() {
        return "Note: " + note + " Id: " + Id;
    }

    /**
     * Запись в поле заметка
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * Получение значения поля Id
     *
     * @return возвращает Id заметки
     */
    public int getId() {
        return Id;
    }

    public String getNote() {
        return note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Note)) return false;
        Note note1 = (Note) o;
        return Objects.equals(getNote(), note1.getNote());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNote());
    }
}
