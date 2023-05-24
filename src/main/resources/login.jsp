<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org"
      th:replace="base::layout(~{::section})">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>Login page</h1>
<!--///yo print hudaina-->
<!--//section vitra j j xa tao matra print hunxa-->
<section>

    <div class="container p-5">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <div class="card">
                    <div class="card-header text-center fs-4">Login Page</div>
                    <div class="card-body">
                        <form action="/login" method="post">

                            <div class="mb-3">
                                <label>Enter Email</label> <input type="text" name="username"
                                                                  class="form-control">
                            </div>


                            <div class="mb-3">
                                <label>Enter Password</label> <input type="text"
                                                                     name="password" class="form-control">
                            </div>
                            <button class="btn btn-primary col-md-12">Login</button>
                            <a th:href="@{register}">Dont have a account. Register</a>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </div>



</section>
</body>
</html>