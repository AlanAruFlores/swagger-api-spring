package ar.com.apirestswagger.controllers;

import ar.com.apirestswagger.models.Item;
import ar.com.apirestswagger.services.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Tag is used to group the APIs in a meaningful way.
 * @Operation is used to add aditional information
 * @ApiResponses is useful to specify which responses are going to retrieve the request.
 */

@RestController
@RequestMapping("/api/item")
public class ItemController {

    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @Tag(name="get", description="Get methods for Items")
    @Operation(summary="Get all items", description = "In this request you can get the all items")
    @GetMapping("/all")
    public ResponseEntity<List<Item>> getAllItems() {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.getAll());
    }
    @Tag(name="get", description="Get methods for Items")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Item.class))}),
            @ApiResponse(responseCode = "404", description = "item not found", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<Item> getAllItems(@PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.getById(id));
    }

    @Tag(name="post", description="Post methods for Items")
    @PostMapping("/save")
    public ResponseEntity<String> saveItem(@RequestBody Item item) {
        this.itemService.saveItem(item);
        return ResponseEntity.ok("Se guardo exitosamente");
    }

    @Tag(name="delete", description="Delete methods for Items")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable("id") Integer id) {
        this.itemService.deleteItem(id);
        return ResponseEntity.ok("Se elimino exitosamente");
    }


}
