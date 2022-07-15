package web;

import data.CineDAO;
import entity.Peliculas;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/servletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String accion = req.getParameter("accion");

        if (accion != null){
            switch (accion){
                case "editar":
                    editarPelicula(req, res);
                    break;
                case "eliminar":
                    eliminarPelicula(req,res);
                    break;
                default:
                    accionDefault(req, res);
                    break;
            }
        } else {
            accionDefault(req, res);
       }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    guardarPelicula(req, res);
                    break;
                case "modificar":
                    modificarPelicula(req, res);
                    break;
                default:
                    accionDefault(req, res);
                    break;
             
            }
        }
        
    }
            
    private void accionDefault(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        List<Peliculas> peliculas = new CineDAO().findAll();
        HttpSession sesion = req.getSession();
        sesion.setAttribute("peliculas", peliculas);
        sesion.setAttribute("cantidadSecuelas",calcularCant(peliculas));
        sesion.setAttribute("recaudacionTotal",calcularRecaudacion(peliculas));
        res.sendRedirect("peliculas.jsp");
    }
    
     private void guardarPelicula(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String director = req.getParameter("director");
        double recaudacion = Double.parseDouble(req.getParameter("recaudacion"));
        int secuelas = Integer.parseInt(req.getParameter("secuelas"));
        
        Peliculas pelicula = new Peliculas(nombre, director, recaudacion, secuelas);
        int regMod = new CineDAO().create(pelicula);
        System.out.println("Insertados: " + regMod);
        accionDefault(req, res);
    }
     
      private void editarPelicula(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int idPelicula = Integer.parseInt(req.getParameter("idPelicula"));
        Peliculas lib = new CineDAO().findFilmById(idPelicula);
        req.setAttribute("pelicula", lib);
        req.getRequestDispatcher("/WEB-INF/paginas/operaciones/editarPelicula.jsp").forward(req, res);      
    }
     
     
     private void modificarPelicula(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String director = req.getParameter("director");
        double recaudacion = Double.parseDouble(req.getParameter("recaudacion"));
        int secuelas = Integer.parseInt(req.getParameter("secuelas"));
        int idPelicula = Integer.parseInt(req.getParameter("idPelicula"));

        Peliculas lib = new Peliculas(idPelicula, nombre, director, recaudacion, secuelas);

        int regMod = new CineDAO().update(lib);

        System.out.println("SE ACTUALIZARON: " + regMod + " REGISTROS");

        accionDefault(req, res);
     }
     
     private void eliminarPelicula(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int idPelicula = Integer.parseInt(req.getParameter("idPelicula"));
        
        int regDel = new CineDAO().delete(idPelicula);
        
        System.out.println("REGISTROS ELIMINADOS: "+ regDel);
        
        accionDefault(req, res);
     }
     
    private int calcularCant(List<Peliculas> lista){
        int secuelas=0;
        for (int i = 0; i < lista.size(); i++){
            secuelas += lista.get(i).getSecuelas();
        }
        return secuelas;
    }
    
    private double calcularRecaudacion(List<Peliculas> lista){
        double Recaudacion=0;
        for (int i = 0; i < lista.size(); i++){
            Recaudacion += (lista.get(i).getSecuelas()*lista.get(i).getRecaudacion());
        }
        return Recaudacion;
    }
   
}
