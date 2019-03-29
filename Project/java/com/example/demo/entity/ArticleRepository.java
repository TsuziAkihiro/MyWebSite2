package com.example.demo.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

// t_userテーブルアクセス用のリポジトリ(DAOのような役割を担う)
@Transactional
@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer>{

	 public List<Article> findByUserIdEquals(String user_id);
}
