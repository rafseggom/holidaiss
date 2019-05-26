<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>




<link href="https://fonts.googleapis.com/css?family=Raleway:200,100,400"
	rel="stylesheet" type="text/css" />





<head>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
<script type="text/javascript">
	var TxtRotate = function(el, toRotate, period) {
		this.toRotate = toRotate;
		this.el = el;
		this.loopNum = 0;
		this.period = parseInt(period, 10) || 2000;
		this.txt = '';
		this.tick();
		this.isDeleting = false;
	};

	TxtRotate.prototype.tick = function() {
		var i = this.loopNum % this.toRotate.length;
		var fullTxt = this.toRotate[i];

		if (this.isDeleting) {
			this.txt = fullTxt.substring(0, this.txt.length - 1);
		} else {
			this.txt = fullTxt.substring(0, this.txt.length + 1);
		}

		this.el.innerHTML = '<span class="wrap">' + this.txt + '</span>';

		var that = this;
		var delta = 300 - Math.random() * 100;

		if (this.isDeleting) {
			delta /= 2;
		}

		if (!this.isDeleting && this.txt === fullTxt) {
			delta = this.period;
			this.isDeleting = true;
		} else if (this.isDeleting && this.txt === '') {
			this.isDeleting = false;
			this.loopNum++;
			delta = 500;
		}

		setTimeout(function() {
			that.tick();
		}, delta);
	};

	window.onload = function() {
		var elements = document.getElementsByClassName('txt-rotate');
		for (var i = 0; i < elements.length; i++) {
			var toRotate = elements[i].getAttribute('data-rotate');
			var period = elements[i].getAttribute('data-period');
			if (toRotate) {
				new TxtRotate(elements[i], JSON.parse(toRotate), period);
			}
		}
		// INJECT CSS
		var css = document.createElement("style");
		css.type = "text/css";
		css.innerHTML = ".txt-rotate > .wrap { border-right: 0.08em solid #666 }";
		document.body.appendChild(css);
	};
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon" href="/images/holidaiss.ico" />
<title>HolidAISS</title>

</head>

<body>


	<br>
	<p style="text-align: center;">
		<img alt="Logo proyecto HolidAISS" src="/images/holidaiss.png"
			style="width: 95px; height: 110px; border: 0;">
	</p>


	<h1>
		HolidAISS es <span class="txt-rotate" data-period="2000"
			data-rotate='[ "fácil.", "rápida.", "útil.", "accesible.", "divertida!" ]'></span>
	</h1>
	<h2>Optimiza tus vacaciones.</h2>


	<div id="searchDiv">
		<div class="login-form">
			<div class="main-div">
				<div class="panel">
					<p>Introduce la ciudad de origen, el precio de tu vuelo y la
						fecha que desees.</p>
				</div>
				<form id="searchForm" action="SearchController" method="post">
					<div id="searchDiv">
						<div class="form-group">


							<input type="text" name="searchQuery" required
								class="form-control" placeholder="¿Cuál es tu ciudad de origen?">

						</div>

						<div class="form-group">

							<input type="number" class="form-control" name="searchPrice"
								required placeholder="¿Cuánto estás dispuesto/a a pagar?">


						</div>
						<div class="form-group">
							<input type="date" class="form-control" name="searchDate"
								placeholder="Fecha">
							<button type="submit" class="btn btn-primary" name="searchBtn"
								value="search">Buscar</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>


	<!--  <p style="text-align: center;">Enlace a GitHub en el logo.</p> -->
	<br>


	<p style="text-align: center;">
		<a href="https://github.com/rafseggom/holidaiss.git"
			onclick='window.open("https://github.com/rafseggom/holidaiss.git");return false;'>
			<img src="/images/github.png" alt="HolidAISS GitHub"
			title="GitHub Repository"
			style="width: 80px; height: 80px; border: 0;">
		</a>
	</p>
</body>
</html>