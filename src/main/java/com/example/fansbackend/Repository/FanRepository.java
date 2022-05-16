package com.example.fansbackend.Repository;

import com.example.fansbackend.Model.Fan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FanRepository extends JpaRepository<Fan, Long>{

}