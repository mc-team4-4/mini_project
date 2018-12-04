<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/sign_in_up_util.css">
	<link rel="stylesheet" type="text/css" href="css/sign_in_up_main.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script type="text/javascript">
	function Add_Product() {
		document.add_product_form.action="add_product_impl.mc"; 
		document.add_product_form.method="get"; 
		document.add_product_form.submit();
	}
	
	
	</script>
<!-- MENU SIDEBAR-->
        <aside class="menu-sidebar d-none d-lg-block">
            <div class="logo">
                <a href="admin_main.mc">
                    <img src="img/icon/logo.jpg" alt="MC Admin" />
                </a>
            </div>
            <div class="menu-sidebar__content js-scrollbar1">
                <nav class="navbar-sidebar">
                    <ul class="list-unstyled navbar__list">
                 
                        <li >
                            <a class="js-arrow" href="admin_main.mc">
                                <i class="fas fa-tachometer-alt"></i>Dashboard</a>
		                </li>
						<li>
							<a href="chart.mc"> 
								<i class="fas fa-chart-bar"></i>Charts</a>
						</li>
						<li>
							<a href="table.mc"> 
								<i class="fas fa-table"></i>Tables</a>
						</li>
                        <li class="active has-sub">
                            <a href="add_product.mc">
                                <i class="far fa-check-square"></i>Add Product</a>
                        </li>
                        <li>
                            <a href="modify_product.mc">
                                <i class="far fa-check-square"></i>Modify Product</a>
                        </li>

					</ul>
                </nav>
            </div>
        </aside>
        <!-- END MENU SIDEBAR-->
        
            <!-- MAIN CONTENT-->
            <div class="main-content">
                <div class="section__content section__content--p30">
			    	<div class="container-fluid">
						<div class="col-lg-auto">
							<div class="card">
								<div class="card-header">
									<strong>Add</strong> Product
								</div>
								<div class="card-body card-block">
									<form name="add_product_form" class="form-horizontal">
										
										<div class="row form-group">
											<div class="col col-md-3">
												<label for="select" class=" form-control-label">Category</label>
											</div>
											<div class="col-12 col-md-9">
											
											
												<select name="category_id" id="category_id" class="form-control">
													<option value="0"></option>
													<option value="1">도시락</option>
													<option value="2">식단프로그램</option>
													<option value="3">건강음료수</option>
													<option value="4">건강간식</option>

												</select>
											</div>
										</div>
										<div class="row form-group">
											<div class="col col-md-3">
												<label for="text-input" class=" form-control-label">Product
													Name</label>
											</div>
											<div class="col-12 col-md-9">
												<input type="text" id="name" name="name"
													placeholder="Enter Product Name" class="form-control"> <small
													class="form-text text-muted"></small>
											</div>
										</div>
										
										
										<div class="row form-group">
											<div class="col col-md-3">
												<label for="text-input" class=" form-control-label">Product
													Price</label>
											</div>
											<div class="col-12 col-md-9">
												<input type="number" id="price" name="price"
													placeholder="Text" class="form-control">
											</div>
										</div>
										

										<div class="row form-group">
											<div class="col col-md-3">
												<label for="text-input" class=" form-control-label">Product
													Amount</label>
											</div>
											<div class="col-12 col-md-9">
												<input type="number" id="amount" name="amount"
													placeholder="Enter Product Amount" class="form-control"> 
											</div>
										</div>
										
										
										<div class="row form-group">
											<div class="col col-md-3">
												<label for="file-multiple-input" class=" form-control-label">Product
													Image File</label>
											</div>
											<div class="col-12 col-md-9">
												<input type="file" id="img"
													name="img" multiple="multiple"
													class="form-control-file">
											</div>
										</div>
										
										
										<div class="row form-group">
											<div class="col col-md-3">
												<label for="text-input" class=" form-control-label">Product
													Content</label>
											</div>
											<div class="col-12 col-md-9">
												<input type="text" id="content" name="content"
													placeholder="Enter Product Content" class="form-control"> 
											</div>
										</div>
										
										

										

										
										<div class="card-footer">
											<div class="container-login100-form-btn">
												<button class="login100-form-btn" onclick="Add_Product();">Add Product</button>
											</div>
										</div>

									</form>
								</div>
								
								
								

							</div>
						</div>
			
					</div>
                </div>
            </div>

