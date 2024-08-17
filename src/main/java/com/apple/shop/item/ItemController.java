package com.apple.shop.item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;
    private final ItemRepository itemRepository;

    @GetMapping("/list")
    String list(Model model) {
        List<Item> result = itemRepository.findAll();
        model.addAttribute("items", result);
        return "list.html";
    }

    @GetMapping("/write")
    String write() {
        return "write.html";
    }

    @PostMapping("/add")
    String addPost(@RequestParam String title, Integer price) {
        itemService.saveItem(title, price);
        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    String itemDetail(@PathVariable Long id, Model model) {
        Optional<Item> result = itemRepository.findById(id);
        if (result.isPresent()) {
            model.addAttribute("item", result.get());
            return "detail.html";
        } else {
            return "redirect:/list";
        }
    }

    @GetMapping("/edit/{id}")
    String edit(@PathVariable Long id, Model model) {
        Optional<Item> result = itemRepository.findById(id);
        if (result.isPresent()) {
            model.addAttribute("item", result.get());
            return "edit.html";
        } else {
            return "redirect:/list";
        }
    }

    @PostMapping("/edit")
    String editItem(@RequestParam Long id, String title, Integer price) {
        itemService.updateItem(id, title, price);
        return "redirect:/list";
    }
}

