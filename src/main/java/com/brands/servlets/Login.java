package com.brands.servlets;

import com.brands.dao.Users;
import com.brands.dto.UserImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Login extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");

        String password = request.getParameter("password");

        System.out.println("password is=" + password);

        Users user = new Users();
        user.setEMail(email);
        user.setPassword(password);

        UserImp userImp = new UserImp();
        if (userImp.loginNour(email, password)) {

            System.out.println("valid");
            response.sendRedirect("index.html?email=" + email + "&password" + password);

        } else {
            String paramName = "Sorry UserName or Password Error!";

            request.setAttribute("user", paramName);
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);


//            String paramName="Sorry UserName or Password Error!";
//            response.sendRedirect("login.jsp?notvalid="+paramName);
//

        }

    }
//    private String builGsonFromObject(Dto dto) {
//        Gson gsonUser = new Gson();
//        System.out.println("gsonuser" + gsonUser);
//        System.out.println("1---" + gsonUser.toJson(dto));
//        return gsonUser.toJson(dto);
//    }
//
//    private String builGsonFromArray(ArrayList array) {
//        Gson gsonUser = new Gson();
//        return gsonUser.toJson(array);
//    }
}
