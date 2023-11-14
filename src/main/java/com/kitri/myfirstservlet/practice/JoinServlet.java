package com.kitri.myfirstservlet.practice;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet("/practice/join")
public class JoinServlet extends HttpServlet {
    static ServletContext sc = null;
    @Override
    public void init(ServletConfig config) throws ServletException {
         sc = config.getServletContext();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String id = req.getParameter("id");
        String pwd1 = req.getParameter("pwd1");
        String pwd2 = req.getParameter("pwd2");

        if (id.isEmpty() || pwd1.isEmpty()) {
            out.print("ID 또는 비밀번호를 입력해주세요.");
            return;
        }

        if (sc.getAttribute(id) == null) {
            if (pwd1.equals(pwd2)) {
                // 회원가입
                sc.setAttribute(id, pwd1);
                out.print("회원가입이 완료되었습니다.");
            } else {
                out.print("비밀번호가 일치하지 않습니다.");
            }
        } else {
            out.print("이미 존재하는 회원입니다.");
        }

    }
}
