<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>자료실 수정페이지</title>
<body>	
	 <!-- Content Header (Page header) -->
    <section class="content-header">
    	<div class="container-fluid">
    		<div class="row mb-2">
    			<div class="col-sm-6">
	      			<h1>자료실</h1>
	      		</div>	      		
	    	
	       		
	       		<div class="col-sm-6">
			      <ol class="breadcrumb float-sm-right">
			        <li class="breadcrumb-item"><a href="list.do"><i class="fa fa-dashboard"></i>자료실</a></li>
			        <li class="breadcrumb-item active">리스트</li>		        
			      </ol>
		      	</div>
	     	</div>	     	
      	</div>
    </section>

   <!-- Main content -->
    <section class="content container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="card card-outline card-primary">
					<div class="card-header">
						<h3>자료 수정</h3>
					</div><!--end card-header  -->
					<div class="card-body">
						<form enctype="multipart/form-data" role="form" method="post" action="modify.do" name="modifyForm">
							<input type="hidden" name="pno" value="${pds.pno }" />
							
							<div class="form-group">
								<label for="writer">작성자</label> 
								<input type="text" id="writer" readonly
									name="writer" class="form-control" value="${pds.writer }">
							</div>
							<div class="form-group">
								<label for="title">제 목</label> 
								<input type="text" id="title" value="${pds.title }"
									name='title' class="form-control" placeholder="제목을 쓰세요">
							</div>
							<div class="form-group">
								<label for="content">내 용</label>
								<textarea id="content" name="content">${pds.content }</textarea>
							</div>
							
							<div class="form-group">								
								<div class="card card-outline card-success">
									<div class="card-header">
										<h3 style="display:inline;line-height:40px;">첨부파일 : </h3>
										&nbsp;&nbsp;<button class="btn btn-primary" 
										type="button" id="addFileBtn">Add File</button>
									</div>									
									<div class="card-footer fileInput">
										<ul class="mailbox-attachments d-flex align-items-stretch clearfix">										
											<c:forEach items="${pds.attachList }" var="attach" >
											<li class="attach-item">																			
												<div class="mailbox-attachment-info">
													<a class="mailbox-attachment-name" name="attachedFile" 
														attach-fileName="${attach.fileName }" attach-no="${attach.ano }" 
														href="<%=request.getContextPath()%>/attach/getFile.do?ano=${attach.ano }"  >													
														<i class="fas fa-paperclip"></i>
														${attach.fileName }&nbsp;&nbsp;
														<button type="button" style="border:0;outline:0;" class="badge bg-red">X</button>																									
													</a>													
												</div>
											</li>	
											</c:forEach>
										</ul>
										<br/>														
									</div> 
								</div>
							</div>
							
						
						</form>
					</div><!--end card-body  -->
					<div class="card-footer">
						<button type="button" class="btn btn-warning" id="modifyBtn" onclick="modify_submit();">수 정</button>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" class="btn" id="cancelBtn" onclick="history.go(-1);">취 소</button>
					</div><!--end card-footer  -->
				</div><!-- end card -->				
			</div><!-- end col-md-12 -->              
		</div><!-- end row --> 
    </section>
    <!-- /.content -->

<script>
window.onload=function(){
	Summernote_start($('#content'));
	
	$('a[name="attachedFile"] > button').click(function(event){
		var parent = $(this).parent('a[name="attachedFile"]');
		alert(parent.attr("attach-fileName") + "파일을 삭제합니다.");

		var ano = parent.attr("attach-no");
		
		$(this).parents('li.attach-item').remove();
		
		var input=$('<input>').attr({
			"type" : "hidden",
			"name" : "deleteFile",
			"value" : ano
		});
		
		$('form[role="form"]').prepend(input);
		
		//X버튼을 누르면 다운로드 가 되는 것을 방지해야 한다.
		return false; //이벤트 방지
	});
	
	//첨부파일==========================================
	$('#addFileBtn').on('click', function(event){
		alert("click add btn");
		var attachedFile = $('a[name="attachedFile"]').length;
		var inputFile = $('input[name="uploadFile"]').length;
		var attachCount = attachedFile+inputFile;
		
		if(attachCount >= 5){
			alert("파일 추가는 5개까지만 가능합니다.");
			return;
		}
		
		var input=$('<input>').attr({"type":"file","name":"uploadFile"}).css("display","inline"); 
		var div=$('<div>').addClass("inputRow");
		div.append(input).append("<button style='border:0;outline:0;' class='badge bg-red' type='button'>X</button");    		   		
		$('.fileInput').append(div);
	});
	
 	$('.fileInput').on('change','input[type="file"]',function(event){
 		if(this.files[0].size>1024*1024*40){
 			alert("파일 용량이 40MB를 초과하였습니다.");
 			this.value="";
 			$(this).click();		 			
 			return false;
 		} 
	});
 	
 	$('div.fileInput').on('click','div.inputRow > button',function(event){
 		$(this).parent('div.inputRow').remove();
 	});
 	
}

//submit====================================
function modify_submit(){
	//alert("click modify btn");
	
	var form = document.modifyForm;
	
	if($("input[name='title']").val()==""){
		alert(input.name+"은 필수입니다.");
		$("input[name='title']").focus();
		return;
	}
	
	var files = $('input[name="uploadFile"]');
	for (var file of files) {
		console.log(file.name+" : " +file.value);
		if(file.value==""){
			alert("파일을 선택하세요.");
			file.focus();
			return false;
		}
	}
	form.submit();
}

</script>

<%@ include file="/WEB-INF/views/common/summernote.jsp" %> 

</body>
  

  
 