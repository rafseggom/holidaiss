<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="includes/header.jsp"%>
<c:if test='${empty sessionScope["Spotify-token"]}'>
    <c:redirect url = "/AuthController/Spotify"/>
</c:if>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="dns-prefetch" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css?family=Raleway:300,400,600" rel="stylesheet" type="text/css">

    <link rel="stylesheet" href="css/styleCreate.css">

    <link rel="icon" href="Favicon.png">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

</head>
<body>


<main class="login-form">
    <div class="cotainer">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">Creación de playlist en Spotify</div>
                    <div class="card-body">
                        <form id="f" action="/spotifyPlaylistNew" method="post">
                            <div class="form-group row">
                                <label for="name" id ="n1" class="col-md-4 col-form-label text-md-right">Nombre de la playlist</label>
                                <div class="col-md-6">
                                    <input type="text" id="n2" class="form-control" name="name" required autofocus>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="description" id ="d1" class="col-md-4 col-form-label text-md-right">Descripción de la playlist</label>
                                <div class="col-md-6">
                                    <input type="text" id="d2" class="form-control" name="description" required>
                                </div>
                            </div>

                            <div class="botones">
                                <button type="submit" id = "b1" class="btn btn-primary">
                                    Confirmar creación
                                </button>
                                <button type="button" onClick="javascript:window.location.href = '/'" id="b2" class="btn btn-primary">Volver a Inicio</button>
                            </div>
                            </form>
                   		</div>
                </div>
            </div>
        </div>
    </div>

</main>







</body>
</html>

<%@include file="includes/footer.jsp"%>
