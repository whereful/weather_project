package zerobase.weather.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Memo;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest // 스프링부트를 이용하여 테스트가 진행된다
@Transactional  // 테스트를 할 때 실제 db의 정보가 변경되면 안되기 때문에 작성
class JdbcMemoRepositoryTest {

    // 스프링부트에서 실제 생성되는 JdbcMemoRepository 객체를 해당 변수에 담음
    @Autowired
    JdbcMemoRepository jdbcMemoRepository;

    @Test
    void insertMemoTest() {

        // given
        Memo memo = new Memo(2, "bbb");

        // when
        jdbcMemoRepository.save(memo);

        // then
        Optional<Memo> result = jdbcMemoRepository.findById(2);
        assertEquals(result.get().getText(), "bbb");

    }

    @Test
    void findAllMemoTest() {

        // given
        List<Memo> memoList = jdbcMemoRepository.findAll();
        System.out.println(memoList);
        assertNotNull(memoList);

        // when


        // then

    }
}