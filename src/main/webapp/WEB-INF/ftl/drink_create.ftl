<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="drinkForm" type="net.testaholic.brewery.domain.bartender.BartenderCreateForm" -->
<#import "/spring.ftl" as spring>
<@layout>
<title>Drinks</title>
</@layout>
<@nav_bar>

<section class="content">
    <div class="container">
        <div class="row">
            <@admin/>

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
                <input name="drinkImageUrl" id="drinkImageUrl" class="form-control" placeholder="drinkImageUrl"
                       required>

                <label for="drinkIngredients" class="sr-only">Drink Ingredients</label>
                <input name="drinkIngredients" id="drinkIngredients" class="form-control"
                       placeholder="drinkIngredients">

                <button class="btn btn-lg btn-primary btn-block" type="submit">Save</button>
            </form>
        </div> <!-- /container -->
    </div>
</section>

</@nav_bar>
