package com.fitback.personal.opinion.controller;

import com.fitback.personal.common.MessageVO;
import com.fitback.personal.opinion.repository.OpinionRepository;
import com.fitback.personal.opinion.service.OpinionServiceImpl;
import com.fitback.personal.opinion.model.Opinion;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping
@Slf4j
public class OpinionController {

    @Autowired
    private final OpinionServiceImpl opinionService;
    @Autowired
    private final OpinionRepository opinionRepository;

    @PostMapping("/opinion/add")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageVO addOpinion(Opinion opinion, MultipartFile opiFile) throws Exception{

        MessageVO result = new MessageVO();
        System.out.println("OPINION:"+ opinion.toString());
        boolean[] temp = opinion.getCheckedState();  //체크박스 배열에서 for문을 통한 점수 채점
        int sum = 0;
        for(boolean flag : temp)  sum += (flag) ? 20 : 0;
        opinion.setScore(sum);
        opinion.setCheckedState(temp);



        int resultCode = -1;

        resultCode = opinionService.addOpinion(opinion, opiFile);

        result.put("resultMessage", resultCode);
        if (resultCode > -1){
            result.put("resultMessage", "저장 성공");
            result.put("searchUrl", "/opinion/list");
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
        return opinionRepository.findAll();
    }

    @DeleteMapping("/opinion/remove/{id}")
    public void opinionDelete(@PathVariable Long id){
        opinionService.opinionDelete(id);
    }
}
