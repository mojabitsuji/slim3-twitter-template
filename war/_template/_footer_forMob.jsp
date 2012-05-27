<%@page pageEncoding="Windows-31J" isELIgnored="false" session="false"%><%@taglib 
prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@taglib 
prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%><%@taglib 
prefix="f" uri="http://www.slim3.org/functions"%><%@taglib 
prefix="m" uri="http://taglibs.mobylet.org/" %><%
pageContext.setAttribute("hostname", "http://" + request.getServerName() + (request.getServerPort() == 80 ? "" : ":" + request.getServerPort()));
%><br />
<hr color="#333333" size="1" />
<div style="font-size:small;">
<ul>
  <li><m:a href="/news">‚¨’m‚ç‚¹</m:a></li>
  <li><m:a href="/agreement">—˜—p‹K–ñ</m:a></li>
  <li><m:a href="http://coxs.jp/">‰^‰c‰ïŽÐ</m:a></li>
  <li><m:a href="">»Îß°ÄºÐ­ÆÃ¨</m:a></li>
  <li><m:a href="/top">TOP‚Ö</m:a></li>
</ul>
</div>

<div style="font-size:xx-small;">
<hr color="#333333" />
<div style="background-color:${decorate.borderColor};"><img src="/img/line.gif" width="100%" height="2" /></div>
<div style="background-color:${decorate.decorateColor};"><img src="/img/line.gif" width="100%" height="2" /></div>
<div style="background-color:${decorate.borderColor}; color:${decorate.decorateColor}; text-align: center;">Copyright COXS<br />All right reserved.</div>
</div>

<jsp:include page="/_template/_analytics_forMob.jsp" />
