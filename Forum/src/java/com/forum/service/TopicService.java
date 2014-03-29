/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.forum.service;

import com.forum.entity.Board;
import com.forum.entity.Topic;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Nicolas
 */
@Stateless
public class TopicService {

    @PersistenceContext
    private EntityManager em;
    
    public List<Topic> getTopicsByBoard(Board board) {
        final CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        final CriteriaQuery<Topic> query = criteriaBuilder.createQuery(Topic.class);
        final Root<Topic> topics = query.from(Topic.class);
    
        query.where(
                criteriaBuilder.equal(
                    topics.get("board").as(Board.class), 
                    board
        ));
        
        query.orderBy(
                criteriaBuilder.desc(
                        topics.get("id")
        ));
   
        return em.createQuery(query).getResultList();
    }
    
    public Topic getTopicById(long id) {
        return em.find(Topic.class, id);
    }
}
