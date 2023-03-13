package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;

@Repository
public class UserDAOImp implements UserDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsersList() {
        Query query = entityManager.createQuery("SELECT u FROM User u");
        List<User> users = query.getResultList();
        return users;
    }
    @Override
    public void addUser(User user) {
        if (user != null) {
            entityManager.persist(user);
        }
    }
    @Override
    public void deleteUser(Long id) {
        Query query = entityManager.createQuery("DELETE from User u where u.id=:id").setParameter("id", id);
        query.executeUpdate();
    }
    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }


}
