<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="currentUser" type="net.testaholic.brewery.domain.CurrentUser" -->
<@layout>
<title>Testaholic.net Brewery</title>
</@layout>
<@nav_bar>
<nav role="navigation">
    <ul>
        <#if !currentUser??>
            <div class="container">

                <form class="form-signin" role="form" action="/login" method="post">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                    <h2 class="form-signin-heading">Please sign in</h2>
                    <p>You can use: demo@localhost / demo</p>

                    <label for="email" class="sr-only">Email address</label>
                    <input type="email" name="email" id="email" class="form-control" placeholder="Email address"
                           required autofocus>

                    <label for="password" class="sr-only">Password</label>
                    <input type="password" name="password" id="password" class="form-control" placeholder="Password"
                           required>
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" for="remember-me" value="remember-me" name="remember-me"
                                   id="remember-me"> Remember me
                        </label>
                    </div>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                </form>

            </div> <!-- /container -->
        </#if>
        <#if currentUser??>
            <li><a href="/users">View all users</a></li>
            <li><a href="/user/${currentUser.id}">View myself</a></li>
        </#if>
        <#if currentUser?? && currentUser.role == "ADMIN">
            <li><a href="/user/create">Create a new user</a></li>
        </#if>
    </ul>
</nav>
</@nav_bar>
