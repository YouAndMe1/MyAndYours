public abstract class Parser {

    abstract void printInConsole();

    abstract void readFile(String s);

    abstract void wrightFile();

    protected String[] formatString(String s) {
        String[] arrayString;
        arrayString = s.split("\\|");
        for (int i = 0; i < arrayString.length; i++)
            arrayString[i] = arrayString[i].trim();
        return arrayString;

    }

}
