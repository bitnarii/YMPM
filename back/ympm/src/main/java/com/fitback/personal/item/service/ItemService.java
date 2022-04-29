package com.fitback.personal.item.service;

import com.fitback.personal.item.model.Item;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

//어떤 기능들인지 ItemServiceImpl 참고하기
public interface ItemService {
//    Item addItem(MultipartFile itemImg, Item item) throws IOException;
    Item addItem(MultipartFile itemImg, Item item) throws IOException;
    List<Item> getAllItem();
    Optional<Item> getByIdItem(Long id);
    List<Item> getByCategoryItem(String itemCategory);
    void deleteByIdItem(Long id);
    String getByIdItemImgPath(Long id);
}
