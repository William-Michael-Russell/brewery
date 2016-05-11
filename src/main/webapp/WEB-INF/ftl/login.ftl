<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="error" type="java.util.Optional<String>" -->

<@layout><title>Log in</title></@layout>


<@nav_bar>
<div class="container">

    <form class="form-signin" role="form" action="/login" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <h2 class="form-signin-heading">Please sign in</h2>
        <p>You can use: demo@localhost / demo</p>

        <label for="email" class="sr-only">Email address</label>
        <input type="email" name="email" id="email" class="form-control" placeholder="Email address" required autofocus>

        <label for="password" class="sr-only">Password</label>
        <input name="password" id="password" class="form-control" placeholder="Password" required>
        <div class="checkbox">
            <label>
                <input type="checkbox" for="remember-me" value="remember-me" name="remember-me" id="remember-me">
                Remember me
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>

</div> <!-- /container -->

    <#if error.isPresent()>
    <p>The email or password you have entered is invalid, try again.</p>
    </#if>
</@nav_bar>
