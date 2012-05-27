<%@page pageEncoding="Windows-31J" isELIgnored="false" session="false"%><%@taglib 
prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@taglib 
prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%><%@taglib 
prefix="f" uri="http://www.slim3.org/functions"%><%@taglib 
prefix="m" uri="http://taglibs.mobylet.org/" %>

${f:h(_totalSize_)}件&nbsp;${f:h(_pagerCount_)}ﾍﾟｰｼﾞ<br />
<div align="center">
<c:if test="${!_prev_}">
前へ
</c:if>
<c:if test="${_prev_}">
<m:a href="${f:h(_prevUrl_)}">前へ</m:a>
</c:if>
<c:forEach var="l" items="${_links_}">
<c:if test="${!l.current}">
<m:a href="${f:h(l.linkUrl)}">${f:h(l.linkNo)}</m:a>
</c:if>
<c:if test="${l.current}">
${f:h(l.linkNo)}
</c:if>
</c:forEach>
<c:if test="${!_next_}">
次へ
</c:if>
<c:if test="${_next_}">
<m:a href="${f:h(_nextUrl_)}">次へ</m:a>
</c:if>
</div>
<br />
