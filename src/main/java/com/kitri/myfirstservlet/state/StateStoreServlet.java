package com.kitri.myfirstservlet.state;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet(name = "stateStoreServlet", value = "/state-store")
public class StateStoreServlet extends HttpServlet {
    int memberCount = 0; // 필드 (멤버 변수)
    ServletContext servletContext = null;

    HashMap<HttpSession, Integer> users = new HashMap<>();

    // init()은 서블릿이 최초 생성될 때 1번 실행
    @Override
    public void init(ServletConfig config) throws ServletException {
        // ServletContext
        servletContext = config.getServletContext(); // (1)
        servletContext.setAttribute("count", new Integer(0));
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int localCount = 0; // 지역 변수
        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("멤버변수 카운트 : " + ++memberCount);
        out.println("로컬변수 카운트 : " + ++localCount);

        // 1. ServletContext : WAS 시작 ~ WAS 종료
        int applicationCount = (int) servletContext.getAttribute("count");
        // int applicationCount = (int) this.getServletContext().getAttribute("count");
        servletContext.setAttribute("count", ++applicationCount);
        out.println("애플리케이션 단위 카운트 : " + applicationCount);

        // 2. Session : 클라이언트의 요청 ~ 클라이언트의 종료
        HttpSession session = req.getSession();// 세션ID 추출
        if (session.isNew()) {
            out.println("세션 생성 완료 " + session.getId());
        }
        Integer sessionCount = (Integer) session.getAttribute("count");
        if (sessionCount == null) {
            sessionCount = 0;
            session.setAttribute("count", sessionCount);
        }
        session.setAttribute("count", ++sessionCount);
        out.println("세션 단위 카운트 : " + sessionCount);

        out.println("--- 해당 페이지에 접속한 유저별 방문 횟수 ---");
        users.forEach((key, value) -> {
            out.println(key + " : " + value);
        });
    }
}
