package com.fitback.personal.closet.controller;

import com.fitback.personal.closet.model.Closet;
import com.fitback.personal.closet.service.ClosetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/closet")
@RequiredArgsConstructor
public class ClosetController {

    @Autowired
    private final ClosetService closetService;

    @PostMapping("/add")
    public Closet addCloset(@RequestBody Closet closet){
        return closetService.addCloset(closet);
    }

    @PutMapping("/edit/{id}")
    public Closet editByIdCloset(@PathVariable Long id, @RequestBody Closet closet){
        return closetService.editByIdCloset(closet);
    }

    @GetMapping("/getAll")
    public List<Closet> getAllCloset(){
        return closetService.getAllCloset();
    }

    @GetMapping("/get/{id}")
    public Optional<Closet> getByIdCloset(@PathVariable Long id){
        return closetService.getByIdCloset(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteByIdCloset(@PathVariable Long id){
        closetService.deleteByIdCloset(id);
    }
}
