import React from "react";
import BookMark from "../../ui/homeUi/BookMark";
import CommentsOnMe from "../../ui/homeUi/CommentsOnMe";
import DateGrid from "../../ui/homeUi/DateGrid";
import MyComments from "../../ui/homeUi/MyComments";
import ThumbCloset from "../../ui/homeUi/ThumbCloset";
import ThumbLook from "../../ui/homeUi/ThumbLook";

function Home() {
    return ( 
  <div id="base" className="">
    <div id="u229" className="ax_default heading_1">
        <div id="u229_div" className=""></div>
        <div id="u229_text" className="text ">
    <p><span>My Dailylook Home</span></p>
  </div>
  </div>

{/* 달력 */}
<DateGrid />

{/* 대표옷장 */}
<ThumbCloset />

{/* 대표 룩 */}
<ThumbLook />

{/* 북마크 */}
<BookMark />

{/* 내게 달린 댓글 모음 */}
<CommentsOnMe />

{/* 내가 쓴 댓글 모음 */}
<MyComments />

</div>
);
}

export default Home;