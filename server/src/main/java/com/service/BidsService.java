package com.service;

import com.entity.Bids;
import com.entity.Projects;
import com.repository.BidsRepository;

import java.util.List;

public class BidsService {
    private BidsRepository  bidsrepository;

    public static List<Projects> postbid(String projectname, String bid, String period) {
        return null;
    }

    public void postbid(Bids projectname, Bids bids, Bids period){
        bidsrepository.save(projectname, bids, period);
    }
}
