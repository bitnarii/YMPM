import axios from "axios";
import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import Body from "../ui/dailyLookUi/Body";
import ClothInfo from "../ui/dailyLookUi/ClothInfo";
import ItemGraph from "../ui/dailyLookUi/ItemGraph";
import NewOpinion from "../ui/opinionUi/NewOpinion";
import Opinion from "../ui/opinionUi/Opinion";
import Record from "../ui/dailyLookUi/Record";
import Pagination from "rc-pagination";
import Photo from "../ui/dailyLookUi/Photo";

function DailyLook() {
    const { id } = useParams();

    const [index, setIndex] = useState("0");

    const [refreash, setRefreash] = useState(false);

    const [opinionList, setOpinionList] = useState({ opinions: [] });

    const [pageSize, setPageSize] = useState(1);
    const [totalCount, setTotalCount] = useState(0);
    const [currentPage, setCurrentPage] = useState(1);

    const findAllDailyLook = `http://localhost:8080/dailyLook/${id}`;

    // const opinionUrl = `http://localhost:8080/dailyLook?start_index=${id}=${pageSize * (currentPage - 1)}&page_size=${pageSize}`;

    const opinionUrl = `http://localhost:8080/opinion/list`;

    const [list, setList] = useState([{}]);

    useEffect(() => {
        axios.get(findAllDailyLook).then((response) => {
            setList(response.data);
        });
    }, []);

    useEffect(() => {
        axios.get(opinionUrl).then((response) => {
            setOpinionList(response.data);
        });
    }, [refreash]);

    const onSelect = (event) => {
        setIndex(event.target.value);
    };

    return (
        <>
            <div id="base" className="">
                <div id="u606" className="ax_default heading_1">
                    <div id="u606_div" className=""></div>
                    <div id="u606_text" className="text ">
                        <p>
                            <span>Dailylook</span>
                        </p>
                    </div>
                </div>

                <div id="u610" className="ax_default box_3">
                    <div id="u610_div" className=""></div>
                    <div id="u610_text" className="text ">
                        <p>
                            <span>데일리룩 제목</span>
                        </p>
                    </div>
                </div>

                <div id="u604" className="ax_default text_field">
                    <div id="u604_div" className=""></div>
                    <input
                        id="u604_input"
                        type="readOnly"
                        placeholder={list.dailyLookName}
                    />
                </div>

                <div id="u611" className="ax_default box_3">
                    <div id="u611_div" className=""></div>
                    <div id="u611_text" className="text ">
                        <p>
                            <span>카테고리</span>
                        </p>
                    </div>
                </div>

                <div id="u605" className="ax_default droplist">
                    <div id="u605_div" className=""></div>
                    <select id="u605_input" className="u605_input">
                        <option
                            className="u605_input_option"
                            selected="selected"
                        >
                            스타일 선택
                        </option>
                        <option className="u605_input_option" value="1">
                            걸리시
                        </option>
                        <option className="u605_input_option" value="2">
                            댄디
                        </option>
                        <option className="u605_input_option" value="3">
                            베이직
                        </option>
                        <option className="u605_input_option" value="4">
                            보이쉬
                        </option>
                        <option className="u605_input_option" value="5">
                            비즈니스 캐주얼
                        </option>
                        <option className="u605_input_option" value="6">
                            스트리트
                        </option>
                        <option className="u605_input_option" value="7">
                            아메카지
                        </option>
                        <option className="u605_input_option" value="8">
                            캐주얼
                        </option>
                        <option className="u605_input_option" value="9">
                            펑크
                        </option>
                        <option className="u605_input_option" value="10">
                            페미닌
                        </option>
                    </select>
                </div>

                <div
                    id="u601"
                    className="ax_default"
                    data-left="1"
                    data-top="131"
                    data-width="400"
                    data-height="708"
                >
                    {/* 인체그리드 */}
                    <Body />
                    {/* 사진 */}
                    <Photo />
                </div>

                {/* 숫자버튼 */}
                <div
                    id="u631"
                    className="ax_default"
                    data-label="Pagination"
                    data-left="171"
                    data-top="799"
                    data-width="61"
                    data-height="27"
                >
                    <div
                        id="u632"
                        className="ax_default box_3 selected"
                        selectiongroup="My Pagination Group"
                    >
                        <div id="u632_div" className="selected"></div>
                        <div id="u632_text" className="text ">
                            <p>
                                <span>1</span>
                            </p>
                        </div>
                    </div>

                    <div
                        id="u633"
                        className="ax_default box_3"
                        selectiongroup="My Pagination Group"
                    >
                        <div id="u633_div" className=""></div>
                        <div id="u633_text" className="text ">
                            <p>
                                <span>2</span>
                            </p>
                        </div>
                    </div>
                </div>

                {/* 데일리 레코드 */}
                <Record />

                {/* 인포메이션 */}
                <ClothInfo />

                <div id="u668" className="ax_default box_3">
                    <div id="u668_div" className=""></div>
                    <div id="u668_text" className="text ">
                        <p>
                            <span>삭제하기</span>
                        </p>
                    </div>
                </div>

                <div id="u669" className="ax_default box_3">
                    <div id="u669_div" className=""></div>
                    <div id="u669_text" className="text ">
                        <p>
                            <span>수정 완료</span>
                        </p>
                    </div>
                </div>

                {/* 의견 */}
                <div style={{ marginLeft: "1101px", marginTop: "132px" }}>
                    <select value={index} onChange={onSelect}>
                        <option value="0">댓글 쓰기</option>
                        <option value="1">댓글 보기</option>
                    </select>
                    {index === "0" ? (
                        <NewOpinion
                            listId={list.id}
                            setRefreash={setRefreash}
                        />
                    ) : null}
                    {index === "1" ? (
                        <Opinion opinionList={opinionList} />
                    ) : null}
                    {index === "1" ? (
                        <Pagination
                            total={totalCount}
                            current={currentPage}
                            pageSize={pageSize}
                            onChange={(page) => setCurrentPage(page)}
                        />
                    ) : null}

                    {/* <Pagination 
        total={totalCount} 
        current={currentPage} 
        pageSize={pageSize} 
        onChange={(page) => setCurrentPage(page)}
        /> */}
                </div>

                {/* 옷장 속 아이템 컴포넌트 */}
                <ItemGraph />
            </div>
        </>
    );
}

export default DailyLook;
