package lk.ijse.helloshoeshop.service;

import lk.ijse.helloshoeshop.dto.CustomerDTO;

import java.util.ArrayList;
import java.util.List;

public interface CustomerService {
    CustomerDTO saveCustomer(CustomerDTO customer);
    void updateCustomer(String id, CustomerDTO customer);
    void deleteCustomer(String id);
    CustomerDTO getCustomer(String id);
    List<CustomerDTO> getAllCustomer();
    String generateNextCustomerId();
}
