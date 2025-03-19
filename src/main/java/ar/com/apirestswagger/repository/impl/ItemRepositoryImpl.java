package ar.com.apirestswagger.repository.impl;

import ar.com.apirestswagger.models.Item;
import ar.com.apirestswagger.repository.ItemRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ItemRepositoryImpl implements ItemRepository {
    private List<Item> itemsData = new ArrayList<>(){
        {
            add(new Item(1,"Item 1", "Este es el item 1"));
            add(new Item(2,"Item 2", "Este es el item 2"));
            add(new Item(3,"Item 3", "Este es el item 3"));
            add(new Item(4,"Item 4", "Este es el item 4"));
        }
    };

    @Override
    public List<Item> findAll() {
        return itemsData;
    }

    @Override
    public void save(Item item) {
        this.itemsData.add(item);
    }

    @Override
    public Optional<Item> findById(Integer id) {
        return this.itemsData.stream().filter( it -> it.getId().equals(id)).findFirst();
    }

    @Override
    public void delete(Integer id) {
        Item itemToRemove =  this.itemsData.stream().filter( it -> it.getId().equals(id)).findFirst().get();
        this.itemsData.remove(itemToRemove);
    }

}
