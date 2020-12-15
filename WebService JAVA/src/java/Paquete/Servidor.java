/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paquete;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author MAIK
 */
@WebService(serviceName = "Servidor")
public class Servidor {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "operation")
    public List operation(int ci) {
        ConexionSql a=new ConexionSql();
        List list = new ArrayList();
        list=a.conectar(ci);
        return list;
    }
    
}
