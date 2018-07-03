// JavaScript Document
(function ($, document, undefined) {

	var pluses = /\+/g;

	function raw(s) {
		return s;
	}

	function decoded(s) {
		return decodeURIComponent(s.replace(pluses, ' '));
	}

	var config = $.cookie = function (key, value, options) {

		// write
		if (value !== undefined) {
			options = $.extend({}, config.defaults, options);

			if (value === null) {
				options.expires = -1;
			}

			if (typeof options.expires === 'number') {
				var days = options.expires, t = options.expires = new Date();
				t.setDate(t.getDate() + days);
			}

			value = config.json ? JSON.stringify(value) : String(value);

			return (document.cookie = [
				encodeURIComponent(key), '=', config.raw ? value : encodeURIComponent(value),
				options.expires ? '; expires=' + options.expires.toUTCString() : '', // use expires attribute, max-age is not supported by IE
				options.path    ? '; path=' + options.path : '',
				options.domain  ? '; domain=' + options.domain : '',
				options.secure  ? '; secure' : ''
			].join(''));
		}

		// read
		var decode = config.raw ? raw : decoded;
		var cookies = document.cookie.split('; ');
		for (var i = 0, l = cookies.length; i < l; i++) {
			var parts = cookies[i].split('=');
			if (decode(parts.shift()) === key) {
				var cookie = decode(parts.join('='));
				return config.json ? JSON.parse(cookie) : cookie;
			}
		}

		return null;
	};

	config.defaults = {};

	$.removeCookie = function (key, options) {
		if ($.cookie(key) !== null) {
			$.cookie(key, null, options);
			return true;
		}
		return false;
	};

})(jQuery, document);

(function($) {
	
  $.fn.layerBoard = function(option) {
  	
		var elements = this;
		
		elements.each(function(){
			
			option = $.extend({
				delayTime: 100,
				fadeTime : 100,
				alpha : 0.5,
				
				limitMin : 1,
				
				easing: 'linear',
				
				limitCookie : 0
			}, option);
							
				
			var limitSec = option.limitMin * 60;
						
						
			if ($.cookie('layerBoardTime') == null) {
				LayerBoardFunc ();
				var start = new Date();
				$.cookie('layerBoardTime', start.getTime(), { expires: option.limitCookie,path: '/' });
				
			} else {
				var now = new Date();
				secDiff = now.getTime() - $.cookie('layerBoardTime');
				secTime = Math.floor( secDiff / 1000);
				if (secTime >= limitSec) {
					
					LayerBoardFunc ();
					
					$.cookie('layerBoardTime', null, { expires:-1,path: '/' });
					
					var start = new Date();
					$.cookie('layerBoardTime', start.getTime(), { expires:option.limitCookie,path: '/' });
					
				}
				
			}
			function LayerBoardFunc () {
				
				
				$('.popup_bnr_bg', elements).show().animate({opacity: 0},0).delay(option.delayTime).animate({opacity: option.alpha},option.fadeTime,function(){
					$('.popup_bnr', elements).fadeIn(option.fadeTime);																																					
				})
					
			}
			$('.popup_bnr_bg', elements).click(function() {
				
				$('.popup_bnr', elements).css('display','none');
				$(this).fadeOut(option.fadeTime);
				
				
			});
			
			//닫기 버튼
			$('.btn_close', elements).click(function() {
				
				$('.popup_bnr', elements).css('display','none');
				$('.popup_bnr_bg', elements).fadeOut(option.fadeTime);
				
				
			});
	
		});
		return this;
	};
	
})( jQuery );
