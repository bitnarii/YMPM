package com.fitback.personal.itemInCloset.controller;

import com.fitback.personal.closet.service.ClosetService;
import com.fitback.personal.item.service.ItemService;
import com.fitback.personal.itemInCloset.model.IItemInCloset;
import com.fitback.personal.itemInCloset.model.ItemInCloset;
import com.fitback.personal.itemInCloset.service.ItemInClosetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/itemInCloset")
@RequiredArgsConstructor
public class ItemInClosetController {

    @Autowired
    private final ItemInClosetService itemInClosetService;
    @Autowired
    private final ItemService itemService;
    @Autowired
    private final ClosetService closetService;

    @PostMapping("/add")
    public ItemInCloset addItemInCloset(@RequestBody IItemInCloset iMapping) {
        return itemInClosetService.addItemInCloset(
                ItemInCloset.builder()
                        //dto 클래스를 이용해 아이디를 받아 그 아이디로 객체 전체를 찾아오는 구조
                        .item(itemService.getByIdItem(iMapping.getItem_id()).get())
                        .closet(closetService.getByIdCloset(iMapping.getCloset_id()).get())
                        .build()
        );
    }

    @GetMapping("/getAll")
    public List<ItemInCloset> getAllItemInCloset() {
        return itemInClosetService.getAllItemInCloset();
    }

    @GetMapping("/get/{id}")
    public Optional<ItemInCloset> getByIdItemInCloset(@PathVariable Long id) {
        return itemInClosetService.getByIdItemInCloset(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteByIdItemInCloset(@PathVariable Long id) {
        itemInClosetService.deleteByIdItemInCloset(id);
    }

}
