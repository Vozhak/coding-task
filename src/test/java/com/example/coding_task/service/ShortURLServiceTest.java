package com.example.coding_task.service;

import com.example.coding_task.dao.ShortURLRepository;
import com.example.coding_task.model.ShortURL;
import org.junit.jupiter.api.Test;

import java.util.List;

import static net.bytebuddy.utility.RandomString.make;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.list;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class ShortURLServiceTest {
    private ShortURLRepository repository = mock(ShortURLRepository.class);
    private ShortURLService service = new ShortURLService(repository);

    @Test
    public void shouldShortenUrlToSpecificLength() {
        int length = 7;

        String shortUrl = service.shortenUrl("https://google.com");

        assertThat(shortUrl).hasSize(length);
    }

    @Test
    public void returnsTitlesBasedOnItemsFromPersistenceLayer() {
        int clicks = 5;
        String first = make(5);
        String second = make(5);
        given(repository.findWithClicksLessOrEqualThan(clicks))
                .willReturn(list(
                        new ShortURL(first, "https://google.com"),
                        new ShortURL(second, "https://yahoo.com")));

        List<String> titles = service.findShortsWithClicksLessOrEqualsThan(clicks);

        assertThat(titles).containsExactly(first, second);
    }

}
