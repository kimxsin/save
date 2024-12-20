package com.ohgiraffers.semiproject.employee.model.dto;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "tbl_comment")
public class CommentDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "emp_code")
    private Integer empCode;

    @Column(name = "comment_contents")
    private String text;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "comment_emp_code")
    private String commentEmpCode;
}