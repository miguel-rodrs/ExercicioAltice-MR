package com.mr.quarkuslabseq.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import java.math.BigInteger;

import com.mr.quarkuslabseq.labseq.LabSeq;

import java.util.HashMap;

@Path("/labseq/{n}")
public class Api {
    LabSeq labSeq = new LabSeq();
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response get_labseq(@PathParam("n") Integer n) {
        if(n<0 || n>99999) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Parameter must be greater or equal to 0 and lower than 100000.")
                    .build();
        }
        BigInteger res = this.labSeq.calculate(n);;
        return Response.ok(res).build();
    }
}
