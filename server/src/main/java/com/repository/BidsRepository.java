package com.repository;
import java.util.*;
import com.entity.Bids;
import org.springframework.data.repository.CrudRepository;

public interface BidsRepository extends CrudRepository <Bids, Long> {
    List<Bids> findByProjectname(String projectname, String bids, String period);

}