<#-- @ftlvariable name="user" type="net.testaholic.brewery.domain.User" -->
<@layout>
<title>Myself</title>
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

        <tr>
            <th scope="row">1</th>
            <td>${user.email}</a></td>
            <td>${user.role}</td>
        </tr>
    </tbody>
</table>
</@nav_bar>