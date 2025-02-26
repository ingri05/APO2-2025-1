package model;

public class Client {
    public String name;
    public String id;
    public String phone;

    public Client(String name, String id, String phone) {
        this.name = name;
        this.id = id;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return name + "," + id + "," + phone;
    }
}
