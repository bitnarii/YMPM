import React, {useEffect, useState} from 'react';
import HotPostDep from './HotPostDep';
import axios from 'axios';
import Container from 'react-bootstrap/Container'
import Row from 'react-bootstrap/Row'
import Col from 'react-bootstrap/Col'
import Pagination from '../Pagination';
import { Link } from 'react-router-dom';
import _ from 'lodash'


function HotPost() {

    const [hotpostList, sethotpostList] = useState([]);
    const [check, setCheck] = useState(false)  
    const [page, setPage] = useState(1);
    const limit = 5;
    const offset = (page - 1) * limit;

    const [keyword, setKeyword] = useState('')
    const debounce = _.debounce((e) => {
        setKeyword(e.target.value);
    	console.log("", e.target.value);
    }, 300);	
    

    useEffect(() =>{
        axios.get('http://localhost:8080/dailyLook/list')
        .then(Response =>{
            sethotpostList(Response.data)
            console.log(Response.data)        
        })
    }, [check])


    return ( 
        <>
          {/* 검색어 입력 INPUT */}
          <div id="u868" class="ax_default text_field">
                <div id="u868_div" class=""></div>
                <input onChange={debounce} id="u868_input" type="text"  class="u868_input" name="keyword"/>
            </div>

            {/* 검색버튼 */}
            <div id="u869" class="ax_default primary_button " >
                <p><button style={{backgroundColor : "white", padding : "3px 0px 1px 0px", borderColor : "white" }} >
                <Link to='/searchresult' state={{ keyword: keyword}} style={{color : "black", textDecoration : "none" , padding : "0 20px"}}> 검색</Link></button></p>
            </div>

            {/* TXT */}
            <div id="u911" class="ax_default heading_2">
                <div id="u911_div" class=""></div>
                <div id="u911_text" class="text ">
                    <p style={{fontSize:"13px"}}><span style={{fontSize:"20px"}}>최신글 </span></p> 
                </div>
            </div>

            {/* 게시글 둘러보기 */}
            <Container id="wrapper" style={{ marginTop : "200px", display: "flex", flexDirection: "row"}}>
                <Row>               
                    {
                        hotpostList.slice(offset, offset + limit).map(hotpost => (
                        <Col style={{padding : "0px", margin : "-15px"}}>
                            <HotPostDep
                                key = {hotpost.id}
                                hotpost = {hotpost}
                                setCheck = {setCheck}
                            /> 
                        </Col>
                        ))
                    }       
                </Row>
            </Container>

            <Pagination
                total={hotpostList.length}
                limit={limit}
                page={page}
                setPage={setPage} />
        </>
    );
}

export default HotPost;