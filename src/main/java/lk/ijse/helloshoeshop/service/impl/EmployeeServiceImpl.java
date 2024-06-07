package lk.ijse.helloshoeshop.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.helloshoeshop.conversion.ConversionData;
import lk.ijse.helloshoeshop.dto.EmployeeDTO;
import lk.ijse.helloshoeshop.entity.BranchEntity;
import lk.ijse.helloshoeshop.entity.CustomerEntity;
import lk.ijse.helloshoeshop.entity.EmployeeEntity;
import lk.ijse.helloshoeshop.entity.UserEntity;
import lk.ijse.helloshoeshop.exeption.NotFoundException;
import lk.ijse.helloshoeshop.repostory.BranchDao;
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
    private BranchDao branchDao;
    @Autowired
    private UserDao userDao;
    @Override
    public void saveEmployee(EmployeeDTO employeeDTO) {
        employeeDTO.setEmployeeCode(generateNextEmployeeId());
        EmployeeEntity employeeEntity = convert.convertToEmployeeEntity(employeeDTO);

        String email = employeeDTO.getEmail();
        Optional<UserEntity> byEmail = userDao.findByEmail(email);

        String branchId = employeeDTO.getBranchId();
        Optional<BranchEntity> byBranch = branchDao.findById(branchId);

        if (byEmail == null) {
            throw new NotFoundException("User Not Found");
        }

        if (byBranch == null){
            throw new NotFoundException("Branch Not Found");
        }

        UserEntity newUserEntity = new UserEntity();
        newUserEntity.setUserId(byEmail.get().getUserId());
        newUserEntity.setEmail(email);
        newUserEntity.setPassword(byEmail.get().getPassword());
        newUserEntity.setRole(byEmail.get().getRole());

        employeeEntity.setUserEntity(newUserEntity);
        employeeEntity.setBranch(byBranch.get());

        employeeDao.save(employeeEntity);
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
        Optional<EmployeeEntity> employeeEntity = employeeDao.findById(id);
        EmployeeEntity employee = employeeEntity.get();
        employee.setEmployeeName(employeeDTO.getEmployeeName());
        employee.setPic(employeeDTO.getPic());
        employee.setGender(employeeDTO.getGender());
        employee.setStatus(employeeDTO.getStatus());
        employee.setDesignation(employeeDTO.getDesignation());
        employee.setDateOfBirth(employeeDTO.getDateOfBirth());
        employee.setAddress1(employeeDTO.getAddress1());
        employee.setAddress2(employeeDTO.getAddress2());
        employee.setAddress3(employeeDTO.getAddress3());
        employee.setAddress4(employeeDTO.getAddress4());
        employee.setPostalCode(employeeDTO.getPostalCode());
        employee.setContactNo(employeeDTO.getContactNo());
        employee.setEmergencyContactName(employeeDTO.getEmergencyContactName());
        employee.setEmergencyContact(employeeDTO.getEmergencyContact());
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
