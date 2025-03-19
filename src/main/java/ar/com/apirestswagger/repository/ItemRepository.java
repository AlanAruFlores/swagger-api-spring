package ar.com.apirestswagger.repository;

import ar.com.apirestswagger.models.Item;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {

    List<Item> findAll();
    void save(Item item);
    Optional<Item> findById(Integer id);
    void delete(Integer id);
}
