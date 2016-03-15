package com.coingeit.dao;

import com.coingeit.db.DBUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Copyright (c) 2015 Exponential Interactive, Inc. All rights reserved.
 * User: abhinavgarg
 * Date: 13/03/16
 */
@Repository
public class UserDAOImpl implements UserDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDAOImpl.class);

    @Autowired
    protected SessionFactory sessionFactory_;
    
    Session getSession() {
        return sessionFactory_.getCurrentSession();
    }
    
    @Override
    public DBUser getUserByEmail(String email) {
        return ((DBUser) getSession().createCriteria(DBUser.class, "user")
                .add(Restrictions.eq("user.email_", email))
                .uniqueResult());
    }

    @Override
    public DBUser getUserByUserName(String userName) {
        return ((DBUser) getSession().createCriteria(DBUser.class, "user")
                .add(Restrictions.eq("user.userName_", userName))
                .uniqueResult());
    }

    @Override
    public DBUser getUserById(long userId) {
        return ((DBUser) getSession().createCriteria(DBUser.class, "user")
                .add(Restrictions.eq("user.id_", userId))
                .uniqueResult());
    }

    @Override
    @Transactional
    public void saveUser(DBUser dbUser) {
        getSession().saveOrUpdate(dbUser);
    }
}
