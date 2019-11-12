/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author David
 */
public class Conexion {
    public DriverManagerDataSource Conectar(){
        DriverManagerDataSource nav = new DriverManagerDataSource();
        nav.setDriverClassName("com.mysql.jdbc.Driver");
        nav.setUrl("jdbc:mysql://node49314-empleados.jl.serv.net.mx:3306/MSC2019");
        nav.setUsername("root");
        nav.setPassword("XVOrvo39422");
        return nav;
    }
}
