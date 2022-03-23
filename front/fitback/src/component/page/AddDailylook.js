import React from "react";
import AddBody from "../../ui/addDailylookUi/AddBody";
import Closet from "../../ui/addDailylookUi/Closet";
import ClothInfo from "../../ui/addDailylookUi/ClothInfo";
import ItemInsert from "../../ui/addDailylookUi/ItemInsert";
import Items from "../../ui/addDailylookUi/Items";



function AddDailylook() {
    return ( 
      <div id="base" className="">

      <div id="u79" className="ax_default heading_1">
        <div id="u79_div" className=""></div>
        <div id="u79_text" className="text ">
          <p><span>Make a new Dailylook</span></p>
        </div>
      </div>
     
      <div id="u70" className="ax_default paragraph">
        <div id="u70_div" className=""></div>
        <div id="u70_text" className="text ">
          <p><span>데일리룩 제목</span></p>
        </div>
      </div>

      <div id="u69" className="ax_default text_field">
        <div id="u69_div" className=""></div>
        <input id="u69_input" type="text" value="" className="u69_input"/>
      </div>

     
      <div id="u71" className="ax_default droplist">
        <div id="u71_div" className=""></div>
        <select id="u71_input" className="u71_input">
          <option className="u71_input_option" value="걸리시">걸리시</option>
          <option className="u71_input_option" value="댄디">댄디</option>
          <option className="u71_input_option" selected value="베이직">베이직</option>
          <option className="u71_input_option" value="보이시">보이시</option>
          <option className="u71_input_option" value="비즈니스 캐주얼">비즈니스 캐주얼</option>
          <option className="u71_input_option" value="스트리트">스트리트</option>
          <option className="u71_input_option" value="아메카지">아메카지</option>
          <option className="u71_input_option" value="캐주얼">캐주얼</option>
          <option className="u71_input_option" value="펑크">펑크</option>
          <option className="u71_input_option" value="페미닌">페미닌</option>
        </select>
      </div>

      {/* 데일리 사진 */} {/* 인체 그리드 */}
      <AddBody />
      
      {/* 아이템 등록 창 */}
      <ItemInsert />
      
      {/* 데일리 감상평 */}{/* 착장별 정보 */}
      <ClothInfo />
      
      <div id="u98" className="ax_default primary_button">
        <div id="u98_div" className=""></div>
        <div id="u98_text" className="text ">
          <p><span>데일리룩 등록하기</span></p>
        </div>
      </div>

      {/* 클로젯 아이템 */}
      <Items />

      {/* 옷장 컴포넌트 */}
      <Closet />
      

    </div>
     );
}

export default AddDailylook;