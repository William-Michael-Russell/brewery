<#-- @ftlvariable name="user" type="net.testaholic.brewery.domain.user.User" -->
<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<@layout>
<title>Myself</title>
</@layout>

<@nav_bar>
<section class="content">
    <div class="container">
        <div class="row">
            <@admin/>

            <h1>My Account</h1>
            <a href="/user/update/${user.id}">Edit Account</a>
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
        </div>
    </div>
</section>
</@nav_bar>