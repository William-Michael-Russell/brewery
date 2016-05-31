<#-- @ftlvariable name="user" type="java.util.Optional<net.testaholic.brewery.domain.user.User>" -->
<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="currentUser" type="net.testaholic.brewery.domain.user.CurrentUser" -->

<#--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>-->
<#--<%@ taglib prefix="updater" uri="http://www.springframework.org/tags/form"%>-->
<#import "/spring.ftl" as spring>
<@layout/>

<@nav_bar>
    <@admin/>
<div class="row">
    <style>

        label, input {
            display: block;
        }

        label {
            padding-top: 20px;
            /*margin-bottom: 20px;*/
        }

        label, select {
            display: block;
        }

        select {
            -webkit-appearance: none;
            -moz-appearance: none;
            appearance: none;
            margin-top: 20px;
        }


    </style>


    <form name="form" role="form" action="" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <h2 class="form-signin-heading">Create New User...</h2>


        <@spring.bind "updater" />
        <#if spring.status.error>
            <ul>
                <#list spring.status.errorMessages as error>

                    <div class="alert alert-danger">
                        <p>${error}</p>
                    </div>

                </#list>
            </ul>
        </#if>

        <div>
            <label for="email" class="col-md-2">Email</label>
            <input type="email" value="${user.get().email}" name="email" id="email" class="form-control col-md-6"
                   placeholder="Email Address" required
                   autofocus>
        </div>
        <br>
        <div>
            <label for="currentPassword" class="col-md-2">Current Password</label>
            <input name="currentPassword" id="currentPassword" class="form-control col-md-6" placeholder="Current password">
        </div>

        <div>
            <form:errors path="userName" cssClass="error" />
            <form:errors path="userName" cssClass="error" element="div" />
            <label for="password" class="col-md-2">New Password</label>
            <input name="password" id="password" class="form-control col-md-6" placeholder="New password">
        </div>

        <div>
            <label for="passwordRepeated" class="col-md-2">Verify new password</label>
            <input name="passwordRepeated" id="passwordRepeated" class="form-control col-md-6"
                   placeholder="Verify new password">
        </div>

        <br>
        <div>
            <label class="col-md-1" for="role">Role</label>
            <select class="col-md-6" name="role" id="role" required>
                <option <#if user.get().role == 'USER'>selected</#if>>USER</option>
                <#if currentUser?? && currentUser.role == "ADMIN">
                    <option <#if user.get().role == 'ADMIN'>selected</#if>>ADMIN</option>
                </#if>

            </select>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Save</button>
    </form>


</div>



</@nav_bar>