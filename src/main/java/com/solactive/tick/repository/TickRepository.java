package com.solactive.tick.repository;

import java.util.List;

import com.solactive.tick.dto.TickDTO;

/**
 * Java Source TickRepository.java created on Oct 16, 2021
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

public interface TickRepository {

    /**
     *
     * @param tickDTO
     */
    public void add(TickDTO tickDTO);

    /**
     *
     * @param ricCode
     * @return
     */
    public List<TickDTO> findTickByRicCode(String ricCode);

    /**
     *
     * @return
     */
    public List<TickDTO> getAllTicks();
}
