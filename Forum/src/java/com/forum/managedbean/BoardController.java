/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.forum.managedbean;

import com.forum.entity.Board;
import com.forum.entity.Topic;
import com.forum.service.BoardService;
import com.forum.service.TopicService;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Nicolas
 */
@ManagedBean
@ViewScoped
public class BoardController implements Serializable{

    @EJB
    private TopicService topicService;
    
    @EJB
    private BoardService boardService;
    
    private int idBoard;
    private Board board;
    private DataModel<Topic> topicsTableModel;
    
    /**
     * Creates a new instance of BoardController
     */
    public BoardController() {
    }
    
    public String listTopics(int idBoard) {
        return "board?faces-redirect=true&idBoard=" + idBoard;
    }

    public Board getBoard() {
        if (board == null) {
            if (idBoard > 0)
                board = boardService.getBoardById(idBoard);
            else 
                board = new Board();
        }
        
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
    
    public int getIdBoard() {
        return idBoard;
    }

    public void setIdBoard(int idBoard) {
        this.idBoard = idBoard;
    }
    
    public DataModel<Topic> getTopicsTableModel() throws IOException {
        final List<Topic> topics = topicService.getTopicsByBoard(getBoard());

        topicsTableModel = new ListDataModel<Topic>(topics);
        
        return topicsTableModel;
    }

    public void setTopicsTableModel(DataModel<Topic> topicsTableModel) {
        this.topicsTableModel = topicsTableModel;
    }
}
