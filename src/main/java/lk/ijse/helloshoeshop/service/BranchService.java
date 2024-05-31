package lk.ijse.helloshoeshop.service;

import lk.ijse.helloshoeshop.dto.BranchDTO;
import lk.ijse.helloshoeshop.exeption.InvalidException;

public interface BranchService {
    void saveBranch(BranchDTO branchDTO) throws InvalidException;
}
