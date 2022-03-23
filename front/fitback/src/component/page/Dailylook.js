import react from "react";
import DayBody from "../../ui/dailylookUi/DayBody";
import DayClothInfo from "../../ui/dailylookUi/DayClothInfo";
import DayItem from "../../ui/dailylookUi/DayItem";
import DayOpinion from "../../ui/dailylookUi/DayOpinion";

function Dailylook() {
    return ( 
    <div id="base" className="">
      
      <div id="u289" className="ax_default heading_1">
        <div id="u289_div" className=""></div>
        <div id="u289_text" className="text ">
          <p><span>Dailylook</span></p>
        </div>
      </div>

      <div id="u356" className="ax_default heading_1">
        <div id="u356_div" className=""></div>
        <div id="u356_text" className="text ">
          <p><span>점수:</span></p>
        </div>
      </div>

      
      <div id="u357" className="ax_default heading_1">
        <div id="u357_div" className=""></div>
        <div id="u357_text" className="text ">
          <p><span>점</span></p>
        </div>
      </div>

      <div id="u343" className="ax_default paragraph">
        <div id="u343_div" className=""></div>
        <div id="u343_text" className="text ">
          <p><span>데일리룩 제목</span></p>
        </div>
      </div>

      <div id="u342" className="ax_default text_field">
        <div id="u342_div" className=""></div>
        <input id="u342_input" type="text" value="" className="u342_input"/>
      </div>

        <div id="u344" className="ax_default droplist">
        <div id="u344_div" className=""></div>
        <select id="u344_input" className="u344_input">
          <option className="u344_input_option" value="걸리시">걸리시</option>
          <option className="u344_input_option" value="댄디">댄디</option>
          <option className="u344_input_option" selected value="베이직">베이직</option>
          <option className="u344_input_option" value="보이시">보이시</option>
          <option className="u344_input_option" value="비즈니스 캐주얼">비즈니스 캐주얼</option>
          <option className="u344_input_option" value="스트리트">스트리트</option>
          <option className="u344_input_option" value="아메카지">아메카지</option>
          <option className="u344_input_option" value="캐주얼">캐주얼</option>
          <option className="u344_input_option" value="펑크">펑크</option>
          <option className="u344_input_option" value="페미닌">페미닌</option>
        </select>
        </div>

        {/* 댓글 */}
        <DayOpinion />

        <DayBody />

        {/* 착장별 정보 */}{/* 데일리 감상평 */}
        <DayClothInfo />      

      <div id="u354" className="ax_default primary_button">
        <div id="u354_div" className=""></div>
        <div id="u354_text" className="text ">
          <p><span>수정하기</span></p>
        </div>
      </div>

      
      <div id="u355" className="ax_default box_3">
        <img id="u355_img" className="img " src="images/edit_dailylook/u211.svg" alt=""/>
        <div id="u355_text" className="text ">
          <p><span>삭제하기</span></p>
        </div>
      </div>      

      <div id="u401" className="ax_default heading_1">
        <div id="u401_div" className=""></div>
        <div id="u401_text" className="text ">
          <p><span>DailyLook's Items</span></p>
        </div>
      </div>


       <DayItem /> 

    </div> 
     );
}

export default Dailylook;