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
        
        <div class="container mt-5">
            <div class="row">
                <div class="col-md-12 text-center">
                    <h1>App Componentes Web</h1>
                </div>
            </div>
            <div class="row col-md-12 justify-content-between float-left mt-5">
                <c:forEach var="Categoria" items="${applicationScope.ListadoCategorias}">
                    <div class="card col-md-3 mr-3 ml-3 mb-3 mx-auto" >
                        <a href="ControllerHome?CategoriaId=${Categoria.categoriaId}">
                          <img src="img/${Categoria.imagen}" class="card-img-top mx-auto" alt="...">  
                        </a>
                        <div class="card-body text-center">
                            <h5 class="card-title"><strong>${Categoria.nombre}</strong></h5>
                            <p class="card-text">${Categoria.descripcion}</p>
                        </div>
                    </div>                
                </c:forEach>
            </div>

        </div>
        
        <script type="text/javascript" src="js/mdb.min.js"></script>
    </body>
</html>
