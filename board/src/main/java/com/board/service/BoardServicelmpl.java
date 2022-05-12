package com.board.service;

import java.util.Collections;
import java.util.List;

import com.board.domain.BoardDTO;
import com.board.mapper.BoardMapper;
import com.board.paging.Criteria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServicelmpl implements BoardService{

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public boolean registerBoard(BoardDTO params) {
        int queryResult = 0;

        if(params.getIdx() == null) {
            queryResult = boardMapper.insertBoard(params);
        }
        else{
            queryResult = boardMapper.updateBoard(params);
        }
        return (queryResult == 1) ? true : false;
    }

    @Override
    public BoardDTO getBoardDetail(Long idx) {
        //To do 게시판 조회 수 증가 로직
        return boardMapper.selectBoardDetail(idx);
    }

    @Override
    public boolean deleteBoard(Long idx) {
        int queryResult = 0;

        BoardDTO board = boardMapper.selectBoardDetail(idx);

        if(board != null && "N".equals(board.getDeleteYn())){
            queryResult = boardMapper.deleteBoard(idx);
        }
        return (queryResult == 1) ? true : false;
    }

    @Override
    public List<BoardDTO> getBoardList(Criteria criteria) {
        List<BoardDTO> boardList = Collections.emptyList();

        int boardTotalCount = boardMapper.selectBoardTotalCount(criteria);

        if(boardTotalCount > 0){
            boardList = boardMapper.selectBoardList(criteria);
        }
        return boardList;
    }
}