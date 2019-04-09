package by.training.tourist_vouchers.servlet;

import by.training.tourist_vouchers.builder.DOMBuilder;
import by.training.tourist_vouchers.builder.SAXBuilder;
import by.training.tourist_vouchers.builder.StAXBuilder;
import by.training.tourist_vouchers.creator.Creator;
import by.training.tourist_vouchers.entity.Voucher;
import org.apache.logging.log4j.core.util.IOUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.List;

/**
 * The {@code Servlet} is used for working with server.
 */
@MultipartConfig
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(final HttpServletRequest request,
                         final HttpServletResponse response)
            throws ServletException, IOException {

        String lang = request.getParameter("lang");
        HttpSession session = request.getSession(true);
        session.setAttribute("lang", lang);
        RequestDispatcher rd = getServletContext().getRequestDispatcher(
                "/result.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(final HttpServletRequest request,
                          final HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        Part filePart = request.getPart("file");
        String fileName =
                Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        InputStream fileContent = filePart.getInputStream();
        System.out.println(fileName);
        StringBuilder filepath = new StringBuilder("D:\\IdeaProjects" +
                "\\epamTraining\\task04\\www\\files\\");
        filepath.append(fileName);
        PrintStream loadedFile = new PrintStream(filepath.toString(), "UTF-8");
        loadedFile.print(IOUtils.toString(new InputStreamReader(fileContent,
                StandardCharsets.UTF_8)));
        loadedFile.close();
        Creator creator = new Creator();
        List<Voucher> vouchers;
        String parser = request.getParameter("parser");
        System.out.println(parser);
        switch (parser) {
            case "SAX":
                vouchers = creator.createVouchers(new SAXBuilder(), fileName);
                request.setAttribute("res", vouchers);
                break;
            case "StAX":
                vouchers = creator.createVouchers(new StAXBuilder(), fileName);
                request.setAttribute("res", vouchers);
                break;
            case "DOM":
                vouchers = creator.createVouchers(new DOMBuilder(), fileName);
                request.setAttribute("res", vouchers);
                break;
        }
        request.getRequestDispatcher("/jsp/result.jsp").forward(request, response);

    }

}
