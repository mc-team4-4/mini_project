<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>



        <!-- Product Details Area Start -->
        <div class="single-product-area section-padding-100 clearfix">
            <div class="container-fluid">

                <div class="row">
                    <div class="col-12">
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb mt-50">
                                <li class="breadcrumb-item"><a href="#">Home</a></li>
                                <li class="breadcrumb-item"><a href="#">${select_category.category_name}</a></li>
                                <li class="breadcrumb-item active" aria-current="page">${select_product_list.name}</li>
                            </ol>
                        </nav>
                    </div>
                </div>

                <div class="row">
                    <div class="col-12 col-lg-7">
                        <div class="single_product_thumb">
                            <div id="product_details_slider" class="carousel slide" data-ride="carousel">
	                            <ol class="carousel-indicators">

                                 	<li class="active" data-target="#product_details_slider" data-slide-to="0" style="background-image: url(img/main_img/${select_product_mainimg_list});">
                                    </li>
                                 <%int count=1; %>
                                <c:forEach var="img_item" items="${select_product_img_list}">
                                   
                                    <li data-target="#product_details_slider" data-slide-to="<%=count %>" style="background-image: url(img/main_img/${img_item});">
                                    </li>
                                    
                                    <%count++; %>
								</c:forEach>   
                                    
                                </ol>
                                <div class="carousel-inner">
                                 <div class="carousel-item active">
                                        <a class="gallery_img" href="img/main_img/${select_product_mainimg_list}">
                                            <img class="d-block w-100" src="img/main_img/${select_product_mainimg_list}" alt="First slide">
                                        </a>
                                 </div> 
                                <%int count2=2; %>
                                <%String al=null; %>

                                <c:forEach var="img_item" items="${select_product_img_list}">

                                    <div class="carousel-item">
                                            <%if(count2==2){
                                        		al="Second slide";
                                        		
                                        	}
                                        	else if(count2==3){
                                        		al="Third slide";
                                        		
                                        	}
                                        	else if(count2==4){
                                        		al="Fourth slide";
                                        		
                                        	}
                                            %>
                                        <a class="gallery_img" href="img/main_img/${img_item}">
    
                                        	
                                            <img class="d-block w-100" src="img/main_img/${img_item}" alt="<%=al%>">
                                         <%count2++; %>
                                        </a>
                                    </div> 
                                   
                                </c:forEach>   
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-12 col-lg-5">
                        <div class="single_product_desc">
                            <!-- Product Meta Data -->
                            <div class="product-meta-data">
                                <div class="line"></div>
                                <p class="product-price">${select_product_list.price}</p>
                                <a href="product_details.mc">
                                    <h6>${select_product_list.name}</h6>
                                </a>
                                <!-- Ratings & Review -->
                                <div class="ratings-review mb-15 d-flex align-items-center justify-content-between">
                                    <div class="ratings">
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                    </div>
                                    <div class="review">
                                        <a href="#">Write A Review</a>
                                    </div>
                                </div>
                                <!-- Avaiable -->
                                <p class="avaibility"><i class="fa fa-circle"></i>${select_product_list.amount}</p>
                            </div>

                            <div class="short_overview my-5">
                                <p>${select_product_list.content}</p>
                            </div>

                            <!-- Add to Cart Form -->
                            <form class="cart clearfix" method="post">
                                <div class="cart-btn d-flex mb-50">
                                    <p>Qty</p>
                                    <div class="quantity">
                                        <span class="qty-minus" onclick="var effect = document.getElementById('qty'); var qty = effect.value; if( !isNaN( qty ) &amp;&amp; qty &gt; 1 ) effect.value--;return false;"><i class="fa fa-caret-down" aria-hidden="true"></i></span>
                                        <input type="number" class="qty-text" id="qty" step="1" min="1" max="300" name="quantity" value="1">
                                        <span class="qty-plus" onclick="var effect = document.getElementById('qty'); var qty = effect.value; if( !isNaN( qty )) effect.value++;return false;"><i class="fa fa-caret-up" aria-hidden="true"></i></span>
                                    </div>
                                </div>
                                <button type="submit" name="addtocart" value="5" class="btn amado-btn">Add to cart</button>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Product Details Area End -->