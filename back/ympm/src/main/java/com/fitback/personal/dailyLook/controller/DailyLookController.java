package com.fitback.personal.dailyLook.controller;

import com.fitback.personal.closet.model.Closet;
import com.fitback.personal.common.MessageVO;
import com.fitback.personal.dailyLook.dto.DailyLookDto;
import com.fitback.personal.dailyLook.model.DailyLook;
import com.fitback.personal.dailyLook.service.DailyLookServiceImpl;
import com.fitback.personal.post.dto.PostDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping
@Slf4j
public class DailyLookController {

    private final DailyLookServiceImpl dailyLookService;

    @PostMapping("/dailyLook/add")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageVO addDailyLook(DailyLook dailyLook, MultipartFile orgFile) throws Exception{
        MessageVO result = new MessageVO();
        System.out.println("DAILY_LOOK:" + dailyLook.toString());
        System.out.println("MULTI_PART:" + orgFile.getOriginalFilename());

        int resultCode = -1;        // DailyLook 등록 결과값을 저장하는 변수

        resultCode = dailyLookService.addDailyLook(dailyLook, orgFile); // 실제 데일리룩 데이터를 저장하는 서비스 호출
        result.put("resultCode", resultCode);                // 결과 메세지 설정
        if(resultCode > -1) {                               // 저장 결과값이 성공이면
            result.put("resultMessage", "저장 성공");       // 저장 성공 메세지
            result.put("searchUrl", "/dailyLook/list"); // 링크 주소 설정
            result.put("dailyLook", dailyLook);
        }else {                                          // 저장 결과값이 실패이면
            result.put("resultMessage","저장 실패"); // 실패 메세지 설정
        }
        return result; // 저장 결과를 반환
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



    @PutMapping("/dailyLook/edit/{id}")
    public MessageVO editDailyLook(@PathVariable Long id, DailyLook dailyLook, MultipartFile orgFile) throws Exception{
        MessageVO result = new MessageVO();
        int resultCode = -1;

        resultCode = dailyLookService.addDailyLook(dailyLook, orgFile);

        result.put("resultCode", resultCode);
        if (resultCode > -1){
            result.put("resultMessage", "수정 완료");
            result.put("dailyLook", dailyLook);
        } else {
            result.put("resultMessage", "수정 실패");
        }
        return result;

    }

    @GetMapping("/dailyLook/searchresult")
    public List<DailyLookDto> DailyLookDtoList(@RequestParam(value="keyword") String keyword, Model model) {
        model.addAttribute("keyword", keyword);
        return dailyLookService.searchPosts(keyword);
    }

    @PutMapping("dailyLook/put/{id}")
    public DailyLook editDailyLook(@PathVariable Long id, @RequestBody DailyLook dailyLook){
        return dailyLookService.editDailyLook(dailyLook);
    }



}
