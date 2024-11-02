package io.github.feilian1999.kkdiary;

import org.springframework.data.repository.CrudRepository;

public interface RevisionRepository extends CrudRepository<Revision, Long> {
    //找revision一個correction, by id
    Revision findByCorrection(String correction);

    Revision findById(long id);
}

