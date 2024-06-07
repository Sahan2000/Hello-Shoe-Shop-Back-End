package lk.ijse.helloshoeshop.service;

import lk.ijse.helloshoeshop.dto.OrderDTO;

public interface SaleService {
    String getNextOrderId();

    void saveOrder(OrderDTO orderDTO);
}
