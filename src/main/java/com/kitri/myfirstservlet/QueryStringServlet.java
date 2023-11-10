package com.kitri.myfirstservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "queryStringServlet", value = "/query-string-servlet")
public class QueryStringServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // GET 메서드 요청을 처리
        // 쿼리 스트링을 추출 해야함 : req.getParamet();
        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("GET요청\n");
        out.println(req.getParameter("name") + "\n");
        out.println(req.getParameter("city") + "\n");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset=UTF-8");
        req.setCharacterEncoding("UTF-8"); // <- 한글 깨짐 방지

        PrintWriter out = resp.getWriter();
        
        out.println("POST요청\n");
        out.println(req.getParameter("name2") + "\n");
        out.println(req.getParameter("city2") + "\n");
    }
}