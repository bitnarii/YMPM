import React from 'react';

function SearchBar() {
    return ( 
        <>
            {/* Unnamed (Text Field) */}
            <div id="u55" className="ax_default text_field">
                <div id="u55_div" className=""></div>
                <input id="u55_input" type="text" value="" className="u55_input"/>
            </div>

            {/* Unnamed (Shape) */}
            <div id="u56" className="ax_default primary_button">
                <img id="u56_img" className="img " src="images/search/u56.svg"/>
                <div id="u56_text" className="text ">
                <p><span>검색</span></p>
                </div>
            </div>

            {/* Unnamed (Image) */}
            <div id="u57" className="ax_default image">
                <img id="u57_img" className="img " src="images/search/u57.svg"/>
                <div id="u57_text" className="text " >
                <p></p>
                </div>
            </div>

        </>
     );
}

export default SearchBar;