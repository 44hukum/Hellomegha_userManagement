<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link rel="stylesheet" type="text/css" href="./Resources/style.css">
</head>
<style>
.wrapper {
  padding: 3rem 1.5rem;
  max-width: 800px;
  margin: 0 auto;
}

.st0 {
  fill: #D7DDE5;
}

.st1, .knob_data {
  fill: #2EAB6F;
  color: #2EAB6F;
}

.graph {
  width: 80%;
  display: table;
  margin: 0 auto 0;
  position: relative;
  text-align: center;
  height: 12.5rem;
}

.graph_media {
  max-height: 12rem;
}

.graph_data, .knob_data {
  font-size: 4rem;
}

.graph_data {
  display: table-cell;
  vertical-align: middle;
}



.stats {
  width: 100%;
  margin-bottom: -2px;
  height: 5.75rem;
  display: table;
}

.stats_row > .stats_item {
  border-left: 0px solid #D7DDE5;
  padding: .75rem 1.5rem;
  overflow: hidden;
  display: table-cell;
  vertical-align: middle;
  height: 100%;
}

.stats_row > .stats_item:first-child {
  border-left: 0;
}

.stats_row:after {
  content: ' ';
  display: table;
  clear: both;
}

.stats_item_number {
  white-space: nowrap;
  font-size: 2.25rem;
  line-height: 2.5rem;
}
.stats_item_number:before {
  display: none;
}

.txt_success {
  color: #2EAB6F;
}

.txt_warn {
  color: #DDC728;
}

.txt_smaller {
  font-size: .75em;
}

.flipY {
  -webkit-transform: scaleY(-1);
          transform: scaleY(-1);
  border-bottom-color: #fff;
}

.txt_faded {
  opacity: .65;
 
}

#myProgress {
  width: 100%;
  background-color: #ddd;
}
#myBar {
  width: 10%;
  height: 30px;
  background-color: #4CAF50;
  text-align: center; /* To center it horizontally (if you want) */
  line-height: 30px; /* To center it vertically */
  color: white;
}

</style>
<body>
<section class="wrapper">
  <div class="row card_row">
    <h1 class="column h6 color_label">User</h1>
    <div class="column half_whole">
      <article class="card box_panel">
        <label class="card_label">
         Growth
        </label>
        <section class="card_body">
          <div class="graph">
            <div class="knob_data">85<span class="txt_smaller">%</span></div>
            <svg class="graph_media" version="1.1" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 266.4 266.4">
              <g>
                <path class="st0" d="M130.5,32.2V0c-53.3,1.1-99,33.5-119.3,79.6l30,11.8C56.7,57.3,90.7,33.3,130.5,32.2z"/>
                
                
                <path class="st1" d="M133.2,0c-0.9,0-1.8,0-2.7,0v32.2c0.9,0,1.8,0,2.7,0c55.8,0,101,45.2,101,101s-45.2,101-101,101
                  s-101-45.2-101-101c0-14.9,3.2-29,9-41.7l-30-11.8C4,96,0,114.1,0,133.2c0,73.6,59.6,133.2,133.2,133.2s133.2-59.6,133.2-133.2
                  S206.7,0,133.2,0z"/>
              </g>
            </svg> 
            <!-- user growth-->
            <div id="myProgress" onclick="move()">
  				<div id="myBar">10%</div>
			</div><!--  --> 
			
			<!-- user engagment-->
          </div>
        </section>
        
        <section class="stats stats_row">
            <div class="stats_item half_whole small_whole">
              <div class="txt_faded">
                <label class="txt_label space_n_b">
                  Goal
                </label>
                <div class="txt_serif stats_item_number txt_success">
                  85<span class="txt_smaller">%</span>
                </div>
              </div>
            </div>
            <div class="stats_item half_whole">
              <div class="txt_faded"  style="float: right;">
                <label class="txt_label space_n_b">
                 Status
                </label>
                <div class="txt_serif stats_item_number txt_error">
                  80<span class="txt_smaller">.2%</span>
                </div>
              </div>
            </div>
        </section>
      </article>
    </div>
   
  </div>
</section>



<script type="text/javascript">
var i = 0;
function move() {
  if (i == 0) {
    i = 1;
    var elem = document.getElementById("myBar");
    var width = 10;
    var id = setInterval(frame, 10);
    function frame() {
      if (width >= 100) {
        clearInterval(id);
        i = 0;
      } else {
        width++;
        elem.style.width = width + "%";
        elem.innerHTML = width + "%";
      }
    }
  }
} 
</script>


</body>
</html>