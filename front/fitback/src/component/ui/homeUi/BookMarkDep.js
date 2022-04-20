import React, { useEffect,useState } from 'react';
import axios from 'axios';
import Row from 'react-bootstrap/Row'
import Col from 'react-bootstrap/Col'
import Container from 'react-bootstrap/Container'


function BookMarkDep({book, check, setCheck}) {

    const [bookList, setBookList] = useState([])

    useEffect(()=> {
        axios.get(`http://localhost:8080/dailyLook/${book.dailyLookId}`)
        .then(Response =>{
            setBookList(Response.data)

        })        
    },[book.dailyLookId])


    return ( 
    <Container style={{position : "relative"}}>
        <Row>
            <Col style= {{margin : "0 0px 30px 20px"}}>
                <div id="u243" className="ax_default placeholder">
                <img id="u243_img" className="img " src = {`images/imgtest/${bookList.filePath}`}   alt=""/>
                    <div id="u243_text" className="text " >
                        <p>{bookList.dailyLookName}</p>
                    </div>
                </div>
            </Col>
        </Row>
    </Container>    
     );
}

export default BookMarkDep;