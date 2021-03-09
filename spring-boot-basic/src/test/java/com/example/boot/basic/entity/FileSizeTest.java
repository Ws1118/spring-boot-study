package com.example.boot.basic.entity;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.io.File;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
//@RunWith(SpringRunner.class) junit4的写法
@ExtendWith(SpringExtension.class)   //junit5的写法
@SpringBootTest
class FileSizeTest {
        @Resource
        private FileSize fileSize;

        @Test
        void getMaxSize() {
            log.info("fileSize:" + fileSize.getMaxSize());
            String maxSize = fileSize.getMaxSize();
//            log.info(maxSize);
            assertEquals("300MB",maxSize);

    }
}