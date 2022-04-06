package com.fitback.personal.itemInCloset.model;

import lombok.Data;

@Data
public class IItemInCloset {
    //입력 받을 때 아이템과 옷장은 id로 받기 때문에 형식 다른 클래스 생성해 줌
    private Long id;
    private Long item_id; //itemId, closetId와 같은 형식으로 아이디 생성 시
    private Long closet_id; //id not null 오류가 떠서 이름 생성 SQL 형식으로 생성
    //TODO: SQL 형식이 아닌 자유 형식으로 id 생성 방법 연구
}
