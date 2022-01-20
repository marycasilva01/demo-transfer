package com.br.demo.transfer.dataprovider.model;

import com.br.demo.transfer.dataprovider.model.enums.TransferType;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Data
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transfer")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "fee_amount")
    private BigDecimal feeAmount;

    @Column(columnDefinition = "DATE", name = "created_at")
    private LocalDate createdAt;

    @Column(columnDefinition = "DATE", name = "transfer_at")
    private LocalDate transferAt;

    @Column(name = "origin_account")
    private String origin;

    @Column(name = "destination_account")
    private String destination;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private TransferType type;
}
