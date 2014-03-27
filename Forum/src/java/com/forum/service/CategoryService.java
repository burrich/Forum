/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.forum.service;

import com.forum.entity.Category;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Nicolas
 */
@Stateless
public class CategoryService {

    @PersistenceContext
    private EntityManager em;
    
    public List<Category> getAllCategories() {
        final CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        final CriteriaQuery<Category> query = criteriaBuilder.createQuery(Category.class);
        query.from(Category.class);
        return em.createQuery(query).getResultList();
    }
}
