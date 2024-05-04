package lk.ijse.helloshoeshop.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.helloshoeshop.conversion.ConversionData;
import lk.ijse.helloshoeshop.dto.EmployeeDTO;
import lk.ijse.helloshoeshop.entity.CustomerEntity;
import lk.ijse.helloshoeshop.entity.EmployeeEntity;
import lk.ijse.helloshoeshop.entity.UserEntity;
import lk.ijse.helloshoeshop.exeption.NotFoundException;
import lk.ijse.helloshoeshop.repostory.CustomerDao;
import lk.ijse.helloshoeshop.repostory.EmployeeDao;
import lk.ijse.helloshoeshop.repostory.UserDao;
import lk.ijse.helloshoeshop.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private ConversionData convert;
    @Autowired
    private UserDao userDao;
    @Override
    public void saveEmployee(EmployeeDTO employeeDTO) {
        employeeDTO.setEmployeeCode(generateNextEmployeeId());
        Optional<UserEntity> userEntity = userDao.findByEmail(employeeDTO.getEmail());
        EmployeeEntity employee = convert.convertToEmployeeEntity(employeeDTO);
        if (userEntity == null) {
            throw new NotFoundException("User Not Found");
        }
        UserEntity newUser = new UserEntity();
        newUser.setUserId(userEntity.get().getUserId());
        newUser.setEmail(userEntity.get().getEmail());
        newUser.setPassword(userEntity.get().getPassword());
        newUser.setRole(userEntity.get().getRole());

        employee.setUserEntity(newUser);
        employeeDao.save(employee);
    }

    @Override
    public EmployeeDTO getEmployee(String id) {
        if(!employeeDao.existsById(id)){throw new NotFoundException("Employee Not Found");}
        return convert.converToEmployeeDTO(employeeDao.findById(id).orElse(null));
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return convert.convertToEmployeeDTOList(employeeDao.findAll());
    }

    @Override
    public void updateEmployee(String id, EmployeeDTO employeeDTO) {
        if(!employeeDao.existsById(id)){throw new NotFoundException("Employee Not Found");}
        employeeDao.save(convert.convertToEmployeeEntity(employeeDTO));
    }

    @Override
    public void deleteEmployee(String id) {
        if(!employeeDao.existsById(id)){throw new NotFoundException("Employee Not Found");}
        employeeDao.deleteById(id);
    }

    @Override
    public String generateNextEmployeeId() {
        EmployeeEntity lastEmployee = employeeDao.findFirstByOrderByEmployeeCodeDesc();
        if (lastEmployee == null) {
            return "Emp-001";
        }
        String lastEmployeeId = lastEmployee.getEmployeeCode();
        int lastId = Integer.parseInt(lastEmployeeId.split("-")[1]);
        int nextId = lastId + 1;
        return "Emp-" + String.format("%03d", nextId);
    }
}
