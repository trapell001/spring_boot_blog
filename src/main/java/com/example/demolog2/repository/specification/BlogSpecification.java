package com.example.demolog2.repository.specification;

import com.example.demolog2.entity.Blog;
import com.example.demolog2.model.request.blog.BlogFilterRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class BlogSpecification {
    public static Specification<Blog> filterAll(BlogFilterRequest filter){

    };
    public static Specification<Blog> WithUrl(String url){
        if(StringUtils.isEmpty(url)) return null;
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("url"),url));
    };
    public static Specification<Blog> WithCategoryId(Long categoryId){
        if(categoryId==0||categoryId==null) return null;
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.join("category").get("id"),categoryId))
    }
    public static Specification<Blog> WithUserId(Long userId){
        if(userId==0||userId==null) return null;
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.join("user").get("id"),userId);
    }
    public static Specification<Blog> WithKeyWord(String keyWord){
        if(StringUtils.hasLength(keyWord)) return null;
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("keyWord"),"%" + keyWord + "%"));
    }
}
