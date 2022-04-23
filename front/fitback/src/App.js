import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Footer from "./component/layout/Footer";
import BookmarkList from "./component/page/BookmarkList";
import Login from "./component/page/Login";
import Register from "./component/page/Register";
import SearchResult from "./component/page/SearchResult";
import UserEdit from "./component/page/UserEdit";
import "bootstrap/dist/css/bootstrap.min.css";
import HotPost from "./component/ui/searchUi/HotPost";
import Home from "./component/page/Home";
import DailyLook from "./component/page/DailyLook";
import AllItems from "./component/page/AllItems";
import Header from "./component/layout/Header";

function App() {
    return (
        // <div
        //     id="wrapper"
        //     style={{
        //         display: "flex",
        //         flexDirection: "column",
        //         minHeight: "100vh",
        //     }}
        // >
        //     <BrowserRouter>
        //         <main>
        //             <Routes>
        //                 <Route path="/" element={<Home />} />
        //                 <Route path="/dailyLook" element={<DailyLook />} />
        //                 <Route path="/login" element={<Login />} />
        //                 <Route
        //                     path="/bookmarklist"
        //                     element={<BookmarkList />}
        //                 />
        //                 <Route path="/register" element={<Register />} />
        //                 <Route path="/search" element={<HotPost />} />
        //                 <Route
        //                     path="/searchresult"
        //                     element={<SearchResult />}
        //                 />
        //                 <Route path="/useredit" element={<UserEdit />} />
        //                 <Route path="/allitems" element={<AllItems />} />

        //             </Routes>
        //         </main>

        //         <footer style={{ marginTop: "auto" }}>
        //             <Footer />
        //         </footer>
        //     </BrowserRouter>
        // </div>
        <BrowserRouter>
        <div id="wrapper">
        <header>
            <Header />
        </header>
        </div>
        <div id="wrapper2">
        <main>
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/dailyLook/:id" element={<DailyLook />} />
                {/* <Route path="/newDailyLook" element={<NewDailyLook />} /> */}
                <Route path="/search" element={<HotPost />} />
                        <Route
                            path="/searchresult"
                            element={<SearchResult />}
                        />             
            </Routes>
        </main>
        </div>
        <div 
            id="wrapper3"
            style={{
                display: "flex",
                flexDirection: "column",
                minHeight: "100vh",
                marginLeft: "50vh"
            }}>
        <footer style={{ marginTop: "auto" }}>
                    <Footer />
        </footer>
        </div>        
        </BrowserRouter>
    );
}

export default App;
