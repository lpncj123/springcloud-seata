package cn.lp.springdubboorder.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lp
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    public User(String userName, String userTelephone, Integer userAge) {
        this.userName = userName;
        this.userTelephone = userTelephone;
        this.userAge = userAge;
    }
    private Integer userId;
    private String userName;
    private String userTelephone;
    private Integer userAge;
}
