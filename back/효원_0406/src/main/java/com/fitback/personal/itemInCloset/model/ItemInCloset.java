package com.fitback.personal.itemInCloset.model;

import com.fitback.personal.closet.model.Closet;
import com.fitback.personal.item.model.Item;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class ItemInCloset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id 자동생성
    private Long id;

    @ManyToOne //다대일 형식
    private Closet closet;

    @ManyToOne
    private Item item;

    @Builder
    public ItemInCloset(Closet closet, Item item) {
        //dto 클래스와 연결 위해 Builder 필요
        this.closet = closet;
        this.item = item;
    }
}
