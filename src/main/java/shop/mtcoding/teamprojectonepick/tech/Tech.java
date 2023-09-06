package shop.mtcoding.teamprojectonepick.tech;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Table(name = "tech_tb")
@Entity
public class Tech {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false, length = 10000)
    String techname;

    @Builder
    public Tech(Integer id, String techname) {
        this.id = id;
        this.techname = techname;
    }
}