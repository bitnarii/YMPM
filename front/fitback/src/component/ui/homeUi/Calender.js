import react from "react";

function Calender() {
    return ( 
      <div>
      <div id="u33" className="ax_default droplist">
        <div id="u33_div" className=""></div>
        <select id="u33_input" className="u33_input">
          <option className="u33_input_option" value="월별 보기">월별 보기</option>
          <option className="u33_input_option" value="연별 보기">연별 보기</option>
          <option className="u33_input_option" selected value="일별 보기">일별 보기</option>
        </select>
      </div>

      <div id="u44" className="ax_default box_2">
          <div id="u44_div" className=""></div>
          <div id="u44_text" className="text " >
            <p></p>
          </div>
      </div>
      </div>
     );
}

export default Calender;