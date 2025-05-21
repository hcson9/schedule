///*
// * Created by Hochan Son on 2025. 5. 19.
// * As part of
// *
// * Copyright (C)  () - All Rights Reserved
// * Unauthorized copying of this file, via any medium is strictly prohibited
// * Proprietary and confidential
// * Written by Backend Team <hc.son9@google.com>, 2025. 5. 19.
// */
//
//package kr.spartacodingclub.demo2.repository;
//
//import kr.spartacodingclub.demo2.entity.Comment;
//import org.springframework.stereotype.Repository;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//import java.util.concurrent.atomic.AtomicLong;
//
///**
// * create on 2025. 5. 19. create by IntelliJ IDEA.
// * create by IntelliJ IDEA.
// *
// * <p> 클래스 설명. </p>
// * <p> {@link } and {@link }관련 클래스 </p>
// *
// * @author Hochan Son
// * @version 1.0
// * @see
// * @since 지원하는 자바버전 (ex : 5+ 5이상)
// */
//@Repository
//public class CommentMapRepository implements CommentRepository {
//  // id 를 부여
//  private AtomicLong lastId = new AtomicLong(0);
//
//  // 요청을 저장
//  private Map<Long, Comment> commentMap = new HashMap<>();
//
//  @Override
//  public Comment save(Comment comment) {
//    commentMap.put(comment.getId(), comment);
//    return comment;
//  }
//
//  @Override
//  public Optional<Comment> findById(Long id) {
//    return Optional.ofNullable(commentMap.get(id));
//  }
//
//  @Override
//  public List<Comment> findAll() {
//    return commentMap.values()
//            .stream()
//            .toList();
//  }
//}
