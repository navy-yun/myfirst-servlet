package com.kitri.myfirstservlet.todo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet("/todo-list")
public class TodoListServlet extends HttpServlet {
    static ArrayList<Todo> todos = new ArrayList<>();
    static PrintWriter out = null;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        out = resp.getWriter();

        // 조회
        printAll();
        // 등록

        out.print("    <form action=\"/query-string-servlet\" method=\"GET\">\n" +
                "        <label for=\"name\">이름 : </label>\n" +
                "        <input type=\"text\" name=\"name\" id=\"name\">\n" +
                "        <br>\n" +
                "        <label for=\"city\">지역 : </label>\n" +
                "        <input type=\"text\" name=\"city\" id=\"city\">\n" +
                "        <br>\n" +
                "        <input type=\"submit\" value=\"전송하기\">\n" +
                "    </form>");

        // 수정

        // 삭제
    }

    private void printAll() {
        todos.forEach(todo -> {
            out.print("<p>" + todo.task + ", " + todo.clear + "</p><br>");
        });
    }
}
