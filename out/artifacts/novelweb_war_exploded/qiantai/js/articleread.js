function SetCookie(name, value) {
	var Days = 365;
	var exp = new Date();
	exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
	document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString() + ";path=/" +";domain=panduoma.cn";
	}
function getCookie(name) {
	var arr = document.cookie.match(new RegExp("(^| )" + name + "=([^;]*)(;|$)"));
	if (arr != null) return unescape(arr[2]);
	return null
}

		$(document).ready(function(){
			$("body").keydown(function(event){
			if(event.keyCode==13){
				var url = $("#bookinfo").attr('href');
				if(url){
					window.location.href = url;
				}
			} 
			if(event.keyCode==37){
				var url = $("#prevUrl").attr('href');
				if( url ){
					window.location.href = url;
				} else {
					alert("该章节目前是第一章。");
				}
				
			}
			if(event.keyCode==39){
				var url = $("#nextUrl").attr('href');
				if( url ){
					window.location.href = url;
				} else {
					alert("作品已经是最后一章。");
				}
			
			}
			});
		});
 
function gotoURL(url) {
	window.location.href = url;
}
function default_style() {
	changeSize('middle', 'article');
	fontColor('black', 'article');
	bgColor('default_style', 'content')
}
function default_fy_style() {
	changeSize('middle', 'article');
	fontColor('black', 'article');
	bgColor('default_style', 'content')
}
function setStyle() {
	if (getCookie('fontsize') != null) {
	    changeSize('', 'readDetailbody p');
	}
	if (getCookie('background') != null) {
	    bgColor('', 'readDetailbody');
	}
	if (getCookie('fontfamily') != null) {
	    fontFamily('', 'readDetailbody p');
	}
}

function changeSize(mode, id) {
	if (mode.length == 0) {
	    mode = getCookie('fontsize')
	} else {
	    SetCookie('fontsize', mode);
	}
	switch(mode){
		case '21': size = '12px';break;
		case '22': size = '14px';break;
		case '23': size = '18px';break;
		case '24': size = '22px';break;
		default : size = '14px';break;
	}
	$(".readDetailbody p").css("fontSize",size);
	$(".readDetailbody p").css("lineHeight",'180%');


	$(".xsDetail").css("fontSize",size);
	$(".xsDetail").css("lineHeight",'180%');

}
function fontFamily(mode, id) {
	if (mode.length == 0) {
		mode = getCookie('fontfamily')
	} else {
		SetCookie('fontfamily', mode)
	}
	switch(mode){
		case '11': family = "'微软雅黑'";break;
		case '12': family = "'宋体'";break;
		case '13': family = "'楷体'";break;
		default : family = "'宋体'";break;
	}
	$(".xsDetail p").css("fontFamily",family);
	$(".xsDetail").css("fontFamily",family);

}
function bgColor(mode, id) {
	if (mode.length == 0) {
	    mode = getCookie('background')
	} else {
	    SetCookie('background', mode)
	}
	switch(mode){
		case '1': bgcolor = '#f6f4ec';break;
		case '2': bgcolor = '#dbeed9';break;
		case '3': bgcolor = '#e8fdfe';break;
		case '4': bgcolor = '#f6f6f6';break;
		case '5': bgcolor = '#ded6d6';break;
		case '6': bgcolor = '#fdd9d9';break;
		case '7': bgcolor = '#666';break;
		default : bgcolor = '#f6f4ec';break;
	}
	$(".readDetailbody").css("backgroundColor",bgcolor);
};

function setReadTheme (id) {
    var arr = ['defaultBg stat','green stat','blue stat','white stat','gray stat','pink stat','night stat'];
    var arr1 = ['stat','setSimsun stat','setKs stat'];
    // var carr = ['#f6f4ec','#dbeed9','#e8fdfe','#f6f6f6','#ded6d6','#fdd9d9','#666'];
    // var farr = ['微软雅黑','宋体','楷体'];
    // var sarr = ['12px','14px','18px','22px'];
    if (id<10) {
        for (var i = 1; i <8; i++) {
            if (i==id) {
                $('#'+id).attr('class',arr[(id-1)]+' border1');
                $('#color').val(id);
            }else{
                $('#'+i).attr('class',arr[(i-1)]);
            };
        };
    };
    if (id>10 && id<20) {
        for (var x = 11; x <14; x++) {
            if (x==id) {
                $('#'+id).attr('class',arr1[(id-11)]+' border1');
                $('#ffamily').val(id);
            }else{
                $('#'+x).attr('class',arr1[(x-11)]);
            };
        };
    };
    if (id>20) {
        for (var y = 21; y <25; y++) {
            if (y==id) {
                $('#'+id).attr('class','border1');
                $('#fsize').val(id);
            }else{
                $('#'+y).attr('class','');
            };
        };
    };
}
function setup () {
    var s = $('#fsize').val();
    var c = $('#color').val();
    var f = $('#ffamily').val();
    changeSize(s);
    bgColor(c);
    fontFamily(f);
    $("#loginpop").css("display","none");
    $(".mask").css("display","none");
}

function hidePopup(){
	$(".mask").css("display","none");
	$(".login_register").css("display","none");
	$(".comment_popup").css("display","none");
	$(".reward_popup").css("display","none");
	$(".success_pop").css("display","none");
	$(".forgetArea").css("display","none");
	$("#loginpop").css("display","none");
};
function showSetup() {
	$("#loginpop").show();
	$(".mask").show();
}
//回到顶部
function goTop() {
	$('html,body').animate({'scrollTop': 0}, 600);
}

$(document).ready(function() {
	if ($('body').html() != null) {
		setStyle()
	}
});