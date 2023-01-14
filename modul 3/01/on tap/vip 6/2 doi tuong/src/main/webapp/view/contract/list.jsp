<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 8/8/2022
  Time: 11:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="bootstrap-5.0.2-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css" />


<html>
<head>
    <title>Title</title>
    <style>
        body {
            background: url("https://img.freepik.com/premium-vector/galaxy-fantasy-background-with-pastel-color_38409-1774.jpg?w=2000")
        }
    </style>
</head>
<body>
<!--navbar-->
<div class="fixed-top" style="margin: 0">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class=" navbar-nav me-auto mb-2 mb-lg-0">
                    <div class="container" style="width: 60px;height: 60px">
                        <a class="navbar-brand" href="/Furama">
                            <img class="img-fluid"
                                 src="https://furamavietnam.com/wp-content/uploads/2018/08/logo@2x.png" alt="">
                        </a>
                    </div>

                    <li class="nav-item">
                        <a class="nav-link  fw-bold" href="/Furama?action=employee">Employee</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link  fw-bold" href="/Furama?action=customer" tabindex="-1" aria-disabled="true">Customer</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link  fw-bold" href="/Furama?action=service" tabindex="-1" aria-disabled="true">Service</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link  fw-bold" href="/Furama?action=contract" tabindex="-1" aria-disabled="true">Contract</a>
                    </li>
                </ul>
                <form class="d-flex ">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
                <div>
                    <a href="">Nguyễn Trần Thảo Nhiên</a>
                </div>
            </div>
        </div>
    </nav>
</div>
<div style="height: 150px;"></div>
<h1 class="p-3 text-white text-center bg-danger">LIST CONTRACT</h1>

    <div class="container mt-5 mb-5">
        <table id="listContract" class="table table-hover table-bordered">
            <thead class="bg-danger text-white fw-bold text-center">
            <tr>
                <th>#</th>
                <th>Dịch vụ</th>
                <th>Khách hàng</th>
                <th>Ngày bắt đầu</th>
                <th>Ngày kết thúc</th>
                <th>Tiền Đặt cọc</th>
                <th>Tổng Tiền</th>
                <th>Dịch vụ đi kèm</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1</td>
                <td>Room twin 01</td>
                <td>Nguyễn Thị Hào</td>
                <td>08/12/2021</td>
                <td>12/12/2021</td>
                <td>0</td>
                <td>1000000</td>
                <td>
                    <div class="d-flex justify-content-around">
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addContract">
                            +
                        </button>
                            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#listService">
                                Danh sách các dịch vụ đi kèm
                            </button>
                        </div>

                </td>
            </tr>
            <tr>
                <td>1</td>
                <td>Room twin 01</td>
                <td>Nguyễn Thị Hào</td>
                <td>08/12/2021</td>
                <td>12/12/2021</td>
                <td>0</td>
                <td>1000000</td>
                <td>
                    <div class="d-flex justify-content-around">
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addContract">
                            +
                        </button>
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#listService">
                            Danh sách các dịch vụ đi kèm
                        </button>
                    </div>

                </td>
            </tr>
            <tr>
                <td>1</td>
                <td>Room twin 01</td>
                <td>Nguyễn Thị Hào</td>
                <td>08/12/2021</td>
                <td>12/12/2021</td>
                <td>0</td>
                <td>1000000</td>
                <td>
                    <div class="d-flex justify-content-around">
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addContract">
                            +
                        </button>
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#listService">
                            Danh sách các dịch vụ đi kèm
                        </button>
                    </div>

                </td>
            </tr>
            <tr>
                <td>1</td>
                <td>Room twin 01</td>
                <td>Nguyễn Thị Hào</td>
                <td>08/12/2021</td>
                <td>12/12/2021</td>
                <td>0</td>
                <td>1000000</td>
                <td>
                    <div class="d-flex justify-content-around">
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addContract">
                            +
                        </button>
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#listService">
                            Danh sách các dịch vụ đi kèm
                        </button>
                    </div>

                </td>
            </tr>
            <tr>
                <td>1</td>
                <td>Room twin 01</td>
                <td>Nguyễn Thị Hào</td>
                <td>08/12/2021</td>
                <td>12/12/2021</td>
                <td>0</td>
                <td>1000000</td>
                <td>
                    <div class="d-flex justify-content-around">
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addContract">
                            +
                        </button>
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#listService">
                            Danh sách các dịch vụ đi kèm
                        </button>
                    </div>

                </td>
            </tr>
            <tr>
                <td>1</td>
                <td>Room twin 01</td>
                <td>Nguyễn Thị Hào</td>
                <td>08/12/2021</td>
                <td>12/12/2021</td>
                <td>0</td>
                <td>1000000</td>
                <td>
                    <div class="d-flex justify-content-around">
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addContract">
                            +
                        </button>
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#listService">
                            Danh sách các dịch vụ đi kèm
                        </button>
                    </div>

                </td>
            </tr>
            <tr>
                <td>1</td>
                <td>Room twin 01</td>
                <td>Nguyễn Thị Hào</td>
                <td>08/12/2021</td>
                <td>12/12/2021</td>
                <td>0</td>
                <td>1000000</td>
                <td>
                    <div class="d-flex justify-content-around">
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addContract">
                            +
                        </button>
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#listService">
                            Danh sách các dịch vụ đi kèm
                        </button>
                    </div>

                </td>
            </tr>

            </tbody>
        </table>
    </div>

<%--modal add contract--%>
<div class="modal" id="addContract">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header bg-success text-center text-white fw-bold">
                <h4 class="modal-title">ADD CONTRACT</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <form action="">
                <!-- Modal body -->
                <div class="modal-body">
                    <form action="/action_page.php">
                        <div class="mb-3 mt-3">
                            <label for="startDate" class="form-label">Chọn ngày bắt đầu:</label>
                            <input type="date" class="form-control" id="startDate" name="startDate">
                        </div>
                        <div class="mb-3 mt-3">
                            <label for="endDate" class="form-label">Chọn ngày kết thúc:</label>
                            <input type="date" class="form-control" id="endDate" name="endDate">
                        </div>
                        <div class="mb-3">
                            <label for="moneySend" class="form-label">Nhập Tiền gửi:</label>
                            <input type="text" class="form-control" id="moneySend" placeholder="Nhập Tiền gửi" name="moneySend">
                        </div>
                        <div class="mb-3">
                            <label for="totalMoney" class="form-label">Tổng tiền</label>
                            <input type="number" class="form-control bg-secondary" readonly id="totalMoney" name="totalMoney">
                        </div>

                        <div>
                            <label for="totalMoney" class="form-label">Khách hàng thuê dịch vụ</label>
                            <select name="customer" id="customer" class="form-control">
                                <option value="">Chọn khách hàng</option>
                                <option value="">Option1</option>
                                <option value="">Option2</option>
                                <option value="">Option3</option>
                            </select>
                        </div>

                        <div>
                            <label for="service" class="form-label">Dịch vụ</label>
                            <select name="service" id="service" class="form-control">
                                <option value="">Chọn dịch vụ</option>
                                <option value="">Option1</option>
                                <option value="">Option2</option>
                                <option value="">Option3</option>
                            </select>
                        </div>

                        <div class="mb-3">
                            <label  class="form-label">Dịch vụ đính kèm</label>
                            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#listService">
                                +
                            </button>
                        </div>
                    </form>
                </div>

                <!-- Modal footer -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-success" data-bs-dismiss="modal">ADD</button>
                </div>
            </form>


        </div>
    </div>
</div>

<%--modal display list service--%>
<div class="modal" id="listService">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header bg-info">
                <h4 class="modal-title text-center text-white">List Service</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
               <p>List Service</p>
                <table class="table table-bordered table-hover">
                    <thead class="bg-danger text-white text-center fw-bold">
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Unit</th>
                        <th>Status</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td>Karaoke</td>
                        <td>10000</td>
                        <td>giờ</td>
                        <td>tiện nghi, hiện tại
                        </td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>Thuê xe máy</td>
                        <td>10000</td>
                        <td>chiếc</td>
                        <td>hỏng 1 xe</td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>Thuê xe đạp</td>
                        <td>20000</td>
                        <td>chiếc</td>
                        <td>tốt</td>
                    </tr>
                    <tr>
                        <td>4</td>
                        <td>Buffet buổi sáng</td>
                        <td>15000</td>
                        <td>suất</td>
                        <td>đầy đủ đồ ăn, tráng miệng</td>
                    </tr>
                    <tr>
                        <td>5</td>
                        <td>Buffet buổi trưa</td>
                        <td>90000</td>
                        <td>suất</td>
                        <td>đầy đủ đồ ăn, tráng miệng</td>
                    </tr>
                    <tr>
                        <td>6</td>
                        <td>Buffet buổi tối</td>
                        <td>16000</td>
                        <td>suất</td>
                        <td>đầy đủ đồ ăn, tráng miệng</td>
                    </tr>
                    </tbody>
                    
                </table>
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
            </div>

        </div>
    </div>
</div>

<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap5.min.js"></script>
<script>
    $(document).ready(function() {
        $('#listContract').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        } );
    } );
</script>
<script src="bootstrap-5.0.2-dist/js/bootstrap.min.js"></script>

</body>
</html>
