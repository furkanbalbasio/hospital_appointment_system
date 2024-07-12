package org.has.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.has.utility.enums.State;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tbl_auth")
public class Auth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
    @Column(unique = true,length = 64, nullable = false)
   private String tcNumber;
    @Column(nullable = false,length = 128)
    private String password;
    private String name;
    private String surname;
    private String phone;
    private String email;
}
