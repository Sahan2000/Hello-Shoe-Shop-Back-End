package lk.ijse.helloshoeshop.service;

import lk.ijse.helloshoeshop.dto.BranchDTO;
import lk.ijse.helloshoeshop.exeption.InvalidException;

import java.util.List;

public interface BranchService {
    void saveBranch(BranchDTO branchDTO) throws InvalidException;
    List<BranchDTO> getAllBranches();
}
