package model;

import java.time.LocalDate;

public class Client {
    private String name;
    private String id;
    private String phone;
    private LocalDate birthDate;

    public Client(String name, String id, String phone, LocalDate birthDate) {
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.birthDate = birthDate;
    }

    public String getId() {
        return id;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "Client{name='" + name + "', id='" + id + "', birthDate=" + birthDate + "}";
    }
}
