package by.training.tourist_vouchers.servlet;

import by.training.tourist_vouchers.builder.DOMBuilder;
import by.training.tourist_vouchers.builder.SAXBuilder;
import by.training.tourist_vouchers.builder.StAXBuilder;
import by.training.tourist_vouchers.creator.Creator;
import by.training.tourist_vouchers.entity.Voucher;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

//@WebServlet("/parse")
@MultipartConfig
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession(true);
        session.setAttribute("language", request.getParameter("language"));

        Creator creator = new Creator();

        Part filePart = request.getPart("file");
        String fileName =
                Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        InputStream fileContent = filePart.getInputStream();
        System.out.println(fileName);
        File file = new File(fileName);
        Files.copy(fileContent, file.toPath());
        System.out.println(file);
//        String xml = getServletContext().getResource(fileName).getFile();
        List<Voucher> vouchers;
        String parser = request.getParameter("parser");
        System.out.println(parser);
        switch (parser) {
            case "SAX":
                vouchers = creator.createVouchers(new SAXBuilder(), fileName);
                System.out.println(vouchers);
                request.setAttribute("res", vouchers);
                break;
            case "StAX":
                vouchers = creator.createVouchers(new StAXBuilder(), fileName);
                System.out.println(vouchers);
                request.setAttribute("res", vouchers);
                break;
            case "DOM":
                vouchers = creator.createVouchers(new DOMBuilder(), fileName);
                System.out.println(vouchers);
                request.setAttribute("res", vouchers);
                break;
        }
        request.getRequestDispatcher("/jsp/result.jsp").forward(request, response);

    }

}
