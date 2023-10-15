package com.example.wallet.repository;

import com.example.wallet.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankAccountRepos extends JpaRepository<BankAccount,Integer> {
    @Query(value = "FROM BankAccount b INNER JOIN b.wallet w WHERE w.walletId=?1")
	public List<BankAccount>  findByWallet(Integer walletId);
	
	@Query(value = "FROM BankAccount b INNER JOIN b.wallet w WHERE w.walletId=?1")
	public List<BankAccount> findAllByWallet(Integer walletId);
}