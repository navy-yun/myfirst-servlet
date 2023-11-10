package com.kitri.myfirstservlet.practice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "multiplicationServlet", value = "/practice/multipliction-servlet")
public class MultiplicationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        int times = Integer.parseInt(req.getParameter("times"));

        out.println("<h4>" + times + "단</h4><br>");
        for (int i = 1; i <= 9; i++) {
            out.println("<p>" + times + " * " + i + " = "+ times * i + "<p>");
        }
    }
}
