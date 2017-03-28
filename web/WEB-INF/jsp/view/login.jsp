<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="shortcut icon" href="<c:url value="resource/images/jaguar.ico" />" type="image/x-icon" />
        <title>Online Banking</title>
        <!-- Bootstrap -->
        <link href="<c:url value="/resource/css/bootstrap.css" />" rel="stylesheet">
        <link href="http://fonts.googleapis.com/css?family=Dancing+Script:700|EB+Garamond" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=UnifrakturCook:700" rel="stylesheet" type="text/css'">
        <link href="https://fonts.googleapis.com/css?family=Old+Standard+TT:700,400italic" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Dancing+Script:700|EB+Garamond" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Oswald:400,700" rel="stylesheet" type="text/css">
        <link href="<c:url value="/resource/css/style.css" />" rel="stylesheet" type="text/css">

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
                          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
                          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
                        <![endif]-->
    </head>
    <body>
        <div class="main container">
            <header>
                <div class="container">
                    <div class="row">
                        <div class="col-md-3 col-md-offset-1"> <img src="<c:url value="resource/images/jaguar.jpg" />" alt="logo" id="welcome" class="img-circle img-responsive"> </div>
                        <div class="col-md-6">
                            <p  id="banner">George Banking Group</p>
                        </div>
                    </div>
                </div>
            </header>
            <!--<div class="side-info">
              <aside>
                <p>Here I will put some advetisements and other staff to look more professioanl. Saying something about the new interest of the
                deposits in the bank</p>
              </aside>
            </div>-->
            <div class="content-main">
                <div class="row">
                    <div class="col-md-6 col-md-offset-3">
                        <h3>Welcome to our online banking service. Please login to be able to access your bank account online services.</h3>
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col-md-6">
                        <form method="post" action="<c:url value="/login" />">
                            <fieldset>
                                <legend id="legend">Enter your login details</legend>
                                <c:if test="${loginFailed}">
                                    <b style="color: red">The username and password you entered are not correct. Please try
                                        again.</b><br /><br />
                                    </c:if>
                                <p>
                                    <label for="user">Username:
                                        <input required autofocus id="user" autocomplete="off" name="username"/>
                                    </label>
                                </p>
                                <p>
                                    <label for="password">Password:
                                        <input type="password" required placeholder="max 15 characters" maxlength="15" id="password" name="password"/>
                                    </label>
                                </p>
                            </fieldset>
                            <p>
                                <input type="image" src="<c:url value="resource/images/submit.png" />" name="submit" id="button"/>
                            </p>
                        </form>
                    </div>
                    <div class="col-md-6">
                        <div> <img src="<c:url value="resource/images/online_banking_en.gif" />" alt="sign up now" align="middle" id="online-banking-banner" class="img-responsive"> </div>
                        <div class="container-signup">
                            <div class="row">
                                <div class="col-md-9"> <span class="sign-up">If you have not signed up yet for your online banking, click on the image    </span>    <span style="font-size:1.8em;" class="glyphicon glyphicon-share-alt" aria-hidden="true"></span> </div>
                                <div class="col-md-3"> <a href="<c:url value="/register" />"><img src="<c:url value="resource/images/signup.jpg" />" alt="sign up now" id="img-signup" class="img-responsive"></a> </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <footer>
                                <p class="foot-p">&#169;2013, George Vasilski. if any queries about this web site go to my portfolio at www.gvasilski.com</p>
                            </footer>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 
        <script src="js/jquery-1.11.2.min.js"></script> 

        <!-- Include all compiled plugins (below), or include individual files as needed --> 
        <script src="js/bootstrap.js"></script>
    </body>
</html>
