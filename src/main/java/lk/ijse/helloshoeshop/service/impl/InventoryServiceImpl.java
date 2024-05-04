package lk.ijse.helloshoeshop.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.helloshoeshop.conversion.ConversionData;
import lk.ijse.helloshoeshop.dto.ItemDTO;
import lk.ijse.helloshoeshop.entity.ItemEntity;
import lk.ijse.helloshoeshop.exeption.NotFoundException;
import lk.ijse.helloshoeshop.repostory.InventoryDao;
import lk.ijse.helloshoeshop.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryDao inventoryDao;
    @Autowired
    private ConversionData convert;
    @Override
    public void saveInventory(ItemDTO inventoryDTO) {
        inventoryDTO.setItemCode(generateItemCode(inventoryDTO));
        inventoryDao.save(convert.convertToItemEntity(inventoryDTO));
    }

    @Override
    public String generateItemCode(ItemDTO itemDTO) {
        StringBuilder prefixBuilder = new StringBuilder();
        if (itemDTO.getGenderCode() != null) {
            prefixBuilder.append(itemDTO.getGenderCode());
        }
        if (itemDTO.getOccasionCode() != null) {
            prefixBuilder.append(itemDTO.getOccasionCode());
        }
        if (itemDTO.getVarietyCode() != null) {
            prefixBuilder.append(itemDTO.getVarietyCode());
        }
        String prefix = prefixBuilder.toString();

        String lastItemCodeStartingWithPrefix =
                inventoryDao.findLastItemCodeStartingWithPrefix(prefix);

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
        Optional<ItemEntity> item = inventoryDao.findById(id);
        if(item.isEmpty()) throw new NotFoundException("Item not found");
        return convert.convertToItemDTO(item.get());
    }

    @Override
    public void updateInventory(String id, ItemDTO inventoryDTO) {
        if(inventoryDao.existsById(id)) throw new NotFoundException("Item not found");
        inventoryDao.save(convert.convertToItemEntity(inventoryDTO));
    }

    @Override
    public void deleteInventory(String id) {
        inventoryDao.deleteById(id);
    }
}
