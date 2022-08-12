package service.impl;

import entities.Item;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repository.ItemRepository;
import service.ItemService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;


    @Override
    public Item findById(Long id) {
        Optional<Item> item = itemRepository.findById(id);
        return item.orElse(null);
    }

    @Override
    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public List<Item> findAllItemsByType(String type) {
        return itemRepository.findItemsByType(type);
    }

    @Override
    public List<Item> findAllItemsByTypeAndSort(String type, String sortBy) {
        return itemRepository.findItemsByTypeOrderBy(type, sortBy);
    }
}
