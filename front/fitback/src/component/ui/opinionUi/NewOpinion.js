import { Spin } from "antd";
import axios from "axios";
import React, { useRef, useState } from "react";

function NewOpinion({listId, setRefreash}) {

  console.log("게시글 아이디 " + listId);

  // const [isChecked, setIsChecked] = useState({name: ''}); 체크여부

  const [checkedState, setCheckedState] = useState(
    new Array(5).fill(false)
  );

  //비구조화 할당을 통한 값 추출
  // const {name} = isChecked;

  const [imageSrc, setImageSrc] = useState([]);

  const [loaded, setLoaded] = useState(false); //이미지 로드

  let inputRef;

  const realButton = useRef();
  const content = useRef();
  const opiFile = useRef();
  const uploadedFile = useRef();


 //체크박스 상태 확인
  const changeHandler = (position) => {
    const updateCheckedState = checkedState.map((item, index) =>
    index === position ? !item : item);
      setCheckedState(updateCheckedState);
  }


  //이미지 저장
  // const saveImage = (e) => {
  //   e.preventDefault();
  //   const fileReader = new FileReader();
    
  //   if(e.target.files){
  //     setLoaded("loading")
  //     fileReader.readAsDataURL(e.target.files[0])
  //   }
  //   fileReader.onload = () => {
  //     setImageSrc(
  //       {
  //         image_file: e.target.files[0],
  //         preview_URL: fileReader.result
  //       })
  //     setLoaded(true);
  //   }
  // }


  //댓글 작성 버튼(기존 버튼 숨김처리)
  const handleClick = () => {
    realButton.current.click();
  };

  //댓글 등록 요청
  // const addOpinion = (e) => {
  //   e.preventDefault();
  //   // setFileName(e.target.files);
  //   if(window.confirm("댓글을 등록할까요?") + imageSrc.uploadedFile){
  //     const formData = new FormData();
  //     formData.append('imageFile', imageSrc.uploadedFile);
  //     axios.post("http://localhost:8080/opinion/add", formData, {
  //       look_id: listId,
  //       content: content.current.value,
  //       checkedState: checkedState,
  //       fileName: imageSrc
  //     }).then((response) => console.log("댓글 등록 성공 "+ response))
  //     .catch((error) => console.log("댓글 등록 실패 "+ error));

  //     console.log(
  //       " 콘텐트 " + content.current.value,
  //       "\n 체크 " + checkedState,
  //       "\n 이미지 " + imageSrc,
  //       "\n 게시글 아이디 " + listId,
  //     );
  //   };
  // }


  const handleUpload = (e) => {
    e.preventDefault();
    const file = e.target.files[0];
    setImageSrc([...imageSrc, { uploadedFile: file }]);
  };

  //댓글 등록 요청
  const addOpinion = (e) => {
    e.preventDefault();
    const formData = new FormData();
    formData.append("opiFile", imageSrc[0].uploadedFile);
    formData.append("content", content.current.value);
    formData.append("checkedState", checkedState);
    formData.append("dailyLook.id", listId);
    axios({
      method: "post",
      url:"http://localhost:8080/opinion/add",
      data: formData,
      headers: { "Content-Type" : "multipart/form-data" }
    }).then((response) => console.log("댓글 등록 성공 "+ response))
      .catch((error) => console.log("댓글 등록 실패 "+ error));
      console.log(
        " 콘텐트 " + content.current.value,
        "\n 체크 " + checkedState,
        "\n 이미지 " + imageSrc[0].uploadedFile,
        "\n 게시글 아이디 " + listId,
       );
  };



  // 파일 미리보기(another)
  // const encodeFile = (fileBlob) => {
  //   const reader = new FileReader();
  //   reader.readAsDataURL(fileBlob);
  //   return new Promise((resolve) => {
  //     reader.onload = () => {
  //       setImageSrc(reader.result);
  //       resolve();
  //     };
  //   });
  // };


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
    
    {/* <form > */}
    <div id="u670" className="ax_default box_3" >
      <div id="u670_div" className=""></div> 
        <div id="u670_text" className="text "> 
         <p onClick={addOpinion}><span>의견 쓰기</span></p>
        <button ref={realButton} onSubmit={handleUpload} style={{display: 'none'}}></button>
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
       <input id="u676_input" index="1" name="check1" type="checkbox" onChange={() => changeHandler(0)} /> 
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
      <input id="u677_input"  index="2" name="check2" type="checkbox" onChange={() => changeHandler(1)} /> 
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
      <input id="u678_input"  index="3" name="check3" type="checkbox" onChange={() => changeHandler(2)} />
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
      <input id="u679_input"  index="4" name="check4" type="checkbox" onChange={() => changeHandler(3)} />
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
      <input id="u680_input"  index="5" name="check5" type="checkbox" onChange={() => changeHandler(4)} /> 
    </div>
    
    <div id="u681" className="ax_default box_3">
      <div id="u681_div" className=""></div>
      <div id="u681_text" className="text ">
        <p><span>Free Opinion</span></p>
      </div>
    </div>
    
    
    <div id="u682" className="ax_default text_field">
      <div id="u682_div" className=""></div>
      <input id="u682_input" type="text" className="u682_input" name="content" ref={content}/>
    </div>
    
    <div id="u683" className="ax_default box_3">
      <div id="u683_div" className=""></div>
      <div id="u683_text" className="text ">
        <p><span>Recommanded Item</span></p> 
       {/* 이미지 업로드 */}        
        <input type="file" name="opiFile" ref={opiFile} accept="image/*" onChange={handleUpload} />
      </div>
    </div>
    

    <div id="u684" className="img__box" >
      {/* 이미지 미리보기 */}


      <div id="u684_text" className="text " >
        <p></p>
      </div>
      {imageSrc && <img src={imageSrc} alt=""/>}
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
    {/* </form> */}
    </div>
   );
}

export default NewOpinion;