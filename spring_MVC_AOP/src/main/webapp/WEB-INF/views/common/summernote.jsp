<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<script>
function Summernote_start(targetObj){
	targetObj.summernote({
		placeholder: '여기에 내용을 적으세요.',
		height:250,
		disableResizeEditor: true,
		callbacks:{
			onImageUpload : function(files, editor, welEditable){
				//files는 배열
				//in 인덱스 ()
				//of element(실제로 파일 하나씩 꺼내준다.)
				//alert("이미지 업로드");
				for(var file of files) {
					//alert(file.name);
					if(file.size > 1024 * 1024 * 5){
						alert("이미지는 5MB 미만입니다.");
						return;
					}
					if(file.name.substring(file.name.lastIndexOf(".")+1).toUpperCase() !="JPG"){
						alert("JPG 이미지 형식만 가능합니다.");
						return;
					}
				}
				
				for(var file of files) {
					sendFile(file, this); //파일을 하나씩 받아서 ajax로 보낼건데 왜 저장을 할까요? 
	
				}
			},
			onMediaDelete : function(target) {
				//지웠을 때 어떤 정보가 오는지 확인해야 한다.
				//alert(target[0].src.split("=")[1]);
				var answer = confirm("정말 이미지를 삭제하시겠습니까?");
				if(answer){
					deleteFile(target[0].src);
				}
			}
		}
	});
}
function sendFile(file, el) {
	var form_data = new FormData();
	form_data.append("file", file);
	$.ajax({
		data: form_data,
		type: "POST",
		url: '<%=request.getContextPath()%>/uploadImg.do',
		cashe: false,
		contentType: false,
		processData: false,
		success: function(img_url) {
			$(el).summernote('editor.insertImage', img_url);
		},
		error:function(){
			alert("이미지 업로드에 실패했습니다.");
		}
	});
}

function deleteFile(src) {
	var splitSrc = src.split("=");
	var fileName = splitSrc[splitSrc.length-1];
	
	var fileData = {fileName:fileName};
	
	//json데이터를 만들고 string형태로 post해서 보낸다. 
	//json데이터라는것을 서버에게 알려줘야 하기 때무네 application를 붙인다.
	
	$.ajax({
		url:"<%=request.getContextPath()%>/deleteImg.do",
		data: JSON.stringify(fileData),
		type:"post",
		contextType:"application/json",
		success:function(res){
			console.log(res);
			//경로 가지고오고, 파일명 왔으면 exist 확인하고 지운다. 
			//지운 후 success 피드백을 준다.
		},
		error:function(){
			alert("이미지 삭제가 불가합니다.");
		}
	});
	
	//command 객체 
}
</script>