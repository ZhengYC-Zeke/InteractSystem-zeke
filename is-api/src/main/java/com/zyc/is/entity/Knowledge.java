package com.zyc.is.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @ProjectName: InteractSystem
 * @Package com.zyc.is.entity
 * @Description: 知识点实体类
 * @author: Zeke
 * @date: 2020/3/1 17:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "knowledge")
public class Knowledge {

    @Id
    //知识点id
    private String id;
    //知识点名称
    private String name;
    @Column(name = "projectId")
    //所属课程id
    private String projectId;

}
