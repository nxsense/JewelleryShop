package service;

import entities.Item;

import java.util.List;

/**
 * @author author
 * @version 1.0
 */
public interface ItemService {
    Item findById(Long id);
    void addItem(Item item);
    void deleteItem(Long id);
    List<Item> findAllItemsByType(String type);
    List<Item> findAllItemsByTypeAndSort(String type, String sortBy);
}
