package lk.ijse.helloshoeshop.service;

import lk.ijse.helloshoeshop.dto.SupplierDTO;

import java.util.List;

public interface SuppliersService {
    SupplierDTO saveSupplier(SupplierDTO supplierDTO);
    String generateNextSupplierId();
    SupplierDTO getSupplier(String id);
    List<SupplierDTO> getAllSuppliers();
    void updateSupplier(String id, SupplierDTO supplierDTO);
    void deleteSupplier(String id);
}
