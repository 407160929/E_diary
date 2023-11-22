package com.group.e_diary;

import com.group.e_diary.generator.entity.UserEntity;
import com.group.e_diary.generator.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EDiaryApplicationTests {

    @Autowired
    UserService userService;
    @Test
    void contextLoads() {
        UserEntity userEntity = new UserEntity();
        userEntity.setAccount("asdsad");
        userEntity.setPassword("adsd");

        userService.save(userEntity);
        System.out.println(userEntity.getId());

    }

}
