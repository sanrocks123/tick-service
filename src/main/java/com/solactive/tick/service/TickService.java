package com.solactive.tick.service;

import java.util.List;

import com.solactive.tick.dto.TickDTO;

/**
 * Java Source TickService.java created on Oct 16, 2021
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

public interface TickService {

    /**
     * @param line
     * @return
     */
    static String getValue(String line) {
        final String[] temp = line.split("=");
        return temp.length == 1 ? "" : temp[1];

    }

    /**
     * consumer API to handle incoming ticks, transform data and save it
     *
     * @param tick
     * @return
     */
    TickDTO consume(String tick);

    /**
     *
     * API to find tick by ric code
     *
     * @param ricCode
     * @return
     */
    List<TickDTO> findTickByRicCode(String ricCode);

    /**
     * API to list all csv exported file paths
     *
     * @return
     */
    List<String> getAllExportedCsvFilePaths();

}
