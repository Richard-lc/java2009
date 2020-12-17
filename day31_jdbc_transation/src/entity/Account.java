package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Richard
 * 2020/12/15 15:29
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private Integer id;
    private String name;
    private String password;
    private Double balance;
}
