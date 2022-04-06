package com.fitback.personal.item.service;

import com.fitback.personal.item.model.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    Item addItem(Item item);
    Item editByIdItem(Item item);
    List<Item> getAllItem();
    Optional<Item> getByIdItem(Long id);
    void deleteByIdItem(Long id);
}
