package com.fitback.ympm.opinion.service;

import com.fitback.ympm.opinion.model.Opinion;
import com.fitback.ympm.opinion.repository.OpinionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OpinionService {

    @Autowired
    private final OpinionRepository opinionRepository;

    public int addOpinion(Opinion opinion, MultipartFile opiFile) throws Exception{

        String filePath;          // 파일 경로
        UUID uuid;               // 파일 고유 식별자
        String fileName;      // 파일명
        File saveFile;           // 저장 파일명
        int result = 0;          // 0 : success, -1:failed

        try {
            if (opiFile != null){
                filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";
                uuid = UUID.randomUUID();
                fileName = uuid  + opiFile.getOriginalFilename();
                saveFile = new File(filePath, fileName);
                opiFile.transferTo(saveFile);
                opinion.setFileName(fileName);
                opinion.setFilePath("/files/" + fileName);
            }
        } catch (FileNotFoundException e){
            result = -1;
        }
        opinionRepository.save(opinion);
        return result;
    }

    public Opinion opinionView(Long id){
        return opinionRepository.findById(id).get();
    }

    public List<Opinion> opinionList(){
        return opinionRepository.findAll();
    }

    public void opinionDelete(Opinion opinion){
        opinionRepository.delete(opinion);
    }

}