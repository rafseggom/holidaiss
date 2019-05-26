<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<meta charset='UTF-8'>
<meta name='viewport'
	content='width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no' />
<link rel='stylesheet' type='text/css' href='sdk/map.css' />
<link rel='stylesheet' type='text/css' href='elements.css' />
<script type='text/javascript' src='js/form.js'></script>
<script type='text/javascript' src='sdk/tomtom.min.js'></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name='viewport'
	content='initial-scale=1,maximum-scale=1,user-scalable=no' />
<script
	src='https://api.tiles.mapbox.com/mapbox-gl-js/v0.54.0/mapbox-gl.js'></script>
<link
	href='https://api.tiles.mapbox.com/mapbox-gl-js/v0.54.0/mapbox-gl.css'
	rel='stylesheet' />
<style>
body {
	margin: 0;
	padding: 0;
}

#map {
	width: 500px;
	height: 500px;
}

#map {
	position: center;
	top: 0;
	bottom: 0;
}
</style>
<link rel="stylesheet" type="text/css" href="css/stylesuccess.css">
<link rel="shortcut icon" href="/images/holidaiss.ico" />
<title>Search results</title>
</head>
<body>

	<!-- Guardar resultado para la búsqueda en Spotify -->

	<c:forEach items="${requestScope.searchQuery}" var="query">
	</c:forEach>
	<table>
		<tr>
			<td width=30%><br> <!-- Mostrar resultado de la búsqueda en Amadeus -->

				<h2>
					Aeropuertos encontrados en :
					<c:out value="${param.searchQuery}" />
				</h2> <c:forEach items="${requestScope.flights}" var="flight">

					<span><b>Aeropuerto de origen:</b> <c:out
							value="${flight.origin}" /></span>
					<br>
					<br>
					<span><b>Aeropuerto de destino:</b> <c:out
							value="${flight.destination}" /></span>
					<br>
					<br>
					<span><b>Fecha Salida:</b> <c:out
							value="${flight.departureDate}" /></span>
					<br>
					<br>
					<span><b>Fecha vuelta:</b> <c:out
							value="${flight.returnDate}" /></span>
					<br>
					<br>
					<span><b>Precio:</b> <c:out value="${flight.price.total}" /></span>
					<br>
					<br>
					<br>
				</c:forEach> <br /></td>
		</tr>

		<td width=40%>

			<div id='map' class='use-all-space'></div> <script>
				// Define your product name and version
				tomtom.setProductInfo('MapsWebSDKExamplesSelfhosted',
						'4.47.2-SNAPSHOT');
				var map, marker;
				// Setting TomTom keys
				tomtom.key('D5IYmsgLaSB7BkLe9jgyhDA923FgG0mS');
				tomtom.searchKey('D5IYmsgLaSB7BkLe9jgyhDA923FgG0mS');

				//Creating the map
				map = tomtom
						.map('map', {
							source : 'vector',
							basePath : '/sdk'
						})
						.setView(
								[
										"${requestScope.results.get(0).getPosition().getLat()}",
										"${requestScope.results.get(0).getPosition().getLon()}" ],
								14);

				// Adding marker to the map
				marker = tomtom.L
						.marker(
								[
										"${requestScope.results.get(0).getPosition().getLat()}",
										"${requestScope.results.get(0).getPosition().getLon()}" ],
								{
									draggable : true
								}).bindPopup('Amsterdam').addTo(map);

				// Show popup each time the marker is moved
				marker
						.on(
								'dragend',
								function(e) {
									tomtom
											.reverseGeocode({
												position : e.target.getLatLng()
											})
											.go(
													function(response) {
														if (response
																&& response.address
																&& response.address.freeformAddress) {
															marker
																	.setPopupContent(response.address.freeformAddress);
														} else {
															marker
																	.setPopupContent('No results found');
														}
														marker.openPopup();
													});
								});
			</script>
		</td>
		<td width=30%><br> <!-- Mostrar resultado de la búsqueda en Amadeus -->

			<!-- <h2>
				Aeropuertos encontrados en :
				<c:out value="${param.searchQuery}" />
			</h2> <c:forEach items="${requestScope.location}" var="locations">

				<span><b>Nombre:</b> <c:out value="${locations.name}" /></span>
				<br>
				<br>
				<span><b>Nombre detallado:</b> <c:out
						value="${locations.detailedName}" /></span>
				<br>
				<br>
				<span><b>Desplazamiento de zona horaria:</b> <c:out
						value="${locations.timeZoneOffset}" /></span>
				<br>
				<br>
				<br>
			</c:forEach> <br /></td>--%>
		</tr> 
	</table>
	<!--  <p style="text-align: right;">Enlace a Spotify en el logo.</p> -->


			<p style="text-align: center;">
				<a href="/spotifyPlaylistsGet"><img src="images/spotify.png"
					width="200px" hspace="20px" style="float: center;"></a>
			</p>
</body>
</html>