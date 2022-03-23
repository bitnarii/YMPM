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
            </Routes>
        </BrowserRouter>
    );
}

export default App;
