package lk.ijse.helloshoeshop.conversion;

import lk.ijse.helloshoeshop.dto.*;
import lk.ijse.helloshoeshop.entity.*;
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

    public EmployeeDTO converToEmployeeDTO(EmployeeEntity employee) {
        return modelMapper.map(employee, EmployeeDTO.class);
    }
    public EmployeeEntity convertToEmployeeEntity(EmployeeDTO employee) {
        return modelMapper.map(employee, EmployeeEntity.class);
    }

    public List<EmployeeDTO> convertToEmployeeDTOList(List<EmployeeEntity> employees){
        return modelMapper.map(employees, List.class);
    }

    public GenderDTO covertToGenderDTO(GenderEntity gender){
        return modelMapper.map(gender, GenderDTO.class);
    }

    public GenderEntity covertToGenderEntity(GenderDTO gender){
        return modelMapper.map(gender, GenderEntity.class);
    }

    public List<GenderDTO> covertToGenderDTOList(List<GenderEntity> genders){
        return modelMapper.map(genders, List.class);
    }

    public OccasionDTO convertToOccasionDTO(OccasionEntity occasion) {
        return modelMapper.map(occasion, OccasionDTO.class);
    }
    public OccasionEntity convertToOccasionEntity(OccasionDTO occasionDTO) {
        return modelMapper.map(occasionDTO, OccasionEntity.class);
    }

    public List<OccasionDTO> convertToOccasionDTOList(List<OccasionEntity> occasion){
        return modelMapper.map(occasion, List.class);
    }

    public VarietyDTO convertToVarietyDTO(VarietyEntity variety) {
        return modelMapper.map(variety, VarietyDTO.class);
    }
    public VarietyEntity convertToVarietyEntity(VarietyDTO varietyDTO) {
        return modelMapper.map(varietyDTO, VarietyEntity.class);
    }

    public List<VarietyDTO> convertToVarietyDTOList(List<VarietyEntity> varieties){
        return modelMapper.map(varieties, List.class);
    }

    public ItemDTO convertToItemDTO(ItemEntity itemEntity) {
        return modelMapper.map(itemEntity, ItemDTO.class);
    }
    public ItemEntity convertToItemEntity(ItemDTO itemDTO) {
        return modelMapper.map(itemDTO, ItemEntity.class);
    }

    public List<ItemDTO> convertToItemDTOList(List<ItemEntity> items){
        return modelMapper.map(items, List.class);
    }
}
