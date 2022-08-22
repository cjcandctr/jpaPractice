package leon.jpa.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@AttributeOverrides({
        @AttributeOverride(
                name="name",
                column = @Column(name="guardian_name")
        ),
        @AttributeOverride(
                name="phone",
                column  = @Column(name="guardian_phone")
        ),
        @AttributeOverride(
                name="email",
                column  = @Column(name="guardian_email")
        )
})
public class Guardian {

    protected String name;
    protected String phone;
    protected String email;
}
