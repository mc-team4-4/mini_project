<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>


<!-- Product Catagories Area Start -->

        <div class="products-catagories-area clearfix">
            <div class="amado-pro-catagory clearfix">
				<%int i=0; %>
				<c:forEach var="img_item" items="${p_list}" begin="<%=i %>" >
					<c:forEach var="main_img" items="${front_main_img_list}" begin ="<%=i %>" end="<%=i %>">
					   <form name="product_details_form" action="product_details.mc" method="post">
					    <!-- Single Catagory -->
		                <div class="single-products-catagory clearfix">
		                  
		                    	<input type="hidden" name="product_id" value="${img_item.product_id}">
	
		                    	<button onclick="Product();"><img src="img/main_img/${main_img}" alt=""></button>
		                    	<!-- Hover Content -->
		                        <div class="hover-content">
		                            <div class="line"></div>
		                            <p>${img_item.price}</p>
		                            <h4>${img_item.name}</h4>
		                        </div> 
	 						
		                   
		                </div>
	                 </form>
	                </c:forEach>
	                <%i++; %>
				</c:forEach>
              
            </div>
        </div>
        <!-- Product Catagories Area End -->



        