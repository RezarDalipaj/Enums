package com.example.enumtest.model.entity;

import com.example.enumtest.model.enums.Status;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "status=0")
@SQLDelete(sql = "UPDATE user_entity SET status = 2 WHERE id=?")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Integer id;
    @Column(unique = true)
    private String userName;
    @Column
    private String password;
    @Enumerated(EnumType.ORDINAL)
    private Status status;
}
