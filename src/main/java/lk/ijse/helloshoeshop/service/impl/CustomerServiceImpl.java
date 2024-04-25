package lk.ijse.helloshoeshop.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.helloshoeshop.conversion.ConversionData;
import lk.ijse.helloshoeshop.dto.CustomerDTO;
import lk.ijse.helloshoeshop.repostory.CustomerDao;
import lk.ijse.helloshoeshop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return convert.converToCustomerDTO(customerDao.save(convert.converToCustomerEntity(customer)));
    }

    @Override
    public void updateCustomer(CustomerDTO customer) {
        Optional<CustomerEntity> tmpCustomer = customerDao.findById(customer.getCustomerCode());

        if(tmpCustomer.isPresent()){
            tmpCustomer.get().setCustomerName(customer.getCustomerName());
            tmpCustomer.get().setGender(customer.getGender());
            tmpCustomer.get().setJoinedDate(customer.getJoinedDate());
            tmpCustomer.get().setLevel(customer.getLevel());
            tmpCustomer.get().setTotalPoint(customer.getTotalPoint());
            tmpCustomer.get().setDob(customer.getDob());
            tmpCustomer.get().setAddress1(customer.getAddress1());
            tmpCustomer.get().setAddress2(customer.getAddress2());
            tmpCustomer.get().setAddress3(customer.getAddress3());
            tmpCustomer.get().setAddress4(customer.getAddress4());
            tmpCustomer.get().setAddress5(customer.getAddress5());
            tmpCustomer.get().setContactNo(customer.getContactNo());
            tmpCustomer.get().setEmail(customer.getEmail());
            tmpCustomer.get().setPurchaseDate(customer.getPurchaseDate());
        }
    }

    @Override
    public void deleteCustomer(String id) {
        customerDao.deleteById(id);
    }
}
