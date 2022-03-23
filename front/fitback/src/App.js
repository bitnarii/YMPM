import "./App.css";
import Closet from "./component/page/Closet";
import ClosetList from "./component/page/ClosetList";

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

            </Routes>
        </BrowserRouter>
    );
}

export default App;
