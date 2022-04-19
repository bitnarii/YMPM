import React, {useEffect, useState} from 'react';
import { useLocation } from 'react-router-dom';
import axios from 'axios';
import Container from 'react-bootstrap/Container'
import Row from 'react-bootstrap/Row'
import Col from 'react-bootstrap/Col'
import SearchResultPostDep from '../ui/searchResultUi/SearchResultPostDep';
import _ from 'lodash'
import Pagination from '../ui/Pagination';


function Test() {

    const [searchList, setSearchList] = useState([]);
    const [check, setCheck] = useState(false);
    const [keyword2, setKeyword] = useState('')
    const [page, setPage] = useState(1);
    const location = useLocation();
    const limit = 5;
    const offset = (page - 1) * limit;
    const debounce = _.debounce((e) => {
        setKeyword(e.target.value);
        console.log("", e.target.value);
    }, 300);	

    useEffect(() =>{
        axios.get(`http://localhost:8080/dailyLook/searchresult?keyword=${location.state.keyword}`)
        .then(Response =>{
            setSearchList(Response.data)
            console.log(Response.data)
            })
    }, [check])

    const buttonClick = () =>{
        axios.get(`http://localhost:8080/dailyLook/searchresult?keyword=${keyword2}`)
        .then(Response =>{
            setSearchList(Response.data)
            console.log(Response.data)
        })
    }

    return ( 
        <>            
            {/* INPUT */}
            <div id="u868" class="ax_default text_field">
                <div id="u868_div" class=""></div>
                <input onChange={debounce} id="u868_input" type="text"  class="u868_input" name="keyword"  />
            </div>

            {/* BUTTON */}
            <div id="u869" class="ax_default primary_button " >
                <p><button  onClick = {buttonClick} style={{backgroundColor : "white", padding : "3px 20px 1px 20px", borderColor : "white" } } >검색</button></p>
            </div>

            {/* TXT */}
            <div id="u915" class="ax_default heading_2">
                <div id="u915_div" class=""></div>
                <div id="u915_text" class="text ">
                <p><span>검색결과</span></p>            
                </div>
            </div>

            <Container id="wrapper" style={{ display: "flex", flexDirection: "row"}}>
                <Row>                  
                {
                    searchList.slice(offset, offset + limit).map(searchResult => (
                    <Col style={{padding : "0px", margin : "-15px"}}>
                        <SearchResultPostDep
                            key = {searchResult.id}
                            searchResult = {searchResult}                      
                            check = {check}
                            setCheck = {setCheck}
                        /> 
                    </Col>
                    ))
                }       
                </Row>
            </Container>

            <Pagination
                total={searchList.length}
                limit={limit}
                page={page}
                setPage={setPage}
                />
        </>
    );
}

export default SearchResult;














