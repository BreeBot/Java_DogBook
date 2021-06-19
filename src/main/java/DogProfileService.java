import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class DogProfileService {

  private final EntityManager em;

  public DogProfileService(EntityManager em) {
    this.em = em;
  }

  public boolean save(Dog profile) {
    try {
      em.getTransaction().begin();
      em.persist(profile);
      em.getTransaction().commit();

      return true;

    } catch (Exception e) {
      System.out.println("\n\n\n\n\n\n\ndid not save\n\n\n\n\n\n\n");
      em.getTransaction().rollback();
      return false;
    }
  }

  public List<Dog> showDogs() {
    TypedQuery<Dog> profiles = em.createQuery("SELECT p FROM Dog p ORDER BY lastName, firstName", Dog.class);
    return profiles.getResultList();

  }
}














