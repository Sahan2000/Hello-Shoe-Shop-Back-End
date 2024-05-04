package lk.ijse.helloshoeshop.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.helloshoeshop.conversion.ConversionData;
import lk.ijse.helloshoeshop.dto.VarietyDTO;
import lk.ijse.helloshoeshop.exeption.NotFoundException;
import lk.ijse.helloshoeshop.repostory.VarietyDao;
import lk.ijse.helloshoeshop.service.VarietyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class VarietyServiceImpl implements VarietyService {
    @Autowired
    private VarietyDao varietyDao;
    @Autowired
    private ConversionData convert;
    @Override
    public void saveVariety(VarietyDTO varietyDTO) {
        varietyDao.save(convert.convertToVarietyEntity(varietyDTO));
    }

    @Override
    public void updateVariety(String id, VarietyDTO varietyDTO) {
        if(!varietyDao.existsById(id)){throw new NotFoundException("Variety Not Found");}
        varietyDao.save(convert.convertToVarietyEntity(varietyDTO));
    }

    @Override
    public void deleteVariety(String id) {
        varietyDao.deleteById(id);
    }

    @Override
    public VarietyDTO getVariety(String id) {
        return null;
    }

    @Override
    public List<VarietyDTO> getAllVariety() {
        return convert.convertToVarietyDTOList(varietyDao.findAll());
    }
}
