package com.vbelova.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class ElectionServiceImpl implements ElectionService {

    private static final Logger log = LoggerFactory.getLogger(ElectionServiceImpl.class);
    private static final List<String> CANDIDATE_NAMES = asList(
            "Le Pen",
            "Marcon"
    );

    private final Map<String, Integer> voteResults = new HashMap<>();

    @Override
    public int vote(String name) {
        if (!CANDIDATE_NAMES.contains(name)) {
            throw new IllegalArgumentException("Candidate doesn't exist: " + name);
        }
        Integer voteNumber = voteResults.get(name);
        if (voteNumber == null) {
            voteNumber = 0;
        }
        voteNumber++;
        voteResults.put(name, voteNumber);
        log.info("Voted for {}", name);
        return voteNumber;
    }

}
