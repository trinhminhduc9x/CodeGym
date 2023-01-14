<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 8/6/2022
  Time: 10:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/view/include/navbar.jsp" %>

<html lang="en">
<head>
  <title>Title</title>
  <link rel="stylesheet" href="bootstrap-5.0.2-dist/css/bootstrap.min.css">
  <style>
    /*body{*/
    /*  background: url("https://img.freepik.com/free-vector/soft-colorful-watercolor-texture-decorative-background-vector_1055-12347.jpg?w=2000");*/
    /*}*/
    #background-video {
      height: 100vh;
      width: 100vw;
      object-fit: cover;
      position: fixed;
      left: 0;
      right: 0;
      top: 0;
      bottom: 0;
      z-index: -1;
    }
    /* page content */
    h2 {
      color: white;
      font-family: Trebuchet MS;
      font-weight: bold;
      text-align: center;
    }

    h1 {
      font-size: 600%;
      margin: 30vh;
      color: #f1df9d;
      font-family: "Times New Roman";
      font-weight: bold;
      text-align: center;
      font-style: italic;

    }
    h2 { font-size: 3rem; }
    @media (max-width: 750px) {
      #background-video { display: none; }
      body {
        background: url("https://www.danang.intercontinental.com/wp-content/uploads/2021/12/Final_Ambient_Header_v5_Sep8_MED.mp4") no-repeat;
        background-size: cover;
      }
    }
  </style>
</head>
<body>
<video id="background-video" autoplay loop muted poster="https://assets.codepen.io/6093409/river.jpg">
  <source src="https://www.danang.intercontinental.com/wp-content/uploads/2021/12/Final_Ambient_Header_v5_Sep8_MED.mp4" type="video/mp4">
</video>
<!--Slider-->
<div class="container d-flex justify-content-center">
  <div class="row">
    <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
      <div class="carousel-indicators">
      </div>
      <div>
        <h1 >  WELCOME TO FURAMA </h1>
      </div>
    </div>

  </div>
</div>
</div>

<!--Content-->
<div class="container">
  <div class="row mt-5">
    <div class="col-md-4">
      <p class="fs-4 text-uppercase text-info text-center">THIS WORLD CLASS RESORT, FURAMA DANANG, REPUTABLE FOR
        BEING A CULINARY RESORT IN VIET NAM
      </p>
    </div>
    <div class="col-md-4">
      <iframe width="90%" height="90%" src="https://www.youtube.com/embed/IjlT_4mvd-c"
              title="The Furama Resort DaNang - Couples Corporate" frameborder="0"
              allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
              allowfullscreen></iframe>
    </div>
    <div class="col-md-4">
      <p class="text-secondary text-info ">Overlooking the long stretch of wide white sand on Danang Beach, Furama Resort Danang is a gateway to
        three World Heritage Sites of Hoi An (20 minutes), My Son (90 minutes) and Hue (2 hours). The 198 rooms
        and suites plus 70 two to four bedroom pool villas feature tasteful décor, designed with traditional
        Vietnamese style and a touch of French colonial architecture and guarantee the Vietnam’s the most
        prestigious resort -counting royalty, presidents, movie stars and international business leaders among
        its celebrity guests.</p>
    </div>
  </div>
  <div class="card m-3" style="max-width: 90%">
    <div class="row g-0">
      <div class="col-md-6">
        <img src="https://furamavietnam.com/wp-content/uploads/2018/07/CULIRARY.jpg"
             class="img-fluid rounded-start" alt="img1">
      </div>
      <div class="col-md-6">
        <div class="p-5">
          <div class="card-body">
            <h5 class="card-title text-center text-info">RECREATION</h5>
            <p class="card-text">
              A full range of Water Sports will keep you busy. Stop by the Water Sport House where our
              experienced staff are waiting to assist or train you in the use of any of our equipment.</p>
            <a href="#" class="btn bg-success text-white">Read more</a>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="card m-3" style="max-width: 90%">
    <div class="row g-0">
      <div class="col-md-6">
        <div class="card-body">
          <div class="p-5">
            <h5 class="card-title text-center text-info">CULINARY</h5>
            <p class="card-text">The resort’s culinary experience features a mixture of the authentic and
              locally inspired Vietnamese, Asian, Italian and other European cuisines plus the best imported
              steaks. The resort presents guests with varied gastronomic venues – the hip and breezy bar
              overlooking the beach, the exclusive Lagoon pool surrounded by a tropical garden, the true
              Italian flare offered at the Don Cipriani’s, the refined Asian touch at Café Indochine or the
              authentic central Vietnam cuisine at the Danaksara.</p>
            <a href="#" class="btn bg-success text-white">Read more</a>
          </div>
        </div>
      </div>
      <div class="col-md-6">
        <img src="https://furamavietnam.com/wp-content/uploads/2018/07/RECREATION.jpg"
             class="img-fluid rounded-start" alt="img1">
      </div>
    </div>
  </div>
  <div class="card m-3" style="max-width: 90%">
    <div class="row g-0">
      <div class="col-md-6">
        <img src="https://furamavietnam.com/wp-content/uploads/2018/10/02.-ICP-ICP_Furama_Danang_-Ball-Room-4.jpg"
             class="img-fluid rounded-start" alt="img1">
      </div>
      <div class="col-md-6">
        <div class="card-body">
          <div>
            <h5 class="card-title text-center text-info">MEETING & EVENT</h5>
            <p class="card-text">
              A well-appointed International Convention Palace with ballrooms can accommodate up to 1,000
              people in style, with another ten function rooms for 50 to 300 people each. A variety of
              cultural-themed parties on the beach or around the lagoon, in the ballrooms or outside the
              resort, with the surprising arrivals of VIPs from Helicopter landing on the resort’s own
              Helipad…</p>
            <a href="#" class="btn bg-success text-white">Read more</a>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<!-- Footer -->
<footer class="text-center text-lg-start bg-light text-muted">
  <!-- Section: Social media -->
  <section class="d-flex justify-content-center justify-content-lg-between p-4 border-bottom">
    <!-- Left -->

    <!-- Left -->

    <!-- Right -->
    <div>
      <a href="" class="me-4 text-reset">
        <i class="fab fa-facebook-f"></i>
      </a>
      <a href="" class="me-4 text-reset">
        <i class="fab fa-twitter"></i>
      </a>
      <a href="" class="me-4 text-reset">
        <i class="fab fa-google"></i>
      </a>
      <a href="" class="me-4 text-reset">
        <i class="fab fa-instagram"></i>
      </a>
      <a href="" class="me-4 text-reset">
        <i class="fab fa-linkedin"></i>
      </a>
      <a href="" class="me-4 text-reset">
        <i class="fab fa-github"></i>
      </a>
    </div>
    <!-- Right -->
  </section>
  <!-- Section: Social media -->

  <!-- Section: Links  -->
  <section class="">
    <div class="container text-center text-md-start mt-5">
      <!-- Grid row -->
      <div class="row mt-3">
        <!-- Grid column -->
        <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
          <!-- Content -->
          <h6 class="text-uppercase fw-bold mb-4">
            <i class="fas fa-gem me-3"></i>Company name
          </h6>
          <p>
            Here you can use rows and columns to organize your footer content. Lorem ipsum
            dolor sit amet, consectetur adipisicing elit.
          </p>
        </div>
        <!-- Grid column -->

        <!-- Grid column -->
        <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
          <!-- Links -->
          <h6 class="text-uppercase fw-bold mb-4">
            Products
          </h6>
          <p>
            <a href="#!" class="text-reset">Angular</a>
          </p>
          <p>
            <a href="#!" class="text-reset">React</a>
          </p>
          <p>
            <a href="#!" class="text-reset">Vue</a>
          </p>
          <p>
            <a href="#!" class="text-reset">Laravel</a>
          </p>
        </div>
        <!-- Grid column -->

        <!-- Grid column -->
        <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
          <!-- Links -->
          <h6 class="text-uppercase fw-bold mb-4">
            Useful links
          </h6>
          <p>
            <a href="#!" class="text-reset">Pricing</a>
          </p>
          <p>
            <a href="#!" class="text-reset">Settings</a>
          </p>
          <p>
            <a href="#!" class="text-reset">Orders</a>
          </p>
          <p>
            <a href="#!" class="text-reset">Help</a>
          </p>
        </div>
        <!-- Grid column -->

        <!-- Grid column -->
        <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
          <!-- Links -->
          <h6 class="text-uppercase fw-bold mb-4">Contact</h6>
          <p><i class="fas fa-home me-3"></i> New York, NY 10012, US</p>
          <p>
            <i class="fas fa-envelope me-3"></i>
            info@example.com
          </p>
          <p><i class="fas fa-phone me-3"></i> + 01 234 567 88</p>
          <p><i class="fas fa-print me-3"></i> + 01 234 567 89</p>
        </div>
        <!-- Grid column -->
      </div>
      <!-- Grid row -->
    </div>
  </section>
  <!-- Section: Links  -->


</footer>
<!-- Footer -->
<script src="bootstrap-5.0.2-dist/js/bootstrap.min.js"></script>
</body>
</html>