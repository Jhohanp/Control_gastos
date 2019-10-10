/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.gastoDAO;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Gasto;
import model.Negocio;

/**
 *
 * @author LENOVO
 */
public class Controller extends HttpServlet {
    
    Negocio negocio;

    @Override
    public void init() throws ServletException {
        this.negocio = new Negocio();
    }
    
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        gastoDAO daogasto = new gastoDAO();
        if(request.getParameter("fecha")!=null){
             ArrayList<Gasto> listaGasto;
             Gson gson = new Gson();
            try {
               listaGasto=daogasto.BuscarGastoD(request.getParameter("fecha"));  
             String json = new Gson().toJson(listaGasto);
                PrintWriter pw=response.getWriter();
                pw.write(json);
                pw.print(json);
                        
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        }
       
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("gasto") != null) {
            String paramName = "gasto";
       String ParamValue = request.getParameter(paramName);
        try {
            negocio.guardarGasto(ParamValue);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        }if (request.getParameter("efectivo") != null){
            String paramName = "efectivo";
       String ParamValue = request.getParameter(paramName);
        
        try {
            negocio.guardarEfectivo(ParamValue);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        }if (request.getParameter("debito") != null){
            String paramName = "debito";
       String ParamValue = request.getParameter(paramName);
        
        try {
            negocio.guardarTD(ParamValue);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        } if (request.getParameter("credito") != null){
            String paramName = "credito";
       String ParamValue = request.getParameter(paramName);
        
        try {
            negocio.guardarTC(ParamValue);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
       
       
       /*if(ParamValue==null){
           System.out.println("parametro "+ paramName + "not found");
       }*/
       }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
   


