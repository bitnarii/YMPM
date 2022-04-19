import "./App.css";
import AddDailylook from "./component/page/AddDailylook";
import BookmarkList from "./component/page/BookmarkList";
import Closet from "./component/page/Closet";
import ClosetList from "./component/page/ClosetList";
import Dailylook from "./component/page/Dailylook";
import EditDailylook from "./component/page/EditDailylook";
import Home from "./component/page/Home";
import Login from "./component/page/Login";
import Opinion from "./component/page/Opinion";
import Register from "./component/page/Register";
import Search from "./component/page/Search";
import SearchResult from "./component/page/SearchResult";
import UserEdit from "./component/page/UserEdit";
import { BrowserRouter, Routes, Route } from "react-router-dom";

function App() {
    return (
        <BrowserRouter>
            <Routes>
                {/* 효원 (옷장, 옷장 불러오기) */}
                <Route path="/closet" element={<Closet />} />
                <Route path="/closetList" element={<ClosetList />} />
                {/* 곽다은 (데일리룩, 댓글) */}
                <Route path="/" element={<Home />} />
                <Route path="/addDailylook" element={<AddDailylook />} />
                <Route path="/editDailylook" element={<EditDailylook />} />
                <Route path="/dailylook" element={<Dailylook />} />
                <Route path="/op" element={<Opinion />} />
                {/* 권빛나리 (회원관리, 북마크, 검색) */}
                <Route path="/login" element={<Login />} />
                <Route path="/bookmarklist" element={<BookmarkList />} />
                <Route path="/register" element={<Register />} />
                <Route path="/search" element={<Search />} />
                <Route path="/searchresult" element={<SearchResult />} />
                <Route path="/useredit" element={<UserEdit />} />
            </Routes>
        </BrowserRouter>
    );
}

export default App;
