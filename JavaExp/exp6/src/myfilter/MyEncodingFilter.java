package myfilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyEncodingFilter implements Filter
{
    private String encoding = null;

    public void init(FilterConfig fc)
    {
        encoding = fc.getInitParameter("encoding");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException
    {
        if (encoding != null) {
            if (request.getCharacterEncoding() == null)
                request.setCharacterEncoding(encoding);
            if (response.getCharacterEncoding() == null)
                response.setCharacterEncoding(encoding);
        }
        chain.doFilter(request, response);
    }

    public void destroy()
    {
        encoding = null;
    }

}
