package com.fitback.personal.item.controller;

import com.fitback.personal.item.model.Item;
import com.fitback.personal.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils; //이미지 리턴에 필요한 IOUtils 가 저장되어 있는 dependency (gradle build 필요)
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@CrossOrigin //프론트와 연결시 CORS 충돌 방지해주는 어노테이션
@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

    @Autowired
    private final ItemService itemService;

    @PostMapping("/add")
    public Item addItem(@RequestParam MultipartFile itemImg, Item item) throws Exception{ //@RequestParam = 키값 지정
        return itemService.addItem(itemImg, item); //아이템 추가
    }

    @PutMapping("/edit/{id}")
    public Item editByIdItem(@PathVariable Long id, @RequestParam MultipartFile itemImg, Item item) throws Exception{
        //postman으로 입력했을 때 생성일 null 값으로 뜨는 게 당연함. 조회시 볼 수 있음
        return itemService.addItem(itemImg, item); //아이템 수정
    }

    @GetMapping("/getAll")
    public List<Item> getAllItem() {
        return itemService.getAllItem(); //아이템 전체 리턴
    }

    @GetMapping("/get/{id}")
    public Optional<Item> getByIdItem(@PathVariable Long id) {
        return itemService.getByIdItem(id); //item id를 이용해 아이템 리턴
    }

    @GetMapping("/getImg/{id}")
    public String getByIdItemImg(@PathVariable Long id){
        Item itemVo = itemService.getByIdItem(id).get(); //item id를 이용해 아이템 객체 리턴
        return itemVo.getItemImgPath(); //아이템의 이미지 절대경로 리턴
    }

    @GetMapping("/getImgCat/{itemCategory}")
    public List<Item> getByCategoryItemImg(@PathVariable String itemCategory) {
        return itemService.getByCategoryItem(itemCategory); //아직 구현 X, 아이템 카테고리를 이용해 아이템 받아올 예정
    }

    @DeleteMapping("/delete/{id}")
    void deleteByIdItem(@PathVariable Long id) {
        itemService.deleteByIdItem(id); //item id를 이용해 아이템 삭제
    }

    @GetMapping(
            value = "/image/{id}", //매핑할 때 경로 설정
            produces = MediaType.IMAGE_JPEG_VALUE //반환하는 데이터 타입 정의
    )
    public @ResponseBody byte [] getItemImage(@PathVariable Long id, HttpServletRequest request) throws IOException{
        //@ResponseBody = 비동기 처리시 사용, HttpServletRequest = Http 프로토콜의 request 정보를 서블릿에게 전달하기 위해 사용
        String imagePath = itemService.getByIdItemImgPath(id); //이미지가 저장되어 있는 (이미지 파일 포함된) 절대 경로
        InputStream imageStream = new FileInputStream(imagePath); //FileInputStream = 파일로부터 바이트로 입력받아, 바이트 단위로 출력할 수 있는 클래스
        byte[] imageByteArray = IOUtils.toByteArray(imageStream); //이미지 파일을 바이트 배열로 변환 (웹에서 이미지 조회 가능하도록)
        imageStream.close(); //사용 완료한 imput stream 닫아주기

        return imageByteArray; //변환한 이미지 파일 바이트 배열을 리턴
//        InputStream in = getClass().getResourceAsStream("src\\main\\resources\\static\\files");
//        return IOUtils.toByteArray(in);
    }

}
