package com.fitback.personal.opinion.controller;

import com.fitback.personal.common.MessageVO;
import com.fitback.personal.opinion.service.OpinionServiceImpl;
import com.fitback.personal.opinion.model.Opinion;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping
public class OpinionController {

    @Autowired
    private final OpinionServiceImpl opinionService;

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

    @GetMapping("/opinion/list/{id}")
    public Optional<Opinion> getOpinion(@PathVariable Long id){
        return opinionService.opinionView(id);
    }

    @GetMapping("/opinion/list")
    public List<Opinion> getAllOpinion(){
        return opinionService.opinionList();
    }

    @DeleteMapping("/opinion/remove/{id}")
    public void opinionDelete(@PathVariable Long id){
        opinionService.opinionDelete(id);
    }
}
