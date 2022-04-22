package com.fitback.personal.dailyLook.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fitback.personal.opinion.model.Opinion;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
public class DailyLookDto {
    private Long id;
    private String dailyLookName;
    private int style;
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

    private String description;
    private int bookmark;


    @OrderBy("desc") //댓글 작성 시, 최근 순으로 볼 수 있도록
    @JsonIgnoreProperties({"dailyLook"}) //무한 참조 방지
    @OneToMany(mappedBy = "dailyLook", fetch = FetchType.EAGER)
    private List<Opinion> opinions;

    @CreationTimestamp
    private Timestamp createDate;

    @Builder
    public DailyLookDto(Long id, String dailyLookName, int style, String filePath, String fileName, String topBrand,
            String topName,
             String bottomBrand,
             String bottomName,
             String dressBrand,
             String dressName,
             String outerBrand,
             String outerName,
             String shoesBrand,
             String shoesName,
             String etcBrand,
             String etcName, String description, int bookmark, List<Opinion> opinions, Timestamp createDate) {
        this.id = id;
        this.dailyLookName = dailyLookName;
        this.style = style;
        this.filePath = filePath;
        this.fileName = fileName;
        this.topBrand = topBrand;
        this.topName = topName;
        this.bottomBrand = bottomBrand;
        this.bottomName = bottomName;
        this.dressBrand = dressBrand;
        this.dressName = dressName;
        this.outerBrand = outerBrand;
        this.outerName = outerName;
        this.shoesBrand = shoesBrand;
        this.shoesName = shoesName;
        this.etcBrand = etcBrand;
        this.etcName = etcName;
        this.topBrand = topBrand;


        this.description = description;
        this.bookmark = bookmark;
        this.opinions = opinions;
        this.createDate = createDate;
    }
}
