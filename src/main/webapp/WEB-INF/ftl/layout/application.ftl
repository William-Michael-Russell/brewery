<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="drinkForm" type="net.testaholic.brewery.domain.bartender.BartenderCreateForm" -->
<#-- @ftlvariable name="currentUser" type="net.testaholic.brewery.domain.user.CurrentUser" -->
<#macro layout>
<!doctype html>
<html lang="en">
<head>

    <style>html, body {
        width: auto !important;
        overflow-x: hidden !important;
    }</style>

    <script>
        $(document).ready(function () {

            $().UItoTop({easingType: 'easeOutQuart'});
            $('#stuck_container').tmStickUp({});
            $('.gallery .gall_item').touchTouch();

        });
        var is_chrome = navigator.userAgent.toLowerCase().indexOf('chrome') > -1;
        if (is_chrome) {
            document.write("Yaii it is Chrome only")
        }
    </script>


    <meta name="viewport"
          content="user-scalable=no, initial-scale=1, maximum-scale=1, minimum-scale=1, width=320, height=device-height, target-densitydpi=medium-dpi"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
<#--<meta name="viewport" content="width=device-width, initial-scale=1">-->

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta charset="utf-8">
    <!-- Latest compiled and minified CSS -->
<#--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>-->

    <meta charset="utf-8">
    <meta name="format-detection" content="telephone=no"/>
    <link rel="icon" href="/static/images/favicon.ico">
    <link rel="shortcut icon" href="/static/images/favicon.ico"/>
<#--<link rel="stylesheet" href="/static/css/stuck.css">-->
    <link rel="stylesheet" href="/static/css/style.css">
    <link rel="stylesheet" href="/static/css/touchTouch.css">
    <link rel="stylesheet" href="/static/css/bootstrap.css">
    <script src="/static/js/jquery.js"></script>
    <script src="/static/js/jquery-migrate-1.1.1.js"></script>
    <script src="/static/js/script.js"></script>
    <script src="/static/js/superfish.js"></script>
    <script src="/static/js/jquery.equalheights.js"></script>
    <script src="/static/js/jquery.mobilemenu.js"></script>
    <script src="/static/js/jquery.easing.1.3.js"></script>
    <script src="/static/js/tmStickUp.js"></script>
    <script src="/static/js/jquery.ui.totop.js"></script>
    <script src="/static/js/touchTouch.jquery.js"></script>
    <script src="/static/js/bootstrap.js"></script>
    <script src="https://use.fonticons.com/f39f8f9b.js"></script>

    <script src="/static/js/html5shiv.js"></script>
    <link rel="stylesheet" media="screen" href="/static/css/ie.css">


    <style>


        .chromeOnly {
            color: green;
        (-bracket-: hack;
            color: red;
        );
        }

        .nav_bar_space {
            padding-top: 85px;
        }

        .mynavbar {
            text-align: center;
        }

        .mynavbar .nav {
            float: none;
        }

        .mynavbar .nav li form a {
            border-radius: 10px;
            background: lightskyblue;
            color: #fff;
        }

        .mynavbar .nav li {
            display: inline-block;
            float: none;
            margin: 0 20px;
            vertical-align: middle;
        }

        .mynavbar .nav li a {
            border-radius: 10px;
            background: lightskyblue;
            color: #fff;
        }

        .mynavbar .nav li a:hover {
            background: cornflowerblue;
        }

        .mynavbar .nav li.mylogo a, .mynavbar .nav li.mylogo a:hover {
            background: transparent;
            max-width: 150px;
        }

        .fix_this {
            max-width: 100px;
            min-width: 75px;
            min-height: 50px;
            background: lightskyblue;

            border-radius: 5px;
        }

        .fix_this:hover {
            max-width: 100px;
            min-width: 75px;
            min-height: 50px;
            align-content: center;
            background: cornflowerblue;
            border-radius: 5px;
        }

        .mynavbar .nav li.mylogo a img {
            width: 100%;
            height: auto;
            vertical-align: middle;
            display: inline-block;
        }

        .navbar-brand {
            display: none
        }

        @media screen and (max-width: 768px) {
            .navbar-brand {
                display: inline
            }

            .mynavbar .nav li {
                display: block;
                margin: 0
            }

            .mynavbar .nav li a {
                border-radius: 0;
                display: block;
                border-bottom: 1px solid #fff
            }

            .mynavbar li.mylogo {
                display: none
            }
        }
    </style>
</head>
</#macro>

<#macro admin>

    <#if currentUser??>
    <div class="col-md-12">
        <#if currentUser?? && currentUser.role == "USER">
            <div class="list-group">

                <a href="/user/${currentUser.id}" data-type="reset" class="btn">My User</a>
                <a href="/users" class="list-group-item">View all users</a>
            </div>


        <#elseif currentUser?? && currentUser.role == "ADMIN">
            <p class="lead">Admin Panel</p>
        <div class="list-group">

            <a href="/bartender/create" data-type="reset" class="btn">Add bartender</a>
            <a href="/appetizers/create" data-type="reset" class="btn">Add Appetizer</a>
            <a href="/user/create" data-type="reset" class="btn">Add User</a>
            <a href="/location/update/1" data-type="reset" class="btn">Update Location</a>
            <a href="/users" data-type="reset" class="btn">List Users</a>
        <#elseif currentUser??>
            <a href="/user/${currentUser.id}" data-type="reset" class="btn">My Account</a>
        </div>
        </#if>
    </div>

    </#if>
</#macro>

<#macro nav_bar>
<body>

<script>
    var isFirefox = navigator.userAgent.toLowerCase().indexOf('firefox') > -1;
    var isChrome = navigator.appVersion.indexOf("Chrome/") != -1;
</script>

<script>
    $(document).ready(function () {

        $().UItoTop({easingType: 'easeOutQuart'});
        $('#stuck_container').tmStickUp({});
        $('.gallery .gall_item').touchTouch();

    });
</script>

<nav class="mynavbar navbar-default navbar-static-top navbar-fixed-top" role="navigation">
    <div class="container navbar-static-top">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1"><span class="sr-only">Toggle navigation</span> <span
                    class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span></button>
            <a href="#" class="navbar-brand">Brewery</a></div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse mynavbar" id="bs-example-navbar-collapse-1">
            <ul id="navbar" class="nav navbar-nav ">
                <li><a href="/">home</a></li>
                <script>

                    if (isChrome) { //bug
                        document.write("<li> <a href=\"/drinks\">");
                        document.write("drinks");
                        document.write("</a></li>");

                        document.write("<li> <a href=\"/appetizers\">");
                        document.write("appetizers");
                        document.write("</a></li>");
                        document.write("<img src=\"/static/images/logo.png\" alt=\"Smiley face\" width=\"62\" height=\"42\">");
                    } else {
                        document.write("<li> <a href=\"/appetizers\">");
                        document.write("appetizers");
                        document.write("</a></li>");

                        document.write("<li> <a href=\"/drinks\">");
                        document.write("drinks");
                        document.write("</a></li>");

                        document.write("<li class=\"mylogo\"><a href=\"/home\"><img src=\"/static/images/logo.png\" alt=\"Smiley face\" width=\"42\" height=\"42\"></a></li>");
                    }

                </script>

            <#--<li class="mylogo"><a href="/home"><img src="/static/images/logo.png"  width="25" height="25" alt="Logo"></a></li>-->
                <li><a href="/location/1">location</a></li>
                <li><a href="/contact">contact</a></li>
                <#if currentUser??>
                    <li>
                        <a href="/user/${currentUser.id}">my account</a>
                    </li>
                    <li>
                        <form class="fix_this chromeOnly" name="formLogout" action="/logout" method="post">
                            <input class="fix_this" type="hidden" name="${_csrf.parameterName}"
                                   value="${_csrf.token}"/>
                            <a class="fix_this" href="#"
                               onclick="document.formLogout.submit(); return false;"><br>logout</a>
                        </form>
                    </li>
                <#else>
                    <li><a href="/login">login</a></li>
                </#if>

            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>


<#--#bugs-->
<script>
    if (isChrome) {
        document.getElementById("drinks").style.fontSize = "25px";
    }

</script>

<div class="container nav_bar_space">
    <div class="row">
        <#nested>
    </div>
</div>

<div class="container">
    <hr>
    <!-- Footer -->
    <footer id="footer">
        <div class="container">
            <div class="row" style="color: #000;">
                <div class="grid_12">
                    <div class="socials">
                        <script>
                            if(!isChrome){
                                document.write("<a href=\"#\" class=\"fa fa-twitter\"></a>")
                                document.write("<a href=\"#\" class=\"fa fa-facebook\"></a>")
                            } else {
                                document.write("<a href=\"#\" class=\"fa fa-facebook chromeOnly\"></a>")
                                document.write("<a href=\"#\" class=\"fa fa-twitter chromeOnly\"></a>")
                            }
                        </script>


                        <a href="#" class="fa fa-google-plus"></a>
                        <a href="#" class="fa fa-pinterest"></a>
                    </div>

                    <script>
                        if (!isChrome) {
                            document.write("<div class=\"copyright\"><span class=\"brand\">Testaholic Brewery</span> &copy; <span id=\"copyright-year\"></span> | <a href=\"#\">Privacy Policy</a></div>");
                        }
                    </script>

                </div>
            </div>
        </div>
    </footer>

</div>
</body>
</html>
</#macro>