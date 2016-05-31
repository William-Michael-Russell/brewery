<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="users" type="java.util.List<net.testaholic.brewery.domain.User>" -->
<#-- @ftlvariable name="currentUser" type="net.testaholic.brewery.domain.user.CurrentUser" -->
<@layout>
<title>List of Users</title>
</@layout>


<@nav_bar>
    <@admin/>

<h1>List of Users</h1>


<table class="table table-striped">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <thead>
    <tr>
        <th>Id</th>
        <th>Email</th>
        <th>Role</th>
        <#if currentUser?? && currentUser.role == 'ADMIN'>
            <th>Edit user</th>
        </#if>
    </tr>
    </thead>
    <tbody>

        <#list users as user>
        <tr>
            <th scope="row">1</th>
            <td><a href="/user/${user.id}">${user.email}</a></td>
            <td>${user.role}</td>
            <#if currentUser?? && currentUser.role == 'ADMIN'>
                <td><a href="/user/update/${user.id}"</a>Edit</td>
            </#if>

        </tr>
        </#list>
    </tbody>
</table>

</@nav_bar>