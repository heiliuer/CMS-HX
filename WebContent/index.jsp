<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>长江大学</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<SCRIPT language="javascript" src="static/_sitegray.js"></SCRIPT>
<script language="javascript" src="static/dynclicks.js"></script>
<script language="javascript" src="static/openlink.js"></script>
</HEAD>
<BODY>

	<%@include file="inc/top.jsp"%>

	<div id="banner">
		<div class="banner-xin">
			<TABLE style="border: 0px currentColor; border-image: none;"
				border="0" cellspacing="0" cellpadding="0">
				<TBODY>
					<TR>
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
								<A class="imagechangenews_pnode" id="u_u35_selectNode0"
									href="javascript:u_u35_icn.changeimg(0)" target="_self";="">1</A><A
									class="imagechangenews_pnode" id="u_u35_selectNode1"
									href="javascript:u_u35_icn.changeimg(1)" target="_self";="">2</A><A
									class="imagechangenews_pnode" id="u_u35_selectNode2"
									href="javascript:u_u35_icn.changeimg(2)" target="_self";="">3</A><A
									class="imagechangenews_pnode" id="u_u35_selectNode3"
									href="javascript:u_u35_icn.changeimg(3)" target="_self";="">4</A><A
									class="imagechangenews_pnode" id="u_u35_selectNode4"
									href="javascript:u_u35_icn.changeimg(4)" target="_self";="">5</A><A
									class="imagechangenews_pnode" id="u_u35_selectNode5"
									href="javascript:u_u35_icn.changeimg(5)" target="_self";="">6</A>
							</div>
						</div>
						<div
							style="background-color: rgba(66, 66, 66, 0.42);margin: 0px; padding: 0px; border: 0px currentColor; border-image: none; left: 0px; top: -40px; width: 850px; height: 50px; text-align: left; overflow: hidden; position: relative;">
							<div align="left;"
								style='background: url("images/banner-icon.png"); padding: 0px 30px; width: 640px; height: 40px; line-height: 40px; overflow: hidden; margin-left: 100px;'>
								<A class="titlestyle65492" id="u_u35_newstitle" target="_blank"></A>
							</div>
							<div align="left"
								style="width: 1150px; height: 0px; overflow: hidden; padding-right: 2px; padding-left: 2px; -ms-text-overflow: ellipsis;"
								display="none">
								<A class="summarystyle65492" id="u_u35_newssummary"
									target="_blank"></A>
							</div>
						</div>
					</TR>
				</TBODY>
			</TABLE>
		</div>
		<SCRIPT language="javascript" src="static/imagechangenews.js"></SCRIPT>
	</div>

	<div class="wenhua-xinwen">
		<div class="width auto">
			<!----校园文化-star--->
			<div class="xiaoyuan fl">
				<div class="xy-biaoti bt-bg">关注</div>
				<div class="xiaoyuan-list">
					<DL class="dl-f1">
						<SCRIPT language="javascript" src="static/jquery-latest.min.js"></SCRIPT>

						<DT>
							<A href="http://news.xidian.edu.cn/" target="_blank"><IMG
								width="200" height="122" src="static/2gb6g8g9m4.jpg"></A>
						</DT>
						<DD>
							<div class="dd-bt">
								<A href="http://news.xidian.edu.cn/" target="_blank">长大新增奖励</A>
							</div>
							<div class="dd-zy">4月22日，教育部公布了2015年度“长江学者奖励计划”入选名单，长江大学共有5人入选。其中，通信工程学院李云松教授和电...</div>
							<div class="dd-zyxia">
								<font class="liulan fr"><A
									href="http://news.xidian.edu.cn/" target="_blank">...</A></font>
								<div class="clear"></div>
							</div>
						</DD>
						<SCRIPT>
							_showDynClickBatch([ 'dynclicks_u36_29937' ],
									[ 29937 ], "wbnews", 1228415538)
						</SCRIPT>
					</DL>
					<DL class="dl-f2">
						<DT>
							<A href="http://www.xidian.edu.cn/jyjx/xdyc.htm" target="_blank"><IMG
								width="200" height="122" src="static/38tlubi7z1.jpg"></A>
						</DT>
						<DD>
							<div class="dd-bt">
								<A href="http://www.xidian.edu.cn/jyjx/xdyc.htm" target="_blank">长大英才</A>
							</div>
							<div class="dd-zy">学校着力营造凝心聚力的办学环境，不拘一格育引汇聚一流英才，锻造了一支师德高尚、业务精湛、结构合理、充满活力的高水平师资队伍。</div>
							<div class="dd-zyxia">
								<font class="liulan fr"><A
									href="http://www.xidian.edu.cn/jyjx/xdyc.htm" target="_blank">...</A></font>
								<div class="clear"></div>
							</div>
						</DD>
						<SCRIPT>
							_showDynClickBatch([ 'dynclicks_u37_29399' ],
									[ 29399 ], "wbnews", 1228415538)
						</SCRIPT>
					</DL>
					<DL class="dl-f2">
						<DT>
							<A href="http://dag.xidian.edu.cn/" target="_blank"><IMG
								width="200" height="122" src="static/2th14zfwx8.jpg"></A>
						</DT>
						<DD>
							<div class="dd-bt">
								<A href="http://dag.xidian.edu.cn/" target="_blank">长大往事</A>
							</div>
							<div class="dd-zy">在这里，你可以品味那部永不消逝的电波史：你可以分享那些可歌可泣的红色传奇；你可以重温那段激情燃烧的光辉岁月！从这里走进长大的...</div>
							<div class="dd-zyxia">
								<font class="liulan fr"><A
									href="http://dag.xidian.edu.cn/" target="_blank">...</A></font>
								<div class="clear"></div>
							</div>
						</DD>
						<SCRIPT>
							_showDynClickBatch([ 'dynclicks_u38_29225' ],
									[ 29225 ], "wbnews", 1228415538)
						</SCRIPT>
						<!--#endeditable-->
					</DL>
					<div class="clear"></div>
				</div>
			</div>
			<!----校园文化-end---->


			<!----校园新闻-star--->
			<div class="xinwen fr">
				<div class="xw-biaoti bt-bg">
					<A class="fl" href="http://news.xidian.edu.cn/" target="_blank">新闻</A>
					<font class="liulan fr"><A style="font-size: 14px;"
						href="http://news.xidian.edu.cn/" target="_blank">更多&gt;</A></font>
					<div class="clear"></div>
				</div>


				<UL class="xinwen-list">
					<!-- <IFRAME width="400" height="360" src="static/xinwenwang.htm"
						border="0" frameborder="0" marginwidth="0" marginheight="0"
						scrolling="no" style="background: none;" target="_blank"></IFRAME> -->

					<div class="xinwen-list2">
						<c:forEach items="${listNews }" var="news">
							<div class="tzlb">
								<div class="lbwzk">
									<a class="lb"
										href="NewsServlet?action=selectNewsShow&newsClassId=19&newsid=${news.id }">${news.title }</a>
								</div>
								<div class="lbsjk">${news.createTime }</div>
							</div>
						</c:forEach>

					</div>
				</UL>
			</div>
			<!----校园新闻-end--->
			<div class="clear"></div>
		</div>
	</div>


	<%@include file="inc/bottom.jsp"%>
	
</BODY>
</HTML>

