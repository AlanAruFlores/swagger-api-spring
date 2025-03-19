package ar.com.apirestswagger.controllers;

import ar.com.apirestswagger.models.Item;
import ar.com.apirestswagger.services.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Item>> getAllItems() {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getAllItems(@PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.getById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveItem(@RequestBody Item item) {
        this.itemService.saveItem(item);
        return ResponseEntity.ok("Se guardo exitosamente");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable("id") Integer id) {
        this.itemService.deleteItem(id);
        return ResponseEntity.ok("Se elimino exitosamente");
    }


}
