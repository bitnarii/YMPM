package com.fitback.personal.opinion.service;

import com.fitback.personal.opinion.model.Opinion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface OpinionService {
    int addOpinion(Opinion opinion, MultipartFile opiFile) throws Exception;
    List<Opinion> opinionList();
    Optional<Opinion> opinionView(Long id);
    void opinionDelete(Long id);
    double getAverageOpinion(Opinion opinion);
}
