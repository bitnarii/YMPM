package com.fitback.personal.item.controller;

import com.fitback.personal.item.model.Item;
import com.fitback.personal.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.*;


@CrossOrigin
@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

    @Autowired
    private final ItemService itemService;

    @PostMapping("/add")
    public Item addItem(@RequestBody Item item) {
        return itemService.addItem(item);
    }

    @PutMapping("/edit/{id}")
    public Item editByIdItem(@PathVariable Long id, @RequestBody Item item) {
        return itemService.editByIdItem(item);
    }

    @GetMapping("/getAll")
    public List<Item> getAllItem() {
        return itemService.getAllItem();
    }

    @GetMapping("/get/{id}")
    public Optional<Item> getByIdItem(@PathVariable Long id) {
        return itemService.getByIdItem(id);
    }

    @DeleteMapping("/delete/{id}")
    void deleteByIdItem(@PathVariable Long id) {
        itemService.deleteByIdItem(id);
    }

    @PostMapping("/img")
    public List<String> uploadImg(@RequestParam List<MultipartFile> itemImg) throws Exception {
        //Exception 던져야 transferTo 구현 가능

        List<String> list = new ArrayList<>();
        for (MultipartFile file : itemImg) {
            // 파일 원본명 가져오기
            String fileName  = file.getOriginalFilename();
            //파일이 업로드 될 경로 설정
            File fileAddr = new File("C:/Users/admin/Documents/FinalProject/myFitBack/imgFile/" + fileName);
            //파일 저장
            file.transferTo(fileAddr);
        }
        return list;
    }
}
