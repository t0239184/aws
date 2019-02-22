package app.anc.aws.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    /**
     * 唯一值
     */
    private String id;
    /**
     * 權限
     */
    private String role;
}
