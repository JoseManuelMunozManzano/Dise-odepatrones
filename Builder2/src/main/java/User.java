import java.time.LocalDate;

// Entity class used to construct the DTO
//
// Podemos pensar en ella como en una clase cuyos objetos obtendremos de una capa de persistencia y que está
// almacenado en BD.
//
// Y se va a usar este objeto para construir nuestro DTO (data transfer object)
public class User {
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private Address address;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
