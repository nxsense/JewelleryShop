package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import entities.Item;
import lombok.Data;

/**
 * DTO for items
 *
 * @author author
 * @version 1.0
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemDto {
    private int id;
    private String type;
    private int price;
    private String metal;
    private float weight;
    private boolean available;

    public static ItemDto fromItem(Item item) {
        ItemDto itemDto = new ItemDto();
        itemDto.setId(item.getId());
        itemDto.setType(item.getType());
        itemDto.setPrice(item.getPrice());
        itemDto.setMetal(item.getMetal());
        itemDto.setWeight(item.getWeight());
        itemDto.setAvailable(item.isAvailable());
        return itemDto;
    }

    public Item toItem() {
        Item item = new Item();
        item.setId(id);
        item.setType(type);
        item.setPrice(price);
        item.setMetal(metal);
        item.setWeight(weight);
        item.setAvailable(available);
        return item;
    }
}
