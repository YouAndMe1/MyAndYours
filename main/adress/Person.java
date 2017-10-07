
public class Person{
    private String fio,
            address,
            cellPhone,
            description,
            age;

    public Person(String... args) {
        this.fio = args[0];
        this.age = args[1];
        this.address = args[2];
        this.cellPhone = args[3];
        this.description = args[4];
    }

    public String getFio() {
        return fio;
    }

    public String getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return String.format("Fio:%s; age:%s; address:%s; cellPhone:%s; decription:%s", fio.toString(), age.toString(), address.toString(), cellPhone.toString(), description.toString());
    }

    public static void main(String[] args) {

    }

}
