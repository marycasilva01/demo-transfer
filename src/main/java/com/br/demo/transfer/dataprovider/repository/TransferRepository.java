package com.br.demo.transfer.dataprovider.repository;

import com.br.demo.transfer.dataprovider.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {
}
