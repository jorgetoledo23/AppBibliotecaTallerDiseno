<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=KoHo:wght@300&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=KoHo:ital,wght@0,300;1,200&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="css/misEstilos.css"/>
        <link rel="stylesheet" href="css/mdb.min.css" />
    </head>
    <body>
        <%--<c:if test="${sessionScope.TipoUsuario == 'admin'}"> --%>
            
        <jsp:include page="includes/menu.jsp"></jsp:include>
        
        <div class="container">
            
            <div class="card card-cascade narrower view view-cascade gradient-card-header blue-gradient py-2 mb-3 d-flex justify-content-between align-items-center">
                <h2 class="card-title mx-5">Administracion de Categorias</h2>
                <a class="text-success mx-5" href="#"><i class="fas fa-sign-out-alt fa-lg mr-2"></i>Salir</a>
            </div>
            <hr>
            <div class="row">
                <div class="col-lg-4">
                    <form action="ControllerCategoria" method="POST" enctype="multipart/form-data">
                        <div class="form-outline mb-4">
                            <input name="categoriaName" type="text" class="form-control" />
                            <label class="form-label" for="categoriaName">Nombre de la Categoria</label>
                        </div>
                        <div class="form-outline mb-4">
                            <input name="categoriaDescripcion" type="text" class="form-control" />
                            <label class="form-label" for="categoriaDescripcion">Descripcion de la Categoria</label>
                        </div>
                        <div class="mb-3">
                            <label for="CategoriaImagen" class="form-label">Imagen</label>
                            <input name="CategoriaImagen" class="form-control" type="file" id="CategoriaImagen">
                        </div>
                        <input class="btn btn-outline-success btn-block" name="Accion" type="submit" value="Guardar Categoria">
                    </form>
                </div>
            </div>
            <div class="row col-md-12 justify-content-between float-left mt-5">

                <c:forEach var="Categoria" items="${applicationScope.ListadoCategorias}">

                    <div class="card col-md-3 mr-3 ml-3 mb-3 mx-auto" >
                        <img src="img/${Categoria.imagen}" class="card-img-top mx-auto" alt="...">
                        <div class="card-body text-center">
                            <h5 class="card-title"><strong>${Categoria.nombre}</strong></h5>
                            <p class="card-text">${Categoria.descripcion}</p>
                        </div>
                        <div class="row justify-content-center mb-3">
                            <div class="col-1 float-left">
                                <a href="ControllerCategoria?opcion=edit&catId=${Categoria.categoriaId}" class="mr-3"><i class="fas fa-edit"></i></a>
                            </div>
                            <div class="col-1 float-left">
                                <a class="mr-3"><i class="fas fa-info-circle"></i></a>
                            </div>
                            <div class="col-1 float-left">
                                <a href="ControllerCategoria?opcion=delete&catId=${Categoria.categoriaId}"
                                    onclick="return confirm('Estas seguro de eliminar esta Categoria?')" class="mr-3"><i class="fas fa-trash"></i></a>
                            </div>
                        </div>
                    </div>
                
                </c:forEach>

               <select name="year">
                    <c:forEach var="i" begin="1950" end="2099" step="1">
                            <option value="${i}">${i}</option>
                    </c:forEach>  
                </select>
            </div>
            
        </div>
        
    <!-- HOLA GITHUB -->
    <script type="text/javascript" src="js/mdb.min.js"></script>
    </body>
</html>
