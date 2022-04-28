import React from "react";
import { springbootPath } from '../../SpringbootPath';

function OpinionPhoto({opinions}) {
    return ( 
        <>
        <ul>
            {opinions.map(opinion => (
                <li key={opinion.id}>
<img style={{width: "130px", marginTop: "45px", marginLeft: "0px"}} src={`${springbootPath}/opinion/image/${opinion.id}`} alt=""/>
                </li>
            ))}
        </ul>
        </>
     );
}

export default OpinionPhoto;