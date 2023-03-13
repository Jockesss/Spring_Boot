package web.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.model.User;
import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {
        @Autowired
        private UserDAO userDAO;

        @Override

        public List<User> getUsersList() {
                return userDAO.getUsersList();
        }

        @Override

        public void addUser(User user) {
                userDAO.addUser(user);
        }

        @Override

        public User getUserById(Long id) {
                return userDAO.getUserById(id);
        }

        @Override

        public void updateUser(User user) {
                userDAO.updateUser(user);
        }

        @Override

        public void deleteUser(Long id) {
                 userDAO.deleteUser(id);
        }
}
