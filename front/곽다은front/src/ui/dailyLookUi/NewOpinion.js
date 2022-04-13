import axios from "axios";
import React, { useRef, useState } from "react";

function NewOpinion() {

  const [isChecked, setIsChecked] = useState(false); //체크여부
  const [imageSrc, setImageSrc] = useState('');

  const check1 = useRef();
  const check2 = useRef();
  const check3 = useRef();
  const check4 = useRef();
  const check5 = useRef();
  const content = useRef();
  const fileName = useRef();

  // const handleChange = (e) => {
  //   console.log("TESTDDDDD",e);
  //   this.setState({isChecked: !this.state.isChecked});
  //   }

  const addOpinion = () => {
    axios.post(`http://localhost:8080/opinion/add`,{
      // content: content.current.value,
      // check1: check1.current.checked,
      // check2: check2.current.checked,
      // check3: check3.current.checked,
      // check4: check4.current.checked,
      // check5: check5.current.checked,
      // fileName: fileName.current.value
    });
  }

  const handleChange = () => {

    setIsChecked(!isChecked);
    if(isChecked === true){
      console.log("선택된 체크박스");
    }
    else{
      console.log("취소");
    }
  }

  // 파일 미리보기
  const encodeFile = (fileBlob) => {
    const reader = new FileReader();
    reader.readAsDataURL(fileBlob);
    return new Promise((resolve) => {
      reader.onload = () => {
        setImageSrc(reader.result);
        resolve();
      };
    });
  };


  return ( 
    <div>
    <div id="u627" className="ax_default box_3">
      <div id="u627_div" className=""></div>
      <div id="u627_text" className="text ">
        <p><span>Opinion</span>&nbsp;점수:</p>
      </div> 
    </div>
 

    
    <div id="u598" className="ax_default box_1">
      <div id="u598_div" className=""></div>
      <div id="u598_text" className="text " >
        <p></p>
      </div>
    </div>
    
    <form onSubmit={addOpinion}>

    <div id="u670" className="ax_default box_3">
      <div id="u670_div" className=""></div>
       <div id="u670_text" className="text ">
        <p ><span>의견 쓰기</span></p>
        <button type="submit" style={{display: 'none'}}></button>
      </div>
    </div>

    <div id="u671" className="ax_default text_field">
      <div id="u671_div" className=""></div>
      <input id="u671_input" name="check1" type="text" value="1. 핏이 딱 맞나요?" className="u671_input"/>
    </div>
    
    <div id="u676" className="ax_default checkbox">
      <label id="u676_input_label" for="u676_input" >
        <img id="u676_img" className="img " src="images/dailylook/u676.svg" alt=""/>
        <div id="u676_text" className="text " >
          <p></p>
        </div>
      </label>
      {/*체크박스1 */}
       <input id="u676_input" ref={check1} name="checkbox" type="checkbox" value="20" checked={isChecked} onChange={handleChange} /> 
    </div>
    
    <div id="u672" className="ax_default text_field">
      <div id="u672_div" className=""></div>
      <input id="u672_input"  type="text" value="2. 아이템의 컬러매치가 적절한가요?" className="u672_input"/>
    </div>
    
    <div id="u677" className="ax_default checkbox">
      <label id="u677_input_label" for="u677_input" >
        <img id="u677_img" className="img " src="images/dailylook/u677.svg" alt=""/>
        <div id="u677_text" className="text " >
          <p></p>
        </div>
      </label>
      {/*체크박스2 */}
      <input id="u677_input" ref={check2} name="checkbox" type="checkbox" value="20" checked={isChecked} onChange={handleChange}/> 
    </div>
    
    <div id="u673" className="ax_default text_field">
      <div id="u673_div" className=""></div>
      <input id="u673_input" type="text" value="3. 악세사리를 잘 활용했나요?" className="u673_input"/>
    </div>
    
    <div id="u678" className="ax_default checkbox">
      <label id="u678_input_label" for="u678_input" >
        <img id="u678_img" className="img " src="images/dailylook/u678.svg" alt=""/>
        <div id="u678_text" className="text " >
          <p></p>
        </div>
      </label>
      {/*체크박스3 */}
      <input id="u678_input" ref={check3} name="checkbox" type="checkbox" value="20" checked={isChecked} onChange={handleChange}/>
    </div>
    
    <div id="u674" className="ax_default text_field">
      <div id="u674_div" className=""></div>
      <input id="u674_input" type="text" value="4. 계절에 적절한 옷인가요?" className="u674_input"/>
    </div>
    
    <div id="u679" className="ax_default checkbox">
      <label id="u679_input_label" for="u679_input" >
        <img id="u679_img" className="img " src="images/dailylook/u679.svg" alt=""/>
        <div id="u679_text" className="text " >
          <p></p>
        </div>
      </label>
      {/*체크박스4 */}
      <input id="u679_input" ref={check4} name="checkbox" type="checkbox" value="20" checked={isChecked} onChange={handleChange}/>
    </div>
    
    <div id="u675" className="ax_default text_field">
      <div id="u675_div" className=""></div>
      <input id="u675_input" type="text" value="5. TPO에 알맞나요?" className="u675_input"/>
    </div>
    
    <div id="u680" className="ax_default checkbox">
      <label id="u680_input_label" for="u680_input" >
        <img id="u680_img" className="img " src="images/dailylook/u680.svg" alt=""/>
        <div id="u680_text" className="text " >
          <p></p>
        </div>
      </label>
      {/*체크박스5 */}
      <input id="u680_input" ref={check5} name="checkbox" type="checkbox" value="20" checked={isChecked} onChange={handleChange}/> 
    </div>
    
    <div id="u681" className="ax_default box_3">
      <div id="u681_div" className=""></div>
      <div id="u681_text" className="text ">
        <p><span>Free Opinion</span></p>
      </div>
    </div>
    
    
    <div id="u682" className="ax_default text_field">
      <div id="u682_div" className=""></div>
      <input id="u682_input" type="text" className="u682_input"/>
    </div>
    
    <div id="u683" className="ax_default box_3">
      <div id="u683_div" className=""></div>
      <div id="u683_text" className="text ">
        <p><span>Recommanded Item</span></p> 
        <input type="file" accept="image/*" onChange={(e) => {encodeFile(e.target.files[0]);}}/>
      </div>
    </div>
    
    <div id="u684" className="img__box" >
      { imageSrc && <img id="u684_img" src={imageSrc} alt="" />}
      <div id="u684_text" className="text " >
        <p></p>
      </div>
      {/* {imageSrc && <img src={imageSrc} alt=""/>} */}
    </div>
    
    
    <div id="u685" className="ax_default heading_3">
      <div id="u685_div" className=""></div>
      <div id="u685_text" className="text ">
        <p><span>브랜드명</span></p>
      </div>
    </div>
    
    
    <div id="u686" className="ax_default text_field">
      <div id="u686_div" className=""></div>
      <input id="u686_input" type="text" className="u686_input"/>
    </div>
    
    
    <div id="u687" className="ax_default heading_3">
      <div id="u687_div" className=""></div>
      <div id="u687_text" className="text ">
        <p><span>상품명</span></p>
      </div>
    </div>
    
    
    <div id="u688" className="ax_default text_field">
      <div id="u688_div" className=""></div>
      <input id="u688_input" type="text"  className="u688_input"/> 
    </div>  
    </form>
    </div>
   );
}

export default NewOpinion;