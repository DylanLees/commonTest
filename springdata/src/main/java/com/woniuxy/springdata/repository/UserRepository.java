package com.woniuxy.springdata.repository;

import com.woniuxy.springdata.entity.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Integer> {
    /*
    自定义更新数据库方法，通过@query和@Modifying注解。注意：向数据库，更新，添加，删除数据，需要开启事务。
    Transaction事务的默认是可以写入数据库。如果需要修改为只读，只需要把属性readOnly=true
     */

    @Transactional
    @Modifying
    @Query("update User u set  u.userName=?1 where u.id=?2")
    int findByUserNameAndUserPass(String userName, Integer id);
    @Procedure(procedureName = "plusinout")
    Integer plusinout(Integer arg);
}
