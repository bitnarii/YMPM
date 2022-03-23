import React from "react";
import Bookmark from "../../ui/homeUi/Bookmark";
import Calender from "../../ui/homeUi/Calender";
import CommentIwrote from "../../ui/homeUi/CommentIwrote";
import CommentOnMe from "../../ui/homeUi/CommentOnMe";
import ThumbCloset from "../../ui/homeUi/ThumbCloset";
import ThumbLook from "../../ui/homeUi/ThumbLook";


function Home() {
    return ( 
      <div id="base" className="">

      <div id="u43" className="ax_default heading_1">
        <div id="u43_div" className=""></div>
        <div id="u43_text" className="text ">
          <p><span>My Dailylook Home</span></p>
        </div>
      </div>

     {/* 내가 쓴 댓글 모음 */}
     <CommentIwrote />

     {/* 내게 달린 댓글 모음 */}
     <CommentOnMe />

     {/* 북마크 */}
     <Bookmark />

      {/* 달력 */}
      <Calender />

      {/* 대표 룩 */}
      <ThumbLook />

      {/* 대표 옷장*/}
      <ThumbCloset />
 
      
    </div>
  );
}

export default Home;