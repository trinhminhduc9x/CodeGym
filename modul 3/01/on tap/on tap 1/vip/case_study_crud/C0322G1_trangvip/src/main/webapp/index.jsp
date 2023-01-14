<%--
  Created by IntelliJ IDEA.
  User: Gia Nguyen Store
  Date: 8/4/2022
  Time: 9:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Furama Resort</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../style/bootstrap/normalize.css">
    <link rel="stylesheet" href="../style/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="../style/datatables/css/dataTables.bootstrap4.min.css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"/>
    <link rel="stylesheet" href="../style/style.css">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0"/>
</head>
<body>
<div class="container-fluid">
    <%@ include file="include/header.jsp"%>
    <div class="row col-lg-12">
        <div id="carouselExampleDark" class="carousel carousel-dark slide" data-bs-ride="carousel">
            <div class="carousel-indicators">
                <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active"
                        aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1"
                        aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="2"
                        aria-label="Slide 3"></button>
                <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="3"
                        aria-label="Slide 4"></button>
                <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="4"
                        aria-label="Slide 5"></button>
            </div>
            <div class="carousel-inner">
                <div class="carousel-item active" data-bs-interval="10000">
                    <img src="https://dulichvietnam.com.vn/vnt_upload/news/05_2020/4b72bd6a00b6fc4290e0f930b5d0733f_1.jpg"
                         class="d-block w-100 " height="600" alt="Not found">
                    <div class="carousel-caption d-none d-md-block">
                        <h1 class="text-light">Beautiful and clean beach</h1>
                    </div>
                </div>
                <div class="carousel-item" data-bs-interval="2000">
                    <img src="https://img.blogdulich.vn/2014/10/Furama-Resort-2-1280x720.jpg" class="d-block w-100"
                         height="600" alt="Not found">
                    <div class="carousel-caption d-none d-md-block">
                        <h1 class="text-light">Wonderful view</h1>
                    </div>
                </div>
                <div class="carousel-item" data-bs-interval="3000">
                    <img src="https://dambritourist.vn/kham-pha-thanh-pho-bien-da-nang-voi-furama-resort-danang/imager_146043.jpg"
                         class="d-block w-100 " height="600" alt="Not Found">
                    <div class="carousel-caption d-none d-md-block">
                        <h1 class="text-light">Furama sort</h1>
                    </div>
                </div>
                <div class="carousel-item" data-bs-interval="4000">
                    <img src="https://ticovilla.com/wp-content/uploads/2021/08/resort-da-nang-13.jpg"
                         class="d-block w-100 " height="600" alt="Not Found">
                    <div class="carousel-caption d-none d-md-block">
                        <h1 class="text-light">Cozy and beautiful space</h1>
                    </div>
                </div>
                <div class="carousel-item" data-bs-interval="5000">
                    <img src="http://datphongresort.com/wp-content/uploads/2020/10/he-thong-nha-hang-furama.jpg"
                         class="d-block w-100 " height="600" alt="Not Found">
                    <div class="carousel-caption d-none d-md-block">
                        <h1 class="text-light">Delicious and beautiful food</h1>
                    </div>
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark"
                    data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark"
                    data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
    </div>
    <div class="row p-5">
        <div class="col-lg-4 ">
            <h3 class="text-warning p-5">KHU NGHỈ DƯỠNG ĐẲNG CẤP THẾ GIỚI, FURAMA ĐÀ NẴNG, NỔI TIẾNG LÀ KHU NGHỈ DƯỠNG
                ẨM
                THỰC TẠI VIỆT NAM.</h3>
        </div>
        <div class="col-lg-4">
            <iframe width="400" height="300" src="https://www.youtube.com/embed/IjlT_4mvd-c" title="The Furama Resort
       DaNang - Couples Corporate" frameborder="0"
                    allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                    allowfullscreen></iframe>
        </div>
        <div class="col-lg-4"><span class="text-primary">Hướng ra bãi biển Đà Nẵng trải dài cát trắng, Furama Resort Đà Nẵng là cửa ngõ đến với 3 di sản văn hoá thế giới:
          Hội An (20 phút), Mỹ Sơn (90 phút) và Huế (2 tiếng. 196 phòng hạng sang cùng với 70 căn biệt thự từ hai đến bốn phòng ngủ có hồ bơi riêng
          đều được trang trí trang nhã, theo phong cách thiết kế truyền thống của Việt Nam và kiến trúc thuộc địa của Pháp, biến Furama thành khu
          nghỉ dưỡng danh giá nhất tại Việt Nam – vinh dự được đón tiếp nhiều người nổi tiếng, giới hoàng gia, chính khách, ngôi sao điện ảnh và các
          nhà lãnh đạo kinh doanh quốc tế.</span></div>
    </div>
    <div class="row p-5">
        <div class="col-lg-12"><h2 class="text-warning text-center">CÁC LOẠI PHÒNG</h2></div>
        <div class="row">
            <div class="col-lg-4"></div>
            <div class="col-lg-4 text-primary"> <span>Khu nghỉ dưỡng có 196 phòng được thiết
            kế theo phong cách truyền thống Việt Nam kết hợp với phong cách Pháp, 2 tòa nhà
            4 tầng có hướng nhìn ra biển, nhìn ra hồ bơi trong xanh và những khu vườn nhiệt
            đới xanh tươi mát. Ngoài ra, khu nghỉ dưỡng Furama còn cung cấp các liệu pháp spa,
            phòng xông hơi ướt, phòng xông hơi khô, dịch vụ mát-xa cạnh hồ bơi, các dịch vụ
            thể thao dưới nước và các lớp tập yoga và Thái Cực Quyền trên bãi biển.</span></div>
            <div class="col-lg-4"></div>
        </div>
    </div>
    <div class="row p-5">
        <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="false">
            <div class="carousel-indicators">
                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active"
                        aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1"
                        aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2"
                        aria-label="Slide 3"></button>
                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="3"
                        aria-label="Slide 4"></button>
                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="4"
                        aria-label="Slide 5"></button>
            </div>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="http://reviewvilla.vn/wp-content/uploads/2022/03/Khach-san-Ha-Noi-1.jpg"
                         class="d-block w-100" height="450" alt="Not found">
                    <div class="carousel-caption d-none d-md-block">
                        <h3 class="text-primary text-shadow">PHÒNG STUDIO HƯỚNG VƯỜN</h3>
                        <b class="text-primary text-shadow">Diện Tích Phòng 41.4 m<sup>
                            <smail>2</smail>
                        </sup></b>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="https://hotelmart.vn/uploads/2019/09/25/1271_i5d8b3014da5a5.jpg" class="d-block w-100"
                         height="450" alt="Not found">
                    <div class="carousel-caption d-none d-md-block">
                        <h3 class="text-primary text-shadow">PHÒNG SUITE HƯỚNG BIỂN</h3>
                        <b class="text-primary text-shadow">Diện Tích Phòng 45.4 m<sup>
                            <smail>2</smail>
                        </sup></b>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="https://kientrucroman.com.vn/wp-content/uploads/phong-ngu-hoang-gia-dep-logo.jpg"
                         class="d-block w-100" height="450" alt="Not found">
                    <div class="carousel-caption d-none d-md-block">
                        <h3 class="text-danger">PHÒNG VIP HƯỚNG VƯỜN</h3>
                        <b class="text-danger">Diện Tích Phòng 55.4 m<sup>
                            <smail>2</smail>
                        </sup></b>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="https://static.tuoitre.vn/tto/i/s626/2014/04/24/NY0OS9eR.jpg" class="d-block w-100"
                         height="450" alt="Not found">
                    <div class="carousel-caption d-none d-md-block">
                        <h3 class="text-danger">PHÒNG VIP HƯỚNG BIỂN</h3>
                        <b class="text-danger">Diện Tích Phòng 50.4 m<sup>
                            <smail>2</smail>
                        </sup></b>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="https://media.discordapp.net/attachments/1003230073119318028/1004766517864435894/imager_13_141153_700.jpeg"
                         class="d-block w-100" height="450" alt="Not found">
                    <div class="carousel-caption d-none d-md-block">
                        <h3 class="text-light">PHÒNG LOVE HƯỚNG VƯỜN</h3>
                        <b class="text-light">Diện Tích Phòng 40.4 m<sup>
                            <smail>2</smail>
                        </sup></b>
                    </div>
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions"
                    data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions"
                    data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
    </div>
    <%@include file="include/footer.jsp"%>
</div>
<script src="../style/jquery/jquery-3.5.1.min.js"></script>
<script src="../style/datatables/js/jquery.dataTables.min.js"></script>
<script src="../style/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="../style/bootstrap/bootstrap.bundle.min.js"></script>
</body>
</html>
