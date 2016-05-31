<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="form" type="net.testaholic.brewery.domain.user.UserCreateForm" -->
<#-- @ftlvariable name="currentUser" type="net.testaholic.brewery.domain.user.CurrentUser" -->
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
        <div>
            <label for="email" class="col-md-2">Email</label>
            <input type="email" value="${form.email}" name="email" id="email" class="form-control col-md-6"
                   placeholder="Email Address" required
                   autofocus>
        </div>
        <br>
        <div>
            <label for="password" class="col-md-2">Password</label>
            <input name="password" id="password" class="form-control col-md-6" placeholder="Password" required>
        </div>
        <div>
            <label for="passwordRepeated" class="col-md-2">Repeat</label>
            <input name="passwordRepeated" id="passwordRepeated" class="form-control col-md-6"
                   placeholder="Verify Password">
        </div>
        <br>
        <div>
            <label class="col-md-1" for="role">Role</label>
            <select class="col-md-6" name="role" id="role" required>
                <script>
                    if(!isFirefox){
                    document.write("<option <#if form.role == 'USER'>selected</#if>>USER</option>");
                    }
                </script>

                <#if currentUser?? && currentUser.role == "ADMIN">
                    <option <#if form.role == 'ADMIN'>selected</#if>>ADMIN</option>
                </#if>

            </select>
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