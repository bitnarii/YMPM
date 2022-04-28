import React, { useEffect,useState } from 'react';
import axios from 'axios';
import Row from 'react-bootstrap/Row'
import Col from 'react-bootstrap/Col'
import Container from 'react-bootstrap/Container'
import { springbootPath } from '../../SpringbootPath';

function BookMarkDep({book, check, setCheck}) {

    const [bookList, setBookList] = useState([])

    useEffect(()=> {
        axios.get(`${springbootPath}/dailyLook/${book.dailyLookId}`)
        .then(Response =>{
            setBookList(Response.data)

        })        
    },[book.dailyLookId])


    return ( 
    <Container style={{position : "relative"}}>
        <Row>
            <Col>
                <div >
                <img id="u243_img" className="img " src = {`${springbootPath}/image/${book.id}`}   alt=""/>
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