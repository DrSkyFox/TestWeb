package ru.test.jparepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.test.models.RequestResponseMessage;

import java.util.List;
import java.util.Optional;

public interface RequestMessageResponseRepository extends JpaRepository<RequestResponseMessage, Long> {

    @Query("select rs from RequestResponseMessage rs where rs.isEnabled=:isEnabled")
    List<RequestResponseMessage> findAll(@Param("isEnabled") Boolean isEnabled);

    Optional<RequestResponseMessage> findById(@Param("id") Long id);

    @Query("update RequestResponseMessage rs set rs.isEnabled=false where rs.responseID =:id")
    void deleteById(@Param("id") Long id);

}
