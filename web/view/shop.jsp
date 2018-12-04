<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<style>


</style>
<div class="shop_sidebar_area">

	<!-- ##### Single Widget ##### -->
	<div class="widget catagory mb-50">
		<!-- Widget Title -->
		<h6 class="widget-title mb-30">Catagories</h6>

		<!--  Catagories  -->
		<div class="catagories-menu">
			<ul>
				<li><a href="lunch_box.mc">Lunch Box</a></li>
				<li><a href="diet_program.mc">Diet Program</a></li>
				<li><a href="health_drink.mc">Health Drink</a></li>
				<li><a href="health_snack.mc">Health Snack</a></li>

			</ul>
		</div>
	</div>

	<!-- ##### Single Widget ##### -->
	<div class="widget price mb-50">
		<!-- Widget Title -->
		<h6 class="widget-title mb-30">Price</h6>

		<div class="widget-desc">
			<div class="slider-range">
				<div data-min="10" data-max="1000" data-unit="$"
					class="slider-range-price ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all"
					data-value-min="10" data-value-max="1000" data-label-result="">
					<div class="ui-slider-range ui-widget-header ui-corner-all"></div>
					<span class="ui-slider-handle ui-state-default ui-corner-all"
						tabindex="0"></span> <span
						class="ui-slider-handle ui-state-default ui-corner-all"
						tabindex="0"></span>
				</div>
				<div class="range-price">$10 - $1000</div>
			</div>
		</div>
	</div>
</div>




<div class="amado_product_area section-padding-100">
	<div class="container-fluid">

		<div class="row">
			<div class="col-12">
				<div
					class="product-topbar d-xl-flex align-items-end justify-content-between">
					<!-- Total Products -->
					<div class="total-products">
						<p>Showing 1-8 0f 25</p>
						<div class="view d-flex">
							<a href="#"><i class="fa fa-th-large" aria-hidden="true"></i></a>
							<a href="#"><i class="fa fa-bars" aria-hidden="true"></i></a>
						</div>
					</div>
					<!-- Sorting -->
					<div class="product-sorting d-flex">
						<div class="sort-by-date d-flex align-items-center mr-15">
							<p>Sort by</p>
							<form action="#" method="get">
								<select name="select" id="sortBydate">
									<option value="value">Date</option>
									<option value="value">Newest</option>
									<option value="value">Popular</option>
								</select>
							</form>
						</div>
						<div class="view-product d-flex align-items-center">
							<p>View</p>
							<form action="#" method="get">
								<select name="select" id="viewProduct">
									<option value="value">12</option>
									<option value="value">24</option>
									<option value="value">48</option>
									<option value="value">96</option>
								</select>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>




		<div class="row">
			<!--Center Start -->
			<c:choose>
				<c:when test="${product_center != null }">
					<jsp:include page="${product_center }.jsp" />
				</c:when>
				<c:otherwise>
					<jsp:include page="lunch_box.jsp" />
				</c:otherwise>
			</c:choose>
			<!--Center End -->



		</div>

	</div>

</div>


<!-- ##### Main Content Wrapper End ##### -->



