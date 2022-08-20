// El cliente apenas cambia.

import java.time.LocalDate;

public class Client {
    public static void main(String[] args) {
        User user = createUser();

        // Al construir el builder, en vez de usar el constructor concreto de nuestro builder, se usa el método estático
        // definido en la clase Producto.

        // Client has to provide director with concrete builder
        UserDTO dto = directBuild(UserDTO.getBuilder(), user);
        System.out.println(dto);
    }

    // This method serves the role of director in builder pattern
    private static UserDTO directBuild(UserDTO.UserDtoBuilder builder, User user) {
        return builder.withFirstName(user.getFirstName()).withLastName(user.getLastName())
                .withBirthday(user.getBirthday()).withAddress(user.getAddress()).build();
    }

    // Returns a sample user
    private static User createUser() {
        User user = new User();
        user.setBirthday(LocalDate.of(1978, 10, 30));
        user.setFirstName("José Manuel");
        user.setLastName("Muñoz Manzano");
        Address address = new Address();
        address.setHouseNumber("100");
        address.setStreet("State Street");
        address.setCity("Pawnee");
        address.setState("Indiana");
        address.setZipcode("47998");
        user.setAddress(address);
        return user;
    }
}
