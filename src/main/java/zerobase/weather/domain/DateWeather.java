package zerobase.weather.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "date_weather")
public class DateWeather {
    @Id // 해당 변수값은 db에 존재하는 테이블의 id값과 일치되게 함
    private LocalDate date;
    private String weather;
    private String icon;
    private double temperature;
}
