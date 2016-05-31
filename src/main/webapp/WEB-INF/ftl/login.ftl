<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="error" type="java.util.Optional<String>" -->

<@layout><title xmlns="http://www.w3.org/1999/html">Log in</title></@layout>


<@nav_bar>
<style>
    input[type=checkbox]
    {
        -webkit-appearance:checkbox;
    }
</style>

<nav role="navigation">
    <ul>
        <#if !currentUser??>
            <div class="row">
                <div class="container">

                    <form class="form-signin" role="form" action="/login" method="post">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                        <h2 class="form-signin-heading">Please sign in</h2>

                        <div>
                            <label for="email" class="col-md-2">Email</label>
                            <input type="email" name="email" id="email" class="form-control col-md-6"
                                   placeholder="Email Address" required
                                   autofocus>
                        </div>


                        <label for="password" class="col-md-2">Password</label>
                        <input type="password" name="password" id="password" class="form-control col-md-7"
                               placeholder="Password"
                               required/>

                        <input class="col-sm-1" type="checkbox" for="remember-me" value="remember-me" name="remember-me"
                               id="remember-me"/>
                        <label for="remember-me" class="col-sm-1">remember me</label>

                        <button class="btn col-md-2" type="submit">Sign in</button>
                    </form>

                </div> <!-- /container -->
            </div>
        </#if>
    </ul>

    <div>
        <p>not a member? <a href="/user/create">click here to sign up!</a></p>

    </div>
</nav>



<#--<#if currentUser?? && currentUser.role == "ADMIN">-->
<#--<li><a href="/user/create">Create a new user</a></li>-->
<#--<li><a href="/users">View all users</a></li>-->
<#--</#if>-->

<#--<div class="container">-->

<#--<form class="form-signin" role="form" action="/login" method="post">-->
<#--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->

<#--<h2 class="form-signin-heading">Please sign in</h2>-->
<#--<p>You can use: demo@localhost / demo</p>-->

<#--<label for="email" class="sr-only">Email storeAddress</label>-->
<#--<input type="email" name="email" id="email" class="form-control" placeholder="Email storeAddress" required autofocus>-->

<#--<label for="password" class="sr-only">Password</label>-->
<#--<input name="password" id="password" class="form-control" placeholder="Password" required>-->
<#--<div class="checkbox">-->
<#--<label>-->
<#--<input type="checkbox" for="remember-me" value="remember-me" name="remember-me" id="remember-me">-->
<#--Remember me-->
<#--</label>-->
<#--</div>-->
<#--<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>-->
<#--</form>-->

<#--</div> <!-- /container &ndash;&gt;-->

    <#if error.isPresent()>
    <p>The email or password you have entered is invalid, try again.</p>
    </#if>
</@nav_bar>
