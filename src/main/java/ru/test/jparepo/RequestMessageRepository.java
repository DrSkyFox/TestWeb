package ru.test.jparepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.test.models.RequestMessage;

import java.util.List;
import java.util.Optional;

public interface RequestMessageRepository extends JpaRepository<RequestMessage, Long> {

    @Query("select R from RequestMessage R where R.isEnabled=:isEnabled")
    List<RequestMessage> findAll(@Param("isEnabled") Boolean isEnabled);

    Optional<RequestMessage> findById(Long id);

    @Query("update RequestMessage R set R.isEnabled = false where R.id=:id")
    void deleteById(Long id);


}
