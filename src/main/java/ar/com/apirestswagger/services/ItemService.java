package ar.com.apirestswagger.services;

import ar.com.apirestswagger.models.Item;

import java.util.List;

public interface ItemService {
    List<Item> getAll();
    Item getById(Integer id);
    void deleteItem(Integer id);
    void saveItem(Item item);
}
