<html>
<body>
<h2>Hello World!</h2>
<form action="<%=request.getContextPath()%>/Upload" method="post" enctype="multipart/form-data">
    <input type="file" name="files">
    <input type="submit" value="s" />
</form>
</body>
</html>
