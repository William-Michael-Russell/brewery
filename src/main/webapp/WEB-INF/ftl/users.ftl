<#-- @ftlvariable name="users" type="java.util.List<eu.kielczewski.example.domain.User>" -->
<@layout>
<title>List of Users</title>
</@layout>


<@nav_bar>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
        <li><a href="/user/create">Create a new user</a></li>
    </ul>
</nav>

<h1>List of Users</h1>


<table class="table table-striped">
    <thead>
    <tr>
        <th>#</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Username</th>
    </tr>
    </thead>
    <tbody>

        <#list users as user>
        <tr>
            <th scope="row">1</th>
            <td><a href="/user/${user.id}">${user.email}</a></td>
            <td>${user.role}</td>
        </tr>
        </#list>
    </tbody>
</table>
</@nav_bar>