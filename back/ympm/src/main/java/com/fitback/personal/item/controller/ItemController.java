package com.fitback.personal.item.controller;

import com.fitback.personal.item.model.AddItemVo;
import com.fitback.personal.item.model.Item;
import com.fitback.personal.item.service.ItemService;
import lombok.RequiredArgsConstructor;
//import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Stream;

//import org.apache.commons.io.IOUtils;
import static java.lang.System.in;


@CrossOrigin
@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

    @Autowired
    private final ItemService itemService;

    @PostMapping("/add")
    public Item addItem(MultipartFile itemImg, Item item) throws Exception{
        return itemService.addItem(itemImg, item);
    }

//    @PostMapping("/add")
//    public AddItemVo addItem(MultipartFile itemImg, Item item) throws Exception{
//        AddItemVo addItemVo = new AddItemVo();
//
//        Item result = itemService.addItem(itemImg, item);
//        addItemVo.put("result", result);
//        return addItemVo;
//    }

    @PutMapping("/edit/{id}")
    public Item editByIdItem(@PathVariable Long id, @RequestParam MultipartFile itemImg, Item item) throws Exception{
        //postman으로 입력했을 때 생성일 안 뜨는 게 당연함. 조회시 볼 수 있음
        return itemService.addItem(itemImg, item);
    }

    @GetMapping("/getAll")
    public List<Item> getAllItem() {
        return itemService.getAllItem();
    }

    @GetMapping("/get/{id}")
    public Optional<Item> getByIdItem(@PathVariable Long id) {
        return itemService.getByIdItem(id);
    }

    @GetMapping("/getImg/{id}")
    public String getByIdItemImg(@PathVariable Long id){
        Item itemVo = itemService.getByIdItem(id).get();
        return itemVo.getItemImgPath();
    }

    @GetMapping("/getImgCat/{itemCategory}")
    public List<Item> getByCategoryItemImg(@PathVariable String itemCategory) {
        return itemService.getByCategoryItem(itemCategory);
    }

    @DeleteMapping("/delete/{id}")
    void deleteByIdItem(@PathVariable Long id) {
        itemService.deleteByIdItem(id);
    }

    @GetMapping(
            value = "/image/{id}",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    public @ResponseBody byte [] getItemImage(@PathVariable Long id, HttpServletRequest request) throws IOException{
        String imagePath = itemService.getByIdItemImgPath(id);
        InputStream imageStream = new FileInputStream(imagePath);
        byte[] imageByteArray = IOUtils.toByteArray(imageStream);
        imageStream.close();

        return imageByteArray;
//        InputStream in = getClass().getResourceAsStream("src\\main\\resources\\static\\files");
//        return IOUtils.toByteArray(in);
    }

}
