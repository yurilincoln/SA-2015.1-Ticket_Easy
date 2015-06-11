(function($) {
	$(document)
			.ready(
					function() {
						$('#cssmenu')
								.prepend(
										'<div id="bg-one"></div><div id="bg-two"></div><div id="bg-three"></div><div id="bg-four"></div>');
					});

	$(document).ready(function() {
		// mostra esconde menu
		$("a.mostra-esconde-menu").click(function() {
			$(".menu_mluv_retratil").toggleClass('esconder');
			if ($(this).text() == "esconder ▲")
				$(this).text("menu ▼")
			else
				$(this).text("esconder ▼");
		});
	});
	// menu ao rolar
	$(window).bind('scroll', function() {
		if ($(window).scrollTop() > 350) {
			$(".menu_mluv_retratil").addClass('esconder');
			$("a.mostra-esconde-menu").text('menu ▼');
		} else if ($(window).scrollTop() < 350) {
			$(".menu_mluv_retratil").removeClass('esconder');
			$("a.mostra-esconde-menu").text('esconder ▲');
		}
	});


})(jQuery);
