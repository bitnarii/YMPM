package com.fitback.personal.dailyLook.service;

import com.fitback.personal.dailyLook.dto.DailyLookDto;
import com.fitback.personal.dailyLook.model.DailyLook;
import com.fitback.personal.dailyLook.repository.DailyLookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class DailyLookServiceImpl implements DailyLookService{

    @Autowired
    private DailyLookRepository dailyLookRepository;

    @Value("${file.dir}")
    private String imgPath;

    @Override
    public DailyLook addDailyLook(MultipartFile orgFile, DailyLook dailyLook) throws Exception{

        //        String rootPath = System.getProperty("user.dir"); //현재 디렉토리 위치 받아오기 (springboot 폴더가 저장되어 있는 위치)
//                "src/main/webapp/static/image"; //디렉토리 내에 파일이 저장될 상세 위치
//        String savePath =  /*File.separator +*/ imgPath; //최종 파일 저장 장소

        //받아온 MultiPartFile 의 원본 파일명
        String orgName = orgFile.getOriginalFilename();
        String fileExt = (orgName != null) ? orgName.substring(orgName.lastIndexOf('.') + 1) : " "; //파일 확장자
        String imgName = UUID.randomUUID() + "." + fileExt; //서비스 파일명 + 확장자
        File saveImg = new File(imgPath + "/" + imgName); //parent 디렉토리에 imgName 이름의 디렉토리나 파일 객체 생성

            orgFile.transferTo(saveImg);//파일 저장

//        log.info(imgPath + "/" + imgName);
            dailyLook.setFileName(imgName); //서비스 파일명
            dailyLook.setFileOrigin(orgName); //원본 파일명
            dailyLook.setFilePath(imgPath + "/" + imgName); //절대 경로 + 이미지 파일명 저장
//            System.out.println("SAVEPATH : " + imgPath);
//            System.out.println("IMGNAME : " + imgName);
//            System.out.println("ORGNAME : " + orgName);
//            System.out.println("ITEMIMGPATH : " + dailyLook.getFilePath());
        return dailyLookRepository.save(dailyLook);
    }

//    @Override
//   public Page<DailyLook> dailyLookList(Pageable pageable){
//    return dailyLookRepository.findAll(pageable);
//    }

    @Override
    public DailyLook dailyLookView(Long id) {
        return dailyLookRepository.findById(id).get();
    }

    @Override
    public void deleteByDailyLookId(Long id) {
        dailyLookRepository.deleteById(id);
    }

    @Override
    public List<DailyLook> dailyLookList(){
        return dailyLookRepository.findAll();
    }

    @Override
    public List<DailyLookDto> searchPosts(String keyword) {
        List<DailyLook> dailyLooks = dailyLookRepository.findByDailyLookNameContaining(keyword);
        List<DailyLookDto> dailyLookDtoList = new ArrayList<>();

        if (dailyLooks.isEmpty()) return dailyLookDtoList;

        for (DailyLook dailyLook : dailyLooks) {
            dailyLookDtoList.add(this.convertEntityToDto(dailyLook));
        }

        return dailyLookDtoList;

    }

    @Override
    public DailyLook editDailyLook( Long id, DailyLook dailyLook, MultipartFile orgFile) throws Exception {
        //        String rootPath = System.getProperty("user.dir"); //현재 디렉토리 위치 받아오기 (springboot 폴더가 저장되어 있는 위치)
//                "src/main/webapp/static/image"; //디렉토리 내에 파일이 저장될 상세 위치
//        String savePath =  /*File.separator +*/ imgPath; //최종 파일 저장 장소

        //받아온 MultiPartFile 의 원본 파일명
        String orgName = orgFile.getOriginalFilename();
        String fileExt = (orgName != null) ? orgName.substring(orgName.lastIndexOf('.') + 1) : " "; //파일 확장자
        String imgName = UUID.randomUUID() + "." + fileExt; //서비스 파일명 + 확장자
        File saveImg = new File(imgPath + "/" + imgName); //parent 디렉토리에 imgName 이름의 디렉토리나 파일 객체 생성

        orgFile.transferTo(saveImg);//파일 저장

//        log.info(imgPath + "/" + imgName);
        dailyLook.setFileName(imgName); //서비스 파일명
        dailyLook.setFileOrigin(orgName); //원본 파일명
        dailyLook.setFilePath(imgPath + "/" + imgName); //절대 경로 + 이미지 파일명 저장
//            System.out.println("SAVEPATH : " + imgPath);
//            System.out.println("IMGNAME : " + imgName);
//            System.out.println("ORGNAME : " + orgName);
//            System.out.println("ITEMIMGPATH : " + dailyLook.getFilePath());
        return dailyLookRepository.save(dailyLook);
    }
//        String rootPath = System.getProperty("user.dir");
//        String imgPath = "src\\main\\resources\\static\\files";
//        String savePath = rootPath + File.separator + imgPath; //최종 파일 저장 장소
//
//        String orgName = orgFile.getOriginalFilename();
//        String imgName = UUID.randomUUID() + ".jpg";
//        File saveImg = new File(savePath + File.separator + imgName); //parent 디렉토리에 imgName 이름의 디렉토리나 파일 객체 생성
//        System.out.println(saveImg);
//
//        orgFile.transferTo(saveImg);//파일 저장
//
//        dailyLook.setFileName(imgName); //서비스 파일명
//        dailyLook.setFileOrigin(orgName); //원본 파일명
//        dailyLook.setFilePath(savePath + File.separator + imgName); //절대 경로 + 이미지 파일명 저장
//
//        System.out.println("SAVEPATH : " + savePath);
//        System.out.println("IMGNAME : " + imgName);
//        System.out.println("ORGNAME : " + orgName);
//        System.out.println("ITEMIMGPATH : " + dailyLook.getFilePath());
//
//        return dailyLookRepository.save(dailyLook);

    @Override
    public DailyLook editDailyLook(DailyLook dailyLook) {
        return dailyLookRepository.save(dailyLook);
    }

    private DailyLookDto convertEntityToDto(DailyLook dailyLook) {
        return DailyLookDto.builder()
                .id(dailyLook.getId())
                .dailyLookName(dailyLook.getDailyLookName())
                .style(dailyLook.getStyle())
                .filePath(dailyLook.getFilePath())
                .fileName(dailyLook.getFileName())
                .topBrand(dailyLook.getTopBrand())
                .topName(dailyLook.getTopName())
                .bottomBrand(dailyLook.getBottomBrand())
                .bottomName(dailyLook.getBottomName())
                .dressBrand(dailyLook.getDressBrand())
                .dressName(dailyLook.getDressName())
                .outerBrand(dailyLook.getOuterBrand())
                .outerName(dailyLook.getOuterName())
                .shoesBrand(dailyLook.getShoesBrand())
                .shoesName(dailyLook.getShoesName())
                .etcBrand(dailyLook.getEtcBrand())
                .etcName(dailyLook.getEtcName())
                .bookmark(dailyLook.getBookmark())
                .description(dailyLook.getDescription())
                .opinions(dailyLook.getOpinions())
                .build();
            }

    @Override
    public String getByIdItemImgPath(Long id) {
        DailyLook dailyLook = dailyLookRepository.findById(id).get();
        return dailyLook.getFilePath();
    }


}

