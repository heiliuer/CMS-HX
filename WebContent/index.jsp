<%@page import="com.google.gson.Gson"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hx.bean.News"%>
<%@page import="com.hx.bean.Sort"%>
<%
	if (request.getRequestURI().replaceAll("/", "").equals(request.getContextPath().replaceAll("/", ""))) {
		request.getRequestDispatcher("NewsServlet").forward(request, response);
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML>
<HEAD>
<META content="IE=11.0000" http-equiv="X-UA-Compatible">
<title>长江大学电信学院</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<SCRIPT language="javascript" src="static/_sitegray.js"></SCRIPT>
<script language="javascript" src="static/dynclicks.js"></script>
<script language="javascript" src="static/openlink.js"></script>
</HEAD>
<BODY>

	<%@include file="inc/top.jsp"%>

	<div id="banner">
		<c:set value="${sortNewsList[0] }" var="sortNews" />
		<c:set value="${sortNews.sort }" var="sort" />
		<div class="banner-xin" title="${sort.sortName }">
			<SCRIPT language="javascript" src="static/imagechangenews.js"></SCRIPT>
			<c:if test="${not empty sortNews}">
				<c:set value="${sortNews.news }" var="newss" />
				<c:if test="${not empty newss}">
					<div style="width: 1150px; height: 390px; overflow: hidden;">
						<div align="center" id="u_u35_div"
							style="margin: 0px; padding: 0px; border: 0px solid black; border-image: none; width: 1150px; height: 390px; background-color: rgb(0, 0, 0);">
							<div id="u_u35_imgdiv"
								style="padding: 0px; border: 0px currentColor; border-image: none;">
								<A id="u_u35_url" target="_blank"><IMG width="1150"
									height="390" id="u_u35_pic" src="static/space.gif" border="0"></A>
							</div>
						</div>
						<div
							style="margin: 0px; padding: 0px; border: 0px currentColor; border-image: none; top: -19px; width: 1150px; height: 19px; text-align: right; position: relative;">
							<c:forEach items="${newss }" var="news" varStatus="vst">
								<c:if test="${vst.index<=5 }">
									<A class="imagechangenews_pnode"
										id="u_u35_selectNode${vst.index }"
										href="javascript:u_u35_icn.changeimg(${vst.index })"
										target="_self">${vst.index+1}</A>
								</c:if>
							</c:forEach>
						</div>
					</div>
					<div
						style="background: linear-gradient(to right, rgba(0, 0, 0, 0.12), rgba(255, 255, 255, 0.04)); margin: 0px; padding: 0px; border: 0px currentColor; border-image: none; left: 0px; top: -40px; width: 850px; height: 50px; text-align: left; overflow: hidden; position: relative;">
						<div align="left"
							style='background: url("images/banner-icon.png"); padding: 0px 30px; width: 640px; height: 40px; line-height: 40px; overflow: hidden;'>
							<A class="titlestyle65492" id="u_u35_newstitle" target="_blank"></A>
						</div>
						<div align="left"
							style="width: 1150px; height: 0px; overflow: hidden; padding-right: 2px; padding-left: 2px; -ms-text-overflow: ellipsis;">
							<A class="summarystyle65492" id="u_u35_newssummary"
								target="_blank"></A>
						</div>
					</div>

					<c:forEach items="${newss }" var="news" varStatus="vst">
						<c:if test="${vst.index<=5 }">
							<script type="text/javascript">
								u_u35_icn
										.addimg(
												"/${news.imgUrlList[0]}",
												"/NewsServlet?action=selectNewsShow&newsClassId=${sort.id }&newsid=${news.id}",
												"${news.title}", "");
							</script>
						</c:if>
					</c:forEach>
					<script type="text/javascript">
						u_u35_icn.changeimg(0);
					</script>
				</c:if>
			</c:if>
		</div>

	</div>

	<div class="wenhua-xinwen">
		<div class="width auto">

			<!----校园文化-star--->
			<c:set value="${sortNewsList[1] }" var="sortNews" />
			<c:set value="${sortNews.sort }" var="sort" />
			<div class="xiaoyuan fl" title="${sort.sortName }">
				<div class="xy-biaoti bt-bg">${sort.sortName }</div>
				<div class="xiaoyuan-list">
					<c:if test="${not empty sortNews}">
						<c:set value="${sortNews.news }" var="newss" />
						<c:forEach items="${newss }" var="news" end="2" varStatus="vst">
							<DL class="${vst.index==0?'dl-f1':'dl-f2' }">
								<DT>
									<A
										href="/NewsServlet?action=selectNewsShow&newsClassId=${sort.id }&newsid=${news.id}"
										target="_blank"><IMG width="200" height="122"
										src="${news.imgList[0]}"></A>
								</DT>
								<DD>
									<div class="dd-bt">
										<A
											href="/NewsServlet?action=selectNewsShow&newsClassId=${sort.id }&newsid=${news.id}"
											target="_blank">${news.title }</A>
									</div>
									<div class="dd-zy">${fn:substring(news.content, 0, 40)}...</div>
									<div class="dd-zyxia">
										<font class="liulan fr"><A
											href="/NewsServlet?action=selectNewsShow&newsClassId=${sort.id }&newsid=${news.id}"
											target="_blank">...</A></font>
										<div class="clear"></div>
									</div>
								</DD>
							</DL>
						</c:forEach>
					</c:if>

					<div class="clear"></div>
				</div>
			</div>
			<!----校园文化-end---->


			<!----校园新闻-star--->
			<c:set value="${sortNewsList[2] }" var="sortNews" />
			<c:set value="${sortNews.sort }" var="sort" />
			<div class="xinwen fr" title="${sort.sortName }">
				<div class="xw-biaoti bt-bg">
					<A class="fl" 
						href="/NewsServlet?action=selectNewsList&newsClassId=${sort.id }"
						target="_blank">${sort.sortName }</A> <font class="liulan fr"><A
						style="font-size: 14px;"
						href="/NewsServlet?action=selectNewsList&newsClassId=${sort.id }"
						target="_blank">更多&gt;</A></font>
					<div class="clear"></div>
				</div>

				<div class="xinwen-list2">
					<c:if test="${not empty sortNews}">
						<c:set value="${sortNews.news }" var="newss" />
						<c:forEach items="${newss }" var="news" end="2" varStatus="vst">
							<div class="tzlb">
								<div class="lbwzk">
									<a class="lb ${news.newsType>0?'hot':'' }" target="_blank"
										href="NewsServlet?action=selectNewsShow&newsClassId=${sort.id }&newsid=${news.id }">${news.title }</a>
								</div>
								<div class="lbsjk">${news.createTime }</div>
							</div>
						</c:forEach>
					</c:if>
				</div>
			</div>
			<div class="clear"></div>
			<!----校园新闻-end--->

		</div>
	</div>

	<%@include file="inc/bottom.jsp"%>

</BODY>
</HTML>

