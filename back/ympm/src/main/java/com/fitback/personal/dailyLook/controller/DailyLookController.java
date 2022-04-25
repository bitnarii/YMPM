package com.fitback.personal.dailyLook.controller;

import com.fitback.personal.dailyLook.dto.DailyLookDto;
import com.fitback.personal.dailyLook.model.DailyLook;
import com.fitback.personal.dailyLook.service.DailyLookServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping
@Slf4j
public class DailyLookController {

    @Autowired
    private final DailyLookServiceImpl dailyLookService;

    @PostMapping("/dailyLook/add")
    @ResponseStatus(HttpStatus.CREATED)
    public DailyLook addDailyLook(DailyLook dailyLook, MultipartFile orgFile) throws IOException {

        return dailyLookService.addDailyLook( orgFile, dailyLook); // 저장 결과를 반환
    }

    @GetMapping("/dailyLook/{id}")//localhost:3000/api/dailyLook/
    public DailyLook getDailyLook(@PathVariable Long id){

        return dailyLookService.dailyLookView(id);  //데일리룩 서비스에서 고유 아이디를 통해 하나의 데일리룩(상세페이지)을 불러옴
    }

    @GetMapping("/dailyLook/list")
    public List<DailyLook> getAllDailyLook(Model model){

        model.addAttribute("list", dailyLookService.dailyLookList()); //전체 데일리룩 불러오기

        return dailyLookService.dailyLookList();
    }

    @DeleteMapping("/dailyLook/remove/{id}")
    public void deleteDailyLook(@PathVariable Long id){
        dailyLookService.deleteByDailyLookId(id); //데일리룩 서비스의 아이디를 지정하여 해당 데일리룩을 삭제하는 메소드
    }

    @GetMapping("/dailyLook/searchresult")
    public List<DailyLookDto> DailyLookDtoList(@RequestParam(value="keyword") String keyword, Model model) {
        model.addAttribute("keyword", keyword);
        return dailyLookService.searchPosts(keyword);
    }

    @PutMapping("dailyLook/edit/{id}")
    public DailyLook editDailyLook(@PathVariable Long id, DailyLook dailyLook, MultipartFile orgFile) throws IOException{
        return dailyLookService.editDailyLook(id, dailyLook, orgFile);
    }

    @GetMapping(value = "/image/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte [] getItemImage(@PathVariable Long id, HttpServletRequest request) throws IOException{
        String imagePath = dailyLookService.getByIdItemImgPath(id);
        InputStream imageStream = new FileInputStream(imagePath);
        byte[] imageByteArray = IOUtils.toByteArray(imageStream);
        imageStream.close();

        return imageByteArray;
    }


    @PutMapping("dailyLook/put/{id}")
    public DailyLook editDailyLook(@PathVariable Long id, @RequestBody DailyLook dailyLook){
        return dailyLookService.editDailyLook(dailyLook);
    }

}
