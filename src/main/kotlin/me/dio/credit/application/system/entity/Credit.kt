package me.dio.credit.application.system.entity

import jakarta.persistence.*
import me.dio.credit.application.system.enumeration.Status
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

@Entity
@Table(name = "Credito")
class Credit {
    @Column(nullable = false, unique = true) val creditCode: UUID = UUID.randomUUID();
    @Column(nullable = false) val creditValue: BigDecimal = BigDecimal.ZERO;
    @Column(nullable = false) val dayFirstInstallment: LocalDate = LocalDate.EPOCH;
    @Column(nullable = false) val numberOfInstallments: Int = 0;
    @Enumerated val status: Status = Status.IN_PROGRES;
    @ManyToOne val customer: Customer? = null;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null
}
