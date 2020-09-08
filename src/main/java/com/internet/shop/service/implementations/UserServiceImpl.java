package com.internet.shop.service.implementations;

import com.internet.shop.dao.interfaces.UserDao;
import com.internet.shop.library.Inject;
import com.internet.shop.library.Service;
import com.internet.shop.model.User;
import com.internet.shop.service.interfaces.UserService;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Inject
    private UserDao userDao;

    @Override
    public User create(User user) {
        return userDao.create(user);
    }

    @Override
    public User getById(Long id) {
        return userDao.getById(id).get();
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User update(User user) {
        return userDao.update(user);
    }

    @Override
    public boolean deleteById(Long id) {
        return userDao.deleteById(id);
    }
}
