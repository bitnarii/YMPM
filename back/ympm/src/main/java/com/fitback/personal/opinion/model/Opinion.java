package com.fitback.personal.opinion.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @Transient
    private boolean[] checkedState;

    private int score;
    private String filePath;
    private String fileName;

    private String topBrand;
    private String topName;;
    private String bottomBrand;
    private String bottomName;
    private String dressBrand;
    private String dressName;
    private String outerBrand;
    private String outerName;
    private String shoesBrand;
    private String shoesName;
    private String etcBrand;
    private String etcName;

    @ManyToOne
    @JoinColumn(name = "look_id")
    private DailyLook dailyLook;

    @JsonFormat(pattern = "YYYY-MM-dd")
    @CreationTimestamp
    private Timestamp createDate;
}
