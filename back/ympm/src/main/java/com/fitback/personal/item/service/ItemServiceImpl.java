package com.fitback.personal.item.service;

import com.fitback.personal.item.model.Item;
import com.fitback.personal.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor //추가 작업을 필요로 하는 필드에 대한 생성자를 생성하는 어노테이션 (초기화 되지 않은 모든 final 필드, @NonNull 로 마크돼있는 모든 필드들에 대한 생성자를 자동으로 생성)
public class ItemServiceImpl implements ItemService{

    @Autowired
    private final ItemRepository itemRepository;

    @Override
    @Transactional //begin, commit 자동 수행, 예외 발생 시 rollback 처리
    public Item addItem(MultipartFile itemImg, Item item) throws IOException { //I/O 오류가 발생하는 경우에 throw 되는 예외

        String rootPath = System.getProperty("user.dir"); //현재 디렉토리 위치 받아오기 (springboot 폴더가 저장되어 있는 위치)
        String imgPath = "src\\main\\resources\\static\\files"; //디렉토리 내에 파일이 저장될 상세 위치
        String savePath = rootPath + File.separator + imgPath; //최종 파일 저장 장소

        String orgName = itemImg.getOriginalFilename(); //받아온 MultiPartFile 의 원본 파일명
        String fileExt = (orgName != null) ? orgName.substring(orgName.lastIndexOf('.') + 1) : " "; //파일 확장자
        String imgName = UUID.randomUUID() + "." + fileExt; //서비스 파일명 + 확장자
        File saveImg = new File(savePath + File.separator + imgName); //parent 디렉토리에 imgName 이름의 디렉토리나 파일 객체 생성

        itemImg.transferTo(saveImg);//파일 저장

        item.setItemImgName(imgName); //서비스 파일명
        item.setItemImgOrigin(orgName); //원본 파일명
        item.setItemImgPath(savePath + File.separator + imgName); //서비스 파일이 저장된 절대 경로

        return itemRepository.save(item); //아이템 저장
    }

    @Override
    @Transactional
    public List<Item> getAllItem() {
        return itemRepository.findAll(); //저장되어 있는 모든 아이템 리턴
    }

    @Override
    @Transactional
    public Optional<Item> getByIdItem(Long id) { //ItemInCloset 클래스에서 매핑할 때 Optional 기능이 필요해 (null problem) Optional 사용
        return itemRepository.findById(id); //item id 를 이용해 item 리턴
    }

    @Override
    public List<Item> getByCategoryItem(String itemCategory) {
        return itemRepository.findByItemCategory(itemCategory); //itemCategory 를 이용해 item 리턴
    }

    @Override
    @Transactional
    public void deleteByIdItem(Long id) {
        itemRepository.deleteById(id); //item id를 이용해 item 삭제
    }

    @Override
    public String getByIdItemImgPath(Long id) {
        Item item = itemRepository.findById(id).get(); //item id 를 이용해 item 전체 리턴 받기
        return item.getItemImgPath(); //받아온 item 의 itemImgPath (이미지의 절대 경로) 리턴
    }

}
