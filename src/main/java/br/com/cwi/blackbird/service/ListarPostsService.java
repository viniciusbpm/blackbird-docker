package br.com.cwi.blackbird.service;

import br.com.cwi.blackbird.controller.response.PostResponse;
import br.com.cwi.blackbird.domain.Post;
import br.com.cwi.blackbird.mapper.PostMapper;
import br.com.cwi.blackbird.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarPostsService {

    @Autowired
    private PostRepository postRepository;

    public Page<PostResponse> listar(Pageable pageable){
        Page<Post> posts = postRepository.findAll(pageable);

        return posts.map(PostMapper::toResponse);
    }
}
