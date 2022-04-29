package com.fitback.personal.opinion.service;

import com.fitback.personal.opinion.repository.OpinionRepository;
import com.fitback.personal.opinion.model.Opinion;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OpinionServiceImpl implements OpinionService{

    @Autowired
    private final OpinionRepository opinionRepository;

    @Value("${file.dir}")
    private String imgPath;

    @Override
    public Opinion addOpinion(Opinion opinion, MultipartFile opiFile) throws Exception{

//        String rootPath = System.getProperty("user.dir");
//        String imgPath = "src\\main\\resources\\static\\files";
//        String savePath = rootPath + File.separator + imgPath; //최종 파일 저장 장소

        String orgName = opiFile.getOriginalFilename();
        String fileExt = (orgName != null) ? orgName.substring(orgName.lastIndexOf('.') + 1) : " " ; //파일 확장자
        String imgName = UUID.randomUUID() + "." + fileExt; //서비스 파일명 + 확장자
        File saveImg = new File(imgPath + "/" + imgName); //parent 디렉토리에 imgName 이름의 디렉토리나 파일 객체 생성
        System.out.println(saveImg);

        opiFile.transferTo(saveImg);//파일 저장

        opinion.setFileName(imgName); //서비스 파일명
        opinion.setFileOrigin(orgName); //원본 파일명
//        item.setItemImgPath("/files/" + imgName); //서비스 경로
        opinion.setFilePath(imgPath + "/" + imgName);

//        System.out.println("SAVEPATH : " + imgPath);
//        System.out.println("IMGNAME : " + imgName);
//        System.out.println("ORGNAME : " + orgName);
//        System.out.println("ITEMIMGPATH : " + opinion.getFilePath());
        return opinionRepository.save(opinion);
    }

    @Override
    public Optional<Opinion> opinionView(Long id){
        return opinionRepository.findById(id);
    }

    @Override
    public List<Opinion> opinionList(){
        return opinionRepository.findAll();
    }

    @Override
    public void opinionDelete(Long id){
        opinionRepository.deleteById(id);
    }

    @Override
    public String getByIdItemImgPath(Long id) {
        Opinion opinion = opinionRepository.findById(id).get();
        return opinion.getFilePath();
    }

}
