/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.forum.service;

import com.forum.entity.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Hibernate;

/**
 *
 * @author Nicolas
 */
@Stateless
public class UserService {

    @PersistenceContext
    private EntityManager em;
    
    public User authenticate(String username, String password) {
        
        // Hashing the password with Apache's DigestsUtils
        final String hashedPassword = DigestUtils.sha1Hex(password);
        
        final CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        final CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);

        final Root<User> userRoot = query.from(User.class);

        // TODO: Using metamodel here would be nice but it needs to use
        // some plugins in maven's pom.xml which would be uselessly confusing for a beginning. 
        query.where(
                criteriaBuilder.equal(userRoot.get("login"), username),
                criteriaBuilder.equal(userRoot.get("passwd"), hashedPassword)
        );

        // Execute the request
        // If there is a no result exception, returns a null user
        try {
            final User foundUser = em.createQuery(query).getSingleResult();
            
            // Récupération des messages de l'user
            Hibernate.initialize(foundUser.getMessages());
    
            return foundUser;
            
        } catch(NoResultException nre) {
            return null;
        }
    }
        
    public User getUserById(long id) {
        return em.find(User.class, id);
    }
}
