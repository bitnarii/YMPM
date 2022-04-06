package com.fitback.personal.dailyLook.service;

import com.fitback.personal.dailyLook.model.DailyLook;
import com.fitback.personal.opinion.model.Opinion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DailyLookService {
    int addDailyLook(DailyLook dailyLook, MultipartFile multipartFile) throws Exception;
    Page<DailyLook> dailyLookList(Pageable pageable);
    DailyLook dailyLookView(Long id);
    void deleteByDailyLookId(Long id);
    List<DailyLook> dailyLookList();
}
