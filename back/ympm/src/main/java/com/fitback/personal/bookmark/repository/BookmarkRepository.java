package com.fitback.personal.bookmark.repository;

import com.fitback.personal.bookmark.model.Bookmark;
import org.apache.el.parser.JJTELParserState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
}
