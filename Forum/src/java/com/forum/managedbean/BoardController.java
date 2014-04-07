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
    

    private Board board;
    private DataModel<Topic> topicsTableModel;
    
    /**
     * Creates a new instance of BoardController
     */
    public BoardController() {
    }
    
    public String listTopics(Board board) {
        return "board?faces-redirect=true&idBoard=" + board.getId();
    }

    public Board getBoard() {
        if (board == null) {
            board = new Board();
        }
        
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
    
    public void setBoard(int idBoard) {
        this.board = boardService.getBoardById(idBoard);
    }
    
    public void setBoardById(String idBoard) {
        this.board = boardService.getBoardById(Integer.parseInt(idBoard));
    }
    
    public DataModel<Topic> getTopicsTableModel() throws IOException {
        final List<Topic> topics = topicService.getTopicsByBoard(board);

        topicsTableModel = new ListDataModel<Topic>(topics);
        
        return topicsTableModel;
    }

    public void setTopicsTableModel(DataModel<Topic> topicsTableModel) {
        this.topicsTableModel = topicsTableModel;
    }
    
    public void deleteBoard(Board go)
    {
       boardService.deleteBoard(go);
    }
    
    public void addBoard()
    {
        boardService.addBoard(board);
    }
    
    public void renameBoard()
    {
        boardService.renameBoard(board);
    }
}
