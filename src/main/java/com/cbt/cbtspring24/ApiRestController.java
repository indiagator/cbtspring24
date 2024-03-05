package com.cbt.cbtspring24;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2")
public class ApiRestController {


    BCryptPasswordEncoder encoder;

    CredentialRepository credentialRepository;
    UserdetailRepository userdetailRepository;

    UsertypelinkRepository usertypelinkRepository;

    WalletRepository walletRepository;

    UsernamewalletlinkRepository usernamewalletlinkRepository;

    ApiRestController( CredentialRepository credentialRepository,
                       UserdetailRepository userdetailRepository,
                       UsertypelinkRepository usertypelinkRepository,
                       UsernamewalletlinkRepository usernamewalletlinkRepository,
                       WalletRepository walletRepository,
                       BCryptPasswordEncoder encoder)
    {
        this.credentialRepository = credentialRepository;
        this.userdetailRepository = userdetailRepository;
        this.usertypelinkRepository = usertypelinkRepository;
        this.usernamewalletlinkRepository = usernamewalletlinkRepository;
        this.walletRepository = walletRepository;
        this.encoder = encoder;
    }

    @PostMapping("signup")
    public ResponseEntity<String> signup(@RequestBody Credential credential)
    {
        credential.setPassword(encoder.encode(credential.getPassword()));
        credentialRepository.save(credential);
        return ResponseEntity.ok("NEW SIGNUP SUCESSFULL WITH USERNAME :"+credential.getUsername());

    }

    @PostMapping("save/user/details")
    public ResponseEntity<Userdetail> saveUserDetails(@RequestBody Userdetail userdetail)
    {
        userdetailRepository.save(userdetail);

        Wallet wallet = new Wallet();
        wallet.setWalletid(String.valueOf((int)(Math.random()*100000)));
        wallet.setBalance(5000000);
        walletRepository.save(wallet);

        Usernamewalletlink usernamewalletlink = new Usernamewalletlink();
        usernamewalletlink.setUsername(userdetail.getUsername());
        usernamewalletlink.setWalletid(wallet.getWalletid());
        usernamewalletlinkRepository.save(usernamewalletlink);

        return ResponseEntity.ok(userdetail);
    }

    @PostMapping("save/user/type")
    public ResponseEntity<String> saveUserType( @RequestBody Usertypelink usertypelink)
    {
        usertypelink.setLinkid(String.valueOf((int)(Math.random()*100000)));
        usertypelinkRepository.save(usertypelink);
        return ResponseEntity.ok("New "+usertypelink.getType()+" registered");
    }

    @GetMapping("get/user/details/{username}")
    public ResponseEntity<UserdetailView> getUserDetails(@PathVariable String username)
    {
        UserdetailView view = userdetailRepository.findViewByUsername(username);

        return ResponseEntity.ok(view);
    }

}
