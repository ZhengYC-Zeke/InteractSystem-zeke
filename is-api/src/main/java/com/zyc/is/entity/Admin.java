package com.zyc.is.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @ProjectName: InteractSystem
 * @Package com.zyc.is.entity
 * @Description: 管理员
 * @author: Zeke
 * @date: 2020/3/1 13:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "admin")
public class Admin implements Serializable {

    @Id
    private String id;
    private String username;
    private String password;

}
