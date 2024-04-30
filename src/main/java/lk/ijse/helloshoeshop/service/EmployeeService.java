package lk.ijse.helloshoeshop.service;

import lk.ijse.helloshoeshop.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    void saveEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO getEmployee(String id);
    List<EmployeeDTO> getAllEmployees();
    void updateEmployee(String id, EmployeeDTO employeeDTO);
    void deleteEmployee(String id);
    String generateNextEmployeeId();
}
