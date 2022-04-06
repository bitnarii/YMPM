package com.fitback.ympm.opinion.controller;

import com.fitback.ympm.common.MessageVO;
import com.fitback.ympm.opinion.model.Opinion;
import com.fitback.ympm.opinion.service.OpinionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class OpinionController {

    @Autowired
    private final OpinionService opinionService;

    @PostMapping("/opinion/add")
    public MessageVO addOpinion(Opinion opinion, MultipartFile opiFile) throws Exception{

        MessageVO result = new MessageVO();

        System.out.println("OPINION:"+ opinion.toString());

        int resultCode = -1;

        resultCode = opinionService.addOpinion(opinion, opiFile);
        result.put("resultMessage", "저장 성공");
//        result.put("searchUrl", "/opinion/add");
        result.put("opinion", opinion);
        if (resultCode > -1){
            result.put("resultMessage", "저장 성공");
            result.put("opinion", opinion);
        } else {
            result.put("resultMessage", "저장 실패");
        }
        return result;
    }

    @GetMapping("/opinion/find/{id}")
    public Opinion getOpinion(Long id){
        return opinionService.opinionView(id);
    }

    @GetMapping("/opinion/findAll")
    public List<Opinion> getAllOpinion(){
        return opinionService.opinionList();
    }

    @DeleteMapping("/opinion/delete/{id}")
    public void opinionDelete(@ModelAttribute Opinion opinion){
        opinionService.opinionDelete(opinion);
    }
}