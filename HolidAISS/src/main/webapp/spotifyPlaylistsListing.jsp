<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/estiloplaylist.css">
<link rel="shortcut icon" href="/images/holidaiss.ico" />

<title>Tus playlists</title>
</head>
<body>
	<c:if test='${empty sessionScope["Spotify-token"]}'>
		<c:redirect url="/AuthController/Spotify" />
	</c:if>
	<ul id="menu">
		<li id="head"> Tus playlists de Spotify:</li>
        <li id="button2"><button type="button" onClick="javascript:window.location.href = '/'" class="button">Volver a Inicio</button></li>
        <li id="button1"><button type="button" onClick="javascript:window.location.href = '/spotifyPlaylistNew'" class="button">Crear una nueva playlist</button></li>
        </ul>
	<div class="container">

    <p class="message">${message}</p>

    <table id="listas">
        <c:forEach items="${playlists.items}" var="playlist">
            <tr>
                <td id="n"><b>Nombre de la playlist: </b><c:out value="${playlist.name}"/></td> 	               
                <td id="playlist"><iframe src="https://open.spotify.com/embed/playlist/<c:out value="${playlist.id}"/>" width="500" height="380" frameborder="0" allowtransparency="true" allow="encrypted-media"></iframe></td>								
 				<td id="uri"><b>Pega este enlace en tu navegador para acceder a la playlist en tu Spotify: </b><c:out value="${playlist.uri}"/></td>        
                </tr> 
        </c:forEach>			
    </table>
    <p>
        <button type="button" onClick="javascript:window.location.href = '/spotifyPlaylistNew'" class="button">Crear una nueva playlist</button>
        <button type="button" onClick="javascript:window.location.href = '/'" class="button">Volver a Inicio</button>
</div>
</body>
</html>