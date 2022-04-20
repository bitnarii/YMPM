package com.fitback.personal.opinion.service;

import com.fitback.personal.opinion.repository.OpinionRepository;
import com.fitback.personal.opinion.model.Opinion;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

    @Override
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
   public double getAverageOpinion(Opinion opinion){
        return 0;
    }

}
