<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href="<c:url value="/resource/images/jaguar.ico" />" type="image/x-icon" />
<title>Online Banking</title>
<link href="<c:url value="/resource/css/bootstrap.css" />" rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Dancing+Script:700|EB+Garamond" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=UnifrakturCook:700" rel="stylesheet" type="text/css'">
<link href="https://fonts.googleapis.com/css?family=Old+Standard+TT:700,400italic" rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Dancing+Script:700|EB+Garamond" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Oswald:400,700" rel="stylesheet" type="text/css">
<link href="<c:url value="/resource/css/boilerplate.css" />" rel="stylesheet" type="text/css">
<link href="<c:url value="/resource/css/layout.css" />" rel="stylesheet" type="text/css">
<link href="<c:url value="/resource/css/custom.css" />" rel="stylesheet" type="text/css">
<link href="<c:url value="/resource/css/style-form.css" />" rel="stylesheet" type="text/css">
<script src="http://code.jquery.com/jquery-2.1.0.min.js"></script>
<script src="<c:url value="resource/js/respond.min.js" />"></script>
</head>

<body>
<div class="gridContainer clearfix">
  <div id="header">
    <div id="welcome"><img src="<c:url value="/resource/images/jaguar.jpg" />" id="card-image" alt="logo" class="img-circle img-responsive"></div>
    <div id="banner">
      <p>George Banking Group</p>
    </div>
  </div>
  <div id="main-page-content">
    <div id="details-holder">
      <div id="info-box">
        <div class="promt">
          <h3>Please fill in the form below to sign up for your online services</h3>
        </div>
        <hr />
        <div  class="form">
            <c:if test="${error}">
                <p style="color: red"><c:out value="${message}" /></p><br />
            </c:if>
          <form id="contactform" method="post" action="<c:url value="/register" />">
            <p class="contact">
              <label for="name">Name</label>
            </p>
            <input id="name" name="name" placeholder="First and last name, e.g Mr./Mrs. or Miss and the name" required tabindex="1" type="text">
            <p class="contact">
              <label for="account-number">Account Number</label>
            </p>
            <input id="account-number" name="account-number" placeholder="12345678" required type="text" pattern="[0-9.]+" maxlength="8">
            <p class="contact">
              <label for="username">Create a username</label>
            </p>
            <input id="username" name="username" placeholder="username" required tabindex="2" type="text">
            <p class="contact">
              <label for="password">Create a password</label>
            </p>
            <input type="password" id="password" name="password" required>
            <p class="contact">
              <label for="repassword">Confirm your password</label>
            </p>
            <p><span id="message"></span></p>
            <input type="password" id="repassword" name="repassword" required>
            
            <!-- validating the password re-enter --> 
            <script>
                        $('#password, #repassword').on('keyup', function()
                        {
                           if ($('#password').val() == $('#repassword').val())
                           {
                               $('#message').html('matching').css('color','green');
                           }
                           else 
                           {
                               $('#message').html('not matching').css('color','red')
                           }
                        });
                    </script>
            <input class="buttom" name="submit" id="submit" tabindex="5" value="Sign up" type="submit">
          </form>
        </div>
      </div>
    </div>
  </div>
  <div id="footer">
    <p class="foot-p">©2013, George Vasilski. if any queries about this web site go to my portfolio at www.gvasilski.com</p>
  </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) 
  <script src="js/jquery-1.js"></script> 
  
   Include all compiled plugins (below), or include individual files as needed 
  <script src="js/bootstrap.js"></script>-->
</body>
</html>

