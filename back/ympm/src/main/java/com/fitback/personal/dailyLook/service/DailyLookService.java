package com.fitback.personal.dailyLook.service;

import com.fitback.personal.dailyLook.dto.DailyLookDto;
import com.fitback.personal.dailyLook.model.DailyLook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.EOFException;
import java.io.IOException;
import java.util.List;

public interface DailyLookService {
    DailyLook addDailyLook(MultipartFile multipartFile, DailyLook dailyLook) throws Exception;
//    Page<DailyLook> dailyLookList(Pageable pageable);
    DailyLook dailyLookView(Long id);
    void deleteByDailyLookId(Long id);
    List<DailyLook> dailyLookList();
    DailyLook editDailyLook(Long id, DailyLook dailyLook, MultipartFile orgFile) throws Exception;
    public String getByIdItemImgPath(Long id);
    List<DailyLookDto> searchPosts(String keyword);
    DailyLook editDailyLook(DailyLook dailyLook);

}
