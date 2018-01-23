package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class erro_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\"/>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Error</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>404 Page not found <img src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3midBqcONVY6iUvzmVUnbHxM6NI8v8PqtS_g_lYRx8gjWz4Jm\" width=\"40\" height=\"40\"/></h1>\n");
      out.write("        <h2>404 Page not found <img src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3midBqcONVY6iUvzmVUnbHxM6NI8v8PqtS_g_lYRx8gjWz4Jm\" width=\"30\" height=\"30\"/></h2>\n");
      out.write("        <h3>404 Page not found <img src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3midBqcONVY6iUvzmVUnbHxM6NI8v8PqtS_g_lYRx8gjWz4Jm\" width=\"25\" height=\"25\"/></h3>\n");
      out.write("        <h4>404 Page not found <img src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3midBqcONVY6iUvzmVUnbHxM6NI8v8PqtS_g_lYRx8gjWz4Jm\" width=\"20\" height=\"20\"/></h4>\n");
      out.write("        <h5>404 Page not found <img src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3midBqcONVY6iUvzmVUnbHxM6NI8v8PqtS_g_lYRx8gjWz4Jm\" width=\"15\" height=\"15\"/></h5>\n");
      out.write("        <h6>404 Page not found <img src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3midBqcONVY6iUvzmVUnbHxM6NI8v8PqtS_g_lYRx8gjWz4Jm\" width=\"10\" height=\"10\"/></h6>\n");
      out.write("        <p><a href=\"index.html\"></a>Voltar</p>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
