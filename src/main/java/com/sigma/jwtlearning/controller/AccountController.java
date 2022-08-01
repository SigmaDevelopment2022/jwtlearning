package com.sigma.jwtlearning.controller;

import com.sigma.jwtlearning.domain.Account;
import com.sigma.jwtlearning.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("accounts")
public class AccountController {
    private final AccountService accountService;

    @PostMapping("insert")
    public ResponseEntity<Boolean> insert(@RequestBody Account account) {
        return new ResponseEntity<>(accountService.insert(account), HttpStatus.CREATED);
    }

    @GetMapping("account")
    public ResponseEntity<Account> findUsingEmail(@RequestParam String email) {
        return ResponseEntity.ok(accountService.findUsingEmail(email));
    }

    @GetMapping("list")
    public ResponseEntity<List<Account>> list() {
        return ResponseEntity.ok(accountService.list());
    }
}
