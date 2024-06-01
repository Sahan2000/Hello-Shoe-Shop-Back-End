package lk.ijse.helloshoeshop.service.impl;

import lk.ijse.helloshoeshop.conversion.ConversionData;
import lk.ijse.helloshoeshop.dto.SizesDTO;
import lk.ijse.helloshoeshop.entity.SizeEntity;
import lk.ijse.helloshoeshop.exeption.DuplicateException;
import lk.ijse.helloshoeshop.exeption.NotFoundException;
import lk.ijse.helloshoeshop.repostory.SizesDao;
import lk.ijse.helloshoeshop.service.SizesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class SizesServiceImpl implements SizesService {
    @Autowired
    private ConversionData convert;
    @Autowired
    private SizesDao sizeServiceDao;
    @Override
    public void saveSize(SizesDTO sizeDTO) {
        if (sizeServiceDao.existsById(sizeDTO.getSizeCode())) throw new DuplicateException("Size Id Duplicate");
        sizeServiceDao.save(convert.toSizeEntity(sizeDTO));
    }

    @Override
    public List<SizesDTO> getAllSizes() {
        return convert.convertToSizeDTOs(sizeServiceDao.findAll());
    }

    @Override
    public void deleteSize(String id) {
        if (!sizeServiceDao.existsById(id)) throw new NotFoundException("Size Not Found");
        sizeServiceDao.deleteById(id);
    }

    @Override
    public void updateSize(String id, SizesDTO sizeDTO) {
        if (!sizeServiceDao.existsById(id)) throw new NotFoundException("Size Not Found");
        sizeServiceDao.save(convert.toSizeEntity(sizeDTO));
    }

    @Override
    public String getSizeId() {
        return getNextSizeId();
    }

    private String getNextSizeId() {
        SizeEntity firstByOrderBySizeCodeDesc = sizeServiceDao.findFirstByOrderBySizeCodeDesc();
        return (firstByOrderBySizeCodeDesc != null)
                ? String.format("Size-%03d",
                Integer.parseInt(firstByOrderBySizeCodeDesc.getSizeCode().
                        replace("Size-", "")) + 1)
                : "Size-001";
    }
}
