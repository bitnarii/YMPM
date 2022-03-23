import React from "react";
import AllItems from "../ui/ClosetUi/AllItems";
import ChooseCloset from "../ui/ClosetUi/ChooseCloset"
import ClosetTable from "../ui/ClosetUi/ClosetTable";

const Closet = () => {
    return (
        <>
            <div id="base" className="closet">

                {/* 페이지 이름 */}
                <div id="u868" className="ax_default heading_1">
                    <div id="u868_div" className=""></div>
                    <div id="u868_text" className="text ">
                        <p>
                            <span>옷장 아이템 리스트</span>
                        </p>
                    </div>
                </div>

                {/* 상위 페이지 */}
                <div className="top">
                    {/* 옷장 선택 페이지 */}
                    <ChooseCloset />
                    {/* 선택된 옷장의 아이템 테이블 */}
                    <ClosetTable />
                </div>

                {/* 중위 페이지 */}
                <div className="middle">
                    {/* 현재 보유 아이템 */}
                    <AllItems />
                </div>
            </div>
        </>
    );
};

export default Closet;
