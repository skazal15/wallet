package com.example.wallet.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.wallet.exception.BeneficiaryException;
import com.example.wallet.exception.CustomerException;
import com.example.wallet.exception.WalletException;
import com.example.wallet.model.Beneficiary;
import com.example.wallet.model.dto.BeneficiaryDTO;
import com.example.wallet.service.BeneficiaryService;

@RestController
@RequestMapping("/beneficiaries")
public class BeneficiaryController {
    
   @Autowired
   BeneficiaryService beneficiaryService;


   /*--------------------------------------------   Add Beneficiary Mapping -------------------------------------------------*/
   @PostMapping("/add")
   public ResponseEntity<Beneficiary> addBeneneficiaryMapping(@RequestBody Beneficiary beneficiary, @RequestParam String key) throws BeneficiaryException, WalletException, CustomerException {
      
      return new ResponseEntity<Beneficiary>(beneficiaryService.addBeneficiary(beneficiary, key),HttpStatus.ACCEPTED);
         
   }


   /*--------------------------------------------   View Beneficiary - walletId -------------------------------------------------*/
   @GetMapping("/view/walletId")
   public ResponseEntity<Beneficiary> getBeneneficiaryByWalletIdMapping(@RequestParam Integer walletId ,@RequestParam String key) throws BeneficiaryException, CustomerException{

      return new ResponseEntity<Beneficiary>((Beneficiary) beneficiaryService.findAllByWallet(walletId),HttpStatus.FOUND);

   }


   /*--------------------------------------------   View Beneficiary - Name -------------------------------------------------*/
   @GetMapping("/view/name")
   public ResponseEntity<Beneficiary> getBeneneficiaryByNameMapping(@RequestParam String name,@RequestParam String key) throws BeneficiaryException, CustomerException{

      return new ResponseEntity<Beneficiary>(beneficiaryService.viewBeneficiary(name,key),HttpStatus.FOUND);

   }


   /*--------------------------------------------   View All Beneficiary Mapping -------------------------------------------------*/
   @GetMapping("/viewall")
   public ResponseEntity<List<Beneficiary>> getAllBeneneficiaryMapping(@RequestParam String key) throws BeneficiaryException, CustomerException{

      return new ResponseEntity<List<Beneficiary>>(beneficiaryService.viewAllBeneficiary(key),HttpStatus.FOUND);

   }


   /*--------------------------------------------   Delete Beneficiary Mapping -------------------------------------------------*/
   @DeleteMapping("/delete")
   public ResponseEntity<Beneficiary> deleteBeneneficiaryMapping(@Valid @RequestBody BeneficiaryDTO beneficiary ,@RequestParam String key) throws BeneficiaryException, CustomerException{
      
      return new ResponseEntity<Beneficiary>(beneficiaryService.deleteBeneficiary(key,beneficiary),HttpStatus.OK);
      
   }
   
}