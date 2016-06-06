package org.itis.gr404.crud;



import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.itis.gr404.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void createUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @Transactional
    public User getUser(Integer id) {
        return (User) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Override
    @Transactional
    public List<User> getUsers() {
        List<User> users = (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class).list();
        return users;
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    @Transactional
    public void deleteUser(Integer id) {
        User user = getUser(id);
        sessionFactory.getCurrentSession().delete(user);
    }
}
