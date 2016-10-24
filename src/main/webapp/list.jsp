<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String basePath = request.getContextPath(); %>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的购物车</title>
</head>
<body>
		<a href="">搜索商品</a>&nbsp;
		<BR>
			本系统的所有商品列表如下：
			<BR>
			<BR>
			<TABLE width=800 border=1>
				<TBODY>
					<TR height=50>
						<TD>
							产品图片
						</TD>
						<TD>
							产品名称
						</TD>
						<TD>
							产品价格
						</TD>
						<TD>
							产品描述
						</TD>
						<TD>
							添加到购物车
						</TD>
					</TR>					
					<s:iterator value ="productlist" var="p">
					<TR>
						<TD>																											
						<img src="" style="height:60px; width:80px" />														
						</TD>						
						<TD>
						<s:property value="#p.name"/> |
						</TD>						
						<TD>
						<s:property value="#p.price"/> |
						</TD>						
						<TD>
						<s:property value="#p.description"/> |
						</TD>												
						<TD>												
						<a href="">添加到购物车</a>						
						</TD>
					</TR>
						</s:iterator>
				</TBODY>
			</TABLE>
			<BR>				
				<s:set name="page" value="#request['page']" />				
				<s:set name="maxpage" value="#request['maxpage']" />					
				<s:if test="#page==1">首页</s:if>	
				<s:if test="#page>1 "><a href="<%=basePath %>/from/listaction!list?page=1"> 首页</a></s:if>					
				<s:if test="#page == 1 ">上一页</s:if>					
				<s:if test="#page>1 "><a href="<%=basePath %>/from/listaction!list?page=${page-1}"> 上一页</a></s:if>					
				<s:if test="#page ==#maxpage">下一页</s:if>					
				<s:if test="#page< #maxpage "><a href="<%=basePath %>/from/listaction!list?page=${page + 1}"> 下一页</a></s:if>					
				<s:if test="#page == #maxpage">末页</s:if>					
				<s:if test="#page< #maxpage  "><a href="<%=basePath %>/from/listaction!list?page=${maxpage}">末页</a></s:if>																								
			<BR>			
			<a href="">查看购物车</a>&nbsp;
			<a href="">结帐</a>&nbsp;
			<a href=""> 返回首页</a>&nbsp;
			<a href="">登录</a>&nbsp;
			<a href="">注册</a>&nbsp;		
</body>
</html>