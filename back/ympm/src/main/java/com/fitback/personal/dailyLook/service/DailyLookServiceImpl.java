package com.fitback.personal.dailyLook.service;

import com.fitback.personal.dailyLook.dto.DailyLookDto;
import com.fitback.personal.dailyLook.model.DailyLook;
import com.fitback.personal.dailyLook.repository.DailyLookRepository;
import com.fitback.personal.post.dto.PostDto;
import com.fitback.personal.post.model.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class DailyLookServiceImpl implements DailyLookService{

    @Autowired
    private DailyLookRepository dailyLookRepository;

    @Override
    public int addDailyLook(DailyLook dailyLook, MultipartFile orgFile) throws Exception {

        String filePath;    // 파일 경로
        UUID uuid;          // 파일 고유 식별자
        String fileName;    // 파일명
        File saveFile;      // 저장 파일명
        int result = 0;     // 0 : success, -1:failed

        try {
            if(orgFile != null) {
                filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";
                uuid = UUID.randomUUID();
                fileName = uuid + orgFile.getOriginalFilename();
                saveFile = new File(filePath, fileName);
                orgFile.transferTo(saveFile);
                dailyLook.setFileName(fileName);
                dailyLook.setFilePath("/files/" + fileName);
            }
        }catch(FileNotFoundException fe){
            result = -1;
        }
        dailyLookRepository.save(dailyLook);
        return result;
    }

    @Override
   public Page<DailyLook> dailyLookList(Pageable pageable){
    return dailyLookRepository.findAll(pageable);
    }

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
                .info(dailyLook.getInfo())
                .bookmark(dailyLook.getBookmark())
                .description(dailyLook.getDescription())
                .opinions(dailyLook.getOpinions())
                .build();


    }
}

