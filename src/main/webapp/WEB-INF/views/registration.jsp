<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Personal Coach</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<jsp:include page="header.jsp"/>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-6 col-md-offset-3">
            <form:form action="/registration/save" method="POST" modelAttribute="registration" class="form-horizontal">
                <fieldset>

                    <!-- Form Name -->
                    <legend>Form Name</legend>

                    <form:hidden path="id"/>

                    <!-- First Name-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="name">First Name</label>
                        <div class="col-md-4">
                            <form:input path="firstname" id="name" placeholder="Enter your first name"
                                   class="name form-control input-md" required="required"
                                        pattern="[А-Яа-я-[A-Za-z]]{2,50}" cssErrorClass="error form-control"/>
                        </div>
                    </div>

                    <!-- Last Name-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="lastname">Last Name</label>
                        <div class="col-md-4">
                            <form:input path="lastname" id="lastname" placeholder="Enter your last name"
                                        class="name form-control input-md" required="required"
                                        pattern="[А-Яа-я-[A-Za-z]]{2,50}" cssErrorClass="error form-control"/>
                        </div>
                    </div>

                    <!-- Email input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="email">Email</label>
                        <div class="col-md-4">
                            <form:input path="email" id="email" placeholder="Enter your email"
                                        class="name form-control input-md" required="required"
                                        cssErrorClass="error form-control"/>

                        </div>
                    </div>

                    <!-- Login input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="login">Login</label>
                        <div class="col-md-4">
                            <form:input path="login" id="login" placeholder="Enter your login"
                                        class="name form-control input-md" required="required"
                                        pattern="[А-Яа-я-[A-Za-z]]{2,50}" cssErrorClass="error form-control"/>
                        </div>
                    </div>

                    <!-- Password input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="password">Password</label>
                        <div class="col-md-4">
                            <form:input path="password" id="password" placeholder="Enter your password"
                                        class="name form-control input-md" required="required"
                                        pattern="[А-Яа-я-[A-Za-z]]{2,50}" cssErrorClass="error form-control"/>
                        </div>
                    </div>

                    <!-- Select Role -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="role">I want to</label>
                        <div class="col-md-4">
                            <form:select path="role" id="role" class="name form-control input-md" required="required"
                                         cssErrorClass="error form-control">
                                <form:option value="ROLE_COACH">Become a Coach</form:option>
                                <form:option value="ROLE_CLIENT">Find a Coach</form:option>
                            </form:select>
                        </div>
                    </div>

                    <!-- Button -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="signup"></label>
                        <div class="col-md-4">
                            <input type="submit" id="signup" value="Sign up" class="btn btn-success"></input>
                        </div>
                    </div>

                </fieldset>
            </form:form>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>

<!-- jQuery -->
<script src="js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
