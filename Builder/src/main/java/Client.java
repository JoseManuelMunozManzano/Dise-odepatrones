import java.time.LocalDate;

// This is our client which also works as "director"
public class Client {
    public static void main(String[] args) {
        User user = createUser();
        UserDTOBuilder builder = new UserWebDTOBuilder();

        // Así se usa el director en nuestro cliente
        UserDTO dto = directBuild(builder, user);
        System.out.println(dto);
    }

    // Director
    // Este director necesita una instancia concreta de builder (UserDTOBuilder) y User Entity
    // porque lo que queremos es construir el DTO a partir de un objeto entidad existente, que es el objeto User
    private static UserDTO directBuild(UserDTOBuilder builder, User user) {
        return builder.withFirstName(user.getFirstName())
                .withLastName(user.getLastName())
                .withAddress(user.getAddress())
                .withBirthday(user.getBirthday())
                .build();
    }

    // Returns a sample user
    public static User createUser() {
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
