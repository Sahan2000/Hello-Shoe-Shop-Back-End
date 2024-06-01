package lk.ijse.helloshoeshop.service;

import lk.ijse.helloshoeshop.dto.SizesDTO;

import java.util.List;

public interface SizesService {
    void saveSize(SizesDTO sizeDTO);

    List<SizesDTO> getAllSizes();

    void deleteSize(String id);

    void updateSize(String id,SizesDTO sizeDTO);

    String getSizeId();
}
