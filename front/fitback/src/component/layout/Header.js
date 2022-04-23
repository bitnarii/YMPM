import React from "react";
import { Link } from "react-router-dom";

function Header() {
    return ( 
      <>
      <div id="base" class="">
          <div id="u213" class="ax_default box_2">
            <div id="u213_div" class=""></div>
            <div id="u213_text" class="text " >
              <p></p>
            </div>
          </div>


          <div id="u214" class="ax_default line">
            <img id="u214_img" class="img " src="images/header/u214.svg" alt=""/>
            <div id="u214_text" class="text " >
              <p></p>
            </div>
          </div>


          <div id="u215" class="ax_default heading_1">
            <div id="u215_div" class=""></div>
            <div id="u215_text" class="text ">
              <p><span>Fit-Back</span></p>
            </div>
          </div>


          <div id="u216" class="ax_default line">
            <img id="u216_img" class="img " src="images/header/u216.svg" alt=""/>
            <div id="u216_text" class="text " >
              <p></p>
            </div>
          </div>


          <div id="u217" class="ax_default heading_1">
            <div id="u217_div" class=""></div>
            <div id="u217_text" class="text ">
              <Link to='/'><p><span>My Dailylook</span></p></Link>
            </div>
          </div>


          <div id="u218" class="ax_default heading_1">
            <div id="u218_div" class=""></div>
            <div id="u218_text" class="text ">
            <Link to='/search'><p><span>Look Around</span></p></Link>
            </div>
          </div>


          <div id="u219" class="ax_default line">
            <img id="u219_img" class="img " src="images/header/u214.svg" alt=""/>
            <div id="u219_text" class="text " >
              <p></p>
            </div>
          </div>


          {/* <div id="u220" class="ax_default label">
            <div id="u220_div" class=""></div>
            <div id="u220_text" class="text ">
              <p><span>내 정보 설정</span></p>
            </div>
          </div>


          <div id="u221" class="ax_default label">
            <div id="u221_div" class=""></div>
            <div id="u221_text" class="text ">
              <p><span>로그아웃</span></p>
            </div>
          </div> */}

          <div id="u222" class="ax_default line">
            {/* <img id="u222_img" class="img " src="images/header/u222.svg" alt=""/> */}
            <div id="u222_text" class="text " >
              <p></p>
            </div>
        </div>
      </div> 
      </> 
    );
}

export default Header;