package mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.example.api.domain.Address;
import com.example.api.domain.Customer;
import com.example.api.dto.AddressDTO;
import com.example.api.dto.CustomerDTO;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "addresses", source = "addresses")
    Customer toEntity(CustomerDTO customerDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "customer", ignore = true)
    Address toEntity(AddressDTO addressDTO);

    CustomerDTO toDTO(Customer customer);

    AddressDTO toDTO(Address address);

}
