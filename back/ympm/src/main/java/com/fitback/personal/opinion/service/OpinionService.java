package com.fitback.personal.opinion.service;

import com.fitback.personal.opinion.model.Opinion;
import org.springframework.web.multipart.MultipartFile;

public interface OpinionService {
    int addOpinion(Opinion opinion, MultipartFile opiFile) throws Exception;
    Opinion opinionView(Long id);
    void opinionDelete(Opinion opinion);
}
