package com.spring.basic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.basic.model.ScoreVO;
import com.spring.basic.repository.IScoreDAO;

@Service
// anotation Service를 추가하게 되면 container에 bean을 등록함
public class ScoreService implements IScoreService {
	
	// service와 dao는 의존성이 있으므로 객체 생성 
	// Autowired는 container에서 타입에 맞는 객체를 찾아서 자동 주입
	@Autowired
	private IScoreDAO dao;
	
	
	@Override
	public void insertScore(ScoreVO score) {
		// controller에서 전달된 값을 연산 진행 후 dao에 전달
		score.calcData();
		// 총점과 평균을 계산
		
		System.out.println(score);
		// score객체를 dao에게 전달해야함으로 service와 dao는 연관관계가 있음
		dao.insertScore(score);
		// dao에 score 객체를 넣어줌
	}

	@Override
	public List<ScoreVO> listScore() {
		
		return dao.listScore();
		// controller에 return
		// Controller에 값을 보내야하고 딱히 데이터를 처리할 필요가 없음 
	}

	@Override
	public void deleteScore(int num) {
		dao.deleteScore(num);

	}

	@Override
	public ScoreVO selectScore(int num) {
		
		return dao.selectScore(num);
	}

}
