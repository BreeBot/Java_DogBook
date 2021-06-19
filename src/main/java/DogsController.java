import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

@WebServlet(urlPatterns = {"/dogs/new", "/dogs"})
public class DogsController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    if(req.getServletPath().equals("/dogs/new")) {
      RequestDispatcher dispatcher = req.getRequestDispatcher("/views/dog-profiles/new.jsp");
      dispatcher.forward(req, resp);
    }else if (req.getServletPath().equals("/dogs")) {
      EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
      EntityManager em = emf.createEntityManager();
      DogProfileService dogService = new DogProfileService(em);

      List<Dog> profiles = dogService.showDogs();
      req.setAttribute("profiles", profiles);

      RequestDispatcher dispatcher = req.getRequestDispatcher("/views/dog-profiles/list.jsp");
      dispatcher.forward(req, resp);

    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
    EntityManager em = emf.createEntityManager();

    DogProfileService dogService = new DogProfileService(em);

    Dog newDog = new Dog();

    try {
      BeanUtils.populate(newDog, req.getParameterMap());
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }

    dogService.save(newDog);

    em.close();

    resp.sendRedirect("/dogs");

  }
}













