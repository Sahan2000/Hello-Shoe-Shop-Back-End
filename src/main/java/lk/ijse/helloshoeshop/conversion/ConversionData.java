package lk.ijse.helloshoeshop.conversion;

import lk.ijse.helloshoeshop.dto.CustomerDTO;
import lk.ijse.helloshoeshop.dto.SupplierDTO;
import lk.ijse.helloshoeshop.dto.UserDTO;
import lk.ijse.helloshoeshop.entity.CustomerEntity;
import lk.ijse.helloshoeshop.entity.SupplierEntity;
import lk.ijse.helloshoeshop.entity.UserEntity;
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

    public SupplierDTO converToSupplierDTO(SupplierEntity supplier) {
        return modelMapper.map(supplier, SupplierDTO.class);
    }
    public SupplierEntity converToSupplierEntity(SupplierDTO supplier) {
        return modelMapper.map(supplier, SupplierEntity.class);
    }

    public List<SupplierDTO> convertToSupplierDTOList(List<SupplierEntity> suppliers){
        return modelMapper.map(suppliers, List.class);
    }

    public UserEntity convertToUserEntity(UserDTO userDTO){
        return modelMapper.map(userDTO, UserEntity.class);
    }

    public UserDTO convertToUserDTO(UserEntity userEntity){
        return modelMapper.map(userEntity, UserDTO.class);
    }
}
