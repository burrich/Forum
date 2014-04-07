/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.forum.service;

import com.forum.entity.Board;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Nicolas
 */
@Stateless
public class BoardService {

    @PersistenceContext
    private EntityManager em;
    
    public Board getBoardById(long id) {
        return em.find(Board.class, id);
    }
    
    public void deleteBoard(Board go)
    {
        em.remove(em.contains(go) ? go : em.merge(go));
    }
    
    public void renameBoard(Board board)
    {
  //      em.persist(board);
    }

    public void addBoard(Board board) {
        em.persist(board);
    }
}
