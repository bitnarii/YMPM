package com.fitback.personal.closet.service;

import com.fitback.personal.closet.model.Closet;
import com.fitback.personal.closet.repository.ClosetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClosetServiceImpl implements ClosetService{
    @Autowired
    private final ClosetRepository closetRepository;

    @Override
    @Transactional
    public Closet addCloset(Closet closet) {
        return closetRepository.save(closet);
    }

    @Override
    @Transactional
    public Closet editByIdCloset(Closet closet) {
        return closetRepository.save(closet);
    }

    @Override
    @Transactional
    public List<Closet> getAllCloset() {
        return closetRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Closet> getByIdCloset(Long id) {
        return closetRepository.findById(id);
    }

    @Override
    @Transactional
    public void deleteByIdCloset(Long id) {
        closetRepository.deleteById(id);
    }
}
