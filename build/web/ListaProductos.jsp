<%-- 
    Document   : ListaProductos
    Created on : 5/05/2022, 11:33:39 PM
    Author     : mordo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">   
        .cabecera{
       font-size:1.2em;
       font-weight:bold;
       color:#FFFFFF;
       background-color: #08088A;
        }
        
        .filas{
         text-align:center;
         background-color: #5882FA;
        }
        
      </style>  
    </head>
    <body>
        
        <table>
            <tr>
                <th class="cabecera">Código Articulo</th>
                <th class="cabecera">Seccion</th>
                <th class="cabecera">Nombre Articulo</th>
                <th class="cabecera">Fecha</th>
                <th class="cabecera">Precio</th>
                <th class="cabecera">Importado</th>
                <th class="cabecera">País de Origen</th>
                
            </tr>
   
            
            <c:forEach  var="tempProd" items="${LISTAPRODUCTOS}">          
                <tr>
                     <td class="filas">${tempProd.cArt }</td>  
                     <td class="filas">${tempProd.seccion }</td>  
                     <td class="filas">${tempProd.nArt }</td> 
                     <td class="filas">${tempProd.fecha }</td>
                     <td class="filas">${tempProd.precio }</td>  
                     <td class="filas">${tempProd.importado }</td>  
                     <td class="filas">${tempProd.pOrig }</td>                     
                </tr>       
           </c:forEach> 
        </table> 
        
        
    </body>
</html>
