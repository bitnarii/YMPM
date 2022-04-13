import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from "./component/pages/Home";
import DailyLook from "./component/pages/DailyLook";

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/dailyLook/:id" element={<DailyLook />} />

            </Routes>
        </BrowserRouter>
    );
}

export default App;
