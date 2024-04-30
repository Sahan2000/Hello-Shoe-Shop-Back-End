package lk.ijse.helloshoeshop.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.helloshoeshop.controller.Customer;
import lk.ijse.helloshoeshop.conversion.ConversionData;
import lk.ijse.helloshoeshop.dto.CustomerDTO;
import lk.ijse.helloshoeshop.entity.CustomerEntity;
import lk.ijse.helloshoeshop.exeption.NotFoundException;
import lk.ijse.helloshoeshop.repostory.CustomerDao;
import lk.ijse.helloshoeshop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private ConversionData convert;
    @Override
    public CustomerDTO saveCustomer(CustomerDTO customer) {
        customer.setCustomerId(generateNextCustomerId());
        return convert.converToCustomerDTO(customerDao.save(convert.converToCustomerEntity(customer)));
    }

    @Override
    public void updateCustomer(String id, CustomerDTO customerDTO) {
        Optional<CustomerEntity> customerEntity = customerDao.findById(id);
        if (customerEntity.isEmpty()) throw new NotFoundException("Customer Not Found");
        customerEntity.get().setCustomerName(customerDTO.getCustomerName());
        customerEntity.get().setGender(customerDTO.getGender());
        customerEntity.get().setJoinDate(customerDTO.getJoinDate());
        customerEntity.get().setDob(customerDTO.getDob());
        customerEntity.get().setAddress1(customerDTO.getAddress1());
        customerEntity.get().setAddress2(customerDTO.getAddress2());
        customerEntity.get().setAddress3(customerDTO.getAddress3());
        customerEntity.get().setAddress4(customerDTO.getAddress4());
        customerEntity.get().setPostalCode(customerDTO.getPostalCode());
        customerEntity.get().setContactNo(customerDTO.getContactNo());
        customerEntity.get().setEmail(customerDTO.getEmail());
        customerEntity.get().setRecentPurchasedDate(customerDTO.getRecentPurchasedDate());
    }

    @Override
    public void deleteCustomer(String id) {
        customerDao.deleteById(id);
    }

    @Override
    public CustomerDTO getCustomer(String id) {
        return convert.converToCustomerDTO( customerDao.findById(id).orElse(null));
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
         return convert.convertToCustomerDTOList(customerDao.findAll());
    }

    @Override
    public String generateNextCustomerId() {
        CustomerEntity lastCustomer = customerDao.findFirstByOrderByCustomerIdDesc();
        return (lastCustomer == null)
                ? "Cust-" + String.format("%03d", Integer.parseInt(lastCustomer.getCustomerId().split("-")[1]))
                : "Cust-001";
    }
}
