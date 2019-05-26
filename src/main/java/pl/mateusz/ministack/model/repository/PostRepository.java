package pl.mateusz.ministack.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.mateusz.ministack.model.entity.PostEntity;
import pl.mateusz.ministack.model.entity.UserEntity;

@Repository
public interface PostRepository extends CrudRepository<PostEntity, Integer> {
Iterable<PostEntity> findTop10ByOrderByIdDesc();

}

