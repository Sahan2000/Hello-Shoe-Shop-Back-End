package lk.ijse.helloshoeshop.service.impl;

import lk.ijse.helloshoeshop.dto.OrderDTO;
import lk.ijse.helloshoeshop.dto.OrderDetailsDTO;
import lk.ijse.helloshoeshop.entity.CustomerEntity;
import lk.ijse.helloshoeshop.entity.OrderEntity;
import lk.ijse.helloshoeshop.entity.StockEntity;
import lk.ijse.helloshoeshop.entity.StockSizeOrderDetailsEntity;
import lk.ijse.helloshoeshop.entity.enumerate.Level;
import lk.ijse.helloshoeshop.repostory.*;
import lk.ijse.helloshoeshop.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Transactional
public class SaleServiceImpl implements SaleService {
    private final SaleServiceDao saleServiceDao;

    private final CustomerDao customerServiceDao;

    private final UserDao userServiceDao;

    private final StockDao stockServiceDao;

    private final StockOrderDetailsDao stockOrderDetailsServiceDao;
    @Override
    public String getNextOrderId() {
        return getOrderId();
    }

    @Override
    public void saveOrder(OrderDTO orderDTO) {
        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setOrderNo(orderDTO.getOrderNo());
        orderEntity.setPurchasedDate(new Timestamp(System.currentTimeMillis()));
        orderEntity.setPaymentMethod(orderDTO.getPaymentMethod());
        orderEntity.setTotalAmount(orderDTO.getTotalAmount());
        orderEntity.setPaidAmount(orderDTO.getPaidAmount());
        orderEntity.setBankName(orderDTO.getBankName());
        orderEntity.setBankNo(orderDTO.getBankNo());

        CustomerEntity customerEntity = customerServiceDao.findById(orderDTO.getCustomerId()).orElseThrow();
        orderEntity.setCustomerEntity(customerEntity);

        orderEntity.setUserEntity(userServiceDao.findByEmail(orderDTO.getUserId()).get());

        saleServiceDao.save(orderEntity);

        for (OrderDetailsDTO detailDTO : orderDTO.getOrderDetailsList()) {
            StockSizeOrderDetailsEntity stockOrderDetailsEntity = new StockSizeOrderDetailsEntity();
            stockOrderDetailsEntity.setStockOrderDetailsId(UUID.randomUUID().toString());
            stockOrderDetailsEntity.setQty(detailDTO.getQty());

            StockEntity stockEntity = stockServiceDao.findById(detailDTO.getStockId()).orElseThrow();
            stockOrderDetailsEntity.setStockEntity(stockEntity);
            stockOrderDetailsEntity.setOrderEntity(orderEntity);

            stockOrderDetailsServiceDao.save(stockOrderDetailsEntity);

            stockEntity.setQty(stockEntity.getQty() - detailDTO.getQty());
            stockServiceDao.save(stockEntity);
        }

        customerEntity.setTotalPoints(customerEntity.getTotalPoints() + 1);
        customerEntity.setRecentPurchasedDate(new Timestamp(System.currentTimeMillis()));
        updateCustomerLevel(customerEntity);
    }

    private void updateCustomerLevel(CustomerEntity customerEntity) {
        int points = customerEntity.getTotalPoints();
        if (points < 50) {
            customerEntity.setLevel(Level.NEW);
        } else if (points <= 99) {
            customerEntity.setLevel(Level.BRONZE);
        } else if (points <= 199) {
            customerEntity.setLevel(Level.SILVER);
        } else {
            customerEntity.setLevel(Level.GOLD);
        }
        customerServiceDao.save(customerEntity);
    }
    private String getOrderId() {
        OrderEntity order = saleServiceDao.findFirstByOrderByOrderNoDesc();
        return (order != null)
                ? String.format("Order-%03d",
                Integer.parseInt(order.getOrderNo().
                        replace("Order-", "")) + 1)
                : "Order-001";
    }
}
