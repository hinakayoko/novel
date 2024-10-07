<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<style type="text/css">
a:link {
	text-decoration: none;
}
</style>
<body>

<div class="pageLists">
	<form>
		<pg:first export="pageUrl">
			<c:if test="${pageUrl!=null }">

					<a href="${pageUrl}" >
						 &laquo;
					</a>

			</c:if>
			<c:if test="${pageUrl==null }">

					<a href="#">
						 &laquo;
					</a>

			</c:if>
		</pg:first>




		<pg:pages>
			<c:choose>
				<c:when test="${currentPageNumber eq pageNumber }">

						<a href="#"  class="current">${pageNumber }</a>

				</c:when>
				<c:otherwise>


						<a href="${pageUrl }">${pageNumber }</a>

				</c:otherwise>
			</c:choose>
		</pg:pages>


		<pg:last export="pageUrl">

			<c:if test="${pageUrl!=null }">

					<a href="${pageUrl}" aria-label="下一页">
						 &raquo;
					</a>

			</c:if>

		</pg:last>


	</form>

</div>



</body>
</html>
