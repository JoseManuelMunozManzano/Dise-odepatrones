import java.time.LocalDate;

// Abstract builder
//
// Builder proporciona métodos que permiten al usuario construir partes de nuestro objeto UserWebDTO.
// Todos estos métodos devuelven una referencia al mismo builder. Así se permite chaining
public interface UserDTOBuilder {
    // methods to build "parts" of product at a time
    UserDTOBuilder withFirstName(String fname);
    UserDTOBuilder withLastName(String lname);
    UserDTOBuilder withBirthday(LocalDate date);
    UserDTOBuilder withAddress(Address address);

    // method to "assemble" final product
    UserDTO build();

    // (optional) method to fetch already built DTO object
    // Sería el query method
    UserDTO getUserDTO();
}
