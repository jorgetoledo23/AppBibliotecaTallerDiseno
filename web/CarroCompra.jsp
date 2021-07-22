<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Libreria</title>
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=KoHo:wght@300&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=KoHo:ital,wght@0,300;1,200&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="css/misEstilos.css"/>
        <link rel="stylesheet" href="css/mdb.min.css" />
    </head>
    <body>
        
        <jsp:include page="includes/menu.jsp"></jsp:include>
        <fmt:setLocale value="es-CL" scope="application"></fmt:setLocale>
        <div class="container mt-5">
            <div class="row">
                <div class="col-md-12 text-center">
                    <h1>Carrito de Compras</h1>
                </div>
            </div>
            <div class="row mt-5">
                <table class="table table-hover text-center">
                    <thead>
                        <tr>
                            <th scope="col">Titulo</th>
                            <th scope="col">Imagen</th>
                            <th scope="col">Autor</th>
                            <th scope="col">Descripcion</th>
                            <th scope="col">Categoria</th>
                            <th scope="col">Precio</th>
                            <th scope="col">Cantidad</th>
                            <th scope="col">Sub Total</th>
                            <th scope="col">Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:set var="Total" scope="page" value="0" ></c:set>
                    <c:forEach var="Item" items="${sessionScope.CarroCompra}">
                        <tr>
                            <th>${Item.libro.titulo}</th>
                            <th><img src="img/imgLibros/${Item.libro.imagen}" style="width: 50px; height: 50px;" class="card-img-top mx-auto" alt="..."></th>
                            <th>${Item.libro.autor}</th>
                            <th>${Item.libro.descripcion}</th>
                            <th>${Item.libro.categoria.nombre}</th>
                            <th><fmt:formatNumber value="${Item.libro.precio}" type="currency" currencySymbol="$"></fmt:formatNumber></th>
                            <th>${Item.cantidad}</th>
                            <th><fmt:formatNumber value="${Item.libro.precio * Item.cantidad}" type="currency" currencySymbol="$"></fmt:formatNumber></th>
                            <th><a href="#"><i class="fas fa-trash fa-lg"></i></a></th>
                        </tr>
                        <c:set var="Total" scope="page" value="${Total + Item.libro.precio * Item.cantidad}" ></c:set>
                    </c:forEach>
                    </tbody>
                    <tfoot>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td><strong>Total: </strong></td>
                            <td><strong><fmt:formatNumber value="${Total}" type="currency" currencySymbol="$"></fmt:formatNumber></strong></td>
                            <td></td>
                    </tr>
                    </tfoot>
                </table>
            </div>
            
            <a class="btn btn-outline-success">Finalizar Compra</a>
            
        </div>
        
        <script type="text/javascript" src="js/mdb.min.js"></script>
    </body>
</html>
