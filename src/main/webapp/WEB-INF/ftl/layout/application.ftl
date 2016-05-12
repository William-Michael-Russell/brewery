<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="drinkForm" type="net.testaholic.brewery.domain.drink.DrinkCreateForm" -->
<#-- @ftlvariable name="currentUser" type="net.testaholic.brewery.domain.user.CurrentUser" -->
<#macro layout>
<!doctype html>
<html lang="en">
<head>

    <style>html, body {
        width: auto !important;
        overflow-x: hidden !important;
    }</style>


    <meta name="viewport"
          content="user-scalable=no, initial-scale=1, maximum-scale=1, minimum-scale=1, width=320, height=device-height, target-densitydpi=medium-dpi"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
<#--<meta name="viewport" content="width=device-width, initial-scale=1">-->

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css"/>
</head>
</#macro>

<#macro nav_bar>
<body>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<div class="container">
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container center-block">
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse center-block" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav center-block">
                    <li>
                        <a href="/">Home</a>
                    </li>

                    <li>
                        <a href="/drinks" id="custom-tag">Drinks</a>
                    </li>
                    <li>
                        <a href="#">Appetizers</a>
                    </li>
                    <li>
                        <a href="#">Locations</a>
                    </li>
                    <#if currentUser??>
                        <li>
                            <form action="/logout" method="post">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <button class="btn btn-warning center-block" type="submit">Log out</button>
                            </form>
                        </li>
                    </#if>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    <br>
    <br>
    <br>
</div>

<!-- Page Content -->
<div class="container">
    <div class="row">
        <#if currentUser??>
            <div class="col-md-3">
                <#if currentUser?? && currentUser.role == "USER">
                    <p class="lead">User Panel</p>
                    <div class="list-group">

                        <a href="/" class="list-group-item">Home</a>
                        <a href="/user/${currentUser.id}" class="list-group-item">My Account</a>
                        <a href="/users" class="list-group-item">View al users</a>
                    </div>

                <#elseif currentUser?? && currentUser.role == "ADMIN">
                    <p class="lead">Admin Panel</p>
                    <div class="list-group">
                        <a href="/drink/create" class="list-group-item">Add ne user</a>
                        <a href="/user/create" class="list-group-item">Add new drink.</a>
                        <a href="/user/${currentUser.id}" class="list-group-item">View all users</a>
                        <a href="/users" class="list-group-item">My Account</a>

                    </div>
                </#if>


            </div>
        </#if>
        <div class="col-md-9">
            <#nested>
        </div>
    </div>


</div>

<div class="container">
    <hr>
    <!-- Footer -->
    <footer>
        <div class="row">
            <div class="col-lg-12">
                <p>Copyright &copy; Testaholic.net 2016 * Brewery</p>
            </div>
        </div>
    </footer>

</div>
</body>
</html>
</#macro>