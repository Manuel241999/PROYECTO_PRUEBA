package productos;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mordo
 */
public class ModeloProductos {
  
    //almacena el pool de conexiones
    private DataSource origenDatos;
    //CONTRUCTOR QUE RECIBE EL POOL DE CONEXIONES:
    public ModeloProductos(DataSource origenDatos2){
        this.origenDatos=origenDatos2;
    }
    
    
    //metodo que obtiene el listado de datos:
    public List<Productos> getProductos()throws Exception{
        /*ESTAS CREANDO UNA VARIABLE LLAMADA productos que es de tipo PRODUCTO(CLASE) QUE
        MANDA A LLAMAR EL CONTRUCTOR QUE ESTA EN PRODUCTOS QUE TIENE TODOS LOS ATRIBUTOS*/
     List<Productos> productos = new ArrayList<>(); 
     
     
     Connection miConexion = null;
     
     PreparedStatement miStatement = null;
      
     ResultSet miResultset  = null;
     
     //ESTABLECER LA CONEXION:
     miConexion = origenDatos.getConnection();
    
     
     //CREAR LA SENTENCIA SQL Y STATEMENT:
     String instruccionSql = "SELECT * FROM PRODUCTOS";
     miStatement = miConexion.prepareStatement(instruccionSql);
     //EJECUTAR SENTENCIA SQL:
     miResultset=miStatement.executeQuery();
     //RECORRER EL RESULTSET OBTENIDO:
     while(miResultset.next()){
              
         
               String codigo_articulo=miResultset.getString(1);
              
               String seccion=miResultset.getString(2);
               
                
               String nombre_articulo=miResultset.getString(3);
                 
                 
               double precio=miResultset.getDouble(4);
                
               
               Date fecha=miResultset.getDate(5);
                
               
               String importado=miResultset.getString(6);
              
               String pais_origen=miResultset.getString(7);
               //RELLENAS LOS ATRIBUTOS DE LA CLASE PERSONA
     
     Productos temProd = new Productos (codigo_articulo,seccion,nombre_articulo,precio,fecha,importado,pais_origen);
     //AQUI LE ESTAS AGREGANDO LOS ATRIBUTOS YA LLENADOS AL ARRAY.
     //agregando al array:
     productos.add(temProd);
     
     }
     
         return productos;
    }
    
}
