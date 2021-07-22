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
                    <h1>App Componentes Web</h1>
                </div>
            </div>
            <div class="row col-md-12 justify-content-between float-left mt-5">
            <c:forEach var="Libro" items="${requestScope.LibrosByCat}">
                    <div class="card col-md-3 mr-3 ml-3 mb-3 mx-auto" >
                        <h5 class="card-title text-center mt-3"><strong>${Libro.titulo}</strong></h5>
                        <h6 class="card-title text-center"><strong>${Libro.descripcion}</strong></h6>
                        <img src="img/imgLibros/${Libro.imagen}" class="card-img-top mx-auto" alt="...">  
                        <div class="card-body text-center">
                            <p class="card-text">${Libro.isbn}</p>
                            <p class="card-text">${Libro.autor}</p>
                            <p class="card-text">${Libro.stock}</p>
                            <p class="card-text">${Libro.categoria.nombre}</p>
                            <p class="card-text text-warning"><fmt:formatNumber value="${Libro.precio}" type="currency" currencySymbol="$"></fmt:formatNumber></p>
                            <a href="ControllerCarroCompras?LibroId=${Libro.libroId}" class="btn btn-outline-success">Agregar al Carro</a>
                        </div>
                    </div>                
                </c:forEach>
            </div>

        </div>
        
        <script type="text/javascript" src="js/mdb.min.js"></script>
    </body>
</html>
