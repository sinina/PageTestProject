///URL PARAM 가져오기
jQuery.extend({
		getURLParam: function(strParamName){
			var strReturn = "";
			var strHref = window.location.href;
			var bFound=false;

			var cmpstring = strParamName + "=";
			var cmplen = cmpstring.length;

			if ( strHref.indexOf("?") > -1 ){
				var strQueryString = strHref.substr(strHref.indexOf("?")+1);
				var aQueryString = strQueryString.split("&");
				for ( var iParam = 0; iParam < aQueryString.length; iParam++ ){
					if (aQueryString[iParam].substr(0,cmplen)==cmpstring){
					var aParam = aQueryString[iParam].split("=");
					strReturn = aParam[1];
					bFound=true;
				break;
				}
			}
		}
		if (bFound==false) return null;
			return strReturn;
		}
	});

var browser = (function() {
	  var s = navigator.userAgent.toLowerCase();
	  var match = /(webkit)[ \/](\w.]+)/.exec(s) ||
				  /(opera)(?:.*version)?[ \/](\w.]+)/.exec(s) ||
				  /(msie) ([\w.]+)/.exec(s) ||               
				  /(mozilla)(?:.*? rv:([\w.]+))?/.exec(s) ||
				 [];
		return { name: match[1] || "", version: match[2] || "0" };
}());

// 숫자에 콤마 찍기
var numberWithCommas = function(x) {
	return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

//이메일 체크
var emailCheck = function(email)
{
	var regEmail = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
	if(!regEmail.test(email)) {
		return false;
	}
	return true;
}

//leadingZeros(5, 3) 005
var leadingZeros = function(n, digits) {
  var zero = '';
  n = n.toString();

  if (n.length < digits) {
    for (var i = 0; i < digits - n.length; i++)
      zero += '0';
  }
  return zero + n;
}


//2014년05월20일 -> 2014-05-20
var dateReplace = function(dt)
{
	dt = dt.replace(/년/g,"-");
	dt = dt.replace(/월/g,"-");
	dt = dt.replace(/일/g,"");
	return dt;
}


var getDayToYoil = function(dt) {
     
    var week = new Array('일', '월', '화', '수', '목', '금', '토');
     
    var today = new Date(dt).getDay();
    var todayYoil = week[today];
     
    return todayYoil;
}

