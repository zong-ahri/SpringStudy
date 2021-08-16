<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Junil blog</title>
    <script src="https://kit.fontawesome.com/c3df4d7d1c.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.css" />
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />
    <link rel="stylesheet" href="/css/style.css" />
</head>
<body>
    <div id="container">
    	<c:choose>
    		<c:when test="${empty loginUserBean }">
		    	<jsp:include page="/WEB-INF/views/header_login.jsp"></jsp:include>
    		</c:when>
    		<c:otherwise>
		    	<jsp:include page="/WEB-INF/views/header_logout.jsp"></jsp:include>
    		</c:otherwise>
    	</c:choose>
        <main>
            <article id="mainimage">
                <div id="swiper-container__id" class="swiper-container">
			        <div class="swiper-wrapper">
			            <div class="swiper-slide"><img src="images/s1.png" width="100%"></div>
			            <div class="swiper-slide"><img src="images/s2.png" width="100%"></div>
			            <div class="swiper-slide"><img src="images/s3.png" width="100%"></div>
			        </div>
			
			        <div class="swiper-pagination"></div>
			        <div class="swiper-button-prev"></div>
			        <div class="swiper-button-next"></div>
			    </div>
            </article>
            <article id="mainboard">
                
            </article>
        </main>
        
        	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
        	
        </div>
    <script src="https://unpkg.com/swiper/swiper-bundle.js"></script>
    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
    <script src="js/swiper.js"></script>
    <script src="js/borderInsert.js"></script>
</body>
</html>