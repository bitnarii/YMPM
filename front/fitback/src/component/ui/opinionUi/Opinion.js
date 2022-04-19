import axios from "axios";
import React, { useEffect, useState } from "react";
import ReactPaginate from "react-paginate";
import { useParams } from "react-router-dom";


function Opinion() {

  const { id } = useParams();

    const [isChecked, setIsChecked] = useState(); //체크여부

    const [opinionList, setOpinionList] = useState({opinions: []});

    const [page, setPage] = useState(1);

    const opinionUrl = `http://localhost:8080/opinion/list/${id}`;

    useEffect(() => {
        axios.get(opinionUrl)
        .then(response => {setOpinionList(response.data)})
      }, []);
    console.log(opinionList);

    

    // const indexOfLast = currentPage * postsPerPage;
    // const indexOfFirst = indexOfLast - postsPerPage;
    // const currentPosts = (tmp) => {
    //   let currentPosts = 0;
    //   currentPosts = tmp.slice(indexOfFirst, indexOfLast);
    //   return currentPosts;
    // }


    return ( 
    <div>
     
      {/* <ReactPaginate 
      pageCount={Math.ceil(opinionList.length)}
      pageRangeDisplayed={1}
      marginPagesDisplayed={0}
      breakLabel={""}
      previousLabel={"<"}
      nextLabel={">"}
      onPageChange={handlePageChange}
      /> */}
      
    <div id="u627" className="ax_default box_3">

      <div id="u627_div" className=""></div>
      <div id="u627_text" className="text ">
        <p><span>Opinion</span>&nbsp;점수:</p>
      </div>
    </div>
    
    {/* 화살표 버튼 */}
    
    <div id="u628" className="ax_default icon">
      <img id="u628_img" className="img " src="images/new_dailylook/u359.svg" alt=""/>
      <div id="u628_text" className="text " >
        {/* <p></p> */}
        
      </div>
      
    </div>
    
    {/* 댓글 갯수 */}
    <div id="u630" className="ax_default box_1">
      <img id="u630_img" className="img " src="images/new_dailylook/u361.svg" alt=""/>
      <div id="u630_text" className="text ">
        <p><span>1 / 2</span></p>
      </div>
      
    </div>
    
    <div id="u629" className="ax_default icon">
      <img id="u629_img" className="img " src="images/new_dailylook/u360.svg" alt=""/>
      <div id="u629_text" className="text " >
        <p></p>
      </div>
    </div>
    
    <div id="u598" className="ax_default box_1">
      <div id="u598_div" className=""></div>
      <div id="u598_text" className="text " >
        <p></p>
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
      {/* 체크박스1
      <input id="u676_input"  name="checkbox" type="checkbox" value="20" checked={isChecked} />  */}
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
      {/* 체크박스2
      <input id="u677_input"  name="checkbox" type="checkbox" value="20" checked={isChecked} />  */}
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
      {/* 체크박스3
      <input id="u678_input"  name="checkbox" type="checkbox" value="20" checked={isChecked} /> */}
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
      {/* 체크박스4
      <input id="u679_input"  name="checkbox" type="checkbox" value="20" checked={isChecked} /> */}
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
      {/* 체크박스5
      <input id="u680_input"  name="checkbox" type="checkbox" value="20" checked={isChecked}/>  */}
    </div>
    
    <div id="u681" className="ax_default box_3">
      <div id="u681_div" className=""></div>
      <div id="u681_text" className="text ">
        <p><span>Free Opinion</span></p>
      </div>
    </div>
  
    <div id="u682" className="ax_default text_field">
      <div id="u682_div" className=""></div>
      {/* <input id="u682_input" type="text" className="u682_input"/> */}

      {/* 체크박스 맵 */}
      <ul>
      {opinionList.opinions.map(opinions => (
        <li key={opinions.id}>
          <input id="u682_input" type="text" placeholder={opinions.content}/>
          <input id="u676_input"  name="check1" type="checkbox" checked={isChecked} />
          <input id="u677_input"  name="check2" type="checkbox" checked={isChecked} /> 
          <input id="u678_input"  name="check3" type="checkbox" checked={isChecked} /> 
          <input id="u679_input"  name="check4" type="checkbox" checked={isChecked} />
          <input id="u680_input"  name="check5" type="checkbox" checked={isChecked} />
        </li>
      ))}
      </ul>
    </div>
    
    <div id="u683" className="ax_default box_3">
      <div id="u683_div" className=""></div>
      <div id="u683_text" className="text ">
        <p><span>Recommanded Item</span></p> 
      </div>
    </div>
    
    <div id="u684" className="img__box" >
     <img id="u684_img"  alt="" />
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
    </div>
    );
}

export default Opinion;