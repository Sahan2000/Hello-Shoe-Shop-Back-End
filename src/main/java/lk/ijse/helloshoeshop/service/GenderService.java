package lk.ijse.helloshoeshop.service;

import lk.ijse.helloshoeshop.dto.GenderDTO;

import java.util.List;

public interface GenderService {
    void saveGender(GenderDTO genderDTO);
    List<GenderDTO> genderGetAll();
    void updateGender(String id, GenderDTO genderDTO);
    void deleteGender(String id);
}
