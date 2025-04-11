package kafka.example.kafka.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "message_entity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country_code", length = 5)
    private String countryCode;

    @Column(name = "phone", length = 15, nullable = false)
    private String phone;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "gender", length = 10)
    private String gender;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "anniversary_date")
    private LocalDate anniversaryDate;

    @Column(name = "user_last_login_date")
    private LocalDate userLastLoginDate;

    @Column(name = "user_signup_date")
    private LocalDate userSignupDate;

    @Column(name = "status", length = 20)
    private String status;

    @Column(name = "msg_sms")
    private Boolean msgSms;

    @Column(name = "msg_whatsapp")
    private Boolean msgWhatsapp;

    @Column(name = "msg_email")
    private Boolean msgEmail;

    @Column(name = "msg_push")
    private Boolean msgPush;

    @Column(name = "order_count")
    private Integer orderCount;

    @Column(name = "total_grand_total", precision = 10, scale = 2)
    private BigDecimal totalGrandTotal;
}
