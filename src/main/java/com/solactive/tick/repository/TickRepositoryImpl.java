package com.solactive.tick.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.solactive.tick.dto.TickDTO;

/**
 * Java Source TickRepositoryImpl.java created on Oct 16, 2021
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

public class TickRepositoryImpl implements TickRepository {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final List<TickDTO> db = new ArrayList<>();

    /**
     * @param tickDTO
     */
    @Override
    public void add(TickDTO tickDTO) {
        db.add(tickDTO);
        log.info("tick data saved, db count: {}", db.size());
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.solactive.tick.repository.TickRepository#findTickByRicCode(java.lang.
     * String)
     */
    @Override
    public List<TickDTO> findTickByRicCode(String ricCode) {
        final List<TickDTO> matchedTicks = db.stream().filter(t -> t.getRicCode().equals(ricCode))
                .collect(Collectors.toList());
        return matchedTicks;
    }

    /**
     * @return
     */
    @Override
    public List<TickDTO> getAllTicks() {
        return db; // I can return clone of list as defensive coding but keeping
                   // it simple for now
    }
}
