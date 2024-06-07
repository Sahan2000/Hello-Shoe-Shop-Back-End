package lk.ijse.helloshoeshop.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.helloshoeshop.conversion.ConversionData;
import lk.ijse.helloshoeshop.dto.StockDTO;
import lk.ijse.helloshoeshop.entity.BranchEntity;
import lk.ijse.helloshoeshop.entity.EmployeeEntity;
import lk.ijse.helloshoeshop.entity.SizeEntity;
import lk.ijse.helloshoeshop.entity.StockEntity;
import lk.ijse.helloshoeshop.exeption.NotFoundException;
import lk.ijse.helloshoeshop.repostory.*;
import lk.ijse.helloshoeshop.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class StockServiceImpl implements StockService {
    private final StockDao stockServiceDao;

    private final SupplierDao supplierServiceDao;

    private final InventoryDao itemServiceDao;

    private final SizesDao sizeServiceDao;

    private final EmployeeDao employeeServiceDao;

    private final BranchDao branchServiceDao;

    private final ConversionData conversionData;

    @Override
    public String getStockId() {
        return getNextStockId();
    }

    @Override
    public void saveStock(StockDTO stockDTO, String email) {

        EmployeeEntity byEmail = employeeServiceDao.findByEmail(email);
        Optional<BranchEntity> branch = branchServiceDao.findById(byEmail.getBranch().getBranchId());
        BranchEntity branchEntity = branch.get();
        SizeEntity sizeEntity = sizeServiceDao.findById(stockDTO.getSizeId()).get();

        stockServiceDao.save(new StockEntity(
                getNextStockId(),
                new Date(),
                stockDTO.getQuantity(),
                stockDTO.getUnitBuyingPrice(),
                stockDTO.getUnitSellingPrice(),
                supplierServiceDao.findById(stockDTO.getSupplierId()).get(),
                itemServiceDao.findById(stockDTO.getItemId()).get(),
                branchEntity,
                sizeEntity
        ));

    }

    @Override
    public List<StockDTO> getAllStock() {
        return conversionData.toStockEntity(stockServiceDao.findAll());
    }

    @Override
    public void updateStock(StockDTO stockDTO, String stockId) {
        Optional<StockEntity> stockEntity = stockServiceDao.findById(stockId);
        if (stockEntity.isEmpty()) throw new NotFoundException("Stock Not Found");
        StockEntity stock = stockEntity.get();
        stock.setQty(stockDTO.getQuantity());
        stock.setUnitBuyingPrice(stockDTO.getUnitBuyingPrice());
        stock.setUnitSellingPrice(stockDTO.getUnitSellingPrice());
        stock.setSupplierEntity(supplierServiceDao.findById(stockDTO.getSupplierId()).get());
        stock.setItemEntity(itemServiceDao.findById(stockDTO.getItemId()).get());
        stock.setSizeEntity(sizeServiceDao.findById(stockDTO.getSizeId()).get());
    }

    @Override
    public void deleteStock(String id) {
        if (!stockServiceDao.existsById(id)) throw new NotFoundException("Stock Not Found");
        stockServiceDao.deleteById(id);
    }

    public String getNextStockId(){
        StockEntity stockEntity = stockServiceDao.findFirstByOrderByStockIdDesc();
        return (stockEntity != null)
                ? String.format("St-%03d",
                Integer.parseInt(stockEntity.getStockId()
                        .replace("St-", "")) + 1)
                : "St-001";
    }
}
