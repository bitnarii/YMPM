package com.fitback.personal.closet.repository;

import com.fitback.personal.closet.model.Closet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClosetRepository extends JpaRepository<Closet, Long> {
}
