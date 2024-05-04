package lk.ijse.helloshoeshop.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.helloshoeshop.conversion.ConversionData;
import lk.ijse.helloshoeshop.dto.GenderDTO;
import lk.ijse.helloshoeshop.exeption.NotFoundException;
import lk.ijse.helloshoeshop.repostory.GenderDao;
import lk.ijse.helloshoeshop.service.GenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class GenderServiceImpl implements GenderService {
    @Autowired
    private GenderDao genderDao;
    @Autowired
    private ConversionData covert;
    @Override
    public void saveGender(GenderDTO genderDTO) {
        genderDao.save(covert.covertToGenderEntity(genderDTO));
    }

    @Override
    public List<GenderDTO> genderGetAll() {
        return covert.covertToGenderDTOList(genderDao.findAll());
    }

    @Override
    public void updateGender(String id, GenderDTO genderDTO) {
        if(genderDao.existsById(id)) throw new NotFoundException("Gender not found");
        genderDao.save(covert.covertToGenderEntity(genderDTO));
    }

    @Override
    public void deleteGender(String id) {
        genderDao.deleteById(id);
    }

}
