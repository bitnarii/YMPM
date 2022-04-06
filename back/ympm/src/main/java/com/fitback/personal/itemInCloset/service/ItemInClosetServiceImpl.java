package com.fitback.personal.itemInCloset.service;

import com.fitback.personal.itemInCloset.model.ItemInCloset;
import com.fitback.personal.itemInCloset.repository.ItemInClosetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemInClosetServiceImpl implements ItemInClosetService {

    @Autowired
    private final ItemInClosetRepository itemInClosetRepository;

    @Override
    @Transactional
    public ItemInCloset addItemInCloset(ItemInCloset mapping) {
        return itemInClosetRepository.save(mapping);
    }

    @Override
    @Transactional
    public List<ItemInCloset> getAllItemInCloset() {
        return itemInClosetRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<ItemInCloset> getByIdItemInCloset(Long id) {
        return itemInClosetRepository.findById(id);
    }

    @Override
    @Transactional
    public void deleteByIdItemInCloset(Long id) {
        itemInClosetRepository.deleteById(id);
    }
}
