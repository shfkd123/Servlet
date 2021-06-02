/**
 * 
 */

function subMenu(mcode){
    if(mcode!="M000000"){
       $.getJSON("/subMenu.do?mCode=" + mcode, function(data) {
				printData(data, $('.subMenuList'), $('#subMenu-list-template'),
						'.subMenu');
			});
		} else {
			$('.subMenuList').html("");
		}
	}
	//handelbars printElement (args : data Array, appent target, handler template, remove class)
	function printData(dataArr, target, templateObject, removeClass) {
		var template = Handlebars.compile(templateObject.html());

		var html = template(dataArr);

		$(removeClass).remove();

		target.append(html);
	}
	
function goPage(url, mCode){
	//HTML5 지원브라우저에서 사용가능
	if (typeof(history.pushState) == 'function'){
		//현재 주소를 가져온다.
		var renewURL = location.href;
		//현재 주소 중 .do 뒤 부분이 있다면 날려버린다.
		renewURL = renewURL.substring(0, renewURL.indexOf(".do")+3);
		
		if(mCode != 'M000000'){
			renewURL += "?mCode="+mCode;
		}
		//페이지를 리로드하지 않고 페이지 주소만 변경할 때 사용
		history.pushState(mCode, null, renewURL);
	} else {
		location.hash = "#"+mCode;
	}
	
	$('iframe[name="ifr"]').attr("src", url);
	
}	
