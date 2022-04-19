import React, { useEffect, useRef, useState } from "react";
import { Link } from 'react-router-dom';
import axios from "axios";


function Registration() {

    const postName = useRef("")
    
    


    const [data, setData] = useState({})

    const url = "http://localhost:8080/search/add"

    const handleData = (e) => {        
        setData(
            {...data,[e.target.name]:e.target.value},        
        )        
    }

    const handleSubmit = (e) => {
        e.preventDefault()
        if(window.confirm("등록하시겠습니까?")){
        axios.post(url,{
            postName: data.postName,


        },).then(window.alert("등록완료"))
    }
        else{
            window.alert("등록취소")
        }
    }


    return(

        <section className="login-area pt-100 pb-100">
            <div className="container">
                <div className="row">
                    <div className="col-lg-8 offset-lg-2">
                        <div><h5 style = {{ marginBottom : '10px' , color : "green", textAlign : "right"}}><Link to={'/list'}>고객리스트 보기 →</Link></h5></div>
                        <div className="basic-login">
                            <h3 className="text-center mb-60">고객등록서비스</h3>
                            <form action="#">
                                
                                <label for="userName">이름 <span>**</span></label>
                                <input onChange={handleData} ref={postName}  name="userName" type="text" placeholder="이름을 입력하세요" />
                                
                           


{/* 
                                <label for="gender">성별 <span>**</span></label>
                                <div className="sorting d-inline-block" >
                                    <select onChange={handleData} name="gender" name="sort" id="shop-sort" >
                                        <option value="default">성별을 선택하세요</option>
                                        <option value="default">여성(F)</option>
                                        <option value="default">남성(M)</option>
                                    </select><br></br><br></br>
                                </div> */}

                                
                                <button className="btn theme-btn-2 w-100" onClick={handleSubmit} > 등록</button>

                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
     
    );
}

export default Registration;