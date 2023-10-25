package zerobase.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Diary;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Integer> {
    // select * from diary where date = ? 처럼 진행
    List<Diary> findAllByDate(LocalDate date);
    List<Diary> findAllByDateBetween(LocalDate startDate, LocalDate endDate);

    // select * from diary where date = ? limit = 1 처럼 진행(맨 처음 1개만 가져옴)
    Diary getFirstByDate(LocalDate date);

    // deleteAllByDate만 적으면 부족함
    // @Transactional을 붙여야 제대로 작동함
    @Transactional
    void deleteAllByDate(LocalDate date);

}
