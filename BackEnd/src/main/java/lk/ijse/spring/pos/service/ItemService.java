package lk.ijse.spring.pos.service;

import lk.ijse.spring.pos.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    void addItem(ItemDTO dto);

    void updateItem(ItemDTO dto);

    void deleteItem(String code);

    List<ItemDTO> getAllItems();

    ItemDTO findItem(String code);
}
