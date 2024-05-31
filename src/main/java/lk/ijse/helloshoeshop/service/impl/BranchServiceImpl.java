package lk.ijse.helloshoeshop.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.helloshoeshop.conversion.ConversionData;
import lk.ijse.helloshoeshop.dto.BranchDTO;
import lk.ijse.helloshoeshop.exeption.InvalidException;
import lk.ijse.helloshoeshop.repostory.BranchDao;
import lk.ijse.helloshoeshop.service.BranchService;
import lk.ijse.helloshoeshop.util.UtilMatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class BranchServiceImpl implements BranchService {
    @Autowired
    private BranchDao branchDao;
    @Autowired
    private ConversionData conversionData;

    @Override
    public void saveBranch(BranchDTO branchDTO) throws InvalidException {
        if (!branchDTO.getProductCode().equals(UtilMatter.productActivationCode())){
            System.out.println(branchDTO.getProductCode().equals(UtilMatter.productActivationCode()));
            throw new InvalidException("Invalid Product Code");
        }
        branchDTO.setBranchId(UtilMatter.generateId());
        branchDao.save(conversionData.convertToBranchEntity(branchDTO));
    }
}
