<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="form" type="net.testaholic.brewery.domain.user.UserCreateForm" -->
<#import "/spring.ftl" as spring>
<@layout/>

<@nav_bar>

    <form name="form" role="form" action="" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <h2 class="form-signin-heading">Create New User...</h2>
        <div>
            <label for="email" class="sr-only">Email address</label>
            <input type="email" value="${form.email}" name="email" id="email" class="form-control"
                   placeholder="Email address" required
                   autofocus>
        </div>

        <label for="password" class="sr-only">Password</label>
        <input name="password" id="password" class="form-control" placeholder="Password" required>

        <label for="passwordRepeated" class="sr-only">Repeat</label>
        <label for="role">Role</label>
        <select name="role" id="role" required>
            <option <#if form.role == 'USER'>selected</#if>>USER</option>
            <option <#if form.role == 'ADMIN'>selected</#if>>ADMIN</option>
            <option <#if form.role == 'ADMIN'>selected</#if>>MEMBER</option>
        </select>
        <input name="passwordRepeated" id="passwordRepeated" class="form-control" placeholder="Verify Password">
        <div>

        </div>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Save</button>
    </form>

    <@spring.bind "form" />
    <#if spring.status.error>
        <ul>
            <#list spring.status.errorMessages as error>
                <li>${error}</li>
            </#list>
        </ul>
    </#if>

</@nav_bar>