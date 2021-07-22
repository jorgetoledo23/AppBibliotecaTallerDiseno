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
            
            <div class="card card-cascade narrower view view-cascade gradient-card-header blue-gradient py-2 mb-3 d-flex justify-content-between align-items-center">
                <h2 class="card-title mx-5">Administracion de Libros</h2>
                <a class="text-success mx-5" href="#"><i class="fas fa-sign-out-alt fa-lg mr-2"></i>Salir</a>
            </div>
            <hr>
            
            <div class="row">
                <form class="row" action="ControllerLibro" method="POST" enctype="multipart/form-data">
                <div class="col-lg-6">
                        <div class="form-outline mb-4">
                            <input name="libroName" type="text" class="form-control" />
                            <label class="form-label" for="libroName">Nombre del Libro</label>
                        </div>

                        <div class="form-outline mb-4">
                            <input name="libroISBN" type="text" class="form-control" />
                            <label class="form-label" for="libroISBN">ISBN</label>
                        </div>
                            <div class="form-outline mb-4">
                            <input name="libroAutor" type="text" class="form-control" />
                            <label class="form-label" for="libroAutor">Autor</label>
                        </div>
                            <div class="form-outline mb-4">
                            <input name="libroDescripcion" type="textarea" class="form-control" />
                            <label class="form-label" for="libroDescripcion">Descripcion</label>
                        </div>
                        <div class="form-group">
                            <label for="CategoriaId" class="control-label">Categoria</label>
                            <select name="CategoriaId" class="form-control">
                                <c:forEach var="C" items="${applicationScope.ListadoCategorias}">
                                    <option value="${C.categoriaId}">${C.nombre}</option>
                                </c:forEach>
                            </select>
                        </div>
                    
                </div>
                    <div class="col-lg-6">
                    

                        <div class="form-outline col-md-6 mb-4">
                            <input name="libroPrecio" type="number" class="form-control" />
                            <label class="form-label" for="libroPrecio">Precio</label>
                        </div>

                        <div class="form-outline col-md-6 mb-4">
                            <input name="libroStock" type="number" class="form-control" />
                            <label class="form-label" for="libroStock">Stock</label>
                        </div>
                        <div class="mb-3">
                            <label for="LibroImagen" class="form-label">Imagen</label>
                            <input name="LibroImagen" class="form-control" type="file" id="CategoriaImagen">
                        </div>
                    </div>
                    <p class="text-warning">${msgError}</p>
                        <input class="btn btn-outline-success btn-block" name="Accion" type="submit" value="Guardar Libro">
                </form>
            </div>
            <div class="row mt-5">
                <table class="table table-hover text-center">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Titulo</th>
                            <th scope="col">ISBN</th>
                            <th scope="col">Imagen</th>
                            <th scope="col">Autor</th>
                            <th scope="col">Descripcion</th>
                            <th scope="col">Precio</th>
                            <th scope="col">Stock</th>
                            <th scope="col">Categoria</th>
                            <th scope="col">Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
    
                    <c:forEach var="Libro" items="${applicationScope.ListadoLibros}">
                        <tr>
                            <th>${Libro.libroId}</th>
                            <th>${Libro.titulo}</th>
                            <th>${Libro.isbn}</th>
                            <th><img src="img/imgLibros/${Libro.imagen}" style="width: 50px; height: 50px;" class="card-img-top mx-auto" alt="..."></th>
                            <th>${Libro.autor}</th>
                            <th>${Libro.descripcion}</th>
                            <th>${Libro.precio}</th>
                            <th>${Libro.stock}</th>
                            <th>${Libro.categoria.nombre}</th>
                            <th>
                                <a class="" href="#"><i class="fas fa-pen fa-lg red-text"></i></a>
                                <a href="#"><i class="fas fa-info-circle fa-lg"></i></a>
                                <a href="#"><i class="fas fa-trash fa-lg"></i></a>
                            </th>
                        </tr>
                    </c:forEach>
                    </tbody>
                    <tfoot>
                        
                    </tfoot>
                </table>
            </div>
            
        </div>
    
    <script type="text/javascript" src="js/mdb.min.js"></script>
    </body>
</html>
