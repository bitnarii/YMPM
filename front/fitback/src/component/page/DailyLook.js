import React from "react";
import { Button, Card, Col, Row, Container, FormControl, InputGroup, Table, Badge, ListGroup } from "react-bootstrap";

function DailyLook() {
    return ( 
    <>
    <Container style={{margin: "auto", width: "100%", display: "flex"}}>    
    <Row>
    <Col>
          
    <Card style={{ width: '20rem', marginTop: "200px", position: "absolute"}}>
        <Card.Img style={{height: "615px"}} variant="top" src="" />
        <Card.Body>
        <Button variant="primary" style={{marginLeft: "175px", backgroundColor: "black", border: "black", color: "white"}}>사진 업로드</Button>
        </Card.Body>
    </Card>
    </Col>

    <Col>
    
    <InputGroup style={{width: "400px", marginLeft: "370px", marginTop: "200px", position: "absolute"}}>
        <FormControl value="데일리룩 제목" style={{border: "transparent"}}/>
        <FormControl style={{borderLeft: "transparent", borderRight: "transparent"}}/>
    </InputGroup>
    <InputGroup style={{width: "400px", marginLeft: "370px", marginTop: "240px", position: "absolute"}}>
        <FormControl value="   카테고리" style={{border: "transparent", borderRight: "transparent"}}/>
        <select name="style" style={{width: "200px"}}>
              <option className="u605_input_option" selected='selected'>스타일 선택</option>
              <option className="u605_input_option" value="1">걸리시</option>
              <option className="u605_input_option" value="2">댄디</option>
              <option className="u605_input_option" value="3">베이직</option>
              <option className="u605_input_option" value="4">보이쉬</option>
              <option className="u605_input_option" value="5">비즈니스 캐주얼</option>
              <option className="u605_input_option" value="6">스트리트</option>
              <option className="u605_input_option" value="7">아메카지</option>
              <option className="u605_input_option" value="8">캐주얼</option>
              <option className="u605_input_option" value="9">펑크</option>
              <option className="u605_input_option" value="10">페미닌</option>
            </select>
    </InputGroup>
    
    <h3 style={{position: "absolute", zIndex: "10"}}>
  <Badge style={{ lineHeight:"25px", marginLeft: "460px", marginTop: "293px", width:"230px", height:"40px"}} bg="black">Information</Badge>
    </h3>
    
    <Table id="table1" style={{textAlign: "center", marginTop: "335px", marginLeft: "330px", width:"65%"}} striped bordered hover>
  
  
  <thead>
    <tr >
      <th>분류</th>
      <th>상품명</th>
      <th>브랜드명</th>
    </tr>
  </thead>
  <tbody id="table1" >
    <tr>
      <td>상의</td>
      <td><input  type="text" style={{border: "black"}}/></td>
      <td><input  type="text" style={{border: "black"}}/></td> 
    </tr>

    <tr>
    <td>하의</td>
      <td><input  type="text" style={{border: "black"}}/></td>
      <td><input  type="text" style={{border: "black"}}/></td>
    </tr>

    <tr>
    <td>원피스</td>
      <td><input  type="text" style={{border: "black"}}/></td>
      <td><input  type="text" style={{border: "black"}}/></td>
    </tr>

    <tr>
    <td>아우터</td>
      <td><input  type="text" style={{border: "black"}}/></td>
      <td><input  type="text" style={{border: "black"}}/></td>
    </tr>

    <tr>
    <td>신발</td>
      <td><input  type="text" style={{border: "black"}}/></td>
      <td><input  type="text" style={{border: "black"}}/></td>
    </tr>

    <tr>
    <td>패션잡화</td>
      <td><input  type="text" style={{border: "black"}}/></td>
      <td><input  type="text" style={{border: "black"}}/></td>
    </tr>

  </tbody>
</Table>

<h3 style={{position: "absolute", zIndex: "10"}}>
  <Badge style={{ marginLeft: "490px", marginTop: "0px"}} bg="black">Daily Record</Badge>
</h3>

  <InputGroup style={{position:"absolute", marginTop: "35px", marginLeft: "328px", width: "500px", height: "200px", zIndex: "1"}}>
    <FormControl as="textarea" aria-label="With textarea" />
  </InputGroup>

        <div style={{float: "left"}}>
            <Button style={{backgroundColor: "black", border: "black", color: "white", marginLeft: "525px", marginTop: "236px"}}>수정하기</Button>        
            <Button style={{backgroundColor: "black", border: "black", color: "white", marginLeft: "525px", marginTop: "1px"}}>삭제하기</Button>        
        </div>

    </Col>
    
        <h3 style={{position: "absolute", zIndex: "10"}}>
  <Badge style={{ marginLeft: "945px", marginTop: "180px"}} bg="black">Opinion</Badge>
    </h3>
    </Row>

    <Row>
      <Card style={{height: "685px", width: "20rem", marginLeft: "90px", marginTop: "200px"}}>
     <Button  style={{width: "100px", position: "absolute", marginTop: "30px", height: "30px", lineHeight:"11px", backgroundColor: "black", border: "black", color: "white"}}>댓글 쓰기</Button>
    <InputGroup style={{marginTop: "70px"}}>
    <FormControl aria-label="Text input with checkbox" />
    <InputGroup.Checkbox />
    </InputGroup>
     
    <InputGroup style={{marginTop: "5px"}}>
    <FormControl aria-label="Text input with checkbox" />
    <InputGroup.Checkbox />
    </InputGroup>

    <InputGroup style={{marginTop: "4px"}}>
    <FormControl aria-label="Text input with checkbox" />
    <InputGroup.Checkbox />
    </InputGroup>

    <InputGroup style={{marginTop: "5px"}}>
    <FormControl aria-label="Text input with checkbox" />
    <InputGroup.Checkbox />
    </InputGroup>

    <InputGroup style={{marginTop: "5px"}}>
    <FormControl aria-label="Text input with checkbox" />
    <InputGroup.Checkbox />
    </InputGroup>

    <Badge style={{marginTop: "20px", height: "35px", fontSize: "large"}} bg="black">Free Opinion</Badge>
    <FormControl style={{width: "295px", marginTop: "7px", height: "55px", borderLeft: "transparent", borderRight: "transparent"}}/>
      
    <Badge style={{marginTop: "20px", height: "35px", fontSize: "large"}} bg="black">Recommended Item</Badge>
      
      <Row>
    <img style={{width: "150px", marginTop: "45px", marginLeft: "0px"}} src="https://t4.ftcdn.net/jpg/04/70/29/97/360_F_470299797_UD0eoVMMSUbHCcNJCdv2t8B2g1GVqYgs.jpg" alt=""/>


<ListGroup style={{width: "165px", marginTop:"30px"}}>
  <ListGroup.Item style={{border: "transparent"}}>브랜드명</ListGroup.Item>
 <input type="text" style={{borderLeft: "transparent", borderRight: "transparent", borderColor: "#dbdbdb"}}/> 
  <ListGroup.Item style={{border: "transparent"}}>상품명</ListGroup.Item>
  <input type="text" style={{borderLeft: "transparent", borderRight: "transparent", borderColor: "#dbdbdb"}}/> 
</ListGroup>
        </Row>
      </Card> 
    </Row>
   </Container>
    </> 
    );
}

export default DailyLook;