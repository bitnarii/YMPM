package com.fitback.personal.opinion.model;

import com.fitback.personal.dailyLook.model.DailyLook;
import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
public class Opinion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false, length = 120)
    String content;

    private int check1;
    private int check2;
    private int check3;
    private int check4;
    private int check5;

    private String filePath;
    private String fileName;

    @ManyToOne
    @JoinColumn(name = "look_id")
    private DailyLook dailyLook;

    @CreationTimestamp
    private Timestamp createDate;
}
