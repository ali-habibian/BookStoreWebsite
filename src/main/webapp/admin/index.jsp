<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/style.css">
    <script src="../js/bootstrap.min.js"></script>
    <title>Bookstore Administration</title>
</head>
<body class="container text-center">
<jsp:directive.include file="header.jsp"/>

<div>
    <h2 class="mt-4">Administrative Dashboard</h2>
</div>

<div class="pt-3">
    <hr class="row col-9 mx-auto"/>
    <div class="row mx-auto text-center justify-content-center">
        <h3 class="mb-2">Quick Actions:</h3>
            <a class="btn btn-dark p-1 me-2 col-2 text-white" href="#">New Book</a>
            <a class="btn btn-dark p-1 me-2 col-2 text-white" href="#">New User</a>
            <a class="btn btn-dark p-1 me-2 col-2 text-white" href="#">New Category</a>
            <a class="btn btn-dark p-1 me-2 col-2 text-white" href="#">New Customer</a>
    </div>
</div>

<div class="pt-3">
    <hr class="row col-9 mx-auto"/>
    <div class="row mx-auto text-center justify-content-center">
        <h3 class="mb-2">Recent Sales:</h3>
    </div>
</div>

<div class="pt-3">
    <hr class="row col-9 mx-auto"/>
    <div class="row mx-auto text-center justify-content-center">
        <h3 class="mb-2">Recent Reviews:</h3>
    </div>
</div>

<div class="pt-3">
    <hr class="row col-9 mx-auto"/>
    <h3 class="mb-2">Statics:</h3>

    <hr class="row col-9 mx-auto"/>
</div>

<jsp:directive.include file="footer.jsp"/>
</body>
</html>
