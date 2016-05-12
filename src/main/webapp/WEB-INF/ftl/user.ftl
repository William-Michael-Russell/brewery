<#-- @ftlvariable name="user" type="net.testaholic.brewery.domain.user.User" -->
<@layout>
<title>Myself</title>
</@layout>

<@nav_bar>
<h1>My Account</h1>


<table class="table table-striped">
    <thead>
    <tr>
        <th>Id</th>
        <th>Email</th>
        <th>Role</th>
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