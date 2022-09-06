package RestControllers;

import dto.ItemDto;
import dto.UserDto;
import entities.Item;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ItemService;
import service.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/catalog/")
public class ItemsController {

    private final ItemService itemService;

    @Autowired
    public ItemsController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ItemDto> getItemById(@PathVariable(name = "id") Long id) {
        Item item = itemService.findById(id);

        if (item == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ItemDto result = ItemDto.fromItem(item);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "{type}")
    public ResponseEntity<List<ItemDto>> getItemsByType(@PathVariable(name = "type") String type){
        List<Item> items = itemService.findAllItemsByType(type);
        if(items.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<ItemDto> result = new ArrayList<>();
        for (Item item : items) {
            result.add(ItemDto.fromItem(item));
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
