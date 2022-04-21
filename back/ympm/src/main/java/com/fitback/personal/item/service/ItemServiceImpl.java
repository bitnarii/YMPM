package com.fitback.personal.item.service;

import com.fitback.personal.item.model.Item;
import com.fitback.personal.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService{
    @Autowired
    private final ItemRepository itemRepository;

    @Override
//    @Transactional //begin, commit 자동 수행, 예외 발생 시 rollback 처리
    public Item addItem(MultipartFile itemImg, Item item) throws IllegalStateException, Exception{

        String rootPath = System.getProperty("user.dir");
        String imgPath = "src\\main\\resources\\static\\files";
        String savePath = rootPath + File.separator + imgPath; //최종 파일 저장 장소

        String orgName = itemImg.getOriginalFilename();
        String fileExt = (orgName != null) ? orgName.substring(orgName.lastIndexOf('.') + 1) : " " ; //파일 확장자
        String imgName = UUID.randomUUID() + "." + fileExt; //서비스 파일명 + 확장자
        File saveImg = new File(savePath + File.separator + imgName); //parent 디렉토리에 imgName 이름의 디렉토리나 파일 객체 생성
        System.out.println(saveImg);

        itemImg.transferTo(saveImg);//파일 저장

        item.setItemImgName(imgName); //서비스 파일명
        item.setItemImgOrigin(orgName); //원본 파일명
//        item.setItemImgPath("/files/" + imgName); //서비스 경로
        item.setItemImgPath(savePath + File.separator + imgName);


        System.out.println("SAVEPATH : " + savePath);
        System.out.println("IMGNAME : " + imgName);
        System.out.println("ORGNAME : " + orgName);
        System.out.println("ITEMIMGPATH : " + item.getItemImgPath());

        return itemRepository.save(item);
    }

    @Override
    @Transactional
    public List<Item> getAllItem() {
        return itemRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Item> getByIdItem(Long id) {
        //ItemInCloset 클래스에서 매핑할 때 Optional 기능이 필요해 (null problem) Optional 사용
        return itemRepository.findById(id);
    }

    @Override
    public List<Item> getByCategoryItem(String itemCategory) {
        return itemRepository.findByItemCategory(itemCategory);
    }

    @Override
    @Transactional
    public void deleteByIdItem(Long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public String getByIdItemImgPath(Long id) {
        Item item = itemRepository.findById(id).get();
        return item.getItemImgPath();
    }

//    이미지 파일 업로드
//    @Override
//    public List<String> uploadImg(@RequestParam List<MultipartFile> itemImg) throws Exception {
//        //Exception 던져야 transferTo 구현 가능
//
//        List<String> list = new ArrayList<>();
//        for (MultipartFile file : itemImg) {
//            // 파일 원본명 가져오기
//            String fileName  = file.getOriginalFilename();
//            //파일이 업로드 될 경로 설정
//            File filePath = new File("C:/Users/admin/Documents/myFitBack_imgFile/" + fileName);
//            //경로 없을 시 생성 (상대 경로 생성 방법 모르겠어서 일단 이렇게 유지 ㅠㅠ)
//            if ( ! filePath.exists()) {
//                //(밑에 건 경고무시문?) mkdir 에 경고문 떠서 아래 문구 추가하니 사라짐
//                //noinspection ResultOfMethodCallIgnored
//                new File("C:/Users/admin/Documents/myFitBack_imgFile").mkdir();
//            }
//            //파일 저장
//            file.transferTo(filePath);
//        }
//        return list;
//    }

}
