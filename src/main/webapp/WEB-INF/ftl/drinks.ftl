<#-- @ftlvariable name="drinks" type="java.util.List<net.testaholic.brewery.domain.User>" -->
<@layout>
<title>List of Drinks</title>
</@layout>


<@nav_bar>

<h1>All Drinks</h1>


<table class="table table-striped">
    <thead>
    <tr>
        <th>#</th>
        <th>Drink Name</th>
        <th>Image</th>
        <th>Ingredients</th>
    </tr>
    </thead>
    <tbody>

        <#list drinks as drink>
        <tr>
            <th scope="row">1</th>
            <td><a href="/drink/${drink.id}">${drink.drinkName}</a></td>
            <td><a href="/drink/${drink.id}"><img src="${drink.drinkImageUrl}" class="img-circle" width="304" height="236"></a></td>
            <td>${drink.drinkIngredients}</td>
        </tr>
        </#list>
    </tbody>
</table>
</@nav_bar>