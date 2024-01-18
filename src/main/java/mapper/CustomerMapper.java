package mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.api.domain.Customer;
import com.example.api.dto.CustomerDTO;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(target = "addresses", ignore = true) 
    Customer createCustomerDTOToCustomer(CustomerDTO customerDTO);

}
