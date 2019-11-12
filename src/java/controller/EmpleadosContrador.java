/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.sun.xml.rpc.processor.modeler.rmi.JavaBean;
import conexion.Conexion;
import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author David
 */
@RestController
public class EmpleadosContrador {
    Conexion con  = new Conexion();
    JdbcTemplate jdbctemplate = new JdbcTemplate(con.Conectar());
    
    @RequestMapping(value="getEmpleados.htm", produces = "application/json")
    @ResponseBody
    public String getEmpleados(){
        String cadsql = "select * from empleados";
        // Ejecuta petición sql
        List datos = this.jdbctemplate.queryForList(cadsql);
        String json = new Gson().toJson(datos);
        return json;
    }
    
    @RequestMapping(value="getEmpleado/{id}.htm", produces = "application/json")
    @ResponseBody
    public String getEmpleadosId(@PathVariable("id") int id){
        String cadsql = "select * from empleados where clave="+id;
        // Ejecuta petición sql
        List datos = this.jdbctemplate.queryForList(cadsql);
        String json = new Gson().toJson(datos);
        return json;
    }
    
    @RequestMapping(value="postEmpleado.htm", produces = "application/json", method=RequestMethod.POST)
    @ResponseBody
    public String postEmpleado(HttpServletRequest Request){
        String nombre = String.valueOf(Request.getParameter("nombre"));
        String sueldo = String.valueOf(Request.getParameter("sueldo"));
        nombre = nombre.replace("\"", "");
        String sql = "insert into empleados (nombre,sueldo) values('"+nombre+"','"+sueldo+"');";
        this.jdbctemplate.execute(sql);
        com.google.gson.JsonObject datos = new JsonParser().parse("{\"message\": \"success\"}").getAsJsonObject();
        String json = new Gson().toJson(datos);
        return json;
    }
    
    @RequestMapping(value="putEmpleado.htm", produces = "application/json", method=RequestMethod.POST)
    @ResponseBody
    public String putEmpleado(HttpServletRequest Request){
        //com.google.gson.JsonObject jsonObject = new JsonParser().parse(data).getAsJsonObject();
        String clave = String.valueOf(Request.getParameter("clave"));
        String nombre = String.valueOf(Request.getParameter("nombre"));
        String sueldo = String.valueOf(Request.getParameter("sueldo"));
        nombre = nombre.replace("\"", "");
        String sql = "update empleados set nombre='"+nombre+"', sueldo='"+sueldo+"' where clave='"+clave+"';";
        this.jdbctemplate.execute(sql);
        com.google.gson.JsonObject datos = new JsonParser().parse("{\"message\": \"success\"}").getAsJsonObject();
        String json = new Gson().toJson(datos);
        return json;
    }
    
    @RequestMapping(value="deleteEmpleado.htm", produces = "application/json", method=RequestMethod.POST)
    @ResponseBody
    public String deleteEmpleado(HttpServletRequest Request){
        //com.google.gson.JsonObject jsonObject = new JsonParser().parse(data).getAsJsonObject();
        String clave = String.valueOf(Request.getParameter("clave"));
        String sql = "delete from empleados where clave='"+clave+"';";
        this.jdbctemplate.execute(sql);
        com.google.gson.JsonObject datos = new JsonParser().parse("{\"message\": \"success\"}").getAsJsonObject();
        String json = new Gson().toJson(datos);
        return json;
    }
    
}
