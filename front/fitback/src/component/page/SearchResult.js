import React from 'react';
import SearchResultPost from '../ui/searchResultUi/SearchResultPost';
import SearchBar from '../ui/searchUi/SearchBar';

function SearchResult() {
    return ( 
        <div id="base" class="">

          <SearchBar/>
          <SearchResultPost/>

        </div>
     );
}

export default SearchResult;