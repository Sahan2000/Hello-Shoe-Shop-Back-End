package lk.ijse.helloshoeshop.service;

import lk.ijse.helloshoeshop.dto.VarietyDTO;

import java.util.List;

public interface VarietyService {
    void saveVariety(VarietyDTO varietyDTO);
    void updateVariety(String id, VarietyDTO varietyDTO);
    void deleteVariety(String id);
    VarietyDTO getVariety(String id);
    List<VarietyDTO> getAllVariety();
}
