package com.solactive.tick.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.solactive.tick.dto.TickDTO;
import com.solactive.tick.repository.TickRepository;
import com.solactive.tick.repository.TickRepositoryImpl;

/**
 * Java Source TickConsumerServiceImpl.java created on Oct 16, 2021
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

public class TickServiceImpl implements TickService {

    private final TickRepository tickRepo = new TickRepositoryImpl();
    private final TickExportService tickExportService = new TickExportServiceImpl();
    private final List<String> exportedCsvFilePaths = new ArrayList<>();

    /*
     * (non-Javadoc)
     *
     * @see
     * com.solactive.tick.service.TickConsumerService#consume(java.lang.String)
     */
    @Override
    public TickDTO consume(String tickValue) {

        final String[] keys = tickValue.split("\\|");

        final TickDTO tick = new TickDTO();
        tick.setTimeStamp(TickService.getValue(keys[0]));
        tick.setPrice(TickService.getValue(keys[1]));
        tick.setClosePrice(TickService.getValue(keys[2]));
        tick.setCurrency(TickService.getValue(keys[3]));
        tick.setRicCode(TickService.getValue(keys[4]));
        tickRepo.add(tick);

        if (!tick.getClosePrice().isEmpty()) {
            exportedCsvFilePaths.add(tickExportService.exportAsCSV(tickRepo.getAllTicks()));
        }

        return tick;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.solactive.tick.service.TickService#findTickByRicCode(java.lang.
     * String)
     */
    @Override
    public List<TickDTO> findTickByRicCode(String ricCode) {
        if (Objects.isNull(ricCode)) {
            throw new IllegalArgumentException("ric code cannot be empty");
        }
        return tickRepo.findTickByRicCode(ricCode);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.solactive.tick.service.TickService#exportedCSVFilePaths()
     */
    @Override
    public List<String> getAllExportedCsvFilePaths() {
        return exportedCsvFilePaths;
    }

}
