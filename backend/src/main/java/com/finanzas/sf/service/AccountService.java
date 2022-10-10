package com.finanzas.sf.service;


import java.util.List;

import com.finanzas.sf.dto.AccountDTO;
import com.finanzas.sf.dto.DeleteAccountRequestDTO;
import com.finanzas.sf.dto.SaveAccountRequestDTO;

public interface AccountService {
    List<AccountDTO> getListAccounts(Long idUser);
    void saveAccount(SaveAccountRequestDTO saveAccountRequestDTO);
    void deleteAccount(DeleteAccountRequestDTO deleteAccountRequestDTO);
}
