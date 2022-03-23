import "./App.css";
import BookmarkList from "./component/page/BookmarkList";
import Closet from "./component/page/Closet";
import ClosetList from "./component/page/ClosetList";
import Login from "./component/page/Login";
import Register from "./component/page/Register";
import Search from "./component/page/Search";
import SearchResult from "./component/page/SearchResult";
import UserEdit from "./component/page/UserEdit";

function App() {
    return (
        <BrowserRouter>
            <Routes>
                {/* 효원 (옷장, 옷장 불러오기) */}
                <Route path="/closet" element={<Closet />} />
                <Route path="/closetList" element={<ClosetList />} />
                {/* 곽다은 (데일리룩, 댓글) */}
                <Route path='/' element={<Home />}/>
                <Route path='/addDailylook' element={<AddDailylook />} />
                <Route path='/editDailylook' element={<EditDailylook />} />
                <Route path='/dailylook' element={<Dailylook />} />
                <Route path='/op' element={<Opinion />} />
                {/* 권빛나리 (회원관리, 북마크, 검색) */}
                <Route path="/login" element={<Login/>} /> 
                <Route path="/bookmarklist" element={<BookmarkList/>} /> 
                <Route path="/register" element={<Register/>} /> 
                <Route path="/search" element={<Search/>} /> 
                <Route path="/searchresult" element={<SearchResult/>} /> 
                <Route path="/useredit" element={<UserEdit/>} /> 

            </Routes>
        </BrowserRouter>
    );
}

export default App;
