package com.fitback.personal.item.repository;

import com.fitback.personal.item.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByItemCategory(String itemCategory); //아이템 카테고리를 통해 아이템을 찾을 수 있도록 함
}
