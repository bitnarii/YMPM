import BookMarkDep from "./BookMarkDep";
import Row from 'react-bootstrap/Row'
import Col from 'react-bootstrap/Col'
import Container from 'react-bootstrap/Container'
import React, {useEffect, useState} from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';


function BookMark() {

  const [check, setCheck] = useState(false)
  const [bookmarkList, setBookmarkList ] = useState([]);

  useEffect(()=> {
      axios.get('http://localhost:8080/bookmark/getall')
      .then(Response => {
          setBookmarkList(Response.data)
          console.log(Response.data)
      })        
  },[check])

    return (
    
    <>
        {/* 북마크 미리보기 */}
            <div style={{width : "300px", height : "100px"}}>
                <Container id="wrapper" style={{ display: "flex", flexDirection: "row"}}>
                        <Row >                            
                                {
                                    bookmarkList.slice(0, 2).map(book => (
                                        <Col style={{ width : "300px" , height : "115px"}}>
                                            <BookMarkDep
                                                key = {book.id}
                                                book = {book}
                                                check = {check}
                                                setCheck = {setCheck}
                                            /> 
                                        </Col>
                                    ))
                                }       
                        </Row>
                    </Container>
            
                <div>
                    {/* TXT */}
                    <div id="u236" className="ax_default box_2">
                        <div id="u236_div" className=""></div>
                        <div id="u236_text" className="text ">
                            <p><span>북마크</span></p>
                        </div>
                    </div>

                    <div id="u241" className="ax_default" data-left="52" data-top="768" data-width="298" data-height="224">
                    </div>
                    {/* 북마크페이지 바로가기 */}
                    <div id="u227" className="ax_default button">
                        <Link to = 'bookmarklist' ><img id="u227_img" className="img " src="images/home/u227.svg" alt=""/>
                        <div id="u227_text" className="text ">
                            <p style={{color : "white",textDecoration : "none" }}><span >자세히 보기</span></p>
                        </div></Link>
                    </div>
                </div>
            </div> 
    </>
    );
}

export default BookMark;