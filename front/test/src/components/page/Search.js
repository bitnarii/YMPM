import React from 'react';
import HotPost from '../ui/SearchUi/HotPost';
import NewPost from '../ui/SearchUi/NewPost';
import SearchBar from '../ui/SearchUi/SearchBar';

function Search() {
    return ( 
        <div id="base" className="">
            <SearchBar/>
            <NewPost/>  
            <HotPost/>
        </div>
     );
}

export default Search;