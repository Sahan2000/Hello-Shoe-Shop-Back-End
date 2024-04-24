package lk.ijse.helloshoeshop.service;

import lk.ijse.helloshoeshop.dto.CustomerDTO;

public interface CustomerService {
    CustomerDTO saveCustomer(CustomerDTO customer);
    void updateCustomer(CustomerDTO customer);
    void deleteCustomer(String id);
}
