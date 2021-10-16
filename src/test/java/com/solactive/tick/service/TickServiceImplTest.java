package com.solactive.tick.service;

import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.solactive.tick.dto.TickDTO;

/**
 * Java Source TickServiceImplTest.java created on Oct 16, 2021
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

public class TickServiceImplTest {

    private final Logger log = LoggerFactory.getLogger(getClass());
    final TickService consumerService = new TickServiceImpl();

    /**
     *
     */
    public TickServiceImplTest() {
        BasicConfigurator.configure();
    }

    @Test
    public void testConsume() {

        final TickDTO tick = consumerService
                .consume("TIMESTAMP=1454000043|PRICE=5.24|CLOSE_PRICE=|CURRENCY=EUR|RIC=AAPL.OQ");

        log.info("tick: {}", tick);

        Assert.assertEquals("", tick.getClosePrice());
    }

    @Test
    public void testExportCsv() {
        consumerService.consume("TIMESTAMP=1454000043|PRICE=5.24|CLOSE_PRICE=3.45|CURRENCY=EUR|RIC=AAPL.OQ");
        consumerService.consume("TIMESTAMP=1454000043|PRICE=4.98|CLOSE_PRICE=|CURRENCY=EUR|RIC=IBM.N");
        consumerService.consume("TIMESTAMP=1454000043|PRICE=7.44|CLOSE_PRICE=2.25|CURRENCY=EUR|RIC=GOOGL.AB");

        log.info("exported file paths: count: {}, paths: {}", consumerService.getAllExportedCsvFilePaths().size(),
                consumerService.getAllExportedCsvFilePaths());

        Assert.assertEquals(2, consumerService.getAllExportedCsvFilePaths().size());
    }

    @Test
    public void testFindTickByRicCode() {
        consumerService.consume("TIMESTAMP=1454000043|PRICE=5.24|CLOSE_PRICE=|CURRENCY=EUR|RIC=AAPL.OQ");
        final List<TickDTO> result = consumerService.findTickByRicCode("AAPL.OQ");
        Assert.assertTrue(result.size() == 1);
    }

}
