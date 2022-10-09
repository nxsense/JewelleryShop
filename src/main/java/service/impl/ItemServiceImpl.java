package service.impl;

import entities.Item;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repository.ItemRepository;
import service.ItemService;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of itemService interface, where interaction with database for items is described
 *
 * @author author
 * @version 1.0
 */
@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;


    /**
     * Searching for certain item by id
     *
     * @param id of the item we search
     */
    @Override
    public Item findById(Long id) {
        Optional<Item> item = itemRepository.findById(id);
        return item.orElse(null);
    }

    /**
     * Adding the item to the DB
     * @param item we want to save
     */
    @Override
    public void addItem(Item item) {
        itemRepository.save(item);
    }

    /**
     * Deleting certain item from the DB
     * @param id of the item we want to find and delete
     */
    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    /**
     * Searching the list of items of some type
     * @param type of the items we want to find
     * @return list of all the items that exist, filtering them by type
     */
    @Override
    public List<Item> findAllItemsByType(String type) {
        return itemRepository.findItemsByType(type);
    }

    /**
     *  Searching the list of items of some type and sorting them by the parameter which is given
     * @param type of the items we want to find
     * @param sortBy parameter by which items would be sorting by
     * @return list of all the items that exist, filtering them by type and sorting them by another principle
     */
    @Override
    public List<Item> findAllItemsByTypeAndSort(String type, String sortBy) {
        return itemRepository.findItemsByTypeOrderBy(type, sortBy);
    }
}
