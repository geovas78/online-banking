<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href="<c:url value="/resource/images/jaguar.ico" />" type="image/x-icon" />
<title>Online Banking</title>
<!--<link href="<c:url value="/resource/css/bootstrap.css" />" rel="stylesheet">-->
<link href="http://fonts.googleapis.com/css?family=Dancing+Script:700|EB+Garamond" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=UnifrakturCook:700" rel="stylesheet" type="text/css'">
<link href="https://fonts.googleapis.com/css?family=Old+Standard+TT:700,400italic" rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Dancing+Script:700|EB+Garamond" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Oswald:400,700" rel="stylesheet" type="text/css">
<link href="<c:url value="/resource/css/boilerplate.css" />" rel="stylesheet" type="text/css">
<link href="<c:url value="/resource/css/layout.css" />" rel="stylesheet" type="text/css">
<link href="<c:url value="/resource/css/custom.css" />" rel="stylesheet" type="text/css">
<link href="<c:url value="/resource/css/showDetailsSection.css" />" rel="stylesheet" type="text/css">
<!-- 
To learn more about the conditional comments around the html tags at the top of the file:
paulirish.com/2008/conditional-stylesheets-vs-css-hacks-answer-neither/

Do the following if you're using your customized build of modernizr (http://www.modernizr.com/):
* insert the link to your js here
* remove the link below to the html5shiv
* add the "no-js" class to the html tags at the top
* you can also remove the link to respond.min.js if you included the MQ Polyfill in your modernizr build 
-->
<!--[if lt IE 9]>
<script src="//html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
<script src="<c:url value="/resource/js/respond.min.js" />"></script>
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
        <li><a href="<c:url value="/options?action=changePass" />">Change password</a></li>
        <li><a href="<c:url value="/login?logout=true" />">LOG OUT</a></li>
      </ul>
    </div>
    <div id="details-holder">
      <hr>
      <div id="card"><img src="<c:url value="resource/images/card.jpg" />" alt="card"></div>
      <div id="pd">Account number : <c:out value="${userAccountDetails.account}" /><br>
        <span> Account holder name :</span> <c:out value="${userAccountDetails.name}" /> </div>
      <div id="info-box">
        <hr>
        <h1 id="show-head">Your bank details are :</h1>
        <ul id="my-list">
          <li class="list-item">Date of creation of your account: <c:out value="${userAccountDetails.dateOfCreation}" /> </li>
          <h3>Address for correspondence : </h3>
          <li class="list-item"> <c:out value="${userAccountDetails.houseNumber}  " />  <c:out value="${userAccountDetails.streetName}" /> </li>
          <li class="list-item"> <c:out value="${userAccountDetails.town}" /> , <c:out value="${userAccountDetails.postcode}" /> </li>
          <li class="list-item">Telephone :
            0<c:out value="${userAccountDetails.telephoneNumber}" />  </li>
          <hr>
          <li class="list-item">Your account has : £ <c:out value="${userAccountDetails.overdraftLimit}" />0 overdraft </li>
          <li class="list-item">Type of the account : <c:out value="${userAccountDetails.accountType}" /> </li>
        </ul>
      </div>
    </div>
    <div id="commercials">
      <div id="first-advert"> <img src="<c:url value="/resource/images/home-address.png" />" alt="" class="img-thumbnail img-responsive" />
        <p style="text-align:center; color:#000; font-weight:bold;"> To change your address for correspondence, please go to your local branch .</p>
      </div>
      <div id="second-advert"><img src="<c:url value="/resource/images/overdraft.jpg" />" alt="saveing account" height="85" class="img-thumbnail img-responsive" />
        <p style="text-align:center; color:#000; font-weight:bold;"> You can apply for extended overdraft limit only by post or in the local branch.</p>
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
