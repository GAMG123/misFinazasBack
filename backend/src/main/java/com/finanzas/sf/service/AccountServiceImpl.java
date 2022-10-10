package com.finanzas.sf.service;

import com.finanzas.sf.constants.Constants;
import com.finanzas.sf.dto.AccountDTO;
import com.finanzas.sf.dto.CategoryDTO;
import com.finanzas.sf.dto.DeleteAccountRequestDTO;
import com.finanzas.sf.dto.SaveAccountRequestDTO;
import com.finanzas.sf.errorhandler.GenericClientException;
import com.finanzas.sf.errorhandler.GenericServerException;
import com.finanzas.sf.model.Category;
import com.finanzas.sf.model.User;
import com.finanzas.sf.model.Account;
import com.finanzas.sf.repository.AccountRepository;
import com.finanzas.sf.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements  AccountService{
    final AccountRepository accountRepository;
    final UserRepository userRepository;
    @Override
    public List<AccountDTO> getListAccounts(Long idUser) {
    	User user =userRepository.findUserByIdUserAndState(idUser, Constants.RESOURCE_ACTIVE).orElseThrow(() ->
        new GenericServerException("Error not Found User"));
        List<Account> listAccount=accountRepository.findAccountByUserAndState(user, Constants.RESOURCE_ACTIVE);
        if(!listAccount.isEmpty()){
            List<AccountDTO> listAccountDto=new ArrayList<>();
            listAccount.forEach(accountEntity->{
            	AccountDTO accountDTO =new AccountDTO() ;
            	accountDTO.setIdAccount(accountEntity.getIdAccount());
            	accountDTO.setNameAccount(accountEntity.getNameAccount());
                listAccountDto.add(accountDTO);
            });
            return listAccountDto;
        }else {
            throw new GenericClientException("No se tiene roles registrados", HttpStatus.NOT_FOUND);
        }
    }
	@Override
	public void saveAccount(SaveAccountRequestDTO saveAccountRequestDTO) {
		Account account = new Account();
		account.setNameAccount(saveAccountRequestDTO.getNameAccount());
		account.setDescriptionAccount(saveAccountRequestDTO.getDescriptionAccount());
		account.setState(Constants.RESOURCE_ACTIVE);
		account.setRegistrationDate(new Date());
		accountRepository.save(account);
		
	}
	@Override
	public void deleteAccount(DeleteAccountRequestDTO deleteAccountRequestDTO) {
		Account account = accountRepository.findAccountByIdAccountAndState(deleteAccountRequestDTO.getIdAccount(), Constants.RESOURCE_ACTIVE).orElseThrow(() ->
        new GenericServerException("Error not Found account"));
		accountRepository.delete(account);
	}
}
