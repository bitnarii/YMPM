package com.fitback.personal.dailyLook.repository;

import com.fitback.personal.dailyLook.model.DailyLook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyLookRepository extends JpaRepository<DailyLook, Long> {

}
