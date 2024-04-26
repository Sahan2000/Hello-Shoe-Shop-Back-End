package lk.ijse.helloshoeshop.conversion;

import lk.ijse.helloshoeshop.dto.CustomerDTO;
import lk.ijse.helloshoeshop.entity.CustomerEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ConversionData {
    final private ModelMapper modelMapper;

    public CustomerDTO converToCustomerDTO(CustomerEntity customer) {
        return modelMapper.map(customer, CustomerDTO.class);
    }
    public CustomerEntity converToCustomerEntity(CustomerDTO customer) {
        return modelMapper.map(customer, CustomerEntity.class);
    }

    public List<CustomerDTO> convertToCustomerDTOList(List<CustomerEntity> customer){
        return modelMapper.map(customer, List.class);
    }
}
