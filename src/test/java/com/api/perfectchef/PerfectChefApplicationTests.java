package com.api.perfectchef;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PerfectChefApplicationTests {

    @Test
    void contextLoads() {
        assertThat(5).isEqualTo(5);
    }

}
