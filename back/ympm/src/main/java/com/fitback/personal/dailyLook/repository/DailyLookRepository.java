package com.fitback.personal.dailyLook.repository;

import com.fitback.personal.dailyLook.model.DailyLook;
import com.fitback.personal.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DailyLookRepository extends JpaRepository<DailyLook, Long> {
    List<DailyLook> findByDailyLookNameContaining(String keyword);


}
