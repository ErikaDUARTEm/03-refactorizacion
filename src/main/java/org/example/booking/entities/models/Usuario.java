package org.example.booking.entities.models;

public class Usuario {
    protected String name;
    protected String lastName;
    protected String email;
    protected String nationality;
    protected String phone;

    public Usuario(String name, String lastName, String email, String nationality, String phone) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.nationality = nationality;
        this.phone = phone;

    }

    protected Usuario() {
    }

    public String viewUsuario() {
        return String.format(
                "************** Detalles del Hotel **********************%n" +
                        "Nombre: %s%n" +
                        "Apellido: %s%n" +
                        "Email: %s%n" +
                        "Nacionalidad: %s%n" +
                        "Telefono: %s%n",
                this.getName(),
                this.getLastName(),
                this.getEmail(),
                this.getNationality(),
                this.getPhone()
        );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
