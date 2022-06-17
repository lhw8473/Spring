﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
    <%@ include file="../include/header.jsp" %>
    
    
    <section>
        <div class="container-fluid">
            <div class="row">
                <!--lg에서 9그리드, xs에서 전체그리드-->   
                <div class="col-lg-9 col-xs-12 board-table">
                    <div class="titlebox">
                        <p>자유게시판</p>
                    </div>
                    <hr>
                    
                    <!--form select를 가져온다 -->
            <form>
		    		<div class="search-wrap">
                       <button type="button" class="btn btn-info search-btn">검색</button>
                       <input type="text" class="form-control search-input">
                       <select class="form-control search-select">
                            <option>제목</option>
                            <option>내용</option>
                            <option>작성자</option>
                            <option>제목+내용</option>
                       </select>
                    </div>
		    </form>
                   
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>번호</th>
                                <th class="board-title">제목</th>
                                <th>작성자</th>
                                <th>등록일</th>
                                <th>수정일</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:forEach var="vo" items="${boardList}">
	                            <tr>
	                                <td>${vo.bno}</td>
	                                <td><a href="<c:url value='/freeBoard/freeDetail?bno=' />">${vo.title}</a></td>
	                                <td>${vo.writer}</td>
	                                <td>${vo.regDate}</td>
	                                <td>${vo.updateDate}</td>
	                            </tr>
                            </c:forEach>
                        </tbody>
                        
                    </table>


                    <!--페이지 네이션을 가져옴-->
		    <form>
                    <div class="text-center">
                    <hr>
                    <ul class="pagination pagination-sm">
                    <c:if test="${pcv.prev }">
                        <li><a href="<c:url value='/freeBoard/freeList?pageNum=${pcv.beginPage -1 }&cpp=${pcv.paging.cpp }'/>">이전</a></li>
                    </c:if>
                    
                    <c:forEach var = "page" begin="${pcv.beginPage }" end = "${pcv.endPage }">
                        <li  class="active"><a href="<c:url value='/freeBoard/freeList?pageNum=${page }'/>">${page}</a></li>
                        <!-- <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li> -->
                        
                    </c:forEach>
                    
                    <c:if test="${pcv.next}">
                        <li><a href="<c:url value='/freeBoard/freeList?pageNum=${pcv.paging.pageNum + 1 }'/>">다음</a></li>
                    </c:if>
                    </ul>
                    <button type="button" class="btn btn-info" onclick="location.href='<c:url value="/freeBoard/freeRegist" />'">글쓰기</button>
                    </div>
		    </form>

                </div>
            </div>
        </div>
	</section>
	
	<%@ include file="../include/footer.jsp" %>


