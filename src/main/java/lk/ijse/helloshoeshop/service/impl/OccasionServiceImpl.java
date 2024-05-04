package lk.ijse.helloshoeshop.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.helloshoeshop.conversion.ConversionData;
import lk.ijse.helloshoeshop.dto.OccasionDTO;
import lk.ijse.helloshoeshop.exeption.NotFoundException;
import lk.ijse.helloshoeshop.repostory.OccasionDao;
import lk.ijse.helloshoeshop.service.OccasionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class OccasionServiceImpl implements OccasionService {
    @Autowired
    private OccasionDao occasionDao;
    @Autowired
    private ConversionData convert;
    @Override
    public void saveOccasion(OccasionDTO occasionDTO) {
        occasionDao.save(convert.convertToOccasionEntity(occasionDTO));
    }

    @Override
    public List<OccasionDTO> getAllOccasion() {
        return convert.convertToOccasionDTOList(occasionDao.findAll());
    }

    @Override
    public void updateOccasion(String id, OccasionDTO occasionDTO) {
        if(!occasionDao.existsById(id)){throw new NotFoundException("Occasion Not Found");}
        occasionDao.save(convert.convertToOccasionEntity(occasionDTO));
    }

    @Override
    public void deleteOccasion(String id) {
        occasionDao.deleteById(id);
    }


}
