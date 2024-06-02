package lk.ijse.helloshoeshop.service;

import lk.ijse.helloshoeshop.dto.ItemDTO;

import java.util.List;

public interface InventoryService {
    void saveInventory(ItemDTO inventoryDTO);
    String generateItemCode(ItemDTO itemDTO);
    List<ItemDTO> getAllInventory();
    ItemDTO getInventory(String id);
    void updateInventory(String id, String itemDesc, String pic);
    void deleteInventory(String id);
}
