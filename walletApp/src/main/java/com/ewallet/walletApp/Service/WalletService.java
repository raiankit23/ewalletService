package com.ewallet.walletApp.Service;


import com.ewallet.walletApp.entity.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ewallet.walletApp.Repository.WalletRepository;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;
    public Wallet createOrUpdate(Wallet wallet){
        if(wallet.getId() == null){
            walletRepository.save(wallet);
        }
        else{
            walletRepository.save(wallet);
        }
        return wallet;
    }
}
