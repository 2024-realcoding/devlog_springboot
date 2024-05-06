import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@Entity(name = "projects")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String title;
    String summary;
    String contents;
    LocalDate startDate;
    LocalDate endDate;
    private Integer id;
    private String title;
    private String summary;
    private String contents;
    private LocalDate startDate;
    private LocalDate endDate;

    public void update(
            String title,
            String summary,
            String contents,
            LocalDate startDate,
            LocalDate endDate
    ) {
        this.title = title;
        this.summary = summary;
        this.contents = contents;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}