
package fr.lernejo.todo;


import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.stereotype.Component;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.util.UUID;


@Component
public class ApplicationIdentifierFilter implements Filter {

    private final String uuid;

    public ApplicationIdentifierFilter() {
        uuid = UUID.randomUUID().toString().replace("-", "");
        System.out.println("uuid = " + uuid);
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
        throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        res.setHeader("Instance-Id", this.uuid);
        filterChain.doFilter(servletRequest, res);

    }
}
