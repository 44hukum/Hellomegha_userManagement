/*===============================
			Preloader
=================================*/
	$(window).on('load', function() {
		$('#status').fadeOut();
		$('#preloader').delay(350).fadeOut('slow');
	});

/*===============================
			Team
=================================*/
/*$(document).ready(function(){
	$(".owl-carousel").owlCarousel();
});*/

$(function() {
	$("#team-members").owlCarousel({
		items: 2,
		//autoplay: true
		//smartspeed: 700;
	});
});

/*===============================
			Progress Bars
=================================*/
$(function() {
	/*$("#progress-elements").waypoint(function() {
		//alert("Alert Message!");
		//this.destroy();
	}, { offset: 'bottom-in-view'});*/

	$("#progress-elements").waypoint(function() {
		$(".progress-bar").each(function() {
			$(this).animate({width: $(this).attr("aria-valuenow") + "%"
			}, 1000);
		});
		this.destroy();
	}, { offset: 'bottom-in-view'});

});

/*===============================
			Responsive tabs
=================================*/
$(function(){
	$("#services-tabs").responsiveTabs({
		animation: 'slide'
	});
});

/*===============================
			Portfolio
=================================*/
$(window).on('load',function(){

	//initialize isotope
	$("#isotope-container").isotope({
	});

	//filter items on button click
	$("#isotope-filters").on('click','button',function(){

		//get filter value
		var filterValue = $(this).attr('data-filter');

		//filter portfolio
		$("#isotope-container").isotope({
			filter: filterValue
		});

		//active button
		$("#isotope-filters").find('.active').removeClass('active');
		$(this).addClass('active');
	});
});

/*===============================
			Magnifier
=================================*/
$(function(){
	$("#portfolio-wrapper").magnificPopup({
		delegate: 'a',
		type: 'image',
		gallery: {
			enabled: true
		}
	});
});

/*===============================
			Navigation
=================================*/
/*show/hide white nav*/
$(function(){

	showHideNav();

	$(window).scroll(function(){
		showHideNav();
	});

	function showHideNav(){
		if ($(window).scrollTop() >50) {
			$("nav").addClass("white-nav-top");
			
			//show dark logo
			$(".navbar-brand img").attr("src", "img/logo/logo-dark.png");

			//show back to top button
			$("#back-to-top").fadeIn();
		}
			else{
				$("nav").removeClass("white-nav-top");

				$(".navbar-brand img").attr("src", "img/logo/logo.png");

				//show back to top button
				$("#back-to-top").fadeOut();
			}
	}
});

/*===============================
			Smooth scrolling
=================================*/
$(function(){
	$("a.smooth-scroll").click(function(event) {
		event.preventDefault();

		var section_id = $(this).attr("href");

		$("html,body").animate({
			scrollTop: $(section_id).offset().top - 64
		}, 1250, "easeInOutExpo");

	});
});
