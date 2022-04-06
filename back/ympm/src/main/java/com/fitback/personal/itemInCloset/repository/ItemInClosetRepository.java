package com.fitback.personal.itemInCloset.repository;

import com.fitback.personal.itemInCloset.model.ItemInCloset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemInClosetRepository extends JpaRepository<ItemInCloset, Long> {
}
