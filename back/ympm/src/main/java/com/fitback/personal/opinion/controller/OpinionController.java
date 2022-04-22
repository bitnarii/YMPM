package com.fitback.personal.opinion.controller;

import com.fitback.personal.opinion.repository.OpinionRepository;
import com.fitback.personal.opinion.service.OpinionServiceImpl;
import com.fitback.personal.opinion.model.Opinion;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping
public class OpinionController {

    @Autowired
    private final OpinionServiceImpl opinionService;
    @Autowired
    private final OpinionRepository opinionRepository;

    @PostMapping("/opinion/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Opinion addOpinion(Opinion opinion, MultipartFile opiFile) throws Exception{

        boolean[] temp = opinion.getCheckedState();  //체크박스 배열에서 for문을 통한 점수 채점
        int sum = 0;
        for(boolean flag : temp)  sum += (flag) ? 20 : 0;
        opinion.setScore(sum);
        opinion.setCheckedState(temp);

        return opinionService.addOpinion(opinion, opiFile);
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

    @GetMapping("/opinion/image/{id}")
    public @ResponseBody byte [] getItemImage(@PathVariable Long id, HttpServletRequest request) throws IOException {
        String imagePath = opinionService.getByIdItemImgPath(id);
        InputStream imageStream = new FileInputStream(imagePath);
        byte[] imageByteArray = IOUtils.toByteArray(imageStream);
        imageStream.close();

        return imageByteArray;
    }
}
