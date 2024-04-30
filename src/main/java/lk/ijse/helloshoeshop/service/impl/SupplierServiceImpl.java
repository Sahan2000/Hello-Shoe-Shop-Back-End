package lk.ijse.helloshoeshop.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.helloshoeshop.conversion.ConversionData;
import lk.ijse.helloshoeshop.dto.SupplierDTO;
import lk.ijse.helloshoeshop.entity.CustomerEntity;
import lk.ijse.helloshoeshop.entity.SupplierEntity;
import lk.ijse.helloshoeshop.entity.enumerate.Category;
import lk.ijse.helloshoeshop.exeption.NotFoundException;
import lk.ijse.helloshoeshop.repostory.SupplierDao;
import lk.ijse.helloshoeshop.service.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SupplierServiceImpl implements SuppliersService {
    @Autowired
    private SupplierDao supplierDao;
    @Autowired
    private ConversionData convert;
    @Override
    public SupplierDTO saveSupplier(SupplierDTO supplierDTO) {
        supplierDTO.setSupplierCode(generateNextSupplierId());
        supplierDTO.setCategory(Category.LOCAL);
        return convert.converToSupplierDTO(supplierDao.save(convert.converToSupplierEntity(supplierDTO)));
    }

    @Override
    public String generateNextSupplierId() {
        SupplierEntity lastSupplier = supplierDao.findFirstByOrderBySupplierCodeDesc();
        if (lastSupplier == null) {
            return "Sup-001";
        }
        String lastSupplierId = lastSupplier.getSupplierCode();
        int lastId = Integer.parseInt(lastSupplierId.split("-")[1]);
        int nextId = lastId + 1;
        return "Sup-" + String.format("%03d", nextId);
    }

    @Override
    public SupplierDTO getSupplier(String id) {
        return convert.converToSupplierDTO( supplierDao.findById(id).orElse(null));
    }

    @Override
    public List<SupplierDTO> getAllSuppliers() {
        return convert.convertToSupplierDTOList(supplierDao.findAll());
    }

    @Override
    public void updateSupplier(String id, SupplierDTO supplierDTO) {
        Optional<SupplierEntity> supplierEntity = supplierDao.findById(id);
        if (supplierEntity.isEmpty()) throw new NotFoundException("supplier Not Found");
        supplierEntity.get().setSupplierName(supplierDTO.getSupplierName());
        supplierEntity.get().setCategory(supplierDTO.getCategory());
        supplierEntity.get().setAddress1(supplierDTO.getAddress1());
        supplierEntity.get().setAddress2(supplierDTO.getAddress2());
        supplierEntity.get().setAddress3(supplierDTO.getAddress3());
        supplierEntity.get().setAddress4(supplierDTO.getAddress4());
        supplierEntity.get().setPostalCode(supplierDTO.getPostalCode());
        supplierEntity.get().setCountry(supplierDTO.getCountry());
        supplierEntity.get().setContactNo1(supplierDTO.getContactNo1());
        supplierEntity.get().setContactNo2(supplierDTO.getContactNo2());
        supplierEntity.get().setEmail(supplierDTO.getEmail());
    }

    @Override
    public void deleteSupplier(String id) {
        supplierDao.deleteById(id);
    }
}
