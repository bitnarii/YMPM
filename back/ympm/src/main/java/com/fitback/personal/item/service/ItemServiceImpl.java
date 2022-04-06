package com.fitback.personal.item.service;

import com.fitback.personal.item.model.Item;
import com.fitback.personal.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService{
    @Autowired
    private final ItemRepository itemRepository;

    @Override
    @Transactional //begin, commit 자동 수행, 예외 발생 시 rollback 처리
    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    @Transactional
    public Item editByIdItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    @Transactional
    public List<Item> getAllItem() {
        return itemRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Item> getByIdItem(Long id) {
        //ItemInCloset 클래스에서 매핑할 때 Optional 기능이 필요해 (null problem) Optional 사용
        return itemRepository.findById(id);
    }

    @Override
    @Transactional
    public void deleteByIdItem(Long id) {
        itemRepository.deleteById(id);
    }
}
