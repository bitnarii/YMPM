import React from "react";

function ChooseCloset() {
    function deleteItem() {
        console.log("delete item");
    }
    function editItem() {
        console.log("edit item");
    }

    return (
        <>
            {/* 옷장 위 이름 (회사용) */}
            <div id="u825" className="ax_default primary_button">
                <div id="u825_div" className=""></div>
                <div id="u825_text" className="text ">
                    <p>
                        <span>회사용</span>
                    </p>
                </div>
            </div>

            {/* 열린 옷장 이미지 */}
            <div id="u778" className="ax_default image">
                <img
                    id="u778_img"
                    className="img "
                    src="images/closet/u778.svg"
                    alt=""
                />
                <div id="u778_text" className="text ">
                    <p></p>
                </div>
            </div>

            {/* 옷장 위 이름 (데일리용) */}
            <div id="u779" className="ax_default primary_button">
                <div id="u779_div" className=""></div>
                <div id="u779_text" className="text ">
                    <p>
                        <span>데일리용</span>
                    </p>
                </div>
            </div>

            {/* 닫힌 옷장 이미지 - 데일리용 */}
            <div id="u780" className="ax_default image">
                <img
                    id="u780_img"
                    className="img "
                    src="images/closet/u780.svg"
                    alt=""
                />
                <div id="u780_text" className="text ">
                    <p></p>
                </div>
            </div>

            {/* 옷장 위 이름 (겨울용) */}
            <div id="u838" className="ax_default primary_button">
                <div id="u838_div" className=""></div>
                <div id="u838_text" className="text ">
                    <p>
                        <span>겨울용</span>
                    </p>
                </div>
            </div>

            {/* 닫힌 옷장 이미지 - 겨울용 */}
            <div id="u839" className="ax_default image">
                <img
                    id="u839_img"
                    className="img "
                    src="images/closet/u839.svg"
                    alt=""
                />
                <div id="u839_text" className="text ">
                    <p></p>
                </div>
            </div>

            {/* 왼쪽 화살표 */}
            <div id="u824" className="ax_default paragraph">
                <div id="u824_div" className=""></div>
                <div id="u824_text" className="text ">
                    <p>
                        <span>&lt;</span>
                    </p>
                </div>
            </div>

            {/* 오른쪽 화살표 */}
            <div id="u826" className="ax_default paragraph">
                <div id="u826_div" className=""></div>
                <div id="u826_text" className="text ">
                    <p>
                        <span>&gt;</span>
                    </p>
                </div>
            </div>

            {/* Heading 2 */}
            <div id="u837" className="ax_default paragraph">
                <div id="u837_div" className=""></div>
                <div id="u837_text" className="text ">
                    <p>
                        <span>회사용 옷장의 아이템 목록</span>
                    </p>
                </div>
            </div>

            {/* button - 옷장 아이템 삭제 */}
            <div id="u845" className="ax_default primary_button">
                <div
                    id="u845_div"
                    className=""
                    onClick={() => deleteItem()}
                ></div>
                <div id="u845_text" className="text ">
                    <p>
                        <span>아 &nbsp;이 &nbsp;템</span>
                    </p>
                    <p>
                        <span>옷장에서</span>
                    </p>
                    <p>
                        <span>빼&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;기</span>
                    </p>
                </div>
            </div>

            {/* button - 옷장 아이템 수정 */}
            <div
                id="u844"
                className="ax_default primary_button"
                onClick={() => editItem()}
            >
                <div id="u844_div" className=""></div>
                <div id="u844_text" className="text ">
                    <p>
                        <span>아&nbsp; 이&nbsp; 템</span>
                    </p>
                    <p>
                        <span>수정하기</span>
                    </p>
                </div>
            </div>

            {/* <!-- Unnamed (Text Area) --> */}
            <div id="u119" class="ax_default text_area">
                <div id="u119_div" class=""></div>
                <textarea id="u119_input" class="u119_input"></textarea>
            </div>
        </>
    );
}

export default ChooseCloset;
