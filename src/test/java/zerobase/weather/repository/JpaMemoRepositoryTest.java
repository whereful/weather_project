package zerobase.weather.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Memo;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class JpaMemoRepositoryTest {

    @Autowired
    JpaMemoRepository jpaMemoRepository;

    @Test
    void insertMemoTest() {

        // given
        Memo memo = new Memo(10, "kkk");

        // when
        jpaMemoRepository.save(memo);

        // then
        List<Memo> memoList =  jpaMemoRepository.findAll();

        assertTrue(memoList.size() > 0);

    }

    @Test
    void findByIdTest() {

        // given

        // 여기서 id를 지정했으나 db에 저장될 때 auto_increment로 지정하여서 11로 저장되지 않을 수 있음
        Memo newMemo = new Memo(11, "fff");

        // when
        Memo memo = jpaMemoRepository.save(newMemo);
        System.out.println(memo.getId());

        // then
        Optional<Memo> result = jpaMemoRepository.findById(memo.getId());

         assertEquals(result.get().getText(), "fff");
    }

}