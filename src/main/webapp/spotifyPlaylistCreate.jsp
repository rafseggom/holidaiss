<%@include file="includes/header.jsp"%>

<h1>Listas de Spotify</h1>

<div class="container">

    <p class="message">${message}</p>

       <h2>Lista de éxitos</h2>
       
            <br><br><br>
            				
        <c:forEach items="${playlists.items}" var="playlist">
        	  <img class="object_earth" src="${playlist.images.get(0).url}" width="200px">
        			&nbsp;&nbsp;&nbsp;				
           
        </c:forEach>			
    	<table>
	<tr>
	 <c:forEach items="${playlists.items}" var="playlist">
            <td width=200px align="center" >
                <h3>
                <a href="${playlist.externalUrls.spotify}" >${playlist.name}</a>
                
               	</h3>							
           </td>
             &nbsp;&nbsp;&nbsp;		
        </c:forEach>
    </tr>	
    </table>
    <p>
       <h3> <a href="/spotifyPlaylistsGet" class="button">Ver mis listas</a>&nbsp;&nbsp;&nbsp;
        <button type="button" onClick="javascript:window.location.href = '/'" class="button" style="width:50px; height:25px"> Volver</button></h3>
</div>

<%@include file="includes/footer.jsp"%>
