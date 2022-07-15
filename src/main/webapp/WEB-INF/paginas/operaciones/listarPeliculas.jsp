<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="es_AR"/>
<section id="peliculas">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Peliculas</h4>
                    </div>
                    <table class="table table-striper table-dark">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Nombre</th> 
                                <th>Director</th>
                                <th>Recaudación Mundial</th>
                                <th>secuelas</th>
                                <th>Accion</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="pelicula" items="${peliculas}" varStatus="status">
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${pelicula.nombre}</td>
                                    <td>${pelicula.director}</td>
                                    <td><fmt:formatNumber value="${pelicula.recaudacion}" type="currency"/></td>
                                    <td>${pelicula.secuelas}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/servletControlador?accion=editar&idPelicula=${pelicula.idPeliculas}"
                                           class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i>
                                            Editar
                                        </a>
                                    </td>
                                </tr>  
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-md-5">
                <div class="card text-center bg-danger text-white mb-3">
                    <div class="card-body">
                        <h3>Cantidad de Secuelas</h3>
                        <h4 class="display-4">
                            ${cantidadSecuelas}
                        </h4>
                    </div>
                </div>
                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>Recaudacion Total</h3>
                        <h4 class="display-4">
                            <i class="fas fa-video"></i>
                            <fmt:formatNumber value="${recaudacionTotal}" type="currency"/>
                        </h4>
                    </div>
                </div>                                            
            </div>
        </div>
    </div>
</section>

                                
<jsp:include page="/WEB-INF/paginas/operaciones/agregarPeliculas.jsp"/>