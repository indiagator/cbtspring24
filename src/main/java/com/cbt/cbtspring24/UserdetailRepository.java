package com.cbt.cbtspring24;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserdetailRepository extends JpaRepository<Userdetail, String> {

    @Query("select u from UserdetailView u where u.username=?1")
    UserdetailView findViewByUsername(String username);

}