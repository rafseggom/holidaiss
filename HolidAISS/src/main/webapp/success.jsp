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
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
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
<!-- TomTom Map -->
<link rel='stylesheet' type='text/css' href='sdk/map.css' />
<script src='sdk/tomtom.min.js'></script>
<style>
body {
	margin: 0;
	padding: 0;
}

#map {
	width: 59%;
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

	<section class="head">
		<div class="container">
			<h2 class="text-center">
				<span>Resultado de la búsqueda </span>
			</h2>
		</div>
	</section>
	<div class="clearfix"></div>
	<section class="search-box">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12 listing-block">
					<div class="media">
						<div class="fav-box">
							<i class="fa fa-heart-o" aria-hidden="true"></i>
						</div>
						
						<div class="media-body pl-3">
							<td width=1000px><br> <!-- Mostrar resultado de la búsqueda en Amadeus -->

				<h89>
					Las opciones de viaje son : <br><br>
					<c:out value="${param.searchQuery}" />
				</h89> <c:forEach items="${requestScope.cheapFlights}" var="cFlight">

					<span><b>Aeropuerto de origen:</b> <c:out
							value="${cFlight.origin}" /></span>
					<br>
					<br>
					<span><b>Aeropuerto de destino:</b> <c:out
							value="${cFlight.destination}" /></span>
					<br>
					<br>
					<span><b>Fecha Salida:</b> <c:out
							value="${cFlight.departureDate}" /></span>
					<br>
					<br>
					<span><b>Fecha vuelta:</b> <c:out
							value="${cFlight.returnDate}" /></span>
					<br>
					<br>
					<span><b>Precio:</b> <c:out value="${cFlight.price.total}" /></span>
					<br>
					<br>
					<br>
				</c:forEach> <br /></td>
						</div>
					</div>
					
				</div>
				<div id='map'></div>
				<script>
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
												.reverseGeocode(
														{
															position : e.target
																	.getLatLng()
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

			</div>
		</div>
	</section>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jQuery-slimScroll/1.3.8/jquery.slimscroll.min.js"></script>
	<script>
		$(function() {
			$('.listing-block').slimScroll({
				height : '500px'
			});
		});
	</script>
	<div id="wrapper">
  <a href="https://holidaiss.appspot.com" class="my-super-cool-btn">
    <div class="dots-container">
      <div class="dot"></div>
      <div class="dot"></div>
      <div class="dot"></div>
      <div class="dot"></div>
    </div>
    <span>Indice</span>
  </a>
  <a href="/spotifyPlaylistCreate.jsp" class="my-super-cool-btn">
    <div class="dots-container">
      <div class="dot"></div>
      <div class="dot"></div>
      <div class="dot"></div>
      <div class="dot"></div>
    </div>
    <span>Spotify</span>
  </a>
</div>
</body>
</html>