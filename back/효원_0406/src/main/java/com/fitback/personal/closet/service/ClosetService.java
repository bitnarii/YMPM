package com.fitback.personal.closet.service;

import com.fitback.personal.closet.model.Closet;

import java.util.List;
import java.util.Optional;

public interface ClosetService{
    Closet addCloset(Closet closet);
    Closet editByIdCloset(Closet closet);
    List<Closet> getAllCloset();
    Optional<Closet> getByIdCloset(Long id);
    void deleteByIdCloset(Long id);
}
