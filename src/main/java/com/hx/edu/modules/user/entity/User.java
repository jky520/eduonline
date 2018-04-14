package com.hx.edu.modules.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Created by DT人 on 2018/4/10 22:19.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
/*@Entity
@Table(name = "t_user")*/
public class User {
    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)*/
    private Integer id;
    /*@Column(nullable = false)*/
    private String username;
   /* @Column(nullable = false)*/
    private String password;
    /*@Column(nullable = false)*/
    private String description;
}
