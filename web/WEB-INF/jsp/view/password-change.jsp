<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href="<c:url value="/resource/images/jaguar.ico" />" type="image/x-icon" />
<title>Online Banking</title>
<!--<link href="css/bootstrap.css" rel="stylesheet">-->
<link href="http://fonts.googleapis.com/css?family=Dancing+Script:700|EB+Garamond" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=UnifrakturCook:700" rel="stylesheet" type="text/css'">
<link href="https://fonts.googleapis.com/css?family=Old+Standard+TT:700,400italic" rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Dancing+Script:700|EB+Garamond" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Oswald:400,700" rel="stylesheet" type="text/css">
<link href="<c:url value="/resource/css/boilerplate.css" />" rel="stylesheet" type="text/css">
<link href="<c:url value="/resource/css/layout.css" />" rel="stylesheet" type="text/css">
<link href="<c:url value="/resource/css/custom.css" />" rel="stylesheet" type="text/css">
<link href="<c:url value="/resource/css/payment-request.css" />" rel="stylesheet" type="text/css">
<link href="<c:url value="resource/css/jquery-ui.css" />" rel="stylesheet">
<link href="<c:url value="resource/css/jquery-ui.theme.css" />" rel="stylesheet">
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
    <div id="navigation">
      <ul class="nav">
        <li><a href="<c:url value="/options?action=makePayment" />">Make a Payment</a></li>
        <li><a href="<c:url value="/options?action=transactions" />">Transactions</a></li>
        <li><a href="<c:url value="/options?action=details" />">View your details</a></li>
        <li><a href="<c:url value="/login?logout=true" />">LOG OUT</a></li>
      </ul>
    </div>
    <div id="details-holder">
      <div id="info-box">
        <div>
          <h1 id="pay-details">Change PASSWORD</h1>
          <hr>
          <div class="request">
            <h1>Follow the steps below</h1>
            <form id="change-password" method="post" action="<c:url value="/options?action=changePass" />">
              <p>
                <label for="old-passord">Enter your old password:
                  <input class="input-field" type="password" required placeholder="max 15 characters" maxlength="15" id="old-password" autocomplete="off" name="old-password"/>
                </label>
              </p>
              <p>
                <label for="password">Enter the new password:
                  <input class="input-field" type="password" required placeholder="max 15 characters" maxlength="15" id="new-password" autocomplete="off" name="new-password"/>
                </label>
              </p>
              <p>
                <label for="password">Re-enter the new password:
                  <input class="input-field" type="password" required placeholder="max 15 characters" maxlength="15" id="new-repassword" autocomplete="off" name="new-repassword"/>
                </label>
              </p>
              <p><span id="message"></span></p>
              <script>
                                                                                        $('#new-password, #new-repassword').on('keyup', function ()
                                                                                        {
                                                                                            if ($('#new-password').val() == $('#new-repassword').val())
                                                                                            {
                                                                                                $('#message').html('matching').css('color', 'green');
                                                                                            }
                                                                                            else
                                                                                            {
                                                                                                $('#message').html('not matching').css('color', 'red')
                                                                                            }
                                                                                        });
                                                                                    </script>
              <p>
                <input class="buttom" name="submit" id="submit" tabindex="5" value="Send Request" type="submit">
              </p>
            </form>
          </div>
          <hr />
        </div>
      </div>
    </div>
    <div id="commercials">
        <div id="first-advert"> <img src="<c:url value="resource/images/bankCard.jpg" />" alt="bankCard" class="img-thumbnail img-responsive" />
        <p style="text-align:center; color:#000; font-weight:bold;"> Using your credit card will give you extra benefits when shopping online.</p>
      </div>
        <div id="second-advert"> <img src="<c:url value="resource/images/comp.jpg" />" alt="saveing account" class="img-thumbnail img-responsive" />
        <p style="text-align:center; color:#000; font-weight:bold;"> We have the best interest rates for your savings. Go to your local branch of GIB Bank and ask for your personal adviser.</p>
      </div>
    </div>
  </div>
  <div id="footer">
    <p class="foot-p">©2013, George Vasilski. if any queries about this web site go to my portfolio at www.gvasilski.com</p>
  </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins)--> 
<script src="<c:url value="resource/js/jquery-1.js" />"></script> 

<!--Include all compiled plugins (below), or include individual files as needed--> 
<script src="<c:url value="resource/js/bootstrap.js" />"></script>
<!--  make the view port for mobile look -->
</body>
</html>
    
