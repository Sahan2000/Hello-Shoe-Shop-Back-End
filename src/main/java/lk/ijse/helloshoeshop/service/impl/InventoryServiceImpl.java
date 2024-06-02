package lk.ijse.helloshoeshop.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.helloshoeshop.conversion.ConversionData;
import lk.ijse.helloshoeshop.dto.ItemDTO;
import lk.ijse.helloshoeshop.entity.GenderEntity;
import lk.ijse.helloshoeshop.entity.ItemEntity;
import lk.ijse.helloshoeshop.entity.OccasionEntity;
import lk.ijse.helloshoeshop.entity.VarietyEntity;
import lk.ijse.helloshoeshop.exeption.NotFoundException;
import lk.ijse.helloshoeshop.repostory.GenderDao;
import lk.ijse.helloshoeshop.repostory.InventoryDao;
import lk.ijse.helloshoeshop.repostory.OccasionDao;
import lk.ijse.helloshoeshop.repostory.VarietyDao;
import lk.ijse.helloshoeshop.service.GenderService;
import lk.ijse.helloshoeshop.service.InventoryService;
import lk.ijse.helloshoeshop.service.OccasionService;
import lk.ijse.helloshoeshop.service.VarietyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryDao inventoryDao;
    @Autowired
    private ConversionData convert;
    @Autowired
    private final GenderDao genderServiceDao;
    @Autowired
    private final OccasionDao occasionServiceDao;
    private final VarietyDao varietyServiceDao;
    @Override
    public void saveInventory(ItemDTO inventoryDTO) {
        ItemEntity itemEntity = convert.convertToItemEntity(inventoryDTO);
        itemEntity.setItemCode(generateItemCode(inventoryDTO));
        Optional<GenderEntity> genderEntity = genderServiceDao.findById(inventoryDTO.getGenderCode());
        if (genderEntity.isPresent()){
            GenderEntity genderEntity1 = genderEntity.get();
            itemEntity.setGenderEntity(genderEntity1);
        };
        Optional<OccasionEntity> occasionEntity = occasionServiceDao.findById(inventoryDTO.getOccasionCode());
        if (occasionEntity.isPresent()){
            OccasionEntity occasionEntity1 = occasionEntity.get();
            itemEntity.setOccasionEntity(occasionEntity1);
        }
        Optional<VarietyEntity> varietyEntity = varietyServiceDao.findById(inventoryDTO.getVarietyCode());
        if (varietyEntity.isPresent()){
            VarietyEntity varietyEntity1 = varietyEntity.get();
            itemEntity.setVarietyEntity(varietyEntity1);
        }
        inventoryDao.save(itemEntity);
    }

    @Override
    public String generateItemCode(ItemDTO itemDTO) {
        StringBuilder prefixBuilder = new StringBuilder();

        if (!itemDTO.getVarietyCode().equals("-1")) {
            prefixBuilder.append(itemDTO.getVarietyCode());
        }
        if (!itemDTO.getOccasionCode().equals("-1")) {
            prefixBuilder.append(itemDTO.getOccasionCode());
        }
        if (!itemDTO.getGenderCode().equals("-1")) {
            prefixBuilder.append(itemDTO.getGenderCode());
        }

        String prefix = prefixBuilder.toString();

        String lastItemCodeStartingWithPrefix =
                inventoryDao.findLastItemCodeStartingWithPrefix(
                        prefix
                );

        return (lastItemCodeStartingWithPrefix != null)
                ? String.format("%s%05d", prefix, Integer.parseInt(lastItemCodeStartingWithPrefix.replace(prefix, "")) + 1)
                : prefix + "00001";
    }

    @Override
    public List<ItemDTO> getAllInventory() {
        return convert.convertToItemDTOList(inventoryDao.findAll());
    }

    @Override
    public ItemDTO getInventory(String id) {
        if(!inventoryDao.existsById(id)){throw new NotFoundException("Item not found.");}
        return convert.convertToItemDTO(inventoryDao.findById(id));
    }

    @Override
    public void updateInventory(String id, String itemDesc, String pic) {
        Optional<ItemEntity> itemEntityOptional = inventoryDao.findById(id);
        if (itemEntityOptional.isEmpty()) {
            throw new NotFoundException("Item not found.");
        }

        ItemEntity itemEntity = itemEntityOptional.get();
        itemEntity.setItemDesc(itemDesc);
        itemEntity.setPic(pic);

        inventoryDao.save(itemEntity);
    }

    @Override
    public void deleteInventory(String id) {
        if(!inventoryDao.existsById(id)){throw new NotFoundException("Item not found.");}
        inventoryDao.deleteById(id);
    }
}
