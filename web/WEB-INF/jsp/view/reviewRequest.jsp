<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href="<c:url value="/resource/images/jaguar.ico" />" type="image/x-icon" />
<title>Online Banking</title>
<link href="<c:url value="resource/css/bootstrap.css" />" rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Dancing+Script:700|EB+Garamond" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=UnifrakturCook:700" rel="stylesheet" type="text/css'">
<link href="https://fonts.googleapis.com/css?family=Old+Standard+TT:700,400italic" rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Dancing+Script:700|EB+Garamond" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Oswald:400,700" rel="stylesheet" type="text/css">
<link href="<c:url value="/resource/css/boilerplate.css" />" rel="stylesheet" type="text/css">
<link href="<c:url value="/resource/css/layout.css" />" rel="stylesheet" type="text/css">
<link href="<c:url value="/resource/css/custom.css" />" rel="stylesheet" type="text/css">
<link href="<c:url value="/resource/css/payment-request.css" />" rel="stylesheet" type="text/css">
<link href="<c:url value="/resource/css/boostrapmin..css" />" rel="stylesheet" type="text/css">
<link href="<c:url value="/resource/css/bootstrap-theme.min.css" />" rel="stylesheet" type="text/css">
            
    
    <style>
            body {
                background-color:buttonface;
            }

            h4 {
                text-align: center;
            }

            .form-group {
                text-align: center;
            }

            .control-label {
                font-size: 24px;
            }

        </style>
        
        <script type="text/javascript">
            $(window).load(function(){
                $('#mreview-modal').modal('show');
            });
        </script>
    
<script src="<c:url value="resource/js/respond.min.js" />"></script>
<script src="<c:url value="resource/js/modernizr-2.8.3-respond-1.4.2.min.js" />"></script>
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
        <li><a href="<c:url value="/options?action=details" />">View your details</a></li>
        <li><a href="<c:url value="/options?action=transactions" />">Transactions</a></li>
        <li><a href="<c:url value="/options?action=changePass" />">Change password</a></li>
        <li><a href="<c:url value="/login?logout=true" />">LOG OUT</a></li>
      </ul>
    </div>
    <div id="details-holder">
      <div id="info-box">
        <div>
          <h1 id="pay-details">Payment details</h1>
          <hr>
          <div class="request">
              <form>
              <h3 id="provide-info">Please provide following information</h3>
              <p></p>
              <p> <span>Name of recipient :</span>
                <select required="" id="title" name="title" class="input-field">
                  <option selected="true" disabled="disabled">title</option>
                  <option>Mr.</option>
                  <option>Mrs.</option>
                  <option>Miss</option>
                </select>
                <input id="name" name="name" placeholder="   John Dow" required="" tabindex="1" type="text" class="input-field">
                </input>
              </p>
              <p> <span>Account number : </span>
                <input id="account-number" name="account-number" placeholder="   12345678" required="" type="text" pattern="[0-9.]+" maxlength="8" class="input-field">
                </input>
              </p>
              <p> <span>Amount to be paid : £ </span>
                <input id="amount" name="amount" placeholder="  e.g   500.00" required="" type="text" pattern="[0-9.]+" class="input-field">
                </input>
              </p>
              <p>
                <input class="button" name="submit" id="submit" tabindex="5" value="NEXT" type="submit">
                </input>
                <!--<button type="button" class="btn btn-primary" type="submit" name="submit">NEXT</button>--> 
              </p>
            </form>
          </div>
          <hr>
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
        
        <!-- modal for reviewing the payment details -->
        
        <div class="modal show" id="review-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title" id="exampleModalLabel">Review your payment details</h4>
                    </div>
                    <div class="modal-body">
                        <form method="post" action="<c:url value="/options?action=confirmPayment" />">
                            <div class="form-group">
                                <label for="recipient-name" class="control-label">Recipient : <c:out value="${name}" /></label>
                                <input name="name" value="<c:out value="${name}" />" type="hidden" />
                            </div>
                            <div class="form-group">
                                <label for="message-text" class="control-label">Account : <c:out value="${accountNumber}" /></label>
                                <input name="account-number" value="<c:out value="${accountNumber}" />" type="hidden" />
                            </div>
                            <div class="form-group">
                                <label for="message-text" class="control-label">Amount : £<c:out value="${amount}" /></label>
                                <input name="amount" value="<c:out value="${amount}" />" type="hidden" />
                            </div>
                            <input class="btn btn-success btn-lg" name="submit" id="submit" tabindex="5" value="PAY NOW" type="submit">
                        </form>
                    </div>
                    <br>
                    <div class="modal-footer">
                        <a id="cancel" href="<c:url value="/options?action=makePayment" />" class="btn btn-danger btn-lg active" role="button">CANCEL</a>
                        <!--<a href="/Payment" btn btn-success btn-lg active" role="button">PAY</a>-->
                        <!-- use of button above obsolete -->
                    </div>
                </div>
            </div>
        </div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 
<script src="<c:url value="resource/js/jquery-1.js" />"></script> 

<!--Include all compiled plugins (below), or include individual files as needed --> 
<script src="<c:url value="resource/js/boostrap.js" />"></script>
</body>
</html>
    

