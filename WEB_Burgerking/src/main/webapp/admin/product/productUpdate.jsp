<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/admin/header.jsp" %>
<%@ include file="/admin/sub_menu.jsp"%>

<article>
	<h1>${productVO.kind2}번 상품 수정</h1>
	<form name="frm" method="post" enctype="multipart/form-data">
		<input type="hidden" name="pseq" value="${productVO.pseq}">
		<input type="hidden" name="oldImage" value="${productVO.image}">
		<table id="list" width="500">
			<tr>
				<th>상품분류</th>
				<td width="50">
					<select name="kind1">
						<c:forEach items="${kindList1}" var="kind" varStatus="status">
							<c:choose>
								<c:when test="${productVO.kind1==status.count}">
									<option value="${status.count}" selected="selected">${kind}</option>
								</c:when>
								<c:otherwise>
									<option value="${status.count}">${kind}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
				<th>분류번호</th>
				<td>
					<input type="text" name="kind2" size="3" maxlength="10-" value="${productVO.kind2}">
				</td>
				<th>세부</th>
				<td>
					<input type="text" name="kind3" size="3" maxlength="10-" value="${productVO.kind3}">
				</td>
				<th>가격</th>
				<td>
					<input type="text" name="price1" size="10" value="${productVO.price1}">
				</td>
				<th>사용유무</th>
				<td>
					<c:choose>
						<c:when test='${productVO.useyn == "1" }'>
							<input type="checkbox" name="useyn" value="y" checked="checked">
						</c:when>
						<c:otherwise>
							<input type="checkbox" name="useyn" value="n">
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			
			<tr>
				<th>상품명</th>
				<td colspan="9">
					<input type="text" name="name" size="80" maxlength="10-" value="${productVO.pname}">
				</td>
			</tr>
			<tr>
				<th>상세설명</th>
				<td colspan="9">
					<textarea rows="8" cols="80" name="content">${productVO.content}</textarea>
				</td>
			</tr>
			<tr>
				<th>상품이미지</th>
				<td colspan="9">
					<img src="image/menu/${productVO.kind1}/${productVO.image}" width="200px"><br>
					<input type="file" name="image">
				</td>
			</tr>
		</table>
		<input type="button" class="btn" value="수정" onclick="go_mod_save()">
		<input type="button" class="btn" value="취소" onclick=
		"location.href='burger.do?command=adminProductDetail&pseq=${productVO.pseq}'">
	</form>
</article>

<%@ include file="/admin/footer.jsp"%>