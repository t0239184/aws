package app.anc.aws.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    /**
     * 唯一值
     */
    private int id;
    /**
     * 使用者代碼
     */
    @NotEmpty(message="ID為必填項目！")
    private String userId;
    /**
     * 密碼
     */
    @Size(min=6,max=10,message = "密碼長度必須6到10位")
    private String password;
    /**
     * 使用者名稱
     */
    private String userName;
    /**
     * 電子信箱
     */
    private String email;
    /**
     * 是否有效
     */
    private String active;
    /**
     * 權限表
     */
    private Set<Role> roles;
}
