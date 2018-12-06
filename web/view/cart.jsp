<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<div class="cart-table-area section-padding-100">
	<div class="container-fluid">
		<div class="row">
			<div class="col-12 col-lg-8">
				<div class="cart-title mt-50">
					<h2>Shopping Cart</h2>
				</div>

				<div class="cart-table clearfix">
					<table class="table table-responsive">
						<thead>
							<tr>
								<th></th>
								<th>Name</th>
								<th>Price</th>
								<th>Quantity</th>
							</tr>
						</thead>
						<tbody>

							<%int total=0; %>
							<%int i=0; %>
							<c:forEach var="db_cart" items="${db_shoppingcart}"
								begin="<%=i %>">
								<c:forEach var="db_product" items="${db_product_list}"
									begin="<%=i %>" end="<%=i %>">
									<c:forEach var="db_cart_img" items="${cart_img_list}"
										begin="<%=i %>" end="<%=i %>">
										<tr>
											<td class="cart_product_img"><a href="#"><img
													src="img/main_img/${db_cart_img}" alt="Product"></a></td>
											<td class="cart_product_desc">
												<h5>${db_product.name }</h5>
											</td>
											<td class="price"><span>${db_product.price }¿ø</span></td>
											<td class="qty">
												<div class="qty-btn d-flex">
													<div class="quantity">
														<input type="number" class="qty-text" id="qty" step="1"
															min="1" max="300" name="quantity"
															value="${db_cart.amount }" readonly="readonly">
													</div>
												</div>
											</td>
										</tr>

									</c:forEach>
									<%
											i++;
										%>
								</c:forEach>
							</c:forEach>



						</tbody>
					</table>
				</div>
			</div>

			<div class="col-12 col-lg-4">
				<div class="cart-summary">
					<h5>Cart Total</h5>
					<ul class="summary-table">
						<li><span>subtotal:</span> <span>${total }¿ø</span></li>
						<li><span>delivery:</span> <span>Free</span></li>
						<li><span>total:</span> <span>${total }¿ø</span></li>
					</ul>
					<div class="cart-btn mt-100">
						<a href="cart.mc" class="btn amado-btn w-100">Checkout</a>
					</div>
				</div>
			</div>


		</div>
	</div>
</div>

<!-- ##### Main Content Wrapper End ##### -->


