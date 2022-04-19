package com.fitback.personal.bookmark.model;

import com.fitback.personal.dailyLook.model.DailyLook;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Bookmark {

    @Id
    private Long id;
    private Long dailyLookId;

//
//    @ManyToOne
//    @JoinColumn(name = "DailyLook_Id")
//    private DailyLook dailyLook;





}
