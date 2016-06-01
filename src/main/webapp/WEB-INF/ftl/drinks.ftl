<#-- @ftlvariable name="drinks" type="java.util.List<net.testaholic.brewery.domain.drink.Drink>" -->
<@layout>
<title>List of Drinks</title>
</@layout>


<@nav_bar>
<section class="content gallery pad1">
    <div class="container">
        <div class="row">

            <#list drinks as drink>

                <#if drink?counter % 4 ==  0>
                    <div class="clear sep__1"></div>
                </#if>
                <div class="grid_4">
                    <div class="gall_block">
                        <div class="maxheight">
                            <a href="${drink.drinkImageUrl}" class="gall_item"><img src="${drink.drinkImageUrl}" alt=""></a>
                            <div class="gall_bot">
                                <div class="text1"><a href="#">${drink.drinkIngredients} </a></div>
                            ${drink.drinkIngredients}
                                <br>
                                <a href="/drink/${drink.id}" class="btn">more</a></div>
                        </div>
                    </div>
                </div>



            <#--<tr>-->
            <#--<th scope="row">1</th>-->
            <#--<td><a href="/bartender/${bartender.id}">${bartender.drinkName}</a></td>-->
            <#--<td><a href="/bartender/${bartender.id}"><img src="${bartender.drinkImageUrl}" class="img-circle" width="304" height="236"></a></td>-->
            <#--<td>${bartender.drinkIngredients}</td>-->
            <#--</tr>-->
            </#list>

        <#--<div class="grid_4">-->
        <#--<div class="gall_block">-->
        <#--<div class="maxheight">-->
        <#--<a href="/static/images/bbig1.jpg" class="gall_item"><img src="/static/images/page2_img1.jpg" alt=""></a>-->
        <#--<div class="gall_bot">-->
        <#--<div class="text1"><a href="#">Vivamus at magna non nunc </a></div>-->
        <#--Rehoncus. Aliquam nibh antegestas id ictum a, commodo. Praesenterto faucibus maleada faucibusnec laeet metus id laoreet-->
        <#--<br>-->
        <#--<a href="#" class="btn">more</a></div>-->
        <#--</div>-->
        <#--</div>-->
        <#--</div>-->
        <#--<div class="grid_4">-->
        <#--<div class="gall_block">-->
        <#--<div class="maxheight">-->
        <#--<a href="/static/images/big3.jpg" class="gall_item"><img src="/static/images/page2_img2.jpg" alt=""></a>-->
        <#--<div class="gall_bot">-->
        <#--<div class="text1"><a href="#">Divamus at magna non nunce </a></div>-->
        <#--Kehoncus. Aliquam nibh antegestas id ictum a, commodo. Praesenterto faucibus maleada faucibusnec laeet metus id laoreet-->
        <#--<br>-->
        <#--<a href="#" class="btn">more</a></div>-->
        <#--</div>-->
        <#--</div>-->
        <#--</div>-->
        <#--<div class="grid_4">-->
        <#--<div class="gall_block">-->
        <#--<div class="maxheight">-->
        <#--<a href="/static/images/bbig3.jpg" class="gall_item"><img src="/static/images/page2_img3.jpg" alt=""></a>-->
        <#--<div class="gall_bot">-->
        <#--<div class="text1"><a href="#">Livamus at magna non nunc </a></div>-->
        <#--Tehoncus. Aliquam nibh antegestas id ictum a, commodo. Praesenterto faucibus maleada faucibusnec laeet metus id laoreeto-->
        <#--<br>-->
        <#--<a href="#" class="btn">more</a></div>-->
        <#--</div>-->
        <#--</div>-->
        <#--</div>-->
        <#--<div class="clear sep__1"></div>-->
        <#--<div class="grid_4">-->
        <#--<div class="gall_block">-->
        <#--<div class="maxheight">-->
        <#--<a href="/static/images/bbig4.jpg" class="gall_item"><img src="/static/images/page2_img4.jpg" alt=""></a>-->
        <#--<div class="gall_bot">-->
        <#--<div class="text1"><a href="#">Sivamus at magna non nute </a></div>-->
        <#--Rehoncus. Aliquam nibh antegestas id ictum a, commodo. Praesenterto faucibus maleada faucibusnec laeet metus id laoreetet-->
        <#--<br>-->
        <#--<a href="#" class="btn">more</a></div>-->
        <#--</div>-->
        <#--</div>-->
        <#--</div>-->
        <#--<div class="grid_4">-->
        <#--<div class="gall_block">-->
        <#--<div class="maxheight">-->
        <#--<a href="/static/images/bbig5.jpg" class="gall_item"><img src="/static/images/page2_img5.jpg" alt=""></a>-->
        <#--<div class="gall_bot">-->
        <#--<div class="text1"><a href="#">Kivamus at magna non nunj </a></div>-->
        <#--Aliquam nibh antegestas id ictum a, commodo. Praesenterto faucibus maleada faucibusnec laeet metus id laoreet-->
        <#--<br>-->
        <#--<a href="#" class="btn">more</a></div>-->
        <#--</div>-->
        <#--</div>-->
        <#--</div>-->
        <#--<div class="grid_4">-->
        <#--<div class="gall_block">-->
        <#--<div class="maxheight">-->
        <#--<a href="/static/images/bbig6.jpg" class="gall_item"><img src="/static/images/page2_img6.jpg" alt=""></a>-->
        <#--<div class="gall_bot">-->
        <#--<div class="text1"><a href="#">Vivamus at magna non nunc </a></div>-->
        <#--Rehoncus. Aliquam nibh antegestas id ictum a, commodo. Praesenterto faucibus maleada faucibusnec laeet metus id laoreet-->
        <#--<br>-->
        <#--<a href="#" class="btn">more</a></div>-->
        <#--</div>-->
        <#--</div>-->
        <#--</div>-->
        <#--<div class="clear sep__1"></div>-->
        <#--<div class="grid_4">-->
        <#--<div class="gall_block">-->
        <#--<div class="maxheight">-->
        <#--<a href="/static/images/bbig7.jpg" class="gall_item"><img src="/static/images/page2_img7.jpg" alt=""></a>-->
        <#--<div class="gall_bot">-->
        <#--<div class="text1"><a href="#">Mivamus at magna non nunc </a></div>-->
        <#--Lehoncus. Aliquam nibh antegestas id ictum a, commodo. Praesenterto faucibus maleada faucibusnec laeet metus id laor-->
        <#--<br>-->
        <#--<a href="#" class="btn">more</a></div>-->
        <#--</div>-->
        <#--</div>-->
        <#--</div>-->
        <#--<div class="grid_4">-->
        <#--<div class="gall_block">-->
        <#--<div class="maxheight">-->
        <#--<a href="/static/images/bbig8.jpg" class="gall_item"><img src="/static/images/page2_img8.jpg" alt=""></a>-->
        <#--<div class="gall_bot">-->
        <#--<div class="text1"><a href="#">Nivamus at magna non nunc </a></div>-->
        <#--Rehoncus. Aliquam nibh antegestas id ictum a, commodo. Praesenterto faucibus maleada faucibusnec laeet metus id laorees-->
        <#--<br>-->
        <#--<a href="#" class="btn">more</a></div>-->
        <#--</div>-->
        <#--</div>-->
        <#--</div>-->
        <#--<div class="grid_4">-->
        <#--<div class="gall_block">-->
        <#--<div class="maxheight">-->
        <#--<a href="/static/images/bbig9.jpg" class="gall_item"><img src="/static/images/page2_img9.jpg" alt=""></a>-->
        <#--<div class="gall_bot">-->
        <#--<div class="text1"><a href="#">Amusat magna non nunc </a></div>-->
        <#--Oehoncus. Gliquam nibh antegestas id ictum a, commodo. Praesenterto faucibus maleada faucibusnec laeet metus id laore-->
        <#--<br>-->
        <#--<a href="#" class="btn">more</a></div>-->
        <#--</div>-->
        <#--</div>-->
        <#--</div>-->
        </div>
    </div>
</section>
</@nav_bar>