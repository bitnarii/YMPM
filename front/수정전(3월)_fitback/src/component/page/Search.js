import React from 'react';
import HotPost from '../ui/searchUi/HotPost';
import NewPost from '../ui/searchUi/NewPost';
import SearchBar from '../ui/searchUi/SearchBar';

function Search () {
    return ( 
        <div id="base" class="">
          
            <SearchBar/>
            <NewPost/>
            <HotPost/>

         </div>
    );
}

export default Search ;