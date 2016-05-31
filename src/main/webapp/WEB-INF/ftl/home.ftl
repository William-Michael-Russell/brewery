<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="currentUser" type="net.testaholic.brewery.domain.user.CurrentUser" -->
<@layout>
<title xmlns="http://www.w3.org/1999/html">Testaholic.net Brewery</title>
</@layout>
<@nav_bar>






<div class="row">
    <div class="col-sm-4">
        <img src="/static/images/ice_cold_beer.png" width="450" height="300" alt="">
        <div class="bann_capt ">
            <div class="maxheight">
                <br>
                <img src="/static/images/pint.png" height="75" width="75" alt="">
                <div class="bann_title">Ice Cold Beer</div>
                <a href="#">more</a>
            </div>
        </div>
    </div>
    <div class="col-sm-4">
        <div class="bann_capt  bn__1">
            <div class="maxheight">
                <br>
                <img src="/static/images/food-2.png" alt="">
                <div class="bann_title">Amazing Appetizers</div>
                <a href="#">more</a>
            </div>
        </div>
        <img src="/static/images/pizza.png" alt="">
    </div>
    <div class="col-sm-4">
        <img src="/static/images/happy_hour.png" width="450" height="300" alt="">
        <div class="bann_capt  bn__2">
            <div class="maxheight">
                <br>
                <img src="/static/images/food-1.png" height="75" width="75" alt="">
                <div class="bann_title">Happy Hours <br> &amp; Offers</div>
                <a href="#">more</a>
            </div>
        </div>
    </div>
</div>

<div class="row">
    <div class="col-md-12">
        <div class="box">
            <div class="row">
                <div class="col-md-4 preffix_1">
                    <h2>Testaholic Brewery</h2>
                    <p>The worlds greatest testing platforms. <strong class="color1"><a
                            href="https://github.com/williamrussellajb/brewery"
                            rel="nofollow">Clone this on Github</a></strong>
                        <br>
                        This brewery application has multiple stages, please take a look at the branching.
                    </p>
                    <a href="http://testaholic.net" class="btn" target="_blank">more</a>
                </div>
                <div class="col-md-6">
                    <h2 class="ta__center">Get Smashed</h2>
                    <strong>Arrogant Bastard Ale -- On Tap!</strong><br>
                    A beer that exudes arrogance, with bold statements such as “you’re not worthy”, “you probably won’t
                    like this” and “fizzy yellow beer is for wussies.” This is a strong and complex ale that makes you
                    proud to claim American beer again! The aggressive hop content is balanced by the thick rich Crystal
                    malt body...not for the faint of heart. <br>
                    <a href="#" class="btn">more</a>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="row">
    <div class="col-md-12">
        <h2>Beer flights</h2>
    </div>
    <div class="gallery">
        <div class="col-md-4"><a href="/static/images/beer_flight1.png" class="gall_item"><img
                src="/static/images/beer_flight1.png" alt=""></a><a href="#" class="link1">+</a>
            <div class="clear"></div>
        </div>
        <div class="col-md-4"><a href="/static/images/beer_flight2.png" class="gall_item"><img
                src="/static/images/beer_flight2.png" alt=""></a><a href="#" class="link1">+</a>
            <div class="clear"></div>
        </div>
        <div class="col-md-4"><a href="/static/images/beer_flight3.png" class="gall_item"><img
                src="/static/images/beer_flight3.png" alt=""></a><a href="#" class="link1">+</a>
            <div class="clear"></div>
        </div>
    </div>
</div>
<br>
<div class="row col-md-12">
    <div class="clear sep__1"></div>
    <div class="col-md-4">
        <h2>Bartenders</h2>
        <script>
            if (isChrome) { // bug fix, this fixes the layout for chrome only
                document.write("<br>")
            }
        </script>
        <blockquote class="bq1">
            <img src="/static/images/billy.jpg" width="75" height="75" alt="" class="img_inner fleft noresize">
            <div class="extra_wrapper">
                <div class="bq_title color1">Bartender Billy</div>
                Join us for happy our! Amazing drinks and great food.
                <script>
                    if(!isChrome){
                        document.write("<a href=\"#\"><span class=\"fa fa-chevron-right\"></span>more bartenders</a>");
                    }
                </script>

            </div>
        </blockquote>
    </div>
    <div class="col-md-4">
        <h2>What’s new</h2>
        <script>
            if (isChrome) { // bug fix, this fixes the layout for chrome only
                document.write("<br>")
            }
        </script>
        <div class="block2">
            <time datetime="2016-10-03">11<br>June</time>
            <div class="extra_wrapper">
                <div class="text1"><a href="/bartender/3">Long Island Iced Tea </a></div>
                Tripple the amount of booze. This will make your night amazing.
            </div>
        </div>
        <div class="block2">
            <time datetime="2014-01-01">15<br>APR</time>
            <div class="extra_wrapper">
                <div class="text1"><a href="#"><strong>Cadillac Margarita</strong></a></div>
                Like it salty? Sour? Super strong? Come and get smashed with this one!
            </div>
        </div>
    </div>
    <div class="col-md-4">
        <br>
        <h2>Opening Hours</h2>
        <ul class="shed">
            <br>
            <li id="happy_hour"><span>Happy Hour:
            <script>
            if (isChrome) { // bug fix, this fixes the layout for chrome only
                document.write("<br>")
            }
        </script>
            </span> 4PM - 8PM
            </li>
            <li><span>Grill Menu:</span> 5PM - 12PM</li>
            <li><span>Live   Musiс:</span>
                <p>8PM - 2AM</p></li>
        </ul>
    </div>

<#--Bugs-->
    <script>
        if (isChrome) {
            document.getElementById("happy_hour").style.fontSize = "75px";
            document.getElementById("happy_hour").style.width = "375px";
        }

    </script>
</div>
</@nav_bar>
