<%@page pageEncoding="Windows-31J" contentType="application/xhtml+xml; charset=Shift_JIS" 
isELIgnored="false" session="false"%><%@taglib 
prefix="m" uri="http://taglibs.mobylet.org/" %><%@taglib 
prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@taglib 
prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%><%@taglib 
prefix="f" uri="http://www.slim3.org/functions"%>
<m:xmlheader/>
<html xml:lang="ja" xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>TwiHooo!</title>
</head>
<body>
<p>²�</p>
<br />
<br />
<form method="post" action="/twihooo">
<br />
<input type="text" ${f:text("targetId")} /><br />
<br />
<input type="hidden" name="firstTwiho" value="true" /><br />
<input type="submit" name="twihooo" value="²ΰ����" />
<br />
</form>
<br />
<br />
</body>
</html>
