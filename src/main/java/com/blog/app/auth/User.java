package com.blog.app.auth;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;

    @NotEmpty
    @Size(min = 2 , message = "User show havw at least 2 cha")
    private String name;

    @Email
    private String email;

    @NotEmpty
    @Size(min = 10 , message = "User phone at least 10 number")
    private String phone;

    @NotEmpty(message = "Password must be 5 Char")
    private String password;

    @NotEmpty
    private String conPassword;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
