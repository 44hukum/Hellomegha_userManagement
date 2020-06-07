<%@page import="com.hellomegha.databasequeries.FindUser"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<link rel="stylesheet" type="text/css" href="./Resources/css/profilesecond.css">
<link rel="stylesheet" type="text/css" href="./Resources/style.css">


<section>
  <%
      int frequency=0;
      String username="";
      ResultSet result=null;      
      String description="I am a Worker here,";
  	String email="";
  	String phonenumber="";
  	String githublink="#";  	
  	String address="Nepal";
  	String firstname="";
  	String lastname="";
        String password="";
        int uid=0;
      if(request.getParameter("textVal") !=null){
            username=request.getParameter("textVal"); //if admin tries to edit user
            result=(new FindUser()).getUser(username);
            try {
            while(result.next()){
                email=result.getString("email");
                phonenumber=result.getString("phoneNumber");
                if(result.getString("githublink") !=null) githublink = result.getString("githublink");
                   if(result.getString("Address") !=null) address = result.getString("Address");
                   if(result.getString("firstName") !=null)  firstname = result.getString("firstName");  
                  if(result.getString("lastName") !=null)   lastname = result.getString("lastName");
                  if(result.getString("About") !=null)  description = result.getString("About");
                    session.setAttribute("changeU",result.getString("userID")); 
                    uid=result.getInt("userID");
                }
              } catch (SQLException e) {
		e.printStackTrace();
			}
      //for userHistory table
            %>
            
            <div class="userHistory">
                <h3>History</h3>
                <h4>User ID: <%=uid%></h4>
                <table>
                    <thead>
                        <tr>
                            <th>Activity</th>                                
                            <th>Time</th>
                            <th>Date</th>
                        </tr>
                    </thead> 
                    <tbody>
                       <% ResultSet uHistory=(new FindUser()).userHistory(uid);
                       while(uHistory.next()){
                       %>
                        <tr>
                            <td><%=uHistory.getString("Activity_log")%></td>
                            <td><%=uHistory.getTime("Time")%></td>
                            <td><%=uHistory.getDate("Date")%></td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
                
            </div>
    
              <% //end of user History
            
            }else{
                   username=(String)session.getAttribute("username");
            }
  	/*  for all the dynamically changing user details */
  	if(username!=null) {
            
            if(session.getAttribute("role").equals("admin")){
                result=(new FindUser()).getAdmin(username);
         
	try {
            while(result.next()){
                email=result.getString("email");
                phonenumber=result.getString("phoneNumber");
                if(result.getString("githublink") !=null) githublink = result.getString("githublink");
                   if(result.getString("Address") !=null) address = result.getString("Address");
                   if(result.getString("firstName") !=null)  firstname = result.getString("firstName");  
                  if(result.getString("lastName") !=null)   lastname = result.getString("lastName");
                  if(result.getString("About") !=null)  description = result.getString("About");
                  password=result.getString("password");
                }
                        
              } catch (SQLException e) {
		e.printStackTrace();
			}
            }
            else {
		result=(new FindUser()).getUser(username);
                 out.println(session.getAttribute("role"));
              
			try {
            while(result.next()){
                email=result.getString("email");
                phonenumber=result.getString("phoneNumber");
                if(result.getString("githublink") !=null) githublink = result.getString("githublink");
                   if(result.getString("Address") !=null) address = result.getString("Address");
                   if(result.getString("firstName") !=null)  firstname = result.getString("firstName");  
                  if(result.getString("lastName") !=null)   lastname = result.getString("lastName");
                  if(result.getString("About") !=null)  description = result.getString("About");
                   password=result.getString("password");
                }
            
              } catch (SQLException e) {
		e.printStackTrace();
			}
            }      
		}
	
      %>
   
      <div class="wrapper" style="margin-top: -300px;
padding-left: 217px;">  
  <div class="profile-card js-profile-card">
    <div class="profile-card__img">
    <!-- blob should be managed properly -->
      <img src="<%= session.getAttribute("profilepic") %>" alt="profile pic">
    </div>

    <div class="profile-card__cnt js-profile-cnt">
      <div class="profile-card__name"><%=username %></div>
    
      <div class="profile-card__txt"><%= description %><strong> helloMegha</strong></div>
      <div class="profile-card-loc">
        <span class="profile-card-loc__icon">
          <svg class="icon"><use xlink:href="#icon-location"></use></svg>
        </span>

        <span class="profile-card-loc__txt">
        <%=address %>
        </span>
      </div>
<!-- 
      <div class="profile-card-inf">
        <div class="profile-card-inf__item">
          <div class="profile-card-inf__title">1598</div>
          <div class="profile-card-inf__txt">Collaboration</div>
        </div>

        <div class="profile-card-inf__item">
          <div class="profile-card-inf__title">65</div>
          <div class="profile-card-inf__txt">Merg</div>
        </div>


        <div class="profile-card-inf__item">
          <div class="profile-card-inf__title">85</div>
          <div class="profile-card-inf__txt">commit</div>
        </div>
      </div> -->
<!-- social media site link -->

      <div class="profile-card-social">
<!-- facebook link -->
    <!--     <a href="#" class="profile-card-social__item facebook" target="_blank">
          <span class="icon-font">
              <svg class="icon"><use xlink:href="#icon-facebook"></use></svg>
          </span>
        </a> --><!-- 
<!-- twiter link  -->       <!-- <a href="#" class="profile-card-social__item twitter" target="_blank">
          <span class="icon-font">
              <svg class="icon"><use xlink:href="#icon-twitter"></use></svg>
          </span>
        </a> --> 
<!-- instagram -->
       <!--  <a href="instagram" class="profile-card-social__item instagram" target="_blank">
          <span class="icon-font">
              <svg class="icon"><use xlink:href="#icon-instagram"></use></svg>
          </span>
        </a> -->

    
 <!-- sociial side link github -->
        <a href="<%=githublink%>" class="profile-card-social__item github" >
          <span class="icon-font">
              <svg class="icon"><use xlink:href="#icon-github"></use></svg>
          </span>
        </a>   
        
      </div>
 <!-- social media link sakeo -->

      <div class="profile-card-ctr">
        <button class="profile-card__button button--blue js-message-btn">Edit</button>
        <button class="profile-card__button button--orange">Block Account</button>
      </div>
    </div>
        <%if(githublink.equals("#")) githublink="";%>
    <div class="profile-card-message js-message" style="text-align: center;">
        Update user
        <form class="profile-card-form" action="updateAccount" method="post">
            <div class="profile-card-form__container">
                
              <input type="text" name="firstname" placeholder="First Name" value="<%= firstname%>">
                  <input type="text" name="lastname" placeholder="Last Name" value="<%= lastname%>">
                  <input type="text" name="username" placeholder="username" value="<%= username%>">
                  <input type="text" name="address" placeholder="address" value="<%= address%>">
                    <input type="text" name="email" placeholder="E-mail" value="<%=email%>">
                       <input type="text" name="phonenumber" placeholder="phonenumber" value="<%=phonenumber%>">
                       <%if(frequency==10){
                           %>
                         <input type="text" name="password" placeholder="passowrd" value="<%=password%>">
                       <%
                          
                       }%>
                   <input type="text" name="githublink" placeholder="githublink" value="<%= githublink%>">
                   <textarea type="text" name="description" placeholder="About">
                   <%= description%>
                   </textarea>
                                  
            </div>
            <div class="profile-card-form__bottom">
              <button class="profile-card__button button--blue" >
                save
          </button>

         	 <button class="profile-card__button button--gray js-message-close">
           		 Cancel
          		</button>
        	</div>
      </form>

      <div class="profile-card__overlay js-message-close"></div>
    </div>

  </div>

</div>

<svg hidden="hidden">
  <defs>
   
    <symbol id="icon-github" viewBox="0 0 32 32">
      <title>github</title>
      <path d="M16.192 0.512c-8.832 0-16 7.168-16 16 0 7.072 4.576 13.056 10.944 15.168 0.8 0.16 1.088-0.352 1.088-0.768 0-0.384 0-1.632-0.032-2.976-4.448 0.96-5.376-1.888-5.376-1.888-0.736-1.856-1.792-2.336-1.792-2.336-1.44-0.992 0.096-0.96 0.096-0.96 1.6 0.128 2.464 1.664 2.464 1.664 1.44 2.432 3.744 1.728 4.672 1.344 0.128-1.024 0.544-1.728 1.024-2.144-3.552-0.448-7.296-1.824-7.296-7.936 0-1.76 0.64-3.168 1.664-4.288-0.16-0.416-0.704-2.016 0.16-4.224 0 0 1.344-0.416 4.416 1.632 1.28-0.352 2.656-0.544 4-0.544s2.72 0.192 4 0.544c3.040-2.080 4.384-1.632 4.384-1.632 0.864 2.208 0.32 3.84 0.16 4.224 1.024 1.12 1.632 2.56 1.632 4.288 0 6.144-3.744 7.488-7.296 7.904 0.576 0.512 1.088 1.472 1.088 2.976 0 2.144-0.032 3.872-0.032 4.384 0 0.416 0.288 0.928 1.088 0.768 6.368-2.112 10.944-8.128 10.944-15.168 0-8.896-7.168-16.032-16-16.032z"></path>
      <path d="M6.24 23.488c-0.032 0.064-0.16 0.096-0.288 0.064-0.128-0.064-0.192-0.16-0.128-0.256 0.032-0.096 0.16-0.096 0.288-0.064 0.128 0.064 0.192 0.16 0.128 0.256v0z"></path>
      <path d="M6.912 24.192c-0.064 0.064-0.224 0.032-0.32-0.064s-0.128-0.256-0.032-0.32c0.064-0.064 0.224-0.032 0.32 0.064s0.096 0.256 0.032 0.32v0z"></path>
      <path d="M7.52 25.12c-0.096 0.064-0.256 0-0.352-0.128s-0.096-0.32 0-0.384c0.096-0.064 0.256 0 0.352 0.128 0.128 0.128 0.128 0.32 0 0.384v0z"></path>
      <path d="M8.384 26.016c-0.096 0.096-0.288 0.064-0.416-0.064s-0.192-0.32-0.096-0.416c0.096-0.096 0.288-0.064 0.416 0.064 0.16 0.128 0.192 0.32 0.096 0.416v0z"></path>
      <path d="M9.6 26.528c-0.032 0.128-0.224 0.192-0.384 0.128-0.192-0.064-0.288-0.192-0.256-0.32s0.224-0.192 0.416-0.128c0.128 0.032 0.256 0.192 0.224 0.32v0z"></path>
      <path d="M10.912 26.624c0 0.128-0.16 0.256-0.352 0.256s-0.352-0.096-0.352-0.224c0-0.128 0.16-0.256 0.352-0.256 0.192-0.032 0.352 0.096 0.352 0.224v0z"></path>
      <path d="M12.128 26.4c0.032 0.128-0.096 0.256-0.288 0.288s-0.352-0.032-0.384-0.16c-0.032-0.128 0.096-0.256 0.288-0.288s0.352 0.032 0.384 0.16v0z"></path>
    </symbol>

    <symbol id="icon-location" viewBox="0 0 32 32">
      <title>location</title>
      <path d="M16 31.68c-0.352 0-0.672-0.064-1.024-0.16-0.8-0.256-1.44-0.832-1.824-1.6l-6.784-13.632c-1.664-3.36-1.568-7.328 0.32-10.592 1.856-3.2 4.992-5.152 8.608-5.376h1.376c3.648 0.224 6.752 2.176 8.608 5.376 1.888 3.264 2.016 7.232 0.352 10.592l-6.816 13.664c-0.288 0.608-0.8 1.12-1.408 1.408-0.448 0.224-0.928 0.32-1.408 0.32zM15.392 2.368c-2.88 0.192-5.408 1.76-6.912 4.352-1.536 2.688-1.632 5.92-0.288 8.672l6.816 13.632c0.128 0.256 0.352 0.448 0.64 0.544s0.576 0.064 0.832-0.064c0.224-0.096 0.384-0.288 0.48-0.48l6.816-13.664c1.376-2.752 1.248-5.984-0.288-8.672-1.472-2.56-4-4.128-6.88-4.32h-1.216zM16 17.888c-3.264 0-5.92-2.656-5.92-5.92 0-3.232 2.656-5.888 5.92-5.888s5.92 2.656 5.92 5.92c0 3.264-2.656 5.888-5.92 5.888zM16 8.128c-2.144 0-3.872 1.728-3.872 3.872s1.728 3.872 3.872 3.872 3.872-1.728 3.872-3.872c0-2.144-1.76-3.872-3.872-3.872z"></path>
      <path d="M16 32c-0.384 0-0.736-0.064-1.12-0.192-0.864-0.288-1.568-0.928-1.984-1.728l-6.784-13.664c-1.728-3.456-1.6-7.52 0.352-10.912 1.888-3.264 5.088-5.28 8.832-5.504h1.376c3.744 0.224 6.976 2.24 8.864 5.536 1.952 3.36 2.080 7.424 0.352 10.912l-6.784 13.632c-0.32 0.672-0.896 1.216-1.568 1.568-0.48 0.224-0.992 0.352-1.536 0.352zM15.36 0.64h-0.064c-3.488 0.224-6.56 2.112-8.32 5.216-1.824 3.168-1.952 7.040-0.32 10.304l6.816 13.632c0.32 0.672 0.928 1.184 1.632 1.44s1.472 0.192 2.176-0.16c0.544-0.288 1.024-0.736 1.28-1.28l6.816-13.632c1.632-3.264 1.504-7.136-0.32-10.304-1.824-3.104-4.864-5.024-8.384-5.216h-1.312zM16 29.952c-0.16 0-0.32-0.032-0.448-0.064-0.352-0.128-0.64-0.384-0.8-0.704l-6.816-13.664c-1.408-2.848-1.312-6.176 0.288-8.96 1.536-2.656 4.16-4.32 7.168-4.512h1.216c3.040 0.192 5.632 1.824 7.2 4.512 1.6 2.752 1.696 6.112 0.288 8.96l-6.848 13.632c-0.128 0.288-0.352 0.512-0.64 0.64-0.192 0.096-0.384 0.16-0.608 0.16zM15.424 2.688c-2.784 0.192-5.216 1.696-6.656 4.192-1.504 2.592-1.6 5.696-0.256 8.352l6.816 13.632c0.096 0.192 0.256 0.32 0.448 0.384s0.416 0.064 0.608-0.032c0.16-0.064 0.288-0.192 0.352-0.352l6.816-13.664c1.312-2.656 1.216-5.792-0.288-8.352-1.472-2.464-3.904-4-6.688-4.16h-1.152zM16 18.208c-3.424 0-6.24-2.784-6.24-6.24 0-3.424 2.816-6.208 6.24-6.208s6.24 2.784 6.24 6.24c0 3.424-2.816 6.208-6.24 6.208zM16 6.4c-3.072 0-5.6 2.496-5.6 5.6 0 3.072 2.528 5.6 5.6 5.6s5.6-2.496 5.6-5.6c0-3.104-2.528-5.6-5.6-5.6zM16 16.16c-2.304 0-4.16-1.888-4.16-4.16s1.888-4.16 4.16-4.16c2.304 0 4.16 1.888 4.16 4.16s-1.856 4.16-4.16 4.16zM16 8.448c-1.952 0-3.552 1.6-3.552 3.552s1.6 3.552 3.552 3.552c1.952 0 3.552-1.6 3.552-3.552s-1.6-3.552-3.552-3.552z"></path>
    </symbol>

    <symbol id="icon-facebook" viewBox="0 0 32 32">
      <title>facebook</title>
      <path d="M19 6h5v-6h-5c-3.86 0-7 3.14-7 7v3h-4v6h4v16h6v-16h5l1-6h-6v-3c0-0.542 0.458-1 1-1z"></path>
    </symbol>

    <symbol id="icon-instagram" viewBox="0 0 32 32">
      <title>instagram</title>
      <path d="M16 2.881c4.275 0 4.781 0.019 6.462 0.094 1.563 0.069 2.406 0.331 2.969 0.55 0.744 0.288 1.281 0.638 1.837 1.194 0.563 0.563 0.906 1.094 1.2 1.838 0.219 0.563 0.481 1.412 0.55 2.969 0.075 1.688 0.094 2.194 0.094 6.463s-0.019 4.781-0.094 6.463c-0.069 1.563-0.331 2.406-0.55 2.969-0.288 0.744-0.637 1.281-1.194 1.837-0.563 0.563-1.094 0.906-1.837 1.2-0.563 0.219-1.413 0.481-2.969 0.55-1.688 0.075-2.194 0.094-6.463 0.094s-4.781-0.019-6.463-0.094c-1.563-0.069-2.406-0.331-2.969-0.55-0.744-0.288-1.281-0.637-1.838-1.194-0.563-0.563-0.906-1.094-1.2-1.837-0.219-0.563-0.481-1.413-0.55-2.969-0.075-1.688-0.094-2.194-0.094-6.463s0.019-4.781 0.094-6.463c0.069-1.563 0.331-2.406 0.55-2.969 0.288-0.744 0.638-1.281 1.194-1.838 0.563-0.563 1.094-0.906 1.838-1.2 0.563-0.219 1.412-0.481 2.969-0.55 1.681-0.075 2.188-0.094 6.463-0.094zM16 0c-4.344 0-4.887 0.019-6.594 0.094-1.7 0.075-2.869 0.35-3.881 0.744-1.056 0.412-1.95 0.956-2.837 1.85-0.894 0.888-1.438 1.781-1.85 2.831-0.394 1.019-0.669 2.181-0.744 3.881-0.075 1.713-0.094 2.256-0.094 6.6s0.019 4.887 0.094 6.594c0.075 1.7 0.35 2.869 0.744 3.881 0.413 1.056 0.956 1.95 1.85 2.837 0.887 0.887 1.781 1.438 2.831 1.844 1.019 0.394 2.181 0.669 3.881 0.744 1.706 0.075 2.25 0.094 6.594 0.094s4.888-0.019 6.594-0.094c1.7-0.075 2.869-0.35 3.881-0.744 1.050-0.406 1.944-0.956 2.831-1.844s1.438-1.781 1.844-2.831c0.394-1.019 0.669-2.181 0.744-3.881 0.075-1.706 0.094-2.25 0.094-6.594s-0.019-4.887-0.094-6.594c-0.075-1.7-0.35-2.869-0.744-3.881-0.394-1.063-0.938-1.956-1.831-2.844-0.887-0.887-1.781-1.438-2.831-1.844-1.019-0.394-2.181-0.669-3.881-0.744-1.712-0.081-2.256-0.1-6.6-0.1v0z"></path>
      <path d="M16 7.781c-4.537 0-8.219 3.681-8.219 8.219s3.681 8.219 8.219 8.219 8.219-3.681 8.219-8.219c0-4.537-3.681-8.219-8.219-8.219zM16 21.331c-2.944 0-5.331-2.387-5.331-5.331s2.387-5.331 5.331-5.331c2.944 0 5.331 2.387 5.331 5.331s-2.387 5.331-5.331 5.331z"></path>
      <path d="M26.462 7.456c0 1.060-0.859 1.919-1.919 1.919s-1.919-0.859-1.919-1.919c0-1.060 0.859-1.919 1.919-1.919s1.919 0.859 1.919 1.919z"></path>
    </symbol>

    <symbol id="icon-twitter" viewBox="0 0 32 32">
      <title>twitter</title>
      <path d="M32 7.075c-1.175 0.525-2.444 0.875-3.769 1.031 1.356-0.813 2.394-2.1 2.887-3.631-1.269 0.75-2.675 1.3-4.169 1.594-1.2-1.275-2.906-2.069-4.794-2.069-3.625 0-6.563 2.938-6.563 6.563 0 0.512 0.056 1.012 0.169 1.494-5.456-0.275-10.294-2.888-13.531-6.862-0.563 0.969-0.887 2.1-0.887 3.3 0 2.275 1.156 4.287 2.919 5.463-1.075-0.031-2.087-0.331-2.975-0.819 0 0.025 0 0.056 0 0.081 0 3.181 2.263 5.838 5.269 6.437-0.55 0.15-1.131 0.231-1.731 0.231-0.425 0-0.831-0.044-1.237-0.119 0.838 2.606 3.263 4.506 6.131 4.563-2.25 1.762-5.075 2.813-8.156 2.813-0.531 0-1.050-0.031-1.569-0.094 2.913 1.869 6.362 2.95 10.069 2.95 12.075 0 18.681-10.006 18.681-18.681 0-0.287-0.006-0.569-0.019-0.85 1.281-0.919 2.394-2.075 3.275-3.394z"></path>
    </symbol>
   
  </defs>
</svg>

</section>

<script type="text/javascript">
var messageBox = document.querySelector('.js-message');
var btn = document.querySelector('.js-message-btn');
var card = document.querySelector('.js-profile-card');
var closeBtn = document.querySelectorAll('.js-message-close');

btn.addEventListener('click',function (e) {
    e.preventDefault();
    card.classList.add('active');
});

closeBtn.forEach(function (element, index) {
   console.log(element);
    element.addEventListener('click',function (e) {
        e.preventDefault();
        card.classList.remove('active');
    });
});
</script>
