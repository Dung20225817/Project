<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"><!-- lấy kí hiệu đặc biệt -->
    <title>Trang Web Rạp Chiếu Phim</title>
    <link rel="stylesheet" type="text/css" href="css/style.css"><!-- link lấy css -->
    <style>
    #hero{
    background-image: url("img/natra.png") ; 
    }
    #hero button{
    background-image: url("img/button.png");
    }
    #header .logo {
    width: 80px;  /* Điều chỉnh kích thước chiều rộng */
    height: auto;  /* Giữ tỷ lệ khung hình */
    border-radius: 50%;
    object-fit: cover;
    }
    </style>
</head>
<body>
   <section id="header">
       <a href="#"><img src="img/newlogo.png" class="logo"></a>


    <div><!-- Không có ý nghĩa về mặt nội dung, chỉ giúp bố cục trang -->
        <ul id="navbar">     <!-- Dùng để tạo danh sách các mục có dấu đầu dòng (bullet points). -->
            <li><a class="active" href="homepage.jsp">Home</a></li> <!-- tạo list danh sách -->
            <li><a href="showmoviepageservlet">Movie</a></li>
            <li><a href="showorderpageservlet">Order</a></li>
            <li><a href="showaccountpageservlet">Account</a></li>
            <li><a href="showcinemainformationservlet">Contact</a></li>
            
        </ul>
    </div>
</section>
<!-- Home page -->
 <section id="hero" >
    <h4>Phim trong tháng</h4>
    <h2>Top 1 thịnh hành</h2>
    <h1>Natra: Ma đồng Náo Hải</h1>
    <p>Phát hành ngày 12-3-2024 </p>
    <button>mua ngay</button>
 </section>

 <!-- feature [tinh nang] -->
<section id="feature" class="section-p1">
    <div class="fe-box">
        <a href="showtimeservlet">
        <img src="img/features/f1.png">
        </a>
        <h6>Lich phim</h6>
    </div>
    <div class="fe-box">
        <a href="incomeservlet">
        <img src="img/features/f2.png">
        </a>
        <h6>Doanh thu</h6>
    </div>
    <div class="fe-box">
        <a href="showcustomerinformationservlet">
        <img src="img/features/f3.png">
        </a>
        <h6>thong tin khach hang</h6>
    </div>
    <div class="fe-box">
         <a href="showemployeeinformationservlet">
        <img src="img/features/f4.png">
         </a>
        <h6>thong tin nhan vien</h6>
    </div>
   <div class="fe-box">
       <a href="showcinemainformationservlet">
           <img src="img/features/f5.png"><!-- comment -->
       </a>
        <h6>Thông tin doanh nghiệp</h6>
    </div>
<!--     <div class="fe-box">
        <img src="img/features/f6.png">
        <h6>Ho tro 24/7</h6>
    </div>-->
</section>

<!-- product -->
 <section id="product1" class="section-p1">
    <h2>Phim đang chiếu</h2>
    <p>Cập nhật theo tuần</p>
    <div class="pro-container">
             <c:forEach var="movie" items="${ListMovieWeek}">
                 <div class="pro">
                 <img src="${movie.mvposter}" alt="">
                  <div class="des">
                 <span>${movie.mvname}</span>
                <h5>${movie.mvtime}</h5>
                 <div class="star">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                </div>
                  </div>
                <h4>${movie.mvprice} $</h4>
               <form action="searchmovieservlet" method="get" id="search">
                    <button type="submit" name="mvid" value="${movie.mvid}"><i class="fa fa-search"></i></button>
                </form>  
                </div>
              </c:forEach>   
                
    </div>
 </section>
    
  
    

</body>
</html>
