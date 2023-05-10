package edu.estu.webserver.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "admins")
@PrimaryKeyJoinColumn(name = "admin_id", referencedColumnName = "id")
public class Admin extends User {
}
