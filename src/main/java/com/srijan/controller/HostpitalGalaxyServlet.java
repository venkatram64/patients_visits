package com.srijan.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.srijan.model.Doctor;
import com.srijan.model.IllnessType;
import com.srijan.model.Medicine;
import com.srijan.service.DoctorService;
import com.srijan.service.MedicineService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class HostpitalGalaxyServlet extends HttpServlet {

    private MedicineService medicineService;
    private DoctorService doctorService;
    public void init() {
        medicineService = new MedicineService();
        doctorService = new DoctorService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            if (action.equalsIgnoreCase("/doctors_list")) {
                listDoctors(request, response);
            }else if(action.equalsIgnoreCase("/search_medicine")){
                RequestDispatcher dispatcher = request.getRequestDispatcher("searchMedicine.jsp");
                dispatcher.forward(request, response);
            }else if(action.equalsIgnoreCase("/search_medicine_type")){
                listMedicine(request, response);
            }
        }catch (SQLException ex) {
            throw new ServletException(ex);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }

    private void listDoctors(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, ClassNotFoundException {

        List<Doctor> listDoctors = doctorService.getAll();
        request.setAttribute("listDoctors", listDoctors);
        RequestDispatcher dispatcher = request.getRequestDispatcher("hospital_galaxy.jsp");
        dispatcher.forward(request, response);
    }

    private void listMedicine(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, IOException, ClassNotFoundException {
        String illnessType = request.getParameter("input");
        IllnessType illnessType1 = IllnessType.valueOf(illnessType);
        List<Medicine> list = medicineService.getMedicineByIllness(illnessType1.getName());

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
        // logger.info(json);
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();

    }
}
