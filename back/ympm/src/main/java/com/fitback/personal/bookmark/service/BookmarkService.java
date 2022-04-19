package com.fitback.personal.bookmark.service;

import com.fitback.personal.bookmark.model.Bookmark;

import java.awt.print.Book;
import java.util.List;

public interface BookmarkService {
    Bookmark addBookmark(Bookmark bookmark);
    List<Bookmark> getAllBookmark();
    void deleteByBookmarkId(Long id);
}
