package ar.com.apirestswagger.services.impl;

import ar.com.apirestswagger.models.Item;
import ar.com.apirestswagger.repository.ItemRepository;
import ar.com.apirestswagger.services.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    private ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    @Override
    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item getById(Integer id) {
        return itemRepository.findById(id).get();
    }

    @Override
    public void deleteItem(Integer id) {
        itemRepository.delete(id);
    }

    @Override
    public void saveItem(Item item) {
        itemRepository.save(item);
    }
}
