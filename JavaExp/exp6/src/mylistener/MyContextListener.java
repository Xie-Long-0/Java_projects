package mylistener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Date;

public final class MyContextListener
    implements ServletContextListener, ServletContextAttributeListener
{

    public void contextInitialized(ServletContextEvent sce)
    {
        System.out.println("应用启动时间：" + new Date());
    }

    public void contextDestroyed(ServletContextEvent sce)
    {
        System.out.println("应用关闭时间：" + new Date());
    }

    public void attributeAdded(ServletContextAttributeEvent scae)
    {
        System.out.println("添加了一个属性：" + scae.getName() + " = " + scae.getValue());
    }

    public void attributeRemoved(ServletContextAttributeEvent scae)
    {
        System.out.println("删除了一个属性：" + scae.getName() + " = " + scae.getValue());
    }

    public void attributeReplaced(ServletContextAttributeEvent scae)
    {
        System.out.println("修改了一个属性：" + scae.getName() + " = "
                + scae.getValue() + " -> "
                + scae.getServletContext().getAttribute(scae.getName()));
    }

}
