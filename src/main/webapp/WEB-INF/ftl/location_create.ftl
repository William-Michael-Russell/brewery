<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="form" type="java.util.Optional<net.testaholic.brewery.domain.location.Location>" -->
<#import "/spring.ftl" as spring>
<@layout/>

<@nav_bar>
    <@admin/>
<div class="col-md-12">

<form name="form" role="form" action="" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <h2 class="form-signin-heading">Update Store Location...</h2>

        <div>
            <label for="storeTitle" >Store title</label>
            <input type="text" size="100" value="${form.get().storeTitle}" name="storeTitle" id="storeTitle"
                   class="form-control"
                   placeholder="Store title" required
                   autofocus>
        </div>
        <br>
        <div>
            <label for="storeAddress" >Store storeAddress</label>
            <input type="text" size="100" value="${form.get().storeAddress}" name="storeAddress" id="storeAddress"
                   class="form-control"
                   placeholder="Store storeAddress" required
                   autofocus>
        </div>
        <br>
        <div>
            <label for="storePhoneNumber" >Store Phone Number</label>
            <input type="text" size="100" value="${form.get().storePhoneNumber}" name="storePhoneNumber"
                   id="storePhoneNumber" class="form-control"
                   placeholder="Store Phone number" required
                   autofocus>
        </div>
        <br>
        <div>
            <label for="storeEmail" >Store Phone Number</label>
            <input type="text" size="100" value="${form.get().storeEmail}" name="storeEmail" id="storeEmail"
                   class="form-control"
                   placeholder="Store email" required
                   autofocus>
        </div>
        <br>
        <div>
            <label for="storeDescription" >Store Phone Number</label>
            <input type="text" size="100" value="${form.get().storeDescription}" name="storeDescription"
                   id="storeDescription" class="form-control"
                   placeholder="Store description" required
                   autofocus>
        </div>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Save</button>
    </form>
</div>


    <@spring.bind "form" />
    <#if spring.status.error>
    <ul>
        <#list spring.status.errorMessages as error>
            <li>${error}</li>
        </#list>
    </ul>
    </#if>

</@nav_bar>