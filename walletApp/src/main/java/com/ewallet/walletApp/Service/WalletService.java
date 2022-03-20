package com.ewallet.walletApp.Service;


import com.ewallet.walletApp.entity.Wallet;
import com.ewallet.walletApp.exception.WalletException;
import org.apache.logging.log4j.message.LoggerNameAwareMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ewallet.walletApp.Repository.WalletRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    public List<Wallet> getAll(){
        return walletRepository.findAllByOrderByPriority() ;
    }

    public Wallet getById(Long id){
        Optional<Wallet> wallet = walletRepository.findById(id);
        if(wallet.isPresent()){
            return wallet.get();
        }
        throw new WalletException("Wallet with "+id+" does not Exist");
    }

    public Wallet createOrUpdate(Wallet wallet){
        if(wallet.getId() == null){
            walletRepository.save(wallet);
        }
        else{
            walletRepository.save(wallet);
        }
        return wallet;
    }

    public boolean delete(Long id){
        Optional<Wallet> wallet = walletRepository.findById(id);
        if(wallet.isPresent()){
            walletRepository.delete(wallet.get());
            return true;
        }
        throw new WalletException("Wallet with "+id+" does not Exist");
    }
}
