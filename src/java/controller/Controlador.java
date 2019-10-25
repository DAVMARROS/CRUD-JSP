/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import conexion.Conexion;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author David
 */
@Controller
public class Controlador{
    Conexion con  = new Conexion();
    JdbcTemplate jdbctemplate = new JdbcTemplate(con.Conectar());
    ModelAndView nav = new ModelAndView();

    /***
    * Método para obtener un listado de registros de la tabla empleados
    */
    @RequestMapping("index.htm")
    public ModelAndView listarEmpleados(){
        //Cadena sql
        String cadsql = "select * from empleados";
        // Ejecuta petición sql
        List datos = this.jdbctemplate.queryForList(cadsql);
        // Crear el id de los datos porque se los pasaremos a la vista
        nav.addObject("lista", datos);
        // Vincular la vista para enviarle los datos
        nav.setViewName("index");
        
        return nav;
    }
    
    @RequestMapping("Nuevo.htm")
    public ModelAndView nuevoEmpleados(){
        // Vincular la vista para enviarle los datos
        String sql = "select clave from empleados ORDER by clave DESC limit 1;";
        int clave = this.jdbctemplate.queryForInt(sql);
        clave+=1;
        nav.addObject("clave", clave);
        nav.setViewName("Agregar");
        
        return nav;
    }
    
    @RequestMapping(value="Agregar.htm", method=RequestMethod.POST)
    public String agregarEmpleados(HttpServletRequest Request){
        String clave = String.valueOf(Request.getParameter("clave"));
        String nombre = String.valueOf(Request.getParameter("nombre"));
        String sueldo = String.valueOf(Request.getParameter("sueldo"));
        System.out.println(clave+" "+nombre+" "+sueldo);
        String sql = "insert into empleados (clave,nombre,sueldo) values('"+clave+"','"+nombre+"','"+sueldo+"');";
        this.jdbctemplate.execute(sql);
        
        return "redirect:index.htm";
    }
    
    @RequestMapping(value="Modificar.htm", method=RequestMethod.GET)
    public ModelAndView modificarEmpleados(HttpServletRequest Request){
        String clave = String.valueOf(Request.getParameter("clave"));
        String cadsql = "select * from empleados where clave='"+clave+"';";
        List datos = this.jdbctemplate.queryForList(cadsql);
        
        // Crear el id de los datos porque se los pasaremos a la vista
        nav.addObject("lista", datos);
        // Vincular la vista para enviarle los datos
        nav.setViewName("Editar");
        
        return nav;
    }
    
    @RequestMapping(value="Ver.htm", method=RequestMethod.GET)
    public ModelAndView VerEmpleados(HttpServletRequest Request){
        String clave = String.valueOf(Request.getParameter("clave"));
        String cadsql = "select * from empleados where clave='"+clave+"';";
        List datos = this.jdbctemplate.queryForList(cadsql);
        
        // Crear el id de los datos porque se los pasaremos a la vista
        nav.addObject("lista", datos);
        // Vincular la vista para enviarle los datos
        nav.setViewName("Ver");
        
        return nav;
    }
    
    @RequestMapping(value="Editar.htm", method=RequestMethod.POST)
    public String EditarEmpleados(HttpServletRequest Request){
        String clave = String.valueOf(Request.getParameter("clave"));
        String nombre = String.valueOf(Request.getParameter("nombre"));
        String sueldo = String.valueOf(Request.getParameter("sueldo"));
        System.out.println(clave+" "+nombre+" "+sueldo);
        String sql = "update empleados set nombre='"+nombre+"', sueldo='"+sueldo+"' where clave='"+clave+"';";
        this.jdbctemplate.execute(sql);
        
        return "redirect:Ver.htm?clave="+clave;
    }
    
    @RequestMapping(value="Borrar.htm", method=RequestMethod.GET)
    public ModelAndView borrarEmpleados(HttpServletRequest Request){
        String clave = String.valueOf(Request.getParameter("clave"));
        String cadsql = "select * from empleados where clave='"+clave+"';";
        List datos = this.jdbctemplate.queryForList(cadsql);
        
        // Crear el id de los datos porque se los pasaremos a la vista
        nav.addObject("lista", datos);
        // Vincular la vista para enviarle los datos
        nav.setViewName("Eliminar");
        
        return nav;
    }
    
    @RequestMapping(value="Eliminar.htm", method=RequestMethod.POST)
    public String EliminarEmpleados(HttpServletRequest Request){
        String clave = String.valueOf(Request.getParameter("clave"));
        String sql = "delete from empleados where clave='"+clave+"';";
        this.jdbctemplate.execute(sql);
        
        return "redirect:index.htm";
    }
}
