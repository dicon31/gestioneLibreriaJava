<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="it">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Trova il tuo account</title>
    <style>
        .box { margin: 0 auto; }
    </style>
</head>
<body>
    <div class="container">
        <jsp:include page="template/header.jsp"></jsp:include>
        <div class="col-12 col-md-5">
            <h2>Trova il tuo account</h2>
            <jsp:include page="include/alert.jsp"></jsp:include>
            <form method="post" action="./dimenticaPassword">
                <div class="mb-3">
                    <p>Inserisci l'e-mail per cercare il tuo account.</p>
                    <label for="email">Email</label>
                    <input type="email" name="email" id="email_val" class="form-control" required>
                </div>
                <div class="mb-3">
                    <input type="submit" value="Cerca" class="btn btn-primary">
                </div>
            </form>
        </div>
        <jsp:include page="template/footer.jsp"></jsp:include>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>