package com.mafort.poupagrana.controllers;

import com.mafort.poupagrana.domain.item.Item;
import com.mafort.poupagrana.domain.item.ItemResponseDTO;
import com.mafort.poupagrana.repositories.ItemRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @PostMapping
    public ResponseEntity<ItemResponseDTO> postItem(@RequestBody @Valid ItemResponseDTO body){
        Item item = new Item(body);
        Item savedItem = this.itemRepository.save(item);
        return ResponseEntity.ok(new ItemResponseDTO(savedItem));
    }

    @GetMapping
    public ResponseEntity<List<ItemResponseDTO>> getItems(){
        List<ItemResponseDTO> productList = this.itemRepository.findAll().stream().map(ItemResponseDTO::new).toList();
        return ResponseEntity.ok(productList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemResponseDTO> putItem(@PathVariable Long id, @RequestBody @Valid ItemResponseDTO body) {
        Optional<Item> optionalItem = this.itemRepository.findById(id);
        if(optionalItem.isPresent()) {
            Item item = optionalItem.get();
            item.update(body);
            this.itemRepository.save(item);
            return ResponseEntity.ok(new ItemResponseDTO(item));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id){
        if(this.itemRepository.existsById(id)) {
            this.itemRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/user/{userId}")
    public List<Item> getItemsByUser_id(@PathVariable String userId) {
        return itemRepository.findByUser_id(userId);
    }


}
