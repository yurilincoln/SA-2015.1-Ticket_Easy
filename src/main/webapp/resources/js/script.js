( function( $ ) {
$( document ).ready(function() {
$('#cssmenu').prepend('<div id="bg-one"></div><div id="bg-two"></div><div id="bg-three"></div><div id="bg-four"></div>');
var nav = $('.nav-container');

$(window).scroll(function () {
    if ($(this).scrollTop() > 136) {
        nav.addClass("f-nav");
    } else {
        nav.removeClass("f-nav");
    }
})
});;
} )( jQuery );