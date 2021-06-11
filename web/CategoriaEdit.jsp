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
        
        <jsp:include page="includes/menu.jsp"></jsp:include>
        
        <div class="container">
            <div class="row">
                <h1 class="mb-3">Editar Categoria</h1>
                <hr>
                <div class="col-lg-4">
                    
                    <form action="ControllerCategoria" method="POST" enctype="multipart/form-data">
                        <div class="form-outline mb-4">
                            <input readonly="true"
                                name="categoriaId" type="text" value="${requestScope.Categoria.categoriaId}" class="form-control" />
                            <label class="form-label" for="categoriaId">CategoriaId</label>
                        </div>
                        <div class="form-outline mb-4">
                            <input name="categoriaName" type="text" class="form-control" value="${requestScope.Categoria.nombre}" />
                            <label class="form-label" for="categoriaName">Nombre de la Categoria</label>
                        </div>
                        <div class="form-outline mb-4">
                            <input name="categoriaDescripcion" type="text" class="form-control" value="${requestScope.Categoria.descripcion}" />
                            <label class="form-label" for="categoriaDescripcion">Descripcion de la Categoria</label>
                        </div>
                        <div class="mb-3">
                            <label for="CategoriaImagen" class="form-label">Imagen</label>
                            <input name="CategoriaImagen" class="form-control" type="file" id="CategoriaImagen">
                        </div>
                        <input class="btn btn-outline-primary btn-block" name="Accion" type="submit" value="Guardar Cambios">
                    </form>
                </div>
            </div>
            
        </div>

    <script type="text/javascript" src="js/mdb.min.js"></script>
    </body>
</html>
