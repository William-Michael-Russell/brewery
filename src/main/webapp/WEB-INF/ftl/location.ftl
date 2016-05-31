<#-- @ftlvariable name="location" type="net.testaholic.brewery.domain.location.Location" -->
<@layout>
<title>Store Location</title>
</@layout>


<@nav_bar>
<!-- Page Content -->
    <@admin/>
<section class="content ctn__1">
    <div class="container">
        <div class="row">
            <div class="grid_12">
                <h2>${location.storeTitle}</h2>
                <div class="map">
                    <div class="row">
                        <div class="grid_9">
                            <figure class="">
                                <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d24214.807650104907!2d-73.94846048422478!3d40.65521573400813!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sen!2sus!4v1395650655094" style="border:0"></iframe>
                            </figure>
                        </div>
                        <div class="grid_3">
                            <script>
                                if(!isFirefox){
                                    document.write("<div class=\"map_block\"><div class=\"map_title\">Address:</div>${location.storeAddress}</div>");
                                }
                            </script>

                            <div class="map_block">
                                <div class="map_title">Phone:</div>
                                ${location.storePhoneNumber}
                            </div>
                            <div class="map_block">
                                <div class="map_title">Email:</div>
                                ${location.storeEmail}
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <script>
                if(isChrome){
                    document.write("<div class=\"grid_8\"><p>${location.storeDescription}</p></div>");
                }else{
                    document.write("<div class=\"grid_8\"><p>come get smashed with us!!</p></div>");

                }
            </script>

        </div>
    </div>
</section>
</@nav_bar>