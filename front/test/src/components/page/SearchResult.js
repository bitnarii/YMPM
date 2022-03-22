import React from 'react';
import SearchResultPost from '../ui/SearchResultUi/SearchResultPost';
import SearchBar from '../ui/SearchUi/SearchBar';

function SearchResult() {
    return (  
        <div id="base" className="">
          <SearchBar/>
          <SearchResultPost/>      
        </div>
    );
}

export default SearchResult;