package com.ewallet.walletApp.Repository;


import com.ewallet.walletApp.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
List<Wallet> findAllByOrderByPriority();
}
