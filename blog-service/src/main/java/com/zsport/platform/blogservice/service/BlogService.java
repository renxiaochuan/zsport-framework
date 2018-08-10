package com.zsport.platform.blogservice.service;


import com.zsport.platform.blogservice.client.UserServiceClient;
import com.zsport.platform.blogservice.dao.BlogDao;
import com.zsport.platform.blogservice.dto.BlogDetailDTO;
import com.zsport.platform.blogservice.entity.Blog;
import com.zsport.platform.blogservice.entity.User;
import com.zsport.platform.blogservice.util.UserUtils;
import com.zsport.platform.common.dto.RespDTO;
import com.zsport.platform.common.exception.CommonException;
import com.zsport.platform.common.exception.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fangzhipeng on 2017/7/10.
 */
@Service
public class BlogService {

    @Autowired
    BlogDao blogDao;

    @Autowired
    UserServiceClient userServiceClient;

    public Blog postBlog(Blog blog) {
        return blogDao.save(blog);
    }

    public List<Blog> findBlogs(String username) {
        return blogDao.findByUsername(username);
    }


    public BlogDetailDTO findBlogDetail(Long id) {
        Blog blog = blogDao.findOne(id);
        if (null == blog) {
            throw new CommonException(ErrorCode.BLOG_IS_NOT_EXIST);
        }
        RespDTO<User> respDTO = userServiceClient.getUser(UserUtils.getCurrentToken(), blog.getUsername());
        if (respDTO==null) {
            throw new CommonException(ErrorCode.RPC_ERROR);
        }
        BlogDetailDTO blogDetailDTO = new BlogDetailDTO();
        blogDetailDTO.setBlog(blog);
        blogDetailDTO.setUser(respDTO.data);
        return blogDetailDTO;
    }

}
