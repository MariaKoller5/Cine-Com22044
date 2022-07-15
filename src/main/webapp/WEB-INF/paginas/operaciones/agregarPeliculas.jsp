<div class="modal fade" id="agregarPeliculaModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Pelicula</h5>
            </div>
            <form action="${pageContext.request.contextPath}/servletControlador?accion=insertar" method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" name="nombre" required="">
                    </div>
                    <div class="form-group">
                        <label for="Director">Director</label>
                        <input type="text" class="form-control" name="Director">
                    </div>
                    <div class="form-group">
                        <label for="recaudacion">Recaudacion</label>
                        <input type="number" class="form-control" name="recaudacion" required="">
                    </div>
                    <div class="form-group">
                        <label for="secuelas">Secuelas</label>
                        <input type="number" class="form-control" name="secuelas" required="">
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">
                        Guardar
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>               