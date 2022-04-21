package com.fitback.personal.item.service;

import com.fitback.personal.item.model.Item;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    Item addItem(MultipartFile itemImg, Item item) throws Exception;
//    Item editByIdItem(Item item);
    List<Item> getAllItem();
    Optional<Item> getByIdItem(Long id);
    List<Item> getByCategoryItem(String itemCategory);
    void deleteByIdItem(Long id);
    String getByIdItemImgPath(Long id);
//    public List<String> uploadImg(@RequestParam List<MultipartFile> itemImg) throws Exception;
}
