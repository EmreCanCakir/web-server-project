package edu.estu.webserver.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "admins")
@PrimaryKeyJoinColumn(name = "admin_id", referencedColumnName = "id")
public class Admin extends User {
}
