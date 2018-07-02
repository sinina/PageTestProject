<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>PetSitter, PetOwner</title>
  <style>
    .area {
      position: absolute;
      background: #fff;
      border: 1px solid #888;
      border-radius: 3px;
      font-size: 12px;
      top: -5px;
      left: 15px;
      padding:2px;
    }

    .info {
      font-size: 12px;
      padding: 5px;
    }
    .info .title {
      font-weight: bold;
    }
  </style>
</head>
<body>
<%@ include file="/views/admin/adminHeader.jsp" %> 
<div id="map" style="width:1200px;height:600px; margin: 0px auto; margin-top: 100px;"></div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c25a804bedbc433c559b302df7e78e0f"></script>
<script>
    // 지도에 폴리곤으로 표시할 영역데이터 배열입니다
    var areas = [
        {
            name : 'S, I, Gg, Gw',
            path : [
                new daum.maps.LatLng(38.5897706, 128.3714743),//기준1(오른 위)
                new daum.maps.LatLng(38.3584588, 128.2039328),
                new daum.maps.LatLng(38.3024406, 128.0254050),
                new daum.maps.LatLng(38.3261459, 127.7727194),
                new daum.maps.LatLng(38.3239912, 127.5777121),
                new daum.maps.LatLng(38.3196816, 127.3415061),
                new daum.maps.LatLng(38.2959742, 127.1547385),
                new daum.maps.LatLng(37.9437660, 126.7070456),
                new daum.maps.LatLng(37.9459320, 126.6740866),
                new daum.maps.LatLng(37.7746243, 126.6685935),
                new daum.maps.LatLng(37.7550830, 126.5916892),
                new daum.maps.LatLng(37.8267093, 126.4159079),
                new daum.maps.LatLng(37.8093517, 126.2016745),
                new daum.maps.LatLng(37.6737651, 126.1082907),//기준2(왼 위)
                new daum.maps.LatLng(37.5914608, 126.2458737),
                new daum.maps.LatLng(37.3560454, 126.3886960),
                new daum.maps.LatLng(36.9901615, 126.7697191),
                new daum.maps.LatLng(36.9095857, 126.8841238),
                new daum.maps.LatLng(36.8914270, 126.8388816),//기준3(왼 아래)
                new daum.maps.LatLng(36.9264177, 126.9827124),
                new daum.maps.LatLng(36.9633098, 127.1218487),
                new daum.maps.LatLng(36.9335602, 127.3536140),
                new daum.maps.LatLng(37.0432528, 127.4991828),
                new daum.maps.LatLng(37.2009321, 127.7463752),
                new daum.maps.LatLng(37.1374619, 127.7958137),
                new daum.maps.LatLng(37.1724865, 127.9386360),
                new daum.maps.LatLng(37.2315537, 127.9331428),
                new daum.maps.LatLng(37.2534188, 128.0265266),
                new daum.maps.LatLng(37.1826244, 128.0538252),
                new daum.maps.LatLng(37.2110662, 128.3202437),
                new daum.maps.LatLng(37.1388470, 128.2790450),
                new daum.maps.LatLng(37.1388470, 128.3916548),
                new daum.maps.LatLng(37.0402551, 128.7574732),
                new daum.maps.LatLng(37.0380627, 129.1941798),
                new daum.maps.LatLng(37.1750488, 129.4683254)//기준4(오른 아래)
            ]
        }, {
            name : 'Dg, Gb',
            path : [
                new daum.maps.LatLng(37.1750488, 129.4683254),//기준1(오른 위)
                new daum.maps.LatLng(37.0380627, 129.1941798),
                new daum.maps.LatLng(37.0402551, 128.7574732),//기준2(왼 위)
                new daum.maps.LatLng(36.8671130, 128.4293072),
                new daum.maps.LatLng(36.7923668, 128.3661358),
                new daum.maps.LatLng(36.8055626, 128.0530254),
                new daum.maps.LatLng(36.6955279, 128.0475322),
                new daum.maps.LatLng(36.6757049, 127.9047100),
                new daum.maps.LatLng(36.2671021, 127.8690044),
                new daum.maps.LatLng(36.2405238, 128.0283062),
                new daum.maps.LatLng(35.9053409, 127.8837475),//기준3(왼 아래)
                new daum.maps.LatLng(35.7707905, 128.1436626),
                new daum.maps.LatLng(35.6414342, 128.1848613),
                new daum.maps.LatLng(35.6213428, 128.3606426),
                new daum.maps.LatLng(35.6302729, 128.5007183),
                new daum.maps.LatLng(35.5722094, 128.7781231),
                new daum.maps.LatLng(35.6218840, 128.9346212),
                new daum.maps.LatLng(35.6084870, 129.0087789),
                new daum.maps.LatLng(35.6397431, 129.0719503),
                new daum.maps.LatLng(35.7044489, 129.1598409),
                new daum.maps.LatLng(35.6821424, 129.2642110),
                new daum.maps.LatLng(35.6486711, 129.2697042),
                new daum.maps.LatLng(35.6620613, 129.3493551),
                new daum.maps.LatLng(35.6674753, 129.7349572)//기준4(오른 아래)
            ]
        }, {
            name : 'Cn, Cb, Dj, Sj',
            path : [
                new daum.maps.LatLng(36.8914270, 126.8388816),//기준1(왼 위)
                new daum.maps.LatLng(36.9264177, 126.9827124),
                new daum.maps.LatLng(36.9633098, 127.1218487),
                new daum.maps.LatLng(36.9335602, 127.3536140),
                new daum.maps.LatLng(37.0432528, 127.4991828),
                new daum.maps.LatLng(37.2009321, 127.7463752),
                new daum.maps.LatLng(37.1374619, 127.7958137),
                new daum.maps.LatLng(37.1724865, 127.9386360),
                new daum.maps.LatLng(37.2315537, 127.9331428),
                new daum.maps.LatLng(37.2534188, 128.0265266),
                new daum.maps.LatLng(37.1826244, 128.0538252),
                new daum.maps.LatLng(37.2110662, 128.3202437),
                new daum.maps.LatLng(37.1388470, 128.2790450),
                new daum.maps.LatLng(37.1388470, 128.3916548),
                new daum.maps.LatLng(37.0402551, 128.7574732),//기준2(오른 위)
                new daum.maps.LatLng(36.8671130, 128.4293072),
                new daum.maps.LatLng(36.7923668, 128.3661358),
                new daum.maps.LatLng(36.8055626, 128.0530254),
                new daum.maps.LatLng(36.6955279, 128.0475322),
                new daum.maps.LatLng(36.6757049, 127.9047100),
                new daum.maps.LatLng(36.2671021, 127.8690044),
                new daum.maps.LatLng(36.2405238, 128.0283062),
                new daum.maps.LatLng(35.9053409, 127.8837475),//기준3(오른 아래)
                new daum.maps.LatLng(36.0634800, 126.8744098),
                new daum.maps.LatLng(36.1311682, 126.8908893),
                new daum.maps.LatLng(35.9895143, 126.6756701),//기준4(왼 아래)
                new daum.maps.LatLng(36.8268234, 126.0128039),
                new daum.maps.LatLng(37.1033330, 126.3863390),
                new daum.maps.LatLng(37.0090815, 126.7076891)
            ]
        }, {
            name : 'Jn, Jb, Gj',
            path : [
                new daum.maps.LatLng(35.9053409, 127.8837475),//기준1(오른 위)
                new daum.maps.LatLng(36.0634800, 126.8744098),
                new daum.maps.LatLng(36.1311682, 126.8908893),
                new daum.maps.LatLng(35.9895143, 126.6756701),//기준2(왼 위)
                new daum.maps.LatLng(34.2574040, 125.7197552),//기준3(왼 아래)
                new daum.maps.LatLng(34.5452792, 127.8669032),//기준4(오른 아래)
            ]
        }, {
            name : 'Kn, Bs, Us',
            path : [
                new daum.maps.LatLng(35.9053409, 127.8837475),//기준1(왼 위)
                new daum.maps.LatLng(35.7707905, 128.1436626),
                new daum.maps.LatLng(35.6414342, 128.1848613),
                new daum.maps.LatLng(35.6213428, 128.3606426),
                new daum.maps.LatLng(35.6302729, 128.5007183),
                new daum.maps.LatLng(35.5722094, 128.7781231),
                new daum.maps.LatLng(35.6218840, 128.9346212),
                new daum.maps.LatLng(35.6084870, 129.0087789),
                new daum.maps.LatLng(35.6397431, 129.0719503),
                new daum.maps.LatLng(35.7044489, 129.1598409),
                new daum.maps.LatLng(35.6821424, 129.2642110),
                new daum.maps.LatLng(35.6486711, 129.2697042),
                new daum.maps.LatLng(35.6620613, 129.3493551),
                new daum.maps.LatLng(35.6674753, 129.7349572),//기준2(오른 위)
                new daum.maps.LatLng(35.0664832, 129.3116136),//기준3(오른 아래)
                new daum.maps.LatLng(34.5452792, 127.8669032)//기준4(왼 아래)
            ]
        }
    ];

    var mapContainer = document.getElementById('map'), // 지도를 표시할 div
        mapOption = {
            center: new daum.maps.LatLng(36.7698781, 128.0436428), // 지도의 중심좌표
            level: 13 // 지도의 확대 레벨
        };

    var map = new daum.maps.Map(mapContainer, mapOption),
        customOverlay = new daum.maps.CustomOverlay({}),
        infowindow = new daum.maps.InfoWindow({removable: true});

    // 지도에 영역데이터를 폴리곤으로 표시합니다
    for (var i = 0, len = areas.length; i < len; i++) {
        displayArea(areas[i]);
    }

    // 다각형을 생상하고 이벤트를 등록하는 함수입니다
    function displayArea(area) {

        // 다각형을 생성합니다
        var polygon = new daum.maps.Polygon({
            map: map, // 다각형을 표시할 지도 객체
            path: area.path,
            strokeWeight: 2,
            strokeColor: '#004c80',
            strokeOpacity: 0.8,
            fillColor: '#fff',
            fillOpacity: 0.7
        });

        // 다각형에 mouseover 이벤트를 등록하고 이벤트가 발생하면 폴리곤의 채움색을 변경합니다
        // 지역명을 표시하는 커스텀오버레이를 지도위에 표시합니다
        daum.maps.event.addListener(polygon, 'mouseover', function(mouseEvent) {
            polygon.setOptions({fillColor: '#09f'});

            customOverlay.setContent('<div class="area">' + area.name + '</div>');

            customOverlay.setPosition(mouseEvent.latLng);
            customOverlay.setMap(map);
        });

        // 다각형에 mousemove 이벤트를 등록하고 이벤트가 발생하면 커스텀 오버레이의 위치를 변경합니다
        daum.maps.event.addListener(polygon, 'mousemove', function(mouseEvent) {

            customOverlay.setPosition(mouseEvent.latLng);
        });

        // 다각형에 mouseout 이벤트를 등록하고 이벤트가 발생하면 폴리곤의 채움색을 원래색으로 변경합니다
        // 커스텀 오버레이를 지도에서 제거합니다
        daum.maps.event.addListener(polygon, 'mouseout', function() {
            polygon.setOptions({fillColor: '#fff'});
            customOverlay.setMap(null);
        });

        // 다각형에 click 이벤트를 등록하고 이벤트가 발생하면 다각형의 이름과 면적을 인포윈도우에 표시합니다
        daum.maps.event.addListener(polygon, 'click', function(mouseEvent) {
            var content = '<div class="info">' +
                '   <div class="title">' + area.name + '</div>' +
                '   <div class="size">PetSitter : ' + '2' + '</br>' + //2대신 펫시터 인원 넣기
                '   <div class="size">PetOwner : ' + '2' + '</br>' + //2대신 반려주 인원 넣기
                '</div>';

            infowindow.setContent(content);
            infowindow.setPosition(mouseEvent.latLng);
            infowindow.setMap(map);
        });
    }
</script>
</body>
</html>
