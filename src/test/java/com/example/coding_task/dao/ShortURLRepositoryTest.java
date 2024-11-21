package com.example.coding_task.dao;

import com.example.coding_task.model.Click;
import com.example.coding_task.model.ShortURL;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static net.bytebuddy.utility.RandomString.make;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class ShortURLRepositoryTest {

    @Autowired
    private ShortURLRepository shortURLRepository;

    @Test
    public void shouldReturnShortURLWithNumberOfClicks() {
        assertThat(shortURLRepository.findWithClicksLessOrEqualThan(10)).hasSize(3);
        assertThat(shortURLRepository.findWithClicksLessOrEqualThan(5)).hasSize(2);
        assertThat(shortURLRepository.findWithClicksLessOrEqualThan(1)).hasSize(1);
    }

    @BeforeEach
    public void prepareData() {
        ShortURL ten = shortURLRepository.save(new ShortURL(make(5), "https://google.com"));
        ShortURL five = shortURLRepository.save(new ShortURL(make(5), "https://bing.com"));
        ShortURL one = shortURLRepository.save(new ShortURL(make(5), "https://yahoo.com"));

        for (int i = 0; i < 10; i++) {
            ten.addClick(new Click().withMetadata(make(15)));
            shortURLRepository.save(ten);
            if (i >= 5) {
                five.addClick(new Click().withMetadata(make(15)));
                shortURLRepository.save(five);
            }
        }

        one.addClick(new Click().withMetadata(make(15)));
        shortURLRepository.save(one);
    }
}
