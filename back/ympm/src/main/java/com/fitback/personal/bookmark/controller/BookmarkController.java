package com.fitback.personal.bookmark.controller;

import com.fitback.personal.bookmark.model.Bookmark;
import com.fitback.personal.bookmark.service.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/bookmark")
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkService bookmarkService;

    @PostMapping("/add")
    public Bookmark addBookmark (@RequestBody Bookmark bookmark) {
        return bookmarkService.addBookmark(bookmark);

    }

    @GetMapping("/getall")
    public List<Bookmark> getAllBookmark(){
        return bookmarkService.getAllBookmark();
    }

    @DeleteMapping("delete/{id}")
    public void deleteByBookmarkId(@PathVariable Long id){
        bookmarkService.deleteByBookmarkId(id);
    }


}
