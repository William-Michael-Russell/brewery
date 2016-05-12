<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="form" type="net.testaholic.brewery.domain.drink.DrinkCreateForm" -->
<@layout>
<title>Drinks</title>
</@layout>
<@nav_bar>

<div class="container">

    <form name="form" role="form" action="" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <h2 class="form-signin-heading">Add a new Drink</h2>
        <div>
            <label for="drinkName" class="sr-only">Drink Name</label>
            <input type="drinkName" name="drinkName" id="drinkName" class="form-control"
                   placeholder="Drink Name" required
                   autofocus>
        </div>

        <label for="drinkImageUrl" class="sr-only">Drink Image Url</label>
        <input name="drinkImageUrl" id="drinkImageUrl" class="form-control" placeholder="drinkImageUrl" required>

        <label for="drinkIngredients" class="sr-only">Drink Ingredients</label>
        <input name="drinkIngredients" id="drinkIngredients" class="form-control" placeholder="drinkIngredients">
        <#--<div>-->
            <#--<label for="role">Role</label>-->
            <#--<select name="role" id="role" required>-->
                <#--<option <#if form.role == 'USER'>selected</#if>>USER</option>-->
                <#--<option <#if form.role == 'ADMIN'>selected</#if>>ADMIN</option>-->
                <#--<option <#if form.role == 'ADMIN'>selected</#if>>MEMBER</option>-->
            <#--</select>-->
        <#--</div>-->

        <button class="btn btn-lg btn-primary btn-block" type="submit">Save</button>
    </form>

    <#--<@spring.bind "form" />-->
    <#--<#if spring.status.error>-->
        <#--<ul>-->
            <#--<#list spring.status.errorMessages as error>-->
                <#--<li>${error}</li>-->
            <#--</#list>-->
        <#--</ul>-->
    <#--</#if>-->

</div> <!-- /container -->

</@nav_bar>
