package com.fitback.personal.item.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor //필드들이 final 로 생성되어 있는 경우에는 필드를 초기화 할 수 없기 때문에 생성자를 만들 수 없고 에러가 발생하는 상황을 방지하기 위해 생성자를 자동으로 생성해주는 어노테이션
@AllArgsConstructor //클래스에 존재하는 모든 필드에 대한 생성자를 자동으로 생성해주는 어노테이션
@EntityListeners(AuditingEntityListener.class) //해당 클래스에 Auditing 기능을 포함 (생성 및 수정시기 기록 시 필요한 어노테이션)
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName; //아이템명
    private String itemCategory; //아이템 카테고리
    private String itemBrand; //아이템 브랜드
    private String itemMemo; //아이템 추가 설명 및 메모

    private String itemImgPath; //아이템 이미지가 저장된 절대경로
    private String itemImgOrigin; //아이템 원본 이미지명
    private String itemImgName; //아이템 서비스 이미지명

    @CreatedDate //JPA 에서 사용 가능한 생성시기 저장 어노테이션
    @Column(nullable = false, updatable = false) //DB와 연관된 내용 (null 값이 될 수 없고, 값이 수정될 수 없다)
    private LocalDateTime createdDate;

    @LastModifiedDate //JPA 에서 사용 가능한 수정시기 저장 어노테이션
    @Column(nullable = false, updatable = true) //DB와 연관된 내용 (null 값이 될 수 없고, 값이 수정될 수 있다)
    private LocalDateTime editedDate;

}
