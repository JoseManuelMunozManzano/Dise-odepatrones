// Se va a realizar otra implementación del patrón Builder que se suele usar en los proyectos
//
// No tenemos constructor!
// Pero queremos construir una instancia inmutable de esta clase
//
// También vemos que los métodos setter son privados, y con esto queremos decir que nuestro objeto UserDto va a ser
// un objeto inmutable.
//
// Cómo afecta esto al Builder?
// Vemos que se ha declarado nuestro Builder, UserDtoBuilder, como una clase estática interna
// Esta es una forma muy común de implementar un Builder, contenido en la clase cuyo objeto va a construirse.
// Beneficios:
// 1. Proporciona un buen espacio de nombres (namespace) para nuestro builder.
// 2. Como es una clase interna, el builder SI que puede usar los métodos setter que son privados en la clase padre.
//    Así puede construirse nuestro objeto inmutable sin tener que escribir un constructor complejo o que necesite
//    mucha información.

import java.time.LocalDate;
import java.time.Period;

// Product class
public class UserDTO {

    private String name;
    private String address;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    private void setAddress(String address) {
        this.address = address;
    }

    private String getAge() {
        return age;
    }

    private void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "name=" + name + "\nage=" + age + "\naddress=" + address;
    }

    // Get builder instance
    // Un cambio adicional que se ve mucho en las implementaciones, aunque no es requerido, es este método estático
    // dentro de nuestra clase Producto.
    // Sencillamente, devuelve una instancia de nuestro builder.
    // Por supuesto, como nuestro builder es una clase pública estática, no necesitamos este método, pudiendo
    // crear el builder fuera. Pero es una práctica común.
    public static UserDtoBuilder getBuilder() {
        return new UserDtoBuilder();
    }

    // Builder
    public static class UserDtoBuilder {

        private String firstName;
        private String lastName;
        private String age;
        private String address;
        private UserDTO userDto;

        public UserDtoBuilder withFirstName(String fname) {
            this.firstName = fname;
            return this;
        }

        public UserDtoBuilder withLastName(String lname) {
            this.lastName = lname;
            return this;
        }

        public UserDtoBuilder withBirthday(LocalDate date) {
            age = Integer.toString(Period.between(date, LocalDate.now()).getYears());
            return this;
        }

        public UserDtoBuilder withAddress(Address address) {
            this.address = address.getHouseNumber() + " " + address.getStreet()
                    + "\n" + address.getCity() + ", " + address.getState() + " " + address.getZipcode();

            return this;
        }

        // Lo que cambia con respecto a la versión anterior del Builder, es que en vez de usar el constructor
        // de nuestra clase Producto para establecer sus propiedades, se están usando los métodos setter.
        public UserDTO build() {
            this.userDto = new UserDTO();
            userDto.setName(firstName + " " + lastName);
            userDto.setAddress(address);
            userDto.setAge(age);

            return this.userDto;
        }

        public UserDTO getUserDto() {
            return this.userDto;
        }
    }
}
