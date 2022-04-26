import React from "react";
import { Link } from "react-router-dom";

function Header() {
    return ( 


<div style = {{display : "flex", justifyContent : "left" , backgroundColor : "black", width : "100vw"}}>
<nav class="navbar navbar-expand-sm navbar-light bg-black">
<<<<<<< Updated upstream
  <a class="navbar-brand" style={{color : "white", fontSize : "20pt"}} href="http://localhost:3000/">　FitBack　　</a>
=======
<Link to='/'><a class="navbar-brand" style={{color : "white", fontSize : "20pt"}} href="#">　FitBack　　</a></Link>
>>>>>>> Stashed changes

  <div class="collapse navbar-collapse" id="navbarText">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
<<<<<<< Updated upstream
        <a class="nav-link" href="http://localhost:3000/dailylook" style={{color : "white"}}>My DailyLook <span class="sr-only"></span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="http://localhost:3000/search"style={{color : "white"}}>Look Around</a>
=======
        <Link to='/'><a class="nav-link" href="#" style={{color : "white"}}>My DailyLook <span class="sr-only"></span></a></Link>
      </li>
      <li class="nav-item">
      <Link to='/search'><a class="nav-link" href="#"style={{color : "white"}}>Look Around</a></Link>
>>>>>>> Stashed changes
      </li>

    </ul>
    <span class="navbar-text">
    
    </span>
  </div>
</nav>
</div>


     
    );
}

export default Header;