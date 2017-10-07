
public class Book {
    private String title,
            date,
            author;

    public Book(String... args) {
        this.title = args[0];
        this.date = args[1];
        this.author = args[2];
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return String.format("Title:%s; date:%s; author:%s", title.toString(), date.toString(), author.toString());
    }

    public static void main(String[] args) {

    }

}
