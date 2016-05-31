<#-- @ftlvariable name="bartender" type="net.testaholic.brewery.domain.bartender.Bartender" -->
<@layout>
<title>Myself</title>
</@layout>

<@nav_bar>
<section class="content">
    <div class="container">
        <div class="row">
            <@admin/>

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
                    <td>${bartender.bartenderName}</a></td>
                    <td>${bartender.bartenderBio}</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</section>
    <@admin/>
</@nav_bar>