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
    private String style;
    //private String orgFile;
    private String filePath;
    private String fileName;
    private String info;
    private String description;

    @OrderBy("desc") //댓글 작성 시, 최근 순으로 볼 수 있도록
    @JsonIgnoreProperties({"dailyLook"}) //무한 참조 방지
    @OneToMany(mappedBy = "dailyLook", fetch = FetchType.EAGER)
    private List<Opinion> opinions;

    @CreationTimestamp
    private Timestamp createDate;

    @Builder
    public DailyLookDto(Long id, String dailyLookName, String style, String filePath, String fileName, String info, String description, List<Opinion> opinions, Timestamp createDate) {
        this.id = id;
        this.dailyLookName = dailyLookName;
        this.style = style;
        this.filePath = filePath;
        this.fileName = fileName;
        this.info = info;
        this.description = description;
        this.opinions = opinions;
        this.createDate = createDate;
    }
}
