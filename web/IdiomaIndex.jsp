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
        <link rel="stylesheet" href="css/mdb.min.css" />
    </head>
    <body >
        
        <jsp:include page="includes/menu.jsp"></jsp:include>
        
        <div class="container">
            <div class="row">
                <h1 class="mb-3">Ingreso de Idiomas</h1>
                <hr>
                <div class="col-lg-4">
                    
                    <form action="ControllerCategorias" method="POST">
                        <div class="form-outline mb-4">
                            <input name="idiomaName" type="text" class="form-control" />
                            <label class="form-label" for="idiomaName">Idioma</label>
                        </div>                       
                        <input style="border-color: #00BCD4; color:#00BCD4; "  
                            class="btn btn-outline-primary btn-block" name="Accion" type="submit" value="Guardar Idioma">
                    </form>
                </div>
            </div>
            <div class="row mt-5">
                <table class="table table-hover text-center">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Idioma</th>
                            <th scope="col">Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
    
                    <c:forEach var="I" items="${applicationScope.ListadoIdiomas}">
                        <tr>
                            <th>${I.descripcion}</th>
                            <th>
                                <a class="" href="#"><i class="fas fa-pen fa-lg red-text"></i></a>
                                <a href="#"><i class="fas fa-info-circle fa-lg"></i></a>
                                <a href="#"><i class="fas fa-trash fa-lg"></i></a>
                            </th>
                        </tr>
                    </c:forEach>
                        
                        <tr>
                            <th>000-1234</th>
                            <th>Espanol</th>
                            <th>
                                <a class="" href="#"><i class="fas fa-pen fa-lg red-text"></i></a>
                                <a href="#"><i class="fas fa-info-circle fa-lg"></i></a>
                                <a href="#"><i class="fas fa-trash fa-lg"></i></a>
                            </th>
                        </tr>
                        <tr>
                            <th>000-1234</th>
                            <th>Ingles</th>
                            <th>
                                <a href="#"><i class="fas fa-pen fa-lg"></i></a>
                                <a href="#"><i class="fas fa-info-circle fa-lg"></i></a>
                                <a href="#"><i class="fas fa-trash fa-lg"></i></a>
                            </th>
                        </tr>
                        <tr>
                            <th>000-1234</th>
                            <th>Frances</th>
                            <th>
                                <a href="#"><i class="fas fa-pen fa-lg"></i></a>
                                <a href="#"><i class="fas fa-info-circle fa-lg"></i></a>
                                <a href="#"><i class="fas fa-trash fa-lg"></i></a>
                            </th>
                        </tr>
                    </tbody>
                    <tfoot>
                        
                    </tfoot>
                </table>
            </div>
            
        </div>
    
    <script type="text/javascript" src="js/mdb.min.js"></script>
    </body>
</html>
