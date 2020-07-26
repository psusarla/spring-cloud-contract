package com.phani.spring.cloudcontracts;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@AutoConfigureStubRunner(
        stubsMode = StubRunnerProperties.StubsMode.LOCAL,
        ids = "com.phani.spring:server:+:stubs:8090")
public class BooksControllerIntegrationTests {

    @Autowired
    private BooksClient booksClient;

    @Test
    public void getReturnsAbook() throws Exception {
        Book book = booksClient.getBook(1);
        assertThat(book).isNotNull();
        assertThat(book.getId()).isEqualTo(1);
        assertThat(book.getAuthor()).isNotEmpty();
        assertThat(book.getName()).isNotEmpty();
    }

    @Test
    public void postCreatesBook() {
      Book bookReq =   Book.builder()
                .name("Twilight")
                .author("Stephenie Meyer").build();

      Book bookRes = booksClient.createBook(bookReq);
      assertThat(bookReq.getName()).isEqualTo(bookRes.getName());
    }
}
