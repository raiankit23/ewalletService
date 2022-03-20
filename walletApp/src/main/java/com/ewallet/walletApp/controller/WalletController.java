package com.ewallet.walletApp.controller;


import com.ewallet.walletApp.Service.ValidationErrorService;
import com.ewallet.walletApp.Service.WalletService;
import com.ewallet.walletApp.entity.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @Autowired
    private ValidationErrorService validationService;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Wallet wallet, BindingResult result){
            ResponseEntity errors = validationService.validate(result);
            if(errors != null) return errors;
            Wallet walletSaved = walletService.createOrUpdate(wallet);
            return new ResponseEntity<Wallet>(walletSaved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,  @Valid @RequestBody Wallet wallet, BindingResult result){
        ResponseEntity errors = validationService.validate(result);
        if(errors != null) return errors;
        wallet.setId(id);
        Wallet walletSaved = walletService.createOrUpdate(wallet);
        return new ResponseEntity<Wallet>(walletSaved, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(walletService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return new ResponseEntity<>(walletService.getById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        walletService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
