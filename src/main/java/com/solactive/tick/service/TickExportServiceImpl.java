package com.solactive.tick.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.solactive.tick.dto.TickDTO;

/**
 * Java Source TickExportServiceImpl.java created on Oct 16, 2021
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

public class TickExportServiceImpl implements TickExportService {

    private static final String COMMA = ",";
    private final Logger log = LoggerFactory.getLogger(getClass());

    /*
     * (non-Javadoc)
     *
     * @see
     * com.solactive.tick.service.TickExportService#exportAsCSV(java.util.List,
     * java.lang.String)
     */
    @Override
    public String exportAsCSV(List<TickDTO> tickList) {

        final StringBuilder sb = new StringBuilder();
        sb.append("timestamp,price,closePrice,currency,ric").append("\n");

        for (final TickDTO t : tickList) {
            sb.append(t.getTimeStamp()).append(COMMA).append(t.getPrice()).append(COMMA).append(t.getClosePrice())
                    .append(COMMA).append(t.getCurrency()).append(COMMA).append(t.getRicCode()).append("\n");
        }
        log.info("exportAsCSV, content: \n\n{}", sb.toString());

        String filePath = "";
        try {
            final File output = File.createTempFile("export-tick", ".csv");
            final FileWriter writer = new FileWriter(output);
            writer.write(sb.toString());
            writer.close();

            log.info("tick exported, file: {}", output.getAbsolutePath());
            filePath = output.getAbsolutePath();
        }
        catch (final IOException ex) {
            log.error("export csv error", ex);
        }
        return filePath;
    }

}
