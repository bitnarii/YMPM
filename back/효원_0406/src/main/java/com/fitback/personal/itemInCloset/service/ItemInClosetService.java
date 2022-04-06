package com.fitback.personal.itemInCloset.service;

import com.fitback.personal.itemInCloset.model.ItemInCloset;

import java.util.List;
import java.util.Optional;

public interface ItemInClosetService {
    ItemInCloset addItemInCloset(ItemInCloset mapping);
    List<ItemInCloset> getAllItemInCloset();
    Optional<ItemInCloset> getByIdItemInCloset(Long id);
    void deleteByIdItemInCloset(Long id);
}
