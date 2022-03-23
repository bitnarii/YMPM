import react from "react";
import OpinionCheck from "../../ui/OpinionUi/OpinionCheck";
import OpinionItem from "../../ui/OpinionUi/OpnionItem";

function Opinion() {
    return ( 

        <div id="base" className="">
        <div id="u457" className="ax_default" data-left="371" data-top="22" data-width="400" data-height="504">
          <div id="u458" className="ax_default" data-left="371" data-top="22" data-width="400" data-height="504">
          <div id="u459" className="ax_default">
              <iframe title="title" id="u459_input" scrolling="auto" frameborder="1" webkitallowfullscreen mozallowfullscreen allowfullscreen></iframe>
            </div>
           <div id="u460" className="ax_default" data-left="412" data-top="317" data-width="306" data-height="176">
            <OpinionCheck />
            <OpinionItem />
            </div>
        </div>
      </div>
      </div>
        
     );
}

export default Opinion;