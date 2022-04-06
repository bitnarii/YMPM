package com.fitback.personal.item.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.File;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Item extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;
    private String itemCategory;
    private String itemBrand;
    private String itemMemo;
}
