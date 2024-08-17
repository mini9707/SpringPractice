package com.apple.shop.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public void saveItem(String title, Integer price) {
        Item item = new Item(title, price);
        itemRepository.save(item);
    }

    public void updateItem(Long id, String title, Integer price) {
        Item item = new Item(id, title, price);
        itemRepository.save(item);
    }
}
