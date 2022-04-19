package com.fitback.personal.bookmark.service;

import com.fitback.personal.bookmark.model.Bookmark;
import com.fitback.personal.bookmark.repository.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookmarkServiceImpl implements BookmarkService{

    private final BookmarkRepository bookmarkRepository;

    @Override
    public Bookmark addBookmark(Bookmark bookmark) {
        return bookmarkRepository.save(bookmark);
    }

    @Override
    public List<Bookmark> getAllBookmark() {
        return bookmarkRepository.findAll();
    }

    @Override
    public void deleteByBookmarkId(Long id) {
        bookmarkRepository.deleteById(id);

    }
}
