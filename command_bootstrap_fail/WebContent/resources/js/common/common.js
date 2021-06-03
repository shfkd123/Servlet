//pageination list up 함수
//page: 페이지번호, url : list url
//copyright 김민지 2021.06.01 ing ~~
function list_go(page, url) {

	if (!url)
		url = "list.do";

	var jobForm = $('#jobForm');

	jobForm.find('[name="page"]').val(page);
	jobForm.find('[name="perPageNum"]').val(
			$('select[name="perPageNum"]').val());
	jobForm.find('[name="searchType"]').val(
			$('select[name="searchType"]').val());
	jobForm.find('[name="keyword"]').val(
			$('div.input-group>input[name="keyword"]').val());

	jobForm.attr({
		action : 'list.do',
		method : 'get'
	}).submit();
}

//팝업창틀 띄우기
//새로운 Window창을 Open할 경우 사용되는 함수 (arg : 주소, 창타이틀, 넓이, 길이)
function OpenWindow(UrlStr, WinTitle, WinWidth, WinHeight) {
	winleft = (screen.width - WinWidth) / 2;
	wintop = (screen.height - WinHeight) / 2;
	var win = window.open(UrlStr, WinTitle, "scrollbars=yes, width=" + WinWidth
			+ ", " + "height=" + WinHeight + ", top=" + wintop + ", left="
			+ winleft + ", resizeable=yes, status=yes");
	win.focus();
}

//팝업창 닫기
function CloseWindow(parentURL) {
	//parentURL이 들어올 수도 안들어올 수 도 있다. 
	if(parentURL){
		window.opener.parent.location.href=parentURL;
	}else{
		window.opener.location.reload(true);
	}
	window.close();
}
