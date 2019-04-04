package by.training.tourist_vouchers.servlet;

import by.training.tourist_vouchers.builder.SAXBuilder;
import by.training.tourist_vouchers.creator.Creator;
import by.training.tourist_vouchers.entity.Voucher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

//@WebServlet("/parse")
public class Servlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Creator creator = new Creator();
        SAXBuilder saxBuilder = new SAXBuilder();
        List<Voucher> vouchers = creator.createVouchers(saxBuilder);
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Testing parsers!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>Parsed data:</h3>");
//        for (Voucher voucher : vouchers) {
//            out.println("<p>" + voucher + "</p>");
//        }
        request.setAttribute("res", vouchers);
        request.getRequestDispatcher("/jsp/result.jsp").forward(request, response);

        out.println("</body>");
        out.println("</html>");
    }
}
