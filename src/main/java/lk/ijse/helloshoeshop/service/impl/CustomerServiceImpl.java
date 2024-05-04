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
        if (customerDao.existsById(id)) throw new NotFoundException("Customer not fond");
        customerDao.save(convert.converToCustomerEntity(customerDTO));
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
        if (lastCustomer == null) {
            return "Cust-001";
        }
        String lastCustomerId = lastCustomer.getCustomerId();
        int lastId = Integer.parseInt(lastCustomerId.split("-")[1]);
        int nextId = lastId + 1;
        return "Cust-" + String.format("%03d", nextId);
    }
}
