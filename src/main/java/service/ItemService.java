package service;

import entities.Item;

import java.util.List;

public interface ItemService {
    Item findById(Long id);
    Item addItem(Item item);
    void deleteItem(Long id);
    List<Item> findAllItemsByType(String type);
    List<Item> findAllItemsByTypeAndSort(String type, String sortBy);
}
