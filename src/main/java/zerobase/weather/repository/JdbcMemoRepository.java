package zerobase.weather.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import zerobase.weather.domain.Memo;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcMemoRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcMemoRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Memo save(Memo memo) {
        String sql = "insert into memo values(?, ?)";
        jdbcTemplate.update(sql, memo.getId(), memo.getText());
        return memo;
    }

    public List<Memo> findAll() {
        String sql = "select * from memo";
        return jdbcTemplate.query(sql, memoRowMapper());
    }

    public Optional<Memo> findById(int id) {
        String sql = "select * from memo where id = ?";

        // id가 중복이 되지 않는 것은 개발자가 알지만 springboot는 몰라서 List형식으로 return됨
        // 그래서 리스트 형식의 가장 첫번째 값을 return하겠다고 함
        // 결과가 없을 수도 있어서 Optional을 사용하여 null 처리 쉽게 설정
        return jdbcTemplate.query(sql, memoRowMapper(), id).stream().findFirst();

    }

    private RowMapper<Memo> memoRowMapper() {

        // jdbc를 통해 데이터를 가져오면 그 데이터 타입은 ResultSet
        // ResultSet의 형태는 {id = 1, text = "~~~"}
        // 해당 ResultSet을 Memo 클래스에 매핑(값을 매칭시킴)해주는 것이 RowMapper

        // rs : ResultSet
        return (rs, rowNum) -> new Memo(rs.getInt("id"), rs.getString("text"));
    }
}
