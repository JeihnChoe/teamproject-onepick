package shop.mtcoding.teamprojectonepick.tech;

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

    String techname;

    @Builder
    public Tech(Integer id, String techname) {
        this.id = id;
        this.techname = techname;
    }
}
