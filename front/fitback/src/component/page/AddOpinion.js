import React from "react";
import AddCheck from "../../ui/AddOpinionUi/AddCheck";
import AddItem from "../../ui/AddOpinionUi/AddItem";

function AddOpinion() {
    return ( 
        <div id="base" className="">

        {/* 아이템 창 */}
          <AddItem />
  
          {/* 체크 창 */}
          <AddCheck />
        </div>
  
     );
}

export default AddOpinion;