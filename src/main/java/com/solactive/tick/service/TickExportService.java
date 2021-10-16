package com.solactive.tick.service;

import java.util.List;

import com.solactive.tick.dto.TickDTO;

/**
 * Java Source TickExportService.java created on Oct 16, 2021
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

public interface TickExportService {

    /**
     *
     * @param tickList
     */
    public String exportAsCSV(List<TickDTO> tickList);

}
