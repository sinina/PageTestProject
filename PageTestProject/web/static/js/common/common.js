// JavaScript Document
var $sizes = {'1321': '소형견', '1322': '중형견', '1323': '대형견'};
var $ages = {'1311': '강아지', '1312': '성견', '1313': '노령견'};

var $states;
var $search = function (wholeStates) {
	var href = '/reserve/search';
	var states = $('.states-tabs :checkbox:checked');

	if (!wholeStates && states.length) {
		href += '?states=' + states.map(function () {
				return this.value;
			}).get().join();
	}
	location.href = href;
};


var IS_IPAD = navigator.userAgent.match(/iPad/i) != null,
		IS_IPHONE = !IS_IPAD && ((navigator.userAgent.match(/iPhone/i) != null) || (navigator.userAgent.match(/iPod/i) != null)),
		IS_IOS = IS_IPAD || IS_IPHONE,
		IS_ANDROID = !IS_IOS && navigator.userAgent.match(/android/i) != null,
		IS_MOBILE = IS_IOS || IS_ANDROID;

var TIMEOUT_IOS = 2 * 1000,
		TIMEOUT_ANDROID = 3 * 100,
		INTERVAL = 100,
		intentNotSupportedBrowserList = [
				'firefox',
				'opr',
				'fb_iab'
		];

function moveToStore (storeURL) {
		window.location.href = storeURL;
}

function web2app (context) {
		var willInvokeApp = (typeof context.willInvokeApp === 'function') ? context.willInvokeApp : function(){},
						onAppMissing  = (typeof context.onAppMissing === 'function')  ? context.onAppMissing  : moveToStore,
						onUnsupportedEnvironment = (typeof context.onUnsupportedEnvironment === 'function') ? context.onUnsupportedEnvironment : function(){};

		willInvokeApp();

		if (IS_ANDROID) {
				if (isIntentSupportedBrowser() && context.intentURI && !context.useUrlScheme) {
						web2appViaIntentURI(context.intentURI);
				} else if (context.storeURL) {
						web2appViaCustomUrlSchemeForAndroid(context.urlScheme, context.storeURL, onAppMissing);
				}
		} else if (IS_IOS && context.storeURL) {
				web2appViaCustomUrlSchemeForIOS(context.urlScheme, context.storeURL, onAppMissing);
		} else {
				setTimeout(function () {
						onUnsupportedEnvironment();
				}, 100);
		}
}

function isIntentSupportedBrowser () {
		var supportsIntent = ('Safari' == 'Chrome') && +(parseint('1')) >= 25;
		var blackListRegexp = new RegExp(intentNotSupportedBrowserList.join('|'), "i");
		return supportsIntent && !blackListRegexp.test('mozilla/5.0 (iphone; cpu iphone os 9_1 like mac os x) applewebkit/601.1.46 (khtml, like gecko) version/9.0 mobile/13b143 safari/601.1');
}

function web2appViaCustomUrlSchemeForAndroid (urlScheme, storeURL, fallback) {
		deferFallback(TIMEOUT_ANDROID, storeURL, fallback);
		launchAppViaHiddenIframe(urlScheme);
}

function deferFallback(timeout, storeURL, fallback) {
		var clickedAt = new Date().getTime();
		return setTimeout(function () {
				var now = new Date().getTime();
				if (isPageVisible() && now - clickedAt < timeout + INTERVAL) {
						fallback(storeURL);
				}
		}, timeout);
}

function web2appViaIntentURI (launchURI) {
		if ( 'Safari' == 'Chrome' ){
				move();
		}else{
				setTimeout(move, 100);
		}

		function move(){
				top.location.href = launchURI;
		}
}

function web2appViaCustomUrlSchemeForIOS (urlScheme, storeURL, fallback) {
		var tid = deferFallback(TIMEOUT_IOS, storeURL, fallback);
		if (parseInt('9', 10) < 8) {
				bindPagehideEvent(tid);
		} else {
				bindVisibilityChangeEvent(tid);
		}

		// https://developer.apple.com/library/prerelease/ios/documentation/General/Conceptual/AppSearch/UniversalLinks.html#//apple_ref/doc/uid/TP40016308-CH12
		if ( isSupportUniversalLinks() ){
				launchAppViaChangingLocation(urlScheme);
		}else{
				launchAppViaHiddenIframe(urlScheme);
		}
}

function bindPagehideEvent (tid) {
		window.addEventListener('pagehide', function clear () {
				if (isPageVisible()) {
						clearTimeout(tid);
						window.removeEventListener('pagehide', clear);
				}
		});
}
function bindVisibilityChangeEvent (tid) {
		document.addEventListener('visibilitychange', function clear () {
				if (isPageVisible()) {
						clearTimeout(tid);
						document.removeEventListener('visibilitychange', clear);
				}
		});
}

function isPageVisible () {
		var attrNames = ['hidden', 'webkitHidden'];
		for(var i=0, len=attrNames.length; i<len; i++) {
				if (document[attrNames[i]] !== 'undefined') {
						return !document[attrNames[i]];
				}
		}
		return true;
}

function launchAppViaChangingLocation (urlScheme){
		window.top.location.href = urlScheme;
}

function launchAppViaHiddenIframe (urlScheme) {
		setTimeout(function () {
				var iframe = createHiddenIframe('appLauncher');
				iframe.src = urlScheme;
		}, 100);
}

function createHiddenIframe (id) {
		var iframe = document.createElement('iframe');
		iframe.id = id;
		iframe.style.border = 'none';
		iframe.style.width = '0';
		iframe.style.height = '0';
		iframe.style.display = 'none';
		iframe.style.overflow = 'hidden';
		document.body.appendChild(iframe);
		return iframe;
}

function isSupportUniversalLinks(){
		return (parseInt('9', 10) > 8 && IS_IOS);
}

function deferFallback(timeout, storeURL, fallback) {
		var clickedAt = new Date().getTime();
		return setTimeout(function () {
				var now = new Date().getTime();
				if (isPageVisible() && now - clickedAt < timeout + INTERVAL) {
						fallback(storeURL);
				}
		}, timeout);
}



//레이어팝업 쿠키체크
function setCookie( name, value, expirehours ) {
	var todayDate = new Date();
	todayDate.setHours( todayDate.getHours() + expirehours );
	document.cookie = name + "=" + escape( value ) + "; path=/; expires=" + todayDate.toGMTString() + ";"
}
function todaycloseWin() {
	setCookie( "ncookie", "done" , 24 );
	document.getElementById('popup_bnr_wrap').style.display = "none";
}

function getInternetExplorerVersion() {
     var rv = Infinity; // Return value assumes failure.
     if (navigator.appName == 'Microsoft Internet Explorer') {
          var ua = navigator.userAgent;
          var re = new RegExp("MSIE ([0-9]{1,}[\.0-9]{0,})");
          if (re.exec(ua) != null)
              rv = parseFloat(RegExp.$1);
         }
     return rv;
}

$(function(){

	$('#popup_bnr_wrap').layerBoard({alpha:0.5});

	//ie8,9 placeholder표시
	var supportsInputAttribute = function (attr) {
	  var input = document.createElement('input');
	  return attr in input;
	};
	if (!supportsInputAttribute('placeholder')) {
	  $('[placeholder]').each(function () {
		var
		  input = $(this),
		  placeholderText = input.attr('placeholder'),
		  placeholderColor = 'GrayText',
		  defaultColor = input.css('color');
		input.
		  focus(function () {
			if (input.val() === placeholderText) {
			  input.val('').css('color', defaultColor);
			}
		  }).
		  blur(function () {
			if (input.val() === '') {
			  input.val(placeholderText).css('color', placeholderColor);
			} else if (input.val() === placeholderText) {
			  input.css('color', placeholderColor);
			}
		  }).
		  blur().
		  parents('form').
			submit(function () {
			  if (input.val() === placeholderText) {
				input.val('');
			  }
			});
	  });
	}

	//금액입력폼 3자리수마다 컴마, 숫자만가능하도록
	/*$('.form-control-price').focus(function(){
		this.value = this.value.replace(/,/g,'') ;
		if (this.value == '0') this.value = '';
	});*/
	$('.form-control-price').blur(function(){
		this.value = this.value.replace(/,/g,'') ;
		var num = '' + parseInt(this.value) ;
		while(num != (num = num.replace(/^(-?\d+)(\d{3})/, '$1,$2')));
		if (isNaN(parseInt(num))) num = '0';
		this.value = num ;
	});

	//펫사진 마우스오버로 프론트표시
	$('.sitter-thum-sub').mouseover(function(){
		$(this).addClass('sitter-thum-sub-front');
	}).mouseout(function(){
		$(this).removeClass('sitter-thum-sub-front');
	});

	// #으로 시작하는 앵커태그처리
	$('a[href^=#anchor]').click(function() {
		var speed = 500;
		var href= $(this).attr("href");
		var target = $(href == "#" || href == "" ? 'html' : href);
		var position = target.offset().top;
		$('body,html').animate({scrollTop:position}, speed, 'swing');
		return false;
	});

	//돌보미등록하기 썸네일 hover
	$('.information-thum-wrap .thum-wrap:nth-child(3n+1)').addClass('thum-wrap-right');

	$('.thum-wrap').mouseover(function(){
		$(this).addClass('thum-wrap-hover');
	}).mouseout(function(){
		$(this).removeClass('thum-wrap-hover');
	});

	//메시지 공지사항
	$('.message-notice-btn , .message-notice-close').on('click', function() {
		$('.message-notice-close').slideToggle(100);
		$('.message-notice-open').slideToggle(100);
		$('.message-notice-btn').toggleClass('message-notice-btn-close');
	});

	//사이드 메시지리스트
	$('#sidebar').simplerSidebar({
		opener: '#sidebar-btn',
		animation: {
				easing: "easeOutQuint"
			},
			sidebar: {
			align: 'right',
			width: 400,
			closingLinks: '#sidebar-close'
		}
	});

	//사이드 메시지리스트 마우스오버처리
	$('.sidebar-list a').mouseover(function(){
		$(this).parent().addClass('sidebar-list-hover');
	}).mouseout(function(){
		$(this).parent('').removeClass('sidebar-list-hover');
	});

	var topNavSearch = $('.top-nav-search select');
	if (topNavSearch.length) {
		$.getJSON("/service/location", function(data) {
			var arr = [{id: '', text: '서울/경기/인천'}];

			for(var i = 0; i < data.length; i++) {
				var states = data[i].states;
				if(states.length) {
					for(var j = 0; j < states.length; j++) {
						arr.push({
							id: states[j].state_no,
							text: data[i].region + ' ' + states[j].state_name
						});
					}
				}
			}
			topNavSearch.select2({
				data: arr, placeholder: '서울/경기/인천', allowClear: true
			});
		});
	}


	if (!$(".left-nav-bar").length) {
		$('.main-wrap').addClass('no-profile');
	}


	var imgNewMsg = $('#new-message-mail');
	var dropdownNewMsg = imgNewMsg.closest('.dropdown').on({
		'show.bs.dropdown': function () {
			clearTimeout(timerNewMsg);
			timerNewMsg = null;
		},
		'hide.bs.dropdown': function () {
			if (!timerNewMsg) {
				timerNewMsg = setTimeout(getNewMessages, 5000);
			}
		}
	});
	var btnNewMsg = dropdownNewMsg.children('[data-toggle=dropdown]');

    var isInbound = location.pathname.indexOf('/to-me') > 0;
    var printUnreadCount = function (idx, c) {
        var text = $.trim($('#submenu a:eq(' + idx + ')').text());
        text = text.substring(0, text.lastIndexOf('예약') + 2);
        $('#submenu a:eq(' + idx + '), #nav-sp-submenu li:eq(' + idx + ') a')
            .text(text + ' (' + c + ')');
    };

	var timerNewMsg = null;
	var getNewMessages = function () {
		$.get('/chat/new_messages', {}, function (r) {
			if (!r.error && !eval(btnNewMsg.attr('aria-expanded'))) {
				var containerNewMsg = $('.dropdown-menu', dropdownNewMsg);
				if (!containerNewMsg.length) {
					containerNewMsg = $('<ul/>', {
							role: 'menu', 'aria-labelledby': 'new-message-mail'
					}).addClass('dropdown-menu').appendTo(dropdownNewMsg);
				} else {
					containerNewMsg.empty();
				}

				if (r.list.length) {
					imgNewMsg.addClass('new-message');

					for (var i = 0; i < r.list.length; i++) {
						var anchor = $('<a/>', {href: '/reservations/' + r.list[i].order_no})
							.appendTo(containerNewMsg).wrap('<li/>')
							.click($.proxy(function (orderNo) {
								$openChat(orderNo);
							}, null, r.list[i].order_no));

						$('<div/>').addClass('profile-photo').appendTo(anchor)
							.css('background-image', 'url(' + r.list[i].mem_photo_path + ')');

						var dl = $('<dl/>').appendTo(anchor);
						var dt = $('<dt/>').addClass('clearfix').appendTo(dl);
						$('<label/>').addClass('pull-left').append(r.list[i].mem_nm).appendTo(dt);

						var date = moment(r.list[i].r_startdate).format('YYYY.M.D')
							+ (r.list[i].service_type == 'STAY' ? ' ~ '
								+ moment(r.list[i].r_enddate).format('M.D') : '');
						$('<span/>').addClass('pull-right').append(date).appendTo(dt);

						$('<dd/>').text($('<p/>').html(r.list[i].msg_body).text()).appendTo(dl);
					}
				} else if (containerNewMsg.length) {
					$('<li/>').addClass('no-content text-center')
						.append('새로 받은 메시지가 없습니다.').appendTo(containerNewMsg);
					imgNewMsg.removeClass('new-message');
				}

				if (!timerNewMsg) {
					timerNewMsg = setTimeout(getNewMessages, 5000);
				}

				if (!location.pathname.indexOf('/reservations/to-')) {
					var submenu = $('#submenu');
					var idxOutbound = submenu.children().length > 1 ? 1 : 0;
					if (idxOutbound) {
						printUnreadCount(0, r.unreadCounts.inbound);
					}
					printUnreadCount(idxOutbound, r.unreadCounts.outbound);

					var navTitle = $('.nav-sp-title');
					var text = $.trim(navTitle.text());
					navTitle.contents().eq(0).remove();

					text = text.substring(0, text.lastIndexOf('예약') + 2);
					navTitle.text(text + ' (' + (r.unreadCounts[isInbound ? 'inbound' : 'outbound']) + ')');
				}
			}
		}, 'json');

		timerNewMsg = null;
	};
	getNewMessages();


	$('.banner-top .close').click(function (e) {
		e.preventDefault();
		$('body > .container, body > .container-fluid, .ui-datepicker').removeClass('visible-banner-top');
	});


	var fixedPopupUnderConstruction = $('#fixed-popup-under-construction');
	var popupUnderConstruction = 'popup-under-construction-2016-10';
	var fixedPopupClose = $('.btn-close', fixedPopupUnderConstruction).click(function () {
		fixedPopupUnderConstruction.addClass('hide');
	});
	$('.today', fixedPopupUnderConstruction).click(function () {
		$.cookie(popupUnderConstruction, true, {expires: 1});
		fixedPopupClose.trigger('click');
	});

	if (false && !$.cookie(popupUnderConstruction)) {
		fixedPopupUnderConstruction.removeClass('hide');
	}


	var statesTabs = $('.states-tabs .nav-tabs').empty();
	if (statesTabs.length) {
		$.getJSON('/service/location', function(data) {
			var li = $('<li/>', {role: 'presentation'}).appendTo(statesTabs);
			var whole = $('<a/>', {href: ''}).append('전체').click(function (e) {
				e.preventDefault();
				$('.dropdown', statesTabs).removeClass('active')
					.find(':checkbox:checked').prop('checked', false);
				$search(true);
			}).appendTo(li);

			var countTotal = 0;

			for (var i = 0; i < data.length; i++) {
				var states = data[i].states;
				if (states.length) {
					li = $('<li/>', {role: 'presentation'})
						.addClass('dropdown').appendTo(statesTabs);

					var anchor = $('<a/>', {
						href: '', id: 'stateTabDrop' + i, 'data-toggle': 'dropdown',
						'aria-controls': 'stateTabDrop' + i + '-contents'
					}).addClass('dropdown-toggle').append(data[i].region).appendTo(li);

					var dropdownMenu = $('<div/>', {
						id: 'stateTabDrop' + i + '-contents', 'role': 'menu',
						'aria-controls': 'stateTabDrop' + i
					}).addClass('dropdown-menu').appendTo(li);
					var ul = $('<ul/>').addClass('clearfix').appendTo(dropdownMenu);

					var countRegion = 0;
					var countChecked = 0;

					for (var j = 0; j < states.length; j++) {
						var state = states[j];
						var count = parseInt(state.count_approved_sitter, 10);
						var li2 = $('<li/>').addClass('pull-left').appendTo(ul);

						var checkbox = $('<input/>', {
							type: 'checkbox', name: 'states[]', id: 'state' + state.state_no
						}).addClass('checkbox').val(state.state_no)
							.appendTo(li2).change(function () {
							var self = $(this);
							var dropdown = self.closest('.dropdown');
							if (this.checked) {
								dropdown.addClass('active');
							} else if (!dropdown.find(':checkbox:checked').length) {
								dropdown.removeClass('active');
							}
						});

						$('<label/>', {for: 'state' + state.state_no})
							.append(state.state_name + ' (' + count + ')').appendTo(li2);

						for (var idx in $states) {
							if (state.state_no == $states[idx]) {
								checkbox.prop('checked', true);
								countChecked++;
								break;
							}
						}

						countRegion += count;
					}

					$('<button/>', {type: 'button', 'data-loading': '검색 중...'})
						.addClass('btn btn-mint').append('확인')
						.click(function () {
							$(this).button('loading');
							$search();
						}).appendTo(dropdownMenu);
					$('<button/>', {type: 'button'}).addClass('btn btn-link')
						.append('선택 초기화').click(function () {
							$(this).closest('.dropdown').removeClass('active')
								.find(':checkbox:checked').prop('checked', false);
						}).appendTo(dropdownMenu);

					if (countChecked) {
						li.addClass('active');
					}
					$('<span/>').append(countRegion).appendTo(anchor);
					$('input, label, button', dropdownMenu).click(function (e) {
				    e.stopPropagation();
				  });

					$('<button/>', {type: 'button', 'aria-label': 'Close'})
						.addClass('close visible-xs-block').append(
							$('<span/>', {'aria-hidden' : 'true'}).append('&times;')
						).appendTo(dropdownMenu);

					countTotal += countRegion;
				}
			}
			$('<span/>').append(countTotal).appendTo(whole);
			statesTabs.removeClass('hide').headroom({
				offset: 10, tolerance: {down: 3, up: 10}, onUnpin: function () {
					$(this.elem).find('.open').removeClass('open');
				}
			});
		});
	}
});

var $openChat = function (orderNo) {
		var param = {width: 500, height: 600};

		window.open('/chat/' + orderNo, 'dogmate-chat-' + orderNo,
			$.map(param, function (val, key) {
					return key + '=' + val;
			}).join());
};
