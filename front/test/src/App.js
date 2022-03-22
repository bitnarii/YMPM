import React from 'react';
import {BrowserRouter, Routes, Route} from 'react-router-dom';
import Footer from './components/layout/Footer';
import BookmarkList from './components/page/BookmarkList';
import Login from './components/page/Login';
import Register from './components/page/Register';
import Search from './components/page/Search';
import SearchResult from './components/page/SearchResult';
import UserEdit from './components/page/UserEdit';


function App() {
  return (
    <BrowserRouter>

    <Routes>  
      <Route path="/" element={<Login/>} /> 
      <Route path="/bookmarklist" element={<BookmarkList/>} /> 
      <Route path="/register" element={<Register/>} /> 
      <Route path="/search" element={<Search/>} /> 
      <Route path="/searchresult" element={<SearchResult/>} /> 
      <Route path="/useredit" element={<UserEdit/>} /> 
   
    </Routes> 





    <Footer/>


  </BrowserRouter>

  );
}

export default App;
