public class Application {

    public static void main(String[] args) {

        Parser parser = new ParserPerson();
        processFile(parser, "test_person.txt");
        print(parser);


        parser = new ParserBook();
        processFile(parser, "test_book.txt");
        print(parser);

    }

    public static void print(Parser parser) {
        parser.printInConsole();
    }

    public static void processFile(Parser parser, String s) {
        parser.readFile(s);
        parser.wrightFile();
    }
}
